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

    Page.Widgets.paketKredit.show = true;
    Page.Widgets.saldoAR.show = false;
    Page.Widgets.btToSaldo.show = false;
    Page.Widgets.efisiensiSK.show = false;
    Page.Widgets.urutanSK.show = false;
    Page.Widgets.jenisSK.show = false;
    Page.Widgets.badgesBonus.show = false;
    Page.Widgets.seasonalPoint.show = false;
    Page.Widgets.informanContainer.show = false;
    Page.Widgets.button3.show = false;
    Page.Widgets.button5.show = false;
    Page.Widgets.messageInforman.hideMessage();
};

Page.statusConversion = function(x) {
    if (x === true) {
        return "On";
    } else {
        return "Off";
    }
}

Page.percentageConversion = function(x, y, z) {
    if (x === "-") {
        return y + "% - " + z + "%";
    } else if (x === "=") {
        return y + "%";
    } else {
        return x + "" + y + "%";
    }
}

Page.currencyConversion = function(x, y, z) {
    if (x === "-") {
        return y + " - " + z;
    } else if (x === "=") {
        return y;
    } else {
        return x + "" + y;
    }
}

Page.updateBadgesonBeforeUpdateRecord = function(variable, inputData, options) {
    inputData.updatedAt = new Date()
};

Page.button2Click = function($event, widget) {
    Page.Widgets.text3.readonly = false;
    Page.Widgets.text3.disabled = false;
    Page.Widgets.text4.readonly = false;
    Page.Widgets.text4.disabled = false;
    Page.Widgets.toggle1.readonly = false;
    Page.Widgets.toggle1.disabled = false;
    Page.Widgets.button2.show = false;
    Page.Widgets.button3.show = true;
};

Page.button2Tap = function($event, widget) {
    Page.Widgets.text3.readonly = false;
    Page.Widgets.text3.disabled = false;
    Page.Widgets.text4.readonly = false;
    Page.Widgets.text4.disabled = false;
    Page.Widgets.toggle1.readonly = false;
    Page.Widgets.toggle1.disabled = false;
    Page.Widgets.button2.show = false;
    Page.Widgets.button3.show = true;
};

Page.button4Click = function($event, widget) {
    Page.Widgets.text5.readonly = false;
    Page.Widgets.text5.disabled = false;
    Page.Widgets.toggle2.readonly = false;
    Page.Widgets.toggle2.disabled = false;
    Page.Widgets.button4.show = false;
    Page.Widgets.button5.show = true;
};

Page.button4Tap = function($event, widget) {
    Page.Widgets.text5.readonly = false;
    Page.Widgets.text5.disabled = false;
    Page.Widgets.toggle2.readonly = false;
    Page.Widgets.toggle2.disabled = false;
    Page.Widgets.button4.show = false;
    Page.Widgets.button5.show = true;
};

Page.UpdateSeasonalPointInformanonBeforeUpdateRecord = function(variable, inputData, options) {
    inputData.updatedAt = new Date();
};

Page.UpdateSuksesTarikInformanonBeforeUpdateRecord = function(variable, inputData, options) {
    inputData.updatedAt = new Date();
};

Page.button3Click = function($event, widget) {
    Page.Widgets.text3.readonly = true;
    Page.Widgets.text3.disabled = true;
    Page.Widgets.text4.readonly = true;
    Page.Widgets.text4.disabled = true;
    Page.Widgets.toggle1.readonly = true;
    Page.Widgets.toggle1.disabled = true;
    Page.Widgets.button2.show = true;
    Page.Widgets.button3.show = false;
};

Page.button3Tap = function($event, widget) {
    Page.Widgets.text3.readonly = true;
    Page.Widgets.text3.disabled = true;
    Page.Widgets.text4.readonly = true;
    Page.Widgets.text4.disabled = true;
    Page.Widgets.toggle1.readonly = true;
    Page.Widgets.toggle1.disabled = true;
    Page.Widgets.button2.show = true;
    Page.Widgets.button3.show = false;
};

Page.button5Click = function($event, widget) {
    Page.Widgets.text5.readonly = true;
    Page.Widgets.text5.disabled = true;
    Page.Widgets.toggle2.readonly = true;
    Page.Widgets.toggle2.disabled = true;
    Page.Widgets.button4.show = true;
    Page.Widgets.button5.show = false;
};

Page.button5Tap = function($event, widget) {
    Page.Widgets.text5.readonly = true;
    Page.Widgets.text5.disabled = true;
    Page.Widgets.toggle2.readonly = true;
    Page.Widgets.toggle2.disabled = true;
    Page.Widgets.button4.show = true;
    Page.Widgets.button5.show = false;
};

Page.peojfClick = function($event, widget) {
    $("#peojf").addClass("clicked");
    $("#informan").removeClass("clicked");
    Page.Widgets.informanContainer.show = false;
    Page.Widgets.peojfContainer.show = true;
};

Page.peojfTap = function($event, widget) {
    $("#peojf").addClass("clicked");
    $("#informan").removeClass("clicked");
    Page.Widgets.informanContainer.show = false;
    Page.Widgets.peojfContainer.show = true;
};

Page.informanClick = function($event, widget) {
    $("#informan").addClass("clicked");
    $("#peojf").removeClass("clicked");
    Page.Widgets.informanContainer.show = true;
    Page.Widgets.peojfContainer.show = false;
};
Page.informanTap = function($event, widget) {
    $("#informan").addClass("clicked");
    $("#peojf").removeClass("clicked");
    Page.Widgets.informanContainer.show = true;
    Page.Widgets.peojfContainer.show = false;
};

