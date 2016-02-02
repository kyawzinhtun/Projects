package org.amaris.presentation.CuttingManageForm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;

import org.amaris.presentation.BalanceManageForm.DetailItemBalanceFrame;
import org.amaris.presentation.CuttingManageForm.CuttingManageFrame.CheckBoxHandler;
import org.amaris.presentation.mainForm.TemplateFrame;
import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.balanceManage.StockBalance;
import org.amaris.service.cuttingManage.DraffCut;
import org.amaris.util.Conversation;
import org.apache.commons.lang.StringUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

public class CuttingEdit extends JFrame {

	private JPanel contentPane;
	public static CuttingEdit cutEditFrame;
	private JTextPane txtCutValue = new JTextPane();
	private JTextPane txtTotalPrice = new JTextPane();
	private JTextPane txtQty = new JTextPane();
	private JTextPane txtCutPrice = new JTextPane();
	private JTextPane txtID = new JTextPane();
	private DefaultTableModel dtm;
	JTextPane txtUnit = new JTextPane();
	JTextPane txtQtyInches = new JTextPane();
	JTextPane txtDraffId = new JTextPane();
	JTextPane txtCutInches = new JTextPane();
	JTextPane txtDraffTotalCut = new JTextPane();
	JTextPane txtTotalCutProcress = new JTextPane();
	private JTable table;
	private int flag = 0;
	
	
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuttingEdit frame = new CuttingEdit();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static CuttingEdit getInstance() {
			cutEditFrame = new CuttingEdit();
			cutEditFrame.setVisible(true);
			cutEditFrame.setResizable(false);
			return cutEditFrame;
	}

