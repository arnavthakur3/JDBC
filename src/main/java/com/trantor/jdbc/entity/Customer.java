package com.trantor.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
public class Customer {
    @Id
    @Column
    private Integer custId;
    private String custName;
    private String custProd;
    private Long prodPrize;
}
