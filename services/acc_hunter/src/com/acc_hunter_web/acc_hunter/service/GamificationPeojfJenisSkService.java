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

import com.acc_hunter_web.acc_hunter.GamificationPeojfJenisSk;

/**
 * Service object for domain model class {@link GamificationPeojfJenisSk}.
 */
public interface GamificationPeojfJenisSkService {

    /**
     * Creates a new GamificationPeojfJenisSk. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on GamificationPeojfJenisSk if any.
     *
     * @param gamificationPeojfJenisSk Details of the GamificationPeojfJenisSk to be created; value cannot be null.
     * @return The newly created GamificationPeojfJenisSk.
     */
    GamificationPeojfJenisSk create(@Valid GamificationPeojfJenisSk gamificationPeojfJenisSk);


	/**
     * Returns GamificationPeojfJenisSk by given id if exists.
     *
     * @param gamificationpeojfjenisskId The id of the GamificationPeojfJenisSk to get; value cannot be null.
     * @return GamificationPeojfJenisSk associated with the given gamificationpeojfjenisskId.
	 * @throws EntityNotFoundException If no GamificationPeojfJenisSk is found.
     */
    GamificationPeojfJenisSk getById(Integer gamificationpeojfjenisskId);

    /**
     * Find and return the GamificationPeojfJenisSk by given id if exists, returns null otherwise.
     *
     * @param gamificationpeojfjenisskId The id of the GamificationPeojfJenisSk to get; value cannot be null.
     * @return GamificationPeojfJenisSk associated with the given gamificationpeojfjenisskId.
     */
    GamificationPeojfJenisSk findById(Integer gamificationpeojfjenisskId);

	/**
     * Find and return the list of GamificationPeojfJenisSks by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param gamificationpeojfjenisskIds The id's of the GamificationPeojfJenisSk to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return GamificationPeojfJenisSks associated with the given gamificationpeojfjenisskIds.
     */
    List<GamificationPeojfJenisSk> findByMultipleIds(List<Integer> gamificationpeojfjenisskIds, boolean orderedReturn);


    /**
     * Updates the details of an existing GamificationPeojfJenisSk. It replaces all fields of the existing GamificationPeojfJenisSk with the given gamificationPeojfJenisSk.
     *
     * This method overrides the input field values using Server side or database managed properties defined on GamificationPeojfJenisSk if any.
     *
     * @param gamificationPeojfJenisSk The details of the GamificationPeojfJenisSk to be updated; value cannot be null.
     * @return The updated GamificationPeojfJenisSk.
     * @throws EntityNotFoundException if no GamificationPeojfJenisSk is found with given input.
     */
    GamificationPeojfJenisSk update(@Valid GamificationPeojfJenisSk gamificationPeojfJenisSk);


    /**
     * Partially updates the details of an existing GamificationPeojfJenisSk. It updates only the
     * fields of the existing GamificationPeojfJenisSk which are passed in the gamificationPeojfJenisSkPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on GamificationPeojfJenisSk if any.
     *
     * @param gamificationpeojfjenisskId The id of the GamificationPeojfJenisSk to be deleted; value cannot be null.
     * @param gamificationPeojfJenisSkPatch The partial data of GamificationPeojfJenisSk which is supposed to be updated; value cannot be null.
     * @return The updated GamificationPeojfJenisSk.
     * @throws EntityNotFoundException if no GamificationPeojfJenisSk is found with given input.
     */
    GamificationPeojfJenisSk partialUpdate(Integer gamificationpeojfjenisskId, Map<String, Object> gamificationPeojfJenisSkPatch);

    /**
     * Deletes an existing GamificationPeojfJenisSk with the given id.
     *
     * @param gamificationpeojfjenisskId The id of the GamificationPeojfJenisSk to be deleted; value cannot be null.
     * @return The deleted GamificationPeojfJenisSk.
     * @throws EntityNotFoundException if no GamificationPeojfJenisSk found with the given id.
     */
    GamificationPeojfJenisSk delete(Integer gamificationpeojfjenisskId);

    /**
     * Deletes an existing GamificationPeojfJenisSk with the given object.
     *
     * @param gamificationPeojfJenisSk The instance of the GamificationPeojfJenisSk to be deleted; value cannot be null.
     */
    void delete(GamificationPeojfJenisSk gamificationPeojfJenisSk);

    /**
     * Find all GamificationPeojfJenisSks matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching GamificationPeojfJenisSks.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<GamificationPeojfJenisSk> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all GamificationPeojfJenisSks matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching GamificationPeojfJenisSks.
     *
     * @see Pageable
     * @see Page
     */
    Page<GamificationPeojfJenisSk> findAll(String query, Pageable pageable);

    /**
     * Exports all GamificationPeojfJenisSks matching the given input query to the given exportType format.
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
     * Exports all GamificationPeojfJenisSks matching the given input query to the given exportType format.
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
     * Retrieve the count of the GamificationPeojfJenisSks in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the GamificationPeojfJenisSk.
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