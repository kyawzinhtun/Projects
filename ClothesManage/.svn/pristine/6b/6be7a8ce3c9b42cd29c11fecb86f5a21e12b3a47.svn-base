package org.amaris.service.lineManager;

import java.util.List;
import org.amaris.service.lineManager.StockView;

public interface ILineServiceManager {
	void addLine(Line line, List<StockView> accessoriesList);
	List<Line> getAllLine();
	List<Line> getCompleteLine(String status);
	List<Line> getUncompleteLine(String status);
	void editLine(List<Line> lineList);
	List<StockView> getAccessoriesById(String id);
	List<Accessories> getAccessoriesListById(String id);
}
