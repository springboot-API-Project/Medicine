var main = {
    init: function () {
        var _this = this;

        $('#brd_save').on('click', function() {
            _this.save();
        })
    },
    save: function () {
        var data = {
            brd_title: $('#brd_title').val(),
            brd_content: $('#brd_content').val(),
            mem_id: $('#ses_id').val(),
            mem_nickname: $('#mem_nickname').val()
        };
        $.ajax({
            url: "api/board/save",
            dataType: JSON,
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert("게시글이 저장되었습니다.");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
};

main.init();