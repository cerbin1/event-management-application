$(document).ready(function () {
    initializeDataTables();
    initializeButtonOnClickListeners();

    function initializeDataTables() {
        $('#newEventsTable').DataTable();
        $('#personDetailsTable').DataTable();
    }

    function initializeButtonOnClickListeners() {
        $('#eventsLink').on('click', function () {
            $('#eventsTable').css("display", "block");
            $('#personalDataTable').css("display", "none");
            $('#eventsLink').addClass('active');
            $('#personalDataLink').removeClass('active');
        });

        $('#personalDataLink').on('click', function () {
            $('#eventsTable').css("display", "none");
            $('#personalDataTable').css("display", "block");
            $('#personalDataLink').addClass('active');
            $('#eventsLink').removeClass('active');
        });
    }
});