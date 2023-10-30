package com.hot6.pnureminder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(Matching_id.class)
public class Matching {


    @Id
    @Column(name = "member1_id")
    private Long member1;

    @Id
    @Column(name = "member2_id")
    private Long member2;


}
