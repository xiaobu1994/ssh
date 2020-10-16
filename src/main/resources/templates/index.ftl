<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<link rel="icon" type="image/x-icon" href="/static/img/favicon.ico">
<body>

<@shiro.hasPermission name="user:list">
    显示正常
</@shiro.hasPermission>

<@shiro.hasPermission name="user:123">
    显示正常2
</@shiro.hasPermission>

</body>
</html>