package com.junctionx.pandalion;

import com.junctionx.pandalion.PandalionApplication;
import com.junctionx.pandalion.domain.Channel;
import com.junctionx.pandalion.repository.ChannelRepository;
import com.junctionx.pandalion.repository.GroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ChannelRepositoryTest extends PandalionApplicationTests{

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void create(){
        Channel channel1 = Channel.builder()
                .name("Coding Festival")
                .location("x:30, y:35")
                .group(groupRepository.getOne(1L))
                .build();

        channelRepository.save(channel1);

        Channel channel2 = Channel.builder()
                .name("Field Manager")
                .location("x:5, y:20")
                .group(groupRepository.getOne(1L))
                .build();

        channelRepository.save(channel2);

        Channel channel3 = Channel.builder()
                .name("9:00 Conference")
                .location("x:29, y:50")
                .group(groupRepository.getOne(1L))
                .build();

        channelRepository.save(channel3);

        Channel channel4 = Channel.builder()
                .name("10:30 Conference")
                .location("x:70, y:12")
                .group(groupRepository.getOne(1L))
                .build();

        channelRepository.save(channel4);

        Channel channel5 = Channel.builder()
                .name("Luncheon")
                .location("x:100, y:50")
                .group(groupRepository.getOne(2L))
                .build();

        channelRepository.save(channel5);

        Channel channel6 = Channel.builder()
                .name("13:30 Special Event")
                .location("x:170, y:80")
                .group(groupRepository.getOne(2L))
                .build();

        channelRepository.save(channel6);

        Channel channel7 = Channel.builder()
                .name("15:00 Conference")
                .location("x:300, y:80")
                .group(groupRepository.getOne(2L))
                .build();

        channelRepository.save(channel7);

        Channel channel8 = Channel.builder()
                .name("Attendance")
                .location("x:600, y:100")
                .group(groupRepository.getOne(2L))
                .build();

        channelRepository.save(channel8);

        Channel channel9 = Channel.builder()
                .name("Secure Closing")
                .location("x:900, y:180")
                .group(groupRepository.getOne(3L))
                .build();

        channelRepository.save(channel9);

        Channel channel10 = Channel.builder()
                .name("Secure Guard")
                .location("x:300, y:280")
                .group(groupRepository.getOne(3L))
                .build();

        channelRepository.save(channel10);

        Channel channel11 = Channel.builder()
                .name("HOTEL")
                .location("x:540, y:380")
                .group(groupRepository.getOne(3L))
                .build();

        channelRepository.save(channel11);

        Channel channel12 = Channel.builder()
                .name("peer session")
                .location("x:400, y:280")
                .group(groupRepository.getOne(3L))
                .build();

        channelRepository.save(channel12);

        Channel channel13 = Channel.builder()
                .name("Seminal")
                .location("x:1000, y:780")
                .group(groupRepository.getOne(3L))
                .build();

        channelRepository.save(channel13);

        Channel channel14 = Channel.builder()
                .name("food contest")
                .location("x:700, y:280")
                .group(groupRepository.getOne(3L))
                .build();

        channelRepository.save(channel14);

        Channel channel15 = Channel.builder()
                .name("coding test")
                .location("x:700, y:780")
                .group(groupRepository.getOne(3L))
                .build();

        channelRepository.save(channel15);

        Channel channel16 = Channel.builder()
                .name("food contest")
                .location("x:900, y:280")
                .group(groupRepository.getOne(3L))
                .build();

        channelRepository.save(channel16);

    }
}
