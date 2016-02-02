package org.amaris.service.cuttingManage;

import java.util.List;

import org.amaris.service.balanceManage.BalanceDetail;

public interface ICuttingServiceManager  {
	public String getLastGenId();
	public List<BalanceDetail> getDeatilByCutting(String cuttingId);
	public void insertCutting(CuttingMain cm);
	public List<CuttingMain> filterByKey(String id);
	public void deleteById(String cutId);
}
