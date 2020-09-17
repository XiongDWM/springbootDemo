
$(function () {
    getOptionList(); 
})

function testify() {
    var username = document.getElementById('uid').value;
    var password = document.getElementById('upwd').value;
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
        $('#upwd').focus();
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
    let UserDto = {
    			id:$("#id").val(),
    			uid: $("#uid").val(), 
    			upwd: $("#upwd").val(),
    			name: $("#name").val(),
    			address:$("#address").val(),
    			phone:$("#phone").val(),
    			email:$("#email").val(),
    			authorities:$("#authorities").val(),
    			activated:$("#isActive").val()
    			
    };
    console.log(UserDto);
    if (testify()) {
        $.ajax({
            url: 'http://localhost:8180/api/register',
            data: JSON.stringify(UserDto),
            type: 'post',
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            
            success: function (data) {
            console.log(data);
            var message=data.msg;
                alert(message);
                $('#backright').load('UserSearch.html');
            }
        })
    }
}

function getOptionList(){
	$.ajax({
		url:'http://localhost:8180/api/getoptions',
		type:'get',
		data:'',
		dataType:'json',
		success:function(data){
			var item=data.detail;
			console.log(item);
			var html='';
			 	for(let i = 0; i < item.length; i++){
			 	html+='<option value='+ item[i].id +'>'+ item[i].details +'</option>'
			 	}
			 	$("#authorities").html(html);
			},
		})
}

function doLogin(){
	




}