<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.spring.com - WebRoot/WEB-INF/views/mysql/db_test.jsp</title>
<style type="text/css">
.error {
    color: red;
}
</style>
</head>
<body>
www.spring.com - WebRoot/WEB-INF/views/mysql/db_test.jsp<br/><br/>
<a href="${baseurl}./home">返回首页</a><br/>
<br/>
${hello}
<br/>
${client.name}
<br/><br/>
<p>DataBase Table: gameserver</p>
<table width="500" align="left">
    <tr>
        <th>id:</th>
        <td>
            ${gameserver.id} ${gameserver_id}
        </td>
    </tr>
    <tr>        
        <th>regionId:</th>
        <td>
            ${gameserver.regionId} ${gameserver_regionId}
        </td>
    </tr>
    <tr>
        <th>regionName:</th>
        <td>
            ${gameserver.regionName} ${gameserver_regionName}
        </td>
    </tr>
    <tr>
        <th>areaId:</th>
        <td>
            ${gameserver.areaId} ${gameserver_areaId}
        </td>
    </tr>
    <tr>
        <th>areaName:</th>
        <td>
            ${gameserver.areaName} ${gameserver_areaName}
        </td>
    </tr>
    <tr>
        <th>areaNameFull:</th>
        <td>
            ${gameserver.areaNameFull} ${gameserver_areaNameFull}
        </td>
    </tr>
	<tr>
        <th>langId:</th>
        <td>
            ${gameserver.langId}
        </td>
    </tr>
	<tr>
        <th>langLocale:</th>
        <td>
            ${gameserver.langLocale}
        </td>
    </tr>
	<tr>
        <th>serverId:</th>
        <td>
            ${gameserver.serverId}
        </td>
    </tr>
	<tr>
        <th>serverName:</th>
        <td>
            ${gameserver.serverName}
        </td>
    </tr>
	<tr>
        <th>serverNameFull:</th>
        <td>
            ${gameserver.serverNameFull}
        </td>
    </tr>
	<tr>
        <th>serverNameAlias:</th>
        <td>
            ${gameserver.serverNameAlias}
        </td>
    </tr>
	<tr>
        <th>serverIP:</th>
        <td>
            ${gameserver.serverIP}
        </td>
    </tr>                
</table>
</body>
</html>