package org.amaris.presentation.BalanceManageForm;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.amaris.presentation.CuttingManageForm.CuttingEdit;
import org.amaris.presentation.CuttingManageForm.CuttingManageFrame;
import org.amaris.presentation.CuttingManageForm.DraffEditingFrame;
import org.amaris.presentation.inventoryManageForm.ButtonRenderer;
import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.balanceManage.IBalanceServiceManager;
import org.amaris.service.balanceManage.StockBalance;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.apache.commons.lang.StringUtils;
import org.jdesktop.swingx.JXDatePicker;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class DetailItemBalanceFrame extends JFrame implements WindowListener {

	public static DetailItemBalanceFrame detailtemBalance;
	public static String paramStockId;
	public static DraffEditingFrame draffEditingFrame;
	public static List<BalanceDetail> paramBalanceAfterDetailList = new ArrayList<BalanceDetail>();
	public static List<BalanceDetail> paramMasterBalanceDetailList = new ArrayList<BalanceDetail>();
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextField txtStockName;
	private JTable table;
	private DefaultTableModel dtm;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private IInventoryServiceManager inventorySerivceManger;
	private HashMap<String, String> comboMap = new HashMap<String, String>();
	private JLabel lblHome;
	private JLabel lblSearch;
	private IBalanceServiceManager iBalanceServiceManger;
	public int rowCount=0;
	private JTextField txtStockInId;
	private HashMap<Integer, Integer> stockQtyIdMap = new HashMap<Integer, Integer>();
	private JXDatePicker datePicker = new JXDatePicker();
	private String flag;
	JButton btnFinished;
	JButton btnDraff = new JButton("Draff");

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailItemBalanceFrame frame = new DetailItemBalanceFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static DetailItemBalanceFrame getInstance() {
			detailtemBalance = new DetailItemBalanceFrame();
			detailtemBalance.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			detailtemBalance.setVisible(true);
			detailtemBalance.setResizable(false);
			return detailtemBalance;
	}
	

	/**
	 * Create the frame.
	 */
	public DetailItemBalanceFrame() {
		flag =(String) Conversation.getConversationValue("Flag");
		if(!flag.equals("Cut")) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		setTitle("Clothes Management System");
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		overrideDefaultTableModle();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Stock Balance Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 1336, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("Stock Detail");
		lblLogo.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblLogo.setBounds(20, 40, 285, 24);
		panel.add(lblLogo);
		
		JLabel lblStock = new JLabel("Stock Name");
		lblStock.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblStock.setBounds(20, 213, 171, 36);
		panel.add(lblStock);
		
		txtStockName = new JTextField();
		txtStockName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtStockName.setColumns(10);
		txtStockName.setBounds(212, 214, 277, 34);
		panel.add(txtStockName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblDate.setBounds(20, 281, 171, 36);
		panel.add(lblDate);
		
		datePicker.setDate(Calendar.getInstance().getTime());
		datePicker.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
		datePicker.setBounds(212, 281, 277, 34);
		datePicker.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        panel.add(datePicker);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Stock List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(516, 152, 784, 328);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object
                value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
		
        if(flag.equals("Cut")) {
        	String[] columnNames = {
    	            "No",
    	            "Color",
    	            "Quantity",
    	            "Price",
    	            "Convertion",
    	            "Total Price",
    	            "Choose",
            };
    		Object[][] data={};
            dtm.setDataVector(data, columnNames);
        }
        else {
    		String[] columnNames = {
    	            "No",
    	            "Color",
    	            "Quantity",
    	            "Price",
    	            "Convertion",
    	            "Total Price",
    	            "Remove",
    	            "Refresh"
            };
    		Object[][] data={};
            dtm.setDataVector(data, columnNames);
        }
		
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 30, 764, 287);
		panel_1.add(scrollPane);
        
		table = new JTable();
		Font font = new Font("Times New Roman", Font.PLAIN, 16);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
		table.setFont(font);
		table.setModel(dtm);
		table.setBounds(10, 22, 682, 213);
		// align checkbox to center
		table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(cellRenderer);
		if(!flag.equals("Cut")) {
			table.getColumnModel().getColumn(7).setCellRenderer(cellRenderer);
		}
		table.addMouseListener(new CheckBoxHandler());
		
		if(flag.equals("Cut")) {
			table.getColumn("Choose").setCellRenderer(new ButtonRenderer());
			table.getColumn("Choose").setCellEditor(new ButtonDeleteStock(new JCheckBox()));
		}
		else {
			table.getColumn("Remove").setCellRenderer(new ButtonRenderer());
			table.getColumn("Remove").setCellEditor(new ButtonDeleteStock(new JCheckBox()));
			
			table.getColumn("Refresh").setCellRenderer(new ButtonRenderer());
			table.getColumn("Refresh").setCellEditor(new ButtonDeleteStock(new JCheckBox()));
		}
		scrollPane.setViewportView(table);
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame mainFrame = MainFrame.getInstance();
				detailtemBalance.setVisible(false);
				detailtemBalance = null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		lblHome.setBounds(700, 20, 150, 150);
		panel.add(lblHome);
		
		
		lblSearch = new JLabel(new ImageIcon("img/search.png"));
		lblSearch.setToolTipText("Search Item");
		lblSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchItemBalanceFrame searchItemBalanceFrame = SearchItemBalanceFrame.getInstance();
				detailtemBalance.setVisible(false);
				detailtemBalance = null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		lblSearch.setBounds(830, 5, 150, 150);
		panel.add(lblSearch);
		
		JLabel lblStockInId = new JLabel("Stock In ID");
		lblStockInId.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblStockInId.setBounds(20, 152, 171, 36);
		panel.add(lblStockInId);
		
		txtStockInId = new JTextField();
		txtStockInId.setEnabled(false);
		txtStockInId.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtStockInId.setColumns(10);
		txtStockInId.setBounds(212, 154, 277, 34);
		panel.add(txtStockInId);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StringUtils.isBlank(txtStockName.getText())) {
					JOptionPane.showMessageDialog(null, "Stock Name is required!.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					if(dtm.getRowCount()!=0) {
						int i=0;
						StockBalance sb = new StockBalance();
						sb.setStockInId(txtStockInId.getText());
						sb.setStockName(txtStockName.getText());
						sb.setStockInDate(formatter.format(datePicker.getDate()));
						sb.setUnit(dtm.getValueAt(0, 2)+"");
						List<BalanceDetail> stockDetailList = new ArrayList<BalanceDetail>();
						while(i<dtm.getRowCount()) {
							BalanceDetail balanceDetail = new BalanceDetail();
							balanceDetail.setStockQuantity(dtm.getValueAt(i, 1)+"");
							balanceDetail.setStockPrice(dtm.getValueAt(i, 3)+"");
							balanceDetail.setDetailUnitCount(dtm.getValueAt(i, 4)+"");
							balanceDetail.setTotalPrice(dtm.getValueAt(i, 5)+"");
							stockDetailList.add(balanceDetail);
							i++;
						}
						sb.setBalanceDetail(stockDetailList);
						try {
							iBalanceServiceManger.editStock(sb);
							JOptionPane.showMessageDialog(null, "Successly Fully Updated.",
									"Info", JOptionPane.INFORMATION_MESSAGE);
						}
						catch(Exception ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(null, "Fail to update stock.",
									"Error Info", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
							JOptionPane.showMessageDialog(null, "Stock list should not be zero.",
								"Error Info", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnEdit.setBounds(20, 366, 125, 45);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					iBalanceServiceManger.deleteStock(txtStockInId.getText());
					JOptionPane.showMessageDialog(null, "Delete process is success.",
							"Info", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Delete process is fail.",
							"Error Info", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnDelete.setBounds(207, 366, 125, 45);
		panel.add(btnDelete);
		
		btnFinished = new JButton("Finished");
		btnFinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<BalanceDetail> tmpList = new ArrayList<BalanceDetail>();
				List<BalanceDetail> tmpList1 = new ArrayList<BalanceDetail>();
				for(BalanceDetail bd : paramBalanceAfterDetailList) {
					bd.setStockInId(txtStockInId.getText());
					tmpList.add(bd);
				}
				Conversation.addConversation(txtStockInId.getText(), tmpList);
				for(BalanceDetail bd : paramMasterBalanceDetailList) {
					bd.setStockInId(txtStockInId.getText());
					tmpList1.add(bd);
				}
				Conversation.addConversation(txtStockInId.getText()+"msb", tmpList1);
					CuttingManageFrame.cuttingList.removeAll(CuttingManageFrame.cuttingList);
				CuttingManageFrame cf = CuttingManageFrame.getInstance();

				detailtemBalance.setVisible(false);
				detailtemBalance = null;
				
			}
		});
		btnFinished.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnFinished.setBounds(20, 366, 150, 45);
		panel.add(btnFinished);
		btnDraff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draffEditingFrame = DraffEditingFrame.getInstance();
				
			}
		});
		
		btnDraff.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnDraff.setBounds(207, 366, 150, 45);
		panel.add(btnDraff);
		btnFinished.setVisible(false);
		btnDraff.setVisible(false);
		
		initializedStockData();
		
		if(flag.equals("Cut")) {
			btnDelete.setVisible(false);
			btnEdit.setVisible(false);
			btnFinished.setVisible(true);
			btnDraff.setVisible(true);
		}
	}
	
	private void overrideDefaultTableModle(){
    	dtm = new DefaultTableModel() {
    		
//    	   @Override
//     	    public boolean isCellEditable(int row, int col) {
//     	        //Note that the data/cell address is constant,
//     	        //no matter where the cell appears onscreen.
//     	        if (col >= 0 && col <=5) {
//     	            return false;
//     	        } else {
//     	            return true;
//     	        }
//     	    }
    	};
    }

	public void initializedStockData() {
		StockBalance stockBalance;
		if(flag.equals("Cut")) {
			stockBalance = (StockBalance) Conversation.getConversationValue("cutting");
		}
		else {
			stockBalance = (StockBalance) Conversation.getConversationValue("editStock");
		}
		txtStockInId.setText(stockBalance.getStockInId());
		paramStockId = stockBalance.getStockInId();
		txtStockName.setText(stockBalance.getStockName());
		if(!flag.equals("Cut")) {
			Date date;
			try {
				date = formatter.parse(stockBalance.getStockInDate());
				datePicker.setDate(date);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		selectStock(stockBalance);
		
	}
	
	public void addingToTable(List<BalanceDetail> stockDetailList,String unit) {
		for(BalanceDetail bd : stockDetailList) {
			if(flag.equals("Cut")) {
				dtm.addRow(new Object[]{
						bd.getStockQtyId(),
						bd.getColorNo(),
						bd.getStockQuantity(),
						bd.getStockPrice(),
						bd.getDetailUnitCount(),
						bd.getTotalPrice(),
						"Choose"
					});
					rowCount += 1;
					stockQtyIdMap.put(rowCount, bd.getStockQtyId());
			}
			else {
				dtm.addRow(new Object[]{
						bd.getStockQtyId(),
						bd.getColorNo(),
						bd.getStockQuantity(),
						bd.getStockPrice(),
						bd.getDetailUnitCount(),
						bd.getTotalPrice(),
						"Delete",
						"Refresh"
					});
					rowCount += 1;
					stockQtyIdMap.put(rowCount, bd.getStockQtyId());
			}

		}
	}
	
	public void selectStock(StockBalance stockBalance) {
		iBalanceServiceManger = (IBalanceServiceManager) BasicBeanFactory.getBean("BalanceServiceManager");
		List<BalanceDetail> resultList;
		try {
			resultList=iBalanceServiceManger.searchBalanceDetailByFilter(stockBalance.getStockInId());
			addingToTable(resultList, stockBalance.getUnit());
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to Insert Item.",
					"Error Info", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void removeAllRow() {
		if(dtm.getRowCount()!=0) {
			for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
			    dtm.removeRow(i);
			}
		}
	}
	
class CheckBoxHandler implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			 int selectedRow = table.getSelectedRow();  
			 int selectedCol = table.getSelectedColumn();

			 if(!flag.equals("Cut")) {
				 if(selectedCol == 6) {
					 dtm.removeRow(selectedRow);
					 rowCount -=1;
				 }
			 }
			 else{
				 BalanceDetail bd = new BalanceDetail();
				 bd.setStockQtyId(Integer.valueOf(dtm.getValueAt(selectedRow, 0)+""));
				 bd.setTotalPrice(dtm.getValueAt(selectedRow, 5)+"");
				 bd.setStockQuantity(dtm.getValueAt(selectedRow, 2)+"");
				 bd.setDetailUnitCount(dtm.getValueAt(selectedRow, 4)+"");
				 Conversation.addConversation("cuttingDetail", bd);
				 CuttingEdit cuttingEidt = CuttingEdit.getInstance();

			 }

			 if(selectedCol ==7) {
				 int price = Integer.valueOf(dtm.getValueAt(selectedRow, 1)+"");
				 int qty = Integer.valueOf(dtm.getValueAt(selectedRow, 3)+"");
				 int totalPrice = price * qty;
				 dtm.setValueAt(totalPrice+"", selectedRow, 5);
				 table.repaint();
			 }
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
	}

@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e) {
	detailtemBalance = null;
	
}

@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}


}
