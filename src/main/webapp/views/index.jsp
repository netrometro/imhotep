<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<%@include file="includes/start.jsp" %>

<div class="container py-3">

    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
        <h1 class="display-4 fw-normal">Pricing</h1>
        <p class="fs-5 text-muted">
            Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;
            Nam imperdiet ipsum elit, eget sodales ligula viverra non.
            Praesent metus arcu, blandit non imperdiet sit amet, fringilla ut tortor.
        </p>
    </div>

    <main>
        <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
            <div class="col">
                <div class="card mb-4 rounded-3 shadow-sm">
                    <div class="card-header py-3">
                        <h4 class="my-0 fw-normal">Free</h4>
                    </div>
                    <div class="card-body">
                        <h1 class="card-title pricing-card-title">R$ 0,00<small class="text-muted fw-light">/mês</small></h1>
                        <ul class="list-unstyled mt-3 mb-4">
                            <li>Acesso a consultas</li>
                            <li>Sem desconto</li>
                            <li>Outos</li>
                            <li>.</li>
                        </ul>
                        <button type="button" class="w-100 btn btn-lg btn-outline-primary">Começar</button>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card mb-4 rounded-3 shadow-sm">
                    <div class="card-header py-3">
                        <h4 class="my-0 fw-normal">Pro</h4>
                    </div>
                    <div class="card-body">
                        <h1 class="card-title pricing-card-title">R$ 10,00<small class="text-muted fw-light">/mês</small></h1>
                        <ul class="list-unstyled mt-3 mb-4">
                            <li>Acesso a consultas</li>
                            <li>2 descontos mensais</li>
                            <li>Convite com desconto</li>
                            <li>.</li>
                        </ul>
                        <button type="button" class="w-100 btn btn-lg btn-primary">Assinar</button>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card mb-4 rounded-3 shadow-sm border-primary">
                    <div class="card-header py-3 text-white bg-primary border-primary">
                        <h4 class="my-0 fw-normal">Enterprise</h4>
                    </div>
                    <div class="card-body">
                        <h1 class="card-title pricing-card-title">$29<small class="text-muted fw-light">/mês</small></h1>
                        <ul class="list-unstyled mt-3 mb-4">
                            <li>Acesso a consultas</li>
                            <li>5 descontos mensais</li>
                            <li>Prioridade em fila</li>
                            <li>10 convites com desconto</li>
                        </ul>
                        <button type="button" class="w-100 btn btn-lg btn-primary">Assinar</button>
                    </div>
                </div>
            </div>
        </div>

        <h2 class="display-6 text-center mb-4">Compare plans</h2>

        <div class="table-responsive">
            <table class="table text-center">
                <thead>
                <tr>
                    <th style="width: 34%;"></th>
                    <th style="width: 22%;">Free</th>
                    <th style="width: 22%;">Pro</th>
                    <th style="width: 22%;">Enterprise</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row" class="text-start">Public</th>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                </tr>
                <tr>
                    <th scope="row" class="text-start">Private</th>
                    <td></td>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                </tr>
                </tbody>

                <tbody>
                <tr>
                    <th scope="row" class="text-start">Permissions</th>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                </tr>
                <tr>
                    <th scope="row" class="text-start">Sharing</th>
                    <td></td>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                </tr>
                <tr>
                    <th scope="row" class="text-start">Unlimited members</th>
                    <td></td>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                </tr>
                <tr>
                    <th scope="row" class="text-start">Extra security</th>
                    <td></td>
                    <td></td>
                    <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                </tr>
                </tbody>
            </table>
        </div>
    </main>

</div>
<%@include file="includes/end.jsp" %>

