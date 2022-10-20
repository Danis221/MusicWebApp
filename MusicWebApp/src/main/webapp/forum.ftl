<!DOCTYPE html>
<html>
<head>
    <#include "base.ftl">

    <#macro title>Forum</#macro>
    <meta charset="utf-8">
   <style type="text/css">
       .linksOnDiscussion {
           border-radius: 5px;
           margin: 10px 100px;
           padding: 10px 0;
           background: #2b2b2c;
       }
       .linksOnDiscussion a {
           color: #bababb;
       }
       .date{
           float: right;
           color: #999;
           margin: 0 100px;
       }
   </style>

</head>
<body>
<#macro content>
    <form action="/forum" method="post">
        <p style="color:red"><#if error??>${error}<br></#if></p>
        <h2><label for="forumHeader">create discussion</label><br></h2>
        <input type="text" id="forumHeader" name="forumHeader" >
        <input type="submit" value="Create" style="background: #eeeeee; color: black;">
    </form>


    <#if forum??>
        <#list forum as f>

            <div class="linksOnDiscussion">
            <a href="/discussion?forumId=${f.forumId}">
                ${f.forumHeader}
            </a>
            <div class="date">
                ${f.created}
            </div>
            </div><br>

        </#list>
    <#else>
        <h1>No forums</h1>
    </#if>
</#macro>

</body>
</html>