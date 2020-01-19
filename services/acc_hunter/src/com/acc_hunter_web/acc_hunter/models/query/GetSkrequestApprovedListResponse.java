/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetSkrequestApprovedListResponse implements Serializable {


    @ColumnAlias("number")
    private Integer number;

    @ColumnAlias("name")
    private String name;

    @ColumnAlias("no_sr")
    private Integer noSr;

    @ColumnAlias("no_aggr")
    private String noAggr;

    @ColumnAlias("no_police")
    private String noPolice;

    @ColumnAlias("no_sp_coll")
    private String noSpColl;

    @ColumnAlias("coll_cd")
    private String collCd;

    @ColumnAlias("req_sk_bt")
    private Long reqSkBt;

    @ColumnAlias("req_sk_date")
    private Timestamp reqSkDate;

    @ColumnAlias("flag_sk")
    private String flagSk;

    @ColumnAlias("flag_econtract")
    private String flagEcontract;

    @ColumnAlias("flag_fidusia")
    private String flagFidusia;

    @ColumnAlias("flag_trnschedule")
    private String flagTrnschedule;

    @ColumnAlias("flag_digisign")
    private String flagDigisign;

    @ColumnAlias("rcv01")
    private String rcv01;

    @ColumnAlias("rcv02")
    private String rcv02;

    @ColumnAlias("rcv03")
    private String rcv03;

    @ColumnAlias("rcv04")
    private String rcv04;

    @ColumnAlias("rcv05")
    private String rcv05;

    @ColumnAlias("sync_date")
    private Timestamp syncDate;

    @ColumnAlias("sync_stat")
    private String syncStat;

    @ColumnAlias("app_uid")
    private String appUid;

    @ColumnAlias("app_stat")
    private String appStat;

    @ColumnAlias("app_date")
    private Timestamp appDate;

    @ColumnAlias("add_uid")
    private String addUid;

    @ColumnAlias("add_stat")
    private String addStat;

    @ColumnAlias("add_date")
    private Date addDate;

    @ColumnAlias("upd_uid")
    private String updUid;

    @ColumnAlias("upd_date")
    private Timestamp updDate;

    @ColumnAlias("status")
    private Short status;

    @ColumnAlias("sk_parent")
    private Integer skParent;

    @ColumnAlias("is_show")
    private Boolean isShow;

    @ColumnAlias("app_sk_bt")
    private Long appSkBt;

    @ColumnAlias("is_signed")
    private Boolean isSigned;

    @ColumnAlias("expired_date")
    private Timestamp expiredDate;

    @ColumnAlias("dokumen")
    private String dokumen;

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoSr() {
        return this.noSr;
    }

    public void setNoSr(Integer noSr) {
        this.noSr = noSr;
    }

    public String getNoAggr() {
        return this.noAggr;
    }

    public void setNoAggr(String noAggr) {
        this.noAggr = noAggr;
    }

    public String getNoPolice() {
        return this.noPolice;
    }

    public void setNoPolice(String noPolice) {
        this.noPolice = noPolice;
    }

    public String getNoSpColl() {
        return this.noSpColl;
    }

    public void setNoSpColl(String noSpColl) {
        this.noSpColl = noSpColl;
    }

    public String getCollCd() {
        return this.collCd;
    }

    public void setCollCd(String collCd) {
        this.collCd = collCd;
    }

    public Long getReqSkBt() {
        return this.reqSkBt;
    }

    public void setReqSkBt(Long reqSkBt) {
        this.reqSkBt = reqSkBt;
    }

    public Timestamp getReqSkDate() {
        return this.reqSkDate;
    }

    public void setReqSkDate(Timestamp reqSkDate) {
        this.reqSkDate = reqSkDate;
    }

    public String getFlagSk() {
        return this.flagSk;
    }

    public void setFlagSk(String flagSk) {
        this.flagSk = flagSk;
    }

    public String getFlagEcontract() {
        return this.flagEcontract;
    }

    public void setFlagEcontract(String flagEcontract) {
        this.flagEcontract = flagEcontract;
    }

    public String getFlagFidusia() {
        return this.flagFidusia;
    }

    public void setFlagFidusia(String flagFidusia) {
        this.flagFidusia = flagFidusia;
    }

    public String getFlagTrnschedule() {
        return this.flagTrnschedule;
    }

    public void setFlagTrnschedule(String flagTrnschedule) {
        this.flagTrnschedule = flagTrnschedule;
    }

    public String getFlagDigisign() {
        return this.flagDigisign;
    }

    public void setFlagDigisign(String flagDigisign) {
        this.flagDigisign = flagDigisign;
    }

    public String getRcv01() {
        return this.rcv01;
    }

    public void setRcv01(String rcv01) {
        this.rcv01 = rcv01;
    }

    public String getRcv02() {
        return this.rcv02;
    }

    public void setRcv02(String rcv02) {
        this.rcv02 = rcv02;
    }

    public String getRcv03() {
        return this.rcv03;
    }

    public void setRcv03(String rcv03) {
        this.rcv03 = rcv03;
    }

    public String getRcv04() {
        return this.rcv04;
    }

    public void setRcv04(String rcv04) {
        this.rcv04 = rcv04;
    }

    public String getRcv05() {
        return this.rcv05;
    }

    public void setRcv05(String rcv05) {
        this.rcv05 = rcv05;
    }

    public Timestamp getSyncDate() {
        return this.syncDate;
    }

    public void setSyncDate(Timestamp syncDate) {
        this.syncDate = syncDate;
    }

    public String getSyncStat() {
        return this.syncStat;
    }

    public void setSyncStat(String syncStat) {
        this.syncStat = syncStat;
    }

    public String getAppUid() {
        return this.appUid;
    }

    public void setAppUid(String appUid) {
        this.appUid = appUid;
    }

    public String getAppStat() {
        return this.appStat;
    }

    public void setAppStat(String appStat) {
        this.appStat = appStat;
    }

    public Timestamp getAppDate() {
        return this.appDate;
    }

    public void setAppDate(Timestamp appDate) {
        this.appDate = appDate;
    }

    public String getAddUid() {
        return this.addUid;
    }

    public void setAddUid(String addUid) {
        this.addUid = addUid;
    }

    public String getAddStat() {
        return this.addStat;
    }

    public void setAddStat(String addStat) {
        this.addStat = addStat;
    }

    public Date getAddDate() {
        return this.addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getUpdUid() {
        return this.updUid;
    }

    public void setUpdUid(String updUid) {
        this.updUid = updUid;
    }

    public Timestamp getUpdDate() {
        return this.updDate;
    }

    public void setUpdDate(Timestamp updDate) {
        this.updDate = updDate;
    }

    public Short getStatus() {
        return this.status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getSkParent() {
        return this.skParent;
    }

    public void setSkParent(Integer skParent) {
        this.skParent = skParent;
    }

    public Boolean getIsShow() {
        return this.isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Long getAppSkBt() {
        return this.appSkBt;
    }

    public void setAppSkBt(Long appSkBt) {
        this.appSkBt = appSkBt;
    }

    public Boolean getIsSigned() {
        return this.isSigned;
    }

    public void setIsSigned(Boolean isSigned) {
        this.isSigned = isSigned;
    }

    public Timestamp getExpiredDate() {
        return this.expiredDate;
    }

    public void setExpiredDate(Timestamp expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getDokumen() {
        return this.dokumen;
    }

    public void setDokumen(String dokumen) {
        this.dokumen = dokumen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetSkrequestApprovedListResponse)) return false;
        final GetSkrequestApprovedListResponse getSkrequestApprovedListResponse = (GetSkrequestApprovedListResponse) o;
        return Objects.equals(getNumber(), getSkrequestApprovedListResponse.getNumber()) &&
                Objects.equals(getName(), getSkrequestApprovedListResponse.getName()) &&
                Objects.equals(getNoSr(), getSkrequestApprovedListResponse.getNoSr()) &&
                Objects.equals(getNoAggr(), getSkrequestApprovedListResponse.getNoAggr()) &&
                Objects.equals(getNoPolice(), getSkrequestApprovedListResponse.getNoPolice()) &&
                Objects.equals(getNoSpColl(), getSkrequestApprovedListResponse.getNoSpColl()) &&
                Objects.equals(getCollCd(), getSkrequestApprovedListResponse.getCollCd()) &&
                Objects.equals(getReqSkBt(), getSkrequestApprovedListResponse.getReqSkBt()) &&
                Objects.equals(getReqSkDate(), getSkrequestApprovedListResponse.getReqSkDate()) &&
                Objects.equals(getFlagSk(), getSkrequestApprovedListResponse.getFlagSk()) &&
                Objects.equals(getFlagEcontract(), getSkrequestApprovedListResponse.getFlagEcontract()) &&
                Objects.equals(getFlagFidusia(), getSkrequestApprovedListResponse.getFlagFidusia()) &&
                Objects.equals(getFlagTrnschedule(), getSkrequestApprovedListResponse.getFlagTrnschedule()) &&
                Objects.equals(getFlagDigisign(), getSkrequestApprovedListResponse.getFlagDigisign()) &&
                Objects.equals(getRcv01(), getSkrequestApprovedListResponse.getRcv01()) &&
                Objects.equals(getRcv02(), getSkrequestApprovedListResponse.getRcv02()) &&
                Objects.equals(getRcv03(), getSkrequestApprovedListResponse.getRcv03()) &&
                Objects.equals(getRcv04(), getSkrequestApprovedListResponse.getRcv04()) &&
                Objects.equals(getRcv05(), getSkrequestApprovedListResponse.getRcv05()) &&
                Objects.equals(getSyncDate(), getSkrequestApprovedListResponse.getSyncDate()) &&
                Objects.equals(getSyncStat(), getSkrequestApprovedListResponse.getSyncStat()) &&
                Objects.equals(getAppUid(), getSkrequestApprovedListResponse.getAppUid()) &&
                Objects.equals(getAppStat(), getSkrequestApprovedListResponse.getAppStat()) &&
                Objects.equals(getAppDate(), getSkrequestApprovedListResponse.getAppDate()) &&
                Objects.equals(getAddUid(), getSkrequestApprovedListResponse.getAddUid()) &&
                Objects.equals(getAddStat(), getSkrequestApprovedListResponse.getAddStat()) &&
                Objects.equals(getAddDate(), getSkrequestApprovedListResponse.getAddDate()) &&
                Objects.equals(getUpdUid(), getSkrequestApprovedListResponse.getUpdUid()) &&
                Objects.equals(getUpdDate(), getSkrequestApprovedListResponse.getUpdDate()) &&
                Objects.equals(getStatus(), getSkrequestApprovedListResponse.getStatus()) &&
                Objects.equals(getSkParent(), getSkrequestApprovedListResponse.getSkParent()) &&
                Objects.equals(getIsShow(), getSkrequestApprovedListResponse.getIsShow()) &&
                Objects.equals(getAppSkBt(), getSkrequestApprovedListResponse.getAppSkBt()) &&
                Objects.equals(getIsSigned(), getSkrequestApprovedListResponse.getIsSigned()) &&
                Objects.equals(getExpiredDate(), getSkrequestApprovedListResponse.getExpiredDate()) &&
                Objects.equals(getDokumen(), getSkrequestApprovedListResponse.getDokumen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(),
                getName(),
                getNoSr(),
                getNoAggr(),
                getNoPolice(),
                getNoSpColl(),
                getCollCd(),
                getReqSkBt(),
                getReqSkDate(),
                getFlagSk(),
                getFlagEcontract(),
                getFlagFidusia(),
                getFlagTrnschedule(),
                getFlagDigisign(),
                getRcv01(),
                getRcv02(),
                getRcv03(),
                getRcv04(),
                getRcv05(),
                getSyncDate(),
                getSyncStat(),
                getAppUid(),
                getAppStat(),
                getAppDate(),
                getAddUid(),
                getAddStat(),
                getAddDate(),
                getUpdUid(),
                getUpdDate(),
                getStatus(),
                getSkParent(),
                getIsShow(),
                getAppSkBt(),
                getIsSigned(),
                getExpiredDate(),
                getDokumen());
    }
}