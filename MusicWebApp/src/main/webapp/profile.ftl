<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8"/>
    <#include "base.ftl">

    <#macro title>Profile</#macro>
    <link rel="stylesheet" href="css/profile.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>


    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).on("click", "#ajax-button", function () {
                $.get("/ajax/bts", function (response) {
                    $("#ajax-div").text(response);
                })
            }
        )
    </script>
</head>
<body>
<#macro content>

    <h1>Kak ze ia lublu BTS, vot oni sleva napravo: Nadjyn, Chonguk, Chingachkyk, Goiko Mitch, Djin, Uingi. Love
        You</h1>
    <div style="float: right;">
        <h1>
            <div id="ajax-div">
            </div>
        </h1>

        <form>
            <input type="button" id="ajax-button" value="Which BTS Member Are You?">
        </form>
    </div>

    <div class="infoOfUser">
        Login: ${user.login}<br>
        Firstname: ${user.firstname}<br>
        Lastname: ${user.lastname}<br>
    </div>


    <div class="dropdown">
        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
           data-bs-toggle="dropdown" aria-expanded="false">
            Settings
        </a>

        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <li><a href="/updateProfile" id="updateProfile">update Profile</a></li>
            <li><a style="color:red;" href="/logout" id="logout">Logout</a></li>
        </ul>
    </div>


</#macro>
</body>
</html>

