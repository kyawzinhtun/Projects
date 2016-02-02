package org.amaris.presentation.LineForm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import org.amaris.presentation.LineForm.LineShareDetailFrame.CheckBoxHandler;
import org.amaris.service.lineManager.ILineServiceManager;
import org.amaris.service.lineManager.StockView;
import org.amaris.util.BasicBeanFactory;
import org.apache.commons.lang.StringUtils;
import org.jdesktop.swingx.JXTipOfTheDay.ShowOnStartupChoice;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class AccessoriesLinePopUp extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;
	private ILineServiceManager iLineServiceManager;
	public static AccessoriesLinePopUp accessoriesLinePopUp;
	public String lineId;
	public int rowCount=0;
	private JTextField txtSearchId;
	private JTextField txtStockId;
	private JTextField txtQty;
	private JLabel lblAccessoriesAdding;
	public String totalPrice;
	public String totalQty;
	public String accessoriesName;	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessoriesLinePopUp frame = new AccessoriesLinePopUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static AccessoriesLinePopUp getInstance(String lineId) {
		accessoriesLinePopUp = new AccessoriesLinePopUp();
		accessoriesLinePopUp.setVisible(true);
		accessoriesLinePopUp.setResizable(false);
		accessoriesLinePopUp.lineId = lineId;
		return accessoriesLinePopUp;
}

	/**
	 * Create the frame.
	 */
	public AccessoriesLinePopUp() {
		setBounds(100, 100, 722, 429);
		setTitle("Accessories Adding");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		overrideDefaultTableModle();
		iLineServiceManager = (ILineServiceManager) BasicBeanFactory.getBean("LineServiceManager");		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<StockView> stockViewList = iLineServiceManager.getAccessoriesById(txtSearchId.getText()+"");
				buildAccessoriesTable(stockViewList);
			}
		});
		btnSearch.setBounds(10, 74, 100, 30);
		contentPane.add(btnSearch);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(10, 115, 100, 30);
		contentPane.add(btnExit);
		
		String[] columnNames = {
                "No",
                "Id",
                "Name",
                "Unit",
                "Total Price",
         };

		Object[][] data={};
		dtm.setDataVector(data, columnNames);
		
		table = new JTable();
		table.setBounds(25, 35, 663, 192);
		Font font = new Font("Times New Roman", Font.PLAIN, 14);
		table.setFont(font);
		table.setModel(dtm);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
		
		// align checkbox to center
		table.getColumnModel().getColumn(0).setCellRenderer(r);
		table.getColumnModel().getColumn(1).setCellRenderer(r);
		table.getColumnModel().getColumn(2).setCellRenderer(r);
		table.getColumnModel().getColumn(3).setCellRenderer(r);
		table.getColumnModel().getColumn(4).setCellRenderer(r);
		table.addMouseListener(new CheckBoxHandler());
				
		scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 118, 527, 252);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);	
		
		txtSearchId = new JTextField();
		txtSearchId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtSearchId.setBounds(141, 74, 122, 25);
		contentPane.add(txtSearchId);
		txtSearchId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Line");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(293, 81, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtStockId = new JTextField();
		txtStockId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtStockId.setColumns(10);
		txtStockId.setBounds(349, 74, 46, 25);
		contentPane.add(txtStockId);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuantity.setBounds(415, 82, 61, 14);
		contentPane.add(lblQuantity);
		
		txtQty = new JTextField();
		txtQty.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtQty.setColumns(10);
		txtQty.setBounds(475, 74, 74, 25);
		contentPane.add(txtQty);
		
		lblAccessoriesAdding = new JLabel("Accessories Adding");
		lblAccessoriesAdding.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAccessoriesAdding.setBounds(10, 21, 152, 25);
		contentPane.add(lblAccessoriesAdding);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String accessoriesId = txtStockId.getText()+"";
					int stockQuantity = Integer.parseInt(StringUtils.substringBefore(txtQty.getText()+"", "."));
					int totalUnitQty = Integer.parseInt(StringUtils.substringBefore(totalQty, ".")); 
					int totalUnitPrice = Integer.parseInt(StringUtils.substringBefore(totalPrice, "."));
					if(stockQuantity>totalUnitQty) {
						JOptionPane.showMessageDialog(null, "Out of stock",
								"Error Info", JOptionPane.ERROR_MESSAGE);
					}
					else {
						 int remainUnit=totalUnitQty-stockQuantity;
						 double perAccPrice = totalUnitPrice/totalUnitQty;
						 List<StockView> svList= LineShareDetailFrame.lineAccessoriesMap.get(lineId);
						 if(svList==null) {
							 svList  = new ArrayList<StockView>();
						 }
						 StockView sv = new StockView(); 
						 sv.setStockDetailId(txtStockId.getText()+"");
						 sv.setStockQtyId(txtStockId.getText()+"");
						 sv.setStockPrice(perAccPrice+"");
						 sv.setStockQuantity(txtQty.getText()+"");
						 sv.setStockName(accessoriesName);
						 svList.add(sv);
//							Assessories assessories = new Assessories(asName, asQuantity, asPrice, mstCode)
//							iAssessoriesServiceManager.addAssessories(assessories);
						 LineShareDetailFrame.lineAccessoriesMap.put(lineId, svList);
						 JOptionPane.showMessageDialog(null, "SuccessFully Add",
									"Info", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(NumberFormatException ne) {
					JOptionPane.showMessageDialog(null, "Fill only nuber in quantity text box",
							"Error Info", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception ex) {
					
				}
			}
		});
		btnAdd.setBounds(567, 74, 100, 30);
		contentPane.add(btnAdd);
	}
	
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
    
    private void overrideDefaultTableModle(){
    	dtm = new DefaultTableModel() {
    		
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
    
    public void buildAccessoriesTable(List<StockView> stockViewList) {
    	removeAllRow();
    	int i=0;
    	if(stockViewList.size()!=0) {
    		for(StockView sv : stockViewList) {
    			dtm.addRow(new Object[]{
    					rowCount=rowCount+1,
						sv.getStockQtyId(),
						sv.getStockName(),
						sv.getStockQuantity(),
						sv.getTotalPrice(),
				});
    		}
    	}
    }
    
    public void removeAllRow() {
    	rowCount =0;
		if(dtm.getRowCount()!=0) {
			for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
			    dtm.removeRow(i);
			}
		}
	}
    
class CheckBoxHandler implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			 int selectedRow = table.getSelectedRow();  
			 int selectedCol = table.getSelectedColumn();
			 txtStockId.setText(dtm.getValueAt(selectedRow, 1)+""); 
			 totalQty  = dtm.getValueAt(selectedRow, 3)+"";
			 totalPrice = dtm.getValueAt(selectedRow, 4)+"";
			 accessoriesName = dtm.getValueAt(selectedRow, 2)+"";
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
