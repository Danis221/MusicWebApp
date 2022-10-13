<html lang="en">

<head>
    <#include "base.ftl">

    <#macro title>Articles</#macro>
    <link rel="stylesheet" href="css/article.css">
</head>
<body>

<#macro content>

    <br>
    <#list articles as a>

        <div class="article">

            <a href="/article?articleId=${a.articleId}">
                <h1>${a.name}</h1>
            </a><br>
            ${a.genre}


            <div class="bar-line">
                <div class="bar-line__left">
                    <iframe width="420" height="315"
                            src=" ${a.videoFromYouTube}">
                    </iframe>
                </div>

                <div class="bar-line__right">
                    <div class="bar-line__right-text">${a.text}</div>
                </div>
            </div>


            </p>


        </div>

    </#list>!
</#macro>
</body>

</html>
