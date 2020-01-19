/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Page.onReady = function() {
    /*
     * variables can be accessed through 'Page.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Page.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Page.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Page.Widgets.username.datavalue'
     */

    if (Page.App.Variables.loggedInUser.dataSet.roles[0] == "REMO HEAD") {
        Page.Widgets.rewardsContainer.show = false;
    } else {
        Page.Widgets.redeemRequestContainer.show = false;
    }
    Page.Widgets.peojfContainer.show = false;
    Page.Widgets.informanContainer.show = false;
    Page.Widgets.configContainer.show = false;
    Page.Widgets.redeemHistoryContainer.show = false;

    Page.Widgets.peojfRedeemContainer.show = false;

    Page.Widgets.peojfHistoryContainer.show = false;

    // Page.Widgets.startDateInforman.datavalue = "";
    // Page.Widgets.endDateInforman.datavalue = "";
    // Page.Widgets.remoInforman.datavalue = null;
    // Page.Widgets.badgesInforman.datavalue = null;

    // Page.Widgets.startDatePeojf.datavalue = "";
    // Page.Widgets.endDatePeojf.datavalue = "";
    // Page.Widgets.remoPeojf.datavalue = null;
    // Page.Widgets.badgesPeojf.datavalue = null;
};

Page.informanClick = function($event, widget) {
    $("#informan").addClass("clicked");
    $("#peojf").removeClass("clicked");
    $("#manageRewards").removeClass("clicked");
    $("#rewardConfiguration").removeClass("clicked");
    $("#redeemRequest").removeClass("clicked");
    $("#redeemHistory").removeClass("clicked");
    Page.Widgets.redeemHistoryContainer.show = false;
    Page.Widgets.redeemRequestContainer.show = false;
    Page.Widgets.informanContainer.show = true;
    Page.Widgets.peojfContainer.show = false;
    Page.Widgets.rewardsContainer.show = false;
    Page.Widgets.configContainer.show = false;
};

Page.peojfClick = function($event, widget) {
    $("#peojf").addClass("clicked");
    $("#informan").removeClass("clicked");
    $("#manageRewards").removeClass("clicked");
    $("#rewardConfiguration").removeClass("clicked");
    $("#redeemRequest").removeClass("clicked");
    $("#redeemHistory").removeClass("clicked");
    Page.Widgets.redeemHistoryContainer.show = false;
    Page.Widgets.redeemRequestContainer.show = false;
    Page.Widgets.informanContainer.show = false;
    Page.Widgets.peojfContainer.show = true;
    Page.Widgets.rewardsContainer.show = false;
    Page.Widgets.configContainer.show = false;
};

Page.rewardMasterClick = function($event, widget) {
    $("#rewardMaster").addClass("clicked");
    $("#informan").removeClass("clicked");
    $("#peojf").removeClass("clicked");
    $("#rewardConfiguration").removeClass("clicked");
    $("#redeemRequest").removeClass("clicked");
    $("#redeemHistory").removeClass("clicked");
    Page.Widgets.redeemHistoryContainer.show = false;
    Page.Widgets.redeemRequestContainer.show = false;
    Page.Widgets.informanContainer.show = false;
    Page.Widgets.peojfContainer.show = false;
    Page.Widgets.rewardsContainer.show = true;
    Page.Widgets.configContainer.show = false;
};

Page.rewardConfigurationClick = function($event, widget) {
    $("#rewardConfiguration").addClass("clicked");
    $("#rewardMaster").removeClass("clicked");
    $("#informan").removeClass("clicked");
    $("#peojf").removeClass("clicked");
    $("#redeemRequest").removeClass("clicked");
    $("#redeemHistory").removeClass("clicked");
    Page.Widgets.redeemHistoryContainer.show = false;
    Page.Widgets.redeemRequestContainer.show = false;
    Page.Widgets.informanContainer.show = false;
    Page.Widgets.peojfContainer.show = false;
    Page.Widgets.rewardsContainer.show = false;
    Page.Widgets.configContainer.show = true;
};

