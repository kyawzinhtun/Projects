package org.amaris.presentation.LineForm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.amaris.presentation.BalanceManageForm.ButtonDeleteStock;
import org.amaris.presentation.BalanceManageForm.DetailItemBalanceFrame;
import org.amaris.presentation.CuttingManageForm.CuttingManageFrame;
import org.amaris.presentation.CuttingManageForm.DifferenceBalance;
import org.amaris.presentation.inventoryManageForm.ButtonRenderer;
import org.amaris.presentation.inventoryManageForm.StyleSearchFrame;
import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.balanceManage.IBalanceServiceManager;
import org.amaris.service.balanceManage.StockBalance;
import org.amaris.service.cuttingManage.CuttingMain;
import org.amaris.service.cuttingManage.DraffCut;
import org.amaris.service.cuttingManage.ICuttingServiceManager;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.service.inventoryManage.Style;
import org.amaris.service.inventoryManage.StyleInclude;
import org.amaris.util.AValidator;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.apache.commons.lang.StringUtils;
import org.jdesktop.swingx.JXDatePicker;

public class LineMangeFrame extends JFrame {

	public static LineMangeFrame lineMangeFrame;
	public static List<DraffCut> draffCutList = new ArrayList<DraffCut>();
	public static String paramCuttingCode;
	private IBalanceServiceManager iBalanceServiceManger;
	private ICuttingServiceManager iCuttingServiceManger;
	private IInventoryServiceManager inventorySerivceManger; 
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	private JPanel contentPane;
	private JLabel lblcuttingCode;
	private JTextField txtCuttingCode;
	private JLabel lblHome;
	private JLabel lblEdit;
	private JLabel lblSearch;
	private JXDatePicker startDatePicker = new JXDatePicker();
	private JXDatePicker endDatePicker = new JXDatePicker();
	private IInventoryServiceManager inventoryServiceManager;
	private JButton btnSave;
	private JFileChooser fileChooser = new JFileChooser();
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scrollPane;
	public int rowCount=0;
	private JLabel lblPayUnit;
	private JTextField txtStyleSize;
	private JLabel lblTotalUnit_1;
	private JTextField txtStyleCode;
	public static List<BalanceDetail> cutBDList = new ArrayList<BalanceDetail>();
	public static List<BalanceDetail> mstBDList = new ArrayList<BalanceDetail>();
	// keep cutting list of CuttingEdit
	public static List<BalanceDetail> cuttingList = new ArrayList<BalanceDetail>();
	public static String perUnitPrice="";
	public static String totalUnitPrice="";
	public static String perIncludeUnitPrice="";
	public static String totalUnit="";
	private JTextField txtFirstPrice;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuttingManageFrame frame = new CuttingManageFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static LineMangeFrame getInstance() {
		if (lineMangeFrame == null) {
			lineMangeFrame = new LineMangeFrame();
			lineMangeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			lineMangeFrame.setVisible(true);
			lineMangeFrame.setResizable(false);
			return lineMangeFrame;
		}
		lineMangeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		lineMangeFrame.setVisible(true);
		lineMangeFrame.setResizable(false);		
		return lineMangeFrame;
	}

