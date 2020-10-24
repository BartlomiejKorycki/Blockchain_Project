package com.block.chain.controllers;

import com.block.chain.entities.BlockEntity;
import com.block.chain.services.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlockchainController {

    private BlockService service;

    @Autowired
    public BlockchainController(BlockService service) {
        this.service = service;
    }

    @GetMapping("/blockchain")
    public List<BlockEntity> getBlockchain() {
        return service.getBlockchain();
    }

    @PostMapping("/blockchain")
    public BlockEntity saveBlock(@RequestBody BlockEntity blockToSave) {
        return service.saveBlock(blockToSave);
    }
}