Page.redeemRequestClick = function($event, widget) {
    $("#redeemRequest").addClass("clicked");
    $("#rewardConfiguration").removeClass("clicked");
    $("#rewardMaster").removeClass("clicked");
    $("#informan").removeClass("clicked");
    $("#peojf").removeClass("clicked");
    $("#redeemHistory").removeClass("clicked");
    Page.Widgets.redeemHistoryContainer.show = false;
    Page.Widgets.redeemRequestContainer.show = true;
    Page.Widgets.informanContainer.show = false;
    Page.Widgets.peojfContainer.show = false;
    Page.Widgets.rewardsContainer.show = false;
    Page.Widgets.configContainer.show = false;
};

Page.redeemHistoryClick = function($event, widget) {
    $("#redeemHistory").addClass("clicked");
    $("#redeemRequest").removeClass("clicked");
    $("#rewardConfiguration").removeClass("clicked");
    $("#rewardMaster").removeClass("clicked");
    $("#informan").removeClass("clicked");
    $("#peojf").removeClass("clicked");
    $("#redeemHistory").addClass("clicked");
    Page.Widgets.redeemHistoryContainer.show = true;
    Page.Widgets.redeemRequestContainer.show = false;
    Page.Widgets.informanContainer.show = false;
    Page.Widgets.peojfContainer.show = false;
    Page.Widgets.rewardsContainer.show = false;
    Page.Widgets.configContainer.show = false;
};

//REDEEM Container
Page.peojfRedeemClick = function($event, widget) {
    $("#peojfRedeem").addClass("clicked");
    $("#infRedeem").removeClass("clicked");
    Page.Widgets.peojfRedeemContainer.show = true;
    Page.Widgets.infRedeemContainer.show = false;
};

Page.infRedeemClick = function($event, widget) {
    $("#infRedeem").addClass("clicked");
    $("#peojfRedeem").removeClass("clicked");
    Page.Widgets.peojfRedeemContainer.show = false;
    Page.Widgets.infRedeemContainer.show = true;
};

//History Container
Page.infHistoryClick = function($event, widget) {
    $("#infHistory").addClass("clicked");
    $("#peojfHistory").removeClass("clicked");
    Page.Widgets.peojfHistoryContainer.show = false;
    Page.Widgets.infHistoryContainer.show = true;
};

Page.peojfHistoryClick = function($event, widget) {
    $("#peojfHistory").addClass("clicked");
    $("#infHistory").removeClass("clicked");
    Page.Widgets.peojfHistoryContainer.show = true;
    Page.Widgets.infHistoryContainer.show = false;
};


Page.label20Click = function($event, widget) {
    Page.Widgets.startDateInforman.datavalue = "";
    Page.Widgets.endDateInforman.datavalue = "";
    Page.Widgets.remoInforman.datavalue = null;
    Page.Widgets.badgesInforman.datavalue = null;
};

Page.label21Click = function($event, widget) {
    Page.Widgets.startDatePeojf.datavalue = "";
    Page.Widgets.endDatePeojf.datavalue = "";
    Page.Widgets.remoPeojf.datavalue = null;
    Page.Widgets.badgesPeojf.datavalue = null;
};

Page.getInformanLeaderboardsonBeforeUpdate = function(variable, inputData, options) {
    if (inputData.startDate != "" && inputData.endDate != "") {
        var date2 = new Date(inputData.endDate);
        var date1 = new Date(inputData.startDate);
        if (date2 < date1) {
            inputData.endDate = inputData.startDate;
            Page.Widgets.endDateInforman.datavalue = inputData.startDate;
        }
    }
    if (inputData.startDate == "" && inputData.endDate == "") {
        inputData.startDate = "1970-01-01";
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        inputData.endDate = yyyy + "-" + mm + "-" + dd;
    }
    if (inputData.city == null || inputData.city == "") {
        inputData.city = "default"
    }
    if (inputData.badgeType == null || inputData.badgeType == "") {
        inputData.badgeType = "default"
    }
};

