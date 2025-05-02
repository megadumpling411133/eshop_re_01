<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品列表</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">商品列表</h2>
    <a href="${pageContext.request.contextPath}/cart/view.action" class="btn btn-outline-success">
            查看購物車
    </a>
    <div class="row">
        <s:iterator value="products">
            <div class="col-md-4 mb-4">
                <div class="card h-100">
                    <img src="${pageContext.request.contextPath}/${imageUrl}" class="card-img-top" alt="<s:property value='name'/>">
                    
                    <div class="card-body">
                        <h5 class="card-title"><s:property value="name"/></h5>
                        <p class="card-text"><s:property value="description"/></p>
                        <p class="text-danger fw-bold">¥<s:property value="price"/></p>
                        <p class="text-muted">庫存: <s:property value="stock"/></p>

                        <!-- ✅ AJAX 加入購物車按鈕 -->
                        <button class="btn btn-primary add-to-cart-btn" data-id="<s:property value='id'/>">
                            加入購物車
                        </button>
                    </div>
                </div>
            </div>
        </s:iterator>
    </div>
    
    <!-- ✅ 分頁導航 -->
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">

            <!-- 上一頁 -->
            <s:if test="currentPage <= 1">
                <li class="page-item disabled">
            </s:if>
            <s:else>
                <li class="page-item">
            </s:else>
                <s:url var="prevUrl" action="list">
                    <s:param name="currentPage" value="currentPage - 1"/>
                </s:url>
                <a class="page-link" href="<s:property value='#prevUrl'/>">上一頁</a>
            </li>

            <!-- 中間頁碼 -->
            <s:iterator begin="1" end="totalPages" status="page">
                <s:if test="currentPage == #page.count">
                    <li class="page-item active">
                </s:if>
                <s:else>
                    <li class="page-item">
                </s:else>
                    <s:url var="pageUrl" action="list">
                        <s:param name="currentPage" value="#page.count"/>
                    </s:url>
                    <a class="page-link" href="<s:property value='#pageUrl'/>">
                        <s:property value="#page.count"/>
                    </a>
                </li>
            </s:iterator>

            <!-- 下一頁 -->
            <s:if test="currentPage >= totalPages">
                <li class="page-item disabled">
            </s:if>
            <s:else>
                <li class="page-item">
            </s:else>
                <s:url var="nextUrl" action="list">
                    <s:param name="currentPage" value="currentPage + 1"/>
                </s:url>
                <a class="page-link" href="<s:property value='#nextUrl'/>">下一頁</a>
            </li>
        </ul>
    </nav>
</div>

<!-- ✅ AJAX 處理程式 -->
<script>
$(document).ready(function () {
    $('.add-to-cart-btn').click(function () {
        const prodId = $(this).data('id'); // ✅ 正確取得商品 ID
        $.ajax({
            url: '<%=request.getContextPath()%>/cart/add.action',
            type: 'GET',
            data: { prodId: prodId }, // ✅ 對應後端的 setProdId()
            dataType: 'json',
            success: function (response) {
                if (response.success) {
                    alert("✅ " + response.message);
                } else {
                    alert("⚠️ " + response.message);
                }
            },
            error: function () {
                alert("❌ 加入購物車失敗，請稍後再試！");
            }
        });
    });
});
</script>

</body>
</html>
