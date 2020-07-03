<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
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
#ofile{
color: cornflowerblue;
}
</style>
<script type="text/javascript">
function update_click(){
	if(confirm("수정하시겠습니까??") == true){
		
	}else{
		return;
	}
}
/* var rootUrl = '${request.context}';  */

$(function(){
	viewDetailDataGet();
	
	/* $('#boardList').click(
	boardList		
	); */
});
function viewDetailDataGet(){
		$.ajax({
			url : "boardDetail.do",
			data : {no : $("#no").val()},
			type : "get",
			contentType : "application/json",
			success : function(data){
				console.log(data);
				var value1 = "<a href='boardfiledown.do?BOARDORIGINALFILE="+data.boardoriginalfile+"&BOARDRENAMEFILE="+data.boardrenamefile+"'>"+data.boardoriginalfile+"</a>";
				$("#BOARDTITLE").val(data.boardtitle);
				$("#username").val(data.username);
				$("#BOARDCONTENT").val(data.username);
			},
			error : function(e) {
                console.log(e.responseText);
            }
		}); 
}

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
           	  게시글 수정
              </h1>
            </div>
        <div class="row">
              <div class="detail1">
                <div class="card"> 
                  <input type="hidden" id="no" value="${no }">
                    <form action="boardUpdate.do" method="post" enctype="multipart/form-data">
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
                          <label class="col-sm-2">글쓴이:</label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" id="username" readonly>
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
                     <textarea rows="10" class="form-control" id="BOARDCONTENT" name="BOARDCONTENT"></textarea>
                      <div class="btn-list mt-4 text-right">
                      <input type="hidden" id="BOARDNO" name="BOARDNO" value="${no }">
                        <button class="btn btn-primary btn-space" type="submit">수정</button>
                     <button class="btn btn-secondary btn-space" id="boarList" onclick="history.back();">뒤로가기 </button>
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