$(function () {
  findAll();
})

function findAll() {
    $.ajax({
        url: 'http://localhost:8180/api/alluser',
        data:'',
        dataType: 'json',
        type: 'get',
        success: function (data){
            let html = '';
            var item=data.detail;
            console.log(item);
            for (let i = 0; i < item.length; i++) {
                html += '<tr>' +
                    '<td>' + item[i].id + '</td>' +
                    '<td>' + item[i].uid + '</td>' +
                    '<td>' + item[i].upwd + '</td>' +
                    '<td>' + item[i].name + '</td>' +
                    '<td>' + item[i].phone + '</td>' +
                    '<td>' + item[i].address + '</td>' +
                    '<td>' + item[i].email + '</td>' +
                    '<td>' + item[i].activated + '</td>' +
                    '<td>' + item[i].authority[0].details + '</td>' +
                    '<td><a href="javascript:UserEdit(' + item[i].id + ')">编辑</a>  ' +
                    '<a href="javascript:UserDel(' + item[i].id + ')" >删除</a></td>' +
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