package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.EUNode;
import service.AddItem;

@Controller
@RequestMapping("/item/cat")

public class AddItemController {
	@Autowired
	private AddItem additem;

	@RequestMapping(value = "/list",method = RequestMethod.POST)
	@ResponseBody
	private List<EUNode> getCatList(@RequestParam(value="id",defaultValue="0")Long parentId) throws Exception {
		System.out.println(parentId);
		List<EUNode> list = additem.GetAllNode(parentId);
		return list;
	}
}
