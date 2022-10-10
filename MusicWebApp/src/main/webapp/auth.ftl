<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>authentication</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="form.css">
</head>
<body>

<div class="login">
    <h1 class="text-center">What kinda music</h1>
    <p style ="color:red"><#if error??>${error}<br></#if></p>
    <form action="authentication" method="post">

        <div class="form-group was-validated">
            Login User:
            <input type="text" name="login"/>
            <br>
        </div>

        <div class="form-group was-validated">
            Firstname:
            <input type="text" name="firstname"/>
            <br>
        </div>

        <div class="form-group was-validated">
            Lastname:
            <input type="text" name="lastname"/>
            <br>
        </div>

        <div class="form-group was-validated">
            Password:
            <input type="password" name="password"/>
            <br>
        </div>
        <input class="btn btn-dark" type="submit" value="Login">
        <br>
        Already have an account?
        <a href="/login">Login</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>