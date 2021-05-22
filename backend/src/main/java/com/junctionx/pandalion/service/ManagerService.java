package com.junctionx.pandalion.service;


import com.junctionx.pandalion.domain.Authority;
import com.junctionx.pandalion.domain.Channel;
import com.junctionx.pandalion.domain.Group;
import com.junctionx.pandalion.domain.Manager;
import com.junctionx.pandalion.network.dto.ManagerDto;
import com.junctionx.pandalion.network.response.*;
import com.junctionx.pandalion.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class ManagerService {

    private final ManagerRepository managerRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Manager signup(ManagerDto managerDto) {
        if (managerRepository.findOneWithAuthoritiesByUsername(managerDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        Manager manager = Manager.builder()
                .username(managerDto.getUsername())
                .password(passwordEncoder.encode(managerDto.getPassword()))
                .nickname(managerDto.getNickname())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return managerRepository.save(manager);
    }

    public ForWebResponse forweb() {

        Manager manager = managerRepository.findById(1L).orElseThrow(NoSuchElementException::new);
        ForWebResponse forWebResponse = new ForWebResponse();
        List<Group> groupList = manager.getGroupList();

        for (Group group : groupList) {
            GroupResponse groupResponse = new GroupResponse();
            groupResponse.setId(group.getId());
            groupResponse.setRegion(group.getRegion());
            groupResponse.setName(group.getName());
            // 아직 setChannelResponseList 추가 안함.
            List<Channel> channelList = group.getChannelList();

            for (Channel channel : channelList) {
                ChannelResponse channelResponse = new ChannelResponse();
                channelResponse.setId(channel.getId());
                channelResponse.setName(channel.getName());
                channelResponse.setCode(channel.getCode());
                channelResponse.setLocation(channel.getLocation());

                FileResponse fileResponse = new FileResponse();
                fileResponse.setId(channel.getFile().getId());
                fileResponse.setAuth(channel.getFile().getAuth());
                fileResponse.setCapacity(channel.getFile().getCapacity());
                fileResponse.setOriginFileName(channel.getFile().getOriginFileName());
                fileResponse.setType(channel.getFile().getType());
                fileResponse.setRegisteredTime(channel.getFile().getRegisteredTime());

                channelResponse.setFileResponse(fileResponse);

                ChattingResponse chattingResponse = new ChattingResponse();
                chattingResponse.setId(channel.getChatting().getId());
                chattingResponse.setText(channel.getChatting().getText());
                chattingResponse.setSelf(channel.getChatting().isSelf());
                chattingResponse.setRegisteredTime(channel.getChatting().getRegisteredTime());

                ChattingUserResponse chattingUserResponse = new ChattingUserResponse();
                chattingUserResponse.setUsername(channel.getChatting().getUser().getUsername());
                chattingUserResponse.setProfileImage(channel.getChatting().getUser().getProfileImage());
                chattingUserResponse.setWorkTp(channel.getChatting().getUser().getWorkTp());

                chattingResponse.setChattingUserResponse(chattingUserResponse);

                channelResponse.setChattingResponse(chattingResponse);

                List<ChannelResponse> channelResponses = new ArrayList<>();
                channelResponses.add(channelResponse);

                groupResponse.setChannelResponseList(channelResponses);
                List<GroupResponse> groupResponses = new ArrayList<>();
                groupResponses.add(groupResponse);
                forWebResponse.setGroupResponseList(groupResponses);
            }
        }

        forWebResponse.setId(1L);
        forWebResponse.setAge(manager.getAge());
        forWebResponse.setNation(manager.getNation());
        forWebResponse.setUsername(manager.getUsername());
        forWebResponse.setNickname(manager.getNickname());

        return forWebResponse;
    }
}
