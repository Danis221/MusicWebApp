<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8"/>
    <#include "base.ftl">

    <#macro title>Profile</#macro>
    <link rel="stylesheet" href="css/profile.css">
</head>
<body>
<#macro content>

    <h1>Kak ze ia lublu BTS, vot oni sleva napravo: Nadjyn, Chonguk, Chingachkyk, Goiko Mitch, Djin, Uingi. Love You</h1>

    <span class="btn">  <a href="/logout" id="logout">Logout</a></span>
    <span class="btn">  <a href="/updateProfile" id="updateProfile">update Profile</a></span>


    <div class="infoOfUser">
        Login: ${user.login}<br>
        Firstname: ${user.firstname}<br>
        Lastname: ${user.lastname}<br>


    </div>


</#macro>
</body>
</html>

