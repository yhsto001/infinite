		/* <%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%> */  
						$(function () {

								viewDetailDataGet();
								viewDetailComment();
								//답글 기본 숨김
								$("#showhide").hide(); // display 속성을 none 으로 바꾼다.

								//답글 클릭시
								/* $('#boardList').click(
								boardList					
								); */						
							});

							function boardList_click() {
								location.href = "boardList.do?";
							}
							
							
							function delete_click() {
								if (confirm("삭제하시겠습니까??") == true) {
									location.href = "boardDelete.do?BOARDNO=" + no2;
								} else {
									return;
								}
							}
							
							
							function update_click() {
								if (confirm("수정하시겠습니까??") == true) {
									location.href = "boardChangeView.do?BOARDNO=" + no2;
								} else {
									return;
								}
							}
							function comment_click() {
								$("#showhide").toggle();
							}
							
							
							function commentdel_click(COMMENTNO) {
								if (confirm("답글을 삭제하시겠습니까??") == true) {
									location.href = "boardCommentDel.do?COMMENTNO=" + COMMENTNO + "&BOARDNO=" + no2;
								} else {
									return;
								}
							}

							
							function commentchang_click(COMMENTNO) {
								var comment = '';

								comment += "<input type='text' class='form-control' style='width:850px; display:inline;' id='COMMENTCONTENT" + COMMENTNO + "'>";
								comment += "<button class='btn btn-primary btn-space' style='margin-bottom: 2px;' onclick='commentchange_click(" + COMMENTNO + ")'>확인</button>";
								$("#" + COMMENTNO).html(comment);
							}
							
							
							function commentchange_click(COMMENTNO) {
								var commentcontent = $("#COMMENTCONTENT" + COMMENTNO).val();
								if (confirm("답글을 수정하시겠습니까??") == true) {
									location.href = "boardCommentChange.do?COMMENTNO=" + COMMENTNO + "&BOARDNO=" + no2 + "&COMMENTCONTENT=" + commentcontent + "";
								} else {
									return;
								}
							}

							
							/* var rootUrl = '${request.context}';  */
							function viewDetailDataGet() {
								$.ajax({
									url: "boardDetail.do",
									data: {
										no: $("#no").val()
									},
									type: "get",
									contentType: "application/json",
									success: function (data) {
										console.log(data);
										if(data.boardoriginalfile != null){
										var value1 = "<a href='boardfiledown.do?BOARDORIGINALFILE=" + data.boardoriginalfile + "&BOARDRENAMEFILE=" + data.boardrenamefile + "'>" + data.boardoriginalfile + "</a>";
										$("#ofile").html(value1);
										}
										$("#title").html(data.boardtitle);
										$("#username").val(data.username);
										$("#content").val(data.username);
										
									},
									error: function (e) {
										console.log(e.responseText);
									}
								});
							}

							
							function viewDetailComment() {
								$.ajax({
									url: "boardDetailComment.do",
									data: {
										no: $("#no").val()
									},
									type: "get",
									contentType: "application/json",
									success: function (data) {
										if(data != ""){
										var comstr = " <div class=\"card\" style=\"background-color: #dee2e6;\">";
										for (i = 0; i < data.length; i++) {
											console.log(i);
											comstr += "		<div class='card-body' style='padding: 0.5rem;'>";
											comstr += "			<div class='form-group'>";
											comstr += "				<div class='row align-items-center'>";
											comstr += "					<label class='boardLabel' id='cmtname'>" + data[i].commentname + " :</label>";
											comstr += "					<div class='' style='padding-top: 3px; width: 950px;' id='" + data[i].commentno + "'>";
											comstr += 					data[i].commentcontent;
											comstr += "					</div>";
											comstr += "					<button class='btn btn-primary btn-space' onclick='commentchang_click(" + data[i].commentno + ")'>수정</button>";
											comstr += "						&nbsp;  &nbsp;";
											comstr += "					<button class='btn btn-secondary btn-space' onclick='commentdel_click(" + data[i].commentno + ")'>삭제</button>";
											comstr += "				</div>";
											comstr += "			</div>";
											comstr += "		</div>";
										}
											comstr += "</div>";
										$("#cmt").html(comstr);
										}
									},
									error: function (e) {
										console.log(e.responseText);
									}
								});
							}

							
							function commentAdd_click() {
								if (confirm("답글을 등록 하시겠습니까??") == true){

									$("form").submit();
								}else{
								
								return;
								}
							}