//var localObj = window.location;
//var contextPath = localObj.pathname.split("/")[1];
//var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
//var server_context=basePath;
let pURL="http://localhost:8080/wxjs";
function saveData() {
    let data = new FormData();
    	data.append("infoText",$("#infoText").val());
    	data.append("picUrl",$("#picUrl").get(0).files[0]);
    	data.append("price",$("#price").val());
    

    $.ajax({
        url: pURL+'/productAdd',
        data: data,
        type: 'post',
        dataType: 'json',
        contentType: false,
        processData: false,
        success: function (data) {
            $('#backright').load('/front-wxjs/back/companySelect.html');
        }
    })
}