package com.block.chain.repositories;

import com.block.chain.entities.BlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockchainRepository extends JpaRepository<BlockEntity, Long> {
}
