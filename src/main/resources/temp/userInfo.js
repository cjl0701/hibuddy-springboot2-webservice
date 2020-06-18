var userInfo = {
    init : function () {
        var _this = this;
        $('#btn-confirm').on('click', function () {
            _this.confirm();
            alert("confirm");
        });

        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });
    },

    confirm : function () {

        console.log("confirm");
        var data = {userId: $('#userId').val()};

        if($('#userId').val() ==="s") {
            alert("아이디를 입력하세요");
            return;
        }

        $.ajax({
            type: 'GET',
            url: '/api/user/info/'+userId,
            data: JSON.stringify(data), //전송할 데이터
            dataType: 'json', //요청한 데이터 형식
            contentType:'application/json; charset=utf-8'
        }).done(function(result) {
            if(result==="avalable")
                alert('사용 가능한 아이디 입니다.');
            else
                alert('이미 등록된 아이디 입니다.');
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/'; //글 등록이 성공하면 메인페이지('/')로 이동
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT', //
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

userInfo.init();