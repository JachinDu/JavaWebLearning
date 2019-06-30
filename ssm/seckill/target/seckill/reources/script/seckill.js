//存放主要交互逻辑js代码

//javascript 模块化
//
var  seckill = {
    //封装秒杀相关ajax的url
    URL: {
        now : function () {
            return '/uestc/seckill/time/now';
        },
        exposer : function (seckillId) {
            return '/uestc/seckill/' + seckillId + '/exposer';
        },
        execution : function (seckillId,md5) {
            return '/uestc/seckill/'+seckillId+'/'+md5+'/execution';
        }
    },


    //处理秒杀逻辑
    handleSeckillKill: function (seckillId,node) {
        //获取秒杀地址，控制显示逻辑，执行秒杀
        //所有控制节点，都要在内容处理前先隐藏一下
        node.hide()
            .html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>')
        $.post(seckill.URL.exposer(seckillId),{},function (result) {
            //回调函数中执行交互流程
            if (result && result['success']) {
                var exposer = result['data'];
                if (exposer['exposed']) {
                    //开启秒杀
                    //获取秒杀地址
                    var md5 = exposer['md5'];
                    var killUrl = seckill.URL.execution(seckillId, md5);
                    // console.log("killUrl:" + killUrl);

                    //注册秒杀事件（按钮）
                    //one来绑定一次点击事件，防止多次点击
                    $('#killBtn').one('click',function () {
                        console.log("000000000000:");

                        //执行秒杀请求
                        //1.先禁用按钮,灰色，也是提示用户只能点击一次
                        $(this).addClass('disabled');
                        //2.发送秒杀请求

                        $.post(killUrl,{},function (result) {


                            if (result && result['success']) {

                                var killResult = result['data'];
                                var state = killResult['state'];
                                var stateInfo = killResult['stateInfo'];
                                //3.显示秒杀结果
                                node.html('<span class="label label-success">'+stateInfo+'</span>');
                            }
                        });
                    });

                    //show出节点（按钮在节点内部）
                    node.show();

                } else {
                    //未开启秒杀
                    var now = exposer['now'];
                    var start = exposer['start'];
                    var end = exposer['end'];
                    //重新进入计时逻辑
                    seckill.SeckillCountdown(seckillId, now, start, end);
                }
            } else {
                console.log('result: ' + result);
            }
        })
    },


    //验证手机号逻辑
    validatePhone: function (phone) {
        //判断（存在 且 长度11 且 是数字
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;
        } else {
            return false;
        }
    },

    //时间判断逻辑
    SeckillCountdown: function (seckillId, nowTime, startTime, endTime) {

        var seckillBox = $('#seckill-box');
        //时间判断
        if (nowTime > endTime) {
            //秒杀结束
            seckillBox.html("秒杀结束！");
        }else if (nowTime < startTime) {
            //秒杀未开始
            //计时,加1000ms防止时间偏移
            var killTime = new Date(startTime + 1000);
            seckillBox.countdown(killTime,function (event) {
                //回调函数，每次时间变化会调用
                //时间格式
                var format = event.strftime('秒杀计时：%D天 %H时 %m分 %S秒');
                seckillBox.html(format);
                // $(this).text(event.strftime('秒杀计时：%D天 %H时 %m分 %S秒'));
            }).on('finish.countdown',function () {
                //时间完成后回调事件
                //获取秒杀地址，控制显示逻辑，执行秒杀
                seckill.handleSeckillKill(seckillId,seckillBox);
            });
        } else {
            //秒杀开始
            seckill.handleSeckillKill(seckillId,seckillBox);
        }
    },


    //详情页秒杀逻辑
    detail: {
        //详情页初始化
        init : function (params) {
            //用户手机验证和登录，计时交互
           //在cookie中国查找手机号
            var killPhone = $.cookie('killPhone');


            //验证手机号
            if (!seckill.validatePhone(killPhone)) {
                //绑定phone
                //控制输出
                console.log("333333:");

                var  killPhoneModal = $('#killPhoneModal');
                // killPhoneModal.modal('show');
                //显示弹出层
                killPhoneModal.modal({
                    show:true,//显示弹出层
                    backdrop:'static', //禁止位置关闭
                    keyboard:false //关闭键盘事件
                });


                $('#killPhoneBtn').click(function(){
                    var inputPhone = $('#killPhoneKey').val();
                    if (seckill.validatePhone(inputPhone)) {

                        //电话写入cookie,7天，仅在/seckill下有效
                        $.cookie('killPhone', inputPhone, {expires: 7, path: '/uestc/seckill'});

                        //刷新页面
                        window.location.reload();

                    } else {
                        //先隐藏，然后填内容，然后再show出来
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误！</label>').show(300);
                    }
                });
            }


            //已经登录
            // 计时交互
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['seckillId'];
            $.get(seckill.URL.now(),{},function (result) {
                if (result && result['success']) {
                    var nowTime = result['data'];
                    //时间判断
                     seckill.SeckillCountdown(seckillId, nowTime, startTime, endTime);
                } else {
                    console.log('result: ' + result);
                }
            });
        }
    }
}