Page.container11Click = function($event, widget) {
    $("#con11").addClass("menu-peojf-clicked");
    $("#con12").removeClass("menu-peojf-clicked");
    $("#con13").removeClass("menu-peojf-clicked");
    $("#con14").removeClass("menu-peojf-clicked");
    $("#con15").removeClass("menu-peojf-clicked");
    $("#con16").removeClass("menu-peojf-clicked");
    $("#con17").removeClass("menu-peojf-clicked");
    $("#con18").removeClass("menu-peojf-clicked");

    Page.Widgets.paketKredit.show = true;
    Page.Widgets.saldoAR.show = false;
    Page.Widgets.btToSaldo.show = false;
    Page.Widgets.efisiensiSK.show = false;
    Page.Widgets.urutanSK.show = false;
    Page.Widgets.jenisSK.show = false;
    Page.Widgets.badgesBonus.show = false;
    Page.Widgets.seasonalPoint.show = false;
};

Page.container12Click = function($event, widget) {
    $("#con11").removeClass("menu-peojf-clicked");
    $("#con12").addClass("menu-peojf-clicked");
    $("#con13").removeClass("menu-peojf-clicked");
    $("#con14").removeClass("menu-peojf-clicked");
    $("#con15").removeClass("menu-peojf-clicked");
    $("#con16").removeClass("menu-peojf-clicked");
    $("#con17").removeClass("menu-peojf-clicked");
    $("#con18").removeClass("menu-peojf-clicked");

    Page.Widgets.paketKredit.show = false;
    Page.Widgets.saldoAR.show = true;
    Page.Widgets.btToSaldo.show = false;
    Page.Widgets.efisiensiSK.show = false;
    Page.Widgets.urutanSK.show = false;
    Page.Widgets.jenisSK.show = false;
    Page.Widgets.badgesBonus.show = false;
    Page.Widgets.seasonalPoint.show = false;
};

Page.container13Click = function($event, widget) {
    $("#con11").removeClass("menu-peojf-clicked");
    $("#con12").removeClass("menu-peojf-clicked");
    $("#con13").addClass("menu-peojf-clicked");
    $("#con14").removeClass("menu-peojf-clicked");
    $("#con15").removeClass("menu-peojf-clicked");
    $("#con16").removeClass("menu-peojf-clicked");
    $("#con17").removeClass("menu-peojf-clicked");
    $("#con18").removeClass("menu-peojf-clicked");

    Page.Widgets.paketKredit.show = false;
    Page.Widgets.saldoAR.show = false;
    Page.Widgets.btToSaldo.show = true;
    Page.Widgets.efisiensiSK.show = false;
    Page.Widgets.urutanSK.show = false;
    Page.Widgets.jenisSK.show = false;
    Page.Widgets.badgesBonus.show = false;
    Page.Widgets.seasonalPoint.show = false;
};

Page.container14Click = function($event, widget) {
    $("#con11").removeClass("menu-peojf-clicked");
    $("#con12").removeClass("menu-peojf-clicked");
    $("#con13").removeClass("menu-peojf-clicked");
    $("#con14").addClass("menu-peojf-clicked");
    $("#con15").removeClass("menu-peojf-clicked");
    $("#con16").removeClass("menu-peojf-clicked");
    $("#con17").removeClass("menu-peojf-clicked");
    $("#con18").removeClass("menu-peojf-clicked");

    Page.Widgets.paketKredit.show = false;
    Page.Widgets.saldoAR.show = false;
    Page.Widgets.btToSaldo.show = false;
    Page.Widgets.efisiensiSK.show = true;
    Page.Widgets.urutanSK.show = false;
    Page.Widgets.jenisSK.show = false;
    Page.Widgets.badgesBonus.show = false;
    Page.Widgets.seasonalPoint.show = false;
};

Page.container15Click = function($event, widget) {
    $("#con11").removeClass("menu-peojf-clicked");
    $("#con12").removeClass("menu-peojf-clicked");
    $("#con13").removeClass("menu-peojf-clicked");
    $("#con14").removeClass("menu-peojf-clicked");
    $("#con15").addClass("menu-peojf-clicked");
    $("#con16").removeClass("menu-peojf-clicked");
    $("#con17").removeClass("menu-peojf-clicked");
    $("#con18").removeClass("menu-peojf-clicked");

    Page.Widgets.paketKredit.show = false;
    Page.Widgets.saldoAR.show = false;
    Page.Widgets.btToSaldo.show = false;
    Page.Widgets.efisiensiSK.show = false;
    Page.Widgets.urutanSK.show = true;
    Page.Widgets.jenisSK.show = false;
    Page.Widgets.badgesBonus.show = false;
    Page.Widgets.seasonalPoint.show = false;
};

Page.container16Click = function($event, widget) {
    $("#con11").removeClass("menu-peojf-clicked");
    $("#con12").removeClass("menu-peojf-clicked");
    $("#con13").removeClass("menu-peojf-clicked");
    $("#con14").removeClass("menu-peojf-clicked");
    $("#con15").removeClass("menu-peojf-clicked");
    $("#con16").addClass("menu-peojf-clicked");
    $("#con17").removeClass("menu-peojf-clicked");
    $("#con18").removeClass("menu-peojf-clicked");

    Page.Widgets.paketKredit.show = false;
    Page.Widgets.saldoAR.show = false;
    Page.Widgets.btToSaldo.show = false;
    Page.Widgets.efisiensiSK.show = false;
    Page.Widgets.urutanSK.show = false;
    Page.Widgets.jenisSK.show = true;
    Page.Widgets.badgesBonus.show = false;
    Page.Widgets.seasonalPoint.show = false;
};

