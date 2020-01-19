/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetParticipantLelangDetailResponse implements Serializable {


    @ColumnAlias("number")
    private Integer number;

    @ColumnAlias("id")
    private Integer id;

    @ColumnAlias("cd_coll")
    private String cdColl;

    @ColumnAlias("lelang_sk_detail_id")
    private Integer lelangSkDetailId;

    @ColumnAlias("bid")
    private Integer bid;

    @ColumnAlias("full_name")
    private String fullName;

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

    public String getCdColl() {
        return this.cdColl;
    }

    public void setCdColl(String cdColl) {
        this.cdColl = cdColl;
    }

    public Integer getLelangSkDetailId() {
        return this.lelangSkDetailId;
    }

    public void setLelangSkDetailId(Integer lelangSkDetailId) {
        this.lelangSkDetailId = lelangSkDetailId;
    }

    public Integer getBid() {
        return this.bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetParticipantLelangDetailResponse)) return false;
        final GetParticipantLelangDetailResponse getParticipantLelangDetailResponse = (GetParticipantLelangDetailResponse) o;
        return Objects.equals(getNumber(), getParticipantLelangDetailResponse.getNumber()) &&
                Objects.equals(getId(), getParticipantLelangDetailResponse.getId()) &&
                Objects.equals(getCdColl(), getParticipantLelangDetailResponse.getCdColl()) &&
                Objects.equals(getLelangSkDetailId(), getParticipantLelangDetailResponse.getLelangSkDetailId()) &&
                Objects.equals(getBid(), getParticipantLelangDetailResponse.getBid()) &&
                Objects.equals(getFullName(), getParticipantLelangDetailResponse.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(),
                getId(),
                getCdColl(),
                getLelangSkDetailId(),
                getBid(),
                getFullName());
    }
}