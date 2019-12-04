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
    console.log("Clicked show password");
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
    App.Actions.goToPage_ChangePassword.invoke();
};