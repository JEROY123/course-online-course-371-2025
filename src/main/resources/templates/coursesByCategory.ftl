<#import "customer/customer.ftl" as p>
<@p.pages>

    <h3> <#if category??> ${category.name} </#if> </h3>
    <br>
    <hr>

    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 row-cols-xl-4">
        <#if courses??>
            <#list courses as course>
                <div class="col">
                    <div class="card">
                        <form method="post" action="/addToCart">
                            <input type="hidden" name="id" value="${course.id}">
                            <a href="#" data-bs-toggle="modal" data-bs-target="#${course.id}">
                                <img src="${course.linkImage}" class="card-img-top" alt="${course.name}">
                            </a>

                            <div class="card-body text-center">
                                <h5 class="card-title"><b>${course.name}</b></h5>
                                <hr>
                                <p class="card-text"><b>${course.short_description}</b></p>
                                <p class="card-text"><i>${course.full_description}</i></p>
                                <p class="card-text">Викладач: <b>${course.teacher.firstName} ${course.teacher.lastName}</b></p>
                                <p class="cart-text"><h3><#if course.price!=0>${course.price} грн.<#else>Безкоштовно</#if></h3></p>
                                <hr>
                                <div class="">
                                    <button class="btn btn-success" ><i class="bi bi-bag-plus"></i>&nbsp;&nbsp;Додати до кошика</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <!-- Modal -->
                <div class="modal fade" id="${course.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-md">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">${course.name}</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body text-center">
                                <img src="${course.linkImage}">

                                <div class="row">
                                    <div class="col">
                                        <p class="card-text">${course.short_description}</p>
                                        <p class="card-text">${course.full_description}</p>
                                        <p>Викладач: <b>${course.teacher.firstName} ${course.teacher.lastName}</b></p>
                                        <p class="cart-text"><h4><#if course.price!=0>${course.price} грн.<#else>Безкоштовно</#if></h4></p>
                                        <hr>

                                        <form method="post" action="/addToCart">
                                            <input type="hidden" name="id" value="${course.id}">
                                            <div class="">
                                                <button class="btn btn-success" ><i class="bi bi-bag-plus"></i>&nbsp;&nbsp;Додати до кошика</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </#list>
        </#if>
    </div>
    <br>





</@p.pages>