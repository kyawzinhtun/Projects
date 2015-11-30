package org.amaris.presentation.SupplierForm;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.amaris.presentation.BalanceManageForm.SearchItemBalanceFrame;
//import org.amaris.presentation.inventoryManageForm.InventoryManageFrame.CheckBoxHandler;
import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.SupplierManager.ISupplierServiceManager;
import org.amaris.service.SupplierManager.Supplier;
import org.amaris.service.balanceManage.IBalanceServiceManager;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.service.inventoryManage.Style;
import org.amaris.service.inventoryManage.StyleInclude;
import org.amaris.service.othercrud.IOtherCrudServiceManager;
import org.amaris.service.othercrud.OtherCrudObject;
import org.amaris.service.othercrud.OtherCrudServiceManager;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.apache.commons.lang.StringUtils;
import org.jdesktop.swingx.JXDatePicker;

public class SupplierDetailFrame extends JFrame {

	public static SupplierDetailFrame supplierDetailFrame;
	private ISupplierServiceManager iSupplierServiceManager;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	private JPanel contentPane;
	private JLabel lblID;
	private JLabel lblSupplierName;
	private JLabel lblSupplierAddress;
	private JLabel lblPhone;
		
	private JTextField txtID;
	private JTextField txtSupplierName;
	private JTextField txtSupplierAddress;
	private JTextField txtPhone;
	private JLabel lblHome;
	private JLabel lblSearch;
	
	private JButton btnEdit;
	private JButton btnDelete;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierDetailFrame frame = new SupplierDetailFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static SupplierDetailFrame getInstance() {
		if (supplierDetailFrame == null) {
			supplierDetailFrame = new SupplierDetailFrame();
			supplierDetailFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			supplierDetailFrame.setVisible(true);
			supplierDetailFrame.setResizable(false);
			return supplierDetailFrame;
		}
		supplierDetailFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		supplierDetailFrame.setVisible(true);
		supplierDetailFrame.setResizable(false);		
		return supplierDetailFrame;
	}

	/**
	 * Create the frame.
	 */
	public SupplierDetailFrame() {
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		iSupplierServiceManager = (ISupplierServiceManager) BasicBeanFactory.getBean("SupplierServiceManager");
		
		JLabel lblOtherProduct = new JLabel("Supplier");
		lblOtherProduct.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblOtherProduct.setBounds(28, 40, 263, 24);
		contentPane.add(lblOtherProduct);
		
		JLabel lblSupplierName = new JLabel("Supplier Name");
		lblSupplierName.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblSupplierName.setBounds(28, 201, 171, 36);
		contentPane.add(lblSupplierName);
		
		JLabel lblDetail = new JLabel("Id");
		lblDetail.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblDetail.setBounds(28, 122, 171, 36);
		contentPane.add(lblDetail);
		
		JLabel lblSupplierAddress = new JLabel("Supplier Address");
		lblSupplierAddress.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblSupplierAddress.setBounds(28, 282, 171, 36);
		contentPane.add(lblSupplierAddress);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblPhone.setBounds(28, 360, 171, 36);
		contentPane.add(lblPhone);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Supplier supplier=new Supplier();
				supplier.setId(txtID.getText());
				supplier.setSupplierName(txtSupplierName.getText());
				supplier.setSupplierAddress(txtSupplierAddress.getText());
				supplier.setSupplierPh(txtPhone.getText());
				try {
					
					iSupplierServiceManager.updateSupplier(supplier);
					JOptionPane.showMessageDialog(null, "Successfully edited!.",
							"Info", JOptionPane.INFORMATION_MESSAGE);

				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Fail to edit!.",
							"Error Info", JOptionPane.ERROR_MESSAGE);

					ex.printStackTrace();
				}
			}
		});
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnEdit.setBounds(28, 614, 98, 45);
		contentPane.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					iSupplierServiceManager.deleteSupplier(txtID.getText());
					clear();
					JOptionPane.showMessageDialog(null, "Successfully Deleted!.",
							"Info", JOptionPane.INFORMATION_MESSAGE);

				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Fail to delete!.",
							"Error Info", JOptionPane.ERROR_MESSAGE);

					ex.printStackTrace();
				}
			}
		});

		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnDelete.setBounds(276, 614, 98, 45);
		contentPane.add(btnDelete);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtID.setColumns(10);
		txtID.setBounds(276, 123, 273, 34);
		contentPane.add(txtID);
		//txtID.setText(getLastID());
		//txtID.setText("2");
		
		
		txtSupplierName = new JTextField();
		txtSupplierName.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtSupplierName.setColumns(10);
		txtSupplierName.setBounds(276, 202, 273, 34);
		contentPane.add(txtSupplierName);
		
		txtSupplierAddress = new JTextField();
		txtSupplierAddress.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtSupplierAddress.setColumns(10);
		txtSupplierAddress.setBounds(276, 282, 273, 34);
		contentPane.add(txtSupplierAddress);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtPhone.setColumns(10);
		txtPhone.setBounds(276, 360, 273, 34);
		contentPane.add(txtPhone);
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//prePareCutBDList();
				MainFrame mainFrame = MainFrame.getInstance();
				supplierDetailFrame.setVisible(false);
				supplierDetailFrame = null;
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
				
				Conversation.addConversation("Flag", "SupplierDetailFrame");
				SupplierSearchFrame searchSupplierFrame = SupplierSearchFrame.getInstance();
				supplierDetailFrame.setVisible(false);
				supplierDetailFrame = null;
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

		initializedData();
	}
	
	public void initializedData() {
		
		String ID = (String) Conversation.getConversationValue("supplier_Detail");
	//	iSupplierServiceManager = (IOtherCrudServiceManager) BasicBeanFactory.getBean("iOtherCrudServiceManager");
		Supplier supplier=new Supplier();
		
		try {
			
			supplier = iSupplierServiceManager.findById(ID);			
			
			txtID.setText(supplier.getId());
			txtSupplierName.setText(supplier.getSupplierName());
			txtSupplierAddress.setText(supplier.getSupplierAddress());
			txtPhone.setText(supplier.getSupplierPh());
			
		}
		catch(Exception ex) {
			
		}
		
	}
	public void editSupplier(Supplier supplier) {
		try {
			iSupplierServiceManager.updateSupplier(supplier);
			JOptionPane.showMessageDialog(null, "Supplier updating successful",
					"Info", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to update supplier.",
					"Error Info", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void removeSupplier(String id){
		try {
			iSupplierServiceManager.deleteSupplier(id);
			JOptionPane.showMessageDialog(null, "Supplier deleting successful",
					"Info", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to delete Supplier.",
					"Error Info", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void clear(){
		txtID.setText("");
		txtSupplierName.setText("");
		txtSupplierAddress.setText("");
		txtPhone.setText("");
	}
	public void keyPressed(KeyEvent e) {
	    if (e.getKeyCode()==KeyEvent.VK_ENTER){
	    	System.out.println("press");
	    }

	}
	
}
