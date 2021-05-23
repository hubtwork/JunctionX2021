package com.junctionx.pandalion.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChattingResponse {

    private Long id;

    private String text;

    private String registeredTime;

    private boolean self;

    private Integer unreadCount;

    private ChattingUserResponse chattingUserResponse;
}
