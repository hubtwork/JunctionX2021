package com.junctionx.demo.service;

import com.junctionx.demo.domain.Admin;
import com.junctionx.demo.domain.request.AdminApiRequest;
import com.junctionx.demo.domain.response.AdminApiResponse;
import com.junctionx.demo.ifs.CrudInterface;
import com.junctionx.demo.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminApiService implements CrudInterface<AdminApiRequest, AdminApiResponse> {

    private final AdminRepository adminRepository;

    @Override
    public AdminApiResponse create(AdminApiRequest request) {

        Admin admin = Admin.builder()
                .adminId(request.getAdminId())
                .age(request.getAge())
                .nation(request.getNation())
                .build();

        return response(admin);
    }

    @Override
    public AdminApiResponse read(Long id) {

        Optional<Admin> optional = adminRepository.findById(id);
        return null;
    }

    @Override
    public AdminApiResponse update(AdminApiRequest request) {
        return null;
    }

    @Override
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
