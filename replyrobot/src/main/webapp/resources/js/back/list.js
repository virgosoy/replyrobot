
/**
 * 单条删除
 * @param id
 * @returns
 */
function deleteOne(contextPath,id){
	if(confirm("是否删除？")){
		var $form = $("#mainForm");
		$form.attr("action",contextPath+"/delete?id="+id);
		$form.submit();
	}
}

function deleteBatch(contextPath){
	if(confirm("是否批量删除？")){
		var $form = $("#mainForm");
		$form.attr("action",contextPath+"/delete");
		$form.submit();
	}
}