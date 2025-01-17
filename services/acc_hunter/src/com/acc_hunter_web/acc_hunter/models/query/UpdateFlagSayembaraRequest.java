/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateFlagSayembaraRequest implements Serializable {


    @JsonProperty("digisign")
    @NotNull
    private String digisign;

    @JsonProperty("contract")
    @NotNull
    private String contract;

    @JsonProperty("schedule")
    @NotNull
    private String schedule;

    @JsonProperty("fidusia")
    @NotNull
    private String fidusia;

    @JsonProperty("noAggr")
    @NotNull
    private String noAggr;

    public String getDigisign() {
        return this.digisign;
    }

    public void setDigisign(String digisign) {
        this.digisign = digisign;
    }

    public String getContract() {
        return this.contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getSchedule() {
        return this.schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getFidusia() {
        return this.fidusia;
    }

    public void setFidusia(String fidusia) {
        this.fidusia = fidusia;
    }

    public String getNoAggr() {
        return this.noAggr;
    }

    public void setNoAggr(String noAggr) {
        this.noAggr = noAggr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateFlagSayembaraRequest)) return false;
        final UpdateFlagSayembaraRequest updateFlagSayembaraRequest = (UpdateFlagSayembaraRequest) o;
        return Objects.equals(getDigisign(), updateFlagSayembaraRequest.getDigisign()) &&
                Objects.equals(getContract(), updateFlagSayembaraRequest.getContract()) &&
                Objects.equals(getSchedule(), updateFlagSayembaraRequest.getSchedule()) &&
                Objects.equals(getFidusia(), updateFlagSayembaraRequest.getFidusia()) &&
                Objects.equals(getNoAggr(), updateFlagSayembaraRequest.getNoAggr());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDigisign(),
                getContract(),
                getSchedule(),
                getFidusia(),
                getNoAggr());
    }
}