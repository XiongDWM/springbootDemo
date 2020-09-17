$(function () {
    findAll();
})

function findAll() {  
   $.ajax({
        url: 'http://localhost:8180/vcontent/findAll',
        data:'',
        dataType: 'json',
        type: 'get',
        success: function (data){
        	console.log(data);
        	var item=data.detail;
        	console.log(item);
            let html = '';
            for (let i = 0; i <item.length; i++) {
           		html += '<tr>' +
                    '<td>' + item[i].context + '</td>' +
                    '<td>' + item[i].translate + '</td>' +
                    '<td>' + item[i].isLike + '</td>' +
                    '<td><a href="javascript:toCollect(' + item[i].id + ')">收藏</a>  ' +
                    '<a href="javascript:toLike(' + item[i].id + ')" >点赞</a></td>' +
                    '</tr>';
            }
            $("#vcdata").html(html);
        },
    })
}
function toLike(id){
	$.ajax({
        url: 'http://localhost:8180/vcontent/likeThis',
        data: {vocabId: id},
        type: 'post',
        dataType: 'json',
        success: function () {
            $("#backright").load('http://localhost:8180/back/VocabSearch.html');
        }
    })
	
}