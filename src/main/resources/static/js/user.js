
$(function () {
    getOptionList; 
})

function testify() {
    var username = document.getElementById('uid').value;
    var password = document.getElementById('pwd').value;
    var reg = /^[a-zA-Z]\w{2,15}$/;
    if (reg.test(username)) {
        document.getElementById('uidText').innerHTML = "用户名可用";
    } else {
        document.getElementById('uidText').innerHTML = "再来亿遍";
        document.getElementById('uid').focus();
        return false;
    }
    if (reg.test(password)) {
        $('#pwdtext').html("过");
    } else {
        $('#pwdtext').html("再来亿遍");
        $('#pwd').focus();
        return false;
    }
    	return true;
}

function getUserDataById() {
    // sessionStorage.getItem()
    let id = localStorage.getItem("userId");
    $.ajax({
        url: aURL+'/findUserById',
        data: {userId: id},
        type: 'get',
        dataType: 'json',
        success: function (data) {
            setUserData(data[0]);
        }
    })
    localStorage.setItem("userId", null);
}

function setUserData(data) {
    $("#id").val(data.id);
    $("#username").val(data.username);
    $("#password").val(data.password);
}


function save() {
    let data = {username: $("#uid").val(), 
    			password: $("#pwd").val()
    			
    
    
    };
    if (testify()) {
        $.ajax({
            url: '/api/userAdd',
            data: data,
            type: 'post',
            dataType: 'json',
            success: function (data) {
                alert(data[0].result);
                $('#backright').load('UserSearch.html');
            }
        })
    }
}

function getOptionList(){
	$.ajax({
		url:'/api/getoptions',
		type:'get',
		data:'',
		dataType:'json',
		
		success:function(data){
			var html='';
			 	for(let i = 0; i < data[0].data.length; i++){
			 	html+='<option value='+data[0].data[i].roles+'>'+data[0].data[i].details+'</option>'
			 	}
			 	$("#authorities").html(html);
			},
		})
}