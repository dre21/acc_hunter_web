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

Page.ReportsTable2_updaterowAction = function($event, row) {
    var img = Page.Variables.getReportImagesByReportId;
    img.setInput({
        "id": row.id
    });
    var sv = Page.Variables.getSubmittedInfoDetail;
    sv.setInput({
        "id": row.id
    });
    sv.invoke(
        function(data) {
            // Success Callback
            console.log("success", data);
        },
        function(error) {
            console.log("error", error);
        });
};
Page.SKRequestsTable_updaterowAction = function($event, row) {
    console.log("row", row);
};