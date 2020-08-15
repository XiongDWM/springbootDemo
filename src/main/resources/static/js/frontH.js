let HPURL="http://localhost:8080/wxjs";
$(function(){
	setModuleList()
	setNewsList();
})

/*function getAllInfoForHomePage(){
	let data=communalAjax("/fronthome","get");
	
	setModuleList(data[0].object.moduleList);
	//setProductList(data[0].object.productList);
	//setNewsList(data[0].object.newsList);
}*/

function setModuleList(){
	$.ajax({
        url: HPURL+'/fronthome',
        data:'',
        dataType: 'json',
        type: 'get',
        success: function (data){
            let html = '';
            for (let i = 0; i < data[0].object.moduleList.length;i++) {
                html +=
                	'<a href="'+data[0].object.moduleList[i].mhref+'" class="menu">'+data[0].object.moduleList[i].mid+'</a>'
                
            }
            $("#topAtHome").html(html);
        },
    })
	
}

/*function setProductList(data){
	let html = '';
    for (let i = 0; i < data.length; i++) {
        html += ' <div>\n' +
            '     <a href="#"><h5>' + data[i].title + '</h5></a>\n' +
            '     <a href="#"><p>' + data[i].content + '</p></a>\n' +
            ' </div>';
    }
    $("#homeNewsList").html(html);
	
}*/

function setNewsList(){

    $.ajax({
        url: HPURL+'/fronthome',
        data:'',
        dataType: 'json',
        type: 'get',
        success: function (data){
            let html = '';
            for (let i = 0; i < data[0].object.newsList.length;i++) {
                html += ' <div>' +
                '     	<h5>' + data[0].object.newsList[i].nid + '</h5>\n' +
                '     <a href="'+data[0].object.newsList[i].nhref+'"><p>' + data[0].object.newsList[i].nctnt + '</p></a>\n' +
                ' </div>';
            }
            $("#newsListHomePage").html(html);
        },
    })
}