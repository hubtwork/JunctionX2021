package com.junctionx.demo.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserApiRequest {
    private Long userId;

    private String name;

    private String groupName;

    private int channelNumber;

    private String code;

    private String location;
}
