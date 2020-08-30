案例：
文件下载需求：
    1.  页面显示超链接
    2.  点击超链接后弹出下载提示框
    3.  完成图片的下载

分析：
    1.  超链接指向的资源如果能够直接被浏览器解析，则在浏览器中展示，如果不能解析，则弹出下载提示框，
        如：<a href="web_project_1/1.jap">图片</a>，这种图片文件可以直接打开不会出现下载提示框
            <a href="web_project_1/1.avi">视频</a>，这种视频文件就会提示下载
    2.  现在需要无论超链接指向的资源能否被浏览器解析都要弹出下载提示框
    3.  使用响应头设置资源的打开方式：
            content-disposition:attachment;filename-xxx

    步骤：
        1.  定义页面，编辑超链接的href属性指向Servlet，传递文件名称filename参数
        2.  定义Servlet
            1.  获取文件名称。
            2.  使用字节输入流加载文件进内存
            3.  指定response的响应头：content-disposition:attachment;filename-xxx
            4.  将数据写到response输出流

问题：
中文文件名乱码问题：
1.  获取客户端使用的浏览器的版本信息
2.  根据不同的版本信息，设置不同的filename的编码方式不同