package org.hkm.tv.video.mapper;

import org.hkm.tv.video.entity.OnlineVideo;

public interface OnlineVideoMapper {

    OnlineVideo findByAnchorId(Long anchorId);

}
