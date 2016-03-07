var ajaxUrl = 'rest/releases/';
var datatableApi;

$(function () {
    datatableApi = $('#datatable').DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "paging": false,
        "info": false,
        /*"language": {
            "search": "Поиск:"
        },*/
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
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ]
    });
    makeEditable();
});

function updateTable() {
    $.ajax({
        type: "GET",
        url: ajaxUrl,
        //data: $('#filter').serialize(),
        success: function (data) {
            updateTableByData(data);
        }
    });
    return false;
}
