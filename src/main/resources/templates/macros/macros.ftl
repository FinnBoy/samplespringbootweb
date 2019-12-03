<#macro script src main="" contextPath="" rup="">
    <#if contextPath == "">
    <#assign contextPath=request.getContextPath()>
    </#if>
    <#if rup == "">
    <#assign rup=Request["org.springframework.web.servlet.resource.ResourceUrlProvider"]>
    </#if>
    <#if main == "">
    <script src="${contextPath + rup.getForLookupPath(src)!}"/>
    <#else>
    <script src="${contextPath + rup.getForLookupPath(src)!}" data-main="${contextPath + rup.getForLookupPath(main)!}"/>
    </#if>
</#macro>

<#macro link href contextPath="" rup="">
    <#if contextPath == "">
    <#assign contextPath=request.getContextPath()>
    </#if>
    <#if rup == "">
    <#assign rup=Request["org.springframework.web.servlet.resource.ResourceUrlProvider"]>
    </#if>
    <link rel="stylesheet" href="${contextPath + rup.getForLookupPath(href)!}">
</#macro>
