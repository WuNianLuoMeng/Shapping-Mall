package service;

import pojo.EUResultData;
import pojo.TbItem;

public interface PagingFunction {
	EUResultData getItemList(int page, int rows);
	TbItem getItem(Long id) throws Exception;
}
