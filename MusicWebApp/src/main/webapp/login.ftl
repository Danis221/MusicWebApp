<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Bootstrap v5.1.3 CDNs -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- CSS File -->
    <link rel="stylesheet" href="css/auth.css">
    <link rel="stylesheet" href="css/login.css">

</head>

<body>

<h1 class="text">What kinda music</h1>

<div class="login">




    <form class="needs-validation" action="login" method="post">
        Login:
        <p style="color:red"><#if error??> ${error}</#if></p>
        <div class="form-group was-validated">
            <label class="form-label" for="login">Login User </label>
            <input required type="text" name="login" id="login" placeholder="login"/>

        </div>
        <div class="form-group was-validated">
            <label class="form-label" for="password">Password</label>
            <input required type="password" name="password" id="password" placeholder="password"/>

        </div>
        <div class="form-group form-check">
            <input type="checkbox" name="_remember_me" id="check" checked/>
            <label class="form-check-label" for="check">Remember me </label>
        </div>
        <input class="btn btn-dark" type="submit" value="Log in">
    </form>

</div>


</body>

</html>