<!DOCTYPE html>
<#include "base.ftl">
<html lang="en">
<head>
    <meta charset="UTF-8">

    <#macro title>Events</#macro>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script  src="js/validatorForEventsSetting.js"></script>
</head>

<body>
<#macro content>
    <a href="/createEvent" id="createEvent" style="color: black; padding: 20px 20px">Create Event</a>

    <form action="events" method="post" id="form">
        <label for="startDate">From the</label>
        <input type="date" id="startDate" name="startDate">

        <label for="endDate">to the</label>
        <input type="date" id="endDate" name="endDate">

        <label for="price"> price <=</label>
        <input type="text"  id="price" name="price">
        <input class="button" id="button" type="submit" value="Apply">

        <p style="color:red" id="errorMessage" hidden></p>
    </form>
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