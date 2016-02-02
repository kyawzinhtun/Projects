package org.amaris.presentation.inventoryManageForm;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.amaris.presentation.BalanceManageForm.ButtonDetailStock;
import org.amaris.presentation.BalanceManageForm.DetailItemBalanceFrame;
import org.amaris.presentation.BalanceManageForm.ManageItemBalanceFrame;
import org.amaris.presentation.BalanceManageForm.SearchItemBalanceFrame;
import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.balanceManage.IBalanceServiceManager;
import org.amaris.service.balanceManage.StockBalance;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.service.inventoryManage.Style;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.apache.commons.lang.StringUtils;

public class StyleSearchFrame extends JFrame {

	public static StyleSearchFrame styleSearchFrame;
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
	private JTextField searchKeyWords;
	private String flag;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StyleSearchFrame frame = new StyleSearchFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static StyleSearchFrame getInstance() {
		if (styleSearchFrame == null) {
			styleSearchFrame = new StyleSearchFrame();
			styleSearchFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			styleSearchFrame.setVisible(true);
			styleSearchFrame.setResizable(false);
			return styleSearchFrame;
		}
		styleSearchFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		styleSearchFrame.setVisible(true);
		styleSearchFrame.setResizable(false);		
		return styleSearchFrame;
	}

	/**
	 * Create the frame.
	 */
	public StyleSearchFrame() {
		
		inventorySerivceManger = (IInventoryServiceManager) BasicBeanFactory.getBean("InventoryServiceManager");
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
		
		JLabel lblLogo = new JLabel("Style Searching");
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
                "Style Code",
                "Image",
                "Remark",
                "Produce Date",
                "Size",
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
		table.getColumnModel().getColumn(5).setCellRenderer(r);
		table.getColumnModel().getColumn(6).setCellRenderer(r);
		
		// add button at update column 
		table.getColumn("Action").setCellRenderer(new ButtonRenderer());
		table.getColumn("Image").setCellRenderer(new ImageRender());
		
		table.getColumn("Action").setCellEditor(new ButtonDetailStock(new JCheckBox()));
		scrollPane.setViewportView(table);
		table.setRowHeight(50);
		
		JLabel lblNewLabel = new JLabel("Filter");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setBounds(20, 127, 66, 26);
		panel.add(lblNewLabel);
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame mainFrame = MainFrame.getInstance();
				styleSearchFrame.setVisible(false);
				styleSearchFrame = null;
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
				InventoryManageFrame inventoryManageFrame = InventoryManageFrame.getInstance();
				styleSearchFrame.setVisible(false);
				styleSearchFrame = null;
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
		searchKeyWords.setBounds(97, 127, 159, 26);
		searchKeyWords.setColumns(10);
		panel.add(searchKeyWords);
		searchKeyWords.getDocument().addDocumentListener(new DocumentListener() {


			public void insertUpdate(DocumentEvent e) {
				searchStockFilter(searchKeyWords.getText());
			}


			public void removeUpdate(DocumentEvent e) {
				searchStockFilter(searchKeyWords.getText());			
			}


			public void changedUpdate(DocumentEvent e) {
				searchStockFilter(searchKeyWords.getText());
			}
		});
		
		initializedDate();
	}
	
	class CheckBoxHandler implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			 int selectedRow = table.getSelectedRow();  
			 int selectedCol = table.getSelectedColumn();
			 if(selectedCol==6) {
				 Conversation.addConversation("Style_Detail", dtm.getValueAt(selectedRow, 1)+"");
				 StyleDetailFrame styleDetailFrame = StyleDetailFrame.getInstance();
				 styleSearchFrame.setVisible(false);
				 styleSearchFrame = null;
			 }
			 else if(selectedCol==2) {
				 Conversation.addConversation("Style_Detail", dtm.getValueAt(selectedRow, 1)+"");
				 ImagePreview imagePreview = ImagePreview.getInstance();
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
	
    private void overrideDefaultTableModle(){
    	dtm = new DefaultTableModel() {
    		
     	    public boolean isCellEditable(int row, int col) {
     	        //Note that the data/cell address is constant,
     	        //no matter where the cell appears onscreen.
     	        if (col >= 0 && col <=5) {
     	        	if(col==2) {
     	        		return true;
     	        	}
     	            return false;
     	        } else {
     	            return true;
     	        }
     	    }
    	};
    }
    
    public void initializedDate() {
    	removeAllRow();
    	List<Style> resultList = new ArrayList<Style>();
			resultList = inventorySerivceManger.findAll();
			int i=0;
			for(Style style : resultList) {
				dtm.addRow(new Object[]{
						i+1,
						style.getStyleName(),
						style.getImagePath(),
						style.getRemark(),
						style.getStyleProduceDate(),
						style.getSize(),
						"Detail",
				});
				ImageIcon icon = new ImageIcon(style.getImagePath());
				dtm.setValueAt(icon, i, 2);
				i++;
			}
    }
	
	public void searchStockFilter(String filterKey) {
		List<Style> resultList = new ArrayList<Style>();
		if(StringUtils.isBlank(filterKey)){
			removeAllRow();
			initializedDate();
		}
		else {
			try {
				resultList = inventorySerivceManger.findFilterStyle(filterKey);
				int i = 0;
				removeAllRow();
					for(Style style : resultList) {
						dtm.addRow(new Object[]{
								i+1,
								style.getStyleName(),
								style.getImagePath(),
								style.getRemark(),
								style.getStyleProduceDate(),
								style.getSize(),
								"Detail",
						});
						ImageIcon icon = new ImageIcon(style.getImagePath());
						dtm.setValueAt(icon, i, 2);
						i++;
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
