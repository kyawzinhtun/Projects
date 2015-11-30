package org.amaris.presentation.mainForm;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;

import org.amaris.presentation.BalanceManageForm.ManageItemBalanceFrame;
import org.amaris.presentation.CuttingManageForm.CuttingManageFrame;
import org.amaris.presentation.CuttingManageForm.CuttingSearch;
import org.amaris.presentation.LineForm.SearchLineFrame;
import org.amaris.presentation.OtherCrud.OtherCrudFrame;
import org.amaris.presentation.SupplierForm.SupplierManage;
import org.amaris.presentation.inventoryManageForm.InventoryManageFrame;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.apache.log4j.Logger;


public class MainFrame extends JFrame {

	/**
	 * 
	 */ 
	public static HashMap<String, Object> conversation = new HashMap<>();
	public static int initalizedFilter = 0;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel manageInventory;
	private JLabel manageInventoryDetail;
	private JLabel manageSetting;
	private JLabel produceStyle;
	private JLabel produceStyleEdit;
	private JLabel cutting;
	private JLabel cuttingEdit;
	private JLabel exit;
	private JLabel balance;
	public static MainFrame mainFrame;
	private InventoryManageFrame inventoryManageFrame;
	private ManageItemBalanceFrame manageItemBalanceFrame;
	private CuttingManageFrame cuttingManageFrame;
	private SupplierManage supplierManage;
	private SearchLineFrame searchLineFrame;
	private OtherCrudFrame otherCrudFrame;
	Conversation cov = new Conversation();
	private static Logger logger = Logger.getLogger(MainFrame.class);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					mainFrame = new MainFrame();
					mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					mainFrame.setVisible(true);
					mainFrame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static MainFrame getInstance() {
		if (mainFrame == null) {
			mainFrame = new MainFrame();
			mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			mainFrame.setVisible(true);
			mainFrame.setResizable(false);
		}
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		return mainFrame;
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		if (initalizedFilter == 0) {
			initalizezdBean();
			initalizedFilter=1;
		}
		
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Welcome to Clothes Management System", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 11, 1336, 680);
		contentPane.add(panel);
		panel.setLayout(null);

		manageInventory = new JLabel(new ImageIcon("img/inventory.png"));
		manageInventory.setToolTipText("Manage Item Inventory");
		manageInventory.setCursor(new Cursor(Cursor.HAND_CURSOR));
		manageInventory.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				supplierManage = SupplierManage.getInstance();
				mainFrame.setVisible(false);
				mainFrame=null;
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		manageInventory.setBounds(120, 80, 130, 130);
		panel.add(manageInventory);
		
		manageInventoryDetail = new JLabel(new ImageIcon("img/inventory_manage.png"));
		manageInventoryDetail.setToolTipText("Inventory Balance");
		manageInventoryDetail.setCursor(new Cursor(Cursor.HAND_CURSOR));
		manageInventoryDetail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageItemBalanceFrame = ManageItemBalanceFrame.getInstance();
				mainFrame.setVisible(false);
				mainFrame=null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		manageInventoryDetail.setBounds(120, 300, 130, 130);
		panel.add(manageInventoryDetail);
		
		manageSetting = new JLabel(new ImageIcon("img/manage_setting.png"));
		manageSetting.setToolTipText("System Setting");
		manageSetting.setCursor(new Cursor(Cursor.HAND_CURSOR));
		manageSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//System.out.println("Click");
				otherCrudFrame = OtherCrudFrame.getInstance();
				mainFrame.setVisible(false);
				mainFrame=null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		manageSetting.setBounds(120, 540, 130, 130);
		panel.add(manageSetting);
		
		
		produceStyle = new JLabel(new ImageIcon("img/style1.png"));
		produceStyle.setToolTipText("Produce Style");
		produceStyle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		produceStyle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inventoryManageFrame = InventoryManageFrame.getInstance();
				mainFrame.setVisible(false);
				mainFrame=null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		produceStyle.setBounds(550, 80, 130, 130);
		panel.add(produceStyle);
		
		
		produceStyleEdit = new JLabel(new ImageIcon("img/style1Edit.png"));
		produceStyleEdit.setToolTipText("Style Edit");
		produceStyleEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		produceStyleEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchLineFrame = SearchLineFrame.getInstance();
				mainFrame.setVisible(false);
				mainFrame=null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		produceStyleEdit.setBounds(550, 300, 150, 150);
		panel.add(produceStyleEdit);
		
		
		cutting = new JLabel(new ImageIcon("img/cut1.png"));
		cutting.setToolTipText("Cutting Manage");
		cutting.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cutting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cuttingManageFrame = CuttingManageFrame.getInstance();
				mainFrame.setVisible(false);
				mainFrame=null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		cutting.setBounds(950, 80, 150, 150);
		panel.add(cutting);
		
		cuttingEdit = new JLabel(new ImageIcon("img/cut_edit.png"));
		cuttingEdit.setToolTipText("Cutting Edit");
		cuttingEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cuttingEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CuttingSearch cs = CuttingSearch.getInstance();
				mainFrame.setVisible(false);
				mainFrame=null;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		cuttingEdit.setBounds(950, 310, 165, 165);
		panel.add(cuttingEdit);
		
		balance = new JLabel(new ImageIcon("img/Graph-icon.png"));
		balance.setToolTipText("Balace Checking");
		balance.setCursor(new Cursor(Cursor.HAND_CURSOR));
		balance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		balance.setBounds(540, 520, 165, 165);
		panel.add(balance);
		
		exit = new JLabel(new ImageIcon("img/Logout.png"));
		exit.setToolTipText("Exit From System");
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		exit.setBounds(950, 540, 165, 165);
		panel.add(exit);
	}
	
	public void initalizezdBean() {
		try {
			BasicBeanFactory bf = new BasicBeanFactory();
			logger.info("All Spring bean are successfully loaded.");
		}
		catch(Exception ex) {
			logger.error("Erro when loading spring bean.", ex);
		}
		
		
	}
	
}
