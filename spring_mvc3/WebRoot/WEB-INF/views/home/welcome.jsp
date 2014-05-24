<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.spring.com - WebRoot/WEB-INF/views/home/welcome.jsp</title>
<script type="text/javascript" src="${baseurl}./assets/scripts/jquery-1.10.2.min.js"></script>
</head>
<body>
www.spring.com - WebRoot/WEB-INF/views/home/welcome.jsp<br/>
<br/>
${hello}
<br/>
${client.name}
<br/><br/>
Spring MVC 3.2.4 Demo<br/>
<ul>
<li><a href="${baseurl}./test/ajax_test">Ajax测试</a></li>
<li><a href="${baseurl}./test/form_validate">表单验证测试</a></li>
</ul>
</body>
</html>