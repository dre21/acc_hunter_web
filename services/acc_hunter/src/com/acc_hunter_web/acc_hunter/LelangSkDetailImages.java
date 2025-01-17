/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * LelangSkDetailImages generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`lelang_sk_detail_images`")
public class LelangSkDetailImages implements Serializable {

    private Integer id;
    private int skListAuctionId;
    private String url;
    private LelangSkDetail lelangSkDetail;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`sk_list_auction_images_id_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`sk_list_auction_id`", nullable = false, scale = 0, precision = 10)
    public int getSkListAuctionId() {
        return this.skListAuctionId;
    }

    public void setSkListAuctionId(int skListAuctionId) {
        this.skListAuctionId = skListAuctionId;
    }

    @Column(name = "`url`", nullable = true, length = 255)
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`sk_list_auction_id`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`lelang_sk_detail_images_lelang_sk_detail_fkey`"))
    @Fetch(FetchMode.JOIN)
    public LelangSkDetail getLelangSkDetail() {
        return this.lelangSkDetail;
    }

    public void setLelangSkDetail(LelangSkDetail lelangSkDetail) {
        if(lelangSkDetail != null) {
            this.skListAuctionId = lelangSkDetail.getId();
        }

        this.lelangSkDetail = lelangSkDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LelangSkDetailImages)) return false;
        final LelangSkDetailImages lelangSkDetailImages = (LelangSkDetailImages) o;
        return Objects.equals(getId(), lelangSkDetailImages.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}