Page.getMitraLeaderboardsonBeforeUpdate = function(variable, inputData, options) {
    console.log(inputData);
    if (inputData.startDate != "" && inputData.endDate != "") {
        var date2 = new Date(inputData.endDate);
        var date1 = new Date(inputData.startDate);
        if (date2 < date1) {
            inputData.endDate = inputData.startDate;
            Page.Widgets.endDatePeojf.datavalue = inputData.startDate;
        }
    }
    if (inputData.startDate == "" && inputData.endDate == "") {
        inputData.startDate = "1970-01-01";
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        inputData.endDate = yyyy + "-" + mm + "-" + dd;
    }
    if (inputData.city == null || inputData.city == "") {
        inputData.city = "default"
    }
    if (inputData.badgeType == null || inputData.badgeType == "") {
        inputData.badgeType = "default"
    }
    console.log(inputData)
};

Page.FileServiceUploadFile1onSuccess = function(variable, data) {
    console.log(data);
    $('.file-upload').remove();
    Page.Variables.imageList.removeItem(0);
    for (var i = 0; i < data.length; i++) {
        Page.Variables.imageList.addItem({
            dataValue: data[i].inlinePath,
            mediaUrlVal: data[i].inlinePath,
            thumbnailUrlVal: data[i].inlinePath
        });
    }
    console.log(Page.Variables.imageList.dataSet)
};
Page.FileServiceUploadFileonSuccess = function(variable, data) {
    $('.file-upload').remove();
    Page.Variables.imageList.removeItem(0);
    for (var i = 0; i < data.length; i++) {
        Page.Variables.imageList.addItem({
            dataValue: data[i].inlinePath,
            mediaUrlVal: data[i].inlinePath,
            thumbnailUrlVal: data[i].inlinePath
        });
    }
    console.log(Page.Variables.imageList.dataSet)
};

Page.resetImageClick = function($event, widget) {
    Page.Variables.imageList.dataSet = [];
};

Page.MasterRewardList1Select = function(widget, $data) {
    console.log($data)
    Page.Variables.imageList.removeItem(0);
    Page.Variables.imageList.addItem({
        dataValue: $data.picReward
    })
    console.log(Page.Variables.imageList.dataSet)
};

Page.addRewardDialogClose = function($event, widget) {
    Page.Variables.imageList.dataSet = [];
};
Page.editRewardClose = function($event, widget) {
    Page.Variables.imageList.dataSet = [];
};

//#####INSERT ON BEFORE######//
Page.insMasterRewardonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
    console.log(inputData)
};

Page.insRewardConfigonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
    console.log(inputData)
};


//#####INSERT SUCCESS####///
Page.insMasterRewardonSuccess = function(variable, data) {
    Page.Actions.successToast.invoke({
        "message": "Add Master Reward Success!"
    })
};
Page.insRewardConfigonSuccess = function(variable, data) {
    Page.Actions.successToast.invoke({
        "message": "Add Reward Configuration Success!"
    })
};


//######UPDATE SUCCESS#####///
Page.updMasterRewardonSuccess = function(variable, data) {
    Page.Actions.successToast.invoke({
        "message": "Update Master Reward Success!"
    })
};
Page.updRewardConfigonSuccess = function(variable, data) {
    Page.Actions.successToast.invoke({
        "message": "Update Reward Configuration Success!"
    })
};


//######DELETE SUCCESS#####//
Page.delMasterRewardonSuccess = function(variable, data) {
    Page.Actions.successToast.invoke({
        "message": "Delete Master Reward Success!"
    })
};
Page.delRewardConfigonSuccess = function(variable, data) {
    Page.Actions.successToast.invoke({
        "message": "Delete Reward Configuration Success!"
    })
};

//ADD Master Reward
Page.button1Click = function($event, widget) {
    if (Page.Widgets.text1.datavalue == "" || Page.Widgets.text1.datavalue === null || Page.Widgets.text1.datavalue === undefined) {
        Page.Widgets.messageAddReward.caption = "Nama tidak boleh kosong";
        Page.Widgets.messageAddReward.type = "error";
        Page.Widgets.messageAddReward.showMessage();
        return false;
    } else if (Page.Widgets.textarea1.datavalue === "" || Page.Widgets.textarea1.datavalue === null || Page.Widgets.textarea1.datavalue === undefined) {
        Page.Widgets.messageAddReward.caption = "Deskripsi tidak boleh kosong";
        Page.Widgets.messageAddReward.type = "error";
        Page.Widgets.messageAddReward.showMessage();
        return false;
    }
    Page.Variables.insMasterReward.invoke();
};

