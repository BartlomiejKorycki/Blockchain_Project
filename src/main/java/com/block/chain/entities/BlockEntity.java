package com.block.chain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Blockchain")
@NoArgsConstructor
@Getter
@Setter
public class BlockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long timestamp;
    private Long magicNumber;
    private String previousHash;
    private String hash;
    private Long generatingTime;
}
