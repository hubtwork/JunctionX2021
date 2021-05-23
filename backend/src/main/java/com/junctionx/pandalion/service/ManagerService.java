package com.junctionx.pandalion.service;


import com.junctionx.pandalion.domain.*;
import com.junctionx.pandalion.network.dto.ManagerDto;
import com.junctionx.pandalion.network.response.*;
import com.junctionx.pandalion.repository.ManagerRepository;
import com.junctionx.pandalion.repository.UserGroupChannelRepository;
import com.junctionx.pandalion.repository.UserRepository;
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

    private final UserGroupChannelRepository userGroupChannelRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

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
                .nation(managerDto.getNation())
                .age(managerDto.getAge())
                .workTp(managerDto.getWorkTp())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return managerRepository.save(manager);
    }

    public ForWebResponse forweb() {

        Manager manager = managerRepository.findById(1L).orElseThrow(NoSuchElementException::new);
        ForWebResponse forWebResponse = new ForWebResponse();
        List<Group> groupList = manager.getGroupList();

        List<GroupResponse> groupResponses = new ArrayList<>();
        for (Group group : groupList) {
            GroupResponse groupResponse = new GroupResponse();

            List<Channel> channelList = group.getChannelList();
            List<ChannelResponse> channelResponses = new ArrayList<>();
            for (Channel channel : channelList) {
                ChannelResponse channelResponse = new ChannelResponse();

                List<File> fileList = channel.getFiles();
                List<FileResponse> fileResponses = new ArrayList<>();
                for (File file : fileList) {
                    FileResponse fileResponse = new FileResponse();
                    fileResponse.setId(file.getId());
                    fileResponse.setAuth(file.getAuth());
                    fileResponse.setCapacity(file.getCapacity());
                    fileResponse.setOriginFileName(file.getOriginFileName());
                    fileResponse.setType(file.getType());
                    fileResponse.setRegisteredTime(file.getRegisteredTime());
                    fileResponses.add(fileResponse);
                }

                List<Chatting> chattingList = channel.getChattings();
                List<ChattingResponse> chattingResponses = new ArrayList<>();
                for (Chatting chatting : chattingList) {
                    ChattingResponse chattingResponse = new ChattingResponse();
                    chattingResponse.setId(chatting.getId());
                    chattingResponse.setText(chatting.getText());
                    chattingResponse.setSelf(chatting.isSelf());
                    chattingResponse.setRegisteredTime(chatting.getRegisteredTime());
                    chattingResponse.setUnreadCount(chatting.getUnreadCount());
                    chattingResponse.setUsername(chatting.getUser().getUsername());
                    chattingResponse.setProfileImage(chatting.getUser().getProfileImage());
                    chattingResponse.setWorkTp(chatting.getUser().getWorkTp());
                    chattingResponses.add(chattingResponse);
                }

                channelResponse.setChannelId(channel.getId());
                channelResponse.setName(channel.getName());
                channelResponse.setCode(channel.getCode());
                channelResponse.setLocation(channel.getLocation());
                channelResponse.setFileResponseList(fileResponses);
                channelResponse.setChattingResponseList(chattingResponses);
                channelResponses.add(channelResponse);
            }

            groupResponse.setChannelResponseList(channelResponses);
            groupResponse.setGroupId(group.getId());
            groupResponse.setRegion(group.getRegion());
            groupResponse.setName(group.getName());
            groupResponses.add(groupResponse);
        }

        forWebResponse.setGroupResponseList(groupResponses);

        forWebResponse.setId(1L);
        forWebResponse.setAge(manager.getAge());
        forWebResponse.setNation(manager.getNation());
        forWebResponse.setUsername(manager.getUsername());
        forWebResponse.setNickname(manager.getNickname());
        forWebResponse.setWorkTp(manager.getWorkTp());


        List<UserGroupChannel> sort = userGroupChannelRepository.findAllByOrderByGroupIdAscChannelIdAsc();

        List<UserGroupChannelResponse> userGroupChannelResponseList = new ArrayList<>();
        for (UserGroupChannel s : sort) {
            UserGroupChannelResponse userGroupChannelResponse = new UserGroupChannelResponse();
            userGroupChannelResponse.setGroupId(s.getGroupId());
            userGroupChannelResponse.setChannelId(s.getChannelId());
            userGroupChannelResponse.setUserId(s.getUserId());

            User user = userRepository.findById(s.getUserId()).orElseThrow(NoSuchElementException::new);

            userGroupChannelResponse.setUsername(user.getUsername());
            userGroupChannelResponse.setCode(user.getCode());
            userGroupChannelResponse.setLocation(user.getLocation());
            userGroupChannelResponse.setProfileImage(user.getProfileImage());
            userGroupChannelResponse.setWorkTp(user.getWorkTp());
            userGroupChannelResponse.setDisabled(user.isDisabled());
            userGroupChannelResponse.setPhoneNumber(user.getPhoneNumber());
            userGroupChannelResponse.setSpeaking(user.isSpeaking());


            userGroupChannelResponseList.add(userGroupChannelResponse);

        }

        forWebResponse.setUserGroupChannelResponseList(userGroupChannelResponseList);

        return forWebResponse;
    }
}
