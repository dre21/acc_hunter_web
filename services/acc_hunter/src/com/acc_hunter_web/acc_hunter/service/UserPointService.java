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

import com.acc_hunter_web.acc_hunter.UserPoint;

/**
 * Service object for domain model class {@link UserPoint}.
 */
public interface UserPointService {

    /**
     * Creates a new UserPoint. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on UserPoint if any.
     *
     * @param userPoint Details of the UserPoint to be created; value cannot be null.
     * @return The newly created UserPoint.
     */
    UserPoint create(@Valid UserPoint userPoint);


	/**
     * Returns UserPoint by given id if exists.
     *
     * @param userpointId The id of the UserPoint to get; value cannot be null.
     * @return UserPoint associated with the given userpointId.
	 * @throws EntityNotFoundException If no UserPoint is found.
     */
    UserPoint getById(Integer userpointId);

    /**
     * Find and return the UserPoint by given id if exists, returns null otherwise.
     *
     * @param userpointId The id of the UserPoint to get; value cannot be null.
     * @return UserPoint associated with the given userpointId.
     */
    UserPoint findById(Integer userpointId);

	/**
     * Find and return the list of UserPoints by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param userpointIds The id's of the UserPoint to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return UserPoints associated with the given userpointIds.
     */
    List<UserPoint> findByMultipleIds(List<Integer> userpointIds, boolean orderedReturn);


    /**
     * Updates the details of an existing UserPoint. It replaces all fields of the existing UserPoint with the given userPoint.
     *
     * This method overrides the input field values using Server side or database managed properties defined on UserPoint if any.
     *
     * @param userPoint The details of the UserPoint to be updated; value cannot be null.
     * @return The updated UserPoint.
     * @throws EntityNotFoundException if no UserPoint is found with given input.
     */
    UserPoint update(@Valid UserPoint userPoint);


    /**
     * Partially updates the details of an existing UserPoint. It updates only the
     * fields of the existing UserPoint which are passed in the userPointPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on UserPoint if any.
     *
     * @param userpointId The id of the UserPoint to be deleted; value cannot be null.
     * @param userPointPatch The partial data of UserPoint which is supposed to be updated; value cannot be null.
     * @return The updated UserPoint.
     * @throws EntityNotFoundException if no UserPoint is found with given input.
     */
    UserPoint partialUpdate(Integer userpointId, Map<String, Object> userPointPatch);

    /**
     * Deletes an existing UserPoint with the given id.
     *
     * @param userpointId The id of the UserPoint to be deleted; value cannot be null.
     * @return The deleted UserPoint.
     * @throws EntityNotFoundException if no UserPoint found with the given id.
     */
    UserPoint delete(Integer userpointId);

    /**
     * Deletes an existing UserPoint with the given object.
     *
     * @param userPoint The instance of the UserPoint to be deleted; value cannot be null.
     */
    void delete(UserPoint userPoint);

    /**
     * Find all UserPoints matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching UserPoints.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<UserPoint> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all UserPoints matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching UserPoints.
     *
     * @see Pageable
     * @see Page
     */
    Page<UserPoint> findAll(String query, Pageable pageable);

    /**
     * Exports all UserPoints matching the given input query to the given exportType format.
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
     * Exports all UserPoints matching the given input query to the given exportType format.
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
     * Retrieve the count of the UserPoints in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the UserPoint.
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