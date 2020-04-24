package org.hkm.tv.anchor.controller;

import org.hkm.common.Result;
import org.hkm.tv.anchor.entity.Anchor;
import org.hkm.tv.anchor.service.AnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/anchor")
public class AnchorController {

    @Autowired
    private AnchorService anchorService;

    @GetMapping("/{id}")
    public Result<Anchor> getAnchorById(@PathVariable("id") Long id) {
        return this.anchorService.getByAnchorId(id);
    }

    @GetMapping
    public Result<List<Anchor>> getList() {
        return this.anchorService.getAnchorList();
    }

}
