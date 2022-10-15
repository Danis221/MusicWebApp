<html lang="en">

<head>
    <#include "base.ftl">

    <#macro title>Articles</#macro>
    <link rel="stylesheet" href="css/article.css">
    <script>
        let btn = document.querySelector('.btn')

        function scroll() {
            if (window.pageYOffset > 20) {
                btn.style.opacity = '1'
            } else { btn.style.opacity = '0' }
        }

        btn.onclick = function () {
            window.scrollTo(0,0)
        }

        window.onscroll = scroll
    </script>
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
                    <iframe width="640" height="360"
                            src=" ${a.videoFromYouTube}">
                    </iframe>
                </div>

                <div class="bar-line__right">
                    <div class="bar-line__right-text">${a.text}</div>
                </div>
            </div>
        </div>

    </#list>!
    <span class="btn"><a>To top &#128316;</a></span>
</#macro>
</body>

</html>
