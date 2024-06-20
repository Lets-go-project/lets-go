package com.example.letsGo.domain.pool;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class PoolScrapMappingId implements Serializable {
    private int userId;
    private String poolId;
}