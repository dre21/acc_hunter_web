/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.wavemaker.commons.InvalidInputException;
import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.acc_hunter_web.acc_hunter.Otp;


/**
 * ServiceImpl object for domain model class Otp.
 *
 * @see Otp
 */
@Service("acc_hunter.OtpService")
@Validated
public class OtpServiceImpl implements OtpService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OtpServiceImpl.class);


    @Autowired
    @Qualifier("acc_hunter.OtpDao")
    private WMGenericDao<Otp, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<Otp, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public Otp create(Otp otpInstance) {
        LOGGER.debug("Creating a new Otp with information: {}", otpInstance);

        Otp otpInstanceCreated = this.wmGenericDao.create(otpInstance);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(otpInstanceCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Otp getById(Integer otpId) {
        LOGGER.debug("Finding Otp by id: {}", otpId);
        return this.wmGenericDao.findById(otpId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Otp findById(Integer otpId) {
        LOGGER.debug("Finding Otp by id: {}", otpId);
        try {
            return this.wmGenericDao.findById(otpId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Otp found with id: {}", otpId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<Otp> findByMultipleIds(List<Integer> otpIds, boolean orderedReturn) {
        LOGGER.debug("Finding Otps by ids: {}", otpIds);

        return this.wmGenericDao.findByMultipleIds(otpIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public Otp update(Otp otpInstance) {
        LOGGER.debug("Updating Otp with information: {}", otpInstance);

        this.wmGenericDao.update(otpInstance);
        this.wmGenericDao.refresh(otpInstance);

        return otpInstance;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public Otp partialUpdate(Integer otpId, Map<String, Object>otpInstancePatch) {
        LOGGER.debug("Partially Updating the Otp with id: {}", otpId);

        Otp otpInstance = getById(otpId);

        try {
            ObjectReader otpInstanceReader = this.objectMapper.reader().forType(Otp.class).withValueToUpdate(otpInstance);
            otpInstance = otpInstanceReader.readValue(this.objectMapper.writeValueAsString(otpInstancePatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", otpInstancePatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        otpInstance = update(otpInstance);

        return otpInstance;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public Otp delete(Integer otpId) {
        LOGGER.debug("Deleting Otp with id: {}", otpId);
        Otp deleted = this.wmGenericDao.findById(otpId);
        if (deleted == null) {
            LOGGER.debug("No Otp found with id: {}", otpId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Otp.class.getSimpleName(), otpId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(Otp otpInstance) {
        LOGGER.debug("Deleting Otp with {}", otpInstance);
        this.wmGenericDao.delete(otpInstance);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<Otp> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Otps");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<Otp> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Otps");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table Otp to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table Otp to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}