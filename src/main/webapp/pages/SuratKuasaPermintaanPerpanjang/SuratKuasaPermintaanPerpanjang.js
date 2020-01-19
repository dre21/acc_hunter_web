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
    Page.Widgets.approvedContainer.show = false;
};

Page.approvedClick = function($event, widget) {
    $("#approved").addClass("clicked");
    $("#pending").removeClass("clicked");
    Page.Widgets.approvedContainer.show = true;
    Page.Widgets.pendingContainer.show = false;
};

Page.pendingClick = function($event, widget) {
    $("#pending").addClass("clicked");
    $("#approved").removeClass("clicked");
    Page.Widgets.approvedContainer.show = false;
    Page.Widgets.pendingContainer.show = true;
};

Page.GetSKRequestPerpanjangApprovedListonBeforeDatasetReady = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        data[i].number = i + 1;
    }
};

Page.GetSKRequestPerpanjangPendingListonBeforeDatasetReady = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        data[i].number = i + 1;
    }
};