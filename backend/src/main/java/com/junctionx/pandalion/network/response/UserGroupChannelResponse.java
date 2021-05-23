package com.junctionx.pandalion.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGroupChannelResponse {

    private Long groupId;

    private Long channelId;

    private UUID userId;

    private String username;

    private String code;

    private String location;

    private String phoneNumber;

    private String workTp;

    private boolean isSpeaking;

    private boolean isDisabled;

    private String profileImage;

}
