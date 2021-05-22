package com.junctionx.pandalion.repository;


import com.junctionx.pandalion.domain.Manager;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @EntityGraph(attributePaths = "authorities")
    Optional<Manager> findOneWithAuthoritiesByUsername(String username);

    Manager findOneByUsername(String username);
}
