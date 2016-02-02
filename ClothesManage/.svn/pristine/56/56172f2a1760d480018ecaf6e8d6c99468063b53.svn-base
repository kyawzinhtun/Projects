package org.amaris.presentation.inventoryManageForm;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.amaris.presentation.mainForm.MainFrame;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.service.inventoryManage.InventoryItem;
import org.amaris.service.inventoryManage.Style;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.apache.commons.lang.StringUtils;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class InventorySearchFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblHome;
	private JLabel lblEdit;
	private JLabel lblSearch;
	public static InventorySearchFrame inventorySearchFrame;
	private JPanel panel_1;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel dtm;
	private IInventoryServiceManager inventorySerivceManger; 
	private String checkBoxNotSelected="<html><body><input type='checkbox'></body></html>";
	private String checkBoxSelected="<html><body><input type='checkbox' checked ></body></html>";
	private IInventoryServiceManager inventoryServiceManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventorySearchFrame frame = new InventorySearchFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static InventorySearchFrame getInstance() {
		if (inventorySearchFrame == null) {
			inventorySearchFrame = new InventorySearchFrame();
			inventorySearchFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			inventorySearchFrame.setVisible(true);
			inventorySearchFrame.setResizable(false);
		}
		inventorySearchFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		inventorySearchFrame.setVisible(true);
		inventorySearchFrame.setResizable(false);		
		return inventorySearchFrame;
	}

	/**
	 * Create the frame.
	 */
	public InventorySearchFrame() {
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		overrideDefaultTableModle();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Inventory Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 11, 1336, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("Search Item List");
		lblLogo.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblLogo.setBounds(20, 60, 285, 24);
		panel.add(lblLogo);
		
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame mainFrame = MainFrame.getInstance();
				inventorySearchFrame.setVisible(false);
				inventorySearchFrame = null;
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
		
//		lblEdit = new JLabel(new ImageIcon("img/edit.png"));
//		lblEdit.setToolTipText("Edit Item");
//		lblEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		lblEdit.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//
//			}
//		});
//		lblEdit.setBounds(830, 30, 150, 150);
//		panel.add(lblEdit);
		
		lblSearch = new JLabel(new ImageIcon("img/add.png"));
		lblSearch.setToolTipText("Search Item");
		lblSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InventoryManageFrame inventoryManageFrame = InventoryManageFrame.getInstance();
				inventorySearchFrame.setVisible(false);
				inventorySearchFrame = null;
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
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Result View", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 164, 1277, 505);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
        DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
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
                "Item ID",
                "Item Name",
                "Date",
                "Image",
                "Remark",
                "Update",
                "Delete",
                "Detail"
        };
		
		Object[][] data={};
		//dtm = new DefaultTableModel();
        dtm.setDataVector(data, columnNames);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 54, 1218, 426);
		panel_1.add(scrollPane);
		
		table = new JTable();
		Font font = new Font("Times New Roman", Font.PLAIN, 16);
		table.setFont(font);
		table.setModel(dtm);
		table.addMouseListener(new CheckBoxHandler());
		table.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
		// align checkbox to center
		table.getColumnModel().getColumn(0).setCellRenderer(r);
		table.getColumnModel().getColumn(1).setCellRenderer(r);
		table.getColumnModel().getColumn(2).setCellRenderer(r);
		table.getColumnModel().getColumn(3).setCellRenderer(r);
		table.getColumnModel().getColumn(4).setCellRenderer(r);
		table.getColumnModel().getColumn(5).setCellRenderer(r);
		// add button at update column 
		table.getColumn("Update").setCellRenderer(new ButtonRenderer());
		table.getColumn("Delete").setCellRenderer(new ButtonRenderer());
		table.getColumn("Detail").setCellRenderer(new ButtonRenderer());
		table.getColumn("Image").setCellRenderer(new ImageRender());
		
		table.getColumn("Update").setCellEditor(new ButtonEditorInventory(new JCheckBox()));
		table.getColumn("Delete").setCellEditor(new ButtonDeleteInventory(new JCheckBox()));
		table.getColumn("Detail").setCellEditor(new ButtonDetailInventory(new JCheckBox()));
		
		//updateRowHeights(table);
		table.setRowHeight(50);
	
		scrollPane.setViewportView(table);
		searchAll();
		
	}
	
	private void updateRowHeights(JTable table)
    {
        try
        {
            for (int row = 0; row < table.getRowCount(); row++)
            {
                int rowHeight = table.getRowHeight();

                for (int column = 0; column < table.getColumnCount(); column++)
                {
                    Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                    rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
                }

                table.setRowHeight(row, rowHeight);
            }
        }
        catch(ClassCastException e) {}
    }
	
    private void overrideDefaultTableModle(){
    	dtm = new DefaultTableModel() {
    		
    	   @Override
     	    public boolean isCellEditable(int row, int col) {
     	        //Note that the data/cell address is constant,
     	        //no matter where the cell appears onscreen.
     	        if (col >= 0 && col <=5) {
     	            return false;
     	        } else {
     	            return true;
     	        }
     	    }
    	};
    }
	
	public void searchAll() {
//		List<Style> itemList = new ArrayList<Style>();
//		inventorySerivceManger = (IInventoryServiceManager) BasicBeanFactory.getBean("InventoryServiceManager");
//		try {
//			itemList = inventorySerivceManger.findAll();
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		int i = 0 ;
//		for(InventoryItem iv : itemList) {
//				i++;
//			dtm.addRow(new Object[]{
//					i,
//					iv.getItemId(),
//					iv.getItemName(),
//					iv.getDate(),
//					iv.getImagePath(),
//					iv.getRemarks(),
//					"Edit",
//					"Delete",
//					"Detail"
//			});
//			ImageIcon icon = new ImageIcon(iv.getImagePath());
//			dtm.setValueAt(icon, i-1, 4);
//		}
	}
	
	class CheckBoxHandler implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			 int selectedRow = table.getSelectedRow();  
			 int selectedCol = table.getSelectedColumn();

			 if(selectedCol == 6) {
				 Conversation.addConversation("SelectedInventoryEdit", dtm.getValueAt(selectedRow, 1));
				 InventoryEditFrame inventoryEditFrame = InventoryEditFrame.getInstance();
				 inventorySearchFrame.setVisible(false);
				 inventorySearchFrame = null;
			 }
			 if(selectedCol == 7) {
				 delete(dtm.getValueAt(selectedRow, 1)+"");
			 }
			 if(selectedCol == 8) {
				 Conversation.addConversation("SelectedInventoryEdit", dtm.getValueAt(selectedRow, 1));
				 InventoryDetailFrame inventoryDetailFrame = InventoryDetailFrame.getInstance();
				 inventorySearchFrame.setVisible(false);
				 inventorySearchFrame = null;
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
	
	public void destroy() {

	}
	
	public void delete(String itemId) {
		inventoryServiceManager = (IInventoryServiceManager) BasicBeanFactory.getBean("InventoryServiceManager");
		try {
			inventoryServiceManager.removeItem(itemId);
			JOptionPane.showMessageDialog(null, "Successfully Delete Item.",
					"Success Info", JOptionPane.INFORMATION_MESSAGE);
			removeAllRow();
			searchAll();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to Delete Item.",
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
}
