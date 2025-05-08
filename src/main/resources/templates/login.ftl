<#import "customer/customer.ftl" as p>
<@p.pages>

    <h2> Форма аутентифікації користувача у системі</h2>

    <form action="/login" method="post">

        <label for="username">Логин користувача</label><br>
        <input type="text" name="username" placeholder="user" id="username"><br>

        <label for="password">Пароль</label><br>
        <input type="password" name="password" id="password"><br>

        <input type="submit" value="Увійти">

        <br><a href="/registration">Перехід на форму регістрації</a><br>

    </form>
</@p.pages>