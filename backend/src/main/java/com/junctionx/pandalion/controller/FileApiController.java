package com.junctionx.pandalion.controller;

import com.junctionx.pandalion.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileApiController {

    private final FileService fileService;

    @PostMapping("/send/manager")
    public ResponseEntity<String> sendManagerFile(@RequestParam("file") MultipartFile[] files) {
        String s = fileService.uploadFile(files);

        return ResponseEntity.ok(s);
    }

//    @PostMapping("/send/user")
//    public ResponseEntity sendUserFile(@RequestParam("files")MultipartFile[] files) {
//
//    }
}

