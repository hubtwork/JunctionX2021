package com.junctionx.pandalion.network.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {

    private Long id;

    private String originFileName;

    private String serverFileName;

    private String filePath;

    private Long managerId;

    private Long userId;

}
