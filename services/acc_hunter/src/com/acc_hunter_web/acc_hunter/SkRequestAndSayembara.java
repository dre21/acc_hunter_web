/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * SkRequestAndSayembara generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`sk_request_and_sayembara`")
@IdClass(SkRequestAndSayembaraId.class)
public class SkRequestAndSayembara implements Serializable {

    private String noAggr;
    private String collCd;
    private LocalDateTime reqSkDate;
    private Integer noSr;
    private String noPolice;
    private String noSpColl;
    private Long reqSkBt;
    private String flagSk;
    private String flagEcontract;
    private String flagFidusia;
    private String flagTrnschedule;
    private String flagDigisign;
    private String rcv01;
    private String rcv02;
    private String rcv03;
    private String rcv04;
    private String rcv05;
    private LocalDateTime syncDate;
    private String syncStat;
    private String appUid;
    private String appStat;
    private LocalDateTime appDate;
    private String addUid;
    private String addStat;
    private Date addDate;
    private String updUid;
    private LocalDateTime updDate;
    private Short status;
    private Integer skParent;
    private Boolean isShow = true;
    private Long appSkBt;

    @Id
    @Column(name = "`no_aggr`", nullable = false, length = 20)
    public String getNoAggr() {
        return this.noAggr;
    }

    public void setNoAggr(String noAggr) {
        this.noAggr = noAggr;
    }

    @Id
    @Column(name = "`coll_cd`", nullable = false, length = 10)
    public String getCollCd() {
        return this.collCd;
    }

    public void setCollCd(String collCd) {
        this.collCd = collCd;
    }

    @Id
    @Column(name = "`req_sk_date`", nullable = false)
    public LocalDateTime getReqSkDate() {
        return this.reqSkDate;
    }

    public void setReqSkDate(LocalDateTime reqSkDate) {
        this.reqSkDate = reqSkDate;
    }

    @Column(name = "`no_sr`", nullable = true, scale = 0, precision = 10)
    public Integer getNoSr() {
        return this.noSr;
    }

    public void setNoSr(Integer noSr) {
        this.noSr = noSr;
    }

    @Column(name = "`no_police`", nullable = true, length = 10)
    public String getNoPolice() {
        return this.noPolice;
    }

    public void setNoPolice(String noPolice) {
        this.noPolice = noPolice;
    }

    @Column(name = "`no_sp_coll`", nullable = true, length = 10)
    public String getNoSpColl() {
        return this.noSpColl;
    }

    public void setNoSpColl(String noSpColl) {
        this.noSpColl = noSpColl;
    }

    @Column(name = "`req_sk_bt`", nullable = true, scale = 0, precision = 19)
    public Long getReqSkBt() {
        return this.reqSkBt;
    }

    public void setReqSkBt(Long reqSkBt) {
        this.reqSkBt = reqSkBt;
    }

    @Column(name = "`flag_sk`", nullable = true, length = 3)
    public String getFlagSk() {
        return this.flagSk;
    }

    public void setFlagSk(String flagSk) {
        this.flagSk = flagSk;
    }

    @Column(name = "`flag_econtract`", nullable = true, length = 1)
    public String getFlagEcontract() {
        return this.flagEcontract;
    }

    public void setFlagEcontract(String flagEcontract) {
        this.flagEcontract = flagEcontract;
    }

    @Column(name = "`flag_fidusia`", nullable = true, length = 1)
    public String getFlagFidusia() {
        return this.flagFidusia;
    }

    public void setFlagFidusia(String flagFidusia) {
        this.flagFidusia = flagFidusia;
    }

    @Column(name = "`flag_trnschedule`", nullable = true, length = 1)
    public String getFlagTrnschedule() {
        return this.flagTrnschedule;
    }

    public void setFlagTrnschedule(String flagTrnschedule) {
        this.flagTrnschedule = flagTrnschedule;
    }

    @Column(name = "`flag_digisign`", nullable = true, length = 1)
    public String getFlagDigisign() {
        return this.flagDigisign;
    }

    public void setFlagDigisign(String flagDigisign) {
        this.flagDigisign = flagDigisign;
    }

    @Column(name = "`rcv01`", nullable = true, length = 10)
    public String getRcv01() {
        return this.rcv01;
    }

