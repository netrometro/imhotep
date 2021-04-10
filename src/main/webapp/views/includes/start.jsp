<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
            crossorigin="anonymous">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">

    <link href="<%= "/imhotep" %>/resources/css/style.css" rel="stylesheet" />

    <style>
        #m-login{
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .m-flex-row{
            display: flex;
            flex-direction: row;
            align-items: center;
        }

        .m-flex-row input{
            margin-top: 1em;
        }
    </style>

    <title>Imhotep</title>

</head>
<body>
<%@include file="menu.jsp" %>