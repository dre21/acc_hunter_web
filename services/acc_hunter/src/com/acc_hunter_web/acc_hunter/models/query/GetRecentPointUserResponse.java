/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetRecentPointUserResponse implements Serializable {


    @ColumnAlias("email")
    private String email;

    @ColumnAlias("point")
    private BigDecimal point;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getPoint() {
        return this.point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetRecentPointUserResponse)) return false;
        final GetRecentPointUserResponse getRecentPointUserResponse = (GetRecentPointUserResponse) o;
        return Objects.equals(getEmail(), getRecentPointUserResponse.getEmail()) &&
                Objects.equals(getPoint(), getRecentPointUserResponse.getPoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(),
                getPoint());
    }
}