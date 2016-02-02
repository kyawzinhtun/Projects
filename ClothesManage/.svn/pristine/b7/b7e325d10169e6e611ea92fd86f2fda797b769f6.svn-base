package org.amaris.presentation.inventoryManageForm;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.service.inventoryManage.InventoryItem;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.apache.commons.lang.StringUtils;
import org.jdesktop.swingx.JXDatePicker;

public class InventoryEditFrame extends JFrame {

	private JPanel contentPane;
	public static InventoryEditFrame inventoryEditFrame;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	private JLabel itemName;
	private JLabel itemId;
	private JLabel imgPath;
	private JLabel remarks;
	private JTextField txtID = new JTextField();
	private JTextField txtItemName = new JTextField();
	private JTextField txtImgPath = new JTextField();
	private JTextField txtRemarks = new JTextField();
	private JLabel lblHome;
	private JLabel lblAdd;
	private JLabel lblSearch;
	private JXDatePicker datePicker = new JXDatePicker();
	private IInventoryServiceManager inventoryServiceManager;
	private JButton btnEdit;
	private JButton btnNewButton;
	private JFileChooser fileChooser = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryEditFrame frame = new InventoryEditFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static InventoryEditFrame getInstance() {
		if (inventoryEditFrame == null) {
			inventoryEditFrame = new InventoryEditFrame();
			inventoryEditFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			inventoryEditFrame.setVisible(true);
			inventoryEditFrame.setResizable(false);
			return inventoryEditFrame;
		}
		inventoryEditFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		inventoryEditFrame.setVisible(true);
		inventoryEditFrame.setResizable(false);		
		return inventoryEditFrame;
	}

	/**
	 * Create the frame.
	 */
	public InventoryEditFrame() {
		initializedDate();
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Inventory Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 1336, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("Edit Item");
		lblLogo.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblLogo.setBounds(20, 60, 285, 24);
		panel.add(lblLogo);
		
		itemName = new JLabel("Item Name");
		itemName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		itemName.setBounds(154, 228, 152, 24);
		panel.add(itemName);
		
		itemId = new JLabel("Item ID");
		itemId.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		itemId.setBounds(154, 156, 125, 24);
		panel.add(itemId);
		
		imgPath = new JLabel("Image Path");
		imgPath.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		imgPath.setBounds(154, 290, 152, 36);
		panel.add(imgPath);
		
		remarks = new JLabel("Remark");
		remarks.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		remarks.setBounds(154, 357, 125, 24);
		panel.add(remarks);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblDate.setBounds(154, 423, 125, 24);
		panel.add(lblDate);
		
		//txtID = new JTextField();
		txtID.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtID.setBounds(350, 144, 229, 36);
		panel.add(txtID);
		txtID.setColumns(10);
		
		//txtItemName = new JTextField();
		txtItemName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.doClick();
			}
		});
		txtItemName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtItemName.setColumns(10);
		txtItemName.setBounds(350, 216, 229, 36);
		panel.add(txtItemName);
		
		//txtImgPath = new JTextField();
		txtImgPath.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtImgPath.setColumns(10);
		txtImgPath.setBounds(350, 290, 229, 36);
		panel.add(txtImgPath);
		
		//txtRemarks = new JTextField();
		txtRemarks.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtRemarks.setColumns(10);
		txtRemarks.setBounds(350, 357, 229, 36);
		panel.add(txtRemarks);
		
		datePicker.setDate(Calendar.getInstance().getTime());
		datePicker.setFormats(new SimpleDateFormat("dd:MM:yyyy"));
		datePicker.setBounds(350, 420, 229, 36);
		datePicker.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        panel.add(datePicker);
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame mainFrame = MainFrame.getInstance();
				inventoryEditFrame.setVisible(false);
				inventoryEditFrame = null;
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
		lblAdd.setToolTipText("Add New Item");
		lblAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InventoryManageFrame inventoryManageFrame = InventoryManageFrame.getInstance();
				inventoryEditFrame.setVisible(false);
				inventoryEditFrame = null;
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
		
		lblSearch = new JLabel(new ImageIcon("img/search.png"));
		lblSearch.setToolTipText("Search Item");
		lblSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InventorySearchFrame inventorySearchFrame = InventorySearchFrame.getInstance();
				inventoryEditFrame.setVisible(false);
				inventoryEditFrame = null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		lblSearch.setBounds(955, 30, 150, 150);
		panel.add(lblSearch);

		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(154, 530, 125, 45);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InventoryItem invItem = new InventoryItem();
				invItem.setItemId(txtID.getText());
				invItem.setItemName(txtItemName.getText());
				invItem.setImagePath(txtImgPath.getText());
				invItem.setRemarks(txtRemarks.getText());
				invItem.setDate(dateFormatter.format(datePicker.getDate()));
				if(StringUtils.isBlank(invItem.getItemName())) {
					JOptionPane.showMessageDialog(null, "Item Name is require to fill.",
							"Require Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					editInvItem(invItem);
					InventorySearchFrame inventorySearchFrame = InventorySearchFrame.getInstance();
					inventoryEditFrame.setVisible(false);
					inventoryEditFrame = null;
				}
			}
		});
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnEdit.setBounds(154, 530, 125, 45);
		panel.add(btnEdit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtImgPath.setText("");
				txtItemName.setText("");
				txtRemarks.setText("");
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnClear.setBounds(350, 530, 132, 45);
		panel.add(btnClear);
		
		fileChooser.setCurrentDirectory(new File("C:\\Documents and Settings"));
		fileChooser.setDialogTitle("Choose Status Report File");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		btnNewButton = new JButton("Browse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {					
					txtImgPath.setText(fileChooser.getSelectedFile() + "");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnNewButton.setBounds(589, 290, 143, 36);
		panel.add(btnNewButton);
		
	}
	
	public void editInvItem(InventoryItem invItem) {
		inventoryServiceManager = (IInventoryServiceManager) BasicBeanFactory.getBean("InventoryServiceManager");
		try {
			//inventoryServiceManager.EditItem(invItem);
			JOptionPane.showMessageDialog(null, "Successfully Edit Item.",
					"Success Info", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to Edit Item.",
					"Error Info", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void keyPressed(KeyEvent e) {
	    if (e.getKeyCode()==KeyEvent.VK_ENTER){
	    	System.out.println("press");
	    }

	}
	
	public void initializedDate() {
		inventoryServiceManager = (IInventoryServiceManager) BasicBeanFactory.getBean("InventoryServiceManager");
		InventoryItem iv = inventoryServiceManager.preEditItem((String) Conversation.getConversationValue("SelectedInventoryEdit"));
		txtID.setText(iv.getItemId());
		txtItemName.setText(iv.getItemName());
		txtRemarks.setText(iv.getRemarks());
		txtImgPath.setText(iv.getImagePath());
		Date date;
		try {
			date = dateFormatter.parse(iv.getDate());
			datePicker.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
