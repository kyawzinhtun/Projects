package org.amaris.persistence.balanceManage;

import java.util.List;

import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.balanceManage.StockBalance;

public interface IBalanceDAOManager {

	public void insertStock(StockBalance stockBalance);
	public List<StockBalance> selectByFilter(String itemId);
	public void upDateStock(StockBalance stockBalance);
	public void deleteStock(String stockInId);
	public List<StockBalance> selectAll();
	public List<BalanceDetail> selectBalanceDetailByFilter(String stockInId);
	public List<StockBalance> selectBalanceDetailByNameFilter(String name);
	public String selectMaxId();
	
}
