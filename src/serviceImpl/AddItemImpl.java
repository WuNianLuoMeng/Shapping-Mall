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
* <p>Title: AddItemImpl.java<��p>
* <p>Description: ������Ʒ��Ϣ�Ŀ�����<��p>
* <p>Copyright: Copyright (c) 2007<��p>
* <p>Company: LTGames<��p>
* @author Ma
* @date 2019��4��26��
 */
@Service
public class AddItemImpl implements AddItem {
	@Autowired
	private TbItemCatMapper mapper;
	@Override
	public List<EUNode> GetAllNode(long id) throws Exception {
		
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		//������ѯ���ڵ���id������TbItemCat��¼������
		criteria.andParentIdEqualTo(id);
		
		List<TbItemCat> list = mapper.selectByExample(example);
		
		
		List<EUNode> result=new ArrayList<>();
		for(TbItemCat x:list) {
			EUNode node=new EUNode();
			node.setId(x.getId());
			node.setText(x.getName());
			//����Ǹ��ڵ㣬��Ϊclosed������Ϊopen
			node.setState(x.getIsParent()?"closed":"open");
			result.add(node);
		}		
		return result;
	}

}