	/**
	 * Create the frame.
	 */
	public LineMangeFrame() {
		
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		overrideDefaultTableModle();

		iBalanceServiceManger = (IBalanceServiceManager) BasicBeanFactory.getBean("BalanceServiceManager");
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Produce Cutting", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 11, 1336, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("Cutting");
		lblLogo.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblLogo.setBounds(20, 60, 216, 24);
		panel.add(lblLogo);
		
		lblcuttingCode = new JLabel("Cutting Code");
		lblcuttingCode.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblcuttingCode.setBounds(20, 199, 188, 30);
		panel.add(lblcuttingCode);
		
		JLabel lblDate = new JLabel("Start Date");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblDate.setBounds(34, 267, 125, 24);
		panel.add(lblDate);
		
		txtCuttingCode = new JTextField();
		txtCuttingCode.setEditable(false);
		txtCuttingCode.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtCuttingCode.setColumns(10);
		txtCuttingCode.setBounds(223, 196, 229, 36);
		panel.add(txtCuttingCode);
		String id = getLastID();
		txtCuttingCode.setText(id);
		paramCuttingCode = id;
		
		startDatePicker.setDate(Calendar.getInstance().getTime());
		startDatePicker.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
		startDatePicker.setBounds(223, 261, 229, 36);
		startDatePicker.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        panel.add(startDatePicker);
    
		endDatePicker.setDate(Calendar.getInstance().getTime());
		endDatePicker.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
		endDatePicker.setBounds(223, 324, 229, 36);
		endDatePicker.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        panel.add(endDatePicker);
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prePareCutBDList();
				MainFrame mainFrame = MainFrame.getInstance();
				lineMangeFrame.setVisible(false);
				lineMangeFrame = null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		lblHome.setBounds(700, 45, 150, 150);
		panel.add(lblHome);
		
		lblSearch = new JLabel(new ImageIcon("img/search.png"));
		lblSearch.setToolTipText("Search Item");
		lblSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prePareCutBDList();
				Conversation.addConversation("Flag", "InventoryManageFrame");
				StyleSearchFrame styleSearchFrame = StyleSearchFrame.getInstance();
				lineMangeFrame.setVisible(false);
				lineMangeFrame = null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		lblSearch.setBounds(830, 30, 150, 150);
		panel.add(lblSearch);

		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prePareCutBDList();
				CuttingMain cm = new CuttingMain();	
				cm.setCuttingId(txtCuttingCode.getText());
				cm.setStyleID(txtStyleCode.getText());
				cm.setSize(txtStyleSize.getText());
				cm.setPerUnitPrice(txtFirstPrice.getText());
//				cm.setPerIncludeUnitPrice(txtSecondPrice.getText());
//				cm.setTotalUnit(txtTotalProductUnit.getText());
//				cm.setTotalUnitPrice(txtTotalPrice.getText());
//				cm.setCuttingDate(formatter.format(datePicker.getDate()));
				cm.setCutBDList(cutBDList);
				cm.setMstBDList(mstBDList);
				cm.setDraffCutList(draffCutList);
				try {
					iCuttingServiceManger.insertCutting(cm);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnSave.setBounds(491, 556, 125, 45);
		panel.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCuttingCode.setText("");
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnClear.setBounds(647, 556, 132, 45);
		panel.add(btnClear);
		
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
        
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Material List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(491, 188, 806, 348);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		String[] columnNames = {
                "No",
                "Line Name",
                "Unit",
                "Start Date",
                "End Date",
                "Action"
        };
		
		Object[][] data={};
        dtm.setDataVector(data, columnNames);
		
		table = new JTable();
		table.setBounds(25, 29, 598, 251);
		
        scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 30, 757, 296);
		panel_1.add(scrollPane);
		
		Font font = new Font("Times New Roman", Font.PLAIN, 16);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
		table.setFont(font);
		table.setModel(dtm);
		// align checkbox to center
		table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
		table.addMouseListener(new CheckBoxHandler());
		
		table.getColumn("Action").setCellRenderer(new ButtonRenderer());
		table.getColumn("Action").setCellEditor(new ButtonDeleteStock(new JCheckBox()));
		scrollPane.setViewportView(table);
		
		lblPayUnit = new JLabel("Order Unit");
		lblPayUnit.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblPayUnit.setBounds(34, 503, 170, 24);
		panel.add(lblPayUnit);
		
		txtStyleSize = new JTextField();
		txtStyleSize.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtStyleSize.setColumns(10);
		txtStyleSize.setBounds(223, 436, 229, 36);
		panel.add(txtStyleSize);
		
		lblTotalUnit_1 = new JLabel("Line");
		lblTotalUnit_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblTotalUnit_1.setBounds(34, 439, 188, 30);
		panel.add(lblTotalUnit_1);
		
		txtStyleCode = new JTextField();
		txtStyleCode.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtStyleCode.setColumns(10);
		txtStyleCode.setBounds(223, 379, 229, 36);
		panel.add(txtStyleCode);
		
		JLabel lblFirstPrice = new JLabel("Total Unit");
		lblFirstPrice.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblFirstPrice.setBounds(34, 385, 161, 24);
		panel.add(lblFirstPrice);
		
		txtFirstPrice = new JTextField();
		txtFirstPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtFirstPrice.setColumns(10);
		txtFirstPrice.setBounds(223, 490, 229, 36);
		panel.add(txtFirstPrice);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblEndDate.setBounds(34, 324, 125, 24);
		panel.add(lblEndDate);
		txtStyleCode.getDocument().addDocumentListener(new DocumentListener() {


			public void insertUpdate(DocumentEvent e) {
				searchStockFilter(txtStyleCode.getText(),"style");
			}


			public void removeUpdate(DocumentEvent e) {
				searchStockFilter(txtStyleCode.getText(),"style");			
			}


			public void changedUpdate(DocumentEvent e) {
				searchStockFilter(txtStyleCode.getText(),"style");
			}
		});
		
		fileChooser.setCurrentDirectory(new File("C:\\Documents and Settings"));
		fileChooser.setDialogTitle("Choose Status Report File");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setAcceptAllFileFilterUsed(false);
		
	}
	
	private void overrideDefaultTableModle(){
    	dtm = new DefaultTableModel() {
    		
    	   @Override
     	    public boolean isCellEditable(int row, int col) {
     	        //Note that the data/cell address is constant,
     	        //no matter where the cell appears onscreen.
     	        if (col >= 0 && col <=2) {
     	            return false;
     	        } else {
     	            return true;
     	        }
     	    }
    	};
    }

class CheckBoxHandler implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			 int selectedRow = table.getSelectedRow();  
			 int selectedCol = table.getSelectedColumn();

