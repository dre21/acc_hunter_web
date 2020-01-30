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

Page.picture4Click = function($event, widget, item, currentItemWidgets) {
    if (currentItemWidgets.pictureDelete.show == false && currentItemWidgets.pictureEdit.show == false) {
        currentItemWidgets.pictureDelete.show = true;
        currentItemWidgets.pictureEdit.show = true;
    } else {
        currentItemWidgets.pictureDelete.show = false;
        currentItemWidgets.pictureEdit.show = false;
    }
};

//Delete user / upd Flag show users
Page.button2Click = function($event, widget) {
    Page.Variables.updFlagShowUsers.invoke();
};