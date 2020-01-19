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

import com.acc_hunter_web.acc_hunter.NotificationCategories;
import com.acc_hunter_web.acc_hunter.NotificationTemplates;
import com.acc_hunter_web.acc_hunter.NotificationUsers;


/**
 * ServiceImpl object for domain model class NotificationCategories.
 *
 * @see NotificationCategories
 */
@Service("acc_hunter.NotificationCategoriesService")
@Validated
public class NotificationCategoriesServiceImpl implements NotificationCategoriesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationCategoriesServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("acc_hunter.NotificationTemplatesService")
    private NotificationTemplatesService notificationTemplatesService;

    @Lazy
    @Autowired
    @Qualifier("acc_hunter.NotificationUsersService")
    private NotificationUsersService notificationUsersService;

    @Autowired
    @Qualifier("acc_hunter.NotificationCategoriesDao")
    private WMGenericDao<NotificationCategories, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<NotificationCategories, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public NotificationCategories create(NotificationCategories notificationCategories) {
        LOGGER.debug("Creating a new NotificationCategories with information: {}", notificationCategories);

        NotificationCategories notificationCategoriesCreated = this.wmGenericDao.create(notificationCategories);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(notificationCategoriesCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public NotificationCategories getById(Integer notificationcategoriesId) {
        LOGGER.debug("Finding NotificationCategories by id: {}", notificationcategoriesId);
        return this.wmGenericDao.findById(notificationcategoriesId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public NotificationCategories findById(Integer notificationcategoriesId) {
        LOGGER.debug("Finding NotificationCategories by id: {}", notificationcategoriesId);
        try {
            return this.wmGenericDao.findById(notificationcategoriesId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No NotificationCategories found with id: {}", notificationcategoriesId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<NotificationCategories> findByMultipleIds(List<Integer> notificationcategoriesIds, boolean orderedReturn) {
        LOGGER.debug("Finding NotificationCategories by ids: {}", notificationcategoriesIds);

        return this.wmGenericDao.findByMultipleIds(notificationcategoriesIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public NotificationCategories update(NotificationCategories notificationCategories) {
        LOGGER.debug("Updating NotificationCategories with information: {}", notificationCategories);

        this.wmGenericDao.update(notificationCategories);
        this.wmGenericDao.refresh(notificationCategories);

        return notificationCategories;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public NotificationCategories partialUpdate(Integer notificationcategoriesId, Map<String, Object>notificationCategoriesPatch) {
        LOGGER.debug("Partially Updating the NotificationCategories with id: {}", notificationcategoriesId);

        NotificationCategories notificationCategories = getById(notificationcategoriesId);

        try {
            ObjectReader notificationCategoriesReader = this.objectMapper.reader().forType(NotificationCategories.class).withValueToUpdate(notificationCategories);
            notificationCategories = notificationCategoriesReader.readValue(this.objectMapper.writeValueAsString(notificationCategoriesPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", notificationCategoriesPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        notificationCategories = update(notificationCategories);

        return notificationCategories;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public NotificationCategories delete(Integer notificationcategoriesId) {
        LOGGER.debug("Deleting NotificationCategories with id: {}", notificationcategoriesId);
        NotificationCategories deleted = this.wmGenericDao.findById(notificationcategoriesId);
        if (deleted == null) {
            LOGGER.debug("No NotificationCategories found with id: {}", notificationcategoriesId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), NotificationCategories.class.getSimpleName(), notificationcategoriesId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(NotificationCategories notificationCategories) {
        LOGGER.debug("Deleting NotificationCategories with {}", notificationCategories);
        this.wmGenericDao.delete(notificationCategories);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<NotificationCategories> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all NotificationCategories");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<NotificationCategories> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all NotificationCategories");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table NotificationCategories to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table NotificationCategories to {} format", options.getExportType());
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
    public Page<NotificationTemplates> findAssociatedNotificationTemplateses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated notificationTemplateses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("notificationCategories.id = '" + id + "'");

        return notificationTemplatesService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<NotificationUsers> findAssociatedNotificationUserses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated notificationUserses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("notificationCategories.id = '" + id + "'");

        return notificationUsersService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service NotificationTemplatesService instance
     */
    protected void setNotificationTemplatesService(NotificationTemplatesService service) {
        this.notificationTemplatesService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service NotificationUsersService instance
     */
    protected void setNotificationUsersService(NotificationUsersService service) {
        this.notificationUsersService = service;
    }

}