<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>www.spring.com - WebRoot/index.jsp</title>
<script type="text/javascript" src="assets/scripts/jquery-1.10.2.min.js"></script>
<script>
alert("jquery 1.10.2 enter()!");
$(function(){
    $("#btnGet").click(function(){
        $.ajax({
            type: 'GET',
            url : 'client/Tian',   		// 通过url传递name参数
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

$(function(){
    $("#btnTest1").click(function(){
        $.ajax({
            type: 'GET',
            url : 'ajax1',   			// 通过url传递name参数
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

$(function(){
    $("#btnTest2").click(function(){
        $.ajax({
            type: 'GET',
            url : 'ajax2/test',   		// 通过url传递name参数
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
alert("jquery 1.10.2 over()!");
</script>
</head>
<body>
www.spring.com - WebRoot/index.jsp<br/><br/>
<a href="hello.html">Hello World!</a><br/>
<br/>
${hello}
${client.name}
<br/>
<input id="btnGet" type="button" value="Get Client" /><br/><br/>
<input id="btnTest1" type="button" value="Ajax Test1" /><br/><br/>
<input id="btnTest2" type="button" value="Ajax Test2" /><br/>
</body>
</html>