    //登出
    // 监听登出链接的点击事件
    document.getElementById("logout-nav").addEventListener("click", function(event) {
        event.preventDefault(); // 阻止默认行为，即跳转到 href 指定的页面

        // 发送登出请求到后端
        fetch('/logout', {
            method: 'POST', // 或者使用其他适合的 HTTP 方法，例如 GET 或 DELETE
            credentials: 'same-origin' // 发送凭证信息，例如 cookie，以便后端识别用户
        })
        .then(response => {
            if (response.ok) {
                // 登出成功，执行相应的页面跳转或其他操作
                window.location.href = 'index.html'; // 跳转到指定页面
            } else {
                // 登出失败，处理错误
                console.error('Logout failed:', response.statusText);
            }
        })
        .catch(error => {
            console.error('Error during logout:', error);
        });
    });