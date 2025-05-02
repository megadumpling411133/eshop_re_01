<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的購物車</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>🛒 我的購物車</h2>

    <c:choose>
        <c:when test="${empty cart || empty cart.details}">
            <div class="alert alert-warning mt-4">購物車是空的。</div>
        </c:when>
        <c:otherwise>
            <table class="table table-bordered mt-4">
                <thead class="table-light">
                    <tr>
                        <th>商品編號</th>
                        <th>數量</th>
                        <th>單價</th>
                        <th>小計</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="total" value="0" />
                    <c:forEach var="item" items="${cart.details}">
                        <tr>
                            <td>${item.productId}</td>
                            <td>${item.quantity}</td>
                            <td>${item.unitPrice}</td>
                            <td>${item.quantity * item.unitPrice}</td>
                            <c:set var="total" value="${total + (item.quantity * item.unitPrice)}" />
                        </tr>
                    </c:forEach>
                    <tr class="table-secondary">
                        <td colspan="3" class="text-end fw-bold">總計：</td>
                        <td class="fw-bold">${total}</td>
                    </tr>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%-- <%@ taglib prefix="s" uri="/struts-tags" %> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!--     <title>購物車</title> -->
<!--     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- </head> -->
<!-- <body> -->
<!-- <div class="container mt-5"> -->
<!--     <h2 class="mb-4">🛒 我的購物車</h2> -->

<%--     <c:choose> --%>
<%--         <c:when test="${empty cart}"> --%>
<!--             <div class="alert alert-warning">目前購物車是空的。</div> -->
<%--         </c:when> --%>
<%--         <c:otherwise> --%>
<!--             <table class="table table-bordered table-hover"> -->
<!--                 <thead class="table-light"> -->
<!--                     <tr> -->
<!--                         <th>圖片</th> -->
<!--                         <th>商品名稱</th> -->
<!--                         <th>單價</th> -->
<!--                         <th>數量</th> -->
<!--                         <th>小計</th> -->
<!--                     </tr> -->
<!--                 </thead> -->
<!--                 <tbody> -->
<%--                     <c:set var="total" value="0" /> --%>
<%--                     <c:forEach var="item" items="${cart.values()}"> --%>
<!--                         <tr> -->
<!--                             <td style="width: 100px;"> -->
<%--                                 <img src="${pageContext.request.contextPath}/${item.product.imageUrl}" class="img-fluid" style="width: 50px;"> --%>
<!--                             </td> -->
<%--                             <td>${item.product.name}</td> --%>
<%--                             <td>¥${item.product.price}</td> --%>
<%--                             <td>${item.quantity}</td> --%>
<%--                             <td>¥${item.product.price * item.quantity}</td> --%>

<%--                             <c:set var="total" value="${total + (item.product.price * item.quantity)}" /> --%>
<!--                         </tr> -->
<%--                     </c:forEach> --%>
<!--                     <tr class="table-secondary"> -->
<!--                         <td colspan="4" class="text-end fw-bold">總計：</td> -->
<%--                         <td class="fw-bold text-danger">¥${total}</td> --%>
<!--                     </tr> -->
<!--                 </tbody> -->
<!--             </table> -->
<%--         </c:otherwise> --%>
<%--     </c:choose> --%>

<!--     <div class="mt-3 text-end"> -->
<%--         <a href="${pageContext.request.contextPath}/product/list.action" class="btn btn-outline-primary">⬅ 返回商品列表</a> --%>
<%--         <a href="cart/clear.action" class="btn btn-danger">🗑 清空購物車</a> --%>
<!--     </div> -->
<!-- </div> -->
<!-- </body> -->
<!-- </html> -->
