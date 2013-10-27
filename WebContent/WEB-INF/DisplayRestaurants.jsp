<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Restaurants</title>
</head>
<body>
	<c:forEach items="${restaurants}" var="r">
		<p>Restau ${ r.id }, Type1 = ${ r.type1 }, Type2 = ${ r.type2 }</p>
    </c:forEach>
</body>
</html>