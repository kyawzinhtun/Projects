package org.amaris.presentation.CuttingManageForm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.amaris.presentation.mainForm.TemplateFrame;
import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.inventoryManage.Style;
import org.amaris.service.inventoryManage.StyleInclude;
import org.amaris.util.Conversation;

import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DifferenceBalance extends JFrame {
	public static DifferenceBalance differenceBalance;
	private JPanel contentPane;
	private JTable cut_BalanceTale;
	private JTable new_BalanceTale;
	private DefaultTableModel cutDtm;
	private DefaultTableModel newDtm;
	JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextField txtProductTotalPrice;
	private JLabel lblPerPrice;
	private JTextField txtPerPrice;
	private JTextField txtFistPrice;
	private JTextField txtSecondPrice;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DifferenceBalance frame = new DifferenceBalance("");
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static DifferenceBalance getInstance(String id) {
		differenceBalance = new DifferenceBalance(id);
		differenceBalance.setVisible(true);
		differenceBalance.setResizable(false);
		return differenceBalance;
	}

	/**
	 * Create the frame.
	 */
	public DifferenceBalance(String id) {
		
		setTitle("Clothes Management System");
		setBounds(0, 0, 914, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		overrideDefaultTableModle();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Stock Balance Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 11, 868, 399);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("Balance Difference");
		lblLogo.setFont(new Font("Castellar", Font.PLAIN, 16));
		lblLogo.setBounds(10, 22, 285, 24);
		panel.add(lblLogo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Cut Value", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 57, 406, 260);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 386, 227);
		panel_1.add(scrollPane);
		
		cut_BalanceTale = new JTable();
		cut_BalanceTale.setBounds(20, 22, 252, 215);
		scrollPane.setColumnHeaderView(cut_BalanceTale);
		
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object
                value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
		
		String[] cut_columnNames = {
                "ID",
                "Qty",
                "Qty_inc",
                "Price"
        };
		
		Object[][] cut_data={};
		cutDtm.setDataVector(cut_data, cut_columnNames);
		Font font = new Font("Times New Roman", Font.PLAIN, 12);
		cut_BalanceTale.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
		cut_BalanceTale.setFont(font);
		cut_BalanceTale.setModel(cutDtm);
		cut_BalanceTale.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		cut_BalanceTale.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		cut_BalanceTale.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		cut_BalanceTale.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		scrollPane.setViewportView(cut_BalanceTale);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "New_Balance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(436, 57, 411, 260);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 24, 391, 225);
		panel_2.add(scrollPane_1);
		
		new_BalanceTale = new JTable();
		new_BalanceTale.setBounds(20, 22, 270, 215);
		scrollPane_1.setColumnHeaderView(new_BalanceTale);
		

		
		String[] new_columnNames = {
                "ID",
                "Qty",
                "Price"
        };
		
		Object[][] new_data={};
		newDtm.setDataVector(new_data, new_columnNames);
		
		Font font2 = new Font("Times New Roman", Font.PLAIN, 12);
		new_BalanceTale.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
		new_BalanceTale.setFont(font2);
		new_BalanceTale.setModel(newDtm);
		new_BalanceTale.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		new_BalanceTale.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		new_BalanceTale.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		scrollPane_1.setViewportView(new_BalanceTale);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTotalPrice.setBounds(30, 328, 79, 14);
		panel.add(lblTotalPrice);
		
		txtProductTotalPrice = new JTextField();
		txtProductTotalPrice.setEnabled(false);
		txtProductTotalPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtProductTotalPrice.setBounds(124, 326, 171, 20);
		panel.add(txtProductTotalPrice);
		txtProductTotalPrice.setColumns(10);
		
		lblPerPrice = new JLabel("Per Price");
		lblPerPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPerPrice.setBounds(30, 361, 79, 14);
		panel.add(lblPerPrice);
		
		txtPerPrice = new JTextField();
		txtPerPrice.setEnabled(false);
		txtPerPrice.setText("0.0");
		txtPerPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtPerPrice.setColumns(10);
		txtPerPrice.setBounds(124, 359, 171, 20);
		panel.add(txtPerPrice);
		
		JButton btnSaveFirstStep = new JButton("Save First Step Price");
		btnSaveFirstStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuttingManageFrame.perUnitPrice = txtPerPrice.getText();
				txtFistPrice.setText(CuttingManageFrame.perUnitPrice);
			}
		});
		btnSaveFirstStep.setBounds(437, 328, 199, 23);
		panel.add(btnSaveFirstStep);
		
		JButton btnSaveSecondStep = new JButton("Save Second Step Price");
		btnSaveSecondStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double firstPrice = Double.parseDouble(CuttingManageFrame.perUnitPrice);
				double secondPrice = Double.parseDouble(txtPerPrice.getText());
				double finalPrice = secondPrice - firstPrice;
				CuttingManageFrame.perIncludeUnitPrice = finalPrice+"";
				txtSecondPrice.setText(CuttingManageFrame.perIncludeUnitPrice);
			}
		});
		btnSaveSecondStep.setBounds(437, 358, 199, 23);
		panel.add(btnSaveSecondStep);
		
		txtFistPrice = new JTextField();
		txtFistPrice.setEnabled(false);
		txtFistPrice.setBounds(654, 329, 159, 20);
		panel.add(txtFistPrice);
		txtFistPrice.setColumns(10);
		
		txtSecondPrice = new JTextField();
		txtSecondPrice.setEnabled(false);
		txtSecondPrice.setBounds(654, 359, 159, 20);
		panel.add(txtSecondPrice);
		txtSecondPrice.setColumns(10);
		
		initializedTale(id);
	}
	
	private void overrideDefaultTableModle(){
		cutDtm = new DefaultTableModel() {
    		
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
    	
    	newDtm = new DefaultTableModel() {
    		
     	   @Override
      	    public boolean isCellEditable(int row, int col) {
      	        //Note that the data/cell address is constant,
      	        //no matter where the cell appears onscreen.
      	        if (col >= 0 && col <=2) {
      	            return false;
      	        } else {
      	            return true;
      	        }
      	    }
     	};
    }
	
	public void initializedTale(String id) {
		List<BalanceDetail> cutbdList = (List<BalanceDetail>) Conversation.getConversationValue(id);
		List<BalanceDetail> newbdList = (List<BalanceDetail>) Conversation.getConversationValue(id+"msb");
		Double totalPrice=0.0;
		for(BalanceDetail bd : cutbdList) {
        		cutDtm.addRow(new Object[]{
					bd.getStockQtyId(),
					bd.getStockQuantity(),
					bd.getQtyInches(),
					bd.getTotalPrice()
        		});
        		totalPrice = totalPrice + Double.valueOf(bd.getTotalPrice());
        }
		txtProductTotalPrice.setText(totalPrice+"");
		CuttingManageFrame.totalUnitPrice = totalPrice+"";
		for(BalanceDetail bd : newbdList) {
    		newDtm.addRow(new Object[]{
				bd.getStockQtyId(),
				bd.getStockQuantity(),
				bd.getTotalPrice()
    		});
    }
		String totalProduct = CuttingManageFrame.getDraffCutList().get(0).totalUnit;
		Double dtotalProduct = Double.parseDouble(totalProduct);
		Double perPrice = totalPrice/dtotalProduct;
		txtPerPrice.setText(perPrice+"");
	}
}
