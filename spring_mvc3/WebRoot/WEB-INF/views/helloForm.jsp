<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.spring.com - WebRoot/WEB-INF/views/helloForm.jsp</title>
<script type="text/javascript" src="${baseurl}./assets/scripts/jquery-1.10.2.min.js"></script>
<script>
//alert("jquery 1.10.2 enter()!");
$(function() {
    $("#btnGet").click(function() {
        $.ajax({
            type: 'GET',
            url : '${baseurl}./ajax/client/Tian',  		// 通过url传递name参数
            dataType : 'json',
            data: {title: "Mr"},   		// 通过data传递title参数
            success : function(data) {
            	alert("ajax success!");
                alert(data.name);
            },
            error : function(data) {
            	alert("ajax error!");
                alert(data.responseText);
            }
        });
    });
});
//alert("jquery 1.10.2 over()!");
</script>
</head>
<body>
www.spring.com - WebRoot/WEB-INF/views/helloForm.jsp<br/><br/>
<a href="${baseurl}./home">Hello World!</a><br/>
<br/>
${hello}
<br/>
${client.name}
<br/><br/>
<input id="btnGet" type="button" value="get client" />
</body>
</html>