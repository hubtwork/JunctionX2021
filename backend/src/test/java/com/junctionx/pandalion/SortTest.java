package com.junctionx.pandalion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.junctionx.pandalion.domain.UserGroupChannel;
import com.junctionx.pandalion.repository.UserGroupChannelRepository;
import com.junctionx.pandalion.sms.service.SmsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class SortTest extends PandalionApplicationTests{

    @Autowired
    private UserGroupChannelRepository userGroupChannelRepository;

    @Autowired
    private SmsService smsService;

    @Test
    void isSortTest(){
        List<UserGroupChannel> sort = userGroupChannelRepository.findAllByOrderByGroupIdAscChannelIdAsc();
        for (UserGroupChannel userGroupChannel : sort) {
            System.out.println("group_id = " + userGroupChannel.getGroupId());
            System.out.println("channel_id = " + userGroupChannel.getChannelId());
        }
    }

    @Test
    void sendSmsTest() throws URISyntaxException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {
        smsService.sendSms("01075187260", "Dohyun Lee's chatting room code : dX3s55mL");
    }
}
