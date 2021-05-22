package com.junctionx.pandalion.service;


import com.junctionx.pandalion.domain.Authority;
import com.junctionx.pandalion.domain.Manager;
import com.junctionx.pandalion.network.dto.ManagerDto;
import com.junctionx.pandalion.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Manager signup(ManagerDto managerDto) {
        if (managerRepository.findOneWithAuthoritiesByUsername(managerDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        //빌더 패턴의 장점
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

}
