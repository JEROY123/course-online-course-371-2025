<#import "admin/admin.ftl" as p>
<@p.pages>

    <h1> Сторінка для адміністування каталогів продукції </h1>

    <table class="table">
        <thead>
        <tr>
            <th>№</th>
            <th>Ім'я</th>
            <th>Опис</th>
            <th>Картинка</th>
        </tr>
        </thead>
        <tbody>
        <#if categories??>
        <#list categories as c>
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.description}</td>
            <td>${c.linkImages}</td>
        </tr>
        </#list>
        </#if>
        </tbody>
    </table>

    <br>
    <hr>
    <h1> Додавання нової категорії </h1>

    <form method="post" action="/saveNewCategory">
        <label for="name">Ім'я</label><br>
        <input type="text" id="name" name="name" placeholder="name"><br>
        <br>

        <label for="description">Опис</label><br>
        <input type="text" id="description" name="description" placeholder="description"><br>
        <br>

        <label for="images">Картинка</label><br>
        <input type="text" id="image" name="image" placeholder="image"><br>
        <br>

        <input class="btn btn-success" type="submit" value="Додати">
    </form>

    <br>
    <hr>
    <h1> Оновлення та видалення категорій </h1>

    <table class="table">
        <thead>
        <tr>
            <th>№</th>
            <th>Ім'я</th>
            <th>Опис</th>
            <th>Картинка</th>
            <th>Оновлення</th>
            <th>Видалення</th>
        </tr>
        </thead>
        <tbody>
        <#if categories??>
            <#list categories as c>
                <tr>
                    <form method="post" action="/updateCategory">
                    <td>
                        <input type="hidden" name="id1" value="${c.id}">
                        ${c.id}
                    </td>
                    <td>
                        <input type="text" name="name" value="${c.name}">
                    </td>
                    <td>
                        <input type="text" name="description" value="${c.description}">
                    </td>
                    <td>
                        <input type="text" name="image" value="${c.linkImages}">
                    </td>
                    <td>
                        <input class="btn btn-success" type="submit" value="Оновити">
                    </td>
                    </form>
                    <form method="post" action="/deleteCategoryFromList">
                    <td>
                        <input type="hidden" name="id1" value="${c.id}">
                        <input class="btn btn-success" type="submit" value="Видалити">
                    </td>
                    </form>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

    <br>
    <hr>
    <h1> Видалення всіх категорій </h1>

    <form method="post" action="/deleteAllCategory">
        <input class="btn btn-success" type="submit" value="Видалити все">
    </form>
</@p.pages>