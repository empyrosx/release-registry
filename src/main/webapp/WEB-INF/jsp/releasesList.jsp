<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="webjars/datatables/1.10.9/css/jquery.dataTables.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>

<div class="navbar" role="navigation">
    <div class="container">
            <a class="navbar-brand">Release registry</a>
        <div class="header-actions" role="navigation">
            <a class="btn btn-primary" href="/join?source=header-home">Sign up</a>
            <a class="btn" href="/login">Sign in</a>
        </div>
    </div>
</div>

<div class="view-box">
    <table class="table table-striped display" id="datatable">
        <thead>
        <tr>
            <th>Released</th>
            <th>Name</th>
            <th>URL</th>
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