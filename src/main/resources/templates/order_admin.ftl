<#import "admin/admin.ftl" as p>
<@p.pages>
    <h1> Адміністування замовлення </h1>

    <hr>
    <h2> Замовлення № ${order.id} </h2>

    <hr>
    <table class="table">
        <tr>
            <td>${order.customer.firstName}</td>
            <td>${order.customer.lastName}</td>
            <td>${order.customer.phone}</td>
            <td>${order.customer.email}</td>
            <td>${order.payment.name}</td>
        </tr>
    </table>

    <hr>

    <table class="table">
        <thead>
        <tr>
            <th>Ідентифікатор</th>
            <th>Назва курсу</th>
            <th>Ціна</th>
        </tr>
        </thead>
        <tbody>


        <#if courseHasOrderList??>
            <#list courseHasOrderList as cho>
                <tr>
                    <td>${cho.course.id}</td>
                    <td>${cho.course.short_description}</td>
                    <td>${cho.course.price} грн</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

    <hr>

    Варість замовлення: <b>${value} грн</b>

</@p.pages>