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
    Page.Widgets.messageLoginFailed.show = true;
    Page.Widgets.messageLoginFailed.hideMessage();
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

Page.button1Click = function($event, widget) {
    // assign password to be encrypted here
    // App.Variables.loginEncryptPass.setInput(Page.Widgets.j_password.datavalue);

    App.Actions.loginAction.invoke({
        inputFields: {
            "j_username": Page.Widgets.j_username.datavalue,
            "j_password": "App.Variables.encryptedPassword.dataSet.dataValue",
            "j_rememberme": false
        }
    }, function(dataLogin) {
        //when success
    }, function(error) {
        //when failed
        loginFailed();
    });

    var loginFailed = function() {
        countFailedLogin = Page.Variables.countFailed.dataSet.dataValue;
        Page.Variables.countFailed.dataSet.dataValue += 1;

        if (countFailedLogin === 3 || countFailedLogin >= 5) {
            var timeLeft = 60;
            Page.Widgets.messageLoginFailed.showMessage();
            Page.Widgets.messageLoginFailed.caption = "Anda terlalu banyak gagal login. Silakan coba beberapa saat lagi (" + timeLeft + "s)";
            Page.Widgets.button1.disabled = true;

            var timerId = setInterval(function() {
                if (timeLeft === -1) {
                    clearTimeout(timerId);
                    Page.Widgets.messageLoginFailed.hideMessage();
                    Page.Widgets.button1.disabled = false;
                } else {
                    Page.Widgets.messageLoginFailed.caption = "Anda terlalu banyak gagal login. Silakan coba beberapa saat lagi (" + timeLeft + "s)";
                    timeLeft--;
                }
            }, 1000);
        }
    }
};

Page.j_passwordChange = function($event, widget, newVal, oldVal) {
    let password = CryptoJS.MD5(newVal).toString();
    App.Variables.encryptedPassword.dataSet.dataValue = password;
};