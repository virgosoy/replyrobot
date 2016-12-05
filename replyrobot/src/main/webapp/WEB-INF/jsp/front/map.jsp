<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />  
<title>百度地图 - 定位</title>
<style type="text/css">  
	html{height:100%}  
	body{height:100%;margin:0px;padding:0px}  
	#container{height:100%}  
</style>  
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZTIUVwG2UvNQvQD1lCtQBXhN3HzouPB3"></script>
</head>
<body>
	<div id="container"></div> 
	<script type="text/javascript"> 
		$(function(){
			/* $.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/json/myip",
				dataType:"text",
				success:function(data){
					$.ajax({
						type:"get",
						url:"http://api.map.baidu.com/highacciploc/v1?ak=ZTIUVwG2UvNQvQD1lCtQBXhN3HzouPB3&qterm=pc&callback_type=jsonp&coord=bd09ll&qcip="+data,
						dataType:"jsonp",
						success:function(data){
							var result = data.result.error;
							if(result==161){
								
							}else{
			                    alert('定位失败！&nbsp;&nbsp;' + result);
			                }
						},
						error: function(){
							alert('服务忙，请稍候再试！');
			            }
					})
				}
			}) */
		})
		var map = new BMap.Map("container");          // 创建地图实例  
		var point = new BMap.Point(116.404, 39.915);  // 创建点坐标  
		map.centerAndZoom(point, 13);                 // 初始化地图，设置中心点坐标和地图缩放级别
		/* var marker = new BMap.Marker(point);        // 创建标注    
		map.addOverlay(marker);                     // 将标注添加到地图中 */
		var geolocation = new BMap.Geolocation();
		geolocation.getCurrentPosition(function(result){
			if(this.getStatus() == BMAP_STATUS_SUCCESS){  
			    var mk = new BMap.Marker(result.point);//创建一个覆盖物  
			    map.addOverlay(mk);//增加一个标示到地图上  
			    map.panTo(result.point);  
			    /* latitude  = result.point.lat;//获取到的纬度  
			    longitude = result.point.lng;//获取到的经度   */
			}else{
				alert("定位失败！");
			}
		})
		
	</script>  
</body>
</html>