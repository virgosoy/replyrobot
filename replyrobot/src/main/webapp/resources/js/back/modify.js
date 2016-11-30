
/**
 * 移除指定行
 * @param id
 * @returns
 */
function remove(dom){
	if(confirm("是否删除？")){
		var $a = $(dom);
		var $tr = $a.parents("tr");
		$tr.remove();
	}
}

/**
 * 添加行
 * @returns
 */
function add(dom){
	var $a = $(dom);
	var $lastDataTr = $a.parents("tr").prev();
	var html = "<tr>"+
			"	<td><input type='checkbox' /><input type='hidden' name='ccid' value='' /></td>"+
			"	<td>"+(parseInt($lastDataTr.children("td").eq(1).text(),10)+1)+"</td>"+
			"	<td><textarea cols='80' rows='5' style='resize:none;' name='content' ></textarea></td>"+
			"	<td>"+
			"		<a href='javascript:void(0);' onclick='remove(this);'>删 除</a>"+
			"	</td>"+
			"</tr>";
	$lastDataTr.after(html);
}