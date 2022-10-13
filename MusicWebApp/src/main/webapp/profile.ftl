<!DOCTYPE html>
<html lang="en">

<head>
    <#include "base.ftl">

    <#macro title>Profile</#macro>
    <link rel="stylesheet" href="css/profile.css">
</head>
<body>
<#macro content>
    ${user.login}
    ${user.firstname}
    ${user.lastname}
</#macro>
</body>
</html>

