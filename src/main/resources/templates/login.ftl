<div class="login-box-body" style="margin-top: 8%;margin-left: 33%;">
    <p class="login-box-msg">你千万不要见怪，城市是一个几百万人一起孤独生活的地方。前台/后台</p>
    <form action="/qt/loginValid" method="post">
        <div class="form-group has-feedback">
            <input type="phone" class="form-control"  style="background-color: transparent;" placeholder="请输入手机号" name="phone">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input type="password" class="form-control" style="background-color: transparent;margin-top: 5px;" placeholder="请输入密码" name="upwd">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="row">
            <div class="col-xs-8">
                <div class="checkbox icheck">
                    <label>
                        <input type="checkbox" name="rememberMe"> 记住账户
                    </label>
                </div>
            </div>
            <!-- /.col -->
            <div class="col-xs-4">
                <button type="submit" class="login-button btn btn-primary btn-block btn-flat">登录</button>
                <p style="color: red">${result!}</p>
                ${msg!}
            </div>
            <!-- /.col -->
        </div>
    </form>
    <!-- /.social-auth-links -->
    <a href="#">忘记密码？</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/register" class="text-center">注册</a>
</div>
<!-- /.login-box-body -->
</div>
<style type="text/css">
    body{
       /* background-image: url('static-hans/qt/images/bg-test.jpg');
        background-color: #000000; #fff176*/
        background: url('/static-hans/qt/images/bg-test.jpg') no-repeat left top;
        background-size:100%;
    }
    .login-button { /* 按钮美化 */
        margin-top: 3px;
        width: 50px; /* 宽度 */
        height: 20px; /* 高度 */
        border-width: 0px; /* 边框宽度 */
        border-radius: 3px; /* 边框半径 */
        background: #1E90FF; /* 背景颜色 */
        cursor: pointer; /* 鼠标移入按钮范围时出现手势 */
        outline: none; /* 不显示轮廓线 */
        font-family: Microsoft YaHei; /* 设置字体 */
        color: white; /* 字体颜色 */
        font-size: 14px; /* 字体大小 */
    }
    .login-button:hover { /* 鼠标移入按钮范围时改变颜色 */
        background: #5599FF;
    }
</style>
