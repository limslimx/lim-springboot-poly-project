var index={
    init: function () {
        var _this=this;

        $('#btn-review0').on('click', function () {
            _this.review();
        });
    },
    review: function () {
        window.alert("hello");
    }
};
index.init();