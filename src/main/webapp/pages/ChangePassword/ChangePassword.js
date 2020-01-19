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

Page.resetPassButtonClick = function($event, widget) {
    console.log("Reset password clicked");
    console.log("Set new generated password ");
    Page.Variables.serviceUpdPass.setInput("email", Page.Widgets.emailAddress.datavalue);
    Page.Variables.serviceUpdPass.setInput("pwd", Page.Widgets.emailAddress.datavalue);
};

Page.buttonResetClick = function($event, widget) {
    if (Page.Widgets.password.datavalue !== Page.Widgets.confPassword.datavalue) {
        Page.Actions.passNotMatch.invoke();
    } else if (/\d/.test(Page.Widgets.password.datavalue) == false || /[a-zA-Z]/.test(Page.Widgets.password.datavalue) == false) {
        Page.Actions.errorNumeric.invoke();
    } else {
        Page.Variables.changePassEncrypt.invoke();
    }
};
Page.eyeConfPasswordClick = function($event, widget) {
    var elem = document.getElementsByClassName("conf-password")
    if (Page.Variables.passTypeText.dataSet.dataValue === "password") {
        $(elem).attr({
            'type': 'text'
        });

        Page.Widgets.eyeConfOff.show = true;
        Page.Widgets.eyeConfPassword.show = false;

        Page.Variables.passTypeText.dataSet.dataValue = "text";
    } else {
        $(elem).attr({
            'type': 'password'
        });

        Page.Widgets.eyeConfOff.show = false;
        Page.Widgets.eyeConfPassword.show = true;

        Page.Variables.passTypeText.dataSet.dataValue = "password";
    }
};
Page.eyePasswordClick = function($event, widget) {
    var elem = document.getElementsByClassName("password")
    if (Page.Variables.passTypeText.dataSet.dataValue === "password") {
        $(elem).attr({
            'type': 'text'
        });

        Page.Widgets.eyeOff.show = true;
        Page.Widgets.eyePassword.show = false;

        Page.Variables.passTypeText.dataSet.dataValue = "text";
    } else {
        $(elem).attr({
            'type': 'password'
        });

        Page.Widgets.eyeOff.show = false;
        Page.Widgets.eyePassword.show = true;

        Page.Variables.passTypeText.dataSet.dataValue = "password";
    }
};

Page.serviceUpdPassonError = function(variable, data) {
    console.log("serviceUpdPassonError", data);
};