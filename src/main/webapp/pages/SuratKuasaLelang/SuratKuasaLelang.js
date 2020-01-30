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
    Page.Widgets.lelangSKAktifContainer.show = false;
    Page.Widgets.lelangSKTidakAktifContainer.show = false;
    Page.Widgets.dokumenSKLelangContainer.show = false;
    Page.Widgets.selectWinnerContainer.show = false;
};

Page.newAuctionClick = function($event, widget) {
    $("#newAuction").addClass("clicked");
    $("#activeAuction").removeClass("clicked");
    $("#nonActiveAuction").removeClass("clicked");
    $("#documentAuction").removeClass("clicked");
    $("#winnerAuction").removeClass("clicked");
    Page.Widgets.lelangSKBaruContainer.show = true;
    Page.Widgets.lelangSKAktifContainer.show = false;
    Page.Widgets.lelangSKTidakAktifContainer.show = false;
    Page.Widgets.dokumenSKLelangContainer.show = false;
    Page.Widgets.selectWinnerContainer.show = false;
};

Page.activeAuctionClick = function($event, widget) {
    $("#newAuction").removeClass("clicked");
    $("#activeAuction").addClass("clicked");
    $("#nonActiveAuction").removeClass("clicked");
    $("#documentAuction").removeClass("clicked");
    $("#winnerAuction").removeClass("clicked");
    Page.Widgets.lelangSKBaruContainer.show = false;
    Page.Widgets.lelangSKAktifContainer.show = true;
    Page.Widgets.lelangSKTidakAktifContainer.show = false;
    Page.Widgets.dokumenSKLelangContainer.show = false;
    Page.Widgets.selectWinnerContainer.show = false;
};

Page.winnerAuctionClick = function($event, widget) {
    $("#newAuction").removeClass("clicked");
    $("#activeAuction").removeClass("clicked");
    $("#nonActiveAuction").removeClass("clicked");
    $("#documentAuction").removeClass("clicked");
    $("#winnerAuction").addClass("clicked");
    Page.Widgets.lelangSKBaruContainer.show = false;
    Page.Widgets.lelangSKAktifContainer.show = false;
    Page.Widgets.lelangSKTidakAktifContainer.show = false;
    Page.Widgets.dokumenSKLelangContainer.show = false;
    Page.Widgets.selectWinnerContainer.show = true;
};

Page.nonActiveAuctionClick = function($event, widget) {
    $("#newAuction").removeClass("clicked");
    $("#activeAuction").removeClass("clicked");
    $("#nonActiveAuction").addClass("clicked");
    $("#documentAuction").removeClass("clicked");
    $("#winnerAuction").removeClass("clicked");
    Page.Widgets.lelangSKBaruContainer.show = false;
    Page.Widgets.lelangSKAktifContainer.show = false;
    Page.Widgets.lelangSKTidakAktifContainer.show = true;
    Page.Widgets.dokumenSKLelangContainer.show = false;
    Page.Widgets.selectWinnerContainer.show = false;
};

Page.documentAuctionClick = function($event, widget) {
    $("#newAuction").removeClass("clicked");
    $("#activeAuction").removeClass("clicked");
    $("#nonActiveAuction").removeClass("clicked");
    $("#documentAuction").addClass("clicked");
    $("#winnerAuction").removeClass("clicked");
    Page.Widgets.lelangSKBaruContainer.show = false;
    Page.Widgets.lelangSKAktifContainer.show = false;
    Page.Widgets.lelangSKTidakAktifContainer.show = false;
    Page.Widgets.dokumenSKLelangContainer.show = true;
    Page.Widgets.selectWinnerContainer.show = false;
};

Page.GetLelangListonBeforeDatasetReady = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        data[i].number = i + 1;
    }
};

