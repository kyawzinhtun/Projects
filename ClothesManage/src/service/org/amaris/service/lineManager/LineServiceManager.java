package org.amaris.service.lineManager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.amaris.persistence.lineManager.ILineManageDAOManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("LineServiceManager")
public class LineServiceManager implements ILineServiceManager {

	@Resource(name = "LineManageDAOManager")
	ILineManageDAOManager iLineManageDAOManager;

	@Transactional(propagation = Propagation.REQUIRED)
	public void addLine(Line line, List<StockView> accessoriesList) {
		try {
			iLineManageDAOManager.insert(line, accessoriesList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Line> getAllLine() {
		try {
			return iLineManageDAOManager.selectAllLine();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Line> getCompleteLine(String status) {
		try {
			return iLineManageDAOManager.selectAllCompleteLine(status);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Line> getUncompleteLine(String status) {
		try {
			return iLineManageDAOManager.selectAllUnCompleteLine(status);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void editLine(List<Line> lineList) {
		// TODO Auto-generated method stub
		try {
			iLineManageDAOManager.editLine(lineList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<StockView> getAccessoriesById(String id) {
		List<StockView> stockList = new ArrayList<StockView>();
		try {
			if (StringUtils.isEmpty(id)) {
				stockList = iLineManageDAOManager.selectAll();
			} else {
				stockList = iLineManageDAOManager.selectById(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return stockList;
	}

	@Override
	public List<Accessories> getAccessoriesListById(String id) {
		// TODO Auto-generated method stub
		List<Accessories> stockList = new ArrayList<Accessories>();
		try {

			stockList = iLineManageDAOManager.getAccessoriesListById(id);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return stockList;
	}

}