Page.container17Click = function($event, widget) {
    $("#con11").removeClass("menu-peojf-clicked");
    $("#con12").removeClass("menu-peojf-clicked");
    $("#con13").removeClass("menu-peojf-clicked");
    $("#con14").removeClass("menu-peojf-clicked");
    $("#con15").removeClass("menu-peojf-clicked");
    $("#con16").removeClass("menu-peojf-clicked");
    $("#con17").addClass("menu-peojf-clicked");
    $("#con18").removeClass("menu-peojf-clicked");

    Page.Widgets.paketKredit.show = false;
    Page.Widgets.saldoAR.show = false;
    Page.Widgets.btToSaldo.show = false;
    Page.Widgets.efisiensiSK.show = false;
    Page.Widgets.urutanSK.show = false;
    Page.Widgets.jenisSK.show = false;
    Page.Widgets.badgesBonus.show = true;
    Page.Widgets.seasonalPoint.show = false;
};

Page.container18Click = function($event, widget) {
    $("#con11").removeClass("menu-peojf-clicked");
    $("#con12").removeClass("menu-peojf-clicked");
    $("#con13").removeClass("menu-peojf-clicked");
    $("#con14").removeClass("menu-peojf-clicked");
    $("#con15").removeClass("menu-peojf-clicked");
    $("#con16").removeClass("menu-peojf-clicked");
    $("#con17").removeClass("menu-peojf-clicked");
    $("#con18").addClass("menu-peojf-clicked");

    Page.Widgets.paketKredit.show = false;
    Page.Widgets.saldoAR.show = false;
    Page.Widgets.btToSaldo.show = false;
    Page.Widgets.efisiensiSK.show = false;
    Page.Widgets.urutanSK.show = false;
    Page.Widgets.jenisSK.show = false;
    Page.Widgets.badgesBonus.show = false;
    Page.Widgets.seasonalPoint.show = true;
};

Page.UpdateGamificationPeojfBadgesBonusonBeforeUpdateRecord = function(variable, inputData, options) {
    inputData.updatedAt = new Date()
};

Page.UpdateGamificationPeojfBtToSaldoonBeforeUpdateRecord = function(variable, inputData, options) {
    inputData.updatedAt = new Date()
};

Page.UpdateGamificationPeojfEfficiencySkonBeforeUpdateRecord = function(variable, inputData, options) {
    inputData.updatedAt = new Date()
};

Page.UpdateGamificationPeojfJenisSkonBeforeUpdateRecord = function(variable, inputData, options) {
    inputData.updatedAt = new Date()
};

Page.UpdateGamificationPeojfPaketKreditonBeforeUpdateRecord = function(variable, inputData, options) {
    inputData.updatedAt = new Date()
};

Page.UpdateGamificationPeojfSaldoAronBeforeUpdateRecord = function(variable, inputData, options) {
    inputData.updatedAt = new Date()
};

Page.UpdateGamificationPeojfSeasonalPointonBeforeUpdateRecord = function(variable, inputData, options) {
    inputData.updatedAt = new Date()
};

Page.UpdateGamificationPeojfUrutanSkonBeforeUpdateRecord = function(variable, inputData, options) {
    inputData.updatedAt = new Date()
};

Page.savePaketKreditClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.paketKreditValueEdit.datavalue === "" || Page.Widgets.paketKreditValueEdit.datavalue === null || Page.Widgets.paketKreditValueEdit.datavalue === undefined) {
        Page.Widgets.messagePaketKredit.caption = "Value tidak boleh kosong";
        Page.Widgets.messagePaketKredit.type = "error";
        Page.Widgets.messagePaketKredit.showMessage();
        return false;
    } else if (Page.Widgets.paketKreditPoinEdit.datavalue === "" || Page.Widgets.paketKreditPoinEdit.datavalue === null || Page.Widgets.paketKreditPoinEdit.datavalue === undefined) {
        Page.Widgets.messagePaketKredit.caption = "Poin tidak boleh kosong";
        Page.Widgets.messagePaketKredit.type = "error";
        Page.Widgets.messagePaketKredit.showMessage();
        return false;
    }
    Page.Variables.UpdateGamificationPeojfPaketKredit.updateRecord();
};

Page.saveUrutanSKClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.urutanSKValueEdit.datavalue === "" || Page.Widgets.urutanSKValueEdit.datavalue === null || Page.Widgets.urutanSKValueEdit.datavalue === undefined) {
        Page.Widgets.messageUrutanSK.caption = "Value tidak boleh kosong";
        Page.Widgets.messageUrutanSK.type = "error";
        Page.Widgets.messageUrutanSK.showMessage();
        return false;
    } else if (Page.Widgets.urutanSKPoinEdit.datavalue === "" || Page.Widgets.urutanSKPoinEdit.datavalue === null || Page.Widgets.urutanSKPoinEdit.datavalue === undefined) {
        Page.Widgets.messageUrutanSK.caption = "Poin tidak boleh kosong";
        Page.Widgets.messageUrutanSK.type = "error";
        Page.Widgets.messageUrutanSK.showMessage();
        return false;
    }
    Page.Variables.UpdateGamificationPeojfUrutanSk.updateRecord();
};

Page.saveJenisSKClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.jenisSKValueEdit.datavalue === "" || Page.Widgets.jenisSKValueEdit.datavalue === null || Page.Widgets.jenisSKValueEdit.datavalue === undefined) {
        Page.Widgets.messageJenisSK.caption = "Value tidak boleh kosong";
        Page.Widgets.messageJenisSK.type = "error";
        Page.Widgets.messageJenisSK.showMessage();
        return false;
    } else if (Page.Widgets.jenisSKPoinEdit.datavalue === "" || Page.Widgets.jenisSKPoinEdit.datavalue === null || Page.Widgets.jenisSKPoinEdit.datavalue === undefined) {
        Page.Widgets.messageJenisSK.caption = "Poin tidak boleh kosong";
        Page.Widgets.messageJenisSK.type = "error";
        Page.Widgets.messageJenisSK.showMessage();
        return false;
    }
    Page.Variables.UpdateGamificationPeojfJenisSk.updateRecord();
};

