<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<c:if test="${!empty msg}">
		<h1><c:out value="${msg }" /></h1>
	</c:if>
	<a href="home/index" style="text-decoration:none;">首頁</a>
</body>
</html>
