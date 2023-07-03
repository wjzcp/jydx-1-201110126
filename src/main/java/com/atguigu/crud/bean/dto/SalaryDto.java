package com.atguigu.crud.bean.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: TalentoHR
 * @description: Ð½×ÊDto
 * @author: record
 * @create: 2023-07-03 15:33
 **/
@Data
public class SalaryDto {

    private Integer id;

    private String deptName;

    private String empName;

    private BigDecimal jsalary;

    private BigDecimal jbonus;

    private String isgrant;

    private Date grantdate;
}
