package com.example.letsGo.domain.pool;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Table(name = "pool")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pool {

    @Id
    @Column(name = "pool_id")
    private String poolId;

    @Size(max = 100)
    @Column(name = "pool_name", nullable = false, length = 100)
    private String poolName;

    @Size(max = 15)
    @Column(name = "pool_tel", nullable = false, length = 15)
    private String poolTel;

    @Size(max = 255)
    @Column(name = "pool_loc", nullable = false, length = 255)
    private String poolLoc;

}