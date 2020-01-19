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

public class UpdateRoleUsersRequest implements Serializable {


    @JsonProperty("roleId")
    @NotNull
    private Integer roleId;

    @JsonProperty("id")
    @NotNull
    private Integer id;

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
        if (!(o instanceof UpdateRoleUsersRequest)) return false;
        final UpdateRoleUsersRequest updateRoleUsersRequest = (UpdateRoleUsersRequest) o;
        return Objects.equals(getRoleId(), updateRoleUsersRequest.getRoleId()) &&
                Objects.equals(getId(), updateRoleUsersRequest.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleId(),
                getId());
    }
}