$(function(){
    $("#serchKeyword").focus();
    var searchKeyword;
    var arry = [];
    $("#serchKeyword").on("keyup",function(e){

        var curIdx = $(".viewKeyword").find(".Suggestion__item--selected").index();
        var selected = $(".viewKeyword").children();

        if (e.keyCode == '38') { // 위방향키
            selected.eq(curIdx-1).attr("class","Suggestion__item--selected");
            selected.eq(curIdx).attr("class","");
        }else if (e.keyCode == '40') { //밑방향키
            selected.eq(curIdx).attr("class","");
            if(selected.length == curIdx+1){ //마지막일경우 0번선택
                selected.eq(0).attr("class","Suggestion__item--selected");
            }else{
                selected.eq(curIdx+1).attr("class","Suggestion__item--selected");
            }
        }else if (e.keyCode == '13'){ //엔터
            curIdx = $(".viewKeyword").find(".Suggestion__item--selected").index();
            alert(arry[curIdx]);
            topViewAdd(curIdx);
        }

        if(searchKeyword == $(this).val()){ //같은값 무시
            return false;
        }
        searchKeyword = $(this).val();

        if(searchKeyword == ""){ //빈값 무시
            $(".Suggestion").hide();
            return false;
        }

        $.ajax({
            url: "https://wr4a6p937i.execute-api.ap-northeast-2.amazonaws.com/dev/languages",
            dataType: "json",
            data: {"keyword":searchKeyword},
            method : "GET",
            success: function(data) {
                $(".viewKeyword").empty();
                arry = [];
                if(data.length == 0){
                    $(".Suggestion").hide();
                }else{
                    $(".Suggestion").show();
                }
                for(var index in data){
                    arry.push(data[index]);
                    var regexAllCase = new RegExp(searchKeyword, "gi");
                    keyword = data[index].replace(regexAllCase,"<span class='Suggestion__item--matched'>"+searchKeyword+"</span>");//검색단어 마킹
                    $(".viewKeyword").append('<li>'+keyword+'</li>');
                }
                $(".viewKeyword").children().eq(0).attr("class","Suggestion__item--selected");
                deleteCookie("keyword");
                setCookie("keyword",searchKeyword,10);
            },error:function(xhr, status, message) {

            }

        })
    })

    $(document).on("click",".viewKeyword li",function(){ // 클릭이벤트
        var idx = $(this).index();
        alert(arry[idx]);
        topViewAdd(idx);
        $("#serchKeyword").focus();
    })

    function topViewAdd(idx){ // 상위뷰 추가
        var topView = $(".topViewKeyword");
        for(var length = 0 ; length < topView.children().length;length++){
            if(topView.children().eq(length).text() == arry[idx]){
                topView.children().eq(length).remove();
            }
        }
        $(".topViewKeyword").append("<li>"+arry[idx]+"</li>");
        if(topView.children().length == 6){
            topView.children().eq(0).remove();
        }
    }

    function setCookie(name, value, exp) {
        var date = new Date();
        date.setTime(date.getTime() + exp*24*60*60*1000);
        document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
    };

    function getCookie(name) {
        var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
        return value? value[2] : null;
    };

    function deleteCookie(name) {
        document.cookie = name + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT;';
    }

    $("#serchKeyword").val(getCookie("keyword"));
    $("#serchKeyword").keyup(); //키업 이벤트 촉발

})