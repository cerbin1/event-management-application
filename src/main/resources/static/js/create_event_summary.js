;$(document).ready(function () {
    $(':checkbox').on('click', function () {
        if (typeof ($(this).attr('readonly')) != "undefined") {
            return false;
        }
    });

    $('#backButton').on('click', function () {
        window.history.back();
    })
});
