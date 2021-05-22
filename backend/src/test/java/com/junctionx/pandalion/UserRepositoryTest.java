package com.junctionx.pandalion;

import com.junctionx.pandalion.domain.User;
import com.junctionx.pandalion.domain.UserGroupChannel;
import com.junctionx.pandalion.repository.UserGroupChannelRepository;
import com.junctionx.pandalion.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserRepositoryTest extends PandalionApplicationTests{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupChannelRepository userGroupChannelRepository;



    public ArrayList random(int personCnt) {


        ArrayList result = new ArrayList();
        ArrayList a = new ArrayList();

        while(true){

            Random g = new Random();
            Random c = new Random();

            int groupNumber =  g.nextInt(3)+1;
            int _groupNumber = groupNumber;
            int channelNumber = c.nextInt(16)+1;
            int _channelNumber = channelNumber;
            if (!((groupNumber == 1 && (channelNumber >= 1 && channelNumber <= 4)) || (groupNumber == 2 && (channelNumber >= 5 && channelNumber <= 8)) || (groupNumber == 3 && (channelNumber >= 9 && channelNumber <= 16)))) {
                continue;
            }
            String temp = Integer.toString(_groupNumber) + Integer.toString(_channelNumber);
            if (!result.contains(temp)){
                result.add(temp);
                a.add((long)groupNumber);
                a.add((long)channelNumber);
            }
            if (result.size() >= personCnt){
                break;
            }
        }

//        for(int i = 0 ; i< a.size(); i++){
//            System.out.println(a.get(i));
//        }
        return a;

    }



    @Test
    public void create(){
        User user1 = User.builder()
                .phoneNumber("01078281192")
                .isDisabled(false)
                .isSpeaking(false)
                .username("lee dohyun")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user1);



        User user2 = User.builder()
                .phoneNumber("01022328783")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim syunggin")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user2);

        User user3 = User.builder()
                .phoneNumber("01012938420")
                .isDisabled(false)
                .isSpeaking(false)
                .username("chae hyunwook")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user3);

        User user4 = User.builder()
                .phoneNumber("01032529503")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim gayung")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user4);

        User user5 = User.builder()
                .phoneNumber("01039251123")
                .isDisabled(true)
                .isSpeaking(false)
                .username("jin galim")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user5);

        User user6 = User.builder()
                .phoneNumber("01025834921")
                .isDisabled(false)
                .isSpeaking(false)
                .username("cha yunghyun")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user6);

        User user7 = User.builder()
                .phoneNumber("01039209965")
                .isDisabled(false)
                .isSpeaking(false)
                .username("park jeewon")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user7);

        User user8 = User.builder()
                .phoneNumber("01098392839")
                .isDisabled(false)
                .isSpeaking(false)
                .username("gang jiwoon")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user8);

        User user9 = User.builder()
                .phoneNumber("01098739928")
                .isDisabled(false)
                .isSpeaking(false)
                .username("jin wongoe")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user9);

        User user10 = User.builder()
                .phoneNumber("01023902983")
                .isDisabled(false)
                .isSpeaking(false)
                .username("chae huynjin")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user10);

        User user11 = User.builder()
                .phoneNumber("01092039928")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim hyunwook")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user11);

        User user12 = User.builder()
                .phoneNumber("01089203928")
                .isDisabled(false)
                .isSpeaking(false)
                .username("jin hyunzin")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user12);

        User user13 = User.builder()
                .phoneNumber("01099287398")
                .isDisabled(false)
                .isSpeaking(false)
                .username("chae hyungin")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user13);

        User user14 = User.builder()
                .phoneNumber("01092304938")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim sinwoo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user14);

        User user15 = User.builder()
                .phoneNumber("010203984938")
                .isDisabled(false)
                .isSpeaking(false)
                .username("cha hyunwook")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user15);

        User user16 = User.builder()
                .phoneNumber("01012039928")
                .isDisabled(false)
                .isSpeaking(false)
                .username("park jinwoo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user16);

        User user17 = User.builder()
                .phoneNumber("01029387782")
                .isDisabled(false)
                .isSpeaking(false)
                .username("gang hyunjoon")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user17);

        User user18 = User.builder()
                .phoneNumber("01029383892")
                .isDisabled(false)
                .isSpeaking(false)
                .username("jun jinwoo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user18);

        User user19 = User.builder()
                .phoneNumber("01029301023")
                .isDisabled(false)
                .isSpeaking(false)
                .username("chae jinwoo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user19);

        User user20 = User.builder()
                .phoneNumber("01023219887")
                .isDisabled(false)
                .isSpeaking(false)
                .username("baek hyunjun")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user20);

        User user21 = User.builder()
                .phoneNumber("01087921773")
                .isDisabled(false)
                .isSpeaking(false)
                .username("jang yoonhyuk")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user21);

        User user22 = User.builder()
                .phoneNumber("01029338279")
                .isDisabled(false)
                .isSpeaking(false)
                .username("park jeenga")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user22);

        User user23 = User.builder()
                .phoneNumber("0109256773")
                .isDisabled(false)
                .isSpeaking(false)
                .username("chae jongho")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user23);

        User user24 = User.builder()
                .phoneNumber("01038290019")
                .isDisabled(false)
                .isSpeaking(false)
                .username("baek jinjoo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user24);

        User user25 = User.builder()
                .phoneNumber("01028847928")
                .isDisabled(false)
                .isSpeaking(true)
                .username("chae hyunwoo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user25);

        User user26 = User.builder()
                .phoneNumber("01054938783")
                .isDisabled(false)
                .isSpeaking(false)
                .username("park jaho")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user26);

        User user27 = User.builder()
                .phoneNumber("01022953827")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim hyunwook")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user27);

        User user28 = User.builder()
                .phoneNumber("01067839928")
                .isDisabled(false)
                .isSpeaking(false)
                .username("min jangho")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user28);

        User user29 = User.builder()
                .phoneNumber("01029938473")
                .isDisabled(false)
                .isSpeaking(false)
                .username("chae minjae")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user29);

        User user30 = User.builder()
                .phoneNumber("01049372883")
                .isDisabled(false)
                .isSpeaking(false)
                .username("jang jongho")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user30);

        User user31 = User.builder()
                .phoneNumber("01084793882")
                .isDisabled(false)
                .isSpeaking(false)
                .username("chae hyunmin")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user31);

        User user32 = User.builder()
                .phoneNumber("01022923309")
                .isDisabled(false)
                .isSpeaking(false)
                .username("park minwoo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user32);

        User user33 = User.builder()
                .phoneNumber("01079338821")
                .isDisabled(false)
                .isSpeaking(false)
                .username("lee jinjoo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user33);

        User user34 = User.builder()
                .phoneNumber("01022938004")
                .isDisabled(false)
                .isSpeaking(false)
                .username("park gangjoon")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user34);

        User user35 = User.builder()
                .phoneNumber("01079283372")
                .isDisabled(false)
                .isSpeaking(false)
                .username("jin yunggee")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user35);

        User user36 = User.builder()
                .phoneNumber("01029305932")
                .isDisabled(false)
                .isSpeaking(false)
                .username("park jaegyung")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user36);

        User user37 = User.builder()
                .phoneNumber("01090938493")
                .isDisabled(false)
                .isSpeaking(false)
                .username("cha jinwhyan")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user37);

        User user38 = User.builder()
                .phoneNumber("01055948393")
                .isDisabled(false)
                .isSpeaking(false)
                .username("chae minhyuk")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user38);

        User user39 = User.builder()
                .phoneNumber("01092837992")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim jinwoo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user39);

        User user40 = User.builder()
                .phoneNumber("01090283746")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim hawoon")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user40);

        User user41 = User.builder()
                .phoneNumber("01022893733")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim minha")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user41);

        User user42 = User.builder()
                .phoneNumber("01029385746")
                .isDisabled(false)
                .isSpeaking(true)
                .username("gang hana")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user42);

        User user43 = User.builder()
                .phoneNumber("01023948837")
                .isDisabled(false)
                .isSpeaking(false)
                .username("chae hyunjin")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user43);

        User user44 = User.builder()
                .phoneNumber("01083872349")
                .isDisabled(false)
                .isSpeaking(false)
                .username("baek jinwoo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user44);

        User user45 = User.builder()
                .phoneNumber("01022938392")
                .isDisabled(false)
                .isSpeaking(false)
                .username("lee rohyun")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user45);

        User user46 = User.builder()
                .phoneNumber("0102453994")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim hana")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user46);

        User user47 = User.builder()
                .phoneNumber("01029384938")
                .isDisabled(false)
                .isSpeaking(false)
                .username("ha jinwoo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user47);

        User user48 = User.builder()
                .phoneNumber("01022930493")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim minwoo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user48);

        User user49 = User.builder()
                .phoneNumber("01029938432")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim jinsung")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user49);


        User user50 = User.builder()
                .phoneNumber("01044930293")
                .isDisabled(false)
                .isSpeaking(false)
                .username("park hongjo")
                .location("x:1,y:1")
                .workTp("staff")
                .build();
        userRepository.save(user50);


        User user51 = User.builder()
                .phoneNumber("01099382947")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim sunggin")
                .location("x:1,y:1")
                .workTp("manager")
                .profileImage("https://i.imgur.com/bw9JmxS.png")
                .build();
        userRepository.save(user51);


        User user52 = User.builder()
                .phoneNumber("01099382947")
                .isDisabled(false)
                .isSpeaking(false)
                .username("park minwoo")
                .location("x:1,y:1")
                .workTp("manager")
                .profileImage("https://i.imgur.com/bw9JmxS.png")
                .build();
        userRepository.save(user52);

        User user53 = User.builder()
                .phoneNumber("01099382947")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim sunggin")
                .location("x:1,y:1")
                .workTp("manager")
                .profileImage("https://i.imgur.com/NJzmdyJ.png")
                .build();
        userRepository.save(user53);

        User user54 = User.builder()
                .phoneNumber("01044987638")
                .isDisabled(false)
                .isSpeaking(false)
                .username("park hana")
                .location("x:1,y:1")
                .workTp("manager")
                .profileImage("https://i.imgur.com/m1a99Xm.png")
                .build();
        userRepository.save(user54);

        User user55 = User.builder()
                .phoneNumber("01071223732")
                .isDisabled(false)
                .isSpeaking(false)
                .username("chae jinha")
                .location("x:1,y:1")
                .workTp("manager")
                .profileImage("https://i.imgur.com/EiiHBDy.png")
                .build();
        userRepository.save(user55);

        User user56 = User.builder()
                .phoneNumber("01099382947")
                .isDisabled(true)
                .isSpeaking(false)
                .username("kim sunggin")
                .location("x:1,y:1")
                .workTp("manager")
                .profileImage("https://i.imgur.com/FrM2Jtq.png")
                .build();
        userRepository.save(user56);

        User user57 = User.builder()
                .phoneNumber("01088722947")
                .isDisabled(false)
                .isSpeaking(false)
                .username("jun jonghyuk")
                .location("x:1,y:1")
                .workTp("manager")
                .profileImage("https://i.imgur.com/COWlmcg.png")
                .build();
        userRepository.save(user57);

        User user58 = User.builder()
                .phoneNumber("01070432347")
                .isDisabled(false)
                .isSpeaking(false)
                .username("kim hanwoo")
                .location("x:1,y:1")
                .workTp("manager")
                .profileImage("https://i.imgur.com/bJdU3rz.png")
                .build();
        userRepository.save(user58);

        User user59 = User.builder()
                .phoneNumber("01022930493")
                .isDisabled(false)
                .isSpeaking(false)
                .username("chae hyunwook")
                .location("x:1,y:1")
                .workTp("manager")
                .profileImage("https://i.imgur.com/FYUPqz5.png")
                .build();
        userRepository.save(user59);

        User user60 = User.builder()
                .phoneNumber("01022930493")
                .isDisabled(false)
                .isSpeaking(false)
                .username("park minjoo")
                .location("x:1,y:1")
                .workTp("manager")
                .profileImage("https://i.imgur.com/mPn0ikd.png")
                .build();
        User save = userRepository.save(user60);

    }

    @Test
    void user_group_channel(){
        int cnt = 8;
        List<User> all = userRepository.findAll();

        all.forEach(a->{
            ArrayList b = random(cnt);
            int tmp = 0;
            for (int i = 0; i < cnt; i++){
                UserGroupChannel userGroupChannel = UserGroupChannel.builder()
                        .userId(a.getId())
                        .groupId((Long) b.get(tmp))
                        .channelId((Long) b.get(tmp+1))
                        .build();
                userGroupChannelRepository.save(userGroupChannel);
                tmp += 2;
            }


        });
        random(3);
    }

    @Test
    void check_many_channel(){
        int[] result = new int[16];
        for(int i=0;i<16;i++){
            result[i] = 0;
        }

        List<UserGroupChannel> all = userGroupChannelRepository.findAll();
        all.forEach(a->{
            result[a.getChannelId().intValue()-1] += 1;
        });

//        for(int i = 0; i < 16;i++){
//            System.out.println(result[i]);
//        }
    }



}
