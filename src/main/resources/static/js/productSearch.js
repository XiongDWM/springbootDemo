//var localObj = window.location;
//var contextPath = localObj.pathname.split("/")[1];
//var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
//var server_context=basePath;
let PURL="http://localhost:8080/wxjs";
$(function () {
    getProductData();
})

function getProductData() {
    $.ajax({
        url: PURL+'/productSearch',
        data: '',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            setProductData(data[0].object);
        }
    })
}

function setProductData(data) {
    let html = '';
    for (let i = 0; i < data.length; i++) {
        html += '<tr>' +
            '<td>' + data[i].id + '</td>' +
            '<td>' + data[i].infoText + '</td>' + 
            '<td>' + data[i].picUrl + '</td>' +
            '<td>' + data[i].price + '</td>' +
            '<td><a href="javascript:toProductEdit(' + data[i].id + ')">Edit</a>  ' +
            '<a href="javascript:UserDel(' + data[i].id + ')" >Delete</a></td>' +
            '</tr>';
    }
    $("#productData").html(html);
}

function toyProductEdit(id) {
    sessionStorage.setItem("pid", id);
    $('#backright').load('/back/UserAdd.html');
}