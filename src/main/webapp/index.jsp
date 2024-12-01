<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock Manager</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Registro de Acciones</h2>
        <!-- Row for symbol and name -->
    <form action="stock" method="POST" onsubmit="return validateForm()">
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
        <!-- Row for date, quantity, and price -->
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
        <!-- Comments field -->
        <div class="form-group">
            <label for="comments">Comentarios</label>
            <textarea class="form-control" id="comments" name="comments"></textarea>
        </div>
        <!-- Submit button -->
        <button type="submit" class="btn btn-primary">Registrar Compra de Acciones</button>
    </form>

    <h3 class="mt-5">Stocks Registrados</h3>

    <!-- Button to trigger price update -->
    <form action="updatePrices" method="GET">
        <button type="submit" class="btn btn-warning mt-3">Actualizar Precios</button>
    </form>

    <!-- Error message -->
    <c:if test="${not empty message and message == 'error'}">
        <br>
        <div class="alert alert-danger" role="alert">
            Ocurrió un error al actualizar los precios de las acciones. Por favor, inténtelo nuevamente más tarde.
        </div>
    </c:if>

    <!-- Table for displaying stocks -->
    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th>ID</th>
            <th>Compañía</th>
            <th>Símbolo</th>
            <th>Fecha de Compra</th>
            <th>Cantidad</th>
            <th>Precio de Compra</th>
            <th>Último Precio Registrado</th>
            <th>Porcentaje Ganancia/Pérdida</th>
            <th>Dinero Ganado/Perdido</th>
            <th>Comentarios</th>
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
                <td><fmt:formatNumber value="${stock.purchasePrice}" type="number" maxFractionDigits="2" /></td>
                <td>
                    <c:choose>
                        <c:when test="${stock.currentPrice != null && stock.currentPrice > 0}">
                            <fmt:formatNumber value="${stock.currentPrice}" type="number" maxFractionDigits="2" />
                        </c:when>
                        <c:otherwise>
                            N/A
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${stock.currentPrice != null && stock.currentPrice > 0}">
                            <c:choose>
                                <c:when test="${stock.profitOrLossPercentage >= 0}">
                    <span class="text-success">
                        <fmt:formatNumber value="${stock.profitOrLossPercentage}" type="number" maxFractionDigits="2" />%
                    </span>
                                </c:when>
                                <c:when test="${stock.profitOrLossPercentage < 0}">
                    <span class="text-danger">
                        <fmt:formatNumber value="${stock.profitOrLossPercentage}" type="number" maxFractionDigits="2" />%
                    </span>
                                </c:when>
                                <c:otherwise>
                    <span>
                        <fmt:formatNumber value="${stock.profitOrLossPercentage}" type="number" maxFractionDigits="2" />%
                    </span>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            N/A
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${stock.currentPrice != null && stock.currentPrice > 0}">
                            <c:choose>
                                <c:when test="${stock.profitOrLoss >= 0}">
                                <span class="text-success">
                                    <fmt:formatNumber value="${stock.profitOrLoss}" type="number" maxFractionDigits="2" />$
                                </span>
                                </c:when>
                                <c:when test="${stock.profitOrLoss < 0}">
                                <span class="text-danger">
                                    <fmt:formatNumber value="${stock.profitOrLoss}" type="number" maxFractionDigits="2" />$
                                </span>
                                </c:when>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            N/A
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${stock.comments != null ? stock.comments : 'N/A'}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function validateForm() {
        let tickerSymbol = document.getElementById("tickerSymbol").value;
        let purchaseDate = new Date(document.getElementById("purchaseDate").value);
        let today = new Date();

        // Validate symbol matches stock symbol conventions
        let symbolRegex = /^[A-Z]{1,5}(\.[A-Z]{1,3})?$/;
        if (!symbolRegex.test(tickerSymbol)) {
            alert("El símbolo debe contener entre 1 y 5 letras mayúsculas, opcionalmente un " +
                "punto seguido de hasta 3 letras mayúsculas.");
            return false;
        }

        // Validate date is not in the future
        if (purchaseDate > today) {
            alert("La fecha de compra no puede ser posterior a la fecha de hoy.");
            return false;
        }

        return true;
    }
</script>
</body>
</html>