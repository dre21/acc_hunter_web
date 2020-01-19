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
    console.log("Debug: ", Page.Widgets.accordionQuestion.Widgets);
};

Page.insertNewUserRemoonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
};

Page.faqDataonBeforeListRecords = function(variable, dataFilter, options) {
    console.log("Debug faqDataonBeforeListRecords", variable);
};

Page.insFaqonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
};
Page.FaqLiveForm1Success = function($event, $operation, $data) {
    Page.Widgets.FaqTable1.refreshData();
};
Page.buttonBatalClick = function($event, widget) {
    Page.Widgets.faqDialog.close();
};
Page.buttonSimpanClick = function($event, widget) {
    Page.Variables.insFaq.invoke();
};