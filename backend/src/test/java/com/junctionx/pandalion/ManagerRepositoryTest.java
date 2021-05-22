package com.junctionx.pandalion;

import com.junctionx.pandalion.PandalionApplication;
import com.junctionx.pandalion.domain.Authority;
import com.junctionx.pandalion.domain.Manager;
import com.junctionx.pandalion.repository.ManagerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class ManagerRepositoryTest extends PandalionApplicationTests {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void create(){
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        Manager manager = Manager.builder()
                .username("park jeewon")
                .age(34)
                .password("")
                .nation("Seoul")
                //.authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        managerRepository.save(manager);

    }
}
