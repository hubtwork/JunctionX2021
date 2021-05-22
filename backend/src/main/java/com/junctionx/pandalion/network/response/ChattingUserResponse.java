package com.junctionx.pandalion.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChattingUserResponse {

    private String username;

    private String profileImage;

    private String workTp;

}
