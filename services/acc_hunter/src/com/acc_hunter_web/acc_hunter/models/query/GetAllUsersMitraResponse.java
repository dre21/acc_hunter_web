/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetAllUsersMitraResponse implements Serializable {


    @ColumnAlias("name")
    private String name;

    @ColumnAlias("email")
    private String email;

    @ColumnAlias("role_type")
    private String roleType;

    @ColumnAlias("province")
    private String province;

    @ColumnAlias("city")
    private String city;

    @ColumnAlias("status")
    private String status;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleType() {
        return this.roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllUsersMitraResponse)) return false;
        final GetAllUsersMitraResponse getAllUsersMitraResponse = (GetAllUsersMitraResponse) o;
        return Objects.equals(getName(), getAllUsersMitraResponse.getName()) &&
                Objects.equals(getEmail(), getAllUsersMitraResponse.getEmail()) &&
                Objects.equals(getRoleType(), getAllUsersMitraResponse.getRoleType()) &&
                Objects.equals(getProvince(), getAllUsersMitraResponse.getProvince()) &&
                Objects.equals(getCity(), getAllUsersMitraResponse.getCity()) &&
                Objects.equals(getStatus(), getAllUsersMitraResponse.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),
                getEmail(),
                getRoleType(),
                getProvince(),
                getCity(),
                getStatus());
    }
}