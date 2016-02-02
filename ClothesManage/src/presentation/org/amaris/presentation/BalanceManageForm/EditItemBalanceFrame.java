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
import org.amaris.presentation.inventoryManageForm.ButtonRenderer;
import org.amaris.presentation.inventoryManageForm.InventorySearchFrame;
import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.balanceManage.IBalanceServiceManager;
import org.amaris.service.balanceManage.StockBalance;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.service.inventoryManage.InventoryItem;
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


public class EditItemBalanceFrame extends JFrame {

	public static EditItemBalanceFrame editItemBalanceFrame;
	private JPanel contentPane;
	private JComboBox comboList = new JComboBox();
	private JComboBox comboBox;
	private JTextField txtStockName;
	private JTextField txtStockPrice;
	private JTextField txtStockQuantity;
	private JTextField txtTotalPrice;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private JXDatePicker datePicker = new JXDatePicker();
	private IInventoryServiceManager inventorySerivceManger;
	private HashMap<String, String> comboMap = new HashMap<String, String>();
	private JLabel lblHome;
	private JLabel lblSearch;
	private IBalanceServiceManager iBalanceServiceManger;
	private JTextField txtStockId;
	public int rowCount=0;
	private JButton btnEdit;
	private String stockId="";
	private JLabel lblAdd;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditItemBalanceFrame frame = new EditItemBalanceFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static EditItemBalanceFrame getInstance() {
		if (editItemBalanceFrame == null) {
			editItemBalanceFrame = new EditItemBalanceFrame();
			editItemBalanceFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			editItemBalanceFrame.setVisible(true);
			editItemBalanceFrame.setResizable(false);
			return editItemBalanceFrame;
		}
		editItemBalanceFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		editItemBalanceFrame.setVisible(true);
		editItemBalanceFrame.setResizable(false);		
		return editItemBalanceFrame;
	}

