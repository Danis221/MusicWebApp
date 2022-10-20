<html lang="en" xmlns="http://www.w3.org/1999/html">

<head>
    <#include "base.ftl">

    <#macro title>Discussion</#macro>
    <link rel="stylesheet" href="css/article.css">

    <style type="text/css">


        .container {
            background-color: #2b2b2c;
            color: #bababb;
            border-radius: 5px;
            margin: 10px 100px;
            padding: 10px 0;
        }

        .container h4 {
            width: 70px;
            height: 20px;
            border: 1px solid black;
            background: whitesmoke;
            color: #2b2b2c;
            float: left;
        }

        .message {
            float: right;
            margin: 0 100px;
        }

        .date {
            float: right;
            color: #999;
            margin: 0 100px;
        }


    </style>

</head>
<body>

<#macro content>


<h1>${discussion.forumHeader}</h1>

<h3>created by user: ${user.login} ${discussion.created}</h3>

    <#if posts?has_content>
<#list posts as p>
<div class="container">
    <h4> ${p.userLogin}</h4>
    ${p.postContent}

    <div class="date">
        ${p.created}
    </div>
</div>
    <br>
    </#list>
        <#else>
        <h1>Write the first comment</h1>
    </#if>

    <div class="message">
        <form action="/discussion" method="post">
            <p style="color:red"><#if error??>${error}<br></#if></p>
            <label for="posContent">Message</label><br>
            <textarea rows="2" cols="20" id="posContent" name="posContent"></textarea>
            <input type="hidden" value="${forumId}" name="forumId"><br>
            <input class="button" id="button" type="submit" value="Send"
                   style="background: #eeeeee; color: black; float: right">
        </form>
    </div>

    </#macro>
</body>

</html>
