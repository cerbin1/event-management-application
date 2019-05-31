;$(document).ready(function () {
    $('#deleteEvent').on('click', function () {
        $.ajax({
            url: '/zarzadzanieWydarzeniami/wydarzenie/usun',
            type: 'delete',
            data: {
                eventId: $('#eventId').val()
            },
            success: function () {
                window.location.replace('/wydarzenia/zarzadzanie')
            }
        });
    })
});