package org.hkm.tv.anchor.service;

import org.hkm.common.Result;
import org.hkm.tv.anchor.entity.Anchor;

import java.util.List;

public interface AnchorService {

    Result<Anchor> getByAnchorId(Long anchorId);
    Result<Anchor> getByRoomId(Integer roomId);

    Result<List<Anchor>> getAnchorList();

}
