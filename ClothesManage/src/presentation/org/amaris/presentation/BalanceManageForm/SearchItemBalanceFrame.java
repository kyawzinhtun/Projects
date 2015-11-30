package org.amaris.presentation.BalanceManageForm;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.amaris.presentation.inventoryManageForm.ButtonRenderer;
import org.amaris.presentation.inventoryManageForm.InventoryManageFrame;
import org.amaris.presentation.inventoryManageForm.StyleDetailFrame;
import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.balanceManage.IBalanceServiceManager;
import org.amaris.service.balanceManage.StockBalance;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.apache.commons.lang.StringUtils;

import javax.swing.JTextField;
 

public class SearchItemBalanceFrame extends JFrame {

	public static SearchItemBalanceFrame searchItemBalanceFrame;
	private HashMap<String, String> comboMap = new HashMap<String, String>();
	private HashMap<Integer, String> tableValueMap = new HashMap<Integer, String>();
	private IInventoryServiceManager inventorySerivceManger;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel dtm;
	private JPanel panel_1;
	private JLabel lblHome;
	private JLabel lblAdd;
	private IBalanceServiceManager iBalanceServiceManger;
	private JTextField searchKeyWords;
	private String flag;
	private JTextField txtNameFilter;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchItemBalanceFrame frame = new SearchItemBalanceFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static SearchItemBalanceFrame getInstance() {
		if (searchItemBalanceFrame == null) {
			searchItemBalanceFrame = new SearchItemBalanceFrame();
			searchItemBalanceFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			searchItemBalanceFrame.setVisible(true);
			searchItemBalanceFrame.setResizable(false);
			return searchItemBalanceFrame;
		}
		searchItemBalanceFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		searchItemBalanceFrame.setVisible(true);
		searchItemBalanceFrame.setResizable(false);		
		return searchItemBalanceFrame;
	}

	/**
	 * Create the frame.
	 */
	public SearchItemBalanceFrame() {
		
		
		flag = (String) Conversation.getConversationValue("Flag");
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 11, 1336, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Result View", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 164, 1277, 505);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		overrideDefaultTableModle();
		
		JLabel lblLogo = new JLabel("Stock Searching");
		lblLogo.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblLogo.setBounds(20, 60, 285, 24);
		panel.add(lblLogo);

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
                "Stock In ID",
                "Stock Name",
                "Stock In Date",
                "Action"

         };
	

