<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="webjars/datatables/1.10.9/css/jquery.dataTables.css">
<body>
<h3>Список обновлений</h3>

<div class="view-box">
    <table class="table table-striped display" id="datatable">
        <thead>
        <tr>
            <th>Выпущено</th>
            <th>Наименование</th>
            <th>Адрес</th>
        </tr>
        </thead>
    </table>
</div>
</body>
<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.5/js/bootstrap.js"></script>
<script type="text/javascript" src="webjars/datatables/1.10.9/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="resources/js/releaseDatatables.js"></script>
</html>