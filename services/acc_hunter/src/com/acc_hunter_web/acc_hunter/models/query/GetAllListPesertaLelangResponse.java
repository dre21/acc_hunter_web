/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetAllListPesertaLelangResponse implements Serializable {


    @ColumnAlias("cd_coll")
    private String cdColl;

    @ColumnAlias("full_name")
    private String fullName;

    @ColumnAlias("branch_id")
    private String branchId;

    @ColumnAlias("badge_type")
    private String badgeType;

    @ColumnAlias("area_name")
    private String areaName;

    @ColumnAlias("participant")
    private Boolean participant;

    public String getCdColl() {
        return this.cdColl;
    }

    public void setCdColl(String cdColl) {
        this.cdColl = cdColl;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBranchId() {
        return this.branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBadgeType() {
        return this.badgeType;
    }

    public void setBadgeType(String badgeType) {
        this.badgeType = badgeType;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Boolean getParticipant() {
        return this.participant;
    }

    public void setParticipant(Boolean participant) {
        this.participant = participant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllListPesertaLelangResponse)) return false;
        final GetAllListPesertaLelangResponse getAllListPesertaLelangResponse = (GetAllListPesertaLelangResponse) o;
        return Objects.equals(getCdColl(), getAllListPesertaLelangResponse.getCdColl()) &&
                Objects.equals(getFullName(), getAllListPesertaLelangResponse.getFullName()) &&
                Objects.equals(getBranchId(), getAllListPesertaLelangResponse.getBranchId()) &&
                Objects.equals(getBadgeType(), getAllListPesertaLelangResponse.getBadgeType()) &&
                Objects.equals(getAreaName(), getAllListPesertaLelangResponse.getAreaName()) &&
                Objects.equals(getParticipant(), getAllListPesertaLelangResponse.getParticipant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCdColl(),
                getFullName(),
                getBranchId(),
                getBadgeType(),
                getAreaName(),
                getParticipant());
    }
}