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

import com.acc_hunter_web.acc_hunter.LelangSk;
import com.acc_hunter_web.acc_hunter.MasterArea;
import com.acc_hunter_web.acc_hunter.Users;


/**
 * ServiceImpl object for domain model class MasterArea.
 *
 * @see MasterArea
 */
@Service("acc_hunter.MasterAreaService")
@Validated
public class MasterAreaServiceImpl implements MasterAreaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MasterAreaServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("acc_hunter.UsersService")
    private UsersService usersService;

    @Lazy
    @Autowired
    @Qualifier("acc_hunter.LelangSkService")
    private LelangSkService lelangSkService;

    @Autowired
    @Qualifier("acc_hunter.MasterAreaDao")
    private WMGenericDao<MasterArea, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<MasterArea, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public MasterArea create(MasterArea masterArea) {
        LOGGER.debug("Creating a new MasterArea with information: {}", masterArea);

        MasterArea masterAreaCreated = this.wmGenericDao.create(masterArea);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(masterAreaCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public MasterArea getById(Integer masterareaId) {
        LOGGER.debug("Finding MasterArea by id: {}", masterareaId);
        return this.wmGenericDao.findById(masterareaId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public MasterArea findById(Integer masterareaId) {
        LOGGER.debug("Finding MasterArea by id: {}", masterareaId);
        try {
            return this.wmGenericDao.findById(masterareaId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No MasterArea found with id: {}", masterareaId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<MasterArea> findByMultipleIds(List<Integer> masterareaIds, boolean orderedReturn) {
        LOGGER.debug("Finding MasterAreas by ids: {}", masterareaIds);

        return this.wmGenericDao.findByMultipleIds(masterareaIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public MasterArea getByAreaCode(String areaCode) {
        Map<String, Object> areaCodeMap = new HashMap<>();
        areaCodeMap.put("areaCode", areaCode);

        LOGGER.debug("Finding MasterArea by unique keys: {}", areaCodeMap);
        return this.wmGenericDao.findByUniqueKey(areaCodeMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public MasterArea update(MasterArea masterArea) {
        LOGGER.debug("Updating MasterArea with information: {}", masterArea);

        this.wmGenericDao.update(masterArea);
        this.wmGenericDao.refresh(masterArea);

        return masterArea;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public MasterArea partialUpdate(Integer masterareaId, Map<String, Object>masterAreaPatch) {
        LOGGER.debug("Partially Updating the MasterArea with id: {}", masterareaId);

        MasterArea masterArea = getById(masterareaId);

        try {
            ObjectReader masterAreaReader = this.objectMapper.reader().forType(MasterArea.class).withValueToUpdate(masterArea);
            masterArea = masterAreaReader.readValue(this.objectMapper.writeValueAsString(masterAreaPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", masterAreaPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        masterArea = update(masterArea);

        return masterArea;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public MasterArea delete(Integer masterareaId) {
        LOGGER.debug("Deleting MasterArea with id: {}", masterareaId);
        MasterArea deleted = this.wmGenericDao.findById(masterareaId);
        if (deleted == null) {
            LOGGER.debug("No MasterArea found with id: {}", masterareaId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), MasterArea.class.getSimpleName(), masterareaId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(MasterArea masterArea) {
        LOGGER.debug("Deleting MasterArea with {}", masterArea);
        this.wmGenericDao.delete(masterArea);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<MasterArea> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all MasterAreas");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<MasterArea> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all MasterAreas");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table MasterArea to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table MasterArea to {} format", options.getExportType());
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
    public Page<LelangSk> findAssociatedLelangSks(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated lelangSks");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("masterArea.id = '" + id + "'");

        return lelangSkService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<Users> findAssociatedUserses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated userses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("masterArea.id = '" + id + "'");

        return usersService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service UsersService instance
     */
    protected void setUsersService(UsersService service) {
        this.usersService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service LelangSkService instance
     */
    protected void setLelangSkService(LelangSkService service) {
        this.lelangSkService = service;
    }

}