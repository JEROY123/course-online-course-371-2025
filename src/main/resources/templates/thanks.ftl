<#import "customer/customer.ftl" as p>

<@p.pages>

    <h3> Д'якуємо за замовлення курсів на нашому сайті.<br/>
        <p> Номер Вашого замовлення - №<#if orderId??> ${orderId}</#if> </p>
    </h3>


</@p.pages>