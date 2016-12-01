package com.soy.replyrobot.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soy.replyrobot.model.Command;
import com.soy.replyrobot.model.CommandContent;
import com.soy.replyrobot.service.CommandService;

@Controller
public class BackController {

	@Autowired
	private CommandService commandService;
	
	@RequestMapping("/list")
	public String list(Model model,Command command){
		List<Command> commandList = commandService.queryCommandList(command);
		model.addAttribute("commandList", commandList);
		return "back/list";
	}
	
	@RequestMapping("/addPage")
	public String addPage(){
		return "back/add";
	}
	
	@RequestMapping("/add")
	public String add(Command command){
		commandService.addCommand(command);
		return "redirect:/list"; 
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Integer[] ids){
		commandService.delete(ids);
		return "redirect:/list";
	}
	
	/**
	 * <p>修改页</p>
	 * @author zhengsiyou
	 * @param id
	 * @return 
	 */
	@RequestMapping(value="/modityPage",params="id")
	public String modifyPage(Integer id,Model model){
		Command command = commandService.queryFullCommandById(id);
		model.addAttribute("command",command);
		return "back/modify";
	}
	
	/**
	 * <p>修改操作</p>
	 * @author zhengsiyou
	 * @return 
	 */
	@RequestMapping("/update")
	public String update(Command command,@RequestParam(value="ccid",required=false) Integer[] contentIds,@RequestParam(value="content",required=false) String[] contents){
		
		List<CommandContent> contentList = new ArrayList<>();
		
		if(contentIds!=null && contents!=null){
			//如果页面传递过来只有一个相同的name切value=""，那么数组的length==0。
			if(contentIds.length==0){
				contentIds = new Integer[]{null};
			}
			if(contents.length==0){
				contents = new String[]{""};
			}
			//封装数据
			CommandContent content = null;
			for (int i = 0; i<contentIds.length; i++) {
				content = new CommandContent();
				content.setId(contentIds[i]);
				content.setCommandId(command.getId());
				content.setContent(contents[i]);
				contentList.add(content);
				System.out.println(content.getId()+":"+content.getContent());
			}
		}
		
		command.setContentList(contentList);
		//进行更新
		commandService.updateFullCommand(command);
		return "redirect:/list";
	}
}
