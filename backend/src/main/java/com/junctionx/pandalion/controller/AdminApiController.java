package com.junctionx.pandalion.controller;

import com.junctionx.pandalion.domain.request.AdminApiRequest;
import com.junctionx.pandalion.domain.response.AdminApiResponse;
import com.junctionx.pandalion.service.AdminApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminApiController  {

    private final AdminApiService adminApiService;


    public AdminApiResponse create(AdminApiRequest request) {
        return adminApiService.create(request);
    }


    public AdminApiResponse read(Long id) {
        return adminApiService.read(id);
    }


    public AdminApiResponse update(AdminApiRequest request) {
        return adminApiService.update(request);
    }


    public void delete(Long id) {
        adminApiService.delete(id);
    }
}