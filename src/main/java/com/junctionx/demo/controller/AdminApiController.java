package com.junctionx.demo.controller;


import com.junctionx.demo.domain.request.AdminApiRequest;
import com.junctionx.demo.domain.response.AdminApiResponse;
import com.junctionx.demo.ifs.CrudInterface;
import com.junctionx.demo.service.AdminApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminApiController implements CrudInterface<AdminApiRequest, AdminApiResponse> {

    private final AdminApiService adminApiService;

    @Override
    public AdminApiResponse create(AdminApiRequest request) {
        return adminApiService.create(request);
    }

    @Override
    public AdminApiResponse read(Long id) {
        return adminApiService.read(id);
    }

    @Override
    public AdminApiResponse update(AdminApiRequest request) {
        return adminApiService.update(request);
    }

    @Override
    public void delete(Long id) {
        adminApiService.delete(id);
    }
}
