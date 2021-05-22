package com.junctionx.pandalion.util;

import com.junctionx.pandalion.domain.Authority;
import com.junctionx.pandalion.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            Authority authority = new Authority();
            authority.setAuthorityName("ROLE_USER");
            em.persist(authority);

            User user = new User(); // user2 ~ user60 까지
            user.setCode("2c3f3s5z");
            user.setPhoneNumber("01072117883");
            user.setDisabled(false); // 한 채널에 1~2 명 ( 통신 상태 불안으로 인한 빨간색 점 )
            user.setSpeaking(true); // 한 채널에 1 명 ( 말하고 있는 사람 초록색 점 )
            user.setUsername("dohyunlee");
            user.setLocation("x 어쩌구 y 어쩌구");
            user.setProfileImage("님이 이미지 링크 생성한 url");
            user.setWorkTp("staff");
            em.persist(user);

            User user1 = new User();

            user1.setCode("asdasfdasdfasdf");
            user1.setPhoneNumber("asdfasdasdfasdff");
            em.persist(user1);
        }
    }
}
