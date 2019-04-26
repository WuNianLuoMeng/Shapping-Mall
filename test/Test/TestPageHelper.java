package Test;

import java.util.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import mapper.TbItemMapper;
import pojo.TbItem;
import pojo.TbItemExample;

public class TestPageHelper {
//	@Autowired
//	private TbItemMapper item;			
	@Test
	public void test() {
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext("classpath:/spring/spring-mybatis.xml");
		TbItemMapper item=applicationcontext.getBean(TbItemMapper.class);
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(0, 10);
		List<TbItem> list = item.selectByExample(example);
		for(TbItem x:list) {
			System.out.println(x.getTitle());
		}
		PageInfo<TbItem> Total = new PageInfo<>(list);
		System.out.println(Total.getTotal());
		
		
	}
}
