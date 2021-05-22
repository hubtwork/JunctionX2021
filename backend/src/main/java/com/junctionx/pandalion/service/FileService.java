package com.junctionx.pandalion.service;

import com.junctionx.pandalion.network.dto.FileDto;
import com.junctionx.pandalion.repository.FileRepository;
import com.junctionx.pandalion.util.MD5Generator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Transactional
public class FileService {

    private final FileRepository fileRepository;

    public String uploadFile(MultipartFile[] files) {
        Arrays.stream(files).map(file->{

            try {
                String originFileName = file.getOriginalFilename();
                String fileName = new MD5Generator(originFileName).toString();

                //실행되는 위치의 'portfolio-files' 폴더에 파일이 저장
                String savePath = System.getProperty("user.dir") + "//files";

                //파일이 저장되는 폴더가 없으면 폴더를 생성
                if (!new File(savePath).exists()) {
                    try {
                        new File(savePath).mkdir();
                    } catch (Exception e) {
                        e.toString();
                    }
                }
                String filePath = savePath + "//" + fileName;
                file.transferTo(new File(filePath));

                FileDto filedto = new FileDto();
                filedto.setOriginFileName(originFileName);
                filedto.setServerFileName(fileName);
                filedto.setFilePath(filePath);
                saveFile(filedto);

            } catch(Exception e) {
                e.toString();
            }
            return file;
        })
                .collect(toList());

        return "file upload success";
    }

    private void saveFile(FileDto fileDto) {
        com.junctionx.pandalion.domain.File build = com.junctionx.pandalion.domain.File.builder()
                .serverFileName(fileDto.getServerFileName())
                .originFileName(fileDto.getOriginFileName())
                .filePath(fileDto.getFilePath())
                .build();

        fileRepository.save(build);
    }
}
