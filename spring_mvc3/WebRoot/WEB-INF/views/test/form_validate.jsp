<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.spring.com - WebRoot/WEB-INF/views/test/form_validate.jsp</title>
<style type="text/css">
.error {
    color: red;
}
</style>
</head>
<body>
www.spring.com - WebRoot/WEB-INF/views/test/form_validate.jsp<br/><br/>
<a href="${baseurl}./home">返回首页</a><br/>
<br/>
${hello}
<br/>
${client.name}
<br/><br/>
    <form:form method="post" modelAttribute="user">
        <p>用户注册页面：</p>
        <form:errors path="*" /><br/><br/>
        ${user_form_errors}<br/><br/>
        <table width="60%" align="center">
            <colgroup>
                <col width="10%" align="right" />
                <col />
            </colgroup>
            <tr>
                <th>用户名：</th>
                <td>
                    <form:input path="username" />
                    <small>length of username is not more than 20.</small><br />
                    <form:errors path="username" cssClass="error" />
                </td>
            </tr>
            <tr>
                <th>密码：</th>
                <td>
                    <form:password path="password" />
                    <small>length of password is not less than 6.</small><br />
                    <form:errors path="password" cssClass="error" />
                </td>
            </tr>
            <tr>
                <th>邮箱：</th>
                <td>
                    <form:input path="email" />
                    <small>format should confirm to general standard.</small><br />
                    <form:errors path="email" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="注册" />
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>