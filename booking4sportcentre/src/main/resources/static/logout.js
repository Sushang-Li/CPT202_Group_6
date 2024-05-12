    //登出
    // 监听登出链接的点击事件
    document.getElementById("logout-nav").addEventListener("click", function(event) {
        event.preventDefault(); // 阻止默认行为，即跳转到 href 指定的页面

        // 发送登出请求到后端
        fetch('/logout', {
            method: 'POST', 
            credentials: 'same-origin' // 发送凭证信息
        })
        .then(response => {
            if (response.ok) {
                // 登出成功，执行相应的页面跳转
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