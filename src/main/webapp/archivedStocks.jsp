<!-- archivedStocks.jsp -->
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
</head>
<body>
<div class="container mt-5">
    <h2>Acciones Archivadas</h2>
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
</div>
</body>
</html>
