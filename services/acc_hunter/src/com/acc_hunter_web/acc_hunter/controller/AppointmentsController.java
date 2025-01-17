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
import com.acc_hunter_web.acc_hunter.UserRequestUpgrades;
import com.acc_hunter_web.acc_hunter.service.AppointmentsService;


/**
 * Controller object for domain model class Appointments.
 * @see Appointments
 */
@RestController("acc_hunter.AppointmentsController")
@Api(value = "AppointmentsController", description = "Exposes APIs to work with Appointments resource.")
@RequestMapping("/acc_hunter/Appointments")
public class AppointmentsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentsController.class);

    @Autowired
	@Qualifier("acc_hunter.AppointmentsService")
	private AppointmentsService appointmentsService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Appointments instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Appointments createAppointments(@RequestBody Appointments appointments) {
		LOGGER.debug("Create Appointments with information: {}" , appointments);

		appointments = appointmentsService.create(appointments);
		LOGGER.debug("Created Appointments with information: {}" , appointments);

	    return appointments;
	}

    @ApiOperation(value = "Returns the Appointments instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Appointments getAppointments(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Appointments with id: {}" , id);

        Appointments foundAppointments = appointmentsService.getById(id);
        LOGGER.debug("Appointments details with id: {}" , foundAppointments);

        return foundAppointments;
    }

    @ApiOperation(value = "Updates the Appointments instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Appointments editAppointments(@PathVariable("id") Integer id, @RequestBody Appointments appointments) {
        LOGGER.debug("Editing Appointments with id: {}" , appointments.getId());

        appointments.setId(id);
        appointments = appointmentsService.update(appointments);
        LOGGER.debug("Appointments details with id: {}" , appointments);

        return appointments;
    }
    
    @ApiOperation(value = "Partially updates the Appointments instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Appointments patchAppointments(@PathVariable("id") Integer id, @RequestBody @MapTo(Appointments.class) Map<String, Object> appointmentsPatch) {
        LOGGER.debug("Partially updating Appointments with id: {}" , id);

        Appointments appointments = appointmentsService.partialUpdate(id, appointmentsPatch);
        LOGGER.debug("Appointments details after partial update: {}" , appointments);

        return appointments;
    }

    @ApiOperation(value = "Deletes the Appointments instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAppointments(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Appointments with id: {}" , id);

        Appointments deletedAppointments = appointmentsService.delete(id);

        return deletedAppointments != null;
    }

    /**
     * @deprecated Use {@link #findAppointments(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Appointments instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<Appointments> searchAppointmentsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Appointments list by query filter:{}", (Object) queryFilters);
        return appointmentsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Appointments instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Appointments> findAppointments(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Appointments list by filter:", query);
        return appointmentsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Appointments instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<Appointments> filterAppointments(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Appointments list by filter", query);
        return appointmentsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportAppointments(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return appointmentsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportAppointmentsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Appointments.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> appointmentsService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Appointments instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countAppointments( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Appointments");
		return appointmentsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getAppointmentsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return appointmentsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/userRequestUpgradeses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the userRequestUpgradeses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UserRequestUpgrades> findAssociatedUserRequestUpgradeses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated userRequestUpgradeses");
        return appointmentsService.findAssociatedUserRequestUpgradeses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AppointmentsService instance
	 */
	protected void setAppointmentsService(AppointmentsService service) {
		this.appointmentsService = service;
	}

}