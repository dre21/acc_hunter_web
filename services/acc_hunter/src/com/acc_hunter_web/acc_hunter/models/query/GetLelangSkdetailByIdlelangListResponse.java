/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetLelangSkdetailByIdlelangListResponse implements Serializable {


    @ColumnAlias("number")
    private Integer number;

    @ColumnAlias("id")
    private Integer id;

    @ColumnAlias("agreement_no")
    private String agreementNo;

    @ColumnAlias("bto_limit")
    private Integer btoLimit;

    @ColumnAlias("lowest_bid")
    private Integer lowestBid;

    @ColumnAlias("description")
    private String description;

    @ColumnAlias("lelang_sk_id")
    private Integer lelangSkId;

    @ColumnAlias("status")
    private Boolean status;

    @ColumnAlias("remo_id")
    private Integer remoId;

    @ColumnAlias("winner_id")
    private String winnerId;

    @ColumnAlias("winner_name")
    private String winnerName;

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgreementNo() {
        return this.agreementNo;
    }

    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }

    public Integer getBtoLimit() {
        return this.btoLimit;
    }

    public void setBtoLimit(Integer btoLimit) {
        this.btoLimit = btoLimit;
    }

    public Integer getLowestBid() {
        return this.lowestBid;
    }

    public void setLowestBid(Integer lowestBid) {
        this.lowestBid = lowestBid;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLelangSkId() {
        return this.lelangSkId;
    }

    public void setLelangSkId(Integer lelangSkId) {
        this.lelangSkId = lelangSkId;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getRemoId() {
        return this.remoId;
    }

    public void setRemoId(Integer remoId) {
        this.remoId = remoId;
    }

    public String getWinnerId() {
        return this.winnerId;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId;
    }

    public String getWinnerName() {
        return this.winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetLelangSkdetailByIdlelangListResponse)) return false;
        final GetLelangSkdetailByIdlelangListResponse getLelangSkdetailByIdlelangListResponse = (GetLelangSkdetailByIdlelangListResponse) o;
        return Objects.equals(getNumber(), getLelangSkdetailByIdlelangListResponse.getNumber()) &&
                Objects.equals(getId(), getLelangSkdetailByIdlelangListResponse.getId()) &&
                Objects.equals(getAgreementNo(), getLelangSkdetailByIdlelangListResponse.getAgreementNo()) &&
                Objects.equals(getBtoLimit(), getLelangSkdetailByIdlelangListResponse.getBtoLimit()) &&
                Objects.equals(getLowestBid(), getLelangSkdetailByIdlelangListResponse.getLowestBid()) &&
                Objects.equals(getDescription(), getLelangSkdetailByIdlelangListResponse.getDescription()) &&
                Objects.equals(getLelangSkId(), getLelangSkdetailByIdlelangListResponse.getLelangSkId()) &&
                Objects.equals(getStatus(), getLelangSkdetailByIdlelangListResponse.getStatus()) &&
                Objects.equals(getRemoId(), getLelangSkdetailByIdlelangListResponse.getRemoId()) &&
                Objects.equals(getWinnerId(), getLelangSkdetailByIdlelangListResponse.getWinnerId()) &&
                Objects.equals(getWinnerName(), getLelangSkdetailByIdlelangListResponse.getWinnerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(),
                getId(),
                getAgreementNo(),
                getBtoLimit(),
                getLowestBid(),
                getDescription(),
                getLelangSkId(),
                getStatus(),
                getRemoId(),
                getWinnerId(),
                getWinnerName());
    }
}