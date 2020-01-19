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

import com.acc_hunter_web.acc_hunter.GamificationPeojfSaldoAr;
import com.acc_hunter_web.acc_hunter.service.GamificationPeojfSaldoArService;


/**
 * Controller object for domain model class GamificationPeojfSaldoAr.
 * @see GamificationPeojfSaldoAr
 */
@RestController("acc_hunter.GamificationPeojfSaldoArController")
@Api(value = "GamificationPeojfSaldoArController", description = "Exposes APIs to work with GamificationPeojfSaldoAr resource.")
@RequestMapping("/acc_hunter/GamificationPeojfSaldoAr")
public class GamificationPeojfSaldoArController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GamificationPeojfSaldoArController.class);

    @Autowired
	@Qualifier("acc_hunter.GamificationPeojfSaldoArService")
	private GamificationPeojfSaldoArService gamificationPeojfSaldoArService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new GamificationPeojfSaldoAr instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GamificationPeojfSaldoAr createGamificationPeojfSaldoAr(@RequestBody GamificationPeojfSaldoAr gamificationPeojfSaldoAr) {
		LOGGER.debug("Create GamificationPeojfSaldoAr with information: {}" , gamificationPeojfSaldoAr);

		gamificationPeojfSaldoAr = gamificationPeojfSaldoArService.create(gamificationPeojfSaldoAr);
		LOGGER.debug("Created GamificationPeojfSaldoAr with information: {}" , gamificationPeojfSaldoAr);

	    return gamificationPeojfSaldoAr;
	}

    @ApiOperation(value = "Returns the GamificationPeojfSaldoAr instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GamificationPeojfSaldoAr getGamificationPeojfSaldoAr(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting GamificationPeojfSaldoAr with id: {}" , id);

        GamificationPeojfSaldoAr foundGamificationPeojfSaldoAr = gamificationPeojfSaldoArService.getById(id);
        LOGGER.debug("GamificationPeojfSaldoAr details with id: {}" , foundGamificationPeojfSaldoAr);

        return foundGamificationPeojfSaldoAr;
    }

    @ApiOperation(value = "Updates the GamificationPeojfSaldoAr instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GamificationPeojfSaldoAr editGamificationPeojfSaldoAr(@PathVariable("id") Integer id, @RequestBody GamificationPeojfSaldoAr gamificationPeojfSaldoAr) {
        LOGGER.debug("Editing GamificationPeojfSaldoAr with id: {}" , gamificationPeojfSaldoAr.getId());

        gamificationPeojfSaldoAr.setId(id);
        gamificationPeojfSaldoAr = gamificationPeojfSaldoArService.update(gamificationPeojfSaldoAr);
        LOGGER.debug("GamificationPeojfSaldoAr details with id: {}" , gamificationPeojfSaldoAr);

        return gamificationPeojfSaldoAr;
    }
    
    @ApiOperation(value = "Partially updates the GamificationPeojfSaldoAr instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public GamificationPeojfSaldoAr patchGamificationPeojfSaldoAr(@PathVariable("id") Integer id, @RequestBody @MapTo(GamificationPeojfSaldoAr.class) Map<String, Object> gamificationPeojfSaldoArPatch) {
        LOGGER.debug("Partially updating GamificationPeojfSaldoAr with id: {}" , id);

        GamificationPeojfSaldoAr gamificationPeojfSaldoAr = gamificationPeojfSaldoArService.partialUpdate(id, gamificationPeojfSaldoArPatch);
        LOGGER.debug("GamificationPeojfSaldoAr details after partial update: {}" , gamificationPeojfSaldoAr);

        return gamificationPeojfSaldoAr;
    }

    @ApiOperation(value = "Deletes the GamificationPeojfSaldoAr instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteGamificationPeojfSaldoAr(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting GamificationPeojfSaldoAr with id: {}" , id);

        GamificationPeojfSaldoAr deletedGamificationPeojfSaldoAr = gamificationPeojfSaldoArService.delete(id);

        return deletedGamificationPeojfSaldoAr != null;
    }

    /**
     * @deprecated Use {@link #findGamificationPeojfSaldoArs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of GamificationPeojfSaldoAr instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<GamificationPeojfSaldoAr> searchGamificationPeojfSaldoArsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering GamificationPeojfSaldoArs list by query filter:{}", (Object) queryFilters);
        return gamificationPeojfSaldoArService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of GamificationPeojfSaldoAr instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<GamificationPeojfSaldoAr> findGamificationPeojfSaldoArs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering GamificationPeojfSaldoArs list by filter:", query);
        return gamificationPeojfSaldoArService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of GamificationPeojfSaldoAr instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<GamificationPeojfSaldoAr> filterGamificationPeojfSaldoArs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering GamificationPeojfSaldoArs list by filter", query);
        return gamificationPeojfSaldoArService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportGamificationPeojfSaldoArs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return gamificationPeojfSaldoArService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportGamificationPeojfSaldoArsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = GamificationPeojfSaldoAr.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> gamificationPeojfSaldoArService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of GamificationPeojfSaldoAr instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countGamificationPeojfSaldoArs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting GamificationPeojfSaldoArs");
		return gamificationPeojfSaldoArService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getGamificationPeojfSaldoArAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return gamificationPeojfSaldoArService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service GamificationPeojfSaldoArService instance
	 */
	protected void setGamificationPeojfSaldoArService(GamificationPeojfSaldoArService service) {
		this.gamificationPeojfSaldoArService = service;
	}

}