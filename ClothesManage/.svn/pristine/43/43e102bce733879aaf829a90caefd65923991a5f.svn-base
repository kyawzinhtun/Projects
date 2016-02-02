package org.amaris.service.balanceManage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.amaris.persistence.balanceManage.IBalanceDAOManager;
import org.amaris.persistence.inventoryManage.IInventoryPersistenceManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service(value="BalanceServiceManager")
public class BalanceServiceManager implements IBalanceServiceManager {

	@Resource(name = "BalanceDAOManager")
	IBalanceDAOManager iBalanceDAOManager;

	@Transactional(propagation=Propagation.REQUIRED)
	public void addStock(StockBalance stockBalance) {
		try {
			//iBalanceDAOManager.insertStock(stockBalance);
			System.out.println(stockBalance.getStockInId());
			System.out.println(stockBalance.getStockName());
			System.out.println(stockBalance.getStockInDate());
			System.out.println(stockBalance.getUnit());
			for(BalanceDetail bd : stockBalance.getBalanceDetail()) {
				System.out.println("stock price " + bd.getStockPrice());
				System.out.println("stock quantity " + bd.getStockQuantity());
				System.out.println("stock totalPrice " + bd.getTotalPrice());
				System.out.println("stock detail Unit " + bd.getDetailUnitCount());
			}
			iBalanceDAOManager.insertStock(stockBalance);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<StockBalance> searchByFilter(String searchKey) {
		List<StockBalance> resultList = new ArrayList<StockBalance>();
		try {
			resultList = iBalanceDAOManager.selectByFilter(searchKey);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public void editStock(StockBalance stockBalance) {
		try {
			iBalanceDAOManager.upDateStock(stockBalance);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void addDesDetail(StockBalance stockBalance) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteStock(String stockInId) {
		try {
			iBalanceDAOManager.deleteStock(stockInId);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<StockBalance> searchAll() {
		try {
			List<StockBalance> stockBalanceList = new ArrayList<StockBalance>();
			stockBalanceList = iBalanceDAOManager.selectAll();
			return stockBalanceList;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<BalanceDetail> searchBalanceDetailByFilter(String stockInId) {
		List<BalanceDetail> resultList = iBalanceDAOManager.selectBalanceDetailByFilter(stockInId);
		return resultList;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public String getLastGenId() {
		return iBalanceDAOManager.selectMaxId();
	  
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<StockBalance> searchByNameFilter(String name) {
		List<StockBalance> resultList = new ArrayList<StockBalance>();
		try {
			resultList = iBalanceDAOManager.selectBalanceDetailByNameFilter(name);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultList;
	}

}
