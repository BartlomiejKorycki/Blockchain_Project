package com.block.chain.services;

import com.block.chain.entities.BlockEntity;
import com.block.chain.repositories.BlockchainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {

    private BlockchainRepository repository;

    @Autowired
    public BlockService(BlockchainRepository repository) {
        this.repository = repository;
    }

    public List<BlockEntity> getBlockchain() {
        return repository.findAll();
    }

    public BlockEntity saveBlock(BlockEntity block) {
        return repository.save(block);
    }
}