    public void setRcv01(String rcv01) {
        this.rcv01 = rcv01;
    }

    @Column(name = "`rcv02`", nullable = true, length = 20)
    public String getRcv02() {
        return this.rcv02;
    }

    public void setRcv02(String rcv02) {
        this.rcv02 = rcv02;
    }

    @Column(name = "`rcv03`", nullable = true, length = 25)
    public String getRcv03() {
        return this.rcv03;
    }

    public void setRcv03(String rcv03) {
        this.rcv03 = rcv03;
    }

    @Column(name = "`rcv04`", nullable = true, length = 30)
    public String getRcv04() {
        return this.rcv04;
    }

    public void setRcv04(String rcv04) {
        this.rcv04 = rcv04;
    }

    @Column(name = "`rcv05`", nullable = true, length = 35)
    public String getRcv05() {
        return this.rcv05;
    }

    public void setRcv05(String rcv05) {
        this.rcv05 = rcv05;
    }

    @Column(name = "`sync_date`", nullable = true)
    public LocalDateTime getSyncDate() {
        return this.syncDate;
    }

    public void setSyncDate(LocalDateTime syncDate) {
        this.syncDate = syncDate;
    }

    @Column(name = "`sync_stat`", nullable = true, length = 1)
    public String getSyncStat() {
        return this.syncStat;
    }

    public void setSyncStat(String syncStat) {
        this.syncStat = syncStat;
    }

    @Column(name = "`app_uid`", nullable = true, length = 20)
    public String getAppUid() {
        return this.appUid;
    }

    public void setAppUid(String appUid) {
        this.appUid = appUid;
    }

    @Column(name = "`app_stat`", nullable = true, length = 2)
    public String getAppStat() {
        return this.appStat;
    }

    public void setAppStat(String appStat) {
        this.appStat = appStat;
    }

    @Column(name = "`app_date`", nullable = true)
    public LocalDateTime getAppDate() {
        return this.appDate;
    }

    public void setAppDate(LocalDateTime appDate) {
        this.appDate = appDate;
    }

    @Column(name = "`add_uid`", nullable = true, length = 20)
    public String getAddUid() {
        return this.addUid;
    }

    public void setAddUid(String addUid) {
        this.addUid = addUid;
    }

    @Column(name = "`add_stat`", nullable = true, length = 2)
    public String getAddStat() {
        return this.addStat;
    }

    public void setAddStat(String addStat) {
        this.addStat = addStat;
    }

    @Column(name = "`add_date`", nullable = true)
    public Date getAddDate() {
        return this.addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Column(name = "`upd_uid`", nullable = true, length = 20)
    public String getUpdUid() {
        return this.updUid;
    }

    public void setUpdUid(String updUid) {
        this.updUid = updUid;
    }

    @Column(name = "`upd_date`", nullable = true)
    public LocalDateTime getUpdDate() {
        return this.updDate;
    }

    public void setUpdDate(LocalDateTime updDate) {
        this.updDate = updDate;
    }

    @Column(name = "`status`", nullable = true, scale = 0, precision = 5)
    public Short getStatus() {
        return this.status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Column(name = "`sk_parent`", nullable = true, scale = 0, precision = 10)
    public Integer getSkParent() {
        return this.skParent;
    }

    public void setSkParent(Integer skParent) {
        this.skParent = skParent;
    }

    @Column(name = "`is_show`", nullable = true)
    public Boolean getIsShow() {
        return this.isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    @Column(name = "`app_sk_bt`", nullable = true, scale = 0, precision = 19)
    public Long getAppSkBt() {
        return this.appSkBt;
    }

    public void setAppSkBt(Long appSkBt) {
        this.appSkBt = appSkBt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkRequestAndSayembara)) return false;
        final SkRequestAndSayembara skRequestAndSayembara = (SkRequestAndSayembara) o;
        return Objects.equals(getNoAggr(), skRequestAndSayembara.getNoAggr()) &&
                Objects.equals(getCollCd(), skRequestAndSayembara.getCollCd()) &&
                Objects.equals(getReqSkDate(), skRequestAndSayembara.getReqSkDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNoAggr(),
                getCollCd(),
                getReqSkDate());
    }
}