Page.saveBadgeClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.badgesBonusValueEdit.datavalue === "" || Page.Widgets.badgesBonusValueEdit.datavalue === null || Page.Widgets.badgesBonusValueEdit.datavalue === undefined) {
        Page.Widgets.messageBadgeBonus.caption = "Value tidak boleh kosong";
        Page.Widgets.messageBadgeBonus.type = "error";
        Page.Widgets.messageBadgeBonus.showMessage();
        return false;
    } else if (Page.Widgets.badgesBonusPoinEdit.datavalue === "" || Page.Widgets.badgesBonusPoinEdit.datavalue === null || Page.Widgets.badgesBonusPoinEdit.datavalue === undefined) {
        Page.Widgets.messageBadgeBonus.caption = "Poin multiplication tidak boleh kosong";
        Page.Widgets.messageBadgeBonus.type = "error";
        Page.Widgets.messageBadgeBonus.showMessage();
        return false;
    }
    Page.Variables.UpdateGamificationPeojfBadgesBonus.updateRecord();
};

Page.saveSeasonalClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.seasonalValueEdit.datavalue === "" || Page.Widgets.seasonalValueEdit.datavalue === null || Page.Widgets.seasonalValueEdit.datavalue === undefined) {
        Page.Widgets.messageSeasonalPoint.caption = "Value tidak boleh kosong";
        Page.Widgets.messageSeasonalPoint.type = "error";
        Page.Widgets.messageSeasonalPoint.showMessage();
        return false;
    } else if (Page.Widgets.seasonalPoinEdit.datavalue === "" || Page.Widgets.seasonalPoinEdit.datavalue === null || Page.Widgets.seasonalPoinEdit.datavalue === undefined) {
        Page.Widgets.messageSeasonalPoint.caption = "Poin multiplication tidak boleh kosong";
        Page.Widgets.messageSeasonalPoint.type = "error";
        Page.Widgets.messageSeasonalPoint.showMessage();
        return false;
    }
    Page.Variables.UpdateGamificationPeojfSeasonalPoint.updateRecord();
};

Page.saveSaldoArClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.saldoArOperatorEdit.datavalue === "" || Page.Widgets.saldoArOperatorEdit.datavalue === null || Page.Widgets.saldoArOperatorEdit.datavalue === undefined) {
        Page.Widgets.messageSaldoAR.caption = "Value operator tidak boleh kosong";
        Page.Widgets.messageSaldoAR.type = "error";
        Page.Widgets.messageSaldoAR.showMessage();
        return false;
    } else if (Page.Widgets.saldoArValue1Edit.datavalue === "" || Page.Widgets.saldoArValue1Edit.datavalue === null || Page.Widgets.saldoArValue1Edit.datavalue === undefined) {
        if (Page.Widgets.saldoArOperatorEdit.datavalue === "-") {
            Page.Widgets.messageSaldoAR.caption = "Value amount 1 tidak boleh kosong";
        } else {
            Page.Widgets.messageSaldoAR.caption = "Value amount tidak boleh kosong";
        }
        Page.Widgets.messageSaldoAR.type = "error";
        Page.Widgets.messageSaldoAR.showMessage();
        return false;
    } else if (Page.Widgets.saldoArOperatorEdit.datavalue === "-" && (Page.Widgets.saldoArValue2Edit.datavalue === "" || Page.Widgets.saldoArValue2Edit.datavalue === null || Page.Widgets.saldoArValue2Edit.datavalue === undefined)) {
        Page.Widgets.messageSaldoAR.caption = "Value amount 2 tidak boleh kosong";
        Page.Widgets.messageSaldoAR.type = "error";
        Page.Widgets.messageSaldoAR.showMessage();
        return false;
    } else if (Page.Widgets.saldoArPoinEdit.datavalue === "" || Page.Widgets.saldoArPoinEdit.datavalue === null || Page.Widgets.saldoArPoinEdit.datavalue === undefined) {
        Page.Widgets.messageSaldoAR.caption = "Poin tidak boleh kosong";
        Page.Widgets.messageSaldoAR.type = "error";
        Page.Widgets.messageSaldoAR.showMessage();
        return false;
    }
    Page.Variables.UpdateGamificationPeojfSaldoAr.updateRecord();
};

