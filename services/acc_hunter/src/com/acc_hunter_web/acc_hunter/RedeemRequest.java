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
 * RedeemRequest generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`redeem_request`")
public class RedeemRequest implements Serializable {

    private Integer id;
    private int idUser;
    private int idRewardConfig;
    private LocalDateTime createdAt;
    private Boolean isConfirmed;
    private LocalDateTime confirmedAt;
    private Users users;
    private RewardConfig rewardConfig;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`redeem_request_id_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`id_user`", nullable = false, scale = 0, precision = 10)
    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Column(name = "`id_reward_config`", nullable = false, scale = 0, precision = 10)
    public int getIdRewardConfig() {
        return this.idRewardConfig;
    }

    public void setIdRewardConfig(int idRewardConfig) {
        this.idRewardConfig = idRewardConfig;
    }

    @Column(name = "`created_at`", nullable = true)
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "`is_confirmed`", nullable = true)
    public Boolean getIsConfirmed() {
        return this.isConfirmed;
    }

    public void setIsConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    @Column(name = "`confirmed_at`", nullable = true)
    public LocalDateTime getConfirmedAt() {
        return this.confirmedAt;
    }

    public void setConfirmedAt(LocalDateTime confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`id_user`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`redeem_request_fk`"))
    @Fetch(FetchMode.JOIN)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        if(users != null) {
            this.idUser = users.getId();
        }

        this.users = users;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`id_reward_config`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`redeem_request_fk_1`"))
    @Fetch(FetchMode.JOIN)
    public RewardConfig getRewardConfig() {
        return this.rewardConfig;
    }

    public void setRewardConfig(RewardConfig rewardConfig) {
        if(rewardConfig != null) {
            this.idRewardConfig = rewardConfig.getId();
        }

        this.rewardConfig = rewardConfig;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RedeemRequest)) return false;
        final RedeemRequest redeemRequest = (RedeemRequest) o;
        return Objects.equals(getId(), redeemRequest.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}