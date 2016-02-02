package org.amaris.presentation.LineForm;



import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JButton;

import org.amaris.service.lineManager.Accessories;
import org.amaris.service.lineManager.StockView;
import org.amaris.presentation.BalanceManageForm.DetailItemBalanceFrame;
import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.cuttingManage.CuttingMain;
import org.amaris.service.cuttingManage.DraffCut;
import org.apache.commons.lang.StringUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

public class AccessoriesDetailPopUp extends JFrame {

	private JPanel contentPane;
	public static AccessoriesDetailPopUp draffEditingFrame;
	private JTable table;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;
	private List<StockView> stockViewList = new ArrayList<StockView>();
	private List<Accessories> accessoriesList = new ArrayList<Accessories>();
//	private List<BalanceDetail> detailList = new ArrayList<BalanceDetail>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessoriesDetailPopUp frame = new AccessoriesDetailPopUp();
//					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static AccessoriesDetailPopUp getInstance() {
		draffEditingFrame = new AccessoriesDetailPopUp();
		draffEditingFrame.setVisible(true);
		draffEditingFrame.setResizable(false);
		return draffEditingFrame;
	}

	/**
	 * Create the frame.
	 */
	public AccessoriesDetailPopUp() {
		setTitle("Cutting Detail");
		setBounds(100, 100, 578, 371);
		overrideDefaultTableModle();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 553, 321);
		contentPane.add(panel);
		panel.setLayout(null);
		
        DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object
                value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
		
		String[] columnNames = {
                "No",
//                "Stock Id",
                "Name",
                "Qty",
                "Price",                
         };

		Object[][] data={};
		dtm.setDataVector(data, columnNames);
		
		table = new JTable();
		table.setBounds(25, 35, 663, 192);
		Font font = new Font("Times New Roman", Font.PLAIN, 16);
		table.setFont(font);
		table.setModel(dtm);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
		
		// align checkbox to center
		table.getColumnModel().getColumn(0).setCellRenderer(r);
		table.getColumnModel().getColumn(1).setCellRenderer(r);
		table.getColumnModel().getColumn(2).setCellRenderer(r);
		table.getColumnModel().getColumn(3).setCellRenderer(r);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 533, 298);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);	
	}
	
	private void overrideDefaultTableModle(){
    	dtm = new DefaultTableModel() {
    		
     	    public boolean isCellEditable(int row, int col) {
     	        //Note that the data/cell address is constant,
     	        //no matter where the cell appears onscreen.
     	        if (col >= 0 && col <=7) {
     	            return false;
     	        } else {
     	            return true;
     	        }
     	    }
    	};
    }

	public List<BalanceDetail> getDetailList() {
//		return detailList;
		return null;
	}

	public void setDetailList(List<BalanceDetail> detailList) {
//		this.detailList = detailList;
//		initDataList(detailList);
	}
	
	public List<StockView> getStockViewList() {
		return stockViewList;
	}

	public void setStockViewList(List<StockView> stockViewList) {
		this.stockViewList = stockViewList;
		initDataList(stockViewList);
	}

	
	public List<Accessories> getAccessoriesList() {
		return accessoriesList;
	}

	public void setAccessoriesList(List<Accessories> accessoriesList) {
		this.accessoriesList = accessoriesList;
		initAccessoiresDataList(accessoriesList);
	}

	private void initDataList(List<StockView> detailList) {
		List<StockView> resultList = detailList;
		int i=0;
		double total=0;
		for(StockView sv : resultList) {
			dtm.addRow(new Object[]{
					i+1,
//					sv.getStockQtyId(),
					sv.getStockName(),
					sv.getStockQuantity(),					
					sv.getStockPrice(),
					
			});
			total+=Double.parseDouble(sv.getStockPrice());
			i++;
		}
		dtm.addRow(new Object[]{
				null,
//				null,
				null,
				"Total Price",					
				total,
				
		});
	}
	
	//show accessories list
	private void initAccessoiresDataList(List<Accessories> detailList) {
		List<Accessories> resultList = detailList;
		int i=0;
		double total=0;
		for(Accessories accessories : resultList) {
			dtm.addRow(new Object[]{
					i+1,
					accessories.getAccountName(),
					accessories.getAccountQuantity(),					
					accessories.getAccountPerPrice(),
					
			});
			total+=Double.parseDouble(accessories.getAccountPerPrice());
			i++;
		}
		dtm.addRow(new Object[]{
				null,
				null,
				"Total Price",					
				total,
				
		});
	}
}

