package org.amaris.presentation.OtherCrud;

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
import javax.swing.JComboBox;
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

public class OtherCrudDetailFrame extends JFrame {

	public static OtherCrudDetailFrame otherCrudDetailFrame;
	private IOtherCrudServiceManager iOtherCrudServiceManger;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	private JPanel contentPane;
	private JLabel lblID;
	private JLabel lblStockName;
	private JLabel lblReceiverName;
	private JLabel lblMaterials;
	private JLabel lblSize;
	private JLabel lblReceivedUnit;
	
	private JTextField txtID;
	private JTextField txtStockName;
	private JTextField txtReceiverName;
	private JTextField txtQty;
	private JTextField txtReceivedUnit;
	private JComboBox cboStatus;
	private JLabel lblHome;
	private JLabel lblEdit;
	private JLabel lblSearch;
	private JXDatePicker startDatePicker = new JXDatePicker();
	private JXDatePicker endDatePicker = new JXDatePicker();
	private IInventoryServiceManager inventoryServiceManager;
	private JButton btnEdit;
	private JButton btnDelete;
	
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private JTable table;
	private DefaultTableModel dtm;
	public int rowCount=0;
	private JScrollPane scrollPane;
	private JButton btnAdd;
	private JButton btnSearch;
	
	private String [] status={"Complete","Uncomplete"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtherCrudDetailFrame frame = new OtherCrudDetailFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static OtherCrudDetailFrame getInstance() {
		if (otherCrudDetailFrame == null) {
			otherCrudDetailFrame = new OtherCrudDetailFrame();
			otherCrudDetailFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			otherCrudDetailFrame.setVisible(true);
			otherCrudDetailFrame.setResizable(false);
			return otherCrudDetailFrame;
		}
		otherCrudDetailFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		otherCrudDetailFrame.setVisible(true);
		otherCrudDetailFrame.setResizable(false);		
		return otherCrudDetailFrame;
	}

	/**
	 * Create the frame.
	 */
	public OtherCrudDetailFrame() {
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		iOtherCrudServiceManger = (IOtherCrudServiceManager) BasicBeanFactory.getBean("OtherCrudServiceManager");
		
		JLabel lblOtherProduct = new JLabel("Other Product");
		lblOtherProduct.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblOtherProduct.setBounds(28, 40, 263, 24);
		contentPane.add(lblOtherProduct);
				
		JLabel lblDetail = new JLabel("Id");
		lblDetail.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblDetail.setBounds(28, 120, 171, 36);
		contentPane.add(lblDetail);
		
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
		

		lblReceivedUnit= new JLabel("Received Unit");
		lblReceivedUnit.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblReceivedUnit.setBounds(28, 540, 171, 36);
		contentPane.add(lblReceivedUnit);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OtherCrudObject otherCrudObject=new OtherCrudObject();
				otherCrudObject.setId(txtID.getText());
				otherCrudObject.setSname(txtStockName.getText());
				otherCrudObject.setReceiver(txtReceiverName.getText());
				otherCrudObject.setStartDate(formatter.format(startDatePicker.getDate()));
				otherCrudObject.setEndDate(formatter.format(endDatePicker.getDate()));
				otherCrudObject.setReceivedunit(txtReceivedUnit.getText());
				otherCrudObject.setStatus(cboStatus.getSelectedItem()+"");
				otherCrudObject.setQty(txtQty.getText());
				try {
					
					iOtherCrudServiceManger.updateOtherCrud(otherCrudObject);
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
					
					iOtherCrudServiceManger.deleteOtherCrud(txtID.getText());
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
		txtID.setBounds(276, 120, 273, 34);
		contentPane.add(txtID);
		//txtID.setText(getLastID());
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
		
		startDatePicker.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 27));
		startDatePicker.setDate(Calendar.getInstance().getTime());
		startDatePicker.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
		startDatePicker.setBounds(276, 400, 290, 34);
		startDatePicker.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		contentPane.add(startDatePicker);
		
		endDatePicker.getEditor().setFont(new Font("Times New Roman", Font.PLAIN, 27));
		endDatePicker.setDate(Calendar.getInstance().getTime());
		endDatePicker.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
		endDatePicker.setBounds(276, 470, 290, 34);
		endDatePicker.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		contentPane.add(endDatePicker);
		

		txtReceivedUnit = new JTextField();
		txtReceivedUnit.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		txtReceivedUnit.setColumns(10);
		txtReceivedUnit.setBounds(276, 540, 273, 34);
		contentPane.add(txtReceivedUnit);
		
		cboStatus = new JComboBox(status);
		cboStatus.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		//cboStatus.setColumns(10);
		cboStatus.setBounds(550, 540, 273, 34);
		contentPane.add(cboStatus);
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//prePareCutBDList();
				MainFrame mainFrame = MainFrame.getInstance();
				otherCrudDetailFrame.setVisible(false);
				otherCrudDetailFrame = null;
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
				otherCrudDetailFrame.setVisible(false);
				otherCrudDetailFrame = null;
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
		
		String ID = (String) Conversation.getConversationValue("OtherCrud_Detail");
	//	iOtherCrudServiceManger = (IOtherCrudServiceManager) BasicBeanFactory.getBean("iOtherCrudServiceManager");
		OtherCrudObject otherCrudObject=new OtherCrudObject();
		
		try {
			
			otherCrudObject = iOtherCrudServiceManger.findById(ID);			
			
			
			txtID.setText(otherCrudObject.getId());
			txtStockName.setText(otherCrudObject.getSname());
			txtReceiverName.setText(otherCrudObject.getReceiver());
			txtQty.setText(otherCrudObject.getQty());
			txtReceivedUnit.setText(otherCrudObject.getReceivedunit());
			cboStatus.setSelectedItem(otherCrudObject.getStatus());
			
			Date date;
			try {
				date = formatter.parse(otherCrudObject.getStartDate());
				startDatePicker.setDate(date);
				date = formatter.parse(otherCrudObject.getEndDate());
				endDatePicker.setDate(date);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		catch(Exception ex) {
			
		}
		
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

	
		public void keyPressed(KeyEvent e) {
	    if (e.getKeyCode()==KeyEvent.VK_ENTER){
	    	System.out.println("press");
	    }

	}
	
	public void clear(){
		txtID.setText("");
		txtStockName.setText("");
		txtReceiverName.setText("");
		txtQty.setText("0");
		txtReceivedUnit.setText("0");
		startDatePicker.setDate(Calendar.getInstance().getTime());
		endDatePicker.setDate(Calendar.getInstance().getTime());
		
	}
}
