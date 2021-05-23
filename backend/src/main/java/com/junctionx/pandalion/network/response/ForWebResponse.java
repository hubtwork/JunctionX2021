package com.junctionx.pandalion.network.response;

import com.junctionx.pandalion.domain.UserGroupChannel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForWebResponse {

    private Long id;

    private Integer age;

    private String nation;

    private String username;

    private String nickname;

    private String workTp;

    private List<GroupResponse> groupResponseList;

    private List<UserGroupChannelResponse> userGroupChannelResponseList;
}
