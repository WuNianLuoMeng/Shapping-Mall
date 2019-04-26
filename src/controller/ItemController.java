package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.EUResultData;
import pojo.TbItem;
import service.PagingFunction;

@Controller
public class ItemController {
	@Autowired
	private PagingFunction paging;

	@RequestMapping("/item/list")
	@ResponseBody
	public EUResultData GetRequestList(Integer page, Integer rows) throws Exception {
		EUResultData result = paging.getItemList(page, rows);
		// System.out.println(result.getTotal());
		return result;
	}

	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem GetTbItem(@PathVariable Long itemId) throws Exception {
		TbItem x = paging.getItem(itemId);

		return x;
	}

}
