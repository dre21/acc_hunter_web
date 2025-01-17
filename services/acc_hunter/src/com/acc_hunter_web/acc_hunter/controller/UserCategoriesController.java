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

import com.acc_hunter_web.acc_hunter.UserCategories;
import com.acc_hunter_web.acc_hunter.Users;
import com.acc_hunter_web.acc_hunter.service.UserCategoriesService;


/**
 * Controller object for domain model class UserCategories.
 * @see UserCategories
 */
@RestController("acc_hunter.UserCategoriesController")
@Api(value = "UserCategoriesController", description = "Exposes APIs to work with UserCategories resource.")
@RequestMapping("/acc_hunter/UserCategories")
public class UserCategoriesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCategoriesController.class);

    @Autowired
	@Qualifier("acc_hunter.UserCategoriesService")
	private UserCategoriesService userCategoriesService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new UserCategories instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UserCategories createUserCategories(@RequestBody UserCategories userCategories) {
		LOGGER.debug("Create UserCategories with information: {}" , userCategories);

		userCategories = userCategoriesService.create(userCategories);
		LOGGER.debug("Created UserCategories with information: {}" , userCategories);

	    return userCategories;
	}

    @ApiOperation(value = "Returns the UserCategories instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UserCategories getUserCategories(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting UserCategories with id: {}" , id);

        UserCategories foundUserCategories = userCategoriesService.getById(id);
        LOGGER.debug("UserCategories details with id: {}" , foundUserCategories);

        return foundUserCategories;
    }

    @ApiOperation(value = "Updates the UserCategories instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UserCategories editUserCategories(@PathVariable("id") Integer id, @RequestBody UserCategories userCategories) {
        LOGGER.debug("Editing UserCategories with id: {}" , userCategories.getId());

        userCategories.setId(id);
        userCategories = userCategoriesService.update(userCategories);
        LOGGER.debug("UserCategories details with id: {}" , userCategories);

        return userCategories;
    }
    
    @ApiOperation(value = "Partially updates the UserCategories instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UserCategories patchUserCategories(@PathVariable("id") Integer id, @RequestBody @MapTo(UserCategories.class) Map<String, Object> userCategoriesPatch) {
        LOGGER.debug("Partially updating UserCategories with id: {}" , id);

        UserCategories userCategories = userCategoriesService.partialUpdate(id, userCategoriesPatch);
        LOGGER.debug("UserCategories details after partial update: {}" , userCategories);

        return userCategories;
    }

    @ApiOperation(value = "Deletes the UserCategories instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUserCategories(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting UserCategories with id: {}" , id);

        UserCategories deletedUserCategories = userCategoriesService.delete(id);

        return deletedUserCategories != null;
    }

    /**
     * @deprecated Use {@link #findUserCategories(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of UserCategories instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<UserCategories> searchUserCategoriesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering UserCategories list by query filter:{}", (Object) queryFilters);
        return userCategoriesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UserCategories instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UserCategories> findUserCategories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UserCategories list by filter:", query);
        return userCategoriesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UserCategories instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<UserCategories> filterUserCategories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UserCategories list by filter", query);
        return userCategoriesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportUserCategories(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return userCategoriesService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportUserCategoriesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = UserCategories.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> userCategoriesService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of UserCategories instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countUserCategories( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting UserCategories");
		return userCategoriesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getUserCategoriesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return userCategoriesService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/userses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the userses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Users> findAssociatedUserses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated userses");
        return userCategoriesService.findAssociatedUserses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UserCategoriesService instance
	 */
	protected void setUserCategoriesService(UserCategoriesService service) {
		this.userCategoriesService = service;
	}

}