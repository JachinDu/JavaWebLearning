<html>
<#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">
    <#--        边栏-->
    <#include "../common/nav_buyer.ftl">

    <#--        主要内容区域-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>商品ID</th>
                            <th>名称</th>
                            <th>单价</th>
                            <th>描述</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list productInfoList.content as productInfo>

                            <tr class="info">
                                <td>${productInfo.productId}</td>
                                <td>${productInfo.productName}</td>
                                <td>${productInfo.productPrice}</td>
                                <td>${productInfo.productDescription}</td>
                                <td><a href="/sell/seller/product/index?productId=${productInfo.productId}">加入购物车</a></td>
<#--                                <td>-->
<#--                                    <#if productInfo.getProductStatusEnum().message == "在架">-->
<#--                                        <a href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a>-->
<#--                                    <#else>-->
<#--                                        <a href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a>-->
<#--                                    </#if>-->
<#--                                </td>-->
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <#--            分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">

                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else>
                            <li><a href="/sell/buyer/product/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                        </#if>

                        <#list 1..productInfoList.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a> </li>
                            <#else>
                                <li><a href="/sell/buyer/product/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>

                        <#if currentPage gte productInfoList.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else>
                            <li><a href="/sell/buyer/product/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                        </#if>

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
