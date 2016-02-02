package org.amaris.presentation.BalanceManageForm;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.amaris.presentation.inventoryManageForm.ButtonRenderer;
import org.amaris.presentation.inventoryManageForm.InventorySearchFrame;
import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.balanceManage.IBalanceServiceManager;
import org.amaris.service.balanceManage.StockBalance;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.service.inventoryManage.InventoryItem;
import org.amaris.util.AValidator;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.apache.commons.lang.StringUtils;
import org.jdesktop.swingx.JXDatePicker;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;


public class ManageItemBalanceFrame extends JFrame {

	public static ManageItemBalanceFrame manageItemBalance;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private JTextField txtStockName;
	private JTextField txtTotalStockPrice;
	private JTextField txtPerPrice;
	private JTable table;
	private DefaultTableModel dtm;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private JXDatePicker datePicker = new JXDatePicker();
	private HashMap<String, String> comboMap = new HashMap<String, String>();
	private JLabel lblHome;
	private JLabel lblSearch;
	private IBalanceServiceManager iBalanceServiceManger;
	public int rowCount=0;
	private JButton btnSave;
	private JTextField txtSecond;
	private JTextField txtFirst;
	private JTextField txtStockIn;
	private JTextField txtNoColor;
	private JLabel lblSeond;
	private JLabel lblFirst;
	private JLabel lblTotalYards;
	private JTextField txtTotalYard;
	JButton btnCalculate = new JButton("Calculate");
	private JLabel lblTotalQty;
	private JTextField unitPrice;
	JLabel lblPerUnitPrice;
	JComboBox cboStockType;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageItemBalanceFrame frame = new ManageItemBalanceFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static ManageItemBalanceFrame getInstance() {
		if (manageItemBalance == null) {
			manageItemBalance = new ManageItemBalanceFrame();
			manageItemBalance.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			manageItemBalance.setVisible(true);
			manageItemBalance.setResizable(false);
			return manageItemBalance;
		}
		manageItemBalance.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		manageItemBalance.setVisible(true);
		manageItemBalance.setResizable(false);		
		return manageItemBalance;
	}

	/**
	 * Create the frame.
	 */
	public ManageItemBalanceFrame() {
		
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1376, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		iBalanceServiceManger = (IBalanceServiceManager) BasicBeanFactory.getBean("BalanceServiceManager");
		overrideDefaultTableModle();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Stock Balance Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 1346, 687);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("Stock In");
		lblLogo.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblLogo.setBounds(20, 40, 285, 24);
		panel.add(lblLogo);
		
		JLabel lblStock = new JLabel("Stock Name");
		lblStock.setFont(new Font("Arial", Font.PLAIN, 14));
		lblStock.setBounds(20, 122, 171, 36);
		panel.add(lblStock);
		
		JLabel lblStockPrice = new JLabel("Per Price");
		lblStockPrice.setFont(new Font("Arial", Font.PLAIN, 14));
		lblStockPrice.setBounds(20, 263, 108, 36);
		panel.add(lblStockPrice);
		
		txtStockName = new JTextField();
		txtStockName.setFont(new Font("Arial", Font.PLAIN, 14));
		txtStockName.setColumns(10);
		txtStockName.setBounds(184, 123, 273, 34);
		panel.add(txtStockName);
		
		txtSecond = new JTextField();
		txtSecond.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSecond.setColumns(10);
		txtSecond.setBounds(184, 541, 273, 34);
		panel.add(txtSecond);
		
		txtFirst = new JTextField();
		txtFirst.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFirst.setColumns(10);
		txtFirst.setBounds(184, 495, 273, 34);
		panel.add(txtFirst);
		
