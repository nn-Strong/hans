<div class="login-box-body" style="margin-top: 8%;margin-left: 33%;">
    <p class="login-box-msg">你千万不要见怪，城市是一个几百万人一起孤独生活的地方。前台/后台</p>
    <form action="/qt/loginValid" method="post">
        <div class="form-group has-feedback">
            <input type="phone" class="form-control" placeholder="请输入手机号" name="phone">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input type="password" class="form-control" placeholder="请输入密码" name="upwd">
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
                <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
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
</style>
