<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acciones Archivadas</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding-top: 70px; /* Adjust based on navbar height */
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
            <li class="nav-item">
                <a class="nav-link mx-2" href="stockController?route=listStocks">Inicio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link mx-2" href="#">Consolidado</a>
            </li>
            <li class="nav-item">
                <a class="nav-link mx-2" href="stockController?route=listArchivedStocks">Archivo</a>
            </li>
        </ul>
        <a class="navbar-brand ms-auto" href="#">Stock Manager</a>
    </div>
</nav>
<div class="container mt-2">
    <h4>Acciones Archivadas</h4>
    <c:if test="${empty stocks}">
        <div class="alert alert-info" role="alert">
            No hay acciones archivadas.
        </div>
    </c:if>
    <c:if test="${not empty stocks}">
        <table class="table table-bordered mt-3">
            <thead>
            <tr>
                <th>ID</th>
                <th>Compañía</th>
                <th>Símbolo</th>
                <th>Fecha Compra</th>
                <th>Cantidad</th>
                <th>Precio Compra ($)</th>
                <th>Último Precio Registrado ($)</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="stock" items="${stocks}">
                <tr>
                    <td>${stock.id}</td>
                    <td>${stock.companyName}</td>
                    <td>${stock.tickerSymbol}</td>
                    <td>${stock.purchaseDate}</td>
                    <td>${stock.quantity}</td>
                    <td><fmt:formatNumber value="${stock.purchasePrice}" type="number" maxFractionDigits="2"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${stock.currentPrice != null}">
                                <fmt:formatNumber value="${stock.currentPrice}" type="number" maxFractionDigits="2"/>
                            </c:when>
                            <c:otherwise>N/A</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <form action="stockController" method="POST">
                            <input type="hidden" name="route" value="unArchiveStock">
                            <input type="hidden" name="stockId" value="${stock.id}">
                            <button type="submit" class="btn btn-secondary btn-sm">Desarchivar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>