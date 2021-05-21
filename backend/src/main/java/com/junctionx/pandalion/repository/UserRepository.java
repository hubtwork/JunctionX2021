package com.junctionx.pandalion.repository;

import com.junctionx.pandalion.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
