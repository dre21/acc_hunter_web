/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Users generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`users`", uniqueConstraints = {
            @UniqueConstraint(name = "`users_email_key`", columnNames = {"`email`"}),
            @UniqueConstraint(name = "`users_phone_number_key`", columnNames = {"`phone_number`"}),
            @UniqueConstraint(name = "`users_identity_number_key`", columnNames = {"`identity_number`"})})
public class Users implements Serializable {

    private Integer id;
    private String email;
    private String password;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String identityNumber;
    private String identityPhoto;
    private String identityWithPersonPhoto;
    private int roleId;
    private LocalDateTime createdAt;
    private Boolean resetPassFirstLogin;
    private Boolean isRequestUpgrade;
    private Boolean isRequestApproved;
    private Boolean status;
    private String province;
    private String city;
    private String mitraId;
    private Integer categoryId;
    private Integer areaId;
    private MasterArea masterArea;
    private Roles roles;
    private UserCategories userCategories;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`users_id_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`email`", nullable = false, length = 50)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "`password`", nullable = false, length = 2147483647)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "`full_name`", nullable = false, length = 50)
    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "`address`", nullable = false, length = 2147483647)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "`phone_number`", nullable = false, length = 20)
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "`identity_number`", nullable = false, length = 20)
    public String getIdentityNumber() {
        return this.identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    @Column(name = "`identity_photo`", nullable = true, length = 2147483647)
    public String getIdentityPhoto() {
        return this.identityPhoto;
    }

    public void setIdentityPhoto(String identityPhoto) {
        this.identityPhoto = identityPhoto;
    }

    @Column(name = "`identity_with_person_photo`", nullable = true, length = 2147483647)
    public String getIdentityWithPersonPhoto() {
        return this.identityWithPersonPhoto;
    }

    public void setIdentityWithPersonPhoto(String identityWithPersonPhoto) {
        this.identityWithPersonPhoto = identityWithPersonPhoto;
    }

    @Column(name = "`role_id`", nullable = false, scale = 0, precision = 10)
    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Column(name = "`created_at`", nullable = false)
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "`reset_pass_first_login`", nullable = true)
    public Boolean getResetPassFirstLogin() {
        return this.resetPassFirstLogin;
    }

    public void setResetPassFirstLogin(Boolean resetPassFirstLogin) {
        this.resetPassFirstLogin = resetPassFirstLogin;
    }

    @Column(name = "`is_request_upgrade`", nullable = true)
    public Boolean getIsRequestUpgrade() {
        return this.isRequestUpgrade;
    }

    public void setIsRequestUpgrade(Boolean isRequestUpgrade) {
        this.isRequestUpgrade = isRequestUpgrade;
    }

    @Column(name = "`is_request_approved`", nullable = true)
    public Boolean getIsRequestApproved() {
        return this.isRequestApproved;
    }

    public void setIsRequestApproved(Boolean isRequestApproved) {
        this.isRequestApproved = isRequestApproved;
    }

    @Column(name = "`status`", nullable = true)
    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Column(name = "`province`", nullable = true, length = 255)
    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Column(name = "`city`", nullable = true, length = 255)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "`mitra_id`", nullable = true, length = 255)
    public String getMitraId() {
        return this.mitraId;
    }

    public void setMitraId(String mitraId) {
        this.mitraId = mitraId;
    }

    @Column(name = "`category_id`", nullable = true, scale = 0, precision = 10)
    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "`area_id`", nullable = true, scale = 0, precision = 10)
    public Integer getAreaId() {
        return this.areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`area_id`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_users_TO_master_area_tJUeB`"))
    @Fetch(FetchMode.JOIN)
    public MasterArea getMasterArea() {
        return this.masterArea;
    }

    public void setMasterArea(MasterArea masterArea) {
        if(masterArea != null) {
            this.areaId = masterArea.getId();
        }

        this.masterArea = masterArea;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`role_id`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_users_TO_roles_role_id_id`"))
    @Fetch(FetchMode.JOIN)
    public Roles getRoles() {
        return this.roles;
    }

    public void setRoles(Roles roles) {
        if(roles != null) {
            this.roleId = roles.getId();
        }

        this.roles = roles;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`category_id`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_users_TO_user_categorsKUW6`"))
    @Fetch(FetchMode.JOIN)
    public UserCategories getUserCategories() {
        return this.userCategories;
    }

    public void setUserCategories(UserCategories userCategories) {
        if(userCategories != null) {
            this.categoryId = userCategories.getId();
        }

        this.userCategories = userCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        final Users users = (Users) o;
        return Objects.equals(getId(), users.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}