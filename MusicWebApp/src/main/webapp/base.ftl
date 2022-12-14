<html lang="en">
<head>
    <link rel="stylesheet" href="css/header.css">
    <script defer src="js/header.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

    <meta charset="UTF-8">
    <title><@title></@title></title>
    <div class="header">
        <a href="/" class="logo">
            <img alt="What kinda music" src="img/logo.jpg"
                 width=45" height="20">
        </a>
        <div class="header-right">
            <a class="active" href="/">Home</a>
            <a href="/createArticle">Create article</a>
            <a href="/articles">Articles</a>
            <a href="/events">Events</a>
            <a href="/forum">Forum</a>
            <a class="active" href="about.ftl">About site</a>
            <a href="/profile">Profile</a>
        </div>
    </div>

</head>

<body>

<div class="content1">
    <div class="content"><@content></@content></div>
</div>

</body>

</html>