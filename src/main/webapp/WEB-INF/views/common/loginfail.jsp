<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/jscsspath.jsp" %>  
</head>
<body>
<div class="page">
      <div class="page-content">
        <div class="container text-center">
          <div class="display-1 text-muted mb-5"><i class="si si-exclamation"></i> 로그인실패</div>
          <p class="h4 text-muted font-weight-normal mb-7">아이디 또는 비밀번호가 일치하지 않습니다. 다시시도해주세요.</p>
          <a class="btn btn-primary" href="javascript:history.back()">
            <i class="fe fe-arrow-left mr-2"></i>Go back
          </a>
        </div>
      </div>
    </div>
</body>
</html>