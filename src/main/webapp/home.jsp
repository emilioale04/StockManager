<!-- comprarAcciones.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Acciones</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Registro de Acciones Compradas</h2>
    <form action="stockController" method="POST" onsubmit="return validateForm()">
        <input type="hidden" name="route" value="saveStock">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="tickerSymbol">Símbolo</label>
                <input type="text" class="form-control" id="tickerSymbol" name="tickerSymbol" required>
            </div>
            <div class="form-group col-md-6">
                <label for="companyName">Nombre de la Compañía</label>
                <input type="text" class="form-control" id="companyName" name="companyName" required>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="purchaseDate">Fecha de Compra</label>
                <input type="date" class="form-control" id="purchaseDate" name="purchaseDate" required>
            </div>
            <div class="form-group col-md-4">
                <label for="quantity">Cantidad</label>
                <input type="number" class="form-control" min="1" id="quantity" name="quantity" required>
            </div>
            <div class="form-group col-md-4">
                <label for="purchasePrice">Precio de Compra</label>
                <input type="number" step="0.01" min="0.01" class="form-control" id="purchasePrice" name="purchasePrice" required>
            </div>
        </div>
        <div class="mt-3">
            <a href="stockController?route=listArchivedStocks" class="btn btn-info">Ver Acciones Archivadas</a>
        </div>

        <button type="submit" class="btn btn-primary">Registrar Compra</button>
    </form>

    <h3 class="mt-5">Acciones Compradas</h3>
    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th>ID</th>
            <th>Compañía</th>
            <th>Símbolo</th>
            <th>Fecha Compra</th>
            <th>Cantidad</th>
            <th>Precio Compra ($)</th>
            <th>Último Precio ($)</th>
            <th>Profit/Loss (%)</th>
            <th>Profit/Loss ($)</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="stock" items="${stocks}">
            <c:if test="${!stock.archive}">
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
                    <td>${stock.profitOrLossPercentage}%</td>
                    <td>${stock.profitOrLoss}$</td>
                    <td>
                        <form action="stockController" method="POST">
                            <input type="hidden" name="route" value="archiveStock">
                            <input type="hidden" name="stockId" value="${stock.id}">
                            <button type="submit" class="btn btn-secondary btn-sm">Archivar</button>
                        </form>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
