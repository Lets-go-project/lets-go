package com.example.letsGo.domain.pool;

import com.example.letsGo.domain.member.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Table(name = "pool_scrap_mapping")
public class PoolScrapMapping {

    @EmbeddedId
    private PoolScrapMappingId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("poolId")
    @JoinColumn(name = "pool_id")
    private Pool pool;
}