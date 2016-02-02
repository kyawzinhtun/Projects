package org.amaris.persistence.cuttingManage;

import java.util.List;

import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.cuttingManage.CuttingMain;

public interface ICuttingDAOManager {
	public String selectMaxId();
	public void insertCuttingMain(CuttingMain cm);
	public List<CuttingMain> searchById(String key);
	public List<BalanceDetail> selectedByCuttingId(String key);
	public void deleteById(String cutId);
}
