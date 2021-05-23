package com.junctionx.pandalion;

import com.junctionx.pandalion.domain.File;
import com.junctionx.pandalion.repository.ChannelRepository;
import com.junctionx.pandalion.repository.FileRepository;
import com.junctionx.pandalion.repository.ManagerRepository;
import com.junctionx.pandalion.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FileRepositoryTest extends PandalionApplicationTests{

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private FileRepository fileRepository;

    @Test
    void create(){
        File file1 = File.builder()
                .auth("above manager")
                .capacity("0.8MB")
                .manager(managerRepository.getById(14L))
                .channel(channelRepository.getOne(1L))
                .type("pdf")
                .originFileName("2021-coding-festival.pdf")
                .registeredTime("2021.04.01")
                .build();
        fileRepository.save(file1);

        File file2 = File.builder()
                .auth("above manager")
                .capacity("0.6MB")
                .manager(managerRepository.getById(14L))
                .channel(channelRepository.getOne(2L))
                .type("pdf")
                .originFileName("2021-filed-manager.pdf")
                .registeredTime("2021.04.02")
                .build();
        fileRepository.save(file2);

        File file3 = File.builder()
                .auth("above staff")
                .capacity("0.8MB")
                .manager(managerRepository.getById(52L))
                .channel(channelRepository.getOne(3L))
                .type("pdf")
                .originFileName("9:00 conference timeline.pdf")
                .registeredTime("2021.04.04")
                .build();
        fileRepository.save(file3);

        File file4 = File.builder()
                .auth("above staff")
                .capacity("0.5MB")
                .manager(managerRepository.getById(14L))
                .channel(channelRepository.getOne(16L))
                .type("pdf")
                .originFileName("2021-Peer-session.pdf")
                .registeredTime("2021.04.08")
                .build();
        fileRepository.save(file4);

        File file5 = File.builder()
                .auth("above manager")
                .capacity("0.85MB")
                .manager(managerRepository.getById(14L))
                .channel(channelRepository.getOne(6L))
                .type("pdf")
                .originFileName("special event.pdf")
                .registeredTime("2021.04.10")
                .build();
        fileRepository.save(file5);

        File file6 = File.builder()
                .auth("above manager")
                .capacity("0.9MB")
                .manager(managerRepository.getById(52L))
                .channel(channelRepository.getOne(9L))
                .type("pdf")
                .originFileName("secure closing.pdf")
                .registeredTime("2021.04.18")
                .build();
        fileRepository.save(file6);

        File file7 = File.builder()
                .auth("above manager")
                .capacity("0.75MB")
                .manager(managerRepository.getById(52L))
                .channel(channelRepository.getOne(12L))
                .type("pdf")
                .originFileName("Food festival recipe.pdf")
                .registeredTime("2021.04.21")
                .build();
        fileRepository.save(file7);
    }
}
