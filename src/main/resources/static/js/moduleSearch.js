//var localObj = window.location;
//var contextPath = localObj.pathname.split("/")[1];
//var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
//var server_context=basePath;

let MURL="http://localhost:8080/wxjs";

$(function () {
    findAll();
})

function findAll() {  
   $.ajax({
        url: MURL+'/moduleSearch',
        data:'',
        dataType: 'json',
        type: 'get',
        success: function (data){
            let html = '';
            for (let i = 0; i < data[0].object.length; i++) {
                html += '<tr>' +
                    '<td>' + data[0].object[i].id + '</td>' +
                    '<td>' + data[0].object[i].mid+ '</td>' +
                    '<td>' + data[0].object[i].mhref+ '</td>' +
                    '<td><a href="javascript:toEdit(' + data[0].object[i] + ')">编辑</a>  ' +
                    '<a href="javascript:Del(' + data[0].object[i] + ')" >删除</a></td>' +
                    '</tr>';
            }
            $("#moduleData").html(html);
        },
    })
}
function Del(){}
function toEdit(){}