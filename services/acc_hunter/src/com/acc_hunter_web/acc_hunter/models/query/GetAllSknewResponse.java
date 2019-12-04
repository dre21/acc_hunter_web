/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetAllSknewResponse implements Serializable {


    @ColumnAlias("remo")
    private String remo;

    @ColumnAlias("tanggal_mulai")
    private Timestamp tanggalMulai;

    @ColumnAlias("tanggal_berakhir")
    private Timestamp tanggalBerakhir;

    public String getRemo() {
        return this.remo;
    }

    public void setRemo(String remo) {
        this.remo = remo;
    }

    public Timestamp getTanggalMulai() {
        return this.tanggalMulai;
    }

    public void setTanggalMulai(Timestamp tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Timestamp getTanggalBerakhir() {
        return this.tanggalBerakhir;
    }

    public void setTanggalBerakhir(Timestamp tanggalBerakhir) {
        this.tanggalBerakhir = tanggalBerakhir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllSknewResponse)) return false;
        final GetAllSknewResponse getAllSknewResponse = (GetAllSknewResponse) o;
        return Objects.equals(getRemo(), getAllSknewResponse.getRemo()) &&
                Objects.equals(getTanggalMulai(), getAllSknewResponse.getTanggalMulai()) &&
                Objects.equals(getTanggalBerakhir(), getAllSknewResponse.getTanggalBerakhir());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRemo(),
                getTanggalMulai(),
                getTanggalBerakhir());
    }
}