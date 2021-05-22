package com.junctionx.pandalion.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChannelRequest {
    private Long channelId;

    private int number;

    private String location;
}
