/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.time.LocalDateTime;
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

import com.acc_hunter_web.acc_hunter.SkRequestAndSayembara;
import com.acc_hunter_web.acc_hunter.SkRequestAndSayembaraId;
import com.acc_hunter_web.acc_hunter.service.SkRequestAndSayembaraService;


/**
 * Controller object for domain model class SkRequestAndSayembara.
 * @see SkRequestAndSayembara
 */
@RestController("acc_hunter.SkRequestAndSayembaraController")
@Api(value = "SkRequestAndSayembaraController", description = "Exposes APIs to work with SkRequestAndSayembara resource.")
@RequestMapping("/acc_hunter/SkRequestAndSayembara")
public class SkRequestAndSayembaraController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkRequestAndSayembaraController.class);

    @Autowired
	@Qualifier("acc_hunter.SkRequestAndSayembaraService")
	private SkRequestAndSayembaraService skRequestAndSayembaraService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new SkRequestAndSayembara instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SkRequestAndSayembara createSkRequestAndSayembara(@RequestBody SkRequestAndSayembara skRequestAndSayembara) {
		LOGGER.debug("Create SkRequestAndSayembara with information: {}" , skRequestAndSayembara);

		skRequestAndSayembara = skRequestAndSayembaraService.create(skRequestAndSayembara);
		LOGGER.debug("Created SkRequestAndSayembara with information: {}" , skRequestAndSayembara);

	    return skRequestAndSayembara;
	}

    @ApiOperation(value = "Returns the SkRequestAndSayembara instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SkRequestAndSayembara getSkRequestAndSayembara(@RequestParam("noAggr") String noAggr, @RequestParam("collCd") String collCd, @RequestParam("reqSkDate") LocalDateTime reqSkDate) {

        SkRequestAndSayembaraId skrequestandsayembaraId = new SkRequestAndSayembaraId();
        skrequestandsayembaraId.setNoAggr(noAggr);
        skrequestandsayembaraId.setCollCd(collCd);
        skrequestandsayembaraId.setReqSkDate(reqSkDate);

        LOGGER.debug("Getting SkRequestAndSayembara with id: {}" , skrequestandsayembaraId);
        SkRequestAndSayembara skRequestAndSayembara = skRequestAndSayembaraService.getById(skrequestandsayembaraId);
        LOGGER.debug("SkRequestAndSayembara details with id: {}" , skRequestAndSayembara);

        return skRequestAndSayembara;
    }



    @ApiOperation(value = "Updates the SkRequestAndSayembara instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SkRequestAndSayembara editSkRequestAndSayembara(@RequestParam("noAggr") String noAggr, @RequestParam("collCd") String collCd, @RequestParam("reqSkDate") LocalDateTime reqSkDate, @RequestBody SkRequestAndSayembara skRequestAndSayembara) {

        skRequestAndSayembara.setNoAggr(noAggr);
        skRequestAndSayembara.setCollCd(collCd);
        skRequestAndSayembara.setReqSkDate(reqSkDate);

        LOGGER.debug("SkRequestAndSayembara details with id is updated with: {}" , skRequestAndSayembara);

        return skRequestAndSayembaraService.update(skRequestAndSayembara);
    }

	@ApiOperation(value = "Partially updates the  SkRequestAndSayembara instance associated with the given composite-id.")
	@RequestMapping(value = "/composite-id", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SkRequestAndSayembara patchSkRequestAndSayembara(@RequestParam("noAggr") String noAggr, @RequestParam("collCd") String collCd, @RequestParam("reqSkDate") LocalDateTime reqSkDate, @RequestBody @MapTo(SkRequestAndSayembara.class) Map<String, Object> skRequestAndSayembaraPatch) {

        SkRequestAndSayembaraId skrequestandsayembaraId = new SkRequestAndSayembaraId();
        skrequestandsayembaraId.setNoAggr(noAggr);
        skrequestandsayembaraId.setCollCd(collCd);
        skrequestandsayembaraId.setReqSkDate(reqSkDate);
        LOGGER.debug("Partially updating SkRequestAndSayembara with id: {}" , skrequestandsayembaraId);

        SkRequestAndSayembara skRequestAndSayembara = skRequestAndSayembaraService.partialUpdate(skrequestandsayembaraId, skRequestAndSayembaraPatch);
        LOGGER.debug("SkRequestAndSayembara details after partial update: {}" , skRequestAndSayembara);

        return skRequestAndSayembara;
    }


    @ApiOperation(value = "Deletes the SkRequestAndSayembara instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSkRequestAndSayembara(@RequestParam("noAggr") String noAggr, @RequestParam("collCd") String collCd, @RequestParam("reqSkDate") LocalDateTime reqSkDate) {

        SkRequestAndSayembaraId skrequestandsayembaraId = new SkRequestAndSayembaraId();
        skrequestandsayembaraId.setNoAggr(noAggr);
        skrequestandsayembaraId.setCollCd(collCd);
        skrequestandsayembaraId.setReqSkDate(reqSkDate);

        LOGGER.debug("Deleting SkRequestAndSayembara with id: {}" , skrequestandsayembaraId);
        SkRequestAndSayembara skRequestAndSayembara = skRequestAndSayembaraService.delete(skrequestandsayembaraId);

        return skRequestAndSayembara != null;
    }


    @RequestMapping(value = "/skFileName/{skFileName}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching SkRequestAndSayembara with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public SkRequestAndSayembara getBySkFileName(@PathVariable("skFileName") String skFileName) {
        LOGGER.debug("Getting SkRequestAndSayembara with uniques key SkFileName");
        return skRequestAndSayembaraService.getBySkFileName(skFileName);
    }

    /**
     * @deprecated Use {@link #findSkRequestAndSayembaras(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of SkRequestAndSayembara instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<SkRequestAndSayembara> searchSkRequestAndSayembarasByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering SkRequestAndSayembaras list by query filter:{}", (Object) queryFilters);
        return skRequestAndSayembaraService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SkRequestAndSayembara instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SkRequestAndSayembara> findSkRequestAndSayembaras(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SkRequestAndSayembaras list by filter:", query);
        return skRequestAndSayembaraService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of SkRequestAndSayembara instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<SkRequestAndSayembara> filterSkRequestAndSayembaras(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering SkRequestAndSayembaras list by filter", query);
        return skRequestAndSayembaraService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportSkRequestAndSayembaras(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return skRequestAndSayembaraService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportSkRequestAndSayembarasAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = SkRequestAndSayembara.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> skRequestAndSayembaraService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of SkRequestAndSayembara instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countSkRequestAndSayembaras( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting SkRequestAndSayembaras");
		return skRequestAndSayembaraService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getSkRequestAndSayembaraAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return skRequestAndSayembaraService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SkRequestAndSayembaraService instance
	 */
	protected void setSkRequestAndSayembaraService(SkRequestAndSayembaraService service) {
		this.skRequestAndSayembaraService = service;
	}

}