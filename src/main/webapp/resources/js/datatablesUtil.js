function makeEditable() {
    form = $('#detailsForm');

    $('#add').click(function () {
        form.find(":input").val("");
        $('#id').val(0);
        $('#editRow').modal();
    });

    form.submit(function () {
        save();
        return false;
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        //failNoty(event, jqXHR, options, jsExc);
    });
}

function save() {

    var values = {};
    form.find(":input").each(function() {
        if (this.name != "") {
            values[this.name] = $(this).val();
        }
    });
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        dataType : "json",
        "contentType" : "application/json; charset=UTF-8",
        data: JSON.stringify(values),
        success: function () {
            $('#editRow').modal('hide');
            updateTable();
            //successNoty('Saved');
        }
    });
}

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}