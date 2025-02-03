<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>
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
<div class="container">
    <h4 class="mt-2">Registro de Acciones</h4>
    <div id="validationAlerts"></div>
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
                <input type="number" step="0.01" min="0.01" class="form-control" id="purchasePrice" name="purchasePrice"
                       required>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Registrar Compra</button>
    </form>
    <h4 class="mt-5">Acciones Compradas</h4>

    <c:if test="${not empty message and message == 'Error al actualizar precios de las acciones.'}">
        <br>
        <div class="alert alert-danger" role="alert">
            Ocurrió un error al actualizar los precios de las acciones. Por favor, inténtelo nuevamente más tarde.
        </div>
    </c:if>

    <c:if test="${empty stocks}">
        <div class="alert alert-info" role="alert">
            No hay acciones registradas.
        </div>
    </c:if>
    <c:if test="${not empty stocks}">
        <div class="d-flex justify-content-between">
            <form action="stockController" method="get" class="mb-3">
                <input type="hidden" name="route" value="listStocks">
                <button type="submit" class="btn btn-warning mt-3">Actualizar Precios</button>
            </form>
            <form action="exportCSV" method="get">
                <button type="submit" class="btn btn-success mt-3">Exportar CSV</button>
            </form>
        </div>
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
                        <form action="stockController" method="POST"
                              onsubmit="return confirm('¿Estás seguro de archivar esta acción?')">
                            <input type="hidden" name="route" value="archiveStock">
                            <input type="hidden" name="stockId" value="${stock.id}">
                            <button type="submit" class="btn btn-secondary btn-sm">Archivar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<script>
    function validateForm() {
        let symbol = document.getElementById("tickerSymbol").value;
        let purchaseDate = new Date(document.getElementById("purchaseDate").value);
        let today = new Date();
        let isValid = true;

        let validationAlerts = document.getElementById("validationAlerts");
        validationAlerts.innerHTML = ""; // Clear previous alerts

        if (!/^[A-Z]{1,5}(\.[A-Z]{1,3})?$/.test(symbol)) {
            validationAlerts.innerHTML += "<div class='alert alert-danger'>Formato inválido para el símbolo.</div>";
            isValid = false;
        }

        if (purchaseDate > today) {
            validationAlerts.innerHTML += "<div class='alert alert-danger'>La fecha no puede ser futura.</div>";
            isValid = false;
        }

        return isValid;
    }
</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>