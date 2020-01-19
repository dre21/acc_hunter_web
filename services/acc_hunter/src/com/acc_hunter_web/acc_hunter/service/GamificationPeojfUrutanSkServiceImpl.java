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

import com.acc_hunter_web.acc_hunter.GamificationPeojfUrutanSk;


/**
 * ServiceImpl object for domain model class GamificationPeojfUrutanSk.
 *
 * @see GamificationPeojfUrutanSk
 */
@Service("acc_hunter.GamificationPeojfUrutanSkService")
@Validated
public class GamificationPeojfUrutanSkServiceImpl implements GamificationPeojfUrutanSkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GamificationPeojfUrutanSkServiceImpl.class);


    @Autowired
    @Qualifier("acc_hunter.GamificationPeojfUrutanSkDao")
    private WMGenericDao<GamificationPeojfUrutanSk, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<GamificationPeojfUrutanSk, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public GamificationPeojfUrutanSk create(GamificationPeojfUrutanSk gamificationPeojfUrutanSk) {
        LOGGER.debug("Creating a new GamificationPeojfUrutanSk with information: {}", gamificationPeojfUrutanSk);

        GamificationPeojfUrutanSk gamificationPeojfUrutanSkCreated = this.wmGenericDao.create(gamificationPeojfUrutanSk);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(gamificationPeojfUrutanSkCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public GamificationPeojfUrutanSk getById(Integer gamificationpeojfurutanskId) {
        LOGGER.debug("Finding GamificationPeojfUrutanSk by id: {}", gamificationpeojfurutanskId);
        return this.wmGenericDao.findById(gamificationpeojfurutanskId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public GamificationPeojfUrutanSk findById(Integer gamificationpeojfurutanskId) {
        LOGGER.debug("Finding GamificationPeojfUrutanSk by id: {}", gamificationpeojfurutanskId);
        try {
            return this.wmGenericDao.findById(gamificationpeojfurutanskId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No GamificationPeojfUrutanSk found with id: {}", gamificationpeojfurutanskId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<GamificationPeojfUrutanSk> findByMultipleIds(List<Integer> gamificationpeojfurutanskIds, boolean orderedReturn) {
        LOGGER.debug("Finding GamificationPeojfUrutanSks by ids: {}", gamificationpeojfurutanskIds);

        return this.wmGenericDao.findByMultipleIds(gamificationpeojfurutanskIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public GamificationPeojfUrutanSk update(GamificationPeojfUrutanSk gamificationPeojfUrutanSk) {
        LOGGER.debug("Updating GamificationPeojfUrutanSk with information: {}", gamificationPeojfUrutanSk);

        this.wmGenericDao.update(gamificationPeojfUrutanSk);
        this.wmGenericDao.refresh(gamificationPeojfUrutanSk);

        return gamificationPeojfUrutanSk;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public GamificationPeojfUrutanSk partialUpdate(Integer gamificationpeojfurutanskId, Map<String, Object>gamificationPeojfUrutanSkPatch) {
        LOGGER.debug("Partially Updating the GamificationPeojfUrutanSk with id: {}", gamificationpeojfurutanskId);

        GamificationPeojfUrutanSk gamificationPeojfUrutanSk = getById(gamificationpeojfurutanskId);

        try {
            ObjectReader gamificationPeojfUrutanSkReader = this.objectMapper.reader().forType(GamificationPeojfUrutanSk.class).withValueToUpdate(gamificationPeojfUrutanSk);
            gamificationPeojfUrutanSk = gamificationPeojfUrutanSkReader.readValue(this.objectMapper.writeValueAsString(gamificationPeojfUrutanSkPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", gamificationPeojfUrutanSkPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        gamificationPeojfUrutanSk = update(gamificationPeojfUrutanSk);

        return gamificationPeojfUrutanSk;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public GamificationPeojfUrutanSk delete(Integer gamificationpeojfurutanskId) {
        LOGGER.debug("Deleting GamificationPeojfUrutanSk with id: {}", gamificationpeojfurutanskId);
        GamificationPeojfUrutanSk deleted = this.wmGenericDao.findById(gamificationpeojfurutanskId);
        if (deleted == null) {
            LOGGER.debug("No GamificationPeojfUrutanSk found with id: {}", gamificationpeojfurutanskId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), GamificationPeojfUrutanSk.class.getSimpleName(), gamificationpeojfurutanskId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(GamificationPeojfUrutanSk gamificationPeojfUrutanSk) {
        LOGGER.debug("Deleting GamificationPeojfUrutanSk with {}", gamificationPeojfUrutanSk);
        this.wmGenericDao.delete(gamificationPeojfUrutanSk);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<GamificationPeojfUrutanSk> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all GamificationPeojfUrutanSks");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<GamificationPeojfUrutanSk> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all GamificationPeojfUrutanSks");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table GamificationPeojfUrutanSk to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table GamificationPeojfUrutanSk to {} format", options.getExportType());
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