<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/admin/css/left.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	<link rel="StyleSheet" href="${pageContext.request.contextPath}/admin/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/dtree.js"></script>
	<script type="text/javascript">
		<!--
		d = new dTree('d');
		d.add(0,-1,'系统菜单树');
		d.add(1,0,'企业管理','/laborInformation/admin/login/welcome.jsp','','mainFrame');
		d.add(2,0,'劳工管理','/laborInformation/admin/login/welcome.jsp','','mainFrame');
		d.add(3,0,'招聘信息管理','/laborInformation/admin/login/welcome.jsp','','mainFrame');
		d.add(4,0,'务工信息管理','/laborInformation/admin/login/welcome.jsp','','mainFrame');
		
		
		//子目录添加
		d.add(11,1,'企业查看','${pageContext.request.contextPath}/findEnterprise','','mainFrame');
		
		
		d.add(21,2,'劳工查看','${pageContext.request.contextPath}/findLabors','','mainFrame');
		d.add(31,3,'招聘信息查看','/laborInformation/admin/orders/list.jsp','','mainFrame');
		d.add(41,4,'务工信息查看','/laborInformation/admin/orders/list.jsp','','mainFrame');
	
		
		document.write(d);
		//-->
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
