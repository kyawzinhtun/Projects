package org.amaris.service.balanceManage;

import java.util.List;

public interface IBalanceServiceManager {
	public void addStock(StockBalance stockBalance);
	public void addDesDetail(StockBalance stockBalance);
	public void deleteStock(String stockInId);
	public List<StockBalance> searchByFilter(String stockInId);
	public List<BalanceDetail> searchBalanceDetailByFilter(String stockInId);
	public void editStock(StockBalance stockBalance);
	public List<StockBalance> searchAll();
	public String getLastGenId();
	public List<StockBalance> searchByNameFilter(String name);
}
