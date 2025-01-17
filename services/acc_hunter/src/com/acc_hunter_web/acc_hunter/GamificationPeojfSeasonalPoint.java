/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * GamificationPeojfSeasonalPoint generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`gamification_peojf_seasonal_point`")
public class GamificationPeojfSeasonalPoint implements Serializable {

    private Integer id;
    private String value;
    private BigDecimal pointMultiplication;
    private boolean status;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`gamification_peojf_seasonal_point_id_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`value`", nullable = false, length = 50)
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "`point_multiplication`", nullable = false, scale = 17, precision = 17)
    public BigDecimal getPointMultiplication() {
        return this.pointMultiplication;
    }

    public void setPointMultiplication(BigDecimal pointMultiplication) {
        this.pointMultiplication = pointMultiplication;
    }

    @Column(name = "`status`", nullable = false)
    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Column(name = "`created_at`", nullable = false)
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "`created_by`", nullable = false, length = 50)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "`updated_at`", nullable = true)
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "`updated_by`", nullable = true, length = 50)
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GamificationPeojfSeasonalPoint)) return false;
        final GamificationPeojfSeasonalPoint gamificationPeojfSeasonalPoint = (GamificationPeojfSeasonalPoint) o;
        return Objects.equals(getId(), gamificationPeojfSeasonalPoint.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}