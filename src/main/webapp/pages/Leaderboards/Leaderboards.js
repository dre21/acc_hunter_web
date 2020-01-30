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
    Page.Widgets.informanContainer.show = false;

    Page.Widgets.startDateInforman.datavalue = "";
    Page.Widgets.endDateInforman.datavalue = "";
    Page.Widgets.remoInforman.datavalue = null;
    Page.Widgets.badgesInforman.datavalue = null;

    Page.Widgets.startDatePeojf.datavalue = "";
    Page.Widgets.endDatePeojf.datavalue = "";
    Page.Widgets.remoPeojf.datavalue = null;
    Page.Widgets.badgesPeojf.datavalue = null;
};

Page.informanClick = function($event, widget) {
    $("#informan").addClass("clicked");
    $("#peojf").removeClass("clicked");
    Page.Widgets.informanContainer.show = true;
    Page.Widgets.peojfContainer.show = false;
};

Page.peojfClick = function($event, widget) {
    $("#peojf").addClass("clicked");
    $("#informan").removeClass("clicked");
    Page.Widgets.informanContainer.show = false;
    Page.Widgets.peojfContainer.show = true;
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
};