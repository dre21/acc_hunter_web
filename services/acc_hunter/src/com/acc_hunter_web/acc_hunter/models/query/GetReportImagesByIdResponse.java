/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetReportImagesByIdResponse implements Serializable {


    @ColumnAlias("url")
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetReportImagesByIdResponse)) return false;
        final GetReportImagesByIdResponse getReportImagesByIdResponse = (GetReportImagesByIdResponse) o;
        return Objects.equals(getUrl(), getReportImagesByIdResponse.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl());
    }
}