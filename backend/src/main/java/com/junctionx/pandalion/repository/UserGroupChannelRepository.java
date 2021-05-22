package com.junctionx.pandalion.repository;

import com.junctionx.pandalion.domain.Manager;
import com.junctionx.pandalion.domain.UserGroupChannel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupChannelRepository extends JpaRepository<UserGroupChannel, Long> {
}
