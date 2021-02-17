$(function () {
    printResult = function (data) {
        var result = JSON.stringify(data);
        alert(result);
    };

    $('#btn-allow-basic').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/api/allow_info/basic',
            async: true,
            dataType: 'text',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
            ,
            success: function (result) {
                var html="<table width='600' border='1'";
                $.each(data, function (entryIndex, entry) {
                    html += "<tr class='bbb'>"
                    html += '<td class="bgcolor1">' + entry.id + '</td>';
                    html += '<td class="bgcolor2">' + entry.comment_content + '</td>';
                    html += '<td class="bgcolor2">' + entry.write_date + '</td>';
                    html += '<td id="abc" class="bgcolor2"><input type="button" onclick="rowDelete(this)" value='+ entry.comment_num+'></td>';
                    html += '</tr>';

                })
            }
        }).done(function () {
            window.location.href='/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    })
});




// var main = {
//     init: function () {
//         var _this = this;
//
//         $('#btn-allow-basic').on('click', function () {
//             _this.getBasic();
//         });
//     },
//     getBasic: function () {
//         $.ajax({
//             type: 'GET',
//             url: '/api/allow_info/basic',
//             dataType: 'json',
//             contentType: 'application/json; charset=utf-8',
//             data: JSON.stringify(data)
//         }).done(function () {
//             alert('정보가 출력됩니다');
//             window.location.href='/';
//         }).fail(function (error) {
//             alert()
//         })
//     }
// }