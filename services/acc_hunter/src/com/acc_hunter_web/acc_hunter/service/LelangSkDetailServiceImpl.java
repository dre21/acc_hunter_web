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
import org.springframework.context.annotation.Lazy;
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

import com.acc_hunter_web.acc_hunter.LelangSkDetail;
import com.acc_hunter_web.acc_hunter.LelangSkDetailImages;
import com.acc_hunter_web.acc_hunter.LelangSkParticipants;


/**
 * ServiceImpl object for domain model class LelangSkDetail.
 *
 * @see LelangSkDetail
 */
@Service("acc_hunter.LelangSkDetailService")
@Validated
public class LelangSkDetailServiceImpl implements LelangSkDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LelangSkDetailServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("acc_hunter.LelangSkParticipantsService")
    private LelangSkParticipantsService lelangSkParticipantsService;

    @Lazy
    @Autowired
    @Qualifier("acc_hunter.LelangSkDetailImagesService")
    private LelangSkDetailImagesService lelangSkDetailImagesService;

    @Autowired
    @Qualifier("acc_hunter.LelangSkDetailDao")
    private WMGenericDao<LelangSkDetail, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<LelangSkDetail, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public LelangSkDetail create(LelangSkDetail lelangSkDetail) {
        LOGGER.debug("Creating a new LelangSkDetail with information: {}", lelangSkDetail);

        LelangSkDetail lelangSkDetailCreated = this.wmGenericDao.create(lelangSkDetail);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(lelangSkDetailCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public LelangSkDetail getById(Integer lelangskdetailId) {
        LOGGER.debug("Finding LelangSkDetail by id: {}", lelangskdetailId);
        return this.wmGenericDao.findById(lelangskdetailId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public LelangSkDetail findById(Integer lelangskdetailId) {
        LOGGER.debug("Finding LelangSkDetail by id: {}", lelangskdetailId);
        try {
            return this.wmGenericDao.findById(lelangskdetailId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No LelangSkDetail found with id: {}", lelangskdetailId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<LelangSkDetail> findByMultipleIds(List<Integer> lelangskdetailIds, boolean orderedReturn) {
        LOGGER.debug("Finding LelangSkDetails by ids: {}", lelangskdetailIds);

        return this.wmGenericDao.findByMultipleIds(lelangskdetailIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public LelangSkDetail getByAgreementNo(String agreementNo) {
        Map<String, Object> agreementNoMap = new HashMap<>();
        agreementNoMap.put("agreementNo", agreementNo);

        LOGGER.debug("Finding LelangSkDetail by unique keys: {}", agreementNoMap);
        return this.wmGenericDao.findByUniqueKey(agreementNoMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public LelangSkDetail update(LelangSkDetail lelangSkDetail) {
        LOGGER.debug("Updating LelangSkDetail with information: {}", lelangSkDetail);

        this.wmGenericDao.update(lelangSkDetail);
        this.wmGenericDao.refresh(lelangSkDetail);

        return lelangSkDetail;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public LelangSkDetail partialUpdate(Integer lelangskdetailId, Map<String, Object>lelangSkDetailPatch) {
        LOGGER.debug("Partially Updating the LelangSkDetail with id: {}", lelangskdetailId);

        LelangSkDetail lelangSkDetail = getById(lelangskdetailId);

        try {
            ObjectReader lelangSkDetailReader = this.objectMapper.reader().forType(LelangSkDetail.class).withValueToUpdate(lelangSkDetail);
            lelangSkDetail = lelangSkDetailReader.readValue(this.objectMapper.writeValueAsString(lelangSkDetailPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", lelangSkDetailPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        lelangSkDetail = update(lelangSkDetail);

        return lelangSkDetail;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public LelangSkDetail delete(Integer lelangskdetailId) {
        LOGGER.debug("Deleting LelangSkDetail with id: {}", lelangskdetailId);
        LelangSkDetail deleted = this.wmGenericDao.findById(lelangskdetailId);
        if (deleted == null) {
            LOGGER.debug("No LelangSkDetail found with id: {}", lelangskdetailId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), LelangSkDetail.class.getSimpleName(), lelangskdetailId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(LelangSkDetail lelangSkDetail) {
        LOGGER.debug("Deleting LelangSkDetail with {}", lelangSkDetail);
        this.wmGenericDao.delete(lelangSkDetail);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<LelangSkDetail> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all LelangSkDetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<LelangSkDetail> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all LelangSkDetails");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table LelangSkDetail to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table LelangSkDetail to {} format", options.getExportType());
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

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<LelangSkDetailImages> findAssociatedLelangSkDetailImageses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated lelangSkDetailImageses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("lelangSkDetail.id = '" + id + "'");

        return lelangSkDetailImagesService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<LelangSkParticipants> findAssociatedLelangSkParticipantses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated lelangSkParticipantses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("lelangSkDetail.id = '" + id + "'");

        return lelangSkParticipantsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service LelangSkParticipantsService instance
     */
    protected void setLelangSkParticipantsService(LelangSkParticipantsService service) {
        this.lelangSkParticipantsService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service LelangSkDetailImagesService instance
     */
    protected void setLelangSkDetailImagesService(LelangSkDetailImagesService service) {
        this.lelangSkDetailImagesService = service;
    }

}