function index() {
    //js通过input的id属性，拿到前端页面输入的用户名，密码
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    //js前端向后端发送请求，同时把前端页面的用户名，密码拼接传给后端
    let called = new Promise(
        (a, b) => {
            const xhr = new XMLHttpRequest();
            xhr.open("POST", 'http://localhost:8000/login1' + username + '&password=' + password);
            xhr.onload = () => a(xhr.responseText);
            xhr.onerror = () => b(xhr);
            xhr.send();
        }
    );

    //js通过对后端返回的请求，解析拿到想要的数据
    called
        .then((e) => {
            console.log(e)
            let date = JSON.parse(e);
            document.getElementById('now').innerHTML = date.msg;
            alert(e)
        })
        .catch((e) => {
            console.log("失败了", e);
        })

}