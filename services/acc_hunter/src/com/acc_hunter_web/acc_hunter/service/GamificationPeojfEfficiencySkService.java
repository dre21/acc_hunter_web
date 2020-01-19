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

import com.acc_hunter_web.acc_hunter.GamificationPeojfEfficiencySk;

/**
 * Service object for domain model class {@link GamificationPeojfEfficiencySk}.
 */
public interface GamificationPeojfEfficiencySkService {

    /**
     * Creates a new GamificationPeojfEfficiencySk. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on GamificationPeojfEfficiencySk if any.
     *
     * @param gamificationPeojfEfficiencySk Details of the GamificationPeojfEfficiencySk to be created; value cannot be null.
     * @return The newly created GamificationPeojfEfficiencySk.
     */
    GamificationPeojfEfficiencySk create(@Valid GamificationPeojfEfficiencySk gamificationPeojfEfficiencySk);


	/**
     * Returns GamificationPeojfEfficiencySk by given id if exists.
     *
     * @param gamificationpeojfefficiencyskId The id of the GamificationPeojfEfficiencySk to get; value cannot be null.
     * @return GamificationPeojfEfficiencySk associated with the given gamificationpeojfefficiencyskId.
	 * @throws EntityNotFoundException If no GamificationPeojfEfficiencySk is found.
     */
    GamificationPeojfEfficiencySk getById(Integer gamificationpeojfefficiencyskId);

    /**
     * Find and return the GamificationPeojfEfficiencySk by given id if exists, returns null otherwise.
     *
     * @param gamificationpeojfefficiencyskId The id of the GamificationPeojfEfficiencySk to get; value cannot be null.
     * @return GamificationPeojfEfficiencySk associated with the given gamificationpeojfefficiencyskId.
     */
    GamificationPeojfEfficiencySk findById(Integer gamificationpeojfefficiencyskId);

	/**
     * Find and return the list of GamificationPeojfEfficiencySks by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param gamificationpeojfefficiencyskIds The id's of the GamificationPeojfEfficiencySk to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return GamificationPeojfEfficiencySks associated with the given gamificationpeojfefficiencyskIds.
     */
    List<GamificationPeojfEfficiencySk> findByMultipleIds(List<Integer> gamificationpeojfefficiencyskIds, boolean orderedReturn);


    /**
     * Updates the details of an existing GamificationPeojfEfficiencySk. It replaces all fields of the existing GamificationPeojfEfficiencySk with the given gamificationPeojfEfficiencySk.
     *
     * This method overrides the input field values using Server side or database managed properties defined on GamificationPeojfEfficiencySk if any.
     *
     * @param gamificationPeojfEfficiencySk The details of the GamificationPeojfEfficiencySk to be updated; value cannot be null.
     * @return The updated GamificationPeojfEfficiencySk.
     * @throws EntityNotFoundException if no GamificationPeojfEfficiencySk is found with given input.
     */
    GamificationPeojfEfficiencySk update(@Valid GamificationPeojfEfficiencySk gamificationPeojfEfficiencySk);


    /**
     * Partially updates the details of an existing GamificationPeojfEfficiencySk. It updates only the
     * fields of the existing GamificationPeojfEfficiencySk which are passed in the gamificationPeojfEfficiencySkPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on GamificationPeojfEfficiencySk if any.
     *
     * @param gamificationpeojfefficiencyskId The id of the GamificationPeojfEfficiencySk to be deleted; value cannot be null.
     * @param gamificationPeojfEfficiencySkPatch The partial data of GamificationPeojfEfficiencySk which is supposed to be updated; value cannot be null.
     * @return The updated GamificationPeojfEfficiencySk.
     * @throws EntityNotFoundException if no GamificationPeojfEfficiencySk is found with given input.
     */
    GamificationPeojfEfficiencySk partialUpdate(Integer gamificationpeojfefficiencyskId, Map<String, Object> gamificationPeojfEfficiencySkPatch);

    /**
     * Deletes an existing GamificationPeojfEfficiencySk with the given id.
     *
     * @param gamificationpeojfefficiencyskId The id of the GamificationPeojfEfficiencySk to be deleted; value cannot be null.
     * @return The deleted GamificationPeojfEfficiencySk.
     * @throws EntityNotFoundException if no GamificationPeojfEfficiencySk found with the given id.
     */
    GamificationPeojfEfficiencySk delete(Integer gamificationpeojfefficiencyskId);

    /**
     * Deletes an existing GamificationPeojfEfficiencySk with the given object.
     *
     * @param gamificationPeojfEfficiencySk The instance of the GamificationPeojfEfficiencySk to be deleted; value cannot be null.
     */
    void delete(GamificationPeojfEfficiencySk gamificationPeojfEfficiencySk);

    /**
     * Find all GamificationPeojfEfficiencySks matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching GamificationPeojfEfficiencySks.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<GamificationPeojfEfficiencySk> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all GamificationPeojfEfficiencySks matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching GamificationPeojfEfficiencySks.
     *
     * @see Pageable
     * @see Page
     */
    Page<GamificationPeojfEfficiencySk> findAll(String query, Pageable pageable);

    /**
     * Exports all GamificationPeojfEfficiencySks matching the given input query to the given exportType format.
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
     * Exports all GamificationPeojfEfficiencySks matching the given input query to the given exportType format.
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
     * Retrieve the count of the GamificationPeojfEfficiencySks in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the GamificationPeojfEfficiencySk.
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