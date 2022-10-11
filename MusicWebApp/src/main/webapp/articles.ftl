<html lang="en">
<#include "base.ftl">

<#macro title>Users</#macro>

<#macro content>
Hello,
<br>

<#list articles as a>
    <iframe width="420" height="315"
            src=" ${a.videoFromYouTube}">
    </iframe>

<br>
</#list>!
</#macro>

</html>
