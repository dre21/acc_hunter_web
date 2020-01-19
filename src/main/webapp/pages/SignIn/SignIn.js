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

Page.picture4Click = function($event, widget) {
    var elem = document.getElementsByClassName("login-password")

    if (Page.Variables.passTypeText.dataSet.dataValue === "password") {
        $(elem).attr({
            'type': 'text'
        });

        Page.Widgets.picture4_1.show = true;
        Page.Widgets.picture4.show = false;

        Page.Variables.passTypeText.dataSet.dataValue = "text";
    } else {
        $(elem).attr({
            'type': 'password'
        });

        Page.Widgets.picture4_1.show = false;
        Page.Widgets.picture4.show = true;

        Page.Variables.passTypeText.dataSet.dataValue = "password";
    }
};

Page.serviceEncryptPassonResult = function(variable, data) {
    console.log("On Result", data);
};

Page.serviceEncryptPassonSuccess = function(variable, data) {
    console.log("On Success", data);
};

Page.serviceEncryptPassonBeforeUpdate = function(variable, inputData, options) {
    console.log("Before update", inputData);
};

Page.serviceEncryptPassonError = function(variable, data) {
    console.log("On Error", data);
};

Page.loginActiononResult = function(variable, data) {
    console.log("Login Action Result", data);
};

Page.loginActiononSuccess = function(variable, data) {
    console.log("Login Action Success");
};
Page.button1Click = function($event, widget) {
    // assign password to be encrypted here
    App.Variables.loginEncryptPass.setInput(Page.Widgets.j_password.datavalue);
    App.Variables.loginEncryptPass.invoke();
};