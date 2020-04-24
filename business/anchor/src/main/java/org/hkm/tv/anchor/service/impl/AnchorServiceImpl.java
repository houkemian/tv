package org.hkm.tv.anchor.service.impl;

import org.hkm.common.Result;
import org.hkm.tv.anchor.entity.Anchor;
import org.hkm.tv.anchor.mapper.AnchorMapper;
import org.hkm.tv.anchor.service.AnchorService;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AnchorServiceImpl implements AnchorService {

    @Autowired
    private AnchorMapper anchorMapper;

    @Autowired
    private RedissonClient redisson;

    @Override
    public Result<Anchor> getByAnchorId(Long anchorId) {

        Anchor anchor = loadFromCache(anchorId);

        return Result.success(anchor);
    }

    @Override
    public Result<Anchor> getByRoomId(Integer roomId) {
//        Anchor anchor = loadFromCache(anchorId);
        Anchor anchor = null;

        return Result.success(anchor);
    }


    @Override
    public Result<List<Anchor>> getAnchorList() {
        return Result.success(this.anchorMapper.findAll());
    }

    private Anchor loadFromDB(Long anchorId) {

        RLock lock = redisson.getLock("anchor:id:"+anchorId);
        Anchor anchor;
        try {

            boolean locked = lock.tryLock();
            if (locked) {
                anchor = this.anchorMapper.findByAnchorId(anchorId);
                return anchor;
            }
        } finally {
            lock.unlock();
        }

        return null;
    }

    private Anchor loadFromCache(Long anchorId) {
        Anchor anchor;
        RMap map = redisson.getMap("anchor:id:"+anchorId);
        if (map.isEmpty()) {
            anchor = loadFromDB(anchorId);
            if (anchor == null) {
                map.put("id", anchorId);
                map.expire(10, TimeUnit.SECONDS);
            } else {
                anchor.map(map);
                map.expire(1, TimeUnit.HOURS);
            }

            return anchor;
        }
        anchor = new Anchor();
        anchor.entity(map);
        return anchor;
    }


}
