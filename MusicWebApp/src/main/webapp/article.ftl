<html lang="en">

<head>
    <#include "base.ftl">

    <#macro title>Articles</#macro>
    <link rel="stylesheet" href="css/article.css">
</head>
<body>

<#macro content>

    <br>

    <div class="article">


        <h1>${article.name}</h1>


        ${article.genre}


        <div class="bar-line">
            <div class="bar-line__left">
                <iframe width="420" height="315"
                        src=" ${article.videoFromYouTube}">
                </iframe>
            </div>

            <div class="bar-line__right">
                <div class="bar-line__right-text">${article.text}</div>
            </div>
        </div>


    </div>


</#macro>
</body>

</html>
