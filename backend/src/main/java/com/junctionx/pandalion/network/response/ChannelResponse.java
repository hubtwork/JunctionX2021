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
public class ChannelResponse {

    private Long channelId;

    private String location;

    private String code;

    private String name;

    private List<FileResponse> fileResponseList;

    private List<ChattingResponse> chattingResponseList;
}
