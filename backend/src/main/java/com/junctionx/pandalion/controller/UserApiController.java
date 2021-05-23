package com.junctionx.pandalion.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.junctionx.pandalion.domain.User;
import com.junctionx.pandalion.repository.UserRepository;
import com.junctionx.pandalion.sms.dto.response.SmsResponseDto;
import com.junctionx.pandalion.sms.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final SmsService smsService;

    private final UserRepository userRepository;

    @GetMapping("/send/{id}")
    public ResponseEntity<SmsResponseDto> sendSms(@PathVariable("id") UUID id) throws URISyntaxException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {

        User user = userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("User doesn't exist"));
        return smsService.sendSms(user.getPhoneNumber(), user.getUsername() + "'s chatting room code : " + user.getCode());
    }

}
