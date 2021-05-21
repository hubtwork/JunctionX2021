package com.junctionx.pandalion.service;


import com.junctionx.pandalion.domain.Admin;
import com.junctionx.pandalion.domain.request.AdminApiRequest;
import com.junctionx.pandalion.domain.response.AdminApiResponse;
import com.junctionx.pandalion.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminApiService {

    private final AdminRepository adminRepository;

    public AdminApiResponse create(AdminApiRequest request) {

        Admin admin = Admin.builder()
                .adminId(request.getAdminId())
                .age(request.getAge())
                .nation(request.getNation())
                .build();

        return response(admin);
    }

    public AdminApiResponse read(Long id) {

        Optional<Admin> optional = adminRepository.findById(id);
        return null;
    }

    public AdminApiResponse update(AdminApiRequest request) {
        return null;
    }

    public void delete(Long id) {

    }

    private AdminApiResponse response(Admin admin){

        AdminApiResponse adminApiResponse = AdminApiResponse.builder()
                .adminId(admin.getAdminId())
                .age(admin.getAge())
                .nation(admin.getNation())
                .build();

        return adminApiResponse;
    }
}
