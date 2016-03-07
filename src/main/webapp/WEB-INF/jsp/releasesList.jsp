<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <a class="btn btn-primary sign-btn sign-btn-primary" href="/join?source=header-home">Sign up</a>
            <a class="btn sign-btn" href="/login">Sign in</a>
        </div>
    </div>
</div>


<div class="view-box">
    <a class="btn btn-sm btn-info" id="add">Add release</a>
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

<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Release editing</h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" method="post" id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="released" class="control-label col-xs-3">Released</label>

                        <div class="col-xs-9">
                            <input class="form-control" id="released" name="released" placeholder="Released">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3">Name</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="url" class="control-label col-xs-3">url</label>

                        <div class="col-xs-9">
                            <input class="form-control" id="url" name="url">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.5/js/bootstrap.js"></script>
<script type="text/javascript" src="webjars/datatables/1.10.9/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="resources/js/datatablesUtil.js"></script>
<script type="text/javascript" src="resources/js/releaseDatatables.js"></script>
</html>