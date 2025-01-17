/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
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

import com.acc_hunter_web.acc_hunter.Banks;


/**
 * ServiceImpl object for domain model class Banks.
 *
 * @see Banks
 */
@Service("acc_hunter.BanksService")
@Validated
public class BanksServiceImpl implements BanksService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BanksServiceImpl.class);


    @Autowired
    @Qualifier("acc_hunter.BanksDao")
    private WMGenericDao<Banks, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<Banks, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public Banks create(Banks banks) {
        LOGGER.debug("Creating a new Banks with information: {}", banks);

        Banks banksCreated = this.wmGenericDao.create(banks);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(banksCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Banks getById(Integer banksId) {
        LOGGER.debug("Finding Banks by id: {}", banksId);
        return this.wmGenericDao.findById(banksId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Banks findById(Integer banksId) {
        LOGGER.debug("Finding Banks by id: {}", banksId);
        try {
            return this.wmGenericDao.findById(banksId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Banks found with id: {}", banksId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<Banks> findByMultipleIds(List<Integer> banksIds, boolean orderedReturn) {
        LOGGER.debug("Finding Banks by ids: {}", banksIds);

        return this.wmGenericDao.findByMultipleIds(banksIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Banks getByName(String name) {
        Map<String, Object> nameMap = new HashMap<>();
        nameMap.put("name", name);

        LOGGER.debug("Finding Banks by unique keys: {}", nameMap);
        return this.wmGenericDao.findByUniqueKey(nameMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public Banks update(Banks banks) {
        LOGGER.debug("Updating Banks with information: {}", banks);

        this.wmGenericDao.update(banks);
        this.wmGenericDao.refresh(banks);

        return banks;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public Banks partialUpdate(Integer banksId, Map<String, Object>banksPatch) {
        LOGGER.debug("Partially Updating the Banks with id: {}", banksId);

        Banks banks = getById(banksId);

        try {
            ObjectReader banksReader = this.objectMapper.reader().forType(Banks.class).withValueToUpdate(banks);
            banks = banksReader.readValue(this.objectMapper.writeValueAsString(banksPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", banksPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        banks = update(banks);

        return banks;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public Banks delete(Integer banksId) {
        LOGGER.debug("Deleting Banks with id: {}", banksId);
        Banks deleted = this.wmGenericDao.findById(banksId);
        if (deleted == null) {
            LOGGER.debug("No Banks found with id: {}", banksId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Banks.class.getSimpleName(), banksId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(Banks banks) {
        LOGGER.debug("Deleting Banks with {}", banks);
        this.wmGenericDao.delete(banks);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<Banks> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Banks");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<Banks> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Banks");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table Banks to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table Banks to {} format", options.getExportType());
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