package com.junctionx.pandalion.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupResponse {

    private Long id;

    private String name;

    private String region;

    private List<ChannelResponse> channelResponseList;
}
