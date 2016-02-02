package org.amaris.service.SupplierManager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.amaris.persistence.balanceManage.IBalanceDAOManager;
import org.amaris.persistence.inventoryManage.IInventoryPersistenceManager;
import org.amaris.persistence.supplierManage.ISupplierDAOManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service(value="SupplierServiceManager")
public class SupplierServiceManager implements ISupplierServiceManager {

	@Resource(name = "SupplierDAOManager")
	ISupplierDAOManager iSupplierDAOManager;

	@Override
	public void addSupplier(Supplier supplier) {
		try {
			iSupplierDAOManager.insertSupplier(supplier);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}


	public String getLastGenId() {
		try {
			return iSupplierDAOManager.selectMaxId();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	@Override
	public void updateSupplier(Supplier supplier) {
		try {
			iSupplierDAOManager.updateSupplier(supplier);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}


	@Override
	public void deleteSupplier(String id) {
		// TODO Auto-generated method stub
		try {
			iSupplierDAOManager.deleteSupplier(id);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}


	@Override
	public List<Supplier> findByNameFilter(String name) {
		// TODO Auto-generated method stub
		List<Supplier> supplierList = null;
		try {
			supplierList=iSupplierDAOManager.findByNameFilter(name);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}	
		return supplierList;
	}


	@Override
	public List<Supplier> findAll() {
		// TODO Auto-generated method stub
		List<Supplier> supplierList = null;
		try {
			supplierList=iSupplierDAOManager.findAll();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}	
		return supplierList;
		
	}


	@Override
	public Supplier findById(String id) {
		// TODO Auto-generated method stub
		Supplier supplier = null;
		try {
			supplier=iSupplierDAOManager.findById(id);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}	
		return supplier;
	}

	
}
