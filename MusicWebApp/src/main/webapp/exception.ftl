<html lang="en">
<#include "base.ftl">

<#macro title>${status_code}</#macro>

<#macro content>
    <h1>Error ${status_code}</h1> <br>
    <strong>URI:</strong>${uri}<br>
    <#if message??><strong>Message:</strong>${message}</#if>

</#macro>

</html>