var buddy = {
    init : function () {
        var _this = this;
        $('button[name=btn-request]').on('click', function () {
            var buddyId = $(this).val();
            _this.buddyRequest(buddyId);
        });
        $('button[name=btn-accept]').on('click', function () {
            var buddyId = $(this).val();
            _this.buddyAccept(buddyId);
        });
    },

    buddyRequest : function (buddyId) {
        $.ajax({
            type: 'POST',
            url: '/api/buddy/request',
            //dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: buddyId
        }).done(function() {
            console.log(buddyId);
            alert(buddyId+"님에게 친구 요청을 보냈습니다!");
            $('#'+buddyId).prop("disabled", true);
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    buddyAccept : function (buddyId) {
        $.ajax({
            type: 'POST',
            url: '/api/buddy/accept',
            //dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: buddyId
        }).done(function() {
            console.log(buddyId);
            alert(buddyId+"님과 친구가 되었습니다!");
            window.location.href = '/buddy/list';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

buddy.init();