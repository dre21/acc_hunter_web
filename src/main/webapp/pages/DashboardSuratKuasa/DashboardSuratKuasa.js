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

Page.DashboardSuratKuasaonSuccess = function(variable, data) {
    var ctx = document.getElementById('myChart').getContext('2d');
    var bulan = [];
    var approved = [];
    var requested = [];
    for (var i = 0; i < data.length; i++) {
        let iMonth = data[i].month.trim()
        bulan.push(iMonth);
        approved.push(data[i].approved);
        requested.push(data[i].requested);
    }

    var chart = new Chart(ctx, {
        // The type of chart we want to create
        type: 'bar',

        // The data for our dataset
        data: {
            labels: bulan,
            datasets: [{
                    label: 'Surat Kuasa Approved',
                    backgroundColor: '#285073',
                    borderColor: '#285073',
                    data: approved
                },
                {
                    label: 'Surat Kuasa Requested',
                    backgroundColor: '#B9C3C9',
                    borderColor: '#B9C3C9',
                    data: requested
                }
            ]
        },

        // Configuration options go here
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        stepSize: 20
                    }
                }]
            }
        }
    });
};

Page.yearChange = function($event, widget, newVal, oldVal) {
    Page.Variables.GetCountDashboardSK.invoke();
    Page.Variables.DashboardSuratKuasa.invoke();
};