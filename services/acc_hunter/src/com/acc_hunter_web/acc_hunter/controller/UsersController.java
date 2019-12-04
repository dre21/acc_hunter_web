/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.security.xss.XssDisable;
import com.wavemaker.tools.api.core.annotations.MapTo;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.acc_hunter_web.acc_hunter.Appointments;
import com.acc_hunter_web.acc_hunter.LelangSkParticipants;
import com.acc_hunter_web.acc_hunter.SkRequests;
import com.acc_hunter_web.acc_hunter.UserRequestUpgrades;
import com.acc_hunter_web.acc_hunter.Users;
import com.acc_hunter_web.acc_hunter.service.UsersService;


/**
 * Controller object for domain model class Users.
 * @see Users
 */
@RestController("acc_hunter.UsersController")
@Api(value = "UsersController", description = "Exposes APIs to work with Users resource.")
@RequestMapping("/acc_hunter/Users")
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    @Autowired
	@Qualifier("acc_hunter.UsersService")
	private UsersService usersService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Users instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Users createUsers(@RequestBody Users users) {
		LOGGER.debug("Create Users with information: {}" , users);

		users = usersService.create(users);
		LOGGER.debug("Created Users with information: {}" , users);

	    return users;
	}

    @ApiOperation(value = "Returns the Users instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Users getUsers(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Users with id: {}" , id);

        Users foundUsers = usersService.getById(id);
        LOGGER.debug("Users details with id: {}" , foundUsers);

        return foundUsers;
    }

    @ApiOperation(value = "Updates the Users instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Users editUsers(@PathVariable("id") Integer id, @RequestBody Users users) {
        LOGGER.debug("Editing Users with id: {}" , users.getId());

        users.setId(id);
        users = usersService.update(users);
        LOGGER.debug("Users details with id: {}" , users);

        return users;
    }
    
    @ApiOperation(value = "Partially updates the Users instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Users patchUsers(@PathVariable("id") Integer id, @RequestBody @MapTo(Users.class) Map<String, Object> usersPatch) {
        LOGGER.debug("Partially updating Users with id: {}" , id);

        Users users = usersService.partialUpdate(id, usersPatch);
        LOGGER.debug("Users details after partial update: {}" , users);

        return users;
    }

    @ApiOperation(value = "Deletes the Users instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUsers(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Users with id: {}" , id);

        Users deletedUsers = usersService.delete(id);

        return deletedUsers != null;
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Users with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Users getByEmail(@PathVariable("email") String email) {
        LOGGER.debug("Getting Users with uniques key Email");
        return usersService.getByEmail(email);
    }

    @RequestMapping(value = "/phoneNumber/{phoneNumber}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Users with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Users getByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        LOGGER.debug("Getting Users with uniques key PhoneNumber");
        return usersService.getByPhoneNumber(phoneNumber);
    }

    @RequestMapping(value = "/identityNumber/{identityNumber}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Users with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Users getByIdentityNumber(@PathVariable("identityNumber") String identityNumber) {
        LOGGER.debug("Getting Users with uniques key IdentityNumber");
        return usersService.getByIdentityNumber(identityNumber);
    }

    /**
     * @deprecated Use {@link #findUsers(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Users instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<Users> searchUsersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Users list by query filter:{}", (Object) queryFilters);
        return usersService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Users instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Users> findUsers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Users list by filter:", query);
        return usersService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Users instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<Users> filterUsers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Users list by filter", query);
        return usersService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportUsers(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return usersService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportUsersAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Users.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> usersService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Users instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countUsers( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Users");
		return usersService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getUsersAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return usersService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/appointmentses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the appointmentses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Appointments> findAssociatedAppointmentses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated appointmentses");
        return usersService.findAssociatedAppointmentses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/lelangSkParticipantses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the lelangSkParticipantses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LelangSkParticipants> findAssociatedLelangSkParticipantses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated lelangSkParticipantses");
        return usersService.findAssociatedLelangSkParticipantses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/skRequestses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the skRequestses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SkRequests> findAssociatedSkRequestses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated skRequestses");
        return usersService.findAssociatedSkRequestses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/userRequestUpgradeses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the userRequestUpgradeses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UserRequestUpgrades> findAssociatedUserRequestUpgradeses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated userRequestUpgradeses");
        return usersService.findAssociatedUserRequestUpgradeses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UsersService instance
	 */
	protected void setUsersService(UsersService service) {
		this.usersService = service;
	}

}