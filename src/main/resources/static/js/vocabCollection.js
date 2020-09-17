$(function () {
  findCollection();
})

function findCollection() {
    $.ajax({
        url: 'http://localhost:8180/api/vocab',
        data:'',
        dataType: 'json',
        type: 'get',
        success: function (data){
            let html = '';
            for (let i = 0; i < data.length; i++) {
                html += '<tr>' +
                    '<td>' + data[i] + '</td>' +
                    '</tr>';
             
            }
            $("#vcs").html(html);
        },

    })
}