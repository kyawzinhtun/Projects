package org.amaris.presentation.SupplierForm;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.amaris.presentation.BalanceManageForm.ManageItemBalanceFrame;
import org.amaris.presentation.inventoryManageForm.StyleSearchFrame;
import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.SupplierManager.ISupplierServiceManager;
import org.amaris.service.SupplierManager.Supplier;
import org.amaris.service.SupplierManager.SupplierServiceManager;
import org.amaris.service.balanceManage.IBalanceServiceManager;
import org.amaris.service.cuttingManage.ICuttingServiceManager;
import org.amaris.util.AValidator;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SupplierManage extends JFrame {

	private JPanel contentPane;
	public static SupplierManage supplierManageFrame;
	private ISupplierServiceManager supplierServiceManager;
	private JTextField txtSupplerId;
	private JTextField txtSupplierName;
	private JTextField txtSupplierAddress;
	private JTextField txtSupplierPhone;
	private JLabel lblHome;
	private JLabel lblSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierManage frame = new SupplierManage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static SupplierManage getInstance() {
		if (supplierManageFrame == null) {
			supplierManageFrame = new SupplierManage();
			supplierManageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			supplierManageFrame.setVisible(true);
			supplierManageFrame.setResizable(false);
			return supplierManageFrame;
		}
		supplierManageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		supplierManageFrame.setVisible(true);
		supplierManageFrame.setResizable(false);		
		return supplierManageFrame;
	}
	
	/**
	 * Create the frame.
	 */
	public SupplierManage() {
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		supplierServiceManager = (ISupplierServiceManager) BasicBeanFactory.getBean("SupplierServiceManager");
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame mainFrame = MainFrame.getInstance();
				supplierManageFrame.setVisible(false);
				supplierManageFrame = null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		lblHome.setBounds(700, 45, 150, 150);
		contentPane.add(lblHome);
		
		lblSearch = new JLabel(new ImageIcon("img/search.png"));
		lblSearch.setToolTipText("Search Item");
		lblSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SupplierSearchFrame supplierSearchFrame=SupplierSearchFrame.getInstance();
				supplierManageFrame.setVisible(false);
				supplierManageFrame=null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		lblSearch.setBounds(830, 30, 150, 150);
		contentPane.add(lblSearch);
		
		JLabel lblSupplierManagement = new JLabel("Supplier Management");
		lblSupplierManagement.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblSupplierManagement.setBounds(39, 39, 357, 24);
		contentPane.add(lblSupplierManagement);
		
		JLabel lblSupplierId = new JLabel("Supplier ID");
		lblSupplierId.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblSupplierId.setBounds(39, 130, 171, 36);
		contentPane.add(lblSupplierId);
		
		txtSupplerId = new JTextField();
		txtSupplerId.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtSupplerId.setColumns(10);
		txtSupplerId.setBounds(231, 132, 273, 34);
		txtSupplerId.setText(getLastID());
		contentPane.add(txtSupplerId);
		
		JLabel lblSupplierName = new JLabel("Supplier Name");
		lblSupplierName.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblSupplierName.setBounds(39, 208, 171, 36);
		contentPane.add(lblSupplierName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblAddress.setBounds(39, 285, 171, 36);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblPhone.setBounds(39, 363, 171, 36);
		contentPane.add(lblPhone);
		
		txtSupplierName = new JTextField();
		txtSupplierName.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtSupplierName.setColumns(10);
		txtSupplierName.setBounds(231, 208, 273, 34);
		contentPane.add(txtSupplierName);
		
		txtSupplierAddress = new JTextField();
		txtSupplierAddress.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtSupplierAddress.setColumns(10);
		txtSupplierAddress.setBounds(231, 285, 273, 34);
		contentPane.add(txtSupplierAddress);
		
		txtSupplierPhone = new JTextField();
		txtSupplierPhone.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtSupplierPhone.setColumns(10);
		txtSupplierPhone.setBounds(231, 364, 273, 34);
		contentPane.add(txtSupplierPhone);
		
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supplier supplier = new Supplier(txtSupplerId.getText(), 
						txtSupplierName.getText(), 
						txtSupplierAddress.getText(), 
						txtSupplierPhone.getText());
				try {
					supplierServiceManager.addSupplier(supplier);
					JOptionPane.showMessageDialog(null, "Supplier saving successful",
							"Info", JOptionPane.INFORMATION_MESSAGE);
				
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		button.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		button.setBounds(39, 454, 98, 45);
		contentPane.add(button);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
				
		});

		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnClear.setBounds(231, 454, 98, 45);
		contentPane.add(btnClear);

	}
	
	public String getLastID() {
		String id="";
		try {
			id = supplierServiceManager.getLastGenId();
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
	public void clear(){
		txtSupplerId.setText(getLastID());
		txtSupplierName.setText("");
		txtSupplierAddress.setText("");
		txtSupplierPhone.setText("");
	}
}
