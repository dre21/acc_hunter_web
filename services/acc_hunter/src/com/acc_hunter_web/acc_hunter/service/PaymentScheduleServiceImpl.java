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

import com.acc_hunter_web.acc_hunter.PaymentSchedule;
import com.acc_hunter_web.acc_hunter.PaymentScheduleId;


/**
 * ServiceImpl object for domain model class PaymentSchedule.
 *
 * @see PaymentSchedule
 */
@Service("acc_hunter.PaymentScheduleService")
@Validated
public class PaymentScheduleServiceImpl implements PaymentScheduleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentScheduleServiceImpl.class);


    @Autowired
    @Qualifier("acc_hunter.PaymentScheduleDao")
    private WMGenericDao<PaymentSchedule, PaymentScheduleId> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<PaymentSchedule, PaymentScheduleId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public PaymentSchedule create(PaymentSchedule paymentSchedule) {
        LOGGER.debug("Creating a new PaymentSchedule with information: {}", paymentSchedule);

        PaymentSchedule paymentScheduleCreated = this.wmGenericDao.create(paymentSchedule);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(paymentScheduleCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public PaymentSchedule getById(PaymentScheduleId paymentscheduleId) {
        LOGGER.debug("Finding PaymentSchedule by id: {}", paymentscheduleId);
        return this.wmGenericDao.findById(paymentscheduleId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public PaymentSchedule findById(PaymentScheduleId paymentscheduleId) {
        LOGGER.debug("Finding PaymentSchedule by id: {}", paymentscheduleId);
        try {
            return this.wmGenericDao.findById(paymentscheduleId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No PaymentSchedule found with id: {}", paymentscheduleId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<PaymentSchedule> findByMultipleIds(List<PaymentScheduleId> paymentscheduleIds, boolean orderedReturn) {
        LOGGER.debug("Finding PaymentSchedules by ids: {}", paymentscheduleIds);

        return this.wmGenericDao.findByMultipleIds(paymentscheduleIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public PaymentSchedule update(PaymentSchedule paymentSchedule) {
        LOGGER.debug("Updating PaymentSchedule with information: {}", paymentSchedule);

        this.wmGenericDao.update(paymentSchedule);
        this.wmGenericDao.refresh(paymentSchedule);

        return paymentSchedule;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public PaymentSchedule partialUpdate(PaymentScheduleId paymentscheduleId, Map<String, Object>paymentSchedulePatch) {
        LOGGER.debug("Partially Updating the PaymentSchedule with id: {}", paymentscheduleId);

        PaymentSchedule paymentSchedule = getById(paymentscheduleId);

        try {
            ObjectReader paymentScheduleReader = this.objectMapper.reader().forType(PaymentSchedule.class).withValueToUpdate(paymentSchedule);
            paymentSchedule = paymentScheduleReader.readValue(this.objectMapper.writeValueAsString(paymentSchedulePatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", paymentSchedulePatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        paymentSchedule = update(paymentSchedule);

        return paymentSchedule;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public PaymentSchedule delete(PaymentScheduleId paymentscheduleId) {
        LOGGER.debug("Deleting PaymentSchedule with id: {}", paymentscheduleId);
        PaymentSchedule deleted = this.wmGenericDao.findById(paymentscheduleId);
        if (deleted == null) {
            LOGGER.debug("No PaymentSchedule found with id: {}", paymentscheduleId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), PaymentSchedule.class.getSimpleName(), paymentscheduleId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(PaymentSchedule paymentSchedule) {
        LOGGER.debug("Deleting PaymentSchedule with {}", paymentSchedule);
        this.wmGenericDao.delete(paymentSchedule);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<PaymentSchedule> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all PaymentSchedules");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<PaymentSchedule> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all PaymentSchedules");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table PaymentSchedule to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table PaymentSchedule to {} format", options.getExportType());
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