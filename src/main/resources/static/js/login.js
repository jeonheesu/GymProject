$("#loginBtn").click(function() {
   
  
   
    g_id = $('#g_id').val();
    g_password = $('#g_password').val();
    

    if(g_id == null || g_id.trim() == ""){
        alert("아이디를 입력해주세요");
        return false;
    }
    if(g_password == null || g_password.trim() == ""){
        alert("비밀번호를 입력해주세요");
        return false;
    }

  
    
});


