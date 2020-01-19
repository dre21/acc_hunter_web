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

import com.acc_hunter_web.acc_hunter.Sayembara;

/**
 * Service object for domain model class {@link Sayembara}.
 */
public interface SayembaraService {

    /**
     * Creates a new Sayembara. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Sayembara if any.
     *
     * @param sayembara Details of the Sayembara to be created; value cannot be null.
     * @return The newly created Sayembara.
     */
    Sayembara create(@Valid Sayembara sayembara);


	/**
     * Returns Sayembara by given id if exists.
     *
     * @param sayembaraId The id of the Sayembara to get; value cannot be null.
     * @return Sayembara associated with the given sayembaraId.
	 * @throws EntityNotFoundException If no Sayembara is found.
     */
    Sayembara getById(Integer sayembaraId);

    /**
     * Find and return the Sayembara by given id if exists, returns null otherwise.
     *
     * @param sayembaraId The id of the Sayembara to get; value cannot be null.
     * @return Sayembara associated with the given sayembaraId.
     */
    Sayembara findById(Integer sayembaraId);

	/**
     * Find and return the list of Sayembaras by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param sayembaraIds The id's of the Sayembara to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Sayembaras associated with the given sayembaraIds.
     */
    List<Sayembara> findByMultipleIds(List<Integer> sayembaraIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Sayembara. It replaces all fields of the existing Sayembara with the given sayembara.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Sayembara if any.
     *
     * @param sayembara The details of the Sayembara to be updated; value cannot be null.
     * @return The updated Sayembara.
     * @throws EntityNotFoundException if no Sayembara is found with given input.
     */
    Sayembara update(@Valid Sayembara sayembara);


    /**
     * Partially updates the details of an existing Sayembara. It updates only the
     * fields of the existing Sayembara which are passed in the sayembaraPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Sayembara if any.
     *
     * @param sayembaraId The id of the Sayembara to be deleted; value cannot be null.
     * @param sayembaraPatch The partial data of Sayembara which is supposed to be updated; value cannot be null.
     * @return The updated Sayembara.
     * @throws EntityNotFoundException if no Sayembara is found with given input.
     */
    Sayembara partialUpdate(Integer sayembaraId, Map<String, Object> sayembaraPatch);

    /**
     * Deletes an existing Sayembara with the given id.
     *
     * @param sayembaraId The id of the Sayembara to be deleted; value cannot be null.
     * @return The deleted Sayembara.
     * @throws EntityNotFoundException if no Sayembara found with the given id.
     */
    Sayembara delete(Integer sayembaraId);

    /**
     * Deletes an existing Sayembara with the given object.
     *
     * @param sayembara The instance of the Sayembara to be deleted; value cannot be null.
     */
    void delete(Sayembara sayembara);

    /**
     * Find all Sayembaras matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Sayembaras.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Sayembara> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Sayembaras matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Sayembaras.
     *
     * @see Pageable
     * @see Page
     */
    Page<Sayembara> findAll(String query, Pageable pageable);

    /**
     * Exports all Sayembaras matching the given input query to the given exportType format.
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
     * Exports all Sayembaras matching the given input query to the given exportType format.
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
     * Retrieve the count of the Sayembaras in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Sayembara.
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


}