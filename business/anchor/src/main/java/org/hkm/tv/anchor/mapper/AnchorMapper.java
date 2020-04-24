package org.hkm.tv.anchor.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.hkm.tv.anchor.entity.Anchor;

import java.util.List;

@Mapper
public interface AnchorMapper {

    Anchor findByAnchorId(Long anchorId);
    Anchor findByRoomId(Integer roomId);

    List<Anchor> findAll();

}
