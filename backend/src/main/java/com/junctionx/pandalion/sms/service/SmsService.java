package com.junctionx.pandalion.sms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.junctionx.pandalion.sms.api.InitService;
import com.junctionx.pandalion.sms.dto.request.MessagesRequestDto;
import com.junctionx.pandalion.sms.dto.request.SmsRequestDto;
import com.junctionx.pandalion.sms.dto.response.SmsResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static com.junctionx.pandalion.util.ApiRequestUtil.*;
import static org.springframework.http.HttpMethod.*;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:ncp.properties")
@Getter
public class SmsService {

    private final InitService initService;

    @Value("${api.accessKey}")
    private String access;

    @Value("${sms.sendFrom}")
    private String sendFrom;

    @Value("${sms.serviceId}")
    private String serviceId;

    private final String BASE_URL = "https://sens.apigw.ntruss.com";

    private final String BASE_SMS_URL = "/sms/v2/services/";

    private final String SEND_SMS_URL = "/messages";

    /**
     * @param recipientPhoneNumber : recipient's phone number
     * @param content : message content
     * @return : ResponseEntity<SmsResponseDto>
     */
    public ResponseEntity<SmsResponseDto> sendSms(String recipientPhoneNumber, String content)
            throws JsonProcessingException, NoSuchAlgorithmException, InvalidKeyException, URISyntaxException {
        SmsRequestDto smsRequestDto = createSmsRequest(recipientPhoneNumber, content);
        return sendRequest(smsRequestToJson(smsRequestDto),
                BASE_URL + BASE_SMS_URL + serviceId + SEND_SMS_URL,
                POST,
                SmsResponseDto.class);
    }

    private HttpEntity<String> smsRequestToJson(SmsRequestDto smsRequestDto)
            throws JsonProcessingException, NoSuchAlgorithmException, InvalidKeyException {
        String jsonBody = getHttpBody(smsRequestDto);
        HttpHeaders headers = getHttpHeader();
        return new HttpEntity<>(jsonBody, headers);
    }

    private SmsRequestDto createSmsRequest(String recipientPhoneNumber, String content) {
        List<MessagesRequestDto> messages = new ArrayList<>();
        messages.add(new MessagesRequestDto(recipientPhoneNumber, content));
        return new SmsRequestDto("SMS", "COMM", "82", sendFrom," ", messages);
    }

    private SmsRequestDto createSmsRequest(String recipientPhoneNumber, String content, String countryCode) {
        List<MessagesRequestDto> messages = new ArrayList<>();
        messages.add(new MessagesRequestDto(recipientPhoneNumber, content));
        return new SmsRequestDto("SMS", "COMM", countryCode, sendFrom," ", messages);
    }

    private HttpHeaders getHttpHeader()
            throws InvalidKeyException, NoSuchAlgorithmException {
        String time = Long.toString(System.currentTimeMillis());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-ncp-apigw-timestamp", time);
        headers.set("x-ncp-iam-access-key", access);

        String sig = initService.makeSignature(time,"POST", BASE_SMS_URL + serviceId + SEND_SMS_URL);
        headers.set("x-ncp-apigw-signature-v2", sig);
        return headers;
    }

    private String getHttpBody(SmsRequestDto smsRequestDto)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(smsRequestDto);
    }
}
