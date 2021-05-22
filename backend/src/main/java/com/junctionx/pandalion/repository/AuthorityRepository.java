package com.junctionx.pandalion.repository;

import com.junctionx.pandalion.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
