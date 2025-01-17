/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class DashboardSuratKuasaResponse implements Serializable {


    @ColumnAlias("month")
    private String month;

    @ColumnAlias("approved")
    private Long approved;

    @ColumnAlias("requested")
    private Long requested;

    @ColumnAlias("month_no")
    private BigDecimal monthNo;

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getApproved() {
        return this.approved;
    }

    public void setApproved(Long approved) {
        this.approved = approved;
    }

    public Long getRequested() {
        return this.requested;
    }

    public void setRequested(Long requested) {
        this.requested = requested;
    }

    public BigDecimal getMonthNo() {
        return this.monthNo;
    }

    public void setMonthNo(BigDecimal monthNo) {
        this.monthNo = monthNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DashboardSuratKuasaResponse)) return false;
        final DashboardSuratKuasaResponse dashboardSuratKuasaResponse = (DashboardSuratKuasaResponse) o;
        return Objects.equals(getMonth(), dashboardSuratKuasaResponse.getMonth()) &&
                Objects.equals(getApproved(), dashboardSuratKuasaResponse.getApproved()) &&
                Objects.equals(getRequested(), dashboardSuratKuasaResponse.getRequested()) &&
                Objects.equals(getMonthNo(), dashboardSuratKuasaResponse.getMonthNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMonth(),
                getApproved(),
                getRequested(),
                getMonthNo());
    }
}