Page.AddLelangSKonBeforeInsertRecord = function(variable, inputData, options) {
    if (inputData.area == null || inputData.area == "") {
        Page.Widgets.addLelangMessage.caption = "Silahkan pilih wilayah yang ingin dibuatkan lelang";
        Page.Widgets.addLelangMessage.showMessage();
        return false;
    } else if (Page.Widgets.titleAddLelang.datavalue == "" || Page.Widgets.titleAddLelang.datavalue == null || Page.Widgets.titleAddLelang.datavalue == undefined) {
        Page.Widgets.addLelangMessage.caption = "Judul tidak boleh kosong";
        Page.Widgets.addLelangMessage.showMessage();
        return false;
    } else if (Page.Widgets.endDateLelang.datavalue == undefined || Page.Widgets.startDateLelang.datavalue == undefined || Page.Widgets.endDateLelang.datavalue == null || Page.Widgets.startDateLelang.datavalue == null) {
        Page.Widgets.addLelangMessage.caption = "Tanggal mulai dan tanggal berakhir tidak boleh kosong";
        Page.Widgets.addLelangMessage.showMessage();
        return false;
    } else if (inputData.endDate < inputData.startDate) {
        Page.Widgets.addLelangMessage.caption = "Tanggal berakhir harus lebih besar dari tanggal mulai";
        Page.Widgets.addLelangMessage.showMessage();
        return false;
    }
};

Page.EditLelangonBeforeUpdateRecord = function(variable, inputData, options) {
    if (inputData.area == null || inputData.area == "") {
        Page.Widgets.editLelangMessage.caption = "Silahkan pilih wilayah yang ingin dibuatkan lelang";
        Page.Widgets.editLelangMessage.showMessage();
        return false;
    } else if (Page.Widgets.titleEditLelang.datavalue == "" || Page.Widgets.titleEditLelang.datavalue == null || Page.Widgets.titleEditLelang.datavalue == undefined) {
        Page.Widgets.editLelangMessage.caption = "Judul tidak boleh kosong";
        Page.Widgets.editLelangMessage.showMessage();
        return false;
    } else if (Page.Widgets.editEndDateLelang.datavalue == undefined || Page.Widgets.editStartDateLelang.datavalue == undefined || Page.Widgets.editEndDateLelang.datavalue == null || Page.Widgets.editStartDateLelang.datavalue == null) {
        Page.Widgets.editLelangMessage.caption = "Tanggal mulai dan tanggal berakhir tidak boleh kosong";
        Page.Widgets.editLelangMessage.showMessage();
        return false;
    } else if (inputData.endDate < inputData.startDate) {
        Page.Widgets.editLelangMessage.caption = "Tanggal berakhir harus lebih besar dari tanggal mulai";
        Page.Widgets.editLelangMessage.showMessage();
        return false;
    }
};

Page.GetLelangSKDetailByIDLelangListonBeforeDatasetReady = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        data[i].number = i + 1;
    }
};

Page.addNoAggrClose = function($event, widget) {
    Page.Variables.imageUploaded.dataSet = [];
};

Page.addNoAggrOpened = function($event, widget) {
    Page.Variables.imageUploaded.dataSet = [];
    Page.Variables.GetNoAggrListLelang.invoke();
};

Page.FileServiceUploadFileonSuccess = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        Page.Variables.imageUploaded.addItem({
            dataValue: data[i].inlinePath
        })
    }
};

Page.InsertNewSKDetailonSuccess = function(variable, data) {
    for (var i = 0; i < Page.Variables.imageUploaded.dataSet.length; i++) {
        Page.Variables.InsertLelangSKImages.createRecord({
            row: {
                'skListAuctionId': data.id,
                'url': Page.Variables.imageUploaded.dataSet[i].dataValue
            }
        }, function(data) {}, function(error) {});
    }
};

