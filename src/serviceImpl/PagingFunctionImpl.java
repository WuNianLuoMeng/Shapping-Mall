package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import mapper.TbItemMapper;
import pojo.EUResultData;
import pojo.TbItem;
import pojo.TbItemExample;
import service.PagingFunction;
@Service
public class PagingFunctionImpl implements PagingFunction {

	@Autowired
	private TbItemMapper mapper;

	@Override
	public EUResultData getItemList(int page, int rows) {
		//查询商品列表
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> list = mapper.selectByExample(example);
		//创建一个返回值对象
		EUResultData result = new EUResultData();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TbItem getItem(Long id) throws Exception {
		TbItem x = mapper.selectByPrimaryKey(id);
		return x;
	}

	

}
