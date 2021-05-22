package com.junctionx.pandalion;

import com.junctionx.pandalion.domain.Group;
import com.junctionx.pandalion.repository.GroupRepository;
import com.junctionx.pandalion.repository.ManagerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupRepositoryTest extends PandalionApplicationTests {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void create(){
        Group group1 = Group.builder()
                .name("2021MS Conference")
                .region("x:10, y:20")
                .manager(managerRepository.getOne(1L))
                .build();

        groupRepository.save(group1);

        Group group2 = Group.builder()
                .name("Junction Festival")
                .region("x:10, y:20")
                .manager(managerRepository.getOne(1L))
                .build();

        groupRepository.save(group2);

        Group group3 = Group.builder()
                .name("Smoo opening")
                .region("x:10, y:20")
                .manager(managerRepository.getOne(1L))
                .build();

        groupRepository.save(group3);


    }
}