Page.InsertNewSKDetailonBeforeInsertRecord = function(variable, inputData, options) {
    if (Page.Widgets.noAggrAddLelang.datavalue == "" || Page.Widgets.noAggrAddLelang.datavalue == null || Page.Widgets.noAggrAddLelang.datavalue == undefined) {
        Page.Widgets.errorParamNoKontrak.caption = "Silahkan pilih no kontrak yang ingin dibuatkan lelang";
        Page.Widgets.errorParamNoKontrak.showMessage();
        return false;
    } else if (Page.Widgets.btoAddLelang.datavalue == "" || Page.Widgets.btoAddLelang.datavalue == null || Page.Widgets.btoAddLelang.datavalue == undefined) {
        Page.Widgets.errorParamNoKontrak.caption = "BTO Limit tidak boleh kosong";
        Page.Widgets.errorParamNoKontrak.showMessage();
        return false;
    } else if (Page.Widgets.deskripsiAddLelang.datavalue == "" || Page.Widgets.deskripsiAddLelang.datavalue == null || Page.Widgets.deskripsiAddLelang.datavalue == undefined) {
        Page.Widgets.errorParamNoKontrak.caption = "Deskripsi tidak boleh kosong";
        Page.Widgets.errorParamNoKontrak.showMessage();
        return false;
    } else if (Page.Variables.imageUploaded.dataSet.length <= 0) {
        Page.Widgets.errorParamNoKontrak.caption = "Silahkan tambahkan beberapa gambar";
        Page.Widgets.errorParamNoKontrak.showMessage();
        return false;
    }
};

Page.label99Click = function($event, widget) {
    Page.Variables.imageUploaded.dataSet = [];
};

Page.label100Click = function($event, widget) {
    Page.Variables.imageUploaded.dataSet = [];
};

Page.GetLelangImagesViewonSuccess = function(variable, data) {
    Page.Variables.imageUploaded.dataSet = [];
    for (var i = 0; i < data.length; i++) {
        Page.Variables.imageUploaded.addItem({
            dataValue: data[i].url
        })
    }
};

Page.UpdateLelangDetailonBeforeUpdateRecord = function(variable, inputData, options) {
    if (Page.Widgets.noAggrEditLelang.datavalue == "" || Page.Widgets.noAggrEditLelang.datavalue == null || Page.Widgets.noAggrEditLelang.datavalue == undefined) {
        Page.Widgets.errorParamKontrakEdit.caption = "Silahkan pilih no kontrak yang ingin dibuatkan lelang";
        Page.Widgets.errorParamKontrakEdit.showMessage();
        return false;
    } else if (Page.Widgets.btoEditLelang.datavalue == "" || Page.Widgets.btoEditLelang.datavalue == null || Page.Widgets.btoEditLelang.datavalue == undefined) {
        Page.Widgets.errorParamKontrakEdit.caption = "BTO Limit tidak boleh kosong";
        Page.Widgets.errorParamKontrakEdit.showMessage();
        return false;
    } else if (Page.Widgets.deskripsiEditLelang.datavalue == "" || Page.Widgets.deskripsiEditLelang.datavalue == null || Page.Widgets.deskripsiEditLelang.datavalue == undefined) {
        Page.Widgets.errorParamKontrakEdit.caption = "Deskripsi tidak boleh kosong";
        Page.Widgets.errorParamKontrakEdit.showMessage();
        return false;
    } else if (Page.Variables.imageUploaded.dataSet.length <= 0) {
        Page.Widgets.errorParamKontrakEdit.caption = "Silahkan tambahkan beberapa gambar";
        Page.Widgets.errorParamKontrakEdit.showMessage();
        return false;
    }
};

Page.UpdateLelangDetailonSuccess = function(variable, data) {
    Page.Variables.HapusLelangImages.invoke({}, function(data) {
        for (var i = 0; i < Page.Variables.imageUploaded.dataSet.length; i++) {
            Page.Variables.InsertLelangSKImages.createRecord({
                row: {
                    'skListAuctionId': Page.Widgets.noAggrList.selecteditem.id,
                    'url': Page.Variables.imageUploaded.dataSet[i].dataValue
                }
            }, function(data) {}, function(error) {});
        }
        Page.Variables.imageUploaded.dataSet = [];
    }, function(error) {});
};

