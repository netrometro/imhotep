<%@ page import="br.upe.model.entities.User" %>
<% User u = (User) session.getAttribute("userlogged"); %>
<nav class="m-navbar">
    <div class="nav-content">
        <div class="logo">
            <a class="navbar-brand" href="/imhotep/"><img src="<%= request.getContextPath()%>/resources/img/logo.png">Imhotep</a>
        </div>
        <div class="nav-login">
            <ul>
                <% if (u != null) { %>
                    <% if (u.getUserRoleId() == 1 ) { %>
                        <li><a class="m-menu-item" href="${pageContext.request.contextPath}/logged/doctor/dashboard-doctor.jsp">Dashboard</a></li>
                    <% }else if (u.getUserRoleId() == 2) { %>
                        <li><a class="m-menu-item" href="${pageContext.request.contextPath}/logged/employee/dashboard-employee.jsp">Dashboard</a></li>
                    <% }else if (u.getUserRoleId() == 3) { %>
                        <li><a class="m-menu-item" href="${pageContext.request.contextPath}/logged/patient/dashboard-patient.jsp">Dashboard</a></li>
                    <% } %>

                    <% if (!u.getCrm().equals("0") ) { %>
                    <li><a class="m-menu-item" href="${pageContext.request.contextPath}/logged/doctor/consultation-periods.jsp">Horários disponíveis para Consulta</a></li>
                    <% } else { %>
                    <li><a class="m-menu-item" href="${pageContext.request.contextPath}/logged/patient/dashboard-patient.jsp">Listar médicos</a></li>
                    <li><a class="m-menu-item" href="${pageContext.request.contextPath}/logged/patient/search-doctors.jsp">Buscar Médico</a></li>
                    <% } %>
                <% }%>
                <% if (u != null) { %>
                    <li style="margin-left: 4em;"><a class="m-menu-item" href="${pageContext.request.contextPath}/logged/patient/dashboard-patient.jsp">Olá ${sessionScope.userlogged.name}</a></li>
                    <li style="padding: 4px 14px; border: 1px solid #ddd; border-radius: .3em;"><a class="m-menu-item" href="${pageContext.request.contextPath}/logout.jsp">Sair</a></li>
                <% } else {%>
                    <li style="margin-left: 4em; padding: 4px 14px; border: 1px solid #ddd; border-radius: .3em;"><a class="m-menu-item" href="${pageContext.request.contextPath}/login.jsp">Entrar ou Cadastrar</a></li>
                <% }%>
            </ul>
        </div>
    </div>
</nav>