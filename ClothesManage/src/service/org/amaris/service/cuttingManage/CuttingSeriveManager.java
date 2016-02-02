package org.amaris.service.cuttingManage;

import java.util.List;

import javax.annotation.Resource;

import org.amaris.persistence.balanceManage.IBalanceDAOManager;
import org.amaris.persistence.cuttingManage.ICuttingDAOManager;
import org.amaris.service.balanceManage.BalanceDetail;
import org.springframework.stereotype.Service;

@Service(value="CuttingSeriveManager")
public class CuttingSeriveManager implements ICuttingServiceManager {
	
	@Resource(name = "CuttingDAOManager")
	ICuttingDAOManager iCuttingDAOManager;

	public String getLastGenId() {
		return iCuttingDAOManager.selectMaxId();
	}


	public void insertCutting(CuttingMain cm) {
		try {
			iCuttingDAOManager.insertCuttingMain(cm);
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}


	
	public List<CuttingMain> filterByKey(String id) {
		try {
			List<CuttingMain> cmList = iCuttingDAOManager.searchById(id);
			return cmList;
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	@Override
	public List<BalanceDetail> getDeatilByCutting(String cuttingId) {
		try {
			List<BalanceDetail> bdList = iCuttingDAOManager.selectedByCuttingId(cuttingId);
			return bdList;
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	@Override
	public void deleteById(String cutId) {
		// TODO Auto-generated method stub
		try {
			iCuttingDAOManager.deleteById(cutId);
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}


	
}
