<!DOCTYPE html>
<#include "base.ftl">
<html lang="en">
<head>
    <meta charset="UTF-8">

    <#macro title>Create article</#macro>
    <link rel="stylesheet" href="css/createArticl.css">
    <script  src="js/validatorForCreateArticle.js"></script>
</head>

<body>
<#macro content>


    <form action="createArticle" method="post" id="form">
        <p style="color:red"><#if error??>${error}<br></#if></p>
        <p style="color:red" id="errorMessage" hidden></p>
        <label class="name" for="name">name article:</label><br>
        <input id="name" name="name"><br>
        <label for="videoFromYouTube"> link youtube:</label><br>
        <input type="text" id="videoFromYouTube" name="videoFromYouTube"
               value="https://www.youtube.com/embed/dQw4w9WgXcQ?list=PLtg6VBytbdL4O6cpBMbAoliCKLcddtHLF"><br>
        <label for="text">text:</label><br>
        <textarea id="text" name="text"></textarea><br>

        <label for="genres">Choose a genre:</label>

        <select name="genre" id="genres"><
            <option value="rock">rock</option>
            <option value="rap">rap</option>
            <option value="indi">indi</option>
            <option value="post-punck">post-punck</option>
        </select><br>
        <check></check>
        <input class="button" id="button" type="submit" value="Create">
    </form>
</#macro>

</body>
</html>