<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">


</HEAD>

<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/addEnterprise" method="post"
		enctype="multipart/form-data">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加企业信息</STRONG> </strong>
				</td>
			</tr>


			<tr>
				
				<td align="center" bgColor="#f5fafe" class="ta_01">企业名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="name" class="bg"/>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">企业电话：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="telephone" 
					class="bg" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">企业法人：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="corporate" 
					class="bg" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">企业属性：</td>
				<td class="ta_01" bgColor="#ffffff"><select name="category"
					id="category">
						<option value="" selected="selected">--选择企业属性--</option>
						<option value="电子商务">电子商务</option>
										<option value="游戏">游戏</option>
										<option value="媒体">媒体</option>
										<option value="广告营销">广告营销</option>
										<option value="信息安全">信息安全</option>
										<option value="智能硬件">智能硬件</option>
										<option value="互联网金融">互联网金融</option>
										<option value="在线教育">在线教育</option>
										<option value="医疗健康">医疗健康</option>
										<option value="生活服务">生活服务</option>
										<option value="计算机软件">计算机软件</option>
										<option value="工程施工">工程施工</option>
										<option value="物流/仓储">物流/仓储</option>
										<option value="旅游">旅游</option>
				</select>
				</td>
			</tr>


			<tr>
			</tr>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">企业描述：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
				<textarea
						name="description" cols="30" rows="3" 
						style="WIDTH: 96%"></textarea>
				</TD>
			</TR>
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</TR>


			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					
					
						
					<input type="submit" class="button_ok" value="确定">	
						
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					
					
					
					<input type="reset" value="重置" class="button_cancel">

					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1">
					
					</span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>