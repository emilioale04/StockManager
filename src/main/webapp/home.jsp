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
                <small class="text-danger" id="symbolError"></small>
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
                <small class="text-danger" id="dateError"></small>
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
        <button type="submit" class="btn btn-primary">Registrar Compra</button>
    </form>
    <h3 class="mt-5">Acciones Compradas Registradas</h3>

    <div class="mt-3">
        <a href="stockController?route=listArchivedStocks" class="btn btn-info">Ver Acciones Archivadas</a>
    </div>

    <div class="d-flex justify-content-between">
        <form action="stockController" method="get" class="mb-3">
            <input type="hidden" name="route" value="listStocks">
            <button type="submit" class="btn btn-warning mt-3">Actualizar Precios</button>
        </form>
        <form action="exportCSV" method="get">
            <button type="submit" class="btn btn-success mt-3">Exportar CSV</button>
        </form>
    </div>

    <c:if test="${not empty message and message == 'Error al actualizar precios de las acciones.'}">
        <br>
        <div class="alert alert-danger" role="alert">
            Ocurrió un error al actualizar los precios de las acciones. Por favor, inténtelo nuevamente más tarde.
        </div>
    </c:if>

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
                    <span class="${stock.profitOrLossPercentage >= 0 ? 'text-success' : 'text-danger'}">
                        <fmt:formatNumber value="${stock.profitOrLossPercentage}" type="number" maxFractionDigits="2"/>%
                    </span>
                </td>
                <td>
                    <span class="${stock.profitOrLoss >= 0 ? 'text-success' : 'text-danger'}">
                        <fmt:formatNumber value="${stock.profitOrLoss}" type="number" maxFractionDigits="2"/>$
                    </span>
                </td>
                <td>
                    <form action="stockController" method="POST" onsubmit="return confirm('¿Estás seguro de archivar esta acción?')">
                        <input type="hidden" name="route" value="archiveStock">
                        <input type="hidden" name="stockId" value="${stock.id}">
                        <button type="submit" class="btn btn-secondary btn-sm">Archivar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>
    function validateForm() {
        let symbol = document.getElementById("tickerSymbol").value;
        let purchaseDate = new Date(document.getElementById("purchaseDate").value);
        let today = new Date();

        if (!/^[A-Z]{1,5}(\.[A-Z]{1,3})?$/.test(symbol)) {
            document.getElementById("symbolError").textContent = "Formato inválido";
            return false;
        }
        if (purchaseDate > today) {
            document.getElementById("dateError").textContent = "La fecha no puede ser futura";
            return false;
        }
        return true;
    }
</script>
</body>
</html>
