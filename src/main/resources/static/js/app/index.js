var index={
    init :function () {
        var _this = this;

        $('#btn-search').on('click', function () {
            _this.search();
        });
    },
    search: function () {

        var searchBy = $('#search_info').val();

        $.ajax({
            type: 'POST',
            url: '/book/info',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(searchBy),
            success: function (json) {
                var msg="";
                for (var i = 0; i < json.length; i++) {
                    msg += ("<div id=book"+i+">")
                    msg += ("<img src=" + json[i].img + "></img><br/>");
                    msg += ("<h4 id=title>" + json[i].name + "</h4>");
                    msg += ("소제목: " + json[i].subName + "<br/>");
                    msg += ("저자: " + json[i].author + "<br/>");
                    msg += ("카테고리: " + json[i].detailCategory + "<br/>");
                    msg += ("순위: " + json[i].rank + "<br/>");
                    msg += ("태그: " + json[i].tag + "<br/>");
                    msg += ("출간일: " + json[i].publicationDate + "<br/>");
                    msg += ("<button type=button class='btn btn-sm btn-success' id=btn-review"+i+">독서록 작성하기</button><br/>");
                    msg += ("</div>")
                    msg+=("<hr/>");
                }
                $('#book_info').html(msg);
            },
            fail: function (error) {
                alert(JSON.stringify(error));
            }
        });
    }

};

var main = {
    init: function () {
        $("#btn-review")
    }
};
index.init();