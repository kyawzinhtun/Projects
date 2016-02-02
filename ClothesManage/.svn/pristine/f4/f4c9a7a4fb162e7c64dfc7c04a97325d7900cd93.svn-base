package org.amaris.presentation.inventoryManageForm;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JTextField;
import org.amaris.presentation.BalanceManageForm.ButtonDeleteStock;
import org.amaris.presentation.BalanceManageForm.SearchItemBalanceFrame;
import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.balanceManage.IBalanceServiceManager;
import org.amaris.service.balanceManage.StockBalance;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.service.inventoryManage.InventoryItem;
import org.amaris.service.inventoryManage.Style;
import org.amaris.service.inventoryManage.StyleInclude;
import org.amaris.util.AValidator;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.apache.commons.lang.StringUtils;
import org.jdesktop.swingx.JXDatePicker;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollBar;


public class InventoryManageFrame extends JFrame{

	public static InventoryManageFrame inventoryManageFrameFrame;
	private IBalanceServiceManager iBalanceServiceManger;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	private JPanel contentPane;
	private JLabel itemName;
	private JLabel imgPath;
	private JLabel remarks;
	private JTextField txtStyleName;
	private JTextField txtImgPath;
	private JTextField txtRemarks;
	private JLabel lblHome;
	private JLabel lblEdit;
	private JLabel lblSearch;
	private JXDatePicker datePicker = new JXDatePicker();
	private IInventoryServiceManager inventoryServiceManager;
	private JButton btnSave;
	private JFileChooser fileChooser = new JFileChooser();
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private JTable table;
	private DefaultTableModel dtm;
	public int rowCount=0;
	private JScrollPane scrollPane;
	private JLabel lblMaterials;
	private JTextField txtStockInId;
	private JLabel lblSize;
	private JTextField txtStyleSize;
	private JButton btnAdd;
	private JButton btnSearch;
	private JTextField txtStockName;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryManageFrame frame = new InventoryManageFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static InventoryManageFrame getInstance() {
		if (inventoryManageFrameFrame == null) {
			inventoryManageFrameFrame = new InventoryManageFrame();
			inventoryManageFrameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			inventoryManageFrameFrame.setVisible(true);
			inventoryManageFrameFrame.setResizable(false);
			return inventoryManageFrameFrame;
		}
		inventoryManageFrameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		inventoryManageFrameFrame.setVisible(true);
		inventoryManageFrameFrame.setResizable(false);		
		return inventoryManageFrameFrame;
	}

