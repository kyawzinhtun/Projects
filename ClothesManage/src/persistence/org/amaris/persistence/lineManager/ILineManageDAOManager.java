package org.amaris.persistence.lineManager;

import java.util.List;

import org.amaris.service.lineManager.Accessories;
import org.amaris.service.lineManager.Line;
import org.amaris.service.lineManager.StockView;

public interface ILineManageDAOManager {
	
 	void insert(Line line, List<StockView> accessoreisList);
 	List<Line> selectAllLine();
 	List<Line> selectAllCompleteLine(String status);
 	List<Line> selectAllUnCompleteLine(String status);
 	void editLine(List<Line> lineList);
 	
 	List<StockView> selectAll();
 	List<StockView> selectById(String id);
 	List<Accessories> getAccessoriesListById(String id);

}
