$(document).ready(function () {
    $('#backButton').on('click', function () {
        window.history.back();
    });


    $('#deletePersonButton').on('click', function () {
        $.ajax({
            url: '/zarzadzanieDanymiOsobowymi/osoba/usun',
            type: 'delete',
            data: {
                id: $('#personId').val()
            },
            success: [function () {
                window.location.replace('/wydarzenia/zarzadzanie')
            }],
            error: [function () {
                $('#deletePerson').modal('hide');
                alert("Nie udało się usunąć danych osobowych");
            }]
        });
    })
});