<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>bookStore首页</title>
<%--导入css --%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>

<body class="main">

	<%@include file="head.jsp"%>
	<%@include file="menu_search.jsp" %>
	

	<div id="divcontent">
		<table width="900px" border="0" cellspacing="0">
			<tr>
				<td width="497"><img src="images/billboard.gif" width="497"
					height="38" />
					<table cellspacing="0" class="ctl">
						<tr>
							<td>&middot;<a href="news.html" style="color:#000000">最新就业信息</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color:#000000">
									每一家企业都经过审核</a></td>
						</tr>
						<tr>
							<td>&middot;<a href="news.html" style="color:#000000">企业根据行业分类，满足您的需求</a></td>
						</tr>
						
					</table></td>
				<td style="padding:5px 15px 10px 40px"><table width="100%"
						border="0" cellspacing="0">
						<tr>
							<td> <b>本周热门企业</b>
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="0">
						<tr>
							<td style="width:50; text-align:center"><a href="info.html"><img
									src="images/alibaba.png" width="102" height="130"
									border="0" /> </a><br /> <a href="info.html">Alibaba<br />
									</a></td>
							<td style="width:50; text-align:center"><a href="info.html"><img
									src="images/google.png" width="102" height="130" border="0" />
							</a><br /> <a href="info.html">google <br /> </a>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp"/>


</body>
</html>