	/**
	 * Create the frame.
	 */
	public CuttingEdit() {
		setBounds(100, 100, 949, 468);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BalanceDetail bd = (BalanceDetail)Conversation.getConversationValue("cuttingDetail");
		
		overrideDefaultTableModle();
				
		JLabel lblTotalQty = new JLabel("Total QTY");
		lblTotalQty.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTotalQty.setBounds(10, 113, 98, 24);
		contentPane.add(lblTotalQty);
		
		txtQty = new JTextPane();
		txtQty.setBounds(132, 113, 135, 24);
		contentPane.add(txtQty);
		txtQty.setText(bd.getStockQuantity());
		
		
		
		JLabel lblCutValue = new JLabel("Cut Value");
		lblCutValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCutValue.setBounds(10, 205, 98, 24);
		contentPane.add(lblCutValue);
		
		txtUnit.setBounds(132, 69, 135, 24);
		contentPane.add(txtUnit);
		if(bd.getDetailUnitCount().contains("KG")) {
			txtUnit.setText("KG");
		}
		else if(bd.getDetailUnitCount().contains("Pack")){
			txtUnit.setText("Pack");
			txtQtyInches.setVisible(false);
			txtCutInches.setVisible(false);
		}
		else if(bd.getDetailUnitCount().contains("Yar")){
			txtUnit.setText("Yard");
		}
		else {
			txtUnit.setText("Unit");
			txtQtyInches.setVisible(false);
			txtCutInches.setVisible(false);
		}
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTotalPrice.setBounds(10, 159, 98, 24);
		contentPane.add(lblTotalPrice);
		
		txtTotalPrice.setBounds(132, 159, 135, 24);
		contentPane.add(txtTotalPrice);
		txtTotalPrice.setText(bd.getTotalPrice());
		
		JLabel lblCutPrice = new JLabel("Cut Price");
		lblCutPrice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCutPrice.setBounds(10, 253, 98, 24);
		contentPane.add(lblCutPrice);
		
		txtCutPrice = new JTextPane();
		txtCutPrice.setEditable(false);
		txtCutPrice.setBounds(132, 253, 135, 24);
		contentPane.add(txtCutPrice);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cutValue = txtCutValue.getText();
				int stockQtyId = Integer.valueOf(txtID.getText()+"");
				String cutPrice = txtCutPrice.getText();
				BalanceDetail bd = new BalanceDetail();
				BalanceDetail bd2 = new BalanceDetail();
				bd.setStockQtyId(stockQtyId);
				bd.setStockQuantity(cutValue);
				bd.setDetailUnitCount(txtUnit.getText());
				if(txtUnit.getText().contains("Unit")||txtUnit.getText().contains("Pack")) {
					bd.setQtyInches(txtCutValue.getText());
				}
				else {
					bd.setQtyInches(txtCutInches.getText());
				}
				bd.setTotalPrice(cutPrice);
				DetailItemBalanceFrame.paramBalanceAfterDetailList.add(bd);
				CuttingManageFrame.cuttingList.add(bd);
				double mstBalceQty =  Double.parseDouble(txtQty.getText()+"") - Double.parseDouble(cutValue);
				double dcutPrice = Double.parseDouble(cutPrice);
				double dTotaPricce = Double.parseDouble(txtTotalPrice.getText());
				double mstBalancePrice = dTotaPricce - dcutPrice;
				bd2.setStockQtyId(stockQtyId);
				bd2.setStockQuantity(mstBalceQty+"");
				bd2.setTotalPrice(mstBalancePrice+"");
				DetailItemBalanceFrame.paramMasterBalanceDetailList.add(bd2);
				cutEditFrame.setVisible(false);
				cutEditFrame=null;
			}
		});
		btnNewButton.setFont(new Font("Tunga", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 297, 89, 24);
		contentPane.add(btnNewButton);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblId.setBounds(10, 26, 98, 24);
		contentPane.add(lblId);
		
		txtID = new JTextPane();
		txtID.setEditable(false);
		txtID.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtID.setBounds(132, 26, 135, 24);
		contentPane.add(txtID);
		txtID.setText(bd.getStockQtyId()+"");
		
		txtCutValue = new JTextPane();
		txtCutValue.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				flag = 2;
			}
		});
		txtCutValue.setBounds(132, 205, 135, 24);
		contentPane.add(txtCutValue);
		
		
		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUnit.setBounds(10, 69, 98, 24);
		contentPane.add(lblUnit);
		
		txtQtyInches.setBounds(296, 113, 135, 24);
		contentPane.add(txtQtyInches);
		double inches = Double.parseDouble(bd.getStockQuantity());
		txtQtyInches.setText((inches*36)+"");
		txtCutInches.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				flag = 1;
			}
		});
		
		txtCutInches.setBounds(296, 205, 135, 24);
		contentPane.add(txtCutInches);
		
		txtCutInches.getDocument().addDocumentListener(new DocumentListener() {

			public void insertUpdate(DocumentEvent e) {
				if(flag==1 && !StringUtils.isBlank(txtCutInches.getText().trim())) {
				try {
					double totalPrice = Double.valueOf(txtTotalPrice.getText());
					double qty = Double.valueOf(txtQtyInches.getText());
					double perPrice = totalPrice / qty;
					String sCutInches = txtCutInches.getText().trim();
					double cutPrice = Double.valueOf(sCutInches);
					double cutValue =	perPrice * cutPrice;
					txtCutPrice.setText(cutValue+"");
					txtCutValue.setText((cutPrice/36)+"");
					
					
				}
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please Insert Number!",
							"Error Info", JOptionPane.ERROR_MESSAGE);
					txtCutPrice.setText("0");

				}
				}
			}


			public void removeUpdate(DocumentEvent e) {
				if(flag==1 && !StringUtils.isBlank(txtCutInches.getText().trim())) {
				try {
					double totalPrice = Double.valueOf(txtTotalPrice.getText());
					double qty = Double.valueOf(txtQtyInches.getText());
					double perPrice = totalPrice / qty;
					String sCutInches = txtCutInches.getText().trim();
					double cutPrice = Double.valueOf(sCutInches);
					double cutValue =	perPrice * cutPrice;
					txtCutPrice.setText(cutValue+"");
					
						txtCutValue.setText((cutPrice/36)+"");
					
				}
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please Insert Number!",
							"Error Info", JOptionPane.ERROR_MESSAGE);
					txtCutPrice.setText("0");

				}
				}
			}


			public void changedUpdate(DocumentEvent e) {
				if(flag==1 && !StringUtils.isBlank(txtCutInches.getText().trim())) {
				try {
					double totalPrice = Double.valueOf(txtTotalPrice.getText());
					double qty = Double.valueOf(txtQtyInches.getText());
					double perPrice = totalPrice / qty;
					String sCutInches = txtCutInches.getText().trim();
					double cutPrice = Double.valueOf(sCutInches);
					double cutValue =	perPrice * cutPrice;
					txtCutPrice.setText(cutValue+"");
					
						txtCutValue.setText((cutPrice/36)+"");
					
				}
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please Insert Number!",
							"Error Info", JOptionPane.ERROR_MESSAGE);
					txtCutPrice.setText("0");

				}
				}
			}
		});
		
		
		JPanel panel = new JPanel();
		panel.setBounds(463, 11, 460, 409);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDraffTotalCut = new JLabel("Draff Total Cut");
		lblDraffTotalCut.setBounds(10, 56, 137, 24);
		lblDraffTotalCut.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblDraffTotalCut);
		
		JLabel lblTotalCut = new JLabel("Total Cut");
		lblTotalCut.setBounds(10, 103, 137, 24);
		lblTotalCut.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblTotalCut);
		
		String draffId = CuttingManageFrame.paramCuttingCode+DetailItemBalanceFrame.paramStockId;
		
		txtDraffId.setBounds(149, 11, 135, 24);
		panel.add(txtDraffId);
		txtDraffId.setText(draffId);
		
		for(DraffCut df : CuttingManageFrame.draffCutList ) {
			if(df.getDraffId().equals(draffId)) {
				txtDraffTotalCut.setText(df.getRealWithDraw());
			}
		}
		
		txtDraffTotalCut.setBounds(149, 56, 135, 24);
		panel.add(txtDraffTotalCut);
		
		txtTotalCutProcress.setBounds(149, 103, 135, 24);
		panel.add(txtTotalCutProcress);
		
		JLabel lblDraffId = new JLabel("Draff ID");
		lblDraffId.setBounds(10, 11, 98, 24);
		panel.add(lblDraffId);
		lblDraffId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
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
		
		String[] columnNames = {
                "No",
                "StockId",
                "cutValue",
        };
		
		Object[][] data={};
        dtm.setDataVector(data, columnNames);
		
		table = new JTable();
		table.setBounds(23, 165, 416, 220);
		
		Font font = new Font("Times New Roman", Font.PLAIN, 16);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
		table.setFont(font);
		table.setModel(dtm);
		// align checkbox to center
		table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		table.addMouseListener(new CheckBoxHandler());
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 440, 245);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(305, 11, 89, 23);
		panel.add(btnRemove);
		
		txtCutValue.getDocument().addDocumentListener(new DocumentListener() {

			public void insertUpdate(DocumentEvent e) {
				if(flag==2 && !StringUtils.isBlank(txtCutValue.getText().trim())) {
				try {
					double totalPrice = Double.valueOf(txtTotalPrice.getText());
					double qty = Double.valueOf(txtQty.getText());
					double perPrice = totalPrice / qty;
					String sCutValue = txtCutValue.getText().trim();
					double cutPrice = Double.valueOf(sCutValue);
					double cutValue =	perPrice * cutPrice;
					txtCutPrice.setText(cutValue+"");
					txtCutInches.setText((cutPrice*36)+"");
				}
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please Insert Number!",
							"Error Info", JOptionPane.ERROR_MESSAGE);
					txtCutPrice.setText("0");

				}
				}
			}


			public void removeUpdate(DocumentEvent e) {
				if(flag==2 && !StringUtils.isBlank(txtCutValue.getText().trim())) {
				try {
					double totalPrice = Double.valueOf(txtTotalPrice.getText());
					double qty = Double.valueOf(txtQty.getText());
					double perPrice = totalPrice / qty;
					String sCutValue = txtCutValue.getText().trim();
					double cutPrice = Double.valueOf(sCutValue);
					double cutValue =	perPrice * cutPrice;
					txtCutPrice.setText(cutValue+"");
					txtCutInches.setText((cutPrice*36)+"");
					}
				
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please Insert Number!",
							"Error Info", JOptionPane.ERROR_MESSAGE);
					txtCutPrice.setText("0");
				}
				}
			}


			public void changedUpdate(DocumentEvent e) {
				if(flag==2 && !StringUtils.isBlank(txtCutValue.getText().trim())) {
				try {
					double totalPrice = Double.valueOf(txtTotalPrice.getText());
					double qty = Double.valueOf(txtQty.getText());
					double perPrice = totalPrice / qty;
					String sCutValue = txtCutValue.getText().trim();
					double cutPrice = Double.valueOf(sCutValue);
					double cutValue =	perPrice * cutPrice;
					txtCutPrice.setText(cutValue+"");
					txtCutInches.setText((cutPrice*36)+"");
					
				}
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please Insert Number!",
							"Error Info", JOptionPane.ERROR_MESSAGE);
					txtCutPrice.setText("0");

				}
				}
			}
		});
		
		initializedData();
	}
	