Page.saveBTToSaldoClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.btToSaldoOperatorEdit.datavalue === "" || Page.Widgets.btToSaldoOperatorEdit.datavalue === null || Page.Widgets.btToSaldoOperatorEdit.datavalue === undefined) {
        Page.Widgets.messageBTToSaldo.caption = "Value operator tidak boleh kosong";
        Page.Widgets.messageBTToSaldo.type = "error";
        Page.Widgets.messageBTToSaldo.showMessage();
        return false;
    } else if (Page.Widgets.btToSaldoValue1Edit.datavalue === "" || Page.Widgets.btToSaldoValue1Edit.datavalue === null || Page.Widgets.btToSaldoValue1Edit.datavalue === undefined) {
        if (Page.Widgets.btToSaldoOperatorEdit.datavalue === "-") {
            Page.Widgets.messageBTToSaldo.caption = "Value percentage 1 tidak boleh kosong";
        } else {
            Page.Widgets.messageBTToSaldo.caption = "Value percentage tidak boleh kosong";
        }
        Page.Widgets.messageBTToSaldo.type = "error";
        Page.Widgets.messageBTToSaldo.showMessage();
        return false;
    } else if (Page.Widgets.btToSaldoOperatorEdit.datavalue === "-" && (Page.Widgets.btToSaldoValue2Edit.datavalue === "" || Page.Widgets.btToSaldoValue2Edit.datavalue === null || Page.Widgets.btToSaldoValue2Edit.datavalue === undefined)) {
        Page.Widgets.messageBTToSaldo.caption = "Value percentage 2 tidak boleh kosong";
        Page.Widgets.messageBTToSaldo.type = "error";
        Page.Widgets.messageBTToSaldo.showMessage();
        return false;
    } else if (Page.Widgets.btToSaldoPoinEdit.datavalue === "" || Page.Widgets.btToSaldoPoinEdit.datavalue === null || Page.Widgets.btToSaldoPoinEdit.datavalue === undefined) {
        Page.Widgets.messageBTToSaldo.caption = "Poin tidak boleh kosong";
        Page.Widgets.messageBTToSaldo.type = "error";
        Page.Widgets.messageBTToSaldo.showMessage();
        return false;
    } else if (Page.Widgets.btToSaldoValue1Edit.datavalue > 100) {
        if (Page.Widgets.btToSaldoOperatorEdit.datavalue === "-") {
            Page.Widgets.messageBTToSaldo.caption = "Value percentage 1 tidak boleh lebih dari 100";
        } else {
            Page.Widgets.messageBTToSaldo.caption = "Value percentage tidak boleh lebih dari 100";
        }
        Page.Widgets.messageBTToSaldo.type = "error";
        Page.Widgets.messageBTToSaldo.showMessage();
        return false;
    } else if (Page.Widgets.btToSaldoValue2Edit.datavalue > 100) {
        Page.Widgets.messageBTToSaldo.caption = "Value percentage 2 tidak boleh lebih dari 100";
        Page.Widgets.messageBTToSaldo.type = "error";
        Page.Widgets.messageBTToSaldo.showMessage();
        return false;
    }
    Page.Variables.UpdateGamificationPeojfBtToSaldo.updateRecord();
};

Page.saveEfficiencySKClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.efficiencySKOperatorEdit.datavalue === "" || Page.Widgets.efficiencySKOperatorEdit.datavalue === null || Page.Widgets.efficiencySKOperatorEdit.datavalue === undefined) {
        Page.Widgets.messageEfficiencySK.caption = "Value operator tidak boleh kosong";
        Page.Widgets.messageEfficiencySK.type = "error";
        Page.Widgets.messageEfficiencySK.showMessage();
        return false;
    } else if (Page.Widgets.efficiencySKValue1Edit.datavalue === "" || Page.Widgets.efficiencySKValue1Edit.datavalue === null || Page.Widgets.efficiencySKValue1Edit.datavalue === undefined) {
        if (Page.Widgets.efficiencySKOperatorEdit.datavalue === "-") {
            Page.Widgets.messageEfficiencySK.caption = "Value percentage 1 tidak boleh kosong";
        } else {
            Page.Widgets.messageEfficiencySK.caption = "Value percentage tidak boleh kosong";
        }
        Page.Widgets.messageEfficiencySK.type = "error";
        Page.Widgets.messageEfficiencySK.showMessage();
        return false;
    } else if (Page.Widgets.efficiencySKOperatorEdit.datavalue === "-" && (Page.Widgets.efficiencySKValue2Edit.datavalue === "" || Page.Widgets.efficiencySKValue2Edit.datavalue === null || Page.Widgets.efficiencySKValue2Edit.datavalue === undefined)) {
        Page.Widgets.messageEfficiencySK.caption = "Value percentage 2 tidak boleh kosong";
        Page.Widgets.messageEfficiencySK.type = "error";
        Page.Widgets.messageEfficiencySK.showMessage();
        return false;
    } else if (Page.Widgets.efficiencySKPoinEdit.datavalue === "" || Page.Widgets.efficiencySKPoinEdit.datavalue === null || Page.Widgets.efficiencySKPoinEdit.datavalue === undefined) {
        Page.Widgets.messageEfficiencySK.caption = "Poin tidak boleh kosong";
        Page.Widgets.messageEfficiencySK.type = "error";
        Page.Widgets.messageEfficiencySK.showMessage();
        return false;
    } else if (Page.Widgets.efficiencySKValue1Edit.datavalue > 100) {
        if (Page.Widgets.efficiencySKOperatorEdit.datavalue === "-") {
            Page.Widgets.messageEfficiencySK.caption = "Value percentage 1 tidak boleh lebih dari 100";
        } else {
            Page.Widgets.messageEfficiencySK.caption = "Value percentage tidak boleh lebih dari 100";
        }
        Page.Widgets.messageEfficiencySK.type = "error";
        Page.Widgets.messageEfficiencySK.showMessage();
        return false;
    } else if (Page.Widgets.efficiencySKValue2Edit.datavalue > 100) {
        Page.Widgets.messageEfficiencySK.caption = "Value percentage 2 tidak boleh lebih dari 100";
        Page.Widgets.messageEfficiencySK.type = "error";
        Page.Widgets.messageEfficiencySK.showMessage();
        return false;
    }
    Page.Variables.UpdateGamificationPeojfEfficiencySk.updateRecord();
};

Page.InsertGamificationPeojfBadgesBonusonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
};

Page.InsertGamificationPeojfBtToSaldoonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
    inputData.mathOperator = Page.Widgets.btToSaldoOperatorAdd.datavalue;
};

Page.InsertGamificationPeojfEfficiencySkonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
    inputData.mathOperator = Page.Widgets.efficiencySKOperatorAdd.datavalue;
};

Page.InsertGamificationPeojfJenisSkonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
};

Page.InsertGamificationPeojfPaketKreditonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
};

Page.InsertGamificationPeojfSaldoAronBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
    inputData.mathOperator = Page.Widgets.saldoArOperatorAdd.datavalue;
};

Page.InsertGamificationPeojfSeasonalPointonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
};

Page.InsertGamificationPeojfUrutanSkonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
};

Page.saveAddPaketKreditClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.paketKreditValueAdd.datavalue === "" || Page.Widgets.paketKreditValueAdd.datavalue === null || Page.Widgets.paketKreditValueAdd.datavalue === undefined) {
        Page.Widgets.messageAddPaketKredit.caption = "Value tidak boleh kosong";
        Page.Widgets.messageAddPaketKredit.type = "error";
        Page.Widgets.messageAddPaketKredit.showMessage();
        return false;
    } else if (Page.Widgets.paketKreditPoinAdd.datavalue === "" || Page.Widgets.paketKreditPoinAdd.datavalue === null || Page.Widgets.paketKreditPoinAdd.datavalue === undefined) {
        Page.Widgets.messageAddPaketKredit.caption = "Poin tidak boleh kosong";
        Page.Widgets.messageAddPaketKredit.type = "error";
        Page.Widgets.messageAddPaketKredit.showMessage();
        return false;
    }
    Page.Variables.InsertGamificationPeojfPaketKredit.createRecord();
};

Page.saveAddUrutanSKClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.urutanSKValueAdd.datavalue === "" || Page.Widgets.urutanSKValueAdd.datavalue === null || Page.Widgets.urutanSKValueAdd.datavalue === undefined) {
        Page.Widgets.messageAddUrutanSK.caption = "Value tidak boleh kosong";
        Page.Widgets.messageAddUrutanSK.type = "error";
        Page.Widgets.messageAddUrutanSK.showMessage();
        return false;
    } else if (Page.Widgets.urutanSKPoinAdd.datavalue === "" || Page.Widgets.urutanSKPoinAdd.datavalue === null || Page.Widgets.urutanSKPoinAdd.datavalue === undefined) {
        Page.Widgets.messageAddUrutanSK.caption = "Poin tidak boleh kosong";
        Page.Widgets.messageAddUrutanSK.type = "error";
        Page.Widgets.messageAddUrutanSK.showMessage();
        return false;
    }
    Page.Variables.InsertGamificationPeojfUrutanSk.createRecord();
};

Page.saveAddJenisSKClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.jenisSKValueAdd.datavalue === "" || Page.Widgets.jenisSKValueAdd.datavalue === null || Page.Widgets.jenisSKValueAdd.datavalue === undefined) {
        Page.Widgets.messageAddJenisSK.caption = "Value tidak boleh kosong";
        Page.Widgets.messageAddJenisSK.type = "error";
        Page.Widgets.messageAddJenisSK.showMessage();
        return false;
    } else if (Page.Widgets.jenisSKPoinAdd.datavalue === "" || Page.Widgets.jenisSKPoinAdd.datavalue === null || Page.Widgets.jenisSKPoinAdd.datavalue === undefined) {
        Page.Widgets.messageAddJenisSK.caption = "Poin tidak boleh kosong";
        Page.Widgets.messageAddJenisSK.type = "error";
        Page.Widgets.messageAddJenisSK.showMessage();
        return false;
    }
    Page.Variables.InsertGamificationPeojfJenisSk.createRecord();
};

Page.saveAddBadgeClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.badgesBonusValueAdd.datavalue === "" || Page.Widgets.badgesBonusValueAdd.datavalue === null || Page.Widgets.badgesBonusValueAdd.datavalue === undefined) {
        Page.Widgets.messageAddBadgeBonus.caption = "Value tidak boleh kosong";
        Page.Widgets.messageAddBadgeBonus.type = "error";
        Page.Widgets.messageAddBadgeBonus.showMessage();
        return false;
    } else if (Page.Widgets.badgesBonusPoinAdd.datavalue === "" || Page.Widgets.badgesBonusPoinAdd.datavalue === null || Page.Widgets.badgesBonusPoinAdd.datavalue === undefined) {
        Page.Widgets.messageAddBadgeBonus.caption = "Poin multiplication tidak boleh kosong";
        Page.Widgets.messageAddBadgeBonus.type = "error";
        Page.Widgets.messageAddBadgeBonus.showMessage();
        return false;
    }
    Page.Variables.InsertGamificationPeojfBadgesBonus.createRecord();
};

Page.saveAddSeasonalClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.seasonalValueAdd.datavalue === "" || Page.Widgets.seasonalValueAdd.datavalue === null || Page.Widgets.seasonalValueAdd.datavalue === undefined) {
        Page.Widgets.messageAddSeasonalPoint.caption = "Value tidak boleh kosong";
        Page.Widgets.messageAddSeasonalPoint.type = "error";
        Page.Widgets.messageAddSeasonalPoint.showMessage();
        return false;
    } else if (Page.Widgets.seasonalPoinAdd.datavalue === "" || Page.Widgets.seasonalPoinAdd.datavalue === null || Page.Widgets.seasonalPoinAdd.datavalue === undefined) {
        Page.Widgets.messageAddSeasonalPoint.caption = "Poin multiplication tidak boleh kosong";
        Page.Widgets.messageAddSeasonalPoint.type = "error";
        Page.Widgets.messageAddSeasonalPoint.showMessage();
        return false;
    }
    Page.Variables.InsertGamificationPeojfSeasonalPoint.createRecord();
};

