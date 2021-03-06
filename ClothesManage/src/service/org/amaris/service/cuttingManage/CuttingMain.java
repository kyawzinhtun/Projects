package org.amaris.service.cuttingManage;

import java.util.ArrayList;
import java.util.List;

import org.amaris.service.balanceManage.BalanceDetail;

public class CuttingMain {
	private String cutId;
	private String cuttingId;
	private List<DraffCut> draffCutList;
	private String cuttingDate;
	private List<BalanceDetail> cutBDList;
	private List<BalanceDetail> mstBDList;
	private String perUnitPrice;
	private String totalUnitPrice;
	private String perIncludeUnitPrice;
	private String totalUnit;
	private String styleID;
	private String size;
	
	public CuttingMain() {
		
	}

	public String getCuttingId() {
		return cuttingId;
	}

	public void setCuttingId(String cuttingId) {
		this.cuttingId = cuttingId;
	}

	public List<DraffCut> getDraffCutList() {
		return draffCutList;
	}

	public void setDraffCutList(List<DraffCut> draffCutList) {
		this.draffCutList = draffCutList;
	}

	public String getCuttingDate() {
		return cuttingDate;
	}

	public void setCuttingDate(String cuttingDate) {
		this.cuttingDate = cuttingDate;
	}

	public List<BalanceDetail> getCutBDList() {
		return cutBDList;
	}

	public void setCutBDList(List<BalanceDetail> cutBDList) {
		this.cutBDList = cutBDList;
	}

	public List<BalanceDetail> getMstBDList() {
		return mstBDList;
	}

	public void setMstBDList(List<BalanceDetail> mstBDList) {
		this.mstBDList = mstBDList;
	}

	public String getPerUnitPrice() {
		return perUnitPrice;
	}

	public void setPerUnitPrice(String perUnitPrice) {
		this.perUnitPrice = perUnitPrice;
	}

	public String getTotalUnitPrice() {
		return totalUnitPrice;
	}

	public void setTotalUnitPrice(String totalUnitPrice) {
		this.totalUnitPrice = totalUnitPrice;
	}

	public String getPerIncludeUnitPrice() {
		return perIncludeUnitPrice;
	}

	public void setPerIncludeUnitPrice(String perIncludeUnitPrice) {
		this.perIncludeUnitPrice = perIncludeUnitPrice;
	}

	public String getTotalUnit() {
		return totalUnit;
	}

	public void setTotalUnit(String totalUnit) {
		this.totalUnit = totalUnit;
	}

	public String getStyleID() {
		return styleID;
	}

	public void setStyleID(String styleID) {
		this.styleID = styleID;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCutId() {
		return cutId;
	}

	public void setCutId(String cutId) {
		this.cutId = cutId;
	}


}
