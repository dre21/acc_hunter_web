/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetPesertaLelangDataResponse implements Serializable {


    @ColumnAlias("id_peserta")
    private Integer idPeserta;

    @ColumnAlias("nama_lengkap")
    private String namaLengkap;

    @ColumnAlias("kategori")
    private String kategori;

    @ColumnAlias("kode_area")
    private String kodeArea;

    @ColumnAlias("remo")
    private String remo;

    @ColumnAlias("user_id")
    private Integer userId;

    @ColumnAlias("lelang_sk_detail_id")
    private Integer lelangSkDetailId;

    @ColumnAlias("biaya")
    private Integer biaya;

    public Integer getIdPeserta() {
        return this.idPeserta;
    }

    public void setIdPeserta(Integer idPeserta) {
        this.idPeserta = idPeserta;
    }

    public String getNamaLengkap() {
        return this.namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getKategori() {
        return this.kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getKodeArea() {
        return this.kodeArea;
    }

    public void setKodeArea(String kodeArea) {
        this.kodeArea = kodeArea;
    }

    public String getRemo() {
        return this.remo;
    }

    public void setRemo(String remo) {
        this.remo = remo;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLelangSkDetailId() {
        return this.lelangSkDetailId;
    }

    public void setLelangSkDetailId(Integer lelangSkDetailId) {
        this.lelangSkDetailId = lelangSkDetailId;
    }

    public Integer getBiaya() {
        return this.biaya;
    }

    public void setBiaya(Integer biaya) {
        this.biaya = biaya;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetPesertaLelangDataResponse)) return false;
        final GetPesertaLelangDataResponse getPesertaLelangDataResponse = (GetPesertaLelangDataResponse) o;
        return Objects.equals(getIdPeserta(), getPesertaLelangDataResponse.getIdPeserta()) &&
                Objects.equals(getNamaLengkap(), getPesertaLelangDataResponse.getNamaLengkap()) &&
                Objects.equals(getKategori(), getPesertaLelangDataResponse.getKategori()) &&
                Objects.equals(getKodeArea(), getPesertaLelangDataResponse.getKodeArea()) &&
                Objects.equals(getRemo(), getPesertaLelangDataResponse.getRemo()) &&
                Objects.equals(getUserId(), getPesertaLelangDataResponse.getUserId()) &&
                Objects.equals(getLelangSkDetailId(), getPesertaLelangDataResponse.getLelangSkDetailId()) &&
                Objects.equals(getBiaya(), getPesertaLelangDataResponse.getBiaya());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPeserta(),
                getNamaLengkap(),
                getKategori(),
                getKodeArea(),
                getRemo(),
                getUserId(),
                getLelangSkDetailId(),
                getBiaya());
    }
}