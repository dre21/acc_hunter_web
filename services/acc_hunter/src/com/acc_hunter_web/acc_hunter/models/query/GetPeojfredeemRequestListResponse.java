/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetPeojfredeemRequestListResponse implements Serializable {


    @ColumnAlias("id")
    private Integer id;

    @ColumnAlias("id_user")
    private Integer idUser;

    @ColumnAlias("full_name")
    private String fullName;

    @ColumnAlias("email")
    private String email;

    @ColumnAlias("name")
    private String name;

    @ColumnAlias("point")
    private Integer point;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoint() {
        return this.point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetPeojfredeemRequestListResponse)) return false;
        final GetPeojfredeemRequestListResponse getPeojfredeemRequestListResponse = (GetPeojfredeemRequestListResponse) o;
        return Objects.equals(getId(), getPeojfredeemRequestListResponse.getId()) &&
                Objects.equals(getIdUser(), getPeojfredeemRequestListResponse.getIdUser()) &&
                Objects.equals(getFullName(), getPeojfredeemRequestListResponse.getFullName()) &&
                Objects.equals(getEmail(), getPeojfredeemRequestListResponse.getEmail()) &&
                Objects.equals(getName(), getPeojfredeemRequestListResponse.getName()) &&
                Objects.equals(getPoint(), getPeojfredeemRequestListResponse.getPoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getIdUser(),
                getFullName(),
                getEmail(),
                getName(),
                getPoint());
    }
}