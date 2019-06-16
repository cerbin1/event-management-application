$(document).ready(function () {
    $("#locales").change(function () {
        var selectedOption = $('#locales').val();
        if (selectedOption !== '') {
            window.location.replace('international?lang=' + selectedOption);
            window.location("/");
        }
    });

    initializeAcceptedEventsDatatable();

    function initializeAcceptedEventsDatatable() {
        $('#acceptedEventsTable').DataTable({
                "language": {
                    "decimal":        "",
                    "emptyTable":     "Brak dostępnych danych w tabeli",
                    "info":           "Wyświetlam stronę _PAGE_ z _PAGES_",
                    "infoEmpty":      "Brak wydarzeń",
                    "infoFiltered":   "(przefiltrowano z _MAX_ wszystkich rekordów)",
                    "infoPostFix":    "",
                    "thousands":      ",",
                    "lengthMenu":     "Wyświetl _MENU_ wydarzeń na stronie",
                    "loadingRecords": "Ładowanie...",
                    "processing":     "Przetwarzanie...",
                    "search":         "Wyszukaj:",
                    "zeroRecords":    "Nie znaleziono wydarzeń",
                    "paginate": {
                        "first":      "Pierwsza",
                        "last":       "Ostatnia",
                        "next":       "Następna",
                        "previous":   "Poprzednia"
                    },
                    "aria": {
                        "sortAscending":  ": aktywuj zeby posortować rosnąco",
                        "sortDescending": ": aktywuj zeby posortować malejąco"
                    }
                }
            }
        );
    }
});