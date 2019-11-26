package com.hy.it.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tb_goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long car_type_id;
    private Double weight;
    private Double price;
    private Long transport_id;
    private Long goods_type_id;
    private Long goods_kind_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end_time;
    private String push_person;
    private String phone;
    private String startplace_name;
    private String  endplace_name;
    @Transient
    private String cartypename;
    @Transient
    private String  goodstypename;
    @Transient
    private String  goodskindname;
    @Transient
    private String transportname;
    @Transient
    private Double maxprice;
    @Transient
    private Double minprice;
    @Transient
    private String createtime;
    @Transient
    private String  endtime;
}
