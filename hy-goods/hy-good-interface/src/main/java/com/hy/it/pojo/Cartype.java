package com.hy.it.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_cartype")
@AllArgsConstructor
@NoArgsConstructor
public class Cartype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ct_id;
    private String car_type;
}
