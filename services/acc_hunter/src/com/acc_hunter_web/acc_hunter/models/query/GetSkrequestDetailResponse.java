/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetSkrequestDetailResponse implements Serializable {


    @ColumnAlias("id_permintaan_sk")
    private Integer idPermintaanSk;

    @ColumnAlias("no_aggreement")
    private String noAggreement;

    @ColumnAlias("bto_request")
    private Integer btoRequest;

    @ColumnAlias("waktu")
    private Timestamp waktu;

    @ColumnAlias("status_converted")
    private String statusConverted;

    @ColumnAlias("status")
    private Boolean status;

    @ColumnAlias("nama_requestor")
    private String namaRequestor;

    public Integer getIdPermintaanSk() {
        return this.idPermintaanSk;
    }

    public void setIdPermintaanSk(Integer idPermintaanSk) {
        this.idPermintaanSk = idPermintaanSk;
    }

    public String getNoAggreement() {
        return this.noAggreement;
    }

    public void setNoAggreement(String noAggreement) {
        this.noAggreement = noAggreement;
    }

    public Integer getBtoRequest() {
        return this.btoRequest;
    }

    public void setBtoRequest(Integer btoRequest) {
        this.btoRequest = btoRequest;
    }

    public Timestamp getWaktu() {
        return this.waktu;
    }

    public void setWaktu(Timestamp waktu) {
        this.waktu = waktu;
    }

    public String getStatusConverted() {
        return this.statusConverted;
    }

    public void setStatusConverted(String statusConverted) {
        this.statusConverted = statusConverted;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNamaRequestor() {
        return this.namaRequestor;
    }

    public void setNamaRequestor(String namaRequestor) {
        this.namaRequestor = namaRequestor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetSkrequestDetailResponse)) return false;
        final GetSkrequestDetailResponse getSkrequestDetailResponse = (GetSkrequestDetailResponse) o;
        return Objects.equals(getIdPermintaanSk(), getSkrequestDetailResponse.getIdPermintaanSk()) &&
                Objects.equals(getNoAggreement(), getSkrequestDetailResponse.getNoAggreement()) &&
                Objects.equals(getBtoRequest(), getSkrequestDetailResponse.getBtoRequest()) &&
                Objects.equals(getWaktu(), getSkrequestDetailResponse.getWaktu()) &&
                Objects.equals(getStatusConverted(), getSkrequestDetailResponse.getStatusConverted()) &&
                Objects.equals(getStatus(), getSkrequestDetailResponse.getStatus()) &&
                Objects.equals(getNamaRequestor(), getSkrequestDetailResponse.getNamaRequestor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPermintaanSk(),
                getNoAggreement(),
                getBtoRequest(),
                getWaktu(),
                getStatusConverted(),
                getStatus(),
                getNamaRequestor());
    }
}