//Update Master Reward
Page.button6Click = function($event, widget) {
    if (Page.Widgets.text3.datavalue == "" || Page.Widgets.text3.datavalue === null || Page.Widgets.text3.datavalue === undefined) {
        Page.Widgets.messageEditReward.caption = "Nama tidak boleh kosong";
        Page.Widgets.messageEditReward.type = "error";
        Page.Widgets.messageEditReward.showMessage();
        return false;
    } else if (Page.Widgets.textarea2.datavalue === "" || Page.Widgets.textarea2.datavalue === null || Page.Widgets.textarea2.datavalue === undefined) {
        Page.Widgets.messageEditReward.caption = "Deskripsi tidak boleh kosong";
        Page.Widgets.messageEditReward.type = "error";
        Page.Widgets.messageEditReward.showMessage();
        return false;
    }
    Page.Variables.updMasterReward.invoke();
};

//Add configuration reward
Page.button4Click = function($event, widget) {
    if (Page.Widgets.select5.datavalue == "" || Page.Widgets.select5.datavalue === null || Page.Widgets.select5.datavalue === undefined) {
        Page.Widgets.messageAddConfig.caption = "Reward tidak boleh kosong";
        Page.Widgets.messageAddConfig.type = "error";
        Page.Widgets.messageAddConfig.showMessage();
        return false;
    } else if (Page.Widgets.select6.datavalue == "" || Page.Widgets.select6.datavalue === null || Page.Widgets.select6.datavalue === undefined) {
        Page.Widgets.messageAddConfig.caption = "Availability tidak boleh kosong";
        Page.Widgets.messageAddConfig.type = "error";
        Page.Widgets.messageAddConfig.showMessage();
        return false;
    } else if (Page.Widgets.text2.datavalue == "" || Page.Widgets.text2.datavalue === null || Page.Widgets.text2.datavalue === undefined) {
        Page.Widgets.messageAddConfig.caption = "Point tidak boleh kosong";
        Page.Widgets.messageAddConfig.type = "error";
        Page.Widgets.messageAddConfig.showMessage();
        return false;
    }
    Page.Variables.insRewardConfig.invoke();
};

//Edit Configuration reward
Page.button5Click = function($event, widget) {
    if (Page.Widgets.select7.datavalue == "" || Page.Widgets.select7.datavalue === null || Page.Widgets.select7.datavalue === undefined) {
        Page.Widgets.messageEditConfig.caption = "Reward tidak boleh kosong";
        Page.Widgets.messageEditConfig.type = "error";
        Page.Widgets.messageEditConfig.showMessage();
        return false;
    } else if (Page.Widgets.select8.datavalue == "" || Page.Widgets.select8.datavalue === null || Page.Widgets.select8.datavalue === undefined) {
        Page.Widgets.messageEditConfig.caption = "Availability tidak boleh kosong";
        Page.Widgets.messageEditConfig.type = "error";
        Page.Widgets.messageEditConfig.showMessage();
        return false;
    } else if (Page.Widgets.text4.datavalue == "" || Page.Widgets.text4.datavalue === null || Page.Widgets.text4.datavalue === undefined) {
        Page.Widgets.messageEditConfig.caption = "Point tidak boleh kosong";
        Page.Widgets.messageEditConfig.type = "error";
        Page.Widgets.messageEditConfig.showMessage();
        return false;
    }
    Page.Variables.updRewardConfig.invoke();
};

Page.updInfFlagRedeemonBeforeUpdate = function(variable, inputData, options) {
    inputData.date_confirm = new Date();
    console.log(inputData)
};
Page.updPeojfFlagRedeemonBeforeUpdate = function(variable, inputData, options) {
    inputData.date_confirm = new Date();
};

Page.insertKreditPeojfonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
};
Page.insertKreditInfonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
};

Page.insNotificationPeojfonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
};
Page.insNotificationInfonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
};