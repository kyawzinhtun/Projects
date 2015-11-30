package org.amaris.service.inventoryManage;

import java.util.List;

public class Style {
	
	private int styleId;
	private String StyleName;
	private String remark;
	private String imagePath;
	private String styleProduceDate;
	private String size;
	private List<StyleInclude> styleIncludeList;
	
	public Style() {
		
	}

	public int getStyleId() {
		return styleId;
	}

	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}

	public String getStyleName() {
		return StyleName;
	}

	public void setStyleName(String styleName) {
		StyleName = styleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getStyleProduceDate() {
		return styleProduceDate;
	}

	public void setStyleProduceDate(String styleProduceDate) {
		this.styleProduceDate = styleProduceDate;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<StyleInclude> getStyleIncludeList() {
		return styleIncludeList;
	}

	public void setStyleIncludeList(List<StyleInclude> styleIncludeList) {
		this.styleIncludeList = styleIncludeList;
	}
	
	

}
