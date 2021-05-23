package com.junctionx.pandalion.controller;

import com.junctionx.pandalion.domain.Manager;
import com.junctionx.pandalion.jwt.JwtFilter;
import com.junctionx.pandalion.jwt.TokenProvider;
import com.junctionx.pandalion.network.dto.LoginDto;
import com.junctionx.pandalion.network.dto.ManagerDto;
import com.junctionx.pandalion.network.dto.TokenDto;
import com.junctionx.pandalion.network.response.ForWebResponse;
import com.junctionx.pandalion.service.ManagerService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/manager")
@RequiredArgsConstructor
public class ManagerApiController {

    private final ManagerService managerService;

    private final TokenProvider tokenProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/signup")
    public ResponseEntity<Manager> signup(
            @Valid @RequestBody ManagerDto managerDto
    ) {
        return ResponseEntity.ok(managerService.signup(managerDto));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/forweb")
    public ForWebResponse forweb(){
        return managerService.forweb();
    }

}