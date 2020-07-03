<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/jscsspath.jsp" %>  
</head>
<body>
 <div class="page">
      <div class="page-main">
        <jsp:include page="../common/header.jsp" />
        <div class="my-3 my-md-5">
          <div class="container">
    <img alt="dambeemain" class="header-brand-img" src="<c:url value='/resources/images/logo/dambeemain.jpg'/>" style="width:100%; height:730px;">
    </div>
    </div>
      </div>										
         <jsp:include page="../common/footer.jsp" />
      </div>
</body>
</html>