		Object[][] data={};
		dtm.setDataVector(data, columnNames);
	
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 54, 1222, 426);
		panel_1.add(scrollPane);
		
		table = new JTable();
		Font font = new Font("Times New Roman", Font.PLAIN, 16);
		table.setFont(font);
		table.setModel(dtm);
		table.addMouseListener(new CheckBoxHandler());
		table.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
		
		// align checkbox to center
		table.getColumnModel().getColumn(0).setCellRenderer(r);
		table.getColumnModel().getColumn(1).setCellRenderer(r);
		table.getColumnModel().getColumn(2).setCellRenderer(r);
		table.getColumnModel().getColumn(3).setCellRenderer(r);
		table.getColumnModel().getColumn(4).setCellRenderer(r);
		
		// add button at update column 
		table.getColumn("Action").setCellRenderer(new ButtonRenderer());
		table.getColumn("Action").setCellEditor(new ButtonDetailStock(new JCheckBox()));
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		
		JLabel lblNewLabel = new JLabel("ID Filter");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setBounds(20, 127, 101, 26);
		panel.add(lblNewLabel);
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame mainFrame = MainFrame.getInstance();
				searchItemBalanceFrame.setVisible(false);
				searchItemBalanceFrame = null;
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
		
		lblAdd = new JLabel(new ImageIcon("img/add.png"));
		lblAdd.setToolTipText("Search Item");
		lblAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageItemBalanceFrame manageItemBalanceFrame = ManageItemBalanceFrame.getInstance();
				searchItemBalanceFrame.setVisible(false);
				searchItemBalanceFrame = null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		lblAdd.setBounds(830, 30, 150, 150);
		panel.add(lblAdd);
		
		searchKeyWords = new JTextField();
		searchKeyWords.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		searchKeyWords.setBounds(115, 126, 159, 26);
		searchKeyWords.setColumns(10);
		panel.add(searchKeyWords);
		
		JLabel lblNameFilter = new JLabel("Name Filter");
		lblNameFilter.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNameFilter.setBounds(300, 127, 119, 26);
		panel.add(lblNameFilter);
		searchKeyWords.getDocument().addDocumentListener(new DocumentListener() {


			public void insertUpdate(DocumentEvent e) {
				searchStockFilter(searchKeyWords.getText(),"key");
			}


			public void removeUpdate(DocumentEvent e) {
				searchStockFilter(searchKeyWords.getText(),"key");			
			}


			public void changedUpdate(DocumentEvent e) {
				searchStockFilter(searchKeyWords.getText(),"key");
			}
		});
		
		txtNameFilter = new JTextField();
		txtNameFilter.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtNameFilter.setColumns(10);
		txtNameFilter.setBounds(429, 127, 214, 26);
		panel.add(txtNameFilter);
		txtNameFilter.getDocument().addDocumentListener(new DocumentListener() {


			public void insertUpdate(DocumentEvent e) {
				searchStockFilter(txtNameFilter.getText(),"name");
			}


			public void removeUpdate(DocumentEvent e) {
				searchStockFilter(txtNameFilter.getText(),"name");			
			}


			public void changedUpdate(DocumentEvent e) {
				searchStockFilter(txtNameFilter.getText(),"name");
			}
		});
		
		
	}
	
	class CheckBoxHandler implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			 int selectedRow = table.getSelectedRow();  
			 int selectedCol = table.getSelectedColumn();
			 if(selectedCol==4) {
				 if(flag.equals("ManageItemBalanceFrame")){
						StockBalance sb = new StockBalance();
						sb.setStockInId((String)dtm.getValueAt(selectedRow, 1));
						sb.setStockName((String)dtm.getValueAt(selectedRow, 2));
						sb.setStockInDate((String)dtm.getValueAt(selectedRow, 3));
						Conversation.addConversation("editStock", sb);
						DetailItemBalanceFrame detailItemBalanceFrame = DetailItemBalanceFrame.getInstance();
						searchItemBalanceFrame.setVisible(false);
						searchItemBalanceFrame = null;
				 }
				 else {
						StockBalance sb = new StockBalance();
						sb.setStockInId((String)dtm.getValueAt(selectedRow, 1));
						sb.setStockName((String)dtm.getValueAt(selectedRow, 2));
						sb.setStockInDate((String)dtm.getValueAt(selectedRow, 3));

						Conversation.addConversation("Produce_Style", sb);
						if(flag.equals("Style_Detail")) {
							StyleDetailFrame styleDetailFrame = StyleDetailFrame.getInstance();
							styleDetailFrame.setChooseValue(sb.getStockInId(),sb.getStockName());
							searchItemBalanceFrame.setVisible(false);
							searchItemBalanceFrame = null;
						}
						else {
							InventoryManageFrame inventoryManageFrame = InventoryManageFrame.getInstance();
							inventoryManageFrame.setChooseValue(sb.getStockInId(),sb.getStockName());
							searchItemBalanceFrame.setVisible(false);
							searchItemBalanceFrame = null;
						}
				 }

			 }
		}

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
	
    private void overrideDefaultTableModle(){
    	dtm = new DefaultTableModel() {
    		
     	    public boolean isCellEditable(int row, int col) {
     	        //Note that the data/cell address is constant,
     	        //no matter where the cell appears onscreen.
     	        if (col >= 0 && col <=3) {
     	            return false;
     	        } else {
     	            return true;
     	        }
     	    }
    	};
    }
	
	public void searchStockFilter(String filterKey, String type) {
		List<StockBalance> resultList = new ArrayList<StockBalance>();
		if(StringUtils.isBlank(filterKey)){
			removeAllRow();
		}
		else {
			iBalanceServiceManger = (IBalanceServiceManager) BasicBeanFactory.getBean("BalanceServiceManager");
			try {
				if(type.equals("name")) {
					resultList = iBalanceServiceManger.searchByNameFilter(filterKey);
				}
				else {
					resultList = iBalanceServiceManger.searchByFilter(filterKey);
				}
				int i = 0;
				removeAllRow();
				if(flag.equals("ManageItemBalanceFrame")) {
					for(StockBalance sb : resultList) {
						dtm.addRow(new Object[]{
								i+1,
								sb.getStockInId(),
								sb.getStockName(),
								sb.getStockInDate(),
								"Detail",
						});
						i++;
					}
				}
				else {
					for(StockBalance sb : resultList) {
						dtm.addRow(new Object[]{
								i+1,
								sb.getStockInId(),
								sb.getStockName(),
								sb.getStockInDate(),
								"Choose"
						});
						i++;
					}
				}
				

			}
			catch(Exception ex) {
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
}
