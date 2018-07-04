<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my.js">
	
</script>
<script type="text/javascript">
<!--
	function fillNameValue(subDiv) {
		document.getElementById("name").value = subDiv.innerHTML;
		
		document.getElementById("content").style.display="none";
	}

	function searchName() {
		var nameElement = document.getElementById("name");
		//获取输入的信息
		var nameValue = nameElement.value;

		var div = document.getElementById("content");
		div.innerHTML = "";
		//1.获取XMLHttpRequest对象
		var xmlhttp = getXMLHttpRequest();

		//2.绑定回调函数
		xmlhttp.onreadystatechange = function() {

			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

				var jsonObj = eval("(" + xmlhttp.responseText + ")");
				
				if(jsonObj.length>0){
					document.getElementById("content").style.display="block";
					for ( var i = 0; i < jsonObj.length; i++) {
						div.innerHTML += "<div onclick='fillNameValue(this)' onmouseover='changeBackground_over(this)' onmouseout='changeBackground_out(this)'>"
								+ jsonObj[i] + "</div>"
					}
				}

			}
		};
		//3.open
		xmlhttp.open("GET",
				"${pageContext.request.contextPath}/findProductName?name="
						+ window.encodeURIComponent(nameValue, "utf-8")
						+ "&time=" + new Date().getTime());
		//4.send
		xmlhttp.send(null);
	};
	
	function changeBackground_over(div){
		div.style.background="gray";
	}
	
	function changeBackground_out(div){
		div.style.background="white";
	}
//-->
</script>

<div id="divmenu">
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=电子商务">电子商务</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=游戏">游戏</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=媒体">媒体</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=广告营销">广告营销</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=信息安全">信息安全</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=智能硬件">智能硬件</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=互联网金融">互联网金融</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=在线教育">在线教育</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=医疗健康">医疗健康</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=生活服务">生活服务</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=计算机软件">计算机软件</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=工程施工">工程施工</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=物流/仓储">物流/仓储</a>
	<a
		href="${pageContext.request.contextPath}/pageServlet?category=旅游">旅游</a>
	<a href="${pageContext.request.contextPath}/pageServlet"
		style="color:#FFFF00">全部企业目录</a>
</div>
<div id="divsearch">
	<form action="${pageContext.request.contextPath}/findEnterpriseBySearch"
		method="post">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td style="text-align:right; padding-right:220px">
				Search <input
					type="text" name="name" class="inputtable" onkeyup="searchName();"
					id="name" /> 
					<input type="image" src="images/serchbutton.gif"
					border="0" style="margin-bottom:-4px">
				</td>
			</tr>
		</table>

	</form>
</div>
<div id="content"
	style="background-color:white;width:128px; text-align:left;margin-left:945px;color:black;float:left;margin-top: -20px;display: none">
</div>