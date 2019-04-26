package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import mapper.TbItemMapper;
import pojo.EUResultData;
import pojo.TbItem;
import pojo.TbItemExample;
import service.*;
import serviceImpl.PagingFunctionImpl;
@Controller

public class PageController {


	@RequestMapping("/")
	public String index() throws Exception {		
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		return page;
	}
	
	
}
