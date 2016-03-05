var ajaxUrl = 'rest/releases';
var datatableApi;

$(function () {
    datatableApi = $('#datatable').DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "paging": false,
        "info": false,
        "language": {
            "search": "Поиск:"
        },
        "columns": [
            {
                "data": "released"
            },
            {
                "data": "name"
            },
            {
                "data": "url"
            }
        ]
    });
});
