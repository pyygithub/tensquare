package com.pyy.recruit.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 招聘信息实体类
 * @author panyy
 */
@Data
@Entity
@Table(name = "tb_recruit")
public class Recruit implements Serializable {
    @Id
    private String id;//id
    private String jobname;//招聘职位
    private String salary;//薪资范围
    private String condition;//经验要求
    private String education;//学历要求
    private String type;//任职方式
    private String address;//办公地址
    private String eid;//企业ID
    private Date createtime;//发布日期
    private String state;//状态 0:关闭 1:开启 2:推荐
    private String url;//原网址
    private String label;//标签
    private String centent1;//职位描述
    private String centent2;//职位要求
}