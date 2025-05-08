<#import "customer/customer.ftl" as p>
<#import "/spring.ftl" as s>

<@p.pages>

    <h2>Регістрація користувача</h2>

    <form action="/registration" method="post">

        <@s.bind "clients"/>

        <label for="username">Логін</label><br>
        <@s.formInput "clients.username"/><br>
        <@s.showErrors "<br"/><br>

        <label for="password">Пароль</label><br>
        <@s.formInput "clients.password"/><br>
        <@s.showErrors "<br"/><br>

        <@s.bind "customers"/>

        <label for="firstName">Ім'я</label><br>
        <@s.formInput "customers.firstName"/><br>
        <@s.showErrors "<br"/><br>

        <label for="lastName">Прізвище</label><br>
        <@s.formInput "customers.lastName"/><br>
        <@s.showErrors "<br"/><br>

        <label for="email">Електронна пошта</label><br>
        <@s.formInput "customers.email"/><br>
        <@s.showErrors "<br"/><br>

        <label for="phone">Телефон</label><br>
        <@s.formInput "customers.phone"/><br>
        <@s.showErrors "<br"/><br>

        <input type="submit" value="Додати користувача">
    </form>

</@p.pages>