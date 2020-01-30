/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetAreaListResponse implements Serializable {


    @ColumnAlias("id")
    private Integer id;

    @ColumnAlias("area_code")
    private String areaCode;

    @ColumnAlias("area_name")
    private String areaName;

    @ColumnAlias("date_added")
    private Date dateAdded;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Date getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAreaListResponse)) return false;
        final GetAreaListResponse getAreaListResponse = (GetAreaListResponse) o;
        return Objects.equals(getId(), getAreaListResponse.getId()) &&
                Objects.equals(getAreaCode(), getAreaListResponse.getAreaCode()) &&
                Objects.equals(getAreaName(), getAreaListResponse.getAreaName()) &&
                Objects.equals(getDateAdded(), getAreaListResponse.getDateAdded());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getAreaCode(),
                getAreaName(),
                getDateAdded());
    }
}