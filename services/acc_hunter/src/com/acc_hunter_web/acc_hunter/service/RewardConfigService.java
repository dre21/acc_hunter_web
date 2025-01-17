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

import com.acc_hunter_web.acc_hunter.RedeemRequest;
import com.acc_hunter_web.acc_hunter.RewardConfig;

/**
 * Service object for domain model class {@link RewardConfig}.
 */
public interface RewardConfigService {

    /**
     * Creates a new RewardConfig. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RewardConfig if any.
     *
     * @param rewardConfig Details of the RewardConfig to be created; value cannot be null.
     * @return The newly created RewardConfig.
     */
    RewardConfig create(@Valid RewardConfig rewardConfig);


	/**
     * Returns RewardConfig by given id if exists.
     *
     * @param rewardconfigId The id of the RewardConfig to get; value cannot be null.
     * @return RewardConfig associated with the given rewardconfigId.
	 * @throws EntityNotFoundException If no RewardConfig is found.
     */
    RewardConfig getById(Integer rewardconfigId);

    /**
     * Find and return the RewardConfig by given id if exists, returns null otherwise.
     *
     * @param rewardconfigId The id of the RewardConfig to get; value cannot be null.
     * @return RewardConfig associated with the given rewardconfigId.
     */
    RewardConfig findById(Integer rewardconfigId);

	/**
     * Find and return the list of RewardConfigs by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param rewardconfigIds The id's of the RewardConfig to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return RewardConfigs associated with the given rewardconfigIds.
     */
    List<RewardConfig> findByMultipleIds(List<Integer> rewardconfigIds, boolean orderedReturn);


    /**
     * Updates the details of an existing RewardConfig. It replaces all fields of the existing RewardConfig with the given rewardConfig.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RewardConfig if any.
     *
     * @param rewardConfig The details of the RewardConfig to be updated; value cannot be null.
     * @return The updated RewardConfig.
     * @throws EntityNotFoundException if no RewardConfig is found with given input.
     */
    RewardConfig update(@Valid RewardConfig rewardConfig);


    /**
     * Partially updates the details of an existing RewardConfig. It updates only the
     * fields of the existing RewardConfig which are passed in the rewardConfigPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on RewardConfig if any.
     *
     * @param rewardconfigId The id of the RewardConfig to be deleted; value cannot be null.
     * @param rewardConfigPatch The partial data of RewardConfig which is supposed to be updated; value cannot be null.
     * @return The updated RewardConfig.
     * @throws EntityNotFoundException if no RewardConfig is found with given input.
     */
    RewardConfig partialUpdate(Integer rewardconfigId, Map<String, Object> rewardConfigPatch);

    /**
     * Deletes an existing RewardConfig with the given id.
     *
     * @param rewardconfigId The id of the RewardConfig to be deleted; value cannot be null.
     * @return The deleted RewardConfig.
     * @throws EntityNotFoundException if no RewardConfig found with the given id.
     */
    RewardConfig delete(Integer rewardconfigId);

    /**
     * Deletes an existing RewardConfig with the given object.
     *
     * @param rewardConfig The instance of the RewardConfig to be deleted; value cannot be null.
     */
    void delete(RewardConfig rewardConfig);

    /**
     * Find all RewardConfigs matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RewardConfigs.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<RewardConfig> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all RewardConfigs matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching RewardConfigs.
     *
     * @see Pageable
     * @see Page
     */
    Page<RewardConfig> findAll(String query, Pageable pageable);

    /**
     * Exports all RewardConfigs matching the given input query to the given exportType format.
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
     * Exports all RewardConfigs matching the given input query to the given exportType format.
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
     * Retrieve the count of the RewardConfigs in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the RewardConfig.
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
     * Returns the associated redeemRequests for given RewardConfig id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated RedeemRequest instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<RedeemRequest> findAssociatedRedeemRequests(Integer id, Pageable pageable);

}