/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetDetailLaporanByAgreementNoResponse implements Serializable {


    @ColumnAlias("id_lapor")
    private Integer idLapor;

    @ColumnAlias("id_pelapor")
    private Integer idPelapor;

    @ColumnAlias("deskripsi")
    private String deskripsi;

    @ColumnAlias("vehicle_no_aggr")
    private String vehicleNoAggr;

    public Integer getIdLapor() {
        return this.idLapor;
    }

    public void setIdLapor(Integer idLapor) {
        this.idLapor = idLapor;
    }

    public Integer getIdPelapor() {
        return this.idPelapor;
    }

    public void setIdPelapor(Integer idPelapor) {
        this.idPelapor = idPelapor;
    }

    public String getDeskripsi() {
        return this.deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getVehicleNoAggr() {
        return this.vehicleNoAggr;
    }

    public void setVehicleNoAggr(String vehicleNoAggr) {
        this.vehicleNoAggr = vehicleNoAggr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetDetailLaporanByAgreementNoResponse)) return false;
        final GetDetailLaporanByAgreementNoResponse getDetailLaporanByAgreementNoResponse = (GetDetailLaporanByAgreementNoResponse) o;
        return Objects.equals(getIdLapor(), getDetailLaporanByAgreementNoResponse.getIdLapor()) &&
                Objects.equals(getIdPelapor(), getDetailLaporanByAgreementNoResponse.getIdPelapor()) &&
                Objects.equals(getDeskripsi(), getDetailLaporanByAgreementNoResponse.getDeskripsi()) &&
                Objects.equals(getVehicleNoAggr(), getDetailLaporanByAgreementNoResponse.getVehicleNoAggr());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdLapor(),
                getIdPelapor(),
                getDeskripsi(),
                getVehicleNoAggr());
    }
}