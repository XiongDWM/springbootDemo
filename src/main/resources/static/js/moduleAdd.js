/*var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
var server_context=basePath;*/
let mURL="http://localhost:8080/wxjs"
function save() {
    let data = {lableName: $("#lableName").val(), href: $("#href").val()};
    	
        $.ajax({
            url:mURL+'/moduleAdd',
            data: data,
            type: 'post',
            dataType: 'json',
            success: function (data) {
                alert(data[0].result);
                $('#backright').load('/front-wxjs/back/moduleSelect.html');
            }
        })
}