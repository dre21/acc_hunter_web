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

import com.acc_hunter_web.acc_hunter.GamificationInformanSuksesTarik;
import com.acc_hunter_web.acc_hunter.service.GamificationInformanSuksesTarikService;


/**
 * Controller object for domain model class GamificationInformanSuksesTarik.
 * @see GamificationInformanSuksesTarik
 */
@RestController("acc_hunter.GamificationInformanSuksesTarikController")
@Api(value = "GamificationInformanSuksesTarikController", description = "Exposes APIs to work with GamificationInformanSuksesTarik resource.")
@RequestMapping("/acc_hunter/GamificationInformanSuksesTarik")
public class GamificationInformanSuksesTarikController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GamificationInformanSuksesTarikController.class);

    @Autowired
	@Qualifier("acc_hunter.GamificationInformanSuksesTarikService")
	private GamificationInformanSuksesTarikService gamificationInformanSuksesTarikService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new GamificationInformanSuksesTarik instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GamificationInformanSuksesTarik createGamificationInformanSuksesTarik(@RequestBody GamificationInformanSuksesTarik gamificationInformanSuksesTarik) {
		LOGGER.debug("Create GamificationInformanSuksesTarik with information: {}" , gamificationInformanSuksesTarik);

		gamificationInformanSuksesTarik = gamificationInformanSuksesTarikService.create(gamificationInformanSuksesTarik);
		LOGGER.debug("Created GamificationInformanSuksesTarik with information: {}" , gamificationInformanSuksesTarik);

	    return gamificationInformanSuksesTarik;
	}

    @ApiOperation(value = "Returns the GamificationInformanSuksesTarik instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GamificationInformanSuksesTarik getGamificationInformanSuksesTarik(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting GamificationInformanSuksesTarik with id: {}" , id);

        GamificationInformanSuksesTarik foundGamificationInformanSuksesTarik = gamificationInformanSuksesTarikService.getById(id);
        LOGGER.debug("GamificationInformanSuksesTarik details with id: {}" , foundGamificationInformanSuksesTarik);

        return foundGamificationInformanSuksesTarik;
    }

    @ApiOperation(value = "Updates the GamificationInformanSuksesTarik instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GamificationInformanSuksesTarik editGamificationInformanSuksesTarik(@PathVariable("id") Integer id, @RequestBody GamificationInformanSuksesTarik gamificationInformanSuksesTarik) {
        LOGGER.debug("Editing GamificationInformanSuksesTarik with id: {}" , gamificationInformanSuksesTarik.getId());

        gamificationInformanSuksesTarik.setId(id);
        gamificationInformanSuksesTarik = gamificationInformanSuksesTarikService.update(gamificationInformanSuksesTarik);
        LOGGER.debug("GamificationInformanSuksesTarik details with id: {}" , gamificationInformanSuksesTarik);

        return gamificationInformanSuksesTarik;
    }
    
    @ApiOperation(value = "Partially updates the GamificationInformanSuksesTarik instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GamificationInformanSuksesTarik patchGamificationInformanSuksesTarik(@PathVariable("id") Integer id, @RequestBody @MapTo(GamificationInformanSuksesTarik.class) Map<String, Object> gamificationInformanSuksesTarikPatch) {
        LOGGER.debug("Partially updating GamificationInformanSuksesTarik with id: {}" , id);

        GamificationInformanSuksesTarik gamificationInformanSuksesTarik = gamificationInformanSuksesTarikService.partialUpdate(id, gamificationInformanSuksesTarikPatch);
        LOGGER.debug("GamificationInformanSuksesTarik details after partial update: {}" , gamificationInformanSuksesTarik);

        return gamificationInformanSuksesTarik;
    }

    @ApiOperation(value = "Deletes the GamificationInformanSuksesTarik instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteGamificationInformanSuksesTarik(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting GamificationInformanSuksesTarik with id: {}" , id);

        GamificationInformanSuksesTarik deletedGamificationInformanSuksesTarik = gamificationInformanSuksesTarikService.delete(id);

        return deletedGamificationInformanSuksesTarik != null;
    }

    /**
     * @deprecated Use {@link #findGamificationInformanSuksesTariks(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of GamificationInformanSuksesTarik instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<GamificationInformanSuksesTarik> searchGamificationInformanSuksesTariksByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering GamificationInformanSuksesTariks list by query filter:{}", (Object) queryFilters);
        return gamificationInformanSuksesTarikService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of GamificationInformanSuksesTarik instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<GamificationInformanSuksesTarik> findGamificationInformanSuksesTariks(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering GamificationInformanSuksesTariks list by filter:", query);
        return gamificationInformanSuksesTarikService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of GamificationInformanSuksesTarik instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<GamificationInformanSuksesTarik> filterGamificationInformanSuksesTariks(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering GamificationInformanSuksesTariks list by filter", query);
        return gamificationInformanSuksesTarikService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportGamificationInformanSuksesTariks(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return gamificationInformanSuksesTarikService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportGamificationInformanSuksesTariksAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = GamificationInformanSuksesTarik.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> gamificationInformanSuksesTarikService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of GamificationInformanSuksesTarik instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countGamificationInformanSuksesTariks( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting GamificationInformanSuksesTariks");
		return gamificationInformanSuksesTarikService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getGamificationInformanSuksesTarikAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return gamificationInformanSuksesTarikService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service GamificationInformanSuksesTarikService instance
	 */
	protected void setGamificationInformanSuksesTarikService(GamificationInformanSuksesTarikService service) {
		this.gamificationInformanSuksesTarikService = service;
	}

}