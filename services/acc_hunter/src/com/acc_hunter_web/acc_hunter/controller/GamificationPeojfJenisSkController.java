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

import com.acc_hunter_web.acc_hunter.GamificationPeojfJenisSk;
import com.acc_hunter_web.acc_hunter.service.GamificationPeojfJenisSkService;


/**
 * Controller object for domain model class GamificationPeojfJenisSk.
 * @see GamificationPeojfJenisSk
 */
@RestController("acc_hunter.GamificationPeojfJenisSkController")
@Api(value = "GamificationPeojfJenisSkController", description = "Exposes APIs to work with GamificationPeojfJenisSk resource.")
@RequestMapping("/acc_hunter/GamificationPeojfJenisSk")
public class GamificationPeojfJenisSkController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GamificationPeojfJenisSkController.class);

    @Autowired
	@Qualifier("acc_hunter.GamificationPeojfJenisSkService")
	private GamificationPeojfJenisSkService gamificationPeojfJenisSkService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new GamificationPeojfJenisSk instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GamificationPeojfJenisSk createGamificationPeojfJenisSk(@RequestBody GamificationPeojfJenisSk gamificationPeojfJenisSk) {
		LOGGER.debug("Create GamificationPeojfJenisSk with information: {}" , gamificationPeojfJenisSk);

		gamificationPeojfJenisSk = gamificationPeojfJenisSkService.create(gamificationPeojfJenisSk);
		LOGGER.debug("Created GamificationPeojfJenisSk with information: {}" , gamificationPeojfJenisSk);

	    return gamificationPeojfJenisSk;
	}

    @ApiOperation(value = "Returns the GamificationPeojfJenisSk instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GamificationPeojfJenisSk getGamificationPeojfJenisSk(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting GamificationPeojfJenisSk with id: {}" , id);

        GamificationPeojfJenisSk foundGamificationPeojfJenisSk = gamificationPeojfJenisSkService.getById(id);
        LOGGER.debug("GamificationPeojfJenisSk details with id: {}" , foundGamificationPeojfJenisSk);

        return foundGamificationPeojfJenisSk;
    }

    @ApiOperation(value = "Updates the GamificationPeojfJenisSk instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GamificationPeojfJenisSk editGamificationPeojfJenisSk(@PathVariable("id") Integer id, @RequestBody GamificationPeojfJenisSk gamificationPeojfJenisSk) {
        LOGGER.debug("Editing GamificationPeojfJenisSk with id: {}" , gamificationPeojfJenisSk.getId());

        gamificationPeojfJenisSk.setId(id);
        gamificationPeojfJenisSk = gamificationPeojfJenisSkService.update(gamificationPeojfJenisSk);
        LOGGER.debug("GamificationPeojfJenisSk details with id: {}" , gamificationPeojfJenisSk);

        return gamificationPeojfJenisSk;
    }
    
    @ApiOperation(value = "Partially updates the GamificationPeojfJenisSk instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GamificationPeojfJenisSk patchGamificationPeojfJenisSk(@PathVariable("id") Integer id, @RequestBody @MapTo(GamificationPeojfJenisSk.class) Map<String, Object> gamificationPeojfJenisSkPatch) {
        LOGGER.debug("Partially updating GamificationPeojfJenisSk with id: {}" , id);

        GamificationPeojfJenisSk gamificationPeojfJenisSk = gamificationPeojfJenisSkService.partialUpdate(id, gamificationPeojfJenisSkPatch);
        LOGGER.debug("GamificationPeojfJenisSk details after partial update: {}" , gamificationPeojfJenisSk);

        return gamificationPeojfJenisSk;
    }

    @ApiOperation(value = "Deletes the GamificationPeojfJenisSk instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteGamificationPeojfJenisSk(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting GamificationPeojfJenisSk with id: {}" , id);

        GamificationPeojfJenisSk deletedGamificationPeojfJenisSk = gamificationPeojfJenisSkService.delete(id);

        return deletedGamificationPeojfJenisSk != null;
    }

    /**
     * @deprecated Use {@link #findGamificationPeojfJenisSks(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of GamificationPeojfJenisSk instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<GamificationPeojfJenisSk> searchGamificationPeojfJenisSksByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering GamificationPeojfJenisSks list by query filter:{}", (Object) queryFilters);
        return gamificationPeojfJenisSkService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of GamificationPeojfJenisSk instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<GamificationPeojfJenisSk> findGamificationPeojfJenisSks(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering GamificationPeojfJenisSks list by filter:", query);
        return gamificationPeojfJenisSkService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of GamificationPeojfJenisSk instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<GamificationPeojfJenisSk> filterGamificationPeojfJenisSks(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering GamificationPeojfJenisSks list by filter", query);
        return gamificationPeojfJenisSkService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportGamificationPeojfJenisSks(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return gamificationPeojfJenisSkService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportGamificationPeojfJenisSksAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = GamificationPeojfJenisSk.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> gamificationPeojfJenisSkService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of GamificationPeojfJenisSk instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countGamificationPeojfJenisSks( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting GamificationPeojfJenisSks");
		return gamificationPeojfJenisSkService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getGamificationPeojfJenisSkAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return gamificationPeojfJenisSkService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service GamificationPeojfJenisSkService instance
	 */
	protected void setGamificationPeojfJenisSkService(GamificationPeojfJenisSkService service) {
		this.gamificationPeojfJenisSkService = service;
	}

}