
let AURL="http://localhost:8080/wxjs"
	
$(function () {
    findAll();
})

function findAll() {
	let data={ searchinId: $("#searchinId").val(), searchinUid: $("#searchinUid").val(),searchinPwd: $("#searchinPwd").val()}
    $.ajax({
        url: AURL+'/userSelect',
        data:data,
        dataType: 'json',
        type: 'get',
        success: function (data){
            let html = '';
            for (let i = 0; i < data[0].object.length; i++) {
                html += '<tr>' +
                    '<td>' + data[0].object[i].id + '</td>' +
                    '<td>' + data[0].object[i].uid + '</td>' +
                    '<td>' + data[0].object[i].pwd + '</td>' +
                    '<td><a href="javascript:UserEdit(' + data[0].object[i].id + ')">编辑</a>  ' +
                    '<a href="javascript:UserDel(' + data[0].object[i].id + ')" >删除</a></td>' +
                    '</tr>';
            }
            $("#userData").html(html);
        },
        error: function (data) {

        }

    })
}
function UserEdit(id) {
    localStorage.setItem("userId", id);
    $('#backright').load('/front-wxjs/back/UserAdd.html');
    $.ajax({
        url: AURL+'/edit',
        data: {userId: id},
        type: 'post',
        dataType: 'json',
        success: function (data) {
            alert(data[0].result);
            $('#backright').load('/front-wxjs/back/UserSearch.html');
        }
    })
}

function UserDel(id) {
    $.ajax({
        url: '/del',
        data: {userId: id},
        type: 'post',
        dataType: 'json',
        success: function (data) {
            alert(data[0].result);
            $('#backright').load('/front-wxjs/back/UserSearch.html');
        }
    })
}