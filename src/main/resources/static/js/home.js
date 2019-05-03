$(document).ready(function () {
    console.log("ready");
    $("#locales").change(function () {
        var selectedOption = $('#locales').val();
        if (selectedOption !== '') {
            window.location.replace('international?lang=' + selectedOption);
            window.location("/");
        }
    });
});