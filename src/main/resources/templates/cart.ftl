<#import "customer/customer.ftl" as p>

<@p.pages>
<h3>Кошик</h3>

    <table class="table table-stripped">
        <thead>
        <tr>
            <th>Курс</th>
            <th>Назва</th>
            <th>Опис</th>
            <th>Ціна</th>
            <th>Видалити</th>
        </tr>
        </thead>
        <tbody>
        <#if cart??>
            <#list cart as item>
                <tr>
                    <td>
                        <img src="${item.linkImage}" alt="${item.name}" height="80" width="160">
                    </td>
                    <td>${item.name}</td>
                    <td>${item.short_description}</td>
                    <td><#if item.price!=0>${item.price} грн.<#else>Безкоштовно</#if></td>
                    <td>
                        <form method = "post" action="/deleteItemFromCart">
                            <input type="hidden" name="id" value=${item.id}>
                            <button class="btn btn-dark">Видалити</button>
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
        </tbody>

    </table>
    <hr>

    <h5>Вартість купівлі: ${totalValue} грн.</h5>
    <h5>Загальна кількість курсів: ${sumEl} </h5>

    <#if cart??>
        <#if cart?size != 0>
            <ul class="nav">
                <li class="nav-item">
                    <form method = "post" action="/deleteAllItemsFromCart">
                        <button class="btn btn-danger">Очистити кошик</button>
                    </form>
                </li>
                <li class="nav-item">&nbsp;</li>
                <li class="nav-item">
                    <form method = "get" action="/order">
                        <button class="btn btn-success">Оформити замовлення</button>
                    </form>
                </li>
            </ul>
        </#if>
    </#if>

</@p.pages>