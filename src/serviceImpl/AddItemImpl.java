package serviceImpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.TbItemCatMapper;
import pojo.EUNode;
import pojo.TbItem;
import pojo.TbItemCat;
import pojo.TbItemCatExample;
import pojo.TbItemCatExample.Criteria;
import service.AddItem;
/**
 * 
* <p>Title: AddItemImpl.java<／p>
* <p>Description: 增加商品信息的控制器<／p>
* <p>Copyright: Copyright (c) 2007<／p>
* <p>Company: LTGames<／p>
* @author Ma
* @date 2019年4月26日
 */
@Service
public class AddItemImpl implements AddItem {
	@Autowired
	private TbItemCatMapper mapper;
	@Override
	public List<EUNode> GetAllNode(long id) throws Exception {
		
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		//创建查询父节点是id的所有TbItemCat记录的条件
		criteria.andParentIdEqualTo(id);
		
		List<TbItemCat> list = mapper.selectByExample(example);
		
		
		List<EUNode> result=new ArrayList<>();
		for(TbItemCat x:list) {
			EUNode node=new EUNode();
			node.setId(x.getId());
			node.setText(x.getName());
			//如果是父节点，则为closed，否则为open
			node.setState(x.getIsParent()?"closed":"open");
			result.add(node);
		}		
		return result;
	}

}


