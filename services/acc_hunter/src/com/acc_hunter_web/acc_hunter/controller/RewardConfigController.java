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

import com.acc_hunter_web.acc_hunter.RedeemRequest;
import com.acc_hunter_web.acc_hunter.RewardConfig;
import com.acc_hunter_web.acc_hunter.service.RewardConfigService;


/**
 * Controller object for domain model class RewardConfig.
 * @see RewardConfig
 */
@RestController("acc_hunter.RewardConfigController")
@Api(value = "RewardConfigController", description = "Exposes APIs to work with RewardConfig resource.")
@RequestMapping("/acc_hunter/RewardConfig")
public class RewardConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RewardConfigController.class);

    @Autowired
	@Qualifier("acc_hunter.RewardConfigService")
	private RewardConfigService rewardConfigService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new RewardConfig instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RewardConfig createRewardConfig(@RequestBody RewardConfig rewardConfig) {
		LOGGER.debug("Create RewardConfig with information: {}" , rewardConfig);

		rewardConfig = rewardConfigService.create(rewardConfig);
		LOGGER.debug("Created RewardConfig with information: {}" , rewardConfig);

	    return rewardConfig;
	}

    @ApiOperation(value = "Returns the RewardConfig instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RewardConfig getRewardConfig(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting RewardConfig with id: {}" , id);

        RewardConfig foundRewardConfig = rewardConfigService.getById(id);
        LOGGER.debug("RewardConfig details with id: {}" , foundRewardConfig);

        return foundRewardConfig;
    }

    @ApiOperation(value = "Updates the RewardConfig instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RewardConfig editRewardConfig(@PathVariable("id") Integer id, @RequestBody RewardConfig rewardConfig) {
        LOGGER.debug("Editing RewardConfig with id: {}" , rewardConfig.getId());

        rewardConfig.setId(id);
        rewardConfig = rewardConfigService.update(rewardConfig);
        LOGGER.debug("RewardConfig details with id: {}" , rewardConfig);

        return rewardConfig;
    }
    
    @ApiOperation(value = "Partially updates the RewardConfig instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RewardConfig patchRewardConfig(@PathVariable("id") Integer id, @RequestBody @MapTo(RewardConfig.class) Map<String, Object> rewardConfigPatch) {
        LOGGER.debug("Partially updating RewardConfig with id: {}" , id);

        RewardConfig rewardConfig = rewardConfigService.partialUpdate(id, rewardConfigPatch);
        LOGGER.debug("RewardConfig details after partial update: {}" , rewardConfig);

        return rewardConfig;
    }

    @ApiOperation(value = "Deletes the RewardConfig instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRewardConfig(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting RewardConfig with id: {}" , id);

        RewardConfig deletedRewardConfig = rewardConfigService.delete(id);

        return deletedRewardConfig != null;
    }

    /**
     * @deprecated Use {@link #findRewardConfigs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RewardConfig instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<RewardConfig> searchRewardConfigsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RewardConfigs list by query filter:{}", (Object) queryFilters);
        return rewardConfigService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RewardConfig instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RewardConfig> findRewardConfigs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RewardConfigs list by filter:", query);
        return rewardConfigService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RewardConfig instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<RewardConfig> filterRewardConfigs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RewardConfigs list by filter", query);
        return rewardConfigService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportRewardConfigs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return rewardConfigService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportRewardConfigsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = RewardConfig.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> rewardConfigService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of RewardConfig instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countRewardConfigs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RewardConfigs");
		return rewardConfigService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getRewardConfigAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return rewardConfigService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/redeemRequests", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the redeemRequests instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RedeemRequest> findAssociatedRedeemRequests(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated redeemRequests");
        return rewardConfigService.findAssociatedRedeemRequests(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RewardConfigService instance
	 */
	protected void setRewardConfigService(RewardConfigService service) {
		this.rewardConfigService = service;
	}

}