package org.hkm.tv.video.entity;

import lombok.Data;

@Data
public class OnlineVideo {

    private Long id;
    private Long anchorId;
    private String key;//串流秘钥

}
