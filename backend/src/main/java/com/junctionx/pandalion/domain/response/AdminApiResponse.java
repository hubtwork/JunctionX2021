package com.junctionx.pandalion.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminApiResponse {

    private Long adminId;

    private int age;

    private String nation;

}
