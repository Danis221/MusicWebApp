<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>authentication</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link rel="stylesheet" href="css/auth.css">
    <script defer src="js/validatorForAuth.js"></script>
</head>
<body>

<div class="login">
    <h1 class="text">What kinda music</h1>


    <form action="authentication" method="post" id="form">
        Sign Up:
        <p style="color:red" ><#if error??>${error}<br></#if></p>
        <p style="color:red" id="errorMessage" hidden></p>
        <div class="form-group was-validated">
            Login User:
            <input  id="login" class="input js-input" type="text" name="login"/>
            <br>
        </div>

        <div class="form-group was-validated">
            Firstname:
            <input id="firstname" type="text" name="firstname"/>
            <br>
        </div>

        <div class="form-group was-validated">
            Lastname:
            <input id="lastname" type="text" name="lastname"/>
            <br>
        </div>

        <div class="form-group was-validated">
            Password:
            <input required id="password" type="password" name="password"/>
            <br>
        </div>
        <input class="btn btn-dark" type="submit" value="Sign Up">
        <br>
        Already have an account?
        <a href="/login">Login</a>
    </form>
</div>


</body>
</html>