Page.checkbox2Change = function($event, widget, newVal, oldVal) {
    if (newVal == true) {
        for (var i = 0; i < Page.Variables.listParticipant.dataSet.length; i++) {
            Page.Variables.listParticipant.dataSet[i].participant = true;
        }
    } else {
        for (var i = 0; i < Page.Variables.listParticipant.dataSet.length; i++) {
            Page.Variables.listParticipant.dataSet[i].participant = false;
        }
    }
};

Page.GetAllListPesertaLelangonSuccess = function(variable, data) {
    Page.Variables.listParticipant.dataSet = [];
    for (var i = 0; i < data.length; i++) {
        Page.Variables.listParticipant.addItem({
            full_name: data[i].fullName,
            coll_cd: data[i].cdColl,
            branch_id: data[i].branchId,
            remo: data[i].areaName,
            badge: data[i].badgeType,
            participant: data[i].participant
        })
    }
};

Page.subfilterRemoChange = function($event, widget, newVal, oldVal) {
    if (newVal != "") {
        Page.Variables.GetAllListPesertaLelang.invoke({
            "inputFields": {
                "idLelang": Page.Widgets.newLelangArea.selecteditem.id,
                "area": "%" + newVal + "%",
                "badge": "%%"
            }
        }, function(data) {}, function(error) {});
    }
};

Page.subfilterBadgesChange = function($event, widget, newVal, oldVal) {
    if (newVal != "") {
        Page.Variables.GetAllListPesertaLelang.invoke({
            "inputFields": {
                "idLelang": Page.Widgets.newLelangArea.selecteditem.id,
                "area": "%%",
                "badge": "%" + newVal + "%"
            }
        }, function(data) {}, function(error) {});
    }
};

Page.filterChange = function($event, widget, newVal, oldVal) {
    if (newVal == "") {
        Page.Variables.GetAllListPesertaLelang.invoke({
            "inputFields": {
                "idLelang": Page.Widgets.newLelangArea.selecteditem.id,
                "area": "%%",
                "badge": "%%"
            }
        }, function(data) {}, function(error) {});
    }
};

Page.GetLelangAktifonBeforeDatasetReady = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        data[i].number = i + 1;
    }
};

Page.GetLelangTidakAktifonBeforeDatasetReady = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        data[i].number = i + 1;
    }
};

Page.GetParticipantLelangDetailTidakAktifonBeforeDatasetReady = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        data[i].number = i + 1;
    }
};

Page.GetParticipantLelangDetailAktifonBeforeDatasetReady = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        data[i].number = i + 1;
    }
};

Page.GetDocumentLelangonBeforeDatasetReady = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        data[i].number = i + 1;
    }
};

Page.GetPilihWinnerSKListonBeforeDatasetReady = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        data[i].number = i + 1;
    }
};

Page.GetParticipantLelangPilihWinneronBeforeDatasetReady = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        data[i].number = i + 1;
    }
};

Page.button12Click = function($event, widget) {
    for (var i = 0; i < Page.Variables.listParticipant.dataSet.length; i++) {
        if (Page.Variables.listParticipant.dataSet[i].participant == true) {
            Page.Variables.InsertLelangParticipant.createRecord({
                row: {
                    'lelangSkId': Page.Widgets.newLelangArea.selecteditem.id,
                    'cdColl': Page.Variables.listParticipant.dataSet[i].coll_cd
                }
            }, function(data) {}, function(error) {});
        }
    }
    App.Actions.suksesInsert.invoke();
    Page.Widgets.addParticipant.close();
};

Page.GetLelangSKDetailByIDLelangListonBeforeUpdate = function(variable, inputData, options) {
    if (inputData.lelangId == null) {
        return false;
    }
};

Page.SetPemenangLelangonBeforeUpdate = function(variable, inputData, options) {
    if (inputData.cdColl == null || inputData.cdColl == "" || inputData.cdColl == undefined) {
        Page.Actions.winnerNotSelected.invoke();
        return false;
    }
};

Page.InsertNotifLelangonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
};