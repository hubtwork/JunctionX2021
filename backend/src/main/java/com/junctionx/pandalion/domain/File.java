package com.junctionx.pandalion.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
@ToString(exclude = {"manager", "user","channel"})
public class File {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    private String registeredTime;

    private String originFileName; // 2021-junctionx-conference.pdf

    private String serverFileName; //X

    private String filePath; //x

    private String capacity; // 0.8MB

    private String auth; // "매니 저 이상"

    private String type; // pdf

    @ManyToOne(fetch = FetchType.LAZY)
    private Manager manager; //

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; //

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
