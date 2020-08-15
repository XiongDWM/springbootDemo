let NURL="http://localhost:8080/wxjs";
	
function saveData() {
    let data = {
    	newsHeading:$("#newsHeading").val(),
    	newsHref:$("#newsHref").val(),
    	npUrl:$("#npUrl").val(),
    	newsContent:$("textarea").val(),
    	isUsed:$("#isUsed").val()
    };

    $.ajax({
        url: NURL+'/newsAdd',
        data: data,
        type: 'post',
        dataType: 'json',
        success: function (data) {
            $('#backright').load('/front-wxjs/back/newsSelect.html');
        }
    })
}