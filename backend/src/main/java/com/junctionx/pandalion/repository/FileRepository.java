package com.junctionx.pandalion.repository;

import com.junctionx.pandalion.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long>
{
}
