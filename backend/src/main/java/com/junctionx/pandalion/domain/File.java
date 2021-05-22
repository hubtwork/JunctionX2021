package com.junctionx.pandalion.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Entity
//@EntityListeners(AuditingEntityListener.class)
//@Builder
//@Accessors(chain = true)
//public class File {
//
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "file_id")
//    private Long id;
//
//    private String originFileName;
//
//    private String serverFileName;
//
//    private String filePath;
//
//    private String workTp;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Manager manager;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user;
//
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    private LocalDateTime updatedAt;
//}
