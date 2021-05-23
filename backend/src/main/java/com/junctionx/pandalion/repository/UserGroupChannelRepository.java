package com.junctionx.pandalion.repository;

import com.junctionx.pandalion.domain.Manager;
import com.junctionx.pandalion.domain.UserGroupChannel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserGroupChannelRepository extends JpaRepository<UserGroupChannel, Long> {

    List<UserGroupChannel> findAllByOrderByGroupIdAscChannelIdAsc();

}
