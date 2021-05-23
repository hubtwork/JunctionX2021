//package com.junctionx.pandalion.util;
//
//import com.junctionx.pandalion.domain.Authority;
//import com.junctionx.pandalion.domain.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//
//@Component
//@RequiredArgsConstructor
//public class InitDb {
//
//    private final InitService initService;
//
//    @PostConstruct
//    public void init() {
//        initService.dbInit1();
//    }
//
//    @Component
//    @Transactional
//    @RequiredArgsConstructor
//    static class InitService {
//
//        private final EntityManager em;
//
//        public void dbInit1() {
////            Authority authority = new Authority();
////            authority.setAuthorityName("ROLE_USER");
////            em.persist(authority);
//
//            User user1 = User.builder()
//                    .phoneNumber("01078281192")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("lee dohyun")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user1);
//
//            User user2 = User.builder()
//                    .phoneNumber("01022328783")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim syunggin")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user2);
//
//            User user3 = User.builder()
//                    .phoneNumber("01012938420")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("chae hyunwook")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user3);
//
//            User user4 = User.builder()
//                    .phoneNumber("01032529503")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim gayung")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user4);
//
//            User user5 = User.builder()
//                    .phoneNumber("01039251123")
//                    .isDisabled(true)
//                    .isSpeaking(false)
//                    .username("jin galim")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user5);
//
//            User user6 = User.builder()
//                    .phoneNumber("01025834921")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("cha yunghyun")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user6);
//
//            User user7 = User.builder()
//                    .phoneNumber("01039209965")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("park jeewon")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user7);
//
//            User user8 = User.builder()
//                    .phoneNumber("01098392839")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("gang jiwoon")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user8);
//
//            User user9 = User.builder()
//                    .phoneNumber("01098739928")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("jin wongoe")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user9);
//
//            User user10 = User.builder()
//                    .phoneNumber("01023902983")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("chae huynjin")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user10);
//
//            User user11 = User.builder()
//                    .phoneNumber("01092039928")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim hyunwook")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user11);
//
//            User user12 = User.builder()
//                    .phoneNumber("01089203928")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("jin hyunzin")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user12);
//
//            User user13 = User.builder()
//                    .phoneNumber("01099287398")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("chae hyungin")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user13);
//
//            User user14 = User.builder()
//                    .phoneNumber("01092304938")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim sinwoo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user14);
//
//            User user15 = User.builder()
//                    .phoneNumber("010203984938")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("cha hyunwook")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user15);
//
//            User user16 = User.builder()
//                    .phoneNumber("01012039928")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("park jinwoo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user16);
//
//            User user17 = User.builder()
//                    .phoneNumber("01029387782")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("gang hyunjoon")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user17);
//
//            User user18 = User.builder()
//                    .phoneNumber("01029383892")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("jun jinwoo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user18);
//
//            User user19 = User.builder()
//                    .phoneNumber("01029301023")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("chae jinwoo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user19);
//
//            User user20 = User.builder()
//                    .phoneNumber("01023219887")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("baek hyunjun")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user20);
//
//            User user21 = User.builder()
//                    .phoneNumber("01087921773")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("jang yoonhyuk")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user21);
//
//            User user22 = User.builder()
//                    .phoneNumber("01029338279")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("park jeenga")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user22);
//
//            User user23 = User.builder()
//                    .phoneNumber("0109256773")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("chae jongho")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user23);
//
//            User user24 = User.builder()
//                    .phoneNumber("01038290019")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("baek jinjoo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user24);
//
//            User user25 = User.builder()
//                    .phoneNumber("01028847928")
//                    .isDisabled(false)
//                    .isSpeaking(true)
//                    .username("chae hyunwoo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user25);
//
//            User user26 = User.builder()
//                    .phoneNumber("01054938783")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("park jaho")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user26);
//
//            User user27 = User.builder()
//                    .phoneNumber("01022953827")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim hyunwook")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user27);
//
//            User user28 = User.builder()
//                    .phoneNumber("01067839928")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("min jangho")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user28);
//
//            User user29 = User.builder()
//                    .phoneNumber("01029938473")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("chae minjae")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user29);
//
//            User user30 = User.builder()
//                    .phoneNumber("01049372883")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("jang jongho")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user30);
//
//            User user31 = User.builder()
//                    .phoneNumber("01084793882")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("chae hyunmin")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user31);
//
//            User user32 = User.builder()
//                    .phoneNumber("01022923309")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("park minwoo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user32);
//
//            User user33 = User.builder()
//                    .phoneNumber("01079338821")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("lee jinjoo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user33);
//
//            User user34 = User.builder()
//                    .phoneNumber("01022938004")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("park gangjoon")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user34);
//
//            User user35 = User.builder()
//                    .phoneNumber("01079283372")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("jin yunggee")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user35);
//
//            User user36 = User.builder()
//                    .phoneNumber("01029305932")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("park jaegyung")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user36);
//
//            User user37 = User.builder()
//                    .phoneNumber("01090938493")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("cha jinwhyan")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user37);
//
//            User user38 = User.builder()
//                    .phoneNumber("01055948393")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("chae minhyuk")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user38);
//
//            User user39 = User.builder()
//                    .phoneNumber("01092837992")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim jinwoo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user39);
//
//            User user40 = User.builder()
//                    .phoneNumber("01090283746")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim hawoon")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user40);
//
//            User user41 = User.builder()
//                    .phoneNumber("01022893733")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim minha")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user41);
//
//            User user42 = User.builder()
//                    .phoneNumber("01029385746")
//                    .isDisabled(false)
//                    .isSpeaking(true)
//                    .username("gang hana")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user42);
//
//            User user43 = User.builder()
//                    .phoneNumber("01023948837")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("chae hyunjin")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user43);
//
//            User user44 = User.builder()
//                    .phoneNumber("01083872349")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("baek jinwoo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user44);
//
//            User user45 = User.builder()
//                    .phoneNumber("01022938392")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("lee rohyun")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user45);
//
//            User user46 = User.builder()
//                    .phoneNumber("0102453994")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim hana")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user46);
//
//            User user47 = User.builder()
//                    .phoneNumber("01029384938")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("ha jinwoo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user47);
//
//            User user48 = User.builder()
//                    .phoneNumber("01022930493")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim minwoo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user48);
//
//            User user49 = User.builder()
//                    .phoneNumber("01029938432")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim jinsung")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user49);
//
//
//            User user50 = User.builder()
//                    .phoneNumber("01044930293")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("park hongjo")
//                    .location("x:1,y:1")
//                    .workTp("staff")
//                    .build();
//            em.persist(user50);
//
//
//            User user51 = User.builder()
//                    .phoneNumber("01099382947")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim sunggin")
//                    .location("x:1,y:1")
//                    .workTp("manager")
//                    .profileImage("https://i.imgur.com/bw9JmxS.png")
//                    .build();
//            em.persist(user51);
//
//
//            User user52 = User.builder()
//                    .phoneNumber("01099382947")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("park minwoo")
//                    .location("x:1,y:1")
//                    .workTp("manager")
//                    .profileImage("https://i.imgur.com/bw9JmxS.png")
//                    .build();
//            em.persist(user52);
//
//            User user53 = User.builder()
//                    .phoneNumber("01099382947")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim sunggin")
//                    .location("x:1,y:1")
//                    .workTp("manager")
//                    .profileImage("https://i.imgur.com/NJzmdyJ.png")
//                    .build();
//            em.persist(user53);
//
//            User user54 = User.builder()
//                    .phoneNumber("01044987638")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("park hana")
//                    .location("x:1,y:1")
//                    .workTp("manager")
//                    .profileImage("https://i.imgur.com/m1a99Xm.png")
//                    .build();
//            em.persist(user54);
//
//            User user55 = User.builder()
//                    .phoneNumber("01071223732")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("chae jinha")
//                    .location("x:1,y:1")
//                    .workTp("manager")
//                    .profileImage("https://i.imgur.com/EiiHBDy.png")
//                    .build();
//            em.persist(user55);
//
//            User user56 = User.builder()
//                    .phoneNumber("01099382947")
//                    .isDisabled(true)
//                    .isSpeaking(false)
//                    .username("kim sunggin")
//                    .location("x:1,y:1")
//                    .workTp("manager")
//                    .profileImage("https://i.imgur.com/FrM2Jtq.png")
//                    .build();
//            em.persist(user56);
//
//            User user57 = User.builder()
//                    .phoneNumber("01088722947")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("jun jonghyuk")
//                    .location("x:1,y:1")
//                    .workTp("manager")
//                    .profileImage("https://i.imgur.com/COWlmcg.png")
//                    .build();
//            em.persist(user57);
//
//            User user58 = User.builder()
//                    .phoneNumber("01070432347")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("kim hanwoo")
//                    .location("x:1,y:1")
//                    .workTp("manager")
//                    .profileImage("https://i.imgur.com/bJdU3rz.png")
//                    .build();
//            em.persist(user58);
//
//            User user59 = User.builder()
//                    .phoneNumber("01022930493")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("chae hyunwook")
//                    .location("x:1,y:1")
//                    .workTp("manager")
//                    .profileImage("https://i.imgur.com/FYUPqz5.png")
//                    .build();
//            em.persist(user59);
//
//            User user60 = User.builder()
//                    .phoneNumber("01022930493")
//                    .isDisabled(false)
//                    .isSpeaking(false)
//                    .username("park minjoo")
//                    .location("x:1,y:1")
//                    .workTp("manager")
//                    .profileImage("https://i.imgur.com/mPn0ikd.png")
//                    .build();
//            em.persist(user60);
//        }
//    }
//}
