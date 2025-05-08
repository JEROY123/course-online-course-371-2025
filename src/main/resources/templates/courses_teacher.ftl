<#import "teacher/teacher.ftl" as p>
<@p.pages>
    <h1> Cторінка для адміністрування курсів </h1>

    <table class="table">
        <thead>
        <tr>
            <th>№</th>
            <th>Ім'я</th>
            <th>Короткий опис</th>
            <th>Довгий опис</th>
            <th>Картинка</th>
            <th>Ціна</th>
            <th>Категорія</th>
            <th>Вчитель</th>
        </tr>
        </thead>
        <tbody>

        <#if courses??>
            <#list courses as course>
                <tr>
                    <td>${course.id}</td>
                    <td>${course.name}</td>
                    <td>${course.short_description}</td>
                    <td>${course.full_description}</td>
                    <td>${course.linkImage}</td>
                    <td>${course.price?c}</td>
                    <td>${course.category.name}</td>
                    <td>${course.teacher.firstName} ${course.teacher.lastName}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>


    <br>
    <hr>
    <h1> Додавання нових курсів</h1>

    <form action="/saveNewCourse" method="post">
        <label for="name">Ім'я</label><br>
        <input type="text" name="name" placeholder="name" id="name"><br><br>

        <label for="short_description">Короткий опис</label><br>
        <input type="text" name="short_description" placeholder="short_description" id="short_description"><br><br>

        <label for="full_description">Довгий опис</label><br>
        <input type="text" name="full_description" placeholder="full_description" id="full_description"><br><br>

        <label for="image">Картинка</label><br>
        <input type="text" name="image" placeholder="url image" id="image"><br><br>

        <label for="price">Ціна</label><br>
        <input type="number" min="0" step="0.01" max="10000" name="price" id="price"><br><br>

        <label for="categories">Категорія</label>
        <select name="categories">
            <#list categories as category>
                <option value="${category.id}">${category.name}</option>
            </#list>
        </select><br><br>

        <label for="customers">Вчитель</label>
        <select name="customers" id="customers">
            <#list customers as customer>
                <option value="${customer.id}">${customer.firstName} ${customer.lastName}</option>
            </#list>
        </select><br><br>

        <input type="submit" value="Додати" class="btn btn-success">
    </form>

    <br>
    <hr>
    <h1> Оновлення та видалення курсів </h1>

    <table class="table">
        <thead>
        <tr>
            <th>№</th>
            <th>Ім'я</th>
            <th>Короткий опис</th>
            <th>Довгий опис</th>
            <th>Картинка</th>
            <th>Ціна</th>
            <th>Категорія</th>
            <th>Вчитель</th>
            <th>Оновлення</th>
            <th>Видалення</th>
        </tr>
        </thead>
        <tbody>

        <#if courses??>
            <#list courses as course>
                <form method="post" action="/updateCourses">
                <tr>
                    <td>${course.id}</td>
                    <input type="hidden" name="id" value="${course.id}">
                    <td><input type="text" name="name" value="${course.name}"></td>
                    <td><input type="text" name="short_description" value="${course.short_description}"></td>
                    <td><input type="text" name="full_description" value="${course.full_description}"></td>
                    <td><input type="text" name="image" value="${course.linkImage}"></td>
                    <td><input type="number" name="price" value="${course.price?c}"></td>
                    <td>
                        <select name="categories">
                            <#if categories??>
                                <#list categories as category>
                                    <#if category.id==course.category.id>
                                        <option value="${category.id}" selected>${category.name}</option>
                                    <#else>
                                        <option value="${category.id}">${category.name}</option>
                                    </#if>
                                </#list>
                            </#if>
                        </select>
                    </td>
                    <td>
                        <select name="customers">
                            <#if customers??>
                                <#list customers as customer>
                                    <#if customer.id==course.teacher.id>
                                        <option value="${customer.id}" selected>${customer.firstName} ${customer.lastName}</option>
                                    <#else>
                                        <option value="${customer.id}">${customer.firstName} ${customer.lastName}</option>
                                    </#if>
                                </#list>
                            </#if>
                        </select>
                    </td>
                    <td> <button  class="btn btn-success" type="submit"> Оновити </button> </td>
                </form>
                    <form method="post" action="/deleteCourse">
                        <input type="hidden" name="id" value="${course.id}">
                        <td> <button class="btn btn-success" type="submit"> Видалити </button></td>
                    </form>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
    <br>
    <hr>
    <h1> Видалення всіх даних </h1>
    <form method="post" action="/deleteAllCourses">
        <button type="submit" class="btn btn-success"> Видалити все </button>
    </form>
</@p.pages>