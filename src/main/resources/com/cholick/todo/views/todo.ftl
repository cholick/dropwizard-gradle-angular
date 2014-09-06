<#-- @ftlvariable name="" type="com.cholick.todo.views.TodoView" -->

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Todo App</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

    <link rel="stylesheet" href="css/main.css">
</head>

<body>

<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Todo App</a>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Todo List for ${user}</strong>
                </div>
                <table class="table table-striped todo-table">
                <#list todos?sort_by("id")?reverse as todo>
                    <tr>
                        <td>
                            <#if todo.completed>
                                <i class="glyphicon glyphicon-ok"></i>
                            </#if>
                        </td>
                        <td>${todo.item}</td>
                    </tr>
                </#list>
                </table>
            </div>
        </div>
    </div>
</div>

</body>

</html>
