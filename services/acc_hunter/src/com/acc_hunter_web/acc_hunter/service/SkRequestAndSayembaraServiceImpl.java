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

import com.acc_hunter_web.acc_hunter.SkRequestAndSayembara;
import com.acc_hunter_web.acc_hunter.SkRequestAndSayembaraId;


/**
 * ServiceImpl object for domain model class SkRequestAndSayembara.
 *
 * @see SkRequestAndSayembara
 */
@Service("acc_hunter.SkRequestAndSayembaraService")
@Validated
public class SkRequestAndSayembaraServiceImpl implements SkRequestAndSayembaraService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkRequestAndSayembaraServiceImpl.class);


    @Autowired
    @Qualifier("acc_hunter.SkRequestAndSayembaraDao")
    private WMGenericDao<SkRequestAndSayembara, SkRequestAndSayembaraId> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<SkRequestAndSayembara, SkRequestAndSayembaraId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public SkRequestAndSayembara create(SkRequestAndSayembara skRequestAndSayembara) {
        LOGGER.debug("Creating a new SkRequestAndSayembara with information: {}", skRequestAndSayembara);

        SkRequestAndSayembara skRequestAndSayembaraCreated = this.wmGenericDao.create(skRequestAndSayembara);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(skRequestAndSayembaraCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public SkRequestAndSayembara getById(SkRequestAndSayembaraId skrequestandsayembaraId) {
        LOGGER.debug("Finding SkRequestAndSayembara by id: {}", skrequestandsayembaraId);
        return this.wmGenericDao.findById(skrequestandsayembaraId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public SkRequestAndSayembara findById(SkRequestAndSayembaraId skrequestandsayembaraId) {
        LOGGER.debug("Finding SkRequestAndSayembara by id: {}", skrequestandsayembaraId);
        try {
            return this.wmGenericDao.findById(skrequestandsayembaraId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No SkRequestAndSayembara found with id: {}", skrequestandsayembaraId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<SkRequestAndSayembara> findByMultipleIds(List<SkRequestAndSayembaraId> skrequestandsayembaraIds, boolean orderedReturn) {
        LOGGER.debug("Finding SkRequestAndSayembaras by ids: {}", skrequestandsayembaraIds);

        return this.wmGenericDao.findByMultipleIds(skrequestandsayembaraIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public SkRequestAndSayembara getBySkFileName(String skFileName) {
        Map<String, Object> skFileNameMap = new HashMap<>();
        skFileNameMap.put("skFileName", skFileName);

        LOGGER.debug("Finding SkRequestAndSayembara by unique keys: {}", skFileNameMap);
        return this.wmGenericDao.findByUniqueKey(skFileNameMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public SkRequestAndSayembara update(SkRequestAndSayembara skRequestAndSayembara) {
        LOGGER.debug("Updating SkRequestAndSayembara with information: {}", skRequestAndSayembara);

        this.wmGenericDao.update(skRequestAndSayembara);
        this.wmGenericDao.refresh(skRequestAndSayembara);

        return skRequestAndSayembara;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public SkRequestAndSayembara partialUpdate(SkRequestAndSayembaraId skrequestandsayembaraId, Map<String, Object>skRequestAndSayembaraPatch) {
        LOGGER.debug("Partially Updating the SkRequestAndSayembara with id: {}", skrequestandsayembaraId);

        SkRequestAndSayembara skRequestAndSayembara = getById(skrequestandsayembaraId);

        try {
            ObjectReader skRequestAndSayembaraReader = this.objectMapper.reader().forType(SkRequestAndSayembara.class).withValueToUpdate(skRequestAndSayembara);
            skRequestAndSayembara = skRequestAndSayembaraReader.readValue(this.objectMapper.writeValueAsString(skRequestAndSayembaraPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", skRequestAndSayembaraPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        skRequestAndSayembara = update(skRequestAndSayembara);

        return skRequestAndSayembara;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public SkRequestAndSayembara delete(SkRequestAndSayembaraId skrequestandsayembaraId) {
        LOGGER.debug("Deleting SkRequestAndSayembara with id: {}", skrequestandsayembaraId);
        SkRequestAndSayembara deleted = this.wmGenericDao.findById(skrequestandsayembaraId);
        if (deleted == null) {
            LOGGER.debug("No SkRequestAndSayembara found with id: {}", skrequestandsayembaraId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), SkRequestAndSayembara.class.getSimpleName(), skrequestandsayembaraId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(SkRequestAndSayembara skRequestAndSayembara) {
        LOGGER.debug("Deleting SkRequestAndSayembara with {}", skRequestAndSayembara);
        this.wmGenericDao.delete(skRequestAndSayembara);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<SkRequestAndSayembara> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SkRequestAndSayembaras");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<SkRequestAndSayembara> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SkRequestAndSayembaras");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table SkRequestAndSayembara to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table SkRequestAndSayembara to {} format", options.getExportType());
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