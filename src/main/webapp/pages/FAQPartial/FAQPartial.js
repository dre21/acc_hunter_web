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
    console.log("pageParam: ", Partial);
};


Partial.faqDataonBeforeListRecords = function(variable, dataFilter, options) {
    console.log("beforeListRecords", dataFilter);
};

Partial.faqDataonSuccess = function(variable, data) {
    console.log("success", data);
};