<#import "admin/admin.ftl" as p>
<@p.pages>
    <#list clients as client>
        ${client.username}

        <form action="/saveNewRoleForClient" method="post">
        <input type="hidden" name="id" value="${client.id}">
        <select name="roles">
            <option value="1">admin</option>
            <option value="2">teacher</option>
            <option value="3">student</option>
        </select>

        <button class="btn btn-success" type="submit">Додати</button>
        </form>
    </#list>
</@p.pages>