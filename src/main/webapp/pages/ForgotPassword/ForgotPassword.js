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
        Page.Variables.passTypeText.dataSet.dataValue = "text";
    } else {
        $(elem).attr({
            'type': 'password'
        });
        Page.Variables.passTypeText.dataSet.dataValue = "password";
    }
};

Page.button1Click = function($event, widget) {
    App.Variables.userEmail.dataSet.dataValue = Page.Widgets.emailAddr.datavalue;
    //temporary Action
    // App.Actions.goToPage_ChangePassword.invoke();
};

Page.CheckEmailAvailableonSuccess = function(variable, data) {
    if (data[0]._count === 0) {
        Page.Actions.notFoundEmail.invoke();
    } else {
        App.Actions.goToPage_ForgotPasswordLinkSent.invoke();
        Page.Variables.sendEmailToUser.invoke();
    }
};

Page.sendEmailToUseronBeforeUpdate = function(variable, inputData, options) {
    inputData.emailMessage = "<p>Anda telah mencoba merubah kata sandi pada sistem ACC Hunter. Silahkan klik link dibawah ini untuk mengubah password.</p><p>http://209.97.175.242/ACC_Hunter_Web/#/ChangePassword?email=" + Page.Widgets.emailAddr.datavalue + "</p>";
};