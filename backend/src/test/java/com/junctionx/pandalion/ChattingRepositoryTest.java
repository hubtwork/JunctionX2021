package com.junctionx.pandalion;

import com.junctionx.pandalion.domain.Chatting;
import com.junctionx.pandalion.domain.UserGroupChannel;
import com.junctionx.pandalion.repository.ChannelRepository;
import com.junctionx.pandalion.repository.UserGroupChannelRepository;
import com.junctionx.pandalion.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChattingRepositoryTest extends PandalionApplicationTests{

    @Autowired
    private UserGroupChannelRepository userGroupChannelRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    void create(){
        String[] text = new String[10];
        String[] time = new String[10];
        text[0] = "Welcome to Food Festival!"; //
        text[1] = "I was so looking forward to today";
        text[2] = "Do you have a lot of delicious food prepared?";
        text[3] = "I want to eat quickly!";
        text[4] = "Please wait a bit, it will start in a while.";
        text[5] = "Thank you for hosting a party like this.";
        time[0] = "2021.05.23 10:00";
        time[1] = "2021.05.23 10:01";
        time[2] = "2021.05.23 10:02";
        time[3] = "2021.05.23 10:06";
        time[4] = "2021.05.23 10:09";
        time[5] = "2021.05.23 10:10";

        List<UserGroupChannel> all = userGroupChannelRepository.findAll();
        all.forEach(a->{
            int cnt = 0;
            if (a.getChannelId() == 12){
                Chatting chatting = Chatting.builder()
                        .channel(channelRepository.getOne(12L))
                        .text(text[cnt])
                        //.registeredTime(time[cnt])
                        //.user(userRepository.getOne(a.getUserId())
                        //.
                        .build();
            }

        });



    }
}
