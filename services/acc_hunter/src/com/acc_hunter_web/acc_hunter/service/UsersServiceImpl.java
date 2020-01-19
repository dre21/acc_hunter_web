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

import com.acc_hunter_web.acc_hunter.Appointments;
import com.acc_hunter_web.acc_hunter.RedeemRequest;
import com.acc_hunter_web.acc_hunter.Sayembara;
import com.acc_hunter_web.acc_hunter.SkRequests;
import com.acc_hunter_web.acc_hunter.UserRequestUpgrades;
import com.acc_hunter_web.acc_hunter.Users;


/**
 * ServiceImpl object for domain model class Users.
 *
 * @see Users
 */
@Service("acc_hunter.UsersService")
@Validated
public class UsersServiceImpl implements UsersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("acc_hunter.UserRequestUpgradesService")
    private UserRequestUpgradesService userRequestUpgradesService;

    @Lazy
    @Autowired
    @Qualifier("acc_hunter.RedeemRequestService")
    private RedeemRequestService redeemRequestService;

    @Lazy
    @Autowired
    @Qualifier("acc_hunter.AppointmentsService")
    private AppointmentsService appointmentsService;

    @Lazy
    @Autowired
    @Qualifier("acc_hunter.SayembaraService")
    private SayembaraService sayembaraService;

    @Lazy
    @Autowired
    @Qualifier("acc_hunter.SkRequestsService")
    private SkRequestsService skRequestsService;

    @Autowired
    @Qualifier("acc_hunter.UsersDao")
    private WMGenericDao<Users, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<Users, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public Users create(Users users) {
        LOGGER.debug("Creating a new Users with information: {}", users);

        Users usersCreated = this.wmGenericDao.create(users);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(usersCreated);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Users getById(Integer usersId) {
        LOGGER.debug("Finding Users by id: {}", usersId);
        return this.wmGenericDao.findById(usersId);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Users findById(Integer usersId) {
        LOGGER.debug("Finding Users by id: {}", usersId);
        try {
            return this.wmGenericDao.findById(usersId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Users found with id: {}", usersId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public List<Users> findByMultipleIds(List<Integer> usersIds, boolean orderedReturn) {
        LOGGER.debug("Finding Users by ids: {}", usersIds);

        return this.wmGenericDao.findByMultipleIds(usersIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Users getByEmail(String email) {
        Map<String, Object> emailMap = new HashMap<>();
        emailMap.put("email", email);

        LOGGER.debug("Finding Users by unique keys: {}", emailMap);
        return this.wmGenericDao.findByUniqueKey(emailMap);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Users getByPhoneNumber(String phoneNumber) {
        Map<String, Object> phoneNumberMap = new HashMap<>();
        phoneNumberMap.put("phoneNumber", phoneNumber);

        LOGGER.debug("Finding Users by unique keys: {}", phoneNumberMap);
        return this.wmGenericDao.findByUniqueKey(phoneNumberMap);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Users getByIdentityNumber(String identityNumber) {
        Map<String, Object> identityNumberMap = new HashMap<>();
        identityNumberMap.put("identityNumber", identityNumber);

        LOGGER.debug("Finding Users by unique keys: {}", identityNumberMap);
        return this.wmGenericDao.findByUniqueKey(identityNumberMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "acc_hunterTransactionManager")
    @Override
    public Users update(Users users) {
        LOGGER.debug("Updating Users with information: {}", users);

        this.wmGenericDao.update(users);
        this.wmGenericDao.refresh(users);

        return users;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public Users partialUpdate(Integer usersId, Map<String, Object>usersPatch) {
        LOGGER.debug("Partially Updating the Users with id: {}", usersId);

        Users users = getById(usersId);

        try {
            ObjectReader usersReader = this.objectMapper.reader().forType(Users.class).withValueToUpdate(users);
            users = usersReader.readValue(this.objectMapper.writeValueAsString(usersPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", usersPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        users = update(users);

        return users;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public Users delete(Integer usersId) {
        LOGGER.debug("Deleting Users with id: {}", usersId);
        Users deleted = this.wmGenericDao.findById(usersId);
        if (deleted == null) {
            LOGGER.debug("No Users found with id: {}", usersId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Users.class.getSimpleName(), usersId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "acc_hunterTransactionManager")
    @Override
    public void delete(Users users) {
        LOGGER.debug("Deleting Users with {}", users);
        this.wmGenericDao.delete(users);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<Users> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Users");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<Users> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Users");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service acc_hunter for table Users to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service acc_hunter for table Users to {} format", options.getExportType());
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
    public Page<Appointments> findAssociatedAppointmentses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated appointmentses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("users.id = '" + id + "'");

        return appointmentsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<Sayembara> findAssociatedSayembaras(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated sayembaras");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("users.id = '" + id + "'");

        return sayembaraService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<SkRequests> findAssociatedSkRequestses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated skRequestses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("users.id = '" + id + "'");

        return skRequestsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<UserRequestUpgrades> findAssociatedUserRequestUpgradeses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated userRequestUpgradeses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("users.id = '" + id + "'");

        return userRequestUpgradesService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "acc_hunterTransactionManager")
    @Override
    public Page<RedeemRequest> findAssociatedRedeemRequests(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated redeemRequests");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("users.id = '" + id + "'");

        return redeemRequestService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service UserRequestUpgradesService instance
     */
    protected void setUserRequestUpgradesService(UserRequestUpgradesService service) {
        this.userRequestUpgradesService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service RedeemRequestService instance
     */
    protected void setRedeemRequestService(RedeemRequestService service) {
        this.redeemRequestService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service AppointmentsService instance
     */
    protected void setAppointmentsService(AppointmentsService service) {
        this.appointmentsService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service SayembaraService instance
     */
    protected void setSayembaraService(SayembaraService service) {
        this.sayembaraService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service SkRequestsService instance
     */
    protected void setSkRequestsService(SkRequestsService service) {
        this.skRequestsService = service;
    }

}