			 if(selectedCol == 3) {
					StockBalance sb = new StockBalance();
					sb.setStockId(Integer.valueOf(dtm.getValueAt(selectedRow, 0)+""));
					sb.setStockInId((String)dtm.getValueAt(selectedRow, 1));
					sb.setStockName((String)dtm.getValueAt(selectedRow, 2));
					Conversation.addConversation("cutting", sb);
					Conversation.addConversation("Flag", "Cut");
					DetailItemBalanceFrame detailItemBalanceFrame = DetailItemBalanceFrame.getInstance();
			 }
			 if(selectedCol == 1) {
				DifferenceBalance db = DifferenceBalance.getInstance(dtm.getValueAt(selectedRow, 1)+"");
				db.addWindowListener(new java.awt.event.WindowAdapter() {
				    @Override
				    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				       txtFirstPrice.setText(perUnitPrice);
//				       txtSecondPrice.setText(perIncludeUnitPrice);
//				       txtTotalPrice.setText(totalUnitPrice);
//				       txtTotalProductUnit.setText(totalUnit);
				    }
				});

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
	
	public void saveInvItem(Style style) {
		inventoryServiceManager = (IInventoryServiceManager) BasicBeanFactory.getBean("InventoryServiceManager");
		try {
			inventoryServiceManager.addNewItem(style);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to create style.",
					"Error Info", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void keyPressed(KeyEvent e) {
	    if (e.getKeyCode()==KeyEvent.VK_ENTER){
	    	System.out.println("press");
	    }

	}
	
	public void setChooseValue(String stockInId, String stockName) {

	}
	
	public void searchStockFilter(String styleCode, String type) {
		inventoryServiceManager = (IInventoryServiceManager) BasicBeanFactory.getBean("InventoryServiceManager");
		List<Style> resultList = new ArrayList<Style>();
		if(StringUtils.isBlank(styleCode)){
			removeAllRow();
		}
		else {
			try {
				if(type.equals("style")) {
					resultList = inventoryServiceManager.findFilterStyle(styleCode);
				}
				
				int i = 0;
				removeAllRow();
	            for(Style style : resultList) {
	            	Style s = inventoryServiceManager.findStyleDetail(style.getStyleName());
	            	for(StyleInclude si : s.getStyleIncludeList()) {
	            		String id = si.getStockInId();
	            		String name = si.getStockName();
	            		dtm.addRow(new Object[]{
							i+1,
							id,
							name,
							"Detail",
	            		});
	            		i++;
	            	}
	            }
			}
			catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Fail to Search Stock",
						"Error Info", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public void removeAllRow() {
		if(dtm.getRowCount()!=0) {
			for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
			    dtm.removeRow(i);
			}
		}
	}
	
	public String getLastID() {
		iCuttingServiceManger = (ICuttingServiceManager) BasicBeanFactory.getBean("CuttingSeriveManager");
		String id="";
		try {
			id = iCuttingServiceManger.getLastGenId();
			int increaseId = Integer.valueOf(id);
			increaseId +=1;
			id = String.valueOf(increaseId);
			int idLenght = id.length();
			for(int i = idLenght; i < AValidator.ID_MAX_LENGTH; i++) {
				id = "0"+id;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return id;
	}

	public static List<DraffCut> getDraffCutList() {
		return draffCutList;
	}

	public static void setDraffCutList(List<DraffCut> draffCutList) {
		CuttingManageFrame.draffCutList = draffCutList;
	}
	
	public void prePareCutBDList() {
		int i = dtm.getRowCount();
		List<BalanceDetail> tmpcutbdListFinal = new ArrayList<BalanceDetail>();
		List<BalanceDetail> tmpNewbdListFinal = new ArrayList<BalanceDetail>();
		for(int j=0;j<i;j++) {
			String id = dtm.getValueAt(j, 1)+"";
			List<BalanceDetail> tmpcutbdList = new ArrayList<BalanceDetail>();
			List<BalanceDetail> tmpNewbdList = new ArrayList<BalanceDetail>();

			tmpcutbdList = (List<BalanceDetail>) Conversation.getConversationValue(id);
			tmpNewbdList = (List<BalanceDetail>) Conversation.getConversationValue(id+"msb");
			if(tmpcutbdList!=null&& tmpNewbdList!=null) {
				tmpcutbdListFinal = (List<BalanceDetail>) Conversation.getConversationValue(id);
				tmpNewbdListFinal = (List<BalanceDetail>) Conversation.getConversationValue(id+"msb");
	
			}
			if(tmpcutbdList!=null&& tmpNewbdList!=null) {
				Conversation.endConversation(id);
				Conversation.endConversation(id+"msb");
			}
		}
		for(BalanceDetail bd : tmpNewbdListFinal) {
			cutBDList.add(bd);
		}
		for(BalanceDetail bd : tmpNewbdListFinal) {
			mstBDList.add(bd);
		}
	}
}
