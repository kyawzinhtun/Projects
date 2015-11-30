package org.amaris.presentation.CuttingManageForm;

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
import org.amaris.presentation.LineForm.LineShareDetailFrame;
import org.amaris.presentation.inventoryManageForm.ButtonRenderer;
import org.amaris.presentation.inventoryManageForm.InventoryManageFrame;
import org.amaris.presentation.inventoryManageForm.StyleDetailFrame;
import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.balanceManage.IBalanceServiceManager;
import org.amaris.service.balanceManage.StockBalance;
import org.amaris.service.cuttingManage.CuttingMain;
import org.amaris.service.cuttingManage.ICuttingServiceManager;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.apache.commons.lang.StringUtils;
import org.jdesktop.swingx.JXDatePicker;

public class CuttingSearch extends JFrame {

	public static CuttingSearch cuttingSearchFrame;
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
	private IBalanceServiceManager iBalanceServiceManger;
	private JTextField searchKeyWords;
	private String flag;
	private ICuttingServiceManager iCuttingServiceManger;
	private JXDatePicker startDatePicker = new JXDatePicker();
	private JXDatePicker endDatePicker = new JXDatePicker();
	List<CuttingMain> resultList = new ArrayList<CuttingMain>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchItemBalanceFrame frame = new SearchItemBalanceFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static CuttingSearch getInstance() {
		if (cuttingSearchFrame == null) {
			cuttingSearchFrame = new CuttingSearch();
			cuttingSearchFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			cuttingSearchFrame.setVisible(true);
			cuttingSearchFrame.setResizable(false);
			return cuttingSearchFrame;
		}
		cuttingSearchFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		cuttingSearchFrame.setVisible(true);
		cuttingSearchFrame.setResizable(false);
		return cuttingSearchFrame;
	}

