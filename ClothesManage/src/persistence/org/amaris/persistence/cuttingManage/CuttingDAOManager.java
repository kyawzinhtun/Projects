package org.amaris.persistence.cuttingManage;

import java.util.ArrayList;
import java.util.List;

import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.cuttingManage.CuttingMain;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "CuttingDAOManager")
public class CuttingDAOManager extends SqlMapClientDaoSupport implements ICuttingDAOManager {

	@Transactional(propagation=Propagation.REQUIRED)
	public String selectMaxId() {
		int id;
		try{
			id =  (int) getSqlMapClientTemplate().queryForObject("cuttingManager.selectMaxId");
			return id+"";
		} catch (DataAccessException de){
		   de.printStackTrace();
		   throw de;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void insertCuttingMain(CuttingMain cm) {
		try {
			getSqlMapClientTemplate().insert("cuttingManager.insertMain", cm);
			insertCutItemList(cm);
		}
		catch(DataAccessException de) {
			de.printStackTrace();
			throw de;
		}
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertCutItemList(CuttingMain cm) {
		List<BalanceDetail> cutBDList = cm.getCutBDList();
		try {
			for(BalanceDetail bd : cutBDList) {
			
				bd.setCuttingId(cm.getCuttingId());
				getSqlMapClientTemplate().insert("cuttingManager.cutDetail", bd);
			}
			updateMstItemList(cm);
		}
		catch(DataAccessException de) {
			de.printStackTrace();
			throw de;
		}

	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateMstItemList(CuttingMain cm) {
		List<BalanceDetail> mstDBList = cm.getMstBDList();
		for(BalanceDetail bd : mstDBList) {
			try {
				bd.setCuttingId(cm.getCuttingId());
				getSqlMapClientTemplate().insert("cuttingManager.masterUpdate", bd);
			}
			catch(DataAccessException de) {
				de.printStackTrace();
				throw de;
			}
		}
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public List<CuttingMain> searchById(String key) {
		List<CuttingMain> cuttingMainList = new ArrayList<CuttingMain>();
		try {
			cuttingMainList = getSqlMapClientTemplate().queryForList("cuttingManager.selectKey", key);
		}
		catch(DataAccessException de) {
			
		}
		return cuttingMainList;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<BalanceDetail> selectedByCuttingId(String key) {
		List<BalanceDetail> balanceDetailList = new ArrayList<BalanceDetail>();
		try {
			balanceDetailList = getSqlMapClientTemplate().queryForList("cuttingManager.selectbycuttingId", key);
			return balanceDetailList;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteById(String cutId) {
		// TODO Auto-generated method stub
		try {
		getSqlMapClientTemplate().delete("cuttingManager.deleteCuttingById", cutId);
		}
		catch(DataAccessException de) {
			de.printStackTrace();
			throw de;
		}
	}

}
