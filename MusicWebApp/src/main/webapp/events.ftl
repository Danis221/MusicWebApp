<!DOCTYPE html>
<#include "base.ftl">
<html lang="en">
<head>
    <meta charset="UTF-8">

    <#macro title>Events</#macro>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>

<body>
<#macro content>
    <span class="Create event" style="color: #999999; padding: 20px 20px">  <a href="/createEvent" id="createEvent">Create Event</a></span>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Concert Date</th>
            <th scope="col">performer</th>

            <th scope="col">price</th>
            <th scope="col">venue</th>
        </tr>
        </thead>
        <#list events as e>
            <tbody>
            <tr>

                <td>${e.concertDate}</td>
                <td>${e.performer}</td>
                <td>${e.price}</td>
                <td>${e.venue}</td>

            </tr>
            </tbody>
        </#list>
    </table>

</#macro>

</body>
</html>