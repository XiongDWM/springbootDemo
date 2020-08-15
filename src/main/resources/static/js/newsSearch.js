let nURL="http://localhost:8080/wxjs";

$(function () {
    findAll(); 
})

function findAll() {  
   $.ajax({
        url: nURL+'/newsSearch',
        data:'',
        dataType: 'json',
        type: 'get',
        success: function (data){
            let html = '';
            for (let i = 0; i < data[0].object.length; i++) {
                html += '<tr>' +
                    '<td>' + data[0].object[i].id + '</td>' +
                    '<td>' + data[0].object[i].nid+ '</td>'+
                    '<td>' + data[0].object[i].nctnt+ '</td>' +
                    '<td>' + data[0].object[i].nhref+'</td>'+
                    '<td>' + data[0].object[i].npic+ '</td>'+
                    '<td>' + data[0].object[i].nusage+ '</td>'+
                    '<td><a href="javascript:toEdit(' + data[0].object[i] + ')">编辑</a>  ' +
                    '<a href="javascript:Del(' + data[0].object[i] + ')" >删除</a></td>' +
                    '</tr>';
            }
            $("#newsData").html(html);
        },
    })
}