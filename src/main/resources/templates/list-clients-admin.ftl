<#import "admin/admin.ftl" as p>

<@p.pages>
    <h1> Сторінка адміністування користувачів </h1>

    <table class="table">
        <thead>
        <tr>
            <th>Логін</th>
            <th>Пароль</th>
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Електронна адреса</th>
            <th>Телефон</th>
        </tr>
        </thead>
        <tbody>
        <#if clients??>
            <#list clients as client>
                <tr>
                    <td>${client.username}</td>
                    <td>${client.password}</td>

                    <#if customers??>
                        <#list customers as customer>
                            <#if customer.id==client.id>
                                <td>${customer.firstName}</td>
                                <td>${customer.lastName}</td>
                                <td>${customer.email}</td>
                                <td>${customer.phone}</td>
                            </#if>
                        </#list>
                    </#if>
                </tr>
            </#list>
        </#if>

        </tbody>
    </table>
</@p.pages>