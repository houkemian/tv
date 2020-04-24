package org.hkm.tv.video.service;

import org.hkm.common.Result;
import org.hkm.tv.video.entity.OnlineVideo;

public interface OnlineVideoService {

    Result<OnlineVideo> getByAnchorId(Long anchorId);

}
