package com.junctionx.pandalion.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChannelResponse {

    private Long id;

    private String location;

    private String code;

    private String name;

    private FileResponse fileResponse;

    private ChattingResponse chattingResponse;
}