class CheckBoxHandler implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			 int selectedRow = table.getSelectedRow();  
			 int selectedCol = table.getSelectedColumn();

			 if(selectedCol == 3) {
					StockBalance sb = new StockBalance();
					sb.setStockId(Integer.valueOf(dtm.getValueAt(selectedRow, 0)+""));
					sb.setStockInId((String)dtm.getValueAt(selectedRow, 1));
					sb.setStockName((String)dtm.getValueAt(selectedRow, 2));
					Conversation.addConversation("cutting", sb);
					Conversation.addConversation("Flag", "Cut");
					DetailItemBalanceFrame detailItemBalanceFrame = DetailItemBalanceFrame.getInstance();
			 }
			 if(selectedCol == 1) {
				DifferenceBalance db = DifferenceBalance.getInstance(dtm.getValueAt(selectedRow, 1)+"");

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
	
	private void overrideDefaultTableModle(){
		dtm = new DefaultTableModel() {
			
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
	
	private void initializedData() {
		if(CuttingManageFrame.cuttingList.size()!=0) {
			List<BalanceDetail> initList = CuttingManageFrame.cuttingList;
			double totalLength=0.0;
			int i=1;
				for(BalanceDetail bd : initList) {
	        		dtm.addRow(new Object[]{
						i,
						bd.getStockQtyId(),
						bd.getQtyInches()
	        		});
	        		totalLength = totalLength + Double.valueOf(bd.getQtyInches());
	        		i++;
				}
			txtTotalCutProcress.setText(totalLength+"");
		}
		//for()
	}
}
