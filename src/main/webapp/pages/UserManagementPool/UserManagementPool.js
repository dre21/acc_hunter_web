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


Page.insertNewUserDetailonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.userId = App.Variables.userId;
};

Page.insertNewUserDetailonError = function(variable, data) {
    console.log("Error", data);
};

Page.serviceGetUserByEmailonSuccess = function(variable, data) {
    App.Variables.userId = data.id;
    var p = Page.Variables.insertNewUserDetail;
    p.invoke();
};

Page.insertNewUserPoolonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
    App.Variables.userEmail = inputData.email;
};

Page.insertNewUserDetailonSuccess = function(variable, data) {
    Page.Actions.createUserSuccessNotification.invoke();
    Page.Widgets.newUsersDialog.close();
    Page.Actions.goToPage_UserManagementPool.invoke();

};