$(function () {
    findAll();
})

function findAll() {  
   $.ajax({
        url: '/vcontent/findAll',
        data:'',
        dataType: 'json',
        type: 'get',
        async : false,
        success: function (data){
            let html = '';
            for (let i = 0; i <data[0].length; i++) {
                html += '<tr>' +
                    '<td>' + data[0].data[i].translate+ '</td>' +
                    '<td>' + data[0].data[i].context+ '</td>' +
                    '<td><a href="javascript:toEdit(' + data[0].data[i] + ')">编辑</a>  ' +
                    '<a href="javascript:Del(' + data[0].data[i] + ')" >删除</a></td>' +
                    '</tr>';
            }
            $("#vcdata").html(html);
        },
    })
}