	/**
	 * Create the frame.
	 */
	public InventoryManageFrame() {
		
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
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Produce Stype", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 11, 1336, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("Create Style");
		lblLogo.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblLogo.setBounds(20, 60, 216, 24);
		panel.add(lblLogo);
		
		itemName = new JLabel("Style Code");
		itemName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		itemName.setBounds(25, 188, 152, 24);
		panel.add(itemName);
		
		imgPath = new JLabel("Image Path");
		imgPath.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		imgPath.setBounds(25, 249, 152, 36);
		panel.add(imgPath);
		
		remarks = new JLabel("Remark");
		remarks.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		remarks.setBounds(25, 318, 125, 24);
		panel.add(remarks);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblDate.setBounds(25, 384, 125, 24);
		panel.add(lblDate);
		
		txtStyleName = new JTextField();
		txtStyleName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave.doClick();
			}
		});
		txtStyleName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtStyleName.setColumns(10);
		txtStyleName.setBounds(187, 182, 229, 36);
		panel.add(txtStyleName);
		
		txtImgPath = new JTextField();
		txtImgPath.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtImgPath.setColumns(10);
		txtImgPath.setBounds(187, 253, 229, 36);
		panel.add(txtImgPath);
		
		txtRemarks = new JTextField();
		txtRemarks.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtRemarks.setColumns(10);
		txtRemarks.setBounds(187, 312, 229, 36);
		panel.add(txtRemarks);
		
		datePicker.setDate(Calendar.getInstance().getTime());
		datePicker.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
		datePicker.setBounds(187, 378, 229, 36);
		datePicker.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        panel.add(datePicker);
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame mainFrame = MainFrame.getInstance();
				inventoryManageFrameFrame.setVisible(false);
				inventoryManageFrameFrame = null;
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
				Conversation.addConversation("Flag", "InventoryManageFrame");
				StyleSearchFrame styleSearchFrame = StyleSearchFrame.getInstance();
				inventoryManageFrameFrame.setVisible(false);
				inventoryManageFrameFrame = null;
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
				if(StringUtils.isBlank(txtStyleName.getText())) {
					JOptionPane.showMessageDialog(null, "Style Name is require to fill.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(StringUtils.isBlank(txtStyleSize.getText())) {
					JOptionPane.showMessageDialog(null, "Style sizes are require to fill.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					Style style = new Style();
					style.setStyleName(txtStyleName.getText());
					style.setImagePath(txtImgPath.getText());
					style.setRemark(txtRemarks.getText());
					style.setSize(txtStyleSize.getText());
					style.setStyleProduceDate(formatter.format(datePicker.getDate()));
					List<StyleInclude> includeList = new ArrayList<StyleInclude>();
					int i=0;
					if(dtm.getRowCount()!=0) {
						while(i<dtm.getRowCount()) {
							StyleInclude si = new StyleInclude();
							si.setStockInId(dtm.getValueAt(i, 1)+"");
							si.setStockName(dtm.getValueAt(i, 2)+"");
							si.setStyleCode(txtStyleName.getText());
							includeList.add(si);
							style.setStyleIncludeList(includeList);
							i++;
						}
						saveInvItem(style);
						JOptionPane.showMessageDialog(null, "Style produce process is success",
								"Info", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "Include list can not be '0'.",
								"Error Info", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnSave.setBounds(20, 544, 125, 45);
		panel.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtImgPath.setText("");
				txtStyleName.setText("");
				txtRemarks.setText("");
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnClear.setBounds(187, 544, 132, 45);
		panel.add(btnClear);
		
		JButton btBrowseButton = new JButton("Browse");
		btBrowseButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btBrowseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {					
					txtImgPath.setText(fileChooser.getSelectedFile() + "");
				}
			}
		});
		btBrowseButton.setBounds(428, 253, 134, 36);
		panel.add(btBrowseButton);
		
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
		panel_1.setBounds(602, 375, 646, 294);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		String[] columnNames = {
                "No",
                "StockInId",
                "StockName",
                "Size",
                "Action"
        };
		
		Object[][] data={};
        dtm.setDataVector(data, columnNames);
		
		table = new JTable();
		table.setBounds(25, 29, 598, 251);
		
        scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 30, 598, 250);
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
		table.addMouseListener(new CheckBoxHandler());
		
		table.getColumn("Action").setCellRenderer(new ButtonRenderer());
		table.getColumn("Action").setCellEditor(new ButtonDeleteStock(new JCheckBox()));
		scrollPane.setViewportView(table);
		
		lblMaterials = new JLabel("Stock In Id");
		lblMaterials.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblMaterials.setBounds(602, 249, 152, 36);
		panel.add(lblMaterials);
		
		txtStockInId = new JTextField();
		txtStockInId.setEnabled(false);
		txtStockInId.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtStockInId.setColumns(10);
		txtStockInId.setBounds(772, 249, 229, 36);
		panel.add(txtStockInId);
		
		txtStockInId.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			
			}
			
		});
		
		lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblSize.setBounds(20, 460, 62, 24);
		panel.add(lblSize);
		
		txtStyleSize = new JTextField();
		txtStyleSize.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtStyleSize.setColumns(10);
		txtStyleSize.setBounds(187, 448, 229, 36);
		panel.add(txtStyleSize);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.addRow(new Object[]{
						rowCount+1,
						txtStockInId.getText(),
						txtStockName.getText(),
						txtStyleSize.getText(),
						"Remove"
					});
					rowCount += 1;
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnAdd.setBounds(1024, 312, 134, 36);
		panel.add(btnAdd);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conversation.addConversation("Flag", "Style");
				SearchItemBalanceFrame searchItemBalanceFrame = SearchItemBalanceFrame.getInstance();
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnSearch.setBounds(1024, 249, 134, 36);
		panel.add(btnSearch);
		
		JLabel lblStockName = new JLabel("Stock Name");
		lblStockName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblStockName.setBounds(602, 312, 152, 36);
		panel.add(lblStockName);
		
		txtStockName = new JTextField();
		txtStockName.setEnabled(false);
		txtStockName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtStockName.setColumns(10);
		txtStockName.setBounds(772, 306, 229, 36);
		panel.add(txtStockName);
		
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
     	        if (col >= 0 && col <=3) {
     	            return false;
     	        } else {
     	            return true;
     	        }
     	    }
    	};
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
	
	class CheckBoxHandler implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			 int selectedRow = table.getSelectedRow();  
			 int selectedCol = table.getSelectedColumn();

			 if(selectedCol == 4) {
				 dtm.removeRow(selectedRow);
				 rowCount -=1;
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
	
	public void setChooseValue(String stockInId, String stockName) {
		txtStockInId.setText(stockInId);
		txtStockName.setText(stockName);
		}
}