Page.saveAddSaldoArClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.saldoArOperatorAdd.datavalue === "" || Page.Widgets.saldoArOperatorAdd.datavalue === null || Page.Widgets.saldoArOperatorAdd.datavalue === undefined) {
        Page.Widgets.messageAddSaldoAR.caption = "Value operator tidak boleh kosong";
        Page.Widgets.messageAddSaldoAR.type = "error";
        Page.Widgets.messageAddSaldoAR.showMessage();
        return false;
    } else if (Page.Widgets.saldoArValue1Add.datavalue === "" || Page.Widgets.saldoArValue1Add.datavalue === null || Page.Widgets.saldoArValue1Add.datavalue === undefined) {
        if (Page.Widgets.saldoArOperatorAdd.datavalue === "-") {
            Page.Widgets.messageAddSaldoAR.caption = "Value amount 1 tidak boleh kosong";
        } else {
            Page.Widgets.messageAddSaldoAR.caption = "Value amount tidak boleh kosong";
        }
        Page.Widgets.messageAddSaldoAR.type = "error";
        Page.Widgets.messageAddSaldoAR.showMessage();
        return false;
    } else if (Page.Widgets.saldoArOperatorAdd.datavalue === "-" && (Page.Widgets.saldoArValue2Add.datavalue === "" || Page.Widgets.saldoArValue2Add.datavalue === null || Page.Widgets.saldoArValue2Add.datavalue === undefined)) {
        Page.Widgets.messageAddSaldoAR.caption = "Value amount 2 tidak boleh kosong";
        Page.Widgets.messageAddSaldoAR.type = "error";
        Page.Widgets.messageAddSaldoAR.showMessage();
        return false;
    } else if (Page.Widgets.saldoArPoinAdd.datavalue === "" || Page.Widgets.saldoArPoinAdd.datavalue === null || Page.Widgets.saldoArPoinAdd.datavalue === undefined) {
        Page.Widgets.messageAddSaldoAR.caption = "Poin tidak boleh kosong";
        Page.Widgets.messageAddSaldoAR.type = "error";
        Page.Widgets.messageAddSaldoAR.showMessage();
        return false;
    }
    Page.Variables.InsertGamificationPeojfSaldoAr.createRecord();
};

Page.saveAddBTToSaldoClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.btToSaldoOperatorAdd.datavalue === "" || Page.Widgets.btToSaldoOperatorAdd.datavalue === null || Page.Widgets.btToSaldoOperatorAdd.datavalue === undefined) {
        Page.Widgets.messageAddBTToSaldo.caption = "Value operator tidak boleh kosong";
        Page.Widgets.messageAddBTToSaldo.type = "error";
        Page.Widgets.messageAddBTToSaldo.showMessage();
        return false;
    } else if (Page.Widgets.btToSaldoValue1Add.datavalue === "" || Page.Widgets.btToSaldoValue1Add.datavalue === null || Page.Widgets.btToSaldoValue1Add.datavalue === undefined) {
        if (Page.Widgets.btToSaldoOperatorAdd.datavalue === "-") {
            Page.Widgets.messageAddBTToSaldo.caption = "Value percentage 1 tidak boleh kosong";
        } else {
            Page.Widgets.messageAddBTToSaldo.caption = "Value percentage tidak boleh kosong";
        }
        Page.Widgets.messageAddBTToSaldo.type = "error";
        Page.Widgets.messageAddBTToSaldo.showMessage();
        return false;
    } else if (Page.Widgets.btToSaldoOperatorAdd.datavalue === "-" && (Page.Widgets.btToSaldoValue2Add.datavalue === "" || Page.Widgets.btToSaldoValue2Add.datavalue === null || Page.Widgets.btToSaldoValue2Add.datavalue === undefined)) {
        Page.Widgets.messageAddBTToSaldo.caption = "Value percentage 2 tidak boleh kosong";
        Page.Widgets.messageAddBTToSaldo.type = "error";
        Page.Widgets.messageAddBTToSaldo.showMessage();
        return false;
    } else if (Page.Widgets.btToSaldoPoinAdd.datavalue === "" || Page.Widgets.btToSaldoPoinAdd.datavalue === null || Page.Widgets.btToSaldoPoinAdd.datavalue === undefined) {
        Page.Widgets.messageAddBTToSaldo.caption = "Poin tidak boleh kosong";
        Page.Widgets.messageAddBTToSaldo.type = "error";
        Page.Widgets.messageAddBTToSaldo.showMessage();
        return false;
    } else if (Page.Widgets.btToSaldoValue1Add.datavalue > 100) {
        if (Page.Widgets.btToSaldoOperatorAdd.datavalue === "-") {
            Page.Widgets.messageAddBTToSaldo.caption = "Value percentage 1 tidak boleh lebih dari 100";
        } else {
            Page.Widgets.messageAddBTToSaldo.caption = "Value percentage tidak boleh lebih dari 100";
        }
        Page.Widgets.messageAddBTToSaldo.type = "error";
        Page.Widgets.messageAddBTToSaldo.showMessage();
        return false;
    } else if (Page.Widgets.btToSaldoValue2Add.datavalue > 100) {
        Page.Widgets.messageAddBTToSaldo.caption = "Value percentage 2 tidak boleh lebih dari 100";
        Page.Widgets.messageAddBTToSaldo.type = "error";
        Page.Widgets.messageAddBTToSaldo.showMessage();
        return false;
    }
    Page.Variables.InsertGamificationPeojfBtToSaldo.createRecord();
};

