<%@ page import="br.upe.model.entities.User" %>
<nav class="navbar navbar-expand" style="background-color: #203B4E;">
    <div class="container-fluid container">
        <a class="navbar-brand" href="/imhotep/"><img src="./resources/img/logo.png" style="width: 1.5em;">Imhotep</a>
        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="d-flex">
            <div class="dropdown">

                <% User u = (User) session.getAttribute("userlogged"); %>

                <div class="dropdown-toggle m-flex-row" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown">
                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="#fff"
                         class="bi bi-person-circle" viewBox="0 0 16 16">
                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                        <path fill-rule="evenodd"
                              d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                    </svg>
                    <% if (u != null) { %>
                        <p>Olá ${sessionScope.userlogged.name}</p>
                    <% } %>
                </div>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <% if (u != null) { %>
                        <li><a class="dropdown-item" href="#">Perfil</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="logout.jsp">Sair</a></li>
                    <% } else {%>
                        <li><a class="dropdown-item" href="login.jsp">Entrar</a></li>
                        <li><a class="dropdown-item" href="registration">Cadastrar-se</a></li>
                    <% }%>
                </ul>
            </div>
        </div>
    </div>
</nav>