		txtTotalStockPrice = new JTextField();
		txtTotalStockPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave.doClick();
			}
		});
		txtTotalStockPrice.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTotalStockPrice.setColumns(10);
		txtTotalStockPrice.setBounds(184, 353, 273, 34);
		panel.add(txtTotalStockPrice);
		
		lblSeond = new JLabel("Total Unit");
		lblSeond.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeond.setBounds(20, 541, 98, 36);
		panel.add(lblSeond);
		
		lblFirst = new JLabel("Convertion");
		lblFirst.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFirst.setBounds(20, 494, 108, 36);
		panel.add(lblFirst);
		
		lblTotalQty = new JLabel("Total Quantity");
		lblTotalQty.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTotalQty.setBounds(20, 310, 127, 36);
		lblTotalQty.setVisible(true);
		panel.add(lblTotalQty);
		
		lblTotalYards = new JLabel("Total Yards");
		lblTotalYards.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTotalYards.setBounds(20, 310, 127, 36);
		panel.add(lblTotalYards);
		
		txtTotalYard = new JTextField();
		txtTotalYard.setEnabled(true);
		txtTotalYard.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTotalYard.setColumns(10);
		txtTotalYard.setBounds(184, 307, 273, 34);
		panel.add(txtTotalYard);
		
		txtPerPrice = new JTextField();
		txtPerPrice.setFont(new Font("Arial", Font.PLAIN, 14));
		txtPerPrice.setColumns(10);
		txtPerPrice.setBounds(184, 261, 273, 34);
		panel.add(txtPerPrice);
		
		lblPerUnitPrice = new JLabel("Unit Price");
		lblPerUnitPrice.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPerUnitPrice.setBounds(20, 589, 91, 29);
		panel.add(lblPerUnitPrice);
		
		unitPrice = new JTextField();
		unitPrice.setFont(new Font("Arial", Font.PLAIN, 14));
		unitPrice.setBounds(184, 588, 273, 33);
		panel.add(unitPrice);
		unitPrice.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				txtPerPrice.setText("");
				txtTotalYard.setText("");
				txtTotalStockPrice.setText("");
				String selectedItem = comboBox.getSelectedItem()+"";
				if(selectedItem.equals("1 Pack")) {
					lblFirst.setEnabled(false);
					lblSeond.setEnabled(false);
					txtSecond.setEnabled(false);
					txtFirst.setEnabled(true);
					txtSecond.setText("");
					txtFirst.setText("");
//					lblInclude.setVisible(false);
//					lblInclude.setBounds(916, 212, 143, 36);
					txtTotalYard.setEditable(true);
					lblTotalYards.setVisible(false);
					lblTotalQty.setVisible(true);
					lblPerUnitPrice.setEnabled(false);
					unitPrice.setEnabled(false);
				}
				else if(selectedItem.equals("1 Yard")) {
					txtTotalYard.setEditable(true);
//					lblInclude.setVisible(false);
					txtSecond.setEnabled(false);
					txtFirst.setEnabled(false);
					txtSecond.setText("");
					txtFirst.setText("");
					lblSeond.setEnabled(false);
					lblFirst.setEnabled(false);
					lblTotalQty.setVisible(false);
					lblTotalYards.setVisible(true);
					lblPerUnitPrice.setEnabled(false);
					unitPrice.setEnabled(false);
				}
				else if(selectedItem.equals("1 KG")) {
					txtSecond.setEnabled(true);
					txtFirst.setEnabled(true);
					txtSecond.setText("");
					txtFirst.setText("");
//					lblInclude.setVisible(false);
					txtTotalYard.setEditable(false);
					lblSeond.setEnabled(true);
					lblFirst.setEnabled(true);
					lblTotalQty.setVisible(false);
					lblTotalYards.setVisible(true);
					lblPerUnitPrice.setEnabled(true);
					unitPrice.setEnabled(true);
				}
				else if(selectedItem.equals("1 Meter")) {
					txtSecond.setEnabled(true);
					txtFirst.setEnabled(true);
					txtSecond.setText("");
					txtFirst.setText("");
//					lblInclude.setVisible(false);
					txtTotalYard.setEditable(false);
					lblFirst.setEnabled(true);
					lblSeond.setEnabled(true);
					lblTotalQty.setVisible(false);
					lblTotalYards.setVisible(true);
					lblPerUnitPrice.setEnabled(true);
					unitPrice.setEnabled(true);
				}
				else {
					txtSecond.setEnabled(false);
					txtSecond.setText("");
					lblSeond.setEnabled(false);
					lblFirst.setEnabled(false);
//					lblInclude.setVisible(false);
					txtFirst.setEnabled(false);
					txtFirst.setText("");
					lblTotalQty.setVisible(true);
					lblTotalYards.setVisible(false);
					txtTotalYard.setEditable(true);
					lblPerUnitPrice.setEnabled(false);
					unitPrice.setEnabled(false);
				}
			}
		});
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(184, 449, 273, 34);
		panel.add(comboBox);
		
		comboBox.addItem("1 Unit");
		comboBox.addItem("1 Pack");
		comboBox.addItem("1 Yard");
		comboBox.addItem("1 KG");
		comboBox.addItem("1 Meter");
		
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTotalPrice.setBounds(20, 357, 127, 36);
		panel.add(lblTotalPrice);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDate.setBounds(20, 169, 91, 36);
		panel.add(lblDate);
		datePicker.getEditor().setFont(new Font("Arial", Font.PLAIN, 14));
		
		datePicker.setDate(Calendar.getInstance().getTime());
		datePicker.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
		datePicker.setBounds(184, 169, 273, 34);
		datePicker.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        panel.add(datePicker);
		
        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowCount = 0;
				if(StringUtils.isBlank(txtStockName.getText())) {
					JOptionPane.showMessageDialog(null, "Stock Name is required!.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				} 
				else if(StringUtils.isBlank(txtTotalStockPrice.getText())) {
					JOptionPane.showMessageDialog(null, "Stock Price is required!.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "Must add in table.",
							"Error Info", JOptionPane.ERROR_MESSAGE);
					removeAllRow();
					clear();
				}
				else {
					int i=0;
					List<BalanceDetail> stockDetailList = new ArrayList<BalanceDetail>();
					StockBalance stockBalance = new StockBalance();
					stockBalance.setStockInId(txtStockIn.getText());
					stockBalance.setStockName(txtStockName.getText());
					//stockBalance.setNoColor(txtNoColor.getText());
					stockBalance.setStockInDate(formatter.format(datePicker.getDate()));
					stockBalance.setUnit(comboBox.getSelectedItem()+"");
					if(cboStockType.getSelectedItem().toString()=="Accessories"){
						stockBalance.setAccessoriesType(true);
					}else{
						stockBalance.setAccessoriesType(false);
					}
					while(i<dtm.getRowCount()) {
						BalanceDetail balanceDetail = new BalanceDetail();
						balanceDetail.setColorNo(dtm.getValueAt(i, 2)+"");
						balanceDetail.setStockPrice(dtm.getValueAt(i, 5)+"");
						balanceDetail.setDetailUnitCount(dtm.getValueAt(i, 6)+"");
						balanceDetail.setStockQuantity(dtm.getValueAt(i, 3)+"");
						balanceDetail.setTotalPrice(dtm.getValueAt(i, 7)+"");
						stockDetailList.add(balanceDetail);
						i++;
					}
					stockBalance.setBalanceDetail(stockDetailList);
					saveStock(stockBalance);
					JOptionPane.showMessageDialog(null, "Successfully Insert Stock.",
							"Success Info", JOptionPane.INFORMATION_MESSAGE);
					removeAllRow();
					clear();
				}

			}
		});
        btnSave.setFont(new Font("Arial", Font.PLAIN, 14));
        btnSave.setBounds(480, 636, 127, 36);
		panel.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTotalStockPrice.setText("");
				txtPerPrice.setText("");
				txtStockName.setText("");
			}
		});
		btnClear.setFont(new Font("Arial", Font.PLAIN, 14));
		btnClear.setBounds(627, 636, 127, 36);
		panel.add(btnClear);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StringUtils.isBlank(txtStockName.getText())) {
					JOptionPane.showMessageDialog(null, "Stock Name is required!.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				} 
				else if(StringUtils.isBlank(txtTotalStockPrice.getText())) {
					JOptionPane.showMessageDialog(null, "Stock Total Price is required!.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(StringUtils.isBlank(txtNoColor.getText())) {
					JOptionPane.showMessageDialog(null, "Color is required!.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(StringUtils.isBlank(txtTotalYard.getText())) {
					JOptionPane.showMessageDialog(null, "Quantity is required!.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(StringUtils.isBlank(txtPerPrice.getText())) {
					JOptionPane.showMessageDialog(null, "Stock Per Price is required!.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					preSavingTable();
				}
				
			}
		});
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAdd.setBounds(184, 636, 127, 36);
		panel.add(btnAdd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Stock List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(480, 169, 856, 451);
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
		
        
		String[] columnNames = {
                "No",
                "Name",
                "Color",
                "Quantity",
                "Unit",
                "Price",
                "Convertion",
                "Total Price",
                "Action"
        };
		
		Object[][] data={};
        dtm.setDataVector(data, columnNames);
		
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 21, 836, 419);
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
//		table.getColumnModel().getColumn(6).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(7).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(8).setCellRenderer(cellRenderer);
		table.addMouseListener(new CheckBoxHandler());
		
		table.getColumn("Action").setCellRenderer(new ButtonRenderer());
		table.getColumn("Action").setCellEditor(new ButtonDeleteStock(new JCheckBox()));
		scrollPane.setViewportView(table);
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame mainFrame = MainFrame.getInstance();
				manageItemBalance.setVisible(false);
				manageItemBalance = null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		lblHome.setBounds(1056, 26, 150, 150);
		panel.add(lblHome);
		
		
		lblSearch = new JLabel(new ImageIcon("img/search.png"));
		lblSearch.setToolTipText("Search Item");
		lblSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Conversation.addConversation("Flag", "ManageItemBalanceFrame");
				SearchItemBalanceFrame searchItemBalanceFrame = SearchItemBalanceFrame.getInstance();
				manageItemBalance.setVisible(false);
				manageItemBalance = null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		lblSearch.setBounds(1186, 11, 150, 150);
		panel.add(lblSearch);
		
		JLabel lblStockInId = new JLabel("Stock In ID");
		lblStockInId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblStockInId.setBounds(20, 75, 171, 36);
		panel.add(lblStockInId);
		
		txtStockIn = new JTextField();
		txtStockIn.setFont(new Font("Arial", Font.PLAIN, 14));
		txtStockIn.setColumns(10);
		txtStockIn.setBounds(184, 77, 273, 34);
		panel.add(txtStockIn);
		txtStockIn.setText(getLastID());
		
		JLabel lblNoOfColor = new JLabel("No of Color");
		lblNoOfColor.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNoOfColor.setBounds(20, 216, 154, 36);
		panel.add(lblNoOfColor);
		
		txtNoColor = new JTextField();
		txtNoColor.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNoColor.setColumns(10);
		txtNoColor.setBounds(184, 215, 273, 34);
		panel.add(txtNoColor);
		
		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUnit.setBounds(20, 447, 64, 36);
		panel.add(lblUnit);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = comboBox.getSelectedItem()+"";
				String sTotalYard = txtTotalYard.getText();
				String sPerPrice = txtPerPrice.getText();
				String sTotalPrice = txtTotalStockPrice.getText();
				try {
					if(selectedItem.equals("1 Pack")) {
						if(!StringUtils.isBlank(sTotalYard)& !StringUtils.isBlank(sPerPrice)) {
							double dTotalYard = Double.parseDouble(sTotalYard);
							double dPerPrice = Double.parseDouble(sPerPrice);
							double dTotalPrice = dPerPrice * dTotalYard;
							txtTotalStockPrice.setText(dTotalPrice+"");
						}
						else if(!StringUtils.isBlank(sTotalYard) & !StringUtils.isBlank(sTotalPrice)) {
							double dTotalYard = Double.parseDouble(sTotalYard);
							double dTotalPrice = Double.parseDouble(sTotalPrice);
							double dPerPrice = dTotalPrice /dTotalYard;
							txtPerPrice.setText(dPerPrice+"");
						}
						
					}
					else if(selectedItem.equals("1 Yard")) {
						if(!StringUtils.isBlank(sTotalYard)& !StringUtils.isBlank(sPerPrice)) {
							double dTotalYard = Double.parseDouble(sTotalYard);
							double dPerPrice = Double.parseDouble(sPerPrice);
							double dTotalPrice = dPerPrice * dTotalYard;
							txtTotalStockPrice.setText(dTotalPrice+"");
						}
						else if(!StringUtils.isBlank(sTotalYard) & !StringUtils.isBlank(sTotalPrice)) {
							double dTotalYard = Double.parseDouble(sTotalYard);
							double dTotalPrice = Double.parseDouble(sTotalPrice);
							double dPerPrice = dTotalPrice /dTotalYard;
							txtPerPrice.setText(dPerPrice+"");
						}
					}
					else if(selectedItem.equals("1 KG")) {
						if(!StringUtils.isBlank(txtFirst.getText())& !StringUtils.isBlank(txtSecond.getText())) {
							double dFirst = Double.parseDouble(txtFirst.getText());
							double dSecond = Double.parseDouble(txtSecond.getText());
							double dTotalYard = dFirst * dSecond;
							txtTotalYard.setText(dTotalYard+"");
							
							if(!StringUtils.isBlank(txtFirst.getText())& !StringUtils.isBlank(txtSecond.getText())
									& !StringUtils.isBlank(unitPrice.getText())
									& StringUtils.isBlank(txtTotalStockPrice.getText())) {
								double dPerPrice = Double.parseDouble(unitPrice.getText());
								double dTotalPrice = dPerPrice * dSecond;
								txtTotalStockPrice.setText(dTotalPrice+"");
								
							}
							else if(!StringUtils.isBlank(sTotalYard) & !StringUtils.isBlank(sTotalPrice)) {
								double dTotalPrice = Double.parseDouble(sTotalPrice);
								double dPerPrice = dTotalPrice /dTotalYard;
								txtPerPrice.setText(dPerPrice+"");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Calculate field must fill",
									"Error Info", JOptionPane.ERROR_MESSAGE);
						}

					}
					else if(selectedItem.equals("1 Meter")) {
						if(!StringUtils.isBlank(txtFirst.getText())& !StringUtils.isBlank(txtSecond.getText())) {
							double dFirst = Double.parseDouble(txtFirst.getText());
							double dSecond = Double.parseDouble(txtSecond.getText());
							double dTotalYard = dFirst * dSecond;
							txtTotalYard.setText(dTotalYard+"");
							
							if(!StringUtils.isBlank(txtFirst.getText())& !StringUtils.isBlank(txtSecond.getText())
									& !StringUtils.isBlank(unitPrice.getText())
									& StringUtils.isBlank(txtTotalStockPrice.getText())) {
								double dPerPrice = Double.parseDouble(unitPrice.getText());
								double dTotalPrice = dPerPrice * dSecond;
								txtTotalStockPrice.setText(dTotalPrice+"");
								
							}
							else if(!StringUtils.isBlank(sTotalYard) & !StringUtils.isBlank(sTotalPrice)) {
								double dTotalPrice = Double.parseDouble(sTotalPrice);
								double dPerPrice = dTotalPrice /dTotalYard;
								txtPerPrice.setText(dPerPrice+"");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Calculate field must fill",
									"Error Info", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						if(!StringUtils.isBlank(sTotalYard)& !StringUtils.isBlank(sPerPrice)) {
							double dTotalYard = Double.parseDouble(sTotalYard);
							double dPerPrice = Double.parseDouble(sPerPrice);
							double dTotalPrice = dPerPrice * dTotalYard;
							txtTotalStockPrice.setText(dTotalPrice+"");
						}
						else if(!StringUtils.isBlank(sTotalYard) & !StringUtils.isBlank(sTotalPrice)) {
							double dTotalYard = Double.parseDouble(sTotalYard);
							double dTotalPrice = Double.parseDouble(sTotalPrice);
							double dPerPrice = dTotalPrice /dTotalYard;
							txtPerPrice.setText(dPerPrice+"");
						}
					}
				}
				catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Fail Number for calculate!.",
								"Error Info", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		btnCalculate.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCalculate.setBounds(330, 636, 127, 36);
		btnCalculate.setVisible(true);
		panel.add(btnCalculate);
		
		JLabel lblStockType = new JLabel("Stock Type");
		lblStockType.setFont(new Font("Arial", Font.PLAIN, 14));
		lblStockType.setBounds(20, 404, 143, 36);
		panel.add(lblStockType);
		
		cboStockType = new JComboBox();
		cboStockType.setModel(new DefaultComboBoxModel(new String[] {"Accessories", "Main Item"}));
		cboStockType.setFont(new Font("Arial", Font.PLAIN, 14));
		cboStockType.setBounds(184, 400, 273, 36);
		panel.add(cboStockType);
	
	}
	
	private void overrideDefaultTableModle(){
    	dtm = new DefaultTableModel() {
    		
    	   @Override
     	    public boolean isCellEditable(int row, int col) {
     	        //Note that the data/cell address is constant,
     	        //no matter where the cell appears onscreen.
     	        if (col >= 0 && col <=6) {
     	            return false;
     	        } else {
     	            return true;
     	        }
     	    }
    	};
    }

	
	public String getLastID() {
		String id="";
		try {
			id = iBalanceServiceManger.getLastGenId();
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
	
	public void preSavingTable() {
		String colorNo = txtNoColor.getText();
		String stockName = txtStockName.getText();
		String totalStockPrice = txtTotalStockPrice.getText();
		String perPrice = txtPerPrice.getText();
		String stockUnit = (String)comboBox.getSelectedItem();
		String totalQty = txtTotalYard.getText();
		String first = txtFirst.getText();
		String second = txtSecond.getText();
		String convertion = first +"->" +second;
		String sunitPrice = unitPrice.getText();
		
		if(stockUnit.equals("1 KG")) {
			convertion = "1 KG "+ convertion + "KG" + ", Price : "+sunitPrice ;
		}
		else if(stockUnit.equals("1 Meter")) {
			convertion = "1 Meter "+ convertion + "Meter"+ ", Price : "+sunitPrice;
		}
		else if(stockUnit.equals("1 Pack")) {
			convertion = "1 Pack";
		}
		else if(stockUnit.equals("1 Yard")) {
			convertion = "Yards";
		}
		else {
			convertion = "-";
		}
		

		
		dtm.addRow(new Object[]{
				rowCount+1,
				stockName,
				colorNo,
				totalQty,
				stockUnit,
				perPrice,
				convertion,
				totalStockPrice,
				"Remove"
		});
		rowCount += 1;
	}
	
	public void saveStock(StockBalance stockBalance) {
		try {
			iBalanceServiceManger.addStock(stockBalance);
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
	
	public void clear() {
		txtTotalStockPrice.setText("");
		//txtYards.setText("");
		txtPerPrice.setText("");
	}
	
	class CheckBoxHandler implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			 int selectedRow = table.getSelectedRow();  
			 int selectedCol = table.getSelectedColumn();

			 if(selectedCol == 8) {
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
}
