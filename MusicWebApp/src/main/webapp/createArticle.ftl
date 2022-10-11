<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/createArticle.css">
    <script defer src="js/validatorForCreateArticle.js"></script>
</head>

<body>

<h1 class="text-center">What kinda music</h1>
<form action="createArticle" method="post" id="form">
    <p style="color:red" id="errorMessage" hidden></p>
    <label class="name" for="name">name article:</label><br>
    <input  id="name" name="name"><br>
    <label for="videoFromYouTube"> link youtube:</label><br>
    <input   type="text" id="videoFromYouTube" name="videoFromYouTube"
           value="https://www.youtube.com/watch?v=lOKmaffc_nw&ab_channel=VanCat"><br>
    <label for="text">text:</label><br>
    <textarea  id="text" name="text" ></textarea><br>

    <label for="genres">Choose a genre:</label>

    <select name="genre" id="genres"><
        <option value="rock">rock</option>
        <option value="rap">rap</option>
        <option value="indi">indi</option>
        <option value="post-punck">post-punck</option>
    </select><br>
    <check></check>
    <input class="button" type="submit" value="Create">
</form>

</body>
</html>