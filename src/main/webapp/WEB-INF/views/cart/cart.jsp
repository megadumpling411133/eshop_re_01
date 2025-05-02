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
	<%-- ✅ 顯示登入使用者名稱 --%>
    <%-- <c:if test="${not empty sessionScope.session_user}">
        <div class="alert alert-info">
            👤 歡迎您，${sessionScope.session_user.name}
        </div>
    </c:if> --%>
    <!-- ✅ 右上角顯示 loginId + 登出按鈕 -->
    <div class="d-flex justify-content-end mb-3">
        <c:if test="${not empty sessionScope.session_user}">
            <span class="me-3 mt-1">👤 歡迎您回來，${sessionScope.session_user.loginId}</span>
            <%-- <a href="${pageContext.request.contextPath}/logout.action" class="btn btn-outline-danger btn-sm">登出</a> --%>
            <a href="${pageContext.request.contextPath}/home/logout.action" class="btn btn-outline-danger btn-sm">登出</a>
            
        </c:if>
    </div>
    <h2>🛒 我的購物車</h2>

    <c:choose>
        <c:when test="${empty cart || empty cart.details}">
            <div class="alert alert-warning mt-4">購物車是空的。</div>
        </c:when>
        <c:otherwise>
            <table class="table table-bordered mt-4">
                <thead class="table-light">
                    <tr>
                    	<th>圖片</th>
                        <th>商品編號</th>
                        <th>商品名稱</th>
                        <th>數量</th>
                        <th>單價</th>
                        <th>小計</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="total" value="0" />
                    <c:forEach var="item" items="${cart.details}">
                        <tr>
                        	<td>
				                <img src="${pageContext.request.contextPath}/${item.product.imageUrl}" 
				                     alt="商品圖片" class="img-fluid" style="max-width: 60px;" />
				            </td>
                            <td>${item.productId}</td>
                            <td>${item.product.name}</td>
                            <td>${item.quantity}</td>
                            <td>${item.unitPrice}</td>
                            <td>${item.quantity * item.unitPrice}</td>
                            <c:set var="total" value="${total + (item.quantity * item.unitPrice)}" />
                        </tr>
                    </c:forEach>
                    <tr class="table-secondary">
					    <td colspan="5" class="text-end fw-bold">總計：</td>
					    <td class="fw-bold text-end">${total}</td>
					</tr>
                </tbody>
            </table>
            <div class="d-flex justify-content-end mt-3">
            	<a href="${pageContext.request.contextPath}/order/checkout.action" class="btn btn-success">🧾 結帳</a>
            	<a href="${pageContext.request.contextPath}/cart/clear.action" class="btn btn-danger">🗑 清空購物車</a>         
        	</div>
        </c:otherwise>
    </c:choose>
    <!-- ✅ 繼續購物 / 清空購物車 -->
    <div class="d-flex justify-content-end mt-3">
        <a href="${pageContext.request.contextPath}/product/list.action" class="btn btn-outline-primary me-2">⬅ 繼續購物</a>       
    </div>
</div>
</body>
</html>

