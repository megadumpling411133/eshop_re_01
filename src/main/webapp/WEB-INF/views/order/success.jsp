<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>訂單成功</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5 text-center">
    <h2 class="text-success">✅ 訂單已成功建立！</h2>
    <p class="mt-3">感謝您的購買，我們會儘速處理您的訂單。</p>
    <a href="${pageContext.request.contextPath}/product/list.action" class="btn btn-primary mt-4">繼續購物</a>
</div>
</body>
</html>
