<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--        边栏-->
    <#include "../common/nav.ftl">

    <#--        主要内容区域-->
    <div id="page-content-wrapper">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <#list productInfoList.content as productInfo>
                    <div class="row">
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <img alt="300x200" src="http://cdn.ibootstrap.cn/lorempixel.com/600/200/people/default.jpg" />
                                <div class="caption">
                                    <h3>
                                        ${productInfo.productName}
                                    </h3>
                                    <p>
                                        ${productInfo.productDescription}
                                    </p>
                                    <p>
                                        <a class="btn btn-primary" href="#">加入购物车</a> <a class="btn" href="#">移出购物车</a>
                                    </p>
                                </div>
                            </div>
                        </div>
        <#--                <div class="col-md-4">-->
        <#--                    <div class="thumbnail">-->
        <#--                        <img alt="300x200" src="http://cdn.ibootstrap.cn/lorempixel.com/600/200/city/default.jpg" />-->
        <#--                        <div class="caption">-->
        <#--                            <h3>-->
        <#--                                Thumbnail label-->
        <#--                            </h3>-->
        <#--                            <p>-->
        <#--                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.-->
        <#--                            </p>-->
        <#--                            <p>-->
        <#--                                <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>-->
        <#--                            </p>-->
        <#--                        </div>-->
        <#--                    </div>-->
        <#--                </div>-->
        <#--                <div class="col-md-4">-->
        <#--                    <div class="thumbnail">-->
        <#--                        <img alt="300x200" src="http://cdn.ibootstrap.cn/lorempixel.com/600/200/sports/default.jpg" />-->
        <#--                        <div class="caption">-->
        <#--                            <h3>-->
        <#--                                Thumbnail label-->
        <#--                            </h3>-->
        <#--                            <p>-->
        <#--                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.-->
        <#--                            </p>-->
        <#--                            <p>-->
        <#--                                <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>-->
        <#--                            </p>-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </#list>
            <button type="button" class="btn btn-default btn-block">按钮</button>
            <ul class="pagination pagination-sm">
                <li>
                    <a href="#">Prev</a>
                </li>
                <li>
                    <a href="#">1</a>
                </li>
                <li>
                    <a href="#">2</a>
                </li>
                <li>
                    <a href="#">3</a>
                </li>
                <li>
                    <a href="#">4</a>
                </li>
                <li>
                    <a href="#">5</a>
                </li>
                <li>
                    <a href="#">Next</a>
                </li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>