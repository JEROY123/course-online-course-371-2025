<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>

<h1>${hello}</h1>

<h1> Категорії </h1>
<#if categories??>
    <#list categories as category>
        <li>${category.id} ${category.description}</li>
    </#list>
</#if>


</body>
</html>