var userInfo = {
    init: function () {
        var _this = this;
        $('#btn-confirm').on('click', function () {
            _this.confirm();
        });

        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });
    },
    //아이디 중복 확인
    confirm: function () {
        var userId = $('#userId').val();
        if (userId === '') {
            alert("아이디를 입력하세요");
            return;
        }
        $.ajax({
            type: 'POST',
            async: true,
            url: '/api/user/info',
            //dataType: 'json', //요청한 데이터 형식. 생략하면 자동으로 자료에 맞게
            contentType: 'application/json; charset=utf-8',
            data: userId
        }).done(function (result) {
            if (result === "available")
                alert('사용 가능한 아이디 입니다.');
            else
                alert('이미 등록된 아이디 입니다.');
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    //회원 가입
    save: function () {
        var userId = $('#userId').val();
        if (userId === '') {
            alert("아이디를 입력하세요");
            return;
        }
        var data = {
            userId: userId,
            name: $('#name').val(),
            email: $('#email').val(),
            sex: $('#sex').val(),
            age: $('#age').val(),
            phone: $('#phone').val(),
            nation: $('#nation').val(),
            nativeLanguage: $('#nativeLang').val(),
            secondLanguage: $('#secondaryLang').val(),
            hobby1: $('#hobby1').val(),
            hobby2: $('#hobby2').val(),
            hobby3: $('#hobby3').val()
        };
        console.log(data);
        $.ajax({
            type: 'POST',
            url: '/api/user/join',
            //dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('가입되었습니다!' +
                '\n다시 로그인 해주세요!');
            window.location.href = '/logout'; //회원 가입이 성공하면 세션 초기화를 위해 로그아웃
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    update: function () {
        var data = {
            age: $('#age').val(),
            phone: $('#phone').val(),
            nation: $('#nation').val(),
            nativeLanguage: $('#nativeLang').val(),
            secondLanguage: $('#secondaryLang').val(),
            hobby1: $('#hobby1').val(),
            hobby2: $('#hobby2').val(),
            hobby3: $('#hobby3').val()
        };
        console.log(data);

        $.ajax({
            type: 'PUT',
            url: '/api/user/update/' + $('#userId').val(),
            //dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('회원 정보가 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

userInfo.init();