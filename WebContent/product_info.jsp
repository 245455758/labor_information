<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>劳务信息管理系统</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />


	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>





					<table cellspacing="0" class="infocontent">
						<tr>
							<td>

								<table width="100%%" border="0" cellspacing="0">
									<tr>
										<td width="30%">

											<div class="divbookcover">
												<p>
													<img src="enterprise/${e.img_url }" width="213" height="269" border="0" />
												</p>
											</div>

											<div style="text-align:center; margin-top:25px">
												<a href="${pageContext.request.contextPath }/findJobInfo?id=${e.id}"> <img src="images/buybutton.png" border="0" />
												</a>
											</div>
										</td>
										<td style="padding:20px 5px 5px 5px"><img
											src="images/miniicon3.gif" width="16" height="13" /><font
											class="bookname">&nbsp;&nbsp;${e.name }</font>

											<hr />性质：<font color="#FF0000">:${e.nature }</font>
											<hr /> 法人：${e.corporate }
											<hr /> 电话：${e.telephone }

											<hr />
											<p>
												<b>内容简介：</b>
											</p>${e.introduce }</td>
											
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
