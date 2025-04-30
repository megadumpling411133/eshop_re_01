<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
    <meta charset="UTF-8">
    <title>註冊頁面</title>
</head>
<body>
    <h2>註冊新帳號</h2>
    <s:form action="save" namespace="/register" method="post">
        <table>
            <tr>
                <td>使用者名稱：</td>
                <td><s:textfield name="loginId" required="true"/></td>
            </tr>
            <tr>
                <td>密碼：</td>
                <td><s:password name="password" required="true"/></td>
            </tr>
            <tr>
                <td>電話：</td>
                <td><s:textfield name="tel"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <s:submit value="註冊" />
                </td>
            </tr>
        </table>
    </s:form>
</body>
</html>
