package com.junctionx.pandalion.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junctionx.pandalion.domain.Manager;
import com.junctionx.pandalion.repository.ManagerRepository;
import com.junctionx.pandalion.repository.UserRepository;
import com.junctionx.pandalion.service.FileService;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import io.jsonwebtoken.Jwt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
@Slf4j
public class FileApiController {

    private final FileService fileService;

    private final ManagerRepository managerRepository;

    private final UserRepository userRepository;

    @PostMapping("/send/manager")
    public SendFileResponse sendManagerFile(HttpServletRequest request, @RequestParam("file") MultipartFile[] files) throws ParseException {

        String bearerToken = request.getHeader("Authorization");
        String token = bearerToken.substring(7);

        JWT jwt = JWTParser.parse(token);
        JWTClaimsSet jwtClaimSet = jwt.getJWTClaimsSet();
        Map<String, Object> claims = jwtClaimSet.getClaims();
        String username = (String) claims.get("sub");
        log.info("file upload user name : {}", username);

        Manager manager = managerRepository.findOneByUsername(username);
        String s = fileService.uploadManagerFile(files, manager.getId());

        return new SendFileResponse(s);
    }

    @Data
    static class SendFileResponse {
        private String description;

        public SendFileResponse(String description) {
            this.description = description;
        }
    }

}

