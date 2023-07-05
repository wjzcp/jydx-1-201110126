<%--
  Created by IntelliJ IDEA.
  User: record
  Date: 2023/7/4
  Time: 8:27
  To change this tsalarylate use File | Settings | File Tsalarylates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>薪资列表</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <script type="text/javascript"
            src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
    <link
            href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 搭建显示页面 -->
<div class="container">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <!-- 按钮 -->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary" id="salary_add_modal_btn">新增</button>
            <button class="btn btn-danger" id="salary_delete_all_btn">删除</button>
        </div>
    </div>
    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="salarys_table">
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" id="check_all"/>
                    </th>
                    <th>#</th>
                    <th>部门</th>
                    <th>员工</th>
                    <th>工资</th>
                    <th>奖金</th>
                    <th>是否发放</th>
                    <th>发放日期</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>

    <!-- 显示分页信息 -->
    <div class="row">
        <!--分页文字信息  -->
        <div class="col-md-6" id="page_info_area"></div>
        <!-- 分页条信息 -->
        <div class="col-md-6" id="page_nav_area">

        </div>
    </div>

</div>
<script type="text/javascript">

    var totalRecord,currentPage;
    //1、页面加载完成以后，直接去发送ajax请求,要到分页数据
    $(function(){
        //去首页
        to_page(1);
    });

    function to_page(pn){
        $.ajax({
            url:"${APP_PATH}/salarys",
            data:"pn="+pn,
            type:"GET",
            success:function(result){
                //console.log(result);
                //1、解析并显示员工数据
                build_salarys_table(result);
                //2、解析并显示分页信息
                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);
            }
        });
    }

    function build_salarys_table(result){
        //清空table表格
        $("#salarys_table tbody").empty();
        var salarys = result.extend.pageInfo.list;
        $.each(salarys,function(index,item){
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
            var IdTd = $("<td></td>").append(item.id);
            var deptNameNameTd = $("<td></td>").append(item.deptName);
            var empNameTd = $("<td></td>").append(item.empName);
            var jsalaryTd = $("<td></td>").append(item.jsalary);
            var jbonusTd = $("<td></td>").append(item.jbonus);
            var isgrantTd = $("<td></td>").append(item.isgrant);
            var grantdateTd = $("<td></td>").append(item.grantdate);
            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("发放");
            //为编辑按钮添加一个自定义的属性，来表示当前资金id
            editBtn.attr("edit-id",item.id);
            var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            //为删除按钮添加一个自定义的属性来表示当前删除的资金id
            delBtn.attr("del-id",item.id);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            //var delBtn =
            //append方法执行完成以后还是返回原来的元素
            $("<tr></tr>").append(checkBoxTd)
                .append(IdTd)
                .append(deptNameNameTd)
                .append(empNameTd)
                .append(jsalaryTd)
                .append(jbonusTd)
                .append(isgrantTd)
                .append(grantdateTd)
                .append(btnTd)
                .appendTo("#salarys_table tbody");
        });
    }
    //解析显示分页信息
    function build_page_info(result){
        $("#page_info_area").empty();
        $("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页,总"+
            result.extend.pageInfo.pages+"页,总"+
            result.extend.pageInfo.total+"条记录");
        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }
    //解析显示分页条，点击分页要能去下一页....
    function build_page_nav(result){
        //page_nav_area
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.extend.pageInfo.hasPreviousPage == false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为元素添加点击翻页的事件
            firstPageLi.click(function(){
                to_page(1);
            });
            prePageLi.click(function(){
                to_page(result.extend.pageInfo.pageNum -1);
            });
        }



        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.extend.pageInfo.hasNextPage == false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function(){
                to_page(result.extend.pageInfo.pageNum +1);
            });
            lastPageLi.click(function(){
                to_page(result.extend.pageInfo.pages);
            });
        }



        //添加首页和前一页 的提示
        ul.append(firstPageLi).append(prePageLi);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.extend.pageInfo.navigatepageNums,function(index,item){

            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if(result.extend.pageInfo.pageNum == item){
                numLi.addClass("active");
            }
            numLi.click(function(){
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nextPageLi).append(lastPageLi);

        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }

    //清空表单样式及内容
    function reset_form(ele){
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }


    //显示校验结果的提示信息
    function show_validate_msg(ele,status,msg){
        //清除当前元素的校验状态
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if("success"==status){
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }else if("error" == status){
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }
    }

    //点击保存，保存员工。
    $("#salary_save_btn").click(function(){
        //1、模态框中填写的表单数据提交给服务器进行保存
        //1、先对要提交给服务器的数据进行校验
        if(!validate_add_form()){
            return false;
        };
        //2、发送ajax请求保存员工
        $.ajax({
            url:"${APP_PATH}/salary",
            type:"POST",
            data:$("#salaryAddModal form").serialize(),
            success:function(result){
                //alert(result.msg);
                if(result.code == 100){
                    //员工保存成功；
                    //1、关闭模态框
                    $("#salaryAddModal").modal('hide');

                    //2、来到最后一页，显示刚才保存的数据
                    //发送ajax请求显示最后一页数据即可
                    to_page(totalRecord);
                }
            }
        });
    });

    function getsalary(id){
        $.ajax({
            url:"${APP_PATH}/salary/"+id,
            type:"GET",
            success:function(result){
                //console.log(result);
                var salaryData = result.extend.salary;
                $("#salaryName_update_static").text(salaryData.deptName);
            }
        });
    }

    //点击更新，更新员工信息
    $("#salary_update_btn").click(function(){
        //更新的资金数据
        $.ajax({
            url:"${APP_PATH}/salary/"+$(this).attr("edit-id"),
            type:"PUT",
            data:$("#salaryUpdateModal form").serialize(),
            success:function(result){
                //alert(result.msg);
                //1、关闭对话框
                $("#salaryUpdateModal").modal("hide");
                //2、回到本页面
                to_page(currentPage);
            }
        });
    });

    //发放工资
    $(document).on("click",".edit_btn",function(){
        //1、是否发放工资
        var salaryId = $(this).attr("edit-id");
        //alert($(this).parents("tr").find("td:eq(1)").text());
        if(confirm("确认发放？")){
            //确认，发送ajax请求删除即可
            $.ajax({
                url:"${APP_PATH}/salary/"+salaryId,
                type:"POST",
                success:function(result){
                    alert(result.msg);
                    //回到本页
                    to_page(currentPage);
                }
            });
        }
    });
    <%--//单个删除--%>
    <%--$(document).on("click",".delete_btn",function(){--%>
    <%--    //1、弹出是否确认删除对话框--%>
    <%--    var salaryName = $(this).parents("tr").find("td:eq(2)").text();--%>
    <%--    var salaryId = $(this).attr("del-id");--%>
    <%--    //alert($(this).parents("tr").find("td:eq(1)").text());--%>
    <%--    if(confirm("确认删除【"+salaryName+"】吗？")){--%>
    <%--        //确认，发送ajax请求删除即可--%>
    <%--        $.ajax({--%>
    <%--            url:"${APP_PATH}/salary/"+salaryId,--%>
    <%--            type:"DELETE",--%>
    <%--            success:function(result){--%>
    <%--                alert(result.msg);--%>
    <%--                //回到本页--%>
    <%--                to_page(currentPage);--%>
    <%--            }--%>
    <%--        });--%>
    <%--    }--%>
    <%--});--%>

    // //完成全选/全不选功能
    // $("#check_all").click(function(){
    //     //attr获取checked是undefined;
    //     //我们这些dom原生的属性；attr获取自定义属性的值；
    //     //prop修改和读取dom原生属性的值
    //     $(".check_item").prop("checked",$(this).prop("checked"));
    // });

    //check_item
    $(document).on("click",".check_item",function(){
        //判断当前选择中的元素是否5个
        var flag = $(".check_item:checked").length==$(".check_item").length;
        $("#check_all").prop("checked",flag);
    });

    <%--//点击全部删除，就批量删除--%>
    <%--$("#salary_delete_all_btn").click(function(){--%>
    <%--    var del_idstr = "";--%>
    <%--    $.each($(".check_item:checked"),function(){--%>
    <%--        //组装员工id字符串--%>
    <%--        del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";--%>
    <%--    });--%>
    <%--    //去除删除的id多余的---%>
    <%--    del_idstr = del_idstr.substring(0, del_idstr.length-1);--%>
    <%--    if(confirm("确认删除【"+salaryNames+"】吗？")){--%>
    <%--        //发送ajax请求删除--%>
    <%--        $.ajax({--%>
    <%--            url:"${APP_PATH}/salary/"+del_idstr,--%>
    <%--            type:"DELETE",--%>
    <%--            success:function(result){--%>
    <%--                alert(result.msg);--%>
    <%--                //回到当前页面--%>
    <%--                to_page(currentPage);--%>
    <%--            }--%>
    <%--        });--%>
    <%--    }--%>
    <%--});--%>
</script>
</body>
</html>
