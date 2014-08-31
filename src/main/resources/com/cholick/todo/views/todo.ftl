<#-- @ftlvariable name="" type="com.cholick.todo.views.TodoView" -->

<html>
<body>


<ul>
<#list todos as todo>
    <li>${todo.item}</li>
</#list>
</ul>


</body>
</html>
