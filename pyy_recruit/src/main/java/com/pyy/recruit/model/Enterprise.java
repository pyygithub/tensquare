package com.pyy.recruit.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 企业实体类
 * @author panyy
 */
@Data
@Entity
@Table(name = "tb_enterprise")
public class Enterprise implements Serializable{

    @Id
    private String id;//id
    private String name;//企业名称
    private String summary;//企业简介
    private String address;//地址
    private String labels;//标签列表
    private String coordinate;//企业位置坐标：经纬度
    private String ishot;//是否热门 0：非热门 1：热门
    private String logo;//企业LOGO
    private Integer jobcount;//职位数
    private String url;//URL

}