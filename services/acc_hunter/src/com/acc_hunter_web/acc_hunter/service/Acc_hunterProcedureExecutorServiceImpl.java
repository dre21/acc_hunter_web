/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.acc_hunter.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;

@Service
public class Acc_hunterProcedureExecutorServiceImpl implements Acc_hunterProcedureExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Acc_hunterProcedureExecutorServiceImpl.class);

    @Autowired
    @Qualifier("acc_hunterWMProcedureExecutor")
    private WMProcedureExecutor procedureExecutor;


}