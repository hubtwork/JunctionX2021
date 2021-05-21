package com.junctionx.demo.repository;

import com.junctionx.demo.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
