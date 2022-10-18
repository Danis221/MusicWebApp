<!DOCTYPE html>
<#include "base.ftl">
<html lang="en">
<head>
    <meta charset="UTF-8">

    <#macro title>Create event</#macro>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="css/createEvent.css">
    <script  src="js/validarorForEvent.js"></script>
</head>

<body>
<#macro content>





    <form action="createEvent" method="post" id="form">
        <p style="color:red"><#if error??>${error}<br></#if></p>
        <p style="color:red" id="errorMessage" hidden></p>
        <div class="form-group">
            <label for="performer">Performer</label>
            <input type="text" id="performer" class="form-control" name="performer">
        </div>
        <br>
        <div class="form-group">
            <label for="concertDate">Concert Date</label>
            <input type="date" class="form-control" id="concertDate" name="concertDate">
        </div>
        <br>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="text" class="form-control" id="price" name="price" value="0">
        </div>
        <br>
        <div class="form-group">
            <label for="venue">Venue</label>
            <input type="text" class="form-control" id="venue" name="venue">
        </div>
        <br>
        <button type="submit" class="btn btn-dark">Submit</button>
    </form>
</#macro>

</body>
</html>