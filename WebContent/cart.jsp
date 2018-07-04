<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />

<script type="text/javascript">
	function changeNum(id,num,totalCount){
		num = parseInt(num);
		totalCount =parseInt(totalCount);
		
		if(num<1){
			if(confirm("是否确认要删除此商品？")){
				num = 0;
			}else{
				num=1;
			}
		}
		
		if(num>totalCount){
			alert("购买数量不能大于库存数量！");
			num=totalCount;
		}
		location.href="${pageContext.request.contextPath}/changeNumServlet?id="+id+"&num="+num;
	}
</script>

</head>

<body class="main">

	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />


	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.html">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>

					<table cellspacing="0" class="infocontent">
						<tr>
							<td><img src="ad/page_ad.png" width="666" height="89" />
								<table width="100%" border="0" cellspacing="0">
									<tr>
									<!-- 	<td><img src="images/buy1.gif" width="635" height="38" />
										</td> -->
									</tr>
									<tr>
										<td>
											<table cellspacing="1" class="carttable">
												<tr>
													<td width="10%">序号</td>
													<td width="10%">企业名称</td>
													<td width="20%">要求的技能</td>
													<td width="10%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;招聘数量</td>
													<td width="20%">要求</td>
													<td width="10%">薪酬</td>
													<td width="10%">联系电话</td>
												</tr>
											</table> 
									<c:set var="sum" value="0" > </c:set>
											<c:forEach items="${l }" var="entry" varStatus="vs">
												<table width="100%" border="0" cellspacing="0">
													<tr>
														<td width="10%">${vs.count }</td>
														<td width="10%">${entry.enterprise_name }</td>

														<td width="20%">${entry.skill_need }</td>
														<td width="10%">${entry.peo_num }</td>
														<td width="20%">${entry.claim }</td>
														<td width="10%">${entry.wage }</td>

														<td width="10%">${entry.telephone }</td>

													</tr>
												</table>
											</c:forEach>

											<table cellspacing="1" class="carttable">
												<tr>
													
												</tr>
											</table>
										<!-- 	<div style="text-align:right; margin-top:10px">
												<a
													href="${pageContext.request.contextPath}/showProductByPage"><img
													src="images/gwc_jx.gif" border="0" /> </a>

												&nbsp;&nbsp;&nbsp;&nbsp;<a
													href="${pageContext.request.contextPath}/order.jsp"><img
													src="images/gwc_buy.gif" border="0" /> </a>
											</div> -->
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
