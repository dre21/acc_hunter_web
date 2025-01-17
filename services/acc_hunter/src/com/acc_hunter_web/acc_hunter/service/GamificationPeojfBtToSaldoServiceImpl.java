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

import com.acc_hunter_web.acc_hunter.GamificationPeojfBtToSaldo;


/**
 * ServiceImpl object for domain model class GamificationPeojfBtToSaldo.
 *
 * @see GamificationPeojfBtToSaldo
 */
@Service("acc_hunter.GamificationPeojfBtToSaldoService")
@Validated
public class GamificationPeojfBtToSaldoServiceImpl implements GamificationPeojfBtToSaldoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GamificationPeojfBtToSaldoServiceImpl.class);


    @Autowired
    @Qualifier("acc_hunter.GamificationPeojfBtToSaldoDao")
    private WMGenericDao<GamificationPeojfBtToSaldo, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<GamificationPeojfBtToSaldo, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public GamificationPeojfBtToSaldo create(GamificationPeojfBtToSaldo gamificationPeojfBtToSaldo) {
        LOGGER.debug("Creating a new GamificationPeojfBtToSaldo with information: {}", gamificationPeojfBtToSaldo);

        GamificationPeojfBtToSaldo gamificationPeojfBtToSaldoCreated = this.wmGenericDao.create(gamificationPeojfBtToSaldo);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(gamificationPeojfBtToSaldoCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public GamificationPeojfBtToSaldo getById(Integer gamificationpeojfbttosaldoId) {
        LOGGER.debug("Finding GamificationPeojfBtToSaldo by id: {}", gamificationpeojfbttosaldoId);
        return this.wmGenericDao.findById(gamificationpeojfbttosaldoId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public GamificationPeojfBtToSaldo findById(Integer gamificationpeojfbttosaldoId) {
        LOGGER.debug("Finding GamificationPeojfBtToSaldo by id: {}", gamificationpeojfbttosaldoId);
        try {
            return this.wmGenericDao.findById(gamificationpeojfbttosaldoId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No GamificationPeojfBtToSaldo found with id: {}", gamificationpeojfbttosaldoId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<GamificationPeojfBtToSaldo> findByMultipleIds(List<Integer> gamificationpeojfbttosaldoIds, boolean orderedReturn) {
        LOGGER.debug("Finding GamificationPeojfBtToSaldos by ids: {}", gamificationpeojfbttosaldoIds);

        return this.wmGenericDao.findByMultipleIds(gamificationpeojfbttosaldoIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public GamificationPeojfBtToSaldo update(GamificationPeojfBtToSaldo gamificationPeojfBtToSaldo) {
        LOGGER.debug("Updating GamificationPeojfBtToSaldo with information: {}", gamificationPeojfBtToSaldo);

        this.wmGenericDao.update(gamificationPeojfBtToSaldo);
        this.wmGenericDao.refresh(gamificationPeojfBtToSaldo);

        return gamificationPeojfBtToSaldo;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public GamificationPeojfBtToSaldo partialUpdate(Integer gamificationpeojfbttosaldoId, Map<String, Object>gamificationPeojfBtToSaldoPatch) {
        LOGGER.debug("Partially Updating the GamificationPeojfBtToSaldo with id: {}", gamificationpeojfbttosaldoId);

        GamificationPeojfBtToSaldo gamificationPeojfBtToSaldo = getById(gamificationpeojfbttosaldoId);

        try {
            ObjectReader gamificationPeojfBtToSaldoReader = this.objectMapper.reader().forType(GamificationPeojfBtToSaldo.class).withValueToUpdate(gamificationPeojfBtToSaldo);
            gamificationPeojfBtToSaldo = gamificationPeojfBtToSaldoReader.readValue(this.objectMapper.writeValueAsString(gamificationPeojfBtToSaldoPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", gamificationPeojfBtToSaldoPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        gamificationPeojfBtToSaldo = update(gamificationPeojfBtToSaldo);

        return gamificationPeojfBtToSaldo;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public GamificationPeojfBtToSaldo delete(Integer gamificationpeojfbttosaldoId) {
        LOGGER.debug("Deleting GamificationPeojfBtToSaldo with id: {}", gamificationpeojfbttosaldoId);
        GamificationPeojfBtToSaldo deleted = this.wmGenericDao.findById(gamificationpeojfbttosaldoId);
        if (deleted == null) {
            LOGGER.debug("No GamificationPeojfBtToSaldo found with id: {}", gamificationpeojfbttosaldoId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), GamificationPeojfBtToSaldo.class.getSimpleName(), gamificationpeojfbttosaldoId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(GamificationPeojfBtToSaldo gamificationPeojfBtToSaldo) {
        LOGGER.debug("Deleting GamificationPeojfBtToSaldo with {}", gamificationPeojfBtToSaldo);
        this.wmGenericDao.delete(gamificationPeojfBtToSaldo);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<GamificationPeojfBtToSaldo> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all GamificationPeojfBtToSaldos");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<GamificationPeojfBtToSaldo> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all GamificationPeojfBtToSaldos");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table GamificationPeojfBtToSaldo to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table GamificationPeojfBtToSaldo to {} format", options.getExportType());
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