	/**
	 * Create the frame.
	 */
	public EditItemBalanceFrame() {
		
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Stock Balance Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 1336, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.setLayout(null);
		comboList.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		comboList.setBounds(258, 152, 236, 34);
		panel.add(comboList);
		
		JLabel lblLogo = new JLabel("Stock Editing");
		lblLogo.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblLogo.setBounds(20, 53, 285, 24);
		panel.add(lblLogo);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblItemName.setBounds(20, 152, 140, 36);
		panel.add(lblItemName);
		
		JLabel lblStock = new JLabel("Stock Name");
		lblStock.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblStock.setBounds(20, 281, 171, 36);
		panel.add(lblStock);
		
		JLabel lblStockPrice = new JLabel("Stock Price");
		lblStockPrice.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblStockPrice.setBounds(602, 152, 171, 36);
		panel.add(lblStockPrice);
		
		txtStockName = new JTextField();
		txtStockName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtStockName.setColumns(10);
		txtStockName.setBounds(258, 282, 236, 34);
		panel.add(txtStockName);
		
		txtStockPrice = new JTextField();
		txtStockPrice.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String stockPrice = txtStockPrice.getText();
				if(!StringUtils.isBlank(stockPrice)) {
					if(StringUtils.isNumeric(stockPrice)) {
						if(!StringUtils.isBlank(txtStockQuantity.getText())) {
							Double dstockPrice = Double.valueOf(stockPrice);
							int stockQuantity = Integer.valueOf(txtStockQuantity.getText());
							Double totalPrice = dstockPrice * stockQuantity;
							txtTotalPrice.setText(totalPrice+"");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Only Number is available!.",
								"Restric Info", JOptionPane.INFORMATION_MESSAGE);
						txtStockPrice.setText("");
					}
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String stockPrice = txtStockPrice.getText();
				if(!StringUtils.isBlank(stockPrice)) {
					if(StringUtils.isNumeric(stockPrice)) {
						if(!StringUtils.isBlank(txtStockQuantity.getText())) {
							Double dstockPrice = Double.valueOf(stockPrice);
							int stockQuantity = Integer.valueOf(txtStockQuantity.getText());
							Double totalPrice = dstockPrice * stockQuantity;
							txtTotalPrice.setText(totalPrice+"");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Only Number is available!.",
								"Restric Info", JOptionPane.INFORMATION_MESSAGE);
						txtStockPrice.setText("");
					}
				}
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				String stockPrice = txtStockPrice.getText();
				if(!StringUtils.isBlank(stockPrice)) {
					if(StringUtils.isNumeric(stockPrice)) {
						if(!StringUtils.isBlank(txtStockQuantity.getText())) {
							Double dstockPrice = Double.valueOf(stockPrice);
							int stockQuantity = Integer.valueOf(txtStockQuantity.getText());
							Double totalPrice = dstockPrice * stockQuantity;
							txtTotalPrice.setText(totalPrice+"");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Only Number is available!.",
								"Restric Info", JOptionPane.INFORMATION_MESSAGE);
						txtStockPrice.setText("");
					}
				}
				
			}
			
		});
		
		txtStockPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.doClick();
			}
		});
		txtStockPrice.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtStockPrice.setColumns(10);
		txtStockPrice.setBounds(853, 152, 236, 34);
		panel.add(txtStockPrice);
		
		comboBox = new JComboBox();
		comboBox.setFont((new Font("Times New Roman", Font.PLAIN, 20)));
		comboBox.setBounds(1152, 152, 83, 36);
		panel.add(comboBox);
		
		JLabel lblStockQuantity = new JLabel("Stock Quantity");
		lblStockQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblStockQuantity.setBounds(602, 212, 205, 36);
		panel.add(lblStockQuantity);
		
		txtStockQuantity = new JTextField();
		txtStockQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.doClick();
			}
		});
		txtStockQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtStockQuantity.setColumns(10);
		txtStockQuantity.setBounds(853, 213, 236, 34);
		panel.add(txtStockQuantity);
		
		txtStockQuantity.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String stockQuantity = txtStockQuantity.getText();
				if(!StringUtils.isBlank(stockQuantity)) {
					if(StringUtils.isNumeric(stockQuantity)) {
						if(!StringUtils.isBlank(txtStockPrice.getText())) {
							int sQuantity = Integer.valueOf(stockQuantity);
							Double dstockPrice = Double.valueOf(txtStockPrice.getText());
							Double totalPrice = dstockPrice * sQuantity;
							txtTotalPrice.setText(totalPrice+"");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Only Number is available!.",
								"Restric Info", JOptionPane.INFORMATION_MESSAGE);
						txtStockQuantity.setText("");
					}
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String stockQuantity = txtStockQuantity.getText();
				if(!StringUtils.isBlank(stockQuantity)) {
					if(StringUtils.isNumeric(stockQuantity)) {
						if(!StringUtils.isBlank(txtStockPrice.getText())) {
							int sQuantity = Integer.valueOf(stockQuantity);
							Double dstockPrice = Double.valueOf(txtStockPrice.getText());
							Double totalPrice = dstockPrice * sQuantity;
							txtTotalPrice.setText(totalPrice+"");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Only Number is available!.",
								"Restric Info", JOptionPane.INFORMATION_MESSAGE);
						txtStockQuantity.setText("");
					}
				}
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				String stockQuantity = txtStockQuantity.getText();
				if(!StringUtils.isBlank(stockQuantity)) {
					if(StringUtils.isNumeric(stockQuantity)) {
						if(!StringUtils.isBlank(txtStockPrice.getText())) {
							int sQuantity = Integer.valueOf(stockQuantity);
							Double dstockPrice = Double.valueOf(txtStockPrice.getText());
							Double totalPrice = dstockPrice * sQuantity;
							txtTotalPrice.setText(totalPrice+"");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Only Number is available!.",
								"Restric Info", JOptionPane.INFORMATION_MESSAGE);
						txtStockQuantity.setText("");
					}
				}
			}
		});
		
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblTotalPrice.setBounds(602, 281, 205, 36);
		panel.add(lblTotalPrice);
		
		txtTotalPrice = new JTextField();
		txtTotalPrice.setEnabled(false);
		txtTotalPrice.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtTotalPrice.setColumns(10);
		txtTotalPrice.setBounds(853, 281, 236, 34);
		panel.add(txtTotalPrice);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblDate.setBounds(20, 358, 171, 36);
		panel.add(lblDate);
		
		datePicker.setDate(Calendar.getInstance().getTime());
		datePicker.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
		datePicker.setBounds(258, 359, 236, 34);
		datePicker.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        panel.add(datePicker);
		
        btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowCount = 0;
				if(StringUtils.isBlank(txtStockName.getText())) {
					JOptionPane.showMessageDialog(null, "Stock Name is required!.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				} 
				else if(StringUtils.isBlank(txtStockPrice.getText())) {
					JOptionPane.showMessageDialog(null, "Stock Price is required!.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (StringUtils.isBlank(txtStockQuantity.getText())) {
					JOptionPane.showMessageDialog(null, "Stock Quantity is required!.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					StockBalance stockBalance = new StockBalance();
					StockBalance stockBalance2 = new StockBalance();
					stockBalance2 = (StockBalance)Conversation.getConversationValue("editStock");
//					stockBalance.setItemId(comboMap.get((String)comboList.getSelectedItem()));
//					stockBalance.setStockId(txtStockId.getText());
					stockBalance.setStockName(txtStockName.getText());
//					stockBalance.setStockPrice(txtStockPrice.getText());
//					stockBalance.setStockQuantity(txtStockQuantity.getText());
//					stockBalance.setTotalPrice(txtTotalPrice.getText());
					stockBalance.setUnit(comboBox.getSelectedItem()+"");
					stockBalance.setStockInDate(formatter.format(datePicker.getDate()));
//					stockBalance.setId(stockBalance2.getId());
					editStock(stockBalance);
					JOptionPane.showMessageDialog(null, "Successfully Edit Stock.",
							"Success Info", JOptionPane.INFORMATION_MESSAGE);
					SearchItemBalanceFrame searchItemBalanceFrame = SearchItemBalanceFrame.getInstance();
					editItemBalanceFrame.setVisible(false);
					editItemBalanceFrame = null;
					
				}
			}
		});
        btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        btnEdit.setBounds(20, 424, 125, 45);
		panel.add(btnEdit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtStockPrice.setText("");
				txtStockQuantity.setText("");
				txtTotalPrice.setText("");
				txtStockName.setText("");
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnClear.setBounds(258, 424, 125, 45);
		panel.add(btnClear);
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame mainFrame = MainFrame.getInstance();
				editItemBalanceFrame.setVisible(false);
				editItemBalanceFrame = null;
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
				editItemBalanceFrame.setVisible(false);
				editItemBalanceFrame = null;
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
		
		lblAdd = new JLabel(new ImageIcon("img/add.png"));
		lblAdd.setToolTipText("Search Item");
		lblAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageItemBalanceFrame manageItemBalanceFrame = ManageItemBalanceFrame.getInstance();
				editItemBalanceFrame.setVisible(false);
				editItemBalanceFrame = null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		lblAdd.setBounds(955, 5, 150, 150);
		panel.add(lblAdd);
		
		JLabel lblStockId = new JLabel("Stock ID");
		lblStockId.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblStockId.setBounds(20, 212, 171, 36);
		panel.add(lblStockId);
		
		txtStockId = new JTextField();
		txtStockId.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtStockId.setColumns(10);
		txtStockId.setBounds(258, 213, 236, 34);
		panel.add(txtStockId);
		
		initializedData();
	}
	
	public void editStock(StockBalance stockBalance) {
		iBalanceServiceManger = (IBalanceServiceManager) BasicBeanFactory.getBean("BalanceServiceManager");
		try {
			iBalanceServiceManger.editStock(stockBalance);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to Insert Item.",
					"Error Info", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void clear() {
		txtStockPrice.setText("");
		txtStockQuantity.setText("");
		txtTotalPrice.setText("");
		txtStockName.setText("");
	}
	
	public void initializedData() {
		StockBalance sb = (StockBalance)Conversation.getConversationValue("editStock");
		comboMap = (HashMap<String, String>) Conversation.getConversationValue("comboMap");
		List<String> itemList = new ArrayList<String>();
//		String itemName = sb.getItemId();
		String unit = sb.getUnit();
//		this.stockId = sb.getId();
//		comboList.addItem(itemName);
//		for(String key: comboMap.keySet()) {
//			if(!key.equals(itemName)){
//				comboList.addItem(key);
//			}
//		}
		
		comboBox.addItem(unit);
		List<String> unitList = new ArrayList<String>(5);
		unitList.add("1 Unit");
		unitList.add("1 Pack");
		unitList.add("1 Yard");
		
		for(String unitCombo : unitList) {
			if(!unitCombo.equals(unit)) {
				comboBox.addItem(unitCombo);
			}
		}
		
//		txtStockId.setText(sb.getStockId());
		txtStockName.setText(sb.getStockName());
//		txtStockPrice.setText(sb.getStockPrice());
//		txtStockQuantity.setText(sb.getStockQuantity());
		Date date;
//		txtTotalPrice.setText(sb.getTotalPrice());
		try {
			date = formatter.parse(sb.getStockInDate());
			datePicker.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
