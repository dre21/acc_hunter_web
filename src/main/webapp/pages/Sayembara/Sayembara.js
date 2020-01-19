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

Page.updateBadgesonBeforeUpdateRecord = function(variable, inputData, options) {
    inputData.updatedAt = new Date()
};

Page.GetSayembaraListonBeforeDatasetReady = function(variable, data) {
    console.log(data);
    for (var i = 0; i < data.length; i++) {
        data[i].value = i + 1;
    }
    console.log(data);
};