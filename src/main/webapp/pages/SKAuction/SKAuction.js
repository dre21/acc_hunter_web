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
};

Page.FileServiceUploadFileonSuccess = function(variable, data) {
    console.log("FileServiceUploadFileonSuccess");
    console.log(variable);
    console.log(data);

    for (var i = 0; i < data.length; i++) {
        Page.Variables.imagesUploadedList.addItem({
            dataValue: data[i].inlinePath,
            mediaUrlVal: data[i].inlinePath,
            thumbnailUrlVal: data[i].inlinePath
        });
    }
    console.log(Page.Variables.imagesUploadedList.dataSet);
};

Page.LelangSkBaruTableRowclick = function($event, widget, row) {
    var sv = Page.Variables.getLelangSKDetail;
    sv.setInput({
        "remo_id": row.remoId
    });
    sv.invoke();
    Page.Variables.remoIDParam.dataSet.dataValue = row.remoId;
    Page.Variables.lelangSKIdParam.dataSet.dataValue = row.id;

    // enable and show Tambah Daftar SK button
    Page.Widgets.buttonTambahDaftarSK.disabled = false;
};
Page.LelangSkDetailLiveFormSuccess = function($event, $operation, $data) {
    // return data from inserted SK Detail
    for (var i = 0; i < Page.Variables.imagesUploadedList.dataSet.length; i++) {
        Page.Variables.insertSKDetailImages.createRecord({
            row: {
                'skListAuctionId': $data.id,
                'url': Page.Variables.imagesUploadedList.dataSet[i].dataValue
            }
        }, function(data) {}, function(error) {});
    }

    Page.Actions.lelangSKDetailNotificationSuccess.invoke();
    Page.Widgets.lelangSKDetailDialog.close();
};
Page.SelectParticipantsTableRowselect = function($event, widget, row) {
    console.log("Select", row);
    Page.Variables.selectedUserIdList.addItem({
        dataValue: row.id
    });

    console.log("selectedUserIdList after add", Page.Variables.selectedUserIdList);
};
Page.LelangSKAktifTableRowclick = function($event, widget, row) {
    Page.Variables.lelangSKDetailIDParam.dataSet.dataValue = row.id;
    // enable buttonTambahPeserta
    Page.Widgets.buttonTambahPeserta.disabled = false;
};

Page.insertLelangSKParticipantsonError = function(variable, data) {
    console.log("error", data);
};

Page.SelectParticipantsTableRowdeselect = function($event, widget, row) {
    Page.Variables.selectedUserIdList.removeItem({
        dataValue: row.id
    });

    console.log("selectedUserIdList deselect", Page.Variables.selectedUserIdList);
};

Page.insertLelangSKParticipantsonBeforeInsertRecord = function(variable, inputData, options) {
    console.log("inputData", inputData);
    console.log("Page.Variables", Page.Variables.selectedUserIdList.dataSet.length);
};

Page.buttonSimpanClick = function($event, widget) {
    // Loop for each selected user list to be inserted into database
    for (var i = 0; i < Page.Variables.selectedUserIdList.dataSet.length; i++) {
        console.log("dataSet", i, Page.Variables.selectedUserIdList.dataSet[i].dataValue);
        Page.Variables.insertLelangSKParticipants.createRecord({
            row: {
                'lelangSkDetailId': Page.Variables.lelangSKDetailIDParam.dataSet.dataValue,
                'userId': Page.Variables.selectedUserIdList.dataSet[i].dataValue
            }
        }, function(data) {}, function(error) {});
    }
};

Page.executeGetLelangSKAktifTable1_updaterowAction = function($event, row) {
    console.log("row", row);
    Page.Variables.viewLelangDetailParam.dataSet.dataValue = row.lelangSkDetailId;
    var api = Page.Variables.viewLelangSKAktif;
    // call API viewLelangSKAktif to retrieve detail data
    api.setInput({
        "agreement_no": row.nomorAgreement
    });
    api.invoke();
};

Page.viewLelangSKAktifonSuccess = function(variable, data) {
    console.log("success", data);
};

Page.viewLelangSKAktifonError = function(variable, data) {
    console.log("error", data);
};