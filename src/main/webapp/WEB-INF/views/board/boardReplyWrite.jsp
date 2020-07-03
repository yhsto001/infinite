<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/jscsspath.jsp" %>  
<style type="text/css">
.page-header{
place-content: center;
}
.detail1{
width:100%;
}
.card-title
{
    width: 100%;
    text-align: center;
}
</style>
<script type="text/javascript">
</script>
</head>
<body>
 <div class="page">
<jsp:include page="../common/header.jsp" />
 <div class="page-main">
        <div class="my-3 my-md-5">
          <div class="container">
            <div class="page-header">
              <h1 class="page-title">
           	   RE ${board.BOARDTITLE } :
              </h1>
            </div>
        <div class="row">
              <div class="detail1">
                <div class="card">
              <form action="boardReplyAdd.do" method="post" enctype="multipart/form-data">
                  <div class="card-body">
                   <div class="form-group">
                        <div class="row align-items-center">
                          <label class="col-sm-2">제목:</label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" id="BOARDTITLE" name="BOARDTITLE">
                          </div>
                        </div>
                      </div>
       
                      <div class="form-group">
                        <div class="row align-items-center">
                          <label class="col-sm-2">파일첨부:</label>
                          <div class="col-sm-10">
                            <input type="file" class="form-control" id="file" name="file">
                          </div>
                        </div>
                      </div>
                       <div class="form-group">
                        <div class="row align-items-center">
                          <label class="col-sm-2">내용:</label>
                        </div>
                      </div>
                      <textarea rows="10" class="form-control" id="BOARDCONTENT" name="BOARDCONTENT"></textarea>
                      <div class="btn-list mt-4 text-right">
                      <input type="hidden" value="${sessionScope.user.USERNAME }" id="USERNAME" name="USERNAME">
                      <input type="hidden" value="${sessionScope.user.USERNO }" id="USERNO" name="USERNO">
                   	<input type="hidden" value="${board.BOARDGROUP }" name="BOARDGROUP">
                        <input type="hidden" value="${board.BOARDGROUP }" name="BOARDGROUP">
                        <input type="hidden" value="${board.BOARDGROUPNO }" name="BOARDGROUPNO">
                        <input type="hidden" value="${board.BOARDDEPTH }" name="BOARDDEPTH">
                        <input type="hidden" value="${board.BOARDKEY }" name="BOARDKEY">
                        <input type="hidden" value="${board.BOARDPARENT }" name="BOARDPARENT">
                        <input type="hidden" value="${board.BOARDNO}" name="BOARDNO">
                        <button type="submit" class="btn btn-primary btn-space">작성</button>
                        <button type="reset" class="btn btn-secondary btn-space">취소</button>           
                      </div>
                  </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
<jsp:include page="../common/footer.jsp" />
</div>
</body>
</html>