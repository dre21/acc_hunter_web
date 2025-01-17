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

import com.acc_hunter_web.acc_hunter.UserPoint;


/**
 * ServiceImpl object for domain model class UserPoint.
 *
 * @see UserPoint
 */
@Service("acc_hunter.UserPointService")
@Validated
public class UserPointServiceImpl implements UserPointService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPointServiceImpl.class);


    @Autowired
    @Qualifier("acc_hunter.UserPointDao")
    private WMGenericDao<UserPoint, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<UserPoint, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public UserPoint create(UserPoint userPoint) {
        LOGGER.debug("Creating a new UserPoint with information: {}", userPoint);

        UserPoint userPointCreated = this.wmGenericDao.create(userPoint);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(userPointCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public UserPoint getById(Integer userpointId) {
        LOGGER.debug("Finding UserPoint by id: {}", userpointId);
        return this.wmGenericDao.findById(userpointId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public UserPoint findById(Integer userpointId) {
        LOGGER.debug("Finding UserPoint by id: {}", userpointId);
        try {
            return this.wmGenericDao.findById(userpointId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No UserPoint found with id: {}", userpointId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<UserPoint> findByMultipleIds(List<Integer> userpointIds, boolean orderedReturn) {
        LOGGER.debug("Finding UserPoints by ids: {}", userpointIds);

        return this.wmGenericDao.findByMultipleIds(userpointIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public UserPoint update(UserPoint userPoint) {
        LOGGER.debug("Updating UserPoint with information: {}", userPoint);

        this.wmGenericDao.update(userPoint);
        this.wmGenericDao.refresh(userPoint);

        return userPoint;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public UserPoint partialUpdate(Integer userpointId, Map<String, Object>userPointPatch) {
        LOGGER.debug("Partially Updating the UserPoint with id: {}", userpointId);

        UserPoint userPoint = getById(userpointId);

        try {
            ObjectReader userPointReader = this.objectMapper.reader().forType(UserPoint.class).withValueToUpdate(userPoint);
            userPoint = userPointReader.readValue(this.objectMapper.writeValueAsString(userPointPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", userPointPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        userPoint = update(userPoint);

        return userPoint;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public UserPoint delete(Integer userpointId) {
        LOGGER.debug("Deleting UserPoint with id: {}", userpointId);
        UserPoint deleted = this.wmGenericDao.findById(userpointId);
        if (deleted == null) {
            LOGGER.debug("No UserPoint found with id: {}", userpointId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), UserPoint.class.getSimpleName(), userpointId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(UserPoint userPoint) {
        LOGGER.debug("Deleting UserPoint with {}", userPoint);
        this.wmGenericDao.delete(userPoint);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<UserPoint> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all UserPoints");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<UserPoint> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all UserPoints");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table UserPoint to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table UserPoint to {} format", options.getExportType());
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