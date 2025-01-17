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

import com.acc_hunter_web.acc_hunter.RedeemRequest;


/**
 * ServiceImpl object for domain model class RedeemRequest.
 *
 * @see RedeemRequest
 */
@Service("acc_hunter.RedeemRequestService")
@Validated
public class RedeemRequestServiceImpl implements RedeemRequestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedeemRequestServiceImpl.class);


    @Autowired
    @Qualifier("acc_hunter.RedeemRequestDao")
    private WMGenericDao<RedeemRequest, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<RedeemRequest, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public RedeemRequest create(RedeemRequest redeemRequest) {
        LOGGER.debug("Creating a new RedeemRequest with information: {}", redeemRequest);

        RedeemRequest redeemRequestCreated = this.wmGenericDao.create(redeemRequest);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(redeemRequestCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public RedeemRequest getById(Integer redeemrequestId) {
        LOGGER.debug("Finding RedeemRequest by id: {}", redeemrequestId);
        return this.wmGenericDao.findById(redeemrequestId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public RedeemRequest findById(Integer redeemrequestId) {
        LOGGER.debug("Finding RedeemRequest by id: {}", redeemrequestId);
        try {
            return this.wmGenericDao.findById(redeemrequestId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No RedeemRequest found with id: {}", redeemrequestId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<RedeemRequest> findByMultipleIds(List<Integer> redeemrequestIds, boolean orderedReturn) {
        LOGGER.debug("Finding RedeemRequests by ids: {}", redeemrequestIds);

        return this.wmGenericDao.findByMultipleIds(redeemrequestIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public RedeemRequest update(RedeemRequest redeemRequest) {
        LOGGER.debug("Updating RedeemRequest with information: {}", redeemRequest);

        this.wmGenericDao.update(redeemRequest);
        this.wmGenericDao.refresh(redeemRequest);

        return redeemRequest;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public RedeemRequest partialUpdate(Integer redeemrequestId, Map<String, Object>redeemRequestPatch) {
        LOGGER.debug("Partially Updating the RedeemRequest with id: {}", redeemrequestId);

        RedeemRequest redeemRequest = getById(redeemrequestId);

        try {
            ObjectReader redeemRequestReader = this.objectMapper.reader().forType(RedeemRequest.class).withValueToUpdate(redeemRequest);
            redeemRequest = redeemRequestReader.readValue(this.objectMapper.writeValueAsString(redeemRequestPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", redeemRequestPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        redeemRequest = update(redeemRequest);

        return redeemRequest;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public RedeemRequest delete(Integer redeemrequestId) {
        LOGGER.debug("Deleting RedeemRequest with id: {}", redeemrequestId);
        RedeemRequest deleted = this.wmGenericDao.findById(redeemrequestId);
        if (deleted == null) {
            LOGGER.debug("No RedeemRequest found with id: {}", redeemrequestId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), RedeemRequest.class.getSimpleName(), redeemrequestId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(RedeemRequest redeemRequest) {
        LOGGER.debug("Deleting RedeemRequest with {}", redeemRequest);
        this.wmGenericDao.delete(redeemRequest);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<RedeemRequest> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all RedeemRequests");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<RedeemRequest> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all RedeemRequests");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table RedeemRequest to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table RedeemRequest to {} format", options.getExportType());
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