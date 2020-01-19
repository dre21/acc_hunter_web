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
 * LelangParticipants generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`lelang_participants`")
public class LelangParticipants implements Serializable {

    private Integer id;
    private String cdColl;
    private int lelangSkId;
    private Boolean insertBid;
    private LelangSk lelangSk;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`lelang_participants_id_seq`" , allocationSize = 1)
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

    @Column(name = "`lelang_sk_id`", nullable = false, scale = 0, precision = 10)
    public int getLelangSkId() {
        return this.lelangSkId;
    }

    public void setLelangSkId(int lelangSkId) {
        this.lelangSkId = lelangSkId;
    }

    @Column(name = "`insert_bid`", nullable = true)
    public Boolean getInsertBid() {
        return this.insertBid;
    }

    public void setInsertBid(Boolean insertBid) {
        this.insertBid = insertBid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`lelang_sk_id`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`lelang_sk_participants_lelang_sk_fkey`"))
    @Fetch(FetchMode.JOIN)
    public LelangSk getLelangSk() {
        return this.lelangSk;
    }

    public void setLelangSk(LelangSk lelangSk) {
        if(lelangSk != null) {
            this.lelangSkId = lelangSk.getId();
        }

        this.lelangSk = lelangSk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LelangParticipants)) return false;
        final LelangParticipants lelangParticipants = (LelangParticipants) o;
        return Objects.equals(getId(), lelangParticipants.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}