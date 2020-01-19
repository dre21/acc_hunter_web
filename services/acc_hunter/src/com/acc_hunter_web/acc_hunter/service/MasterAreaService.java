/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.acc_hunter_web.acc_hunter.LelangSk;
import com.acc_hunter_web.acc_hunter.MasterArea;
import com.acc_hunter_web.acc_hunter.Users;

/**
 * Service object for domain model class {@link MasterArea}.
 */
public interface MasterAreaService {

    /**
     * Creates a new MasterArea. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on MasterArea if any.
     *
     * @param masterArea Details of the MasterArea to be created; value cannot be null.
     * @return The newly created MasterArea.
     */
    MasterArea create(@Valid MasterArea masterArea);


	/**
     * Returns MasterArea by given id if exists.
     *
     * @param masterareaId The id of the MasterArea to get; value cannot be null.
     * @return MasterArea associated with the given masterareaId.
	 * @throws EntityNotFoundException If no MasterArea is found.
     */
    MasterArea getById(Integer masterareaId);

    /**
     * Find and return the MasterArea by given id if exists, returns null otherwise.
     *
     * @param masterareaId The id of the MasterArea to get; value cannot be null.
     * @return MasterArea associated with the given masterareaId.
     */
    MasterArea findById(Integer masterareaId);

	/**
     * Find and return the list of MasterAreas by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param masterareaIds The id's of the MasterArea to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return MasterAreas associated with the given masterareaIds.
     */
    List<MasterArea> findByMultipleIds(List<Integer> masterareaIds, boolean orderedReturn);

    /**
     * Find and return the MasterArea for given areaCode  if exists.
     *
     * @param areaCode value of areaCode; value cannot be null.
     * @return MasterArea associated with the given inputs.
     * @throws EntityNotFoundException if no matching MasterArea found.
     */
    MasterArea getByAreaCode(String areaCode);

    /**
     * Updates the details of an existing MasterArea. It replaces all fields of the existing MasterArea with the given masterArea.
     *
     * This method overrides the input field values using Server side or database managed properties defined on MasterArea if any.
     *
     * @param masterArea The details of the MasterArea to be updated; value cannot be null.
     * @return The updated MasterArea.
     * @throws EntityNotFoundException if no MasterArea is found with given input.
     */
    MasterArea update(@Valid MasterArea masterArea);


    /**
     * Partially updates the details of an existing MasterArea. It updates only the
     * fields of the existing MasterArea which are passed in the masterAreaPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on MasterArea if any.
     *
     * @param masterareaId The id of the MasterArea to be deleted; value cannot be null.
     * @param masterAreaPatch The partial data of MasterArea which is supposed to be updated; value cannot be null.
     * @return The updated MasterArea.
     * @throws EntityNotFoundException if no MasterArea is found with given input.
     */
    MasterArea partialUpdate(Integer masterareaId, Map<String, Object> masterAreaPatch);

    /**
     * Deletes an existing MasterArea with the given id.
     *
     * @param masterareaId The id of the MasterArea to be deleted; value cannot be null.
     * @return The deleted MasterArea.
     * @throws EntityNotFoundException if no MasterArea found with the given id.
     */
    MasterArea delete(Integer masterareaId);

    /**
     * Deletes an existing MasterArea with the given object.
     *
     * @param masterArea The instance of the MasterArea to be deleted; value cannot be null.
     */
    void delete(MasterArea masterArea);

    /**
     * Find all MasterAreas matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching MasterAreas.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<MasterArea> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all MasterAreas matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching MasterAreas.
     *
     * @see Pageable
     * @see Page
     */
    Page<MasterArea> findAll(String query, Pageable pageable);

    /**
     * Exports all MasterAreas matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all MasterAreas matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the MasterAreas in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the MasterArea.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated lelangSks for given MasterArea id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated LelangSk instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<LelangSk> findAssociatedLelangSks(Integer id, Pageable pageable);

    /*
     * Returns the associated userses for given MasterArea id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Users instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Users> findAssociatedUserses(Integer id, Pageable pageable);

}