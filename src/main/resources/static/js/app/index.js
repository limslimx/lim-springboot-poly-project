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
                    var name = json[i].name;
                    var author = json[i].author;
                    msg += ("<div id=book"+i+">")
                    msg += ("<img src=" + json[i].img + "></img><br/>");
                    msg += ("<h4 id=title"+i+">" + json[i].name + "</h4>");
                    if (!(json[i].subName == "")) {
                        msg += ("소제목: <h6 id=subTitle" + i + ">" + json[i].subName + "</h6>");
                    }
                    msg += ("저자: <h6 id=author"+i+">"+ json[i].author + "</h6>");
                    msg += ("카테고리: <h6 id=category"+i+">" + json[i].detailCategory + "</h6>");
                    if (!(json[i].rank == "")) {
                        msg += ("순위: " + json[i].rank + "<br/>");
                    }
                    msg += ("태그: " + json[i].tag + "<br/>");
                    msg += ("출간일: " + json[i].publicationDate.substring(0, json[i].publicationDate.length-2) + "<br/>");
                    msg += ("<button type=button class='btn btn-sm btn-success' id='btn-review"+i+"' onclick='test(this.id)'>독서록 작성하기</button><br/>");
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

function test(id) {

    var id = id.substring(10, id.length);

    var data = {
        name: $("#title"+id).html(),
        author: $("#author"+id).html(),
        category: $("#category"+id).html()
    }

    console.log(data.name);
    console.log(data.author);
    console.log(data.category);

    $.ajax({
        type: "post",
        url: "/book/review",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data)
    }).done(function () {
        console.log("success");
        window.location.href = "/book/review";
    });

}
index.init();