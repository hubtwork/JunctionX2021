package com.junctionx.pandalion;

import com.junctionx.pandalion.domain.UserGroupChannel;
import com.junctionx.pandalion.repository.UserGroupChannelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SortTest extends PandalionApplicationTests{

    @Autowired
    private UserGroupChannelRepository userGroupChannelRepository;

    @Test
    void isSortTest(){
        List<UserGroupChannel> sort = userGroupChannelRepository.findAllByOrderByGroupIdAscChannelIdAsc();
        for (UserGroupChannel userGroupChannel : sort) {
            System.out.println("group_id = " + userGroupChannel.getGroupId());
            System.out.println("channel_id = " + userGroupChannel.getChannelId());
        }
    }
}
