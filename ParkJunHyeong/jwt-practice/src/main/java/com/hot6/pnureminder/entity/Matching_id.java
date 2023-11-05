package com.hot6.pnureminder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matching_id implements Serializable {
    private Long member1;
    private Long member2;

}