	/**
	 * Create the frame.
	 */
	public CuttingSearch() {

		flag = (String) Conversation.getConversationValue("Flag");
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(20, 11, 1336, 680);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Result View",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 164, 1277, 505);
		panel.add(panel_1);
		panel_1.setLayout(null);

		overrideDefaultTableModle();

		JLabel lblLogo = new JLabel("Cutting Searching");
		lblLogo.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblLogo.setBounds(20, 60, 351, 24);
		panel.add(lblLogo);

		DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
				setHorizontalAlignment(JLabel.CENTER);
				return this;
			}
		};

		String[] columnNames = { "No", "Cutting ID", "Item Name",
				"Cutting Length", "First Price", "Second Price", "Total Price",
				"Stock In Date", "Detail", "Line", "Delete" };

		Object[][] data = {};
		dtm.setDataVector(data, columnNames);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 54, 1222, 426);
		panel_1.add(scrollPane);

		table = new JTable();
		Font font = new Font("Times New Roman", Font.PLAIN, 16);
		table.setFont(font);
		table.setModel(dtm);
		table.addMouseListener(new CheckBoxHandler());
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		// align checkbox to center
		table.getColumnModel().getColumn(0).setCellRenderer(r);
		table.getColumnModel().getColumn(1).setCellRenderer(r);
		table.getColumnModel().getColumn(2).setCellRenderer(r);
		table.getColumnModel().getColumn(3).setCellRenderer(r);
		table.getColumnModel().getColumn(4).setCellRenderer(r);
		table.getColumnModel().getColumn(5).setCellRenderer(r);
		table.getColumnModel().getColumn(6).setCellRenderer(r);
		table.getColumnModel().getColumn(7).setCellRenderer(r);
		table.getColumnModel().getColumn(8).setCellRenderer(r);
		table.getColumnModel().getColumn(9).setCellRenderer(r);
		table.getColumnModel().getColumn(10).setCellRenderer(r);

		// add button at update column
		table.getColumn("Detail").setCellRenderer(new ButtonRenderer());
		table.getColumn("Detail").setCellEditor(
				new ButtonDetailStock(new JCheckBox()));
		table.getColumn("Line").setCellRenderer(new ButtonRenderer());
		table.getColumn("Line").setCellEditor(
				new ButtonDetailStock(new JCheckBox()));
		table.getColumn("Delete").setCellRenderer(new ButtonRenderer());
		table.getColumn("Delete").setCellEditor(
				new ButtonDetailStock(new JCheckBox()));
		scrollPane.setViewportView(table);
		table.setRowHeight(30);

		JLabel lblNewLabel = new JLabel("ID Filter");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setBounds(20, 127, 101, 26);
		panel.add(lblNewLabel);

		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame mainFrame = MainFrame.getInstance();
				cuttingSearchFrame.setVisible(false);
				cuttingSearchFrame = null;
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
				ManageItemBalanceFrame manageItemBalanceFrame = ManageItemBalanceFrame
						.getInstance();
				cuttingSearchFrame.setVisible(false);
				cuttingSearchFrame = null;
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
		searchKeyWords.setBounds(115, 126, 159, 26);
		searchKeyWords.setColumns(10);
		panel.add(searchKeyWords);
		searchKeyWords.getDocument().addDocumentListener(
				new DocumentListener() {

					public void insertUpdate(DocumentEvent e) {
						searchStockFilter(searchKeyWords.getText(), "key");
					}

					public void removeUpdate(DocumentEvent e) {
						searchStockFilter(searchKeyWords.getText(), "key");
					}

					public void changedUpdate(DocumentEvent e) {
						searchStockFilter(searchKeyWords.getText(), "key");
					}
				});

	}

	class CheckBoxHandler implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			int selectedRow = table.getSelectedRow();
			int selectedCol = table.getSelectedColumn();
			if (selectedCol == 8) {
				String cutting_id = (String) dtm.getValueAt(selectedRow, 1);
				searchDetailStock(cutting_id);

			}
			if (selectedCol == 9) {
				String cutting_id = (String) dtm.getValueAt(selectedRow, 1);
				searchLineStock(cutting_id);
			}
			if (selectedCol == 10) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure want to delete?") == JOptionPane.YES_OPTION) {					
						deleteRow(resultList.get(selectedRow).getCutId());					
				} 
			}
		}

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

	private void overrideDefaultTableModle() {
		dtm = new DefaultTableModel() {

			public boolean isCellEditable(int row, int col) {
				// Note that the data/cell address is constant,
				// no matter where the cell appears onscreen.
				if (col >= 0 && col <= 7) {
					return false;
				} else {
					return true;
				}
			}
		};
	}

	public void searchDetailStock(String cutting_Id) {
		iCuttingServiceManger = (ICuttingServiceManager) BasicBeanFactory
				.getBean("CuttingSeriveManager");
		List<BalanceDetail> balanceDetailList = new ArrayList<BalanceDetail>();
		try {
			balanceDetailList = iCuttingServiceManger
					.getDeatilByCutting(cutting_Id);
			CuttingDetailFrame cuttingDetailFrame = CuttingDetailFrame
					.getInstance();
			cuttingDetailFrame.setDetailList(balanceDetailList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void searchLineStock(String cutting_Id) {
		iCuttingServiceManger = (ICuttingServiceManager) BasicBeanFactory
				.getBean("CuttingSeriveManager");
		List<CuttingMain> balanceDetailList = new ArrayList<CuttingMain>();
		try {
			balanceDetailList = iCuttingServiceManger.filterByKey(cutting_Id);
			LineShareDetailFrame lineShareDetailFrame = LineShareDetailFrame
					.getInstance();
			lineShareDetailFrame.setDetailList(balanceDetailList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void searchStockFilter(String filterKey, String type) {

		
		if (StringUtils.isBlank(filterKey)) {
			removeAllRow();
		} else {
			iCuttingServiceManger = (ICuttingServiceManager) BasicBeanFactory
					.getBean("CuttingSeriveManager");
			try {
				resultList = iCuttingServiceManger.filterByKey(filterKey);
				int i = 0;
				removeAllRow();
				for (CuttingMain cm : resultList) {
					dtm.addRow(new Object[] { i + 1, cm.getCuttingId(),
							cm.getStyleID(), cm.getTotalUnit(),
							cm.getPerUnitPrice(), cm.getPerIncludeUnitPrice(),
							cm.getTotalUnitPrice(), cm.getCuttingDate(),
							"detail", "Line", "Delete" });
					i++;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Fail to Search Stock",
						"Error Info", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public void removeAllRow() {
		if (dtm.getRowCount() != 0) {
			for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
				dtm.removeRow(i);
			}
		}
	}

	public void deleteRow(String cutId){
		iCuttingServiceManger.deleteById(cutId);
	}
}
