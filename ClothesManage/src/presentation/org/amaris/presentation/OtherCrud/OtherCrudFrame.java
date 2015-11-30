package org.amaris.presentation.OtherCrud;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.amaris.presentation.CuttingManageForm.CuttingManageFrame;
import org.amaris.presentation.LineForm.LineMangeFrame;
import org.amaris.presentation.inventoryManageForm.StyleSearchFrame;
import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.balanceManage.IBalanceServiceManager;
import org.amaris.service.cuttingManage.CuttingMain;
import org.amaris.service.othercrud.IOtherCrudServiceManager;
import org.amaris.service.othercrud.OtherCrudObject;
import org.amaris.util.AValidator;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OtherCrudFrame extends JFrame {

	public static OtherCrudFrame otherCrudFrame;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtStockName;
	private JTextField txtReceiverName;
	private JTextField txtQty;
	private JTextField txtReceivedQty;
	private JLabel lblHome;
	private JLabel lblSearch;
	private JButton btnSave;
	private JButton btnClear;
	private JXDatePicker datePicker = new JXDatePicker();
	private JXDatePicker datePicker2 = new JXDatePicker();
	private IOtherCrudServiceManager iOtherCrudServiceManager;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtherCrudFrame frame = new OtherCrudFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static OtherCrudFrame getInstance() {
		if (otherCrudFrame == null) {
			otherCrudFrame = new OtherCrudFrame();
			otherCrudFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			otherCrudFrame.setVisible(true);
			otherCrudFrame.setResizable(false);
			return otherCrudFrame;
		}
		otherCrudFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		otherCrudFrame.setVisible(true);
		otherCrudFrame.setResizable(false);		
		return otherCrudFrame;
	}


	/**
	 * Create the frame.
	 */
	public OtherCrudFrame() {
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		iOtherCrudServiceManager = (IOtherCrudServiceManager) BasicBeanFactory.getBean("OtherCrudServiceManager");
		
		JLabel lblOtherProduct = new JLabel("Other Product");
		lblOtherProduct.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblOtherProduct.setBounds(28, 40, 263, 24);
		contentPane.add(lblOtherProduct);
		
		JLabel lblID = new JLabel("Id");
		lblID.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblID.setBounds(28, 120, 171, 36);
		contentPane.add(lblID);
		
		JLabel lblStockName = new JLabel("Stock Name");
		lblStockName.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblStockName.setBounds(28, 190, 171, 36);
		contentPane.add(lblStockName);
				
		JLabel lblReceiverName = new JLabel("Receiver Name");
		lblReceiverName.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblReceiverName.setBounds(28, 260, 171, 36);
		contentPane.add(lblReceiverName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblQuantity.setBounds(28, 330, 171, 36);
		contentPane.add(lblQuantity);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblStartDate.setBounds(28, 400, 171, 36);
		contentPane.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblEndDate.setBounds(28, 470, 171, 36);
		contentPane.add(lblEndDate);
		

		JLabel lblReceivedUnit = new JLabel("Received Unit");
		lblReceivedUnit.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblReceivedUnit.setBounds(28, 540, 171, 36);
		contentPane.add(lblReceivedUnit);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OtherCrudObject otherCrudObject=new OtherCrudObject();
				otherCrudObject.setId(txtID.getText());
				otherCrudObject.setSname(txtStockName.getText());
				otherCrudObject.setReceiver(txtReceiverName.getText());
				otherCrudObject.setStartDate(formatter.format(datePicker.getDate()));
				otherCrudObject.setEndDate(formatter.format(datePicker2.getDate()));
				otherCrudObject.setReceivedunit("0");
				otherCrudObject.setStatus("Uncomplete");
				otherCrudObject.setQty(txtQty.getText());
				try {
					
					iOtherCrudServiceManager.insertOtherCrud(otherCrudObject);
					
					
					JOptionPane.showMessageDialog(null, "Successfully saved!.",
							"Info", JOptionPane.INFORMATION_MESSAGE);

				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Fail to save!.",
							"Error Info", JOptionPane.ERROR_MESSAGE);

					ex.printStackTrace();
				}
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnSave.setBounds(28, 614, 98, 45);
		contentPane.add(btnSave);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			clear();
			}
				
			});
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnClear.setBounds(276, 614, 98, 45);
		contentPane.add(btnClear);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtID.setColumns(10);
		txtID.setBounds(276, 120, 273, 34);
		contentPane.add(txtID);
		txtID.setText(getLastID());
		//txtID.setText("2");
		
		
		txtStockName = new JTextField();
		txtStockName.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtStockName.setColumns(10);
		txtStockName.setBounds(276, 190, 273, 34);
		contentPane.add(txtStockName);
		
		txtReceiverName = new JTextField();
		txtReceiverName.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtReceiverName.setColumns(10);
		txtReceiverName.setBounds(276, 260, 273, 34);
		contentPane.add(txtReceiverName);
		
		txtQty = new JTextField();
		txtQty.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtQty.setColumns(10);
		txtQty.setBounds(276, 330, 273, 34);
		contentPane.add(txtQty);
		
		datePicker.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 27));
		datePicker.setDate(Calendar.getInstance().getTime());
		datePicker.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
		datePicker.setBounds(276, 400, 290, 34);
		datePicker.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		contentPane.add(datePicker);
		
		datePicker2.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 27));
		datePicker2.setDate(Calendar.getInstance().getTime());
		datePicker2.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
		datePicker2.setBounds(276, 470, 290, 34);
		datePicker2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		contentPane.add(datePicker2);
		
		txtReceivedQty = new JTextField();
		txtReceivedQty.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtReceivedQty.setColumns(10);
		txtReceivedQty.setEditable(false);
		txtReceivedQty.setText("0");
		txtReceivedQty.setBounds(276, 540, 273, 34);
		contentPane.add(txtReceivedQty);
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//prePareCutBDList();
				MainFrame mainFrame = MainFrame.getInstance();
				otherCrudFrame.setVisible(false);
				otherCrudFrame = null;
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
				
				Conversation.addConversation("Flag", "OtherCrudFrame");
				OtherCrudSearchFrame searchOtherCrudFrame = OtherCrudSearchFrame.getInstance();
				otherCrudFrame.setVisible(false);
				otherCrudFrame = null;
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


	}
	
	public String getLastID() {
		String id="";
		try {
			id = iOtherCrudServiceManager.getMaxId();
			
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
		txtID.setText(getLastID());
		txtStockName.setText("");
		txtReceiverName.setText("");
		txtQty.setText("");
		datePicker.setDate(Calendar.getInstance().getTime());
		datePicker2.setDate(Calendar.getInstance().getTime());
		
	}
}
