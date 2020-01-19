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

Page.insertNewUserMitraonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.createdAt = new Date();
    App.Variables.userEmail = inputData.email;
};

Page.insertNewUserDetailonBeforeInsertRecord = function(variable, inputData, options) {
    console.log("it is called", inputData);
    inputData.userId = App.Variables.userId;
};

Page.insertNewUserBankInfoonSuccess = function(variable, data) {
    Page.Actions.createUserSuccessNotification.invoke();
    Page.Widgets.newUsersDialog.close();
    Page.Actions.goToPage_UserManagementMitra.invoke();
};

Page.insertNewUserBankInfoonBeforeInsertRecord = function(variable, inputData, options) {
    inputData.userId = App.Variables.userId;
    console.log("inputDataBankInfo: ", inputData);
};

Page.insertNewUserDetailonError = function(variable, data) {
    console.log("Error", data);
};

Page.serviceGetUserByEmailonSuccess = function(variable, data) {
    console.log("success", data);
    App.Variables.userId = data.id;

    console.log("App.Variables.userId", App.Variables.userId);

    var p = Page.Variables.insertNewUserDetail;
    p.invoke();
};

Page.picture6Click = function($event, widget, item, currentItemWidgets) {
    if (currentItemWidgets.pictureEdit.show == false) {
        currentItemWidgets.pictureEdit.show = true;
    } else {
        currentItemWidgets.pictureEdit.show = false;
    }
};