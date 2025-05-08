<#import "customer/customer.ftl" as p>

<@p.pages>
    <h3>Замовлення</h3>

    <hr/>

    <h3> Інформація про користувача </h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Телефон</th>
            <th>Електронна пошта</th>
        </tr>
        </thead>
        <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.phone}</td>
            <td>${customer.email}</td>
        </tr>
    </table>


    <hr/>
    <h3> Інформація про курси </h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Курс</th>
            <th>Назва</th>
            <th>Опис</th>
            <th>Ціна</th>
        </tr>
        </thead>
        <tbody>
        <#if cart??>
            <#list cart as item>
                <tr>
                    <td> <img src="${item.linkImage}" height="80" alt="${item.name}"> </td>
                    <td> ${item.name} </td>
                    <td> ${item.short_description} </td>
                    <td> <#if item.price!=0>${item.price} грн.<#else>Безкоштовно</#if> </td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
    <hr>

    <form action="/order" method="post">
        <h3> Payment </h3>
        <select name="payment">
            <option value="1">Готівка</option>
            <option value="2">Банківська карта</option>
            <option value="3">Переказ</option>
        </select>

        <button class="button"> Купити </button>
    </form>

</@p.pages>