Page.saveAddEfficiencySKClick = function($event, widget) {
    //add form validation edit
    if (Page.Widgets.efficiencySKOperatorAdd.datavalue === "" || Page.Widgets.efficiencySKOperatorAdd.datavalue === null || Page.Widgets.efficiencySKOperatorAdd.datavalue === undefined) {
        Page.Widgets.messageAddEfficiencySK.caption = "Value operator tidak boleh kosong";
        Page.Widgets.messageAddEfficiencySK.type = "error";
        Page.Widgets.messageAddEfficiencySK.showMessage();
        return false;
    } else if (Page.Widgets.efficiencySKValue1Add.datavalue === "" || Page.Widgets.efficiencySKValue1Add.datavalue === null || Page.Widgets.efficiencySKValue1Add.datavalue === undefined) {
        if (Page.Widgets.efficiencySKOperatorAdd.datavalue === "-") {
            Page.Widgets.messageAddEfficiencySK.caption = "Value percentage 1 tidak boleh kosong";
        } else {
            Page.Widgets.messageAddEfficiencySK.caption = "Value percentage tidak boleh kosong";
        }
        Page.Widgets.messageAddEfficiencySK.type = "error";
        Page.Widgets.messageAddEfficiencySK.showMessage();
        return false;
    } else if (Page.Widgets.efficiencySKOperatorAdd.datavalue === "-" && (Page.Widgets.efficiencySKValue2Add.datavalue === "" || Page.Widgets.efficiencySKValue2Add.datavalue === null || Page.Widgets.efficiencySKValue2Add.datavalue === undefined)) {
        Page.Widgets.messageAddEfficiencySK.caption = "Value percentage 2 tidak boleh kosong";
        Page.Widgets.messageAddEfficiencySK.type = "error";
        Page.Widgets.messageAddEfficiencySK.showMessage();
        return false;
    } else if (Page.Widgets.efficiencySKPoinAdd.datavalue === "" || Page.Widgets.efficiencySKPoinAdd.datavalue === null || Page.Widgets.efficiencySKPoinAdd.datavalue === undefined) {
        Page.Widgets.messageAddEfficiencySK.caption = "Poin tidak boleh kosong";
        Page.Widgets.messageAddEfficiencySK.type = "error";
        Page.Widgets.messageAddEfficiencySK.showMessage();
        return false;
    } else if (Page.Widgets.efficiencySKValue1Add.datavalue > 100) {
        if (Page.Widgets.efficiencySKOperatorAdd.datavalue === "-") {
            Page.Widgets.messageAddEfficiencySK.caption = "Value percentage 1 tidak boleh lebih dari 100";
        } else {
            Page.Widgets.messageAddEfficiencySK.caption = "Value percentage tidak boleh lebih dari 100";
        }
        Page.Widgets.messageAddEfficiencySK.type = "error";
        Page.Widgets.messageAddEfficiencySK.showMessage();
        return false;
    } else if (Page.Widgets.efficiencySKValue2Add.datavalue > 100) {
        Page.Widgets.messageAddEfficiencySK.caption = "Value percentage 2 tidak boleh lebih dari 100";
        Page.Widgets.messageAddEfficiencySK.type = "error";
        Page.Widgets.messageAddEfficiencySK.showMessage();
        return false;
    }
    Page.Variables.InsertGamificationPeojfEfficiencySk.createRecord();
};

Page.button3Click1 = function($event, widget) {
    // add validation
    if (Page.Widgets.text3.datavalue === "" || Page.Widgets.text3.datavalue === null || Page.Widgets.text3.datavalue === undefined) {
        Page.Widgets.messageInforman.caption = "Jumlah maks selisih hari tidak boleh kosong";
        Page.Widgets.messageInforman.type = "error";
        Page.Widgets.messageInforman.showMessage();
        return false;
    } else if (Page.Widgets.text4.datavalue === "" || Page.Widgets.text4.datavalue === null || Page.Widgets.text4.datavalue === undefined) {
        Page.Widgets.messageInforman.caption = "Jumlah poin tidak boleh kosong";
        Page.Widgets.messageInforman.type = "error";
        Page.Widgets.messageInforman.showMessage();
        return false;
    }
    Page.Variables.UpdateSuksesTarikInforman.invoke();
};

Page.button5Click1 = function($event, widget) {
    // add validation
    if (Page.Widgets.text5.datavalue === "" || Page.Widgets.text5.datavalue === null || Page.Widgets.text5.datavalue === undefined) {
        Page.Widgets.messageInforman.caption = "Bonus multiplication tidak boleh kosong";
        Page.Widgets.messageInforman.type = "error";
        Page.Widgets.messageInforman.showMessage();
        return false;
    }
    Page.Variables.UpdateSeasonalPointInforman.invoke();
};

Page.UpdateSeasonalPointInformanonSuccess = function(variable, data) {
    Page.Widgets.text5.readonly = true;
    Page.Widgets.text5.disabled = true;
    Page.Widgets.toggle2.readonly = true;
    Page.Widgets.toggle2.disabled = true;
    Page.Widgets.button4.show = true;
    Page.Widgets.button5.show = false;
    Page.Widgets.messageInforman.hideMessage();
};

Page.UpdateSuksesTarikInformanonSuccess = function(variable, data) {
    Page.Widgets.text3.readonly = true;
    Page.Widgets.text3.disabled = true;
    Page.Widgets.text4.readonly = true;
    Page.Widgets.text4.disabled = true;
    Page.Widgets.toggle1.readonly = true;
    Page.Widgets.toggle1.disabled = true;
    Page.Widgets.button2.show = true;
    Page.Widgets.button3.show = false;
    Page.Widgets.messageInforman.hideMessage();
};