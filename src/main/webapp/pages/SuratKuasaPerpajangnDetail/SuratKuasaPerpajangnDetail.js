/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Partial.onReady = function() {
    /*
     * variables can be accessed through 'Partial.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Partial.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Partial.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Partial.Widgets.username.datavalue'
     */
};


Partial.GetReportListByNoAggronBeforeDatasetReady = function(variable, data) {
    for (var i = 0; i < data.length; i++) {
        data[i].number = i + 1;
    }
};

Partial.CutMessage = function(x) {
    return x.substring(0, 27) + "...";
}