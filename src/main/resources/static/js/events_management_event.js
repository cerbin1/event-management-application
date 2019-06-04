$(document).ready(function () {
    $(':checkbox').on('click', function () {
        if (typeof ($(this).attr('readonly')) != "undefined") {
            return false;
        }
    });

    $('#backButton').on('click', function () {
        window.history.back();
    });

    $('#deleteEvent').on('click', function () {
        $.ajax({
            url: '/zarzadzanieWydarzeniami/wydarzenie/usun/TODOO',
            type: 'delete',
            params: {
                eventId: $('#eventId').val()
            },
            success: function () {
                window.location.replace('/wydarzenia/zarzadzanie')
            }
        });
    })
});