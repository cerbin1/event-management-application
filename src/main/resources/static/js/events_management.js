$(document).ready(function () {
    initializeDataTables();
    initializeButtonOnClickListeners();

    function initializeDataTables() {
        $('#newEventsTable').DataTable({
            "language": {
                "decimal": "",
                "emptyTable": "Brak dostępnych danych w tabeli",
                "info": "Wyświetlam stronę _PAGE_ z _PAGES_",
                "infoEmpty": "Brak wydarzeń",
                "infoFiltered": "(przefiltrowano z _MAX_ wszystkich rekordów)",
                "infoPostFix": "",
                "thousands": ",",
                "lengthMenu": "Wyświetl _MENU_ wydarzeń na stronie",
                "loadingRecords": "Ładowanie...",
                "processing": "Przetwarzanie...",
                "search": "Wyszukaj:",
                "zeroRecords": "Nie znaleziono wydarzeń",
                "paginate": {
                    "first": "Pierwsza",
                    "last": "Ostatnia",
                    "next": "Następna",
                    "previous": "Poprzednia"
                },
                "aria": {
                    "sortAscending": ": aktywuj zeby posortować rosnąco",
                    "sortDescending": ": aktywuj zeby posortować malejąco"
                }
            }
        });
        $('#personDetailsTable').DataTable({
            "language": {
                "decimal":        "",
                "emptyTable":     "Brak dostępnych danych w tabeli",
                "info":           "Wyświetlam stronę _PAGE_ z _PAGES_",
                "infoEmpty":      "Brak danych osobowych",
                "infoFiltered":   "(przefiltrowano z _MAX_ wszystkich rekordów)",
                "infoPostFix":    "",
                "thousands":      ",",
                "lengthMenu":     "Wyświetl _MENU_ danych osobowych na stronie",
                "loadingRecords": "Ładowanie...",
                "processing":     "Przetwarzanie...",
                "search":         "Wyszukaj:",
                "zeroRecords":    "Nie znaleziono danych osobowych",
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
        });
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