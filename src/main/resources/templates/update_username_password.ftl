<#import "admin/admin.ftl" as p>

<@p.pages>
    <h1> Сторінка адміністування користувачів </h1>

    <table class="table">
        <thead>
        <tr>
            <th>Ідентифікатор</th>
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Електронна адреса</th>
            <th>Телефон</th>
            <th>Логін</th>
            <th>Пароль</th>
            <th>Оновити</th>
        </tr>
        </thead>
        <tbody>
        <#if clients??>
            <#list clients as client>
                <tr>
                    <form method="post" action="/updateUsernameAndPassword">
                        <#if customers??>
                            <#list customers as customer>
                                <#if customer.id==client.id>
                                    <td>${customer.id}</td>
                                    <td>${customer.firstName}</td>
                                    <td>${customer.lastName}</td>
                                    <td>${customer.email}</td>
                                    <td>${customer.phone}</td>
                                </#if>
                            </#list>
                        </#if>

                        <input type="hidden" name="id" value="${client.id}">
                        <td><input type="text" name="username" value="${client.username}"></td>
                        <td><input type="text" name="password" value="${client.password}"></td>
                        <td>
                            <button type="submit"> Оновити</button>
                        </td>
                    </form>
                </tr>
            </#list>
        </#if>

        </tbody>
    </table>



</@p.pages>