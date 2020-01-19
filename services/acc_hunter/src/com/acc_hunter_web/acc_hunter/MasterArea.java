/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * MasterArea generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`master_area`", uniqueConstraints = {
            @UniqueConstraint(name = "`unique_area_code`", columnNames = {"`area_code`"})})
public class MasterArea implements Serializable {

    private Integer id;
    private String areaCode;
    private String areaName;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`master_area_id_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`area_code`", nullable = true, length = 255)
    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Column(name = "`area_name`", nullable = true, length = 255)
    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MasterArea)) return false;
        final MasterArea masterArea = (MasterArea) o;
        return Objects.equals(getId(), masterArea.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}