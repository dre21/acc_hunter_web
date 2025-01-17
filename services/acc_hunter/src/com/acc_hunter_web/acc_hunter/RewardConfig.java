/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * RewardConfig generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`reward_config`")
public class RewardConfig implements Serializable {

    private Integer id;
    private Integer idReward;
    private Integer point;
    private String availability;
    private LocalDateTime createdAt;
    private MasterReward masterReward;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`reward_config_id_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`id_reward`", nullable = true, scale = 0, precision = 10)
    public Integer getIdReward() {
        return this.idReward;
    }

    public void setIdReward(Integer idReward) {
        this.idReward = idReward;
    }

    @Column(name = "`point`", nullable = true, scale = 0, precision = 10)
    public Integer getPoint() {
        return this.point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Column(name = "`availability`", nullable = true, length = 255)
    public String getAvailability() {
        return this.availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Column(name = "`created_at`", nullable = true)
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`id_reward`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`reward_config_fk`"))
    @Fetch(FetchMode.JOIN)
    public MasterReward getMasterReward() {
        return this.masterReward;
    }

    public void setMasterReward(MasterReward masterReward) {
        if(masterReward != null) {
            this.idReward = masterReward.getId();
        }

        this.masterReward = masterReward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RewardConfig)) return false;
        final RewardConfig rewardConfig = (RewardConfig) o;
        return Objects.equals(getId(), rewardConfig.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}