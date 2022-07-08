$("#UpdateBtn").click(function () {

    var memberUpdatetag = $('#memberUpdateForm');

    g_no = $('#g_no').val();
    g_id = $('#g_id').val();
    g_password = $('#g_password').val();
    g_Rpassword = $('#g_Rpassword').val();
    g_name = $('#g_name').val();
    g_height = $('#g_height').val();
    g_weight = $('#g_weight').val();


    if (g_id == null || g_id.trim() == "") {
        alert("아이디를 입력해주세요");
        return false;
    }
    if (g_password == null || g_password.trim() == "") {
        alert("비밀번호를 입력해주세요");
        return false;
    }
    if (g_Rpassword == null || g_Rpassword.trim() == "") {
        alert("비밀번호를 재 입력해주세요");
        return false;
    }
    if (g_password != g_Rpassword) {
        alert('비밀번호와 비밀번호 확인란이 일치 하지 않습니다');
        return false;
    }
    if (g_height == null || g_height.trim() == "") {
        alert('키를 입력해 주세요');
        return false;
    }
    if (g_weight == null || g_weight.trim() == "") {
        alert('몸무게를 입력해주세요');
        return false;
    }

    if (g_name == null || g_name.trim() == "") {
        alert("닉네임을 입력해주세요");
        return false;
    }


    var test = bmi(g_height, g_weight);
    $('#g_bmi').val(test);


    memberUpdatetag.submit();

});

$('#id_check').click(function () {
    g_id = $('#g_id').val();
    $.ajax({
        url: '/check_id',
        type: 'post',
        data: {
            g_id: g_id
        },
        success: function (data) {
            console.log(data);
            if (data > 0) {
                alert('아이디 중복');
            } else {
                alert('아이디 사용 가능');
                id_check = true;
            }
        },
        error: function (request, status, error) {
            console.log("code:" + request.status + "\n" +
                "message:" + request.responseText + "\n" +
                "error:" + error);
        }
    });
});






function bmi(g_height, g_weight) {




    return Math.round(g_weight / ((g_height / 100) * (g_height / 100))*100)/100;

}