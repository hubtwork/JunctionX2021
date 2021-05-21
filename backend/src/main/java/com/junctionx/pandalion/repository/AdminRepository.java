package com.junctionx.pandalion.repository;


import com.junctionx.pandalion.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
