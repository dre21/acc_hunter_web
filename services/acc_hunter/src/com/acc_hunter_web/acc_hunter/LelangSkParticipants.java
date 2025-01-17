/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
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
 * LelangSkParticipants generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`lelang_sk_participants`")
public class LelangSkParticipants implements Serializable {

    private Integer id;
    private String cdColl;
    private int lelangSkDetailId;
    private Integer bid;
    private LelangSkDetail lelangSkDetail;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`lelang_sk_participants_id_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`cd_coll`", nullable = false, length = 10)
    public String getCdColl() {
        return this.cdColl;
    }

    public void setCdColl(String cdColl) {
        this.cdColl = cdColl;
    }

    @Column(name = "`lelang_sk_detail_id`", nullable = false, scale = 0, precision = 10)
    public int getLelangSkDetailId() {
        return this.lelangSkDetailId;
    }

    public void setLelangSkDetailId(int lelangSkDetailId) {
        this.lelangSkDetailId = lelangSkDetailId;
    }

    @Column(name = "`bid`", nullable = true, scale = 0, precision = 10)
    public Integer getBid() {
        return this.bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`lelang_sk_detail_id`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`lelang_sk_participants_lelang_sk_detail_fkey`"))
    @Fetch(FetchMode.JOIN)
    public LelangSkDetail getLelangSkDetail() {
        return this.lelangSkDetail;
    }

    public void setLelangSkDetail(LelangSkDetail lelangSkDetail) {
        if(lelangSkDetail != null) {
            this.lelangSkDetailId = lelangSkDetail.getId();
        }

        this.lelangSkDetail = lelangSkDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LelangSkParticipants)) return false;
        final LelangSkParticipants lelangSkParticipants = (LelangSkParticipants) o;
        return Objects.equals(getId(), lelangSkParticipants.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}