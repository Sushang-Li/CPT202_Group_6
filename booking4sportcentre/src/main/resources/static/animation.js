/* 侧边栏点击 */
$(document).ready(function() {
    $('#a2').click(function(event) {
        event.preventDefault();  // 阻止链接默认动作
        var submenu = $(this).next('ul');  // 使用 jQuery 获取<a>标签后面的<ul>元素
        var chevronIcon = $('#chevron');  // 使用 jQuery 直接定位到图标元素
        
        chevronIcon.fadeOut(200, function() {  // 先淡出图标
            if (submenu.is(':visible')) {
                submenu.fadeOut(200, function() {  // 淡出子菜单
                    chevronIcon.removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-right');
                    submenu.hide(); // 完全隐藏子菜单
                    chevronIcon.fadeIn(300); // 淡入更新后的图标
                });
            } else {
                submenu.fadeIn(200, function() {  // 淡入子菜单
                    chevronIcon.removeClass('glyphicon-chevron-right').addClass('glyphicon-chevron-down');
                    submenu.show(); // 完全显示子菜单
                    chevronIcon.fadeIn(200); // 淡入更新后的图标
                });
            }
        });
    });
});
//图标旋转
$(document).ready(function() {
    setInterval(function() {
        var globeIcon = $('.glyphicon-globe'); // 定位到图标元素
        globeIcon.addClass('rotate-animation'); // 添加动画类
        // 确保动画可以重复执行
        globeIcon.on('animationend', function() {
            globeIcon.removeClass('rotate-animation');
        });
    }, 3000); // 每3秒执行一次
});