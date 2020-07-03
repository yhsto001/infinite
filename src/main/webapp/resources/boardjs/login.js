function idpwschk(){
  var form = new FormData(document.getElementById('loginchk'));
      $.ajax({
        url : "login.do",
        data : form,
        type : 'POST',
        dataType : 'json',
        async : false,
        processData : false,
        contentType : false,
        success : function(data){
          console.log(data);
          location.href = "htmain.do";
        },
        error : function (request, status, error){
          alert("아이디가 없거나 패스워드가 일치하지 않습니다.");
        }
      });
}