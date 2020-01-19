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

import com.acc_hunter_web.acc_hunter.Branches;


/**
 * ServiceImpl object for domain model class Branches.
 *
 * @see Branches
 */
@Service("acc_hunter.BranchesService")
@Validated
public class BranchesServiceImpl implements BranchesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BranchesServiceImpl.class);


    @Autowired
    @Qualifier("acc_hunter.BranchesDao")
    private WMGenericDao<Branches, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<Branches, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public Branches create(Branches branches) {
        LOGGER.debug("Creating a new Branches with information: {}", branches);

        Branches branchesCreated = this.wmGenericDao.create(branches);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(branchesCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Branches getById(Integer branchesId) {
        LOGGER.debug("Finding Branches by id: {}", branchesId);
        return this.wmGenericDao.findById(branchesId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Branches findById(Integer branchesId) {
        LOGGER.debug("Finding Branches by id: {}", branchesId);
        try {
            return this.wmGenericDao.findById(branchesId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Branches found with id: {}", branchesId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<Branches> findByMultipleIds(List<Integer> branchesIds, boolean orderedReturn) {
        LOGGER.debug("Finding Branches by ids: {}", branchesIds);

        return this.wmGenericDao.findByMultipleIds(branchesIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public Branches update(Branches branches) {
        LOGGER.debug("Updating Branches with information: {}", branches);

        this.wmGenericDao.update(branches);
        this.wmGenericDao.refresh(branches);

        return branches;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public Branches partialUpdate(Integer branchesId, Map<String, Object>branchesPatch) {
        LOGGER.debug("Partially Updating the Branches with id: {}", branchesId);

        Branches branches = getById(branchesId);

        try {
            ObjectReader branchesReader = this.objectMapper.reader().forType(Branches.class).withValueToUpdate(branches);
            branches = branchesReader.readValue(this.objectMapper.writeValueAsString(branchesPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", branchesPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        branches = update(branches);

        return branches;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public Branches delete(Integer branchesId) {
        LOGGER.debug("Deleting Branches with id: {}", branchesId);
        Branches deleted = this.wmGenericDao.findById(branchesId);
        if (deleted == null) {
            LOGGER.debug("No Branches found with id: {}", branchesId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Branches.class.getSimpleName(), branchesId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(Branches branches) {
        LOGGER.debug("Deleting Branches with {}", branches);
        this.wmGenericDao.delete(branches);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<Branches> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Branches");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<Branches> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Branches");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table Branches to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table Branches to {} format", options.getExportType());
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