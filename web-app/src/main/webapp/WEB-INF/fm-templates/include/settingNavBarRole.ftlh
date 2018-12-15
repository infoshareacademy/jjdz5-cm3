<#if whoIs == "3">
    <#include "navbarHeaderTemplateManagerAndAdmin.ftlh">
<#elseif whoIs == "2">
    <#include "navbarHeaderTemplateOnlyAdmin.ftlh">
<#elseif whoIs == "1">
    <#include "navbarHeaderTemplateOnlyManager.ftlh">
<#else>
    <#include "navbarHeaderTemplateSimpleEmployee.ftlh">
</#if>