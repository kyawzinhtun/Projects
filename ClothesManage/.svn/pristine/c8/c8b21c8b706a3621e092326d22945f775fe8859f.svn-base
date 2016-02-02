package org.amaris.presentation.CuttingManageForm;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import org.amaris.presentation.BalanceManageForm.DetailItemBalanceFrame;
import org.amaris.presentation.CuttingManageForm.CuttingSearch.CheckBoxHandler;
import org.amaris.service.balanceManage.BalanceDetail;
import org.amaris.service.cuttingManage.CuttingMain;
import org.amaris.service.cuttingManage.DraffCut;
import org.apache.commons.lang.StringUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CuttingDetailFrame extends JFrame {

	private JPanel contentPane;
	public static CuttingDetailFrame draffEditingFrame;
	JTextPane txtCuttingID = new JTextPane();
	private JTable table;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;
	private List<BalanceDetail> detailList = new ArrayList<BalanceDetail>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuttingDetailFrame frame = new CuttingDetailFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static CuttingDetailFrame getInstance() {
		draffEditingFrame = new CuttingDetailFrame();
		draffEditingFrame.setVisible(true);
		draffEditingFrame.setResizable(false);
		return draffEditingFrame;
	}

	/**
	 * Create the frame.
	 */
	public CuttingDetailFrame() {
		setTitle("Cutting Detail");
		setBounds(100, 100, 750, 500);
		overrideDefaultTableModle();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Cutting ID");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblId.setBounds(10, 57, 98, 24);
		contentPane.add(lblId);
		
		txtCuttingID.setBounds(118, 57, 135, 24);
		txtCuttingID.setText(CuttingManageFrame.paramCuttingCode);
		contentPane.add(txtCuttingID);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBounds(41, 408, 89, 33);
		contentPane.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnClear.setBounds(183, 408, 89, 33);
		contentPane.add(btnClear);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "stock detail", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 132, 714, 252);
		contentPane.add(panel);
		panel.setLayout(null);
		
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
                "stock ID",
                "Cut Yard",
                "Cut Inches",
                "Cutting Price",
                "Cutting Unit",
         };

		Object[][] data={};
		dtm.setDataVector(data, columnNames);
		
		table = new JTable();
		table.setBounds(25, 35, 663, 192);
		Font font = new Font("Times New Roman", Font.PLAIN, 16);
		table.setFont(font);
		table.setModel(dtm);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
		
		// align checkbox to center
		table.getColumnModel().getColumn(0).setCellRenderer(r);
		table.getColumnModel().getColumn(1).setCellRenderer(r);
		table.getColumnModel().getColumn(2).setCellRenderer(r);
		table.getColumnModel().getColumn(3).setCellRenderer(r);
		table.getColumnModel().getColumn(4).setCellRenderer(r);
		table.getColumnModel().getColumn(5).setCellRenderer(r);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 694, 220);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);	
	}
	
	private void overrideDefaultTableModle(){
    	dtm = new DefaultTableModel() {
    		
     	    public boolean isCellEditable(int row, int col) {
     	        //Note that the data/cell address is constant,
     	        //no matter where the cell appears onscreen.
     	        if (col >= 0 && col <=7) {
     	            return false;
     	        } else {
     	            return true;
     	        }
     	    }
    	};
    }

	public List<BalanceDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<BalanceDetail> detailList) {
		this.detailList = detailList;
		initDataList(detailList);
	}
	
	private void initDataList(List<BalanceDetail> detailList) {
		List<BalanceDetail> resultList = detailList;
		int i=0;
		for(BalanceDetail bm : resultList) {
			dtm.addRow(new Object[]{
					i+1,
					bm.getStockQtyId(),
					bm.getStockQuantity(),
					bm.getQtyInches(),
					bm.getStockPrice(),
					bm.getDetailUnitCount()
			});
			i++;
		}
	}
}
