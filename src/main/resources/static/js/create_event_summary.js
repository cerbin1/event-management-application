;$(document).ready(function () {
    $(':checkbox').on('click', function () {
        if (typeof ($(this).attr('readonly')) != "undefined") {
            return false;
        }
    })
});
