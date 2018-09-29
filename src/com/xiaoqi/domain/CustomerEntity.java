package com.xiaoqi.domain;

import javax.persistence.*;
import java.util.Objects;


/*

创建数据库的信息

CREATE DATABASE xiaoqi;

USE xiaoqi;

SELECT *
FROM customer;

CREATE TABLE `customer` (
  `cust_id`       BIGINT(32)  NOT NULL AUTO_INCREMENT
  COMMENT '客户编号(主键)',
  `cust_name`     VARCHAR(32) NOT NULL
  COMMENT '客户名称(公司名称)',
  `cust_source`   VARCHAR(32)          DEFAULT NULL
  COMMENT '客户信息来源',
  `cust_industry` VARCHAR(32)          DEFAULT NULL
  COMMENT '客户所属行业',
  `cust_level`    VARCHAR(32)          DEFAULT NULL
  COMMENT '客户级别',
  `cust_linkman`  VARCHAR(64)          DEFAULT NULL
  COMMENT '联系人',
  `cust_phone`    VARCHAR(64)          DEFAULT NULL
  COMMENT '固定电话',
  `cust_mobile`   VARCHAR(16)          DEFAULT NULL
  COMMENT '移动电话',
  PRIMARY KEY (`cust_id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;



 */
@Entity
@Table(name = "customer", schema = "xiaoqi")
public class CustomerEntity {
    private long custId;
    private String custName;
    private String custSource;
    private String custIndustry;
    private String custLevel;
    private String custLinkman;
    private String custPhone;
    private String custMobile;

    @Id
    @Column(name = "cust_id")
    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    @Basic
    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Basic
    @Column(name = "cust_source")
    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    @Basic
    @Column(name = "cust_industry")
    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    @Basic
    @Column(name = "cust_level")
    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    @Basic
    @Column(name = "cust_linkman")
    public String getCustLinkman() {
        return custLinkman;
    }

    public void setCustLinkman(String custLinkman) {
        this.custLinkman = custLinkman;
    }

    @Basic
    @Column(name = "cust_phone")
    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Basic
    @Column(name = "cust_mobile")
    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return custId == that.custId &&
                Objects.equals(custName, that.custName) &&
                Objects.equals(custSource, that.custSource) &&
                Objects.equals(custIndustry, that.custIndustry) &&
                Objects.equals(custLevel, that.custLevel) &&
                Objects.equals(custLinkman, that.custLinkman) &&
                Objects.equals(custPhone, that.custPhone) &&
                Objects.equals(custMobile, that.custMobile);
    }


    @Override
    public String toString() {
        return "CustomerEntity{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custLinkman='" + custLinkman + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custMobile='" + custMobile + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(custId, custName, custSource, custIndustry, custLevel, custLinkman, custPhone, custMobile);
    }
}
