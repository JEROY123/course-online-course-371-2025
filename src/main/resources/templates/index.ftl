<#import "customer/customer.ftl" as p>
<@p.pages>

    <h3> Каталог курсів </h3>

    <div class="row">
        <div class="col"></div>
        <div class="col"></div>
        <div class="col"></div>
        <div class="col">

            <form action="/list_card" method="get">
                <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                    <button type="submit" class="btn btn-outline-primary" name="listPresentation" value="true">
                        <i class="bi bi-card-checklist"> list</i>
                    </button>
                    <button type="submit" class="btn btn-outline-primary" name="listPresentation" value="false">
                        <i class="bi bi-table"> table</i>
                    </button>
                </div>
            </form>

        </div>
    </div>

    <#if listPresentation??>
        <#if listPresentation=="true">
            <hr>
            <table class="table table table-striped">
                <tbody>
                <#if categories??>
                    <#list categories as category>
                        <tr>
                            <td>
                                <a href="/category/${category.id}">
                                    <img src="${category.linkImages}"
                                         alt="${category.name}" width="180px">
                                </a>
                            </td>
                            <td>${category.name}</td>
                            <td>${category.description}</td>
                        </tr>
                    </#list>
                </#if>
                </tbody>

            </table>
        <#else>

            <hr>
            <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3">
                <#if categories??>
                    <#list categories as category>
                        <div class="col">
                            <div class="card">
                                <a href="/category/${category.id}">
                                    <img src="${category.linkImages}" class="card-img-top card-img-bottom"
                                         alt="${category.name}">
                                </a>
                                <div class="card-body">
                                    <h5 class="card-title">${category.name}</h5>
                                    <p class="card-text">${category.description}</p>
                                </div>
                            </div>
                        </div>
                    </#list>
                </#if>
            </div>
        </#if>
    </#if>

    <br>

</@p.pages>
