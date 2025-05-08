<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><b><i>Навчаемо всіх</i></b></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">
                        <i class="bi bi-house">&nbsp;На головну</i>
                    </a>
                </li>

                <a class="navbar-brand"><#if userName??><i class="bi bi-person-fill">&nbsp;${userName}</i></#if></a>
<#--                <#if roles_id??>-->
                <form class="d-flex" method="get" action="/admin">
                    <button class="btn btn-outline-success" type="submit"><i class="bi bi-person-vcard"><br>Admin</i></button>
                </form>
<#--                <#else>-->
                <form class="d-flex" method="get" action="/teacher">
                    <button class="btn btn-outline-success" type="submit"><i class="bi bi-person-vcard"><br>Teacher</i></button>
                </form>
                <form class="d-flex" method="get" action="/student">
                    <button class="btn btn-outline-success" type="submit"><i class="bi bi-person-vcard"><br>Student</i></button>
                </form>
<#--                </#if>-->
            </ul>

            <form class="d-flex" method="get" action="/cart">
                <button class="btn btn-outline-success" type="submit"><i class="bi bi-cart4"><br>Кошик</i></button>
            </form>

            <#if userName??>
                <form class="d-flex" method="post" action="/logout">
                    <button class="btn btn-outline-success" type="submit"><i class="bi bi-door-open"><br>Вихід</i></button>
                </form>
            <#else>
                <form class="d-flex" method="get" action="/login">
                    <button class="btn btn-outline-success" type="submit"><i class="bi bi-door-open"><br>Вхід</i></button>
                </form>
            </#if>
        </div>
    </div>
</nav>