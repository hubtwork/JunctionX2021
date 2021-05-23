package com.junctionx.pandalion.repository;

import com.junctionx.pandalion.domain.Manager;
import com.junctionx.pandalion.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findOneByUsername(String username);
}
