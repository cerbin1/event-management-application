$(document).ready(function () {
    $(':checkbox').on('click', function () {
        if (typeof ($(this).attr('readonly')) != "undefined") {
            return false;
        }
    });

    $('#backButton').on('click', function () {
        window.history.back();
    });


    $('#deleteEventButton').on('click', function () {
        $.ajax({
            url: '/zarzadzanieWydarzeniami/wydarzenie/usun',
            type: 'delete',
            data: {
                id: $('#eventId').val()
            },
            success: [function () {
                window.location.replace('/wydarzenia/zarzadzanie')
            }],
            error: [function () {
                $('#deleteEvent').modal('hide');
                alert("Nie udało się usunąć wydarzenia");
            }]
        });
    })
});