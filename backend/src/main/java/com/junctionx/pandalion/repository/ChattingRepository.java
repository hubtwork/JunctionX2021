package com.junctionx.pandalion.repository;

import com.junctionx.pandalion.domain.Chatting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChattingRepository extends JpaRepository<Chatting, Long> {
}
