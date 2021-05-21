package com.junctionx.pandalion.repository;

import com.junctionx.pandalion.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
