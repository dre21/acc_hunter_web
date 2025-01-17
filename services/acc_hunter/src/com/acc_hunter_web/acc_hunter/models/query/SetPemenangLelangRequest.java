/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SetPemenangLelangRequest implements Serializable {


    @JsonProperty("cdColl")
    @NotNull
    private String cdColl;

    @JsonProperty("winName")
    @NotNull
    private String winName;

    @JsonProperty("id")
    @NotNull
    private Integer id;

    public String getCdColl() {
        return this.cdColl;
    }

    public void setCdColl(String cdColl) {
        this.cdColl = cdColl;
    }

    public String getWinName() {
        return this.winName;
    }

    public void setWinName(String winName) {
        this.winName = winName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetPemenangLelangRequest)) return false;
        final SetPemenangLelangRequest setPemenangLelangRequest = (SetPemenangLelangRequest) o;
        return Objects.equals(getCdColl(), setPemenangLelangRequest.getCdColl()) &&
                Objects.equals(getWinName(), setPemenangLelangRequest.getWinName()) &&
                Objects.equals(getId(), setPemenangLelangRequest.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCdColl(),
                getWinName(),
                getId());
    }
}