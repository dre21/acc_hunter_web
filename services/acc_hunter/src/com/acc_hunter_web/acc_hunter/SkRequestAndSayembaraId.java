/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class SkRequestAndSayembaraId implements Serializable {

    private String noAggr;
    private String collCd;
    private LocalDateTime reqSkDate;

    public String getNoAggr() {
        return this.noAggr;
    }

    public void setNoAggr(String noAggr) {
        this.noAggr = noAggr;
    }

    public String getCollCd() {
        return this.collCd;
    }

    public void setCollCd(String collCd) {
        this.collCd = collCd;
    }

    public LocalDateTime getReqSkDate() {
        return this.reqSkDate;
    }

    public void setReqSkDate(LocalDateTime reqSkDate) {
        this.reqSkDate = reqSkDate;
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