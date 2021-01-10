//var register=document.getElementById("register");
function  checkInput()  {
    //获取对象
    var userName=document.getElementById("username");
    var password=document.getElementById("password");
    var password2=document.getElementById("password2");
    //验证
    if(userName.value==""){
        alert("用户名不能为空");
        return false;
    }
    if(userName.value.length<6){
        alert("用户名长度至少需要6位");
        return false;
    }
    //可以使用正则表达式进行验证
    if(password.value==""){
        alert("密码不能为空");
        return false;
    }
    if(password.value.length<6){
        alert("密码长度至少需要6位");
        return false;
    }
    if(password.value!==password2.value){
        alert("两次密码不一致,请重新输入!");
        return false;
    }
    return true;
}