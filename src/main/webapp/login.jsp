<%@ page import="com.example.pojo.entity.User" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
    // 獲取當前會話中的用戶物件
    User user = (User) session.getAttribute("user");

    // 如果用戶已登入，則重新導向到首頁
    if (user != null && !"".equals(user.getLoginId())) {
        response.sendRedirect("home/index");
    }
%>

<!DOCTYPE html>
<html lang="zh-TW">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用戶登入</title>
    <script src="public/jquery-3.4.1.min.js"></script>
</head>
<body>
    <form id="loginForm" action="login/login" method="post">
        <div style="margin: 50px;">
            <table>
                <!-- 顯示錯誤訊息 -->
                <c:if test="${not empty msg}">
                    <tr>
                        <td colspan="2" align="center" style="color: red;">
                            <c:out value="${msg}" />
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>使用者名稱：</td>
                    <td>
                        <input type="text" name="loginId" value='<c:out value="${loginId}"/>' required>
                    </td>
                </tr>
                <tr>
                    <td>密碼：</td>
                    <td>
                        <input type="password" name="password" required>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <br />
                        <button type="button" onclick="validateAndSubmit()">登入</button>
                        &nbsp;<a href="register/register" style="text-decoration: none;">註冊</a>
                    </td>
                </tr>
            </table>
        </div>
    </form>

    <script type="text/javascript">
        function validateAndSubmit() {
            let loginId = $("input[name='loginId']").val().trim();
            let password = $("input[name='password']").val().trim();

            if (!loginId) {
                alert("使用者名稱不能為空");
                return;
            }

            if (!password) {
                alert("密碼不能為空");
                return;
            }

            $("#loginForm").submit();
        }
    </script>
</body>
</html>
