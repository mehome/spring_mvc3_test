<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>www.spring.com - WebRoot/WEB-INF/views/test/ajax_test.jsp</title>
<script type="text/javascript" src="${baseurl}./assets/scripts/jquery-1.10.2.min.js"></script>
<script>
//alert("jquery 1.10.2 enter()!");
$(function() {
    $("#btnGet").click(function() {
        $.ajax({
            type: 'GET',
            url : '${baseurl}./test/client/Tian',   		// 通过url传递name参数
            dataType : 'json',
            data: {title: "Mr Test 0"},	// 通过data传递title参数
            success : function(data) {
            	alert("ajax test 0 success!");
                alert(data.name);
            },
            error : function(data) {
            	alert("ajax error!");
                alert(data.responseText);
            }
        });
    });
});

$(function() {
    $("#btnTest1").click(function() {
        $.ajax({
            type: 'GET',
            url : '${baseurl}./test/ajax1',   			// 通过url传递name参数
            dataType : 'json',
            data: {title: "Mr Test 1"},	// 通过data传递title参数
            success : function(data) {
            	alert("ajax test 1 success!");
                alert(data.name);
            },
            error : function(data) {
            	alert("ajax error!");
                alert(data.responseText);
            }
        });
    });
});

$(function() {
    $("#btnTest2").click(function() {
        $.ajax({
            type: 'GET',
            url : '${baseurl}./test/ajax2/test',   		// 通过url传递name参数
            dataType : 'json',
            data: {title: "Mr Test 2"},	// 通过data传递title参数
            success : function(data) {
            	alert("ajax test 2 success!");
            	for (var i = 0; i < data.length; i++)
                	alert(data[i].name);
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
www.spring.com - WebRoot/WEB-INF/views/test/ajax_test.jsp<br/><br/>
<a href="${baseurl}./home">返回首页</a><br/>
<br/>
${hello}
<br/>
${client.name}
<br/><br/>
<input id="btnGet" type="button" value="Get Client" /><br/><br/>
<input id="btnTest1" type="button" value="Ajax Test1" /><br/><br/>
<input id="btnTest2" type="button" value="Ajax Test2" /><br/>
</body>
</html>