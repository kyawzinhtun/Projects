package org.amaris.presentation.CuttingManageForm;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import org.amaris.presentation.BalanceManageForm.DetailItemBalanceFrame;
import org.amaris.service.cuttingManage.DraffCut;
import org.apache.commons.lang.StringUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.UIManager;

public class DraffEditingFrame extends JFrame {

	private JPanel contentPane;
	public static DraffEditingFrame draffEditingFrame;
	JTextPane txtStockId = new JTextPane();
	JTextPane txtCuttingID = new JTextPane();
	JTextPane txtPerUnitLength = new JTextPane();
	JTextPane txtTotalUnit = new JTextPane();
	JTextPane txtTotalLength = new JTextPane();
	JTextPane txtCutLength = new JTextPane();
	JTextPane txtSize = new JTextPane();
	JTextPane txtPerUnitInclude = new JTextPane();
	JTextPane txtTotalUnit2 = new JTextPane();
	JTextPane txtSizeUnit = new JTextPane();
	JTextPane txtWithDrawUnit = new JTextPane();
	JTextPane txtTotalInclude = new JTextPane();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DraffEditingFrame frame = new DraffEditingFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static DraffEditingFrame getInstance() {
		draffEditingFrame = new DraffEditingFrame();
		draffEditingFrame.setVisible(true);
		draffEditingFrame.setResizable(false);
		return draffEditingFrame;
	}

	/**
	 * Create the frame.
	 */
	public DraffEditingFrame() {
		setTitle("Draff");
		setBounds(100, 100, 750, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtStockId.setBounds(183, 100, 135, 24);
		contentPane.add(txtStockId);
		txtStockId.setText(DetailItemBalanceFrame.paramStockId);
		
		JLabel lblId = new JLabel("Cutting ID");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblId.setBounds(41, 57, 98, 24);
		contentPane.add(lblId);
		
		JLabel lblUnit = new JLabel("Stock ID");
		lblUnit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUnit.setBounds(41, 100, 98, 24);
		contentPane.add(lblUnit);
		
		txtCuttingID.setBounds(183, 57, 135, 24);
		txtCuttingID.setText(CuttingManageFrame.paramCuttingCode);
		contentPane.add(txtCuttingID);
		
		JLabel lblUnitLength = new JLabel("1 Unit Length");
		lblUnitLength.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUnitLength.setBounds(41, 147, 121, 24);
		contentPane.add(lblUnitLength);
		
		JLabel lblTotalUnit = new JLabel("Total Unit");
		lblTotalUnit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTotalUnit.setBounds(41, 192, 121, 24);
		contentPane.add(lblTotalUnit);
		
		JLabel lblTotalLength = new JLabel("Total Length");
		lblTotalLength.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTotalLength.setBounds(41, 239, 121, 24);
		contentPane.add(lblTotalLength);
		
		JLabel lblCutLength = new JLabel("Cut Length");
		lblCutLength.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCutLength.setBounds(41, 289, 121, 24);
		contentPane.add(lblCutLength);
		
		
		txtPerUnitLength.setBounds(183, 147, 135, 24);
		contentPane.add(txtPerUnitLength);
		
		txtTotalUnit.setBounds(183, 192, 135, 24);
		contentPane.add(txtTotalUnit);
	
		txtTotalLength.setBounds(183, 239, 135, 24);
		contentPane.add(txtTotalLength);
		
		txtTotalLength.getDocument().addDocumentListener(new DocumentListener() {


			public void insertUpdate(DocumentEvent e) {
				String perUnitLenght = txtPerUnitLength.getText();
				if(!StringUtils.isEmpty(perUnitLenght)) {
					String totalUnit = txtTotalLength.getText();
					if(!StringUtils.isEmpty(totalUnit)) {
						Double dperUnitLengt = Double.parseDouble(perUnitLenght);
						Double dtotalUnitLength = Double.parseDouble(totalUnit);
						Double dtotalUnit = (dtotalUnitLength / dperUnitLengt);
						txtTotalUnit.setText(dtotalUnit+"");
					}
				}
			}


			public void removeUpdate(DocumentEvent e) {
				String perUnitLenght = txtPerUnitLength.getText();
				if(!StringUtils.isEmpty(perUnitLenght)) {
					String totalUnit = txtTotalLength.getText();
					if(!StringUtils.isEmpty(totalUnit)) {
						Double dperUnitLengt = Double.parseDouble(perUnitLenght);
						Double dtotalUnitLength = Double.parseDouble(totalUnit);
						Double dtotalUnit = (dtotalUnitLength / dperUnitLengt);
						txtTotalUnit.setText(dtotalUnit+"");
					}
				}
			}


			public void changedUpdate(DocumentEvent e) {
				String perUnitLenght = txtPerUnitLength.getText();
				if(!StringUtils.isEmpty(perUnitLenght)) {
					String totalUnit = txtTotalLength.getText();
					if(!StringUtils.isEmpty(totalUnit)) {
						Double dperUnitLengt = Double.parseDouble(perUnitLenght);
						Double dtotalUnitLength = Double.parseDouble(totalUnit);
						Double dtotalUnit = (dtotalUnitLength / dperUnitLengt);
						txtTotalUnit.setText(dtotalUnit+"");
					}
				}
			}
		});
			
		
		
		txtCutLength.setBounds(183, 289, 135, 24);
		contentPane.add(txtCutLength);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSize.setBounds(41, 336, 121, 24);
		contentPane.add(lblSize);
		
		
		txtSize.setBounds(183, 336, 135, 24);
		contentPane.add(txtSize);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DraffCut df = new DraffCut();
				String draffId = txtCuttingID.getText()+txtStockId.getText();
				if(StringUtils.isBlank(txtPerUnitLength.getText())) {
					df.setCuttingId(txtCuttingID.getText());
					df.setStockId(txtStockId.getText());
					df.setDraffId(draffId);
					df.setPerUnitLength(txtPerUnitInclude.getText());
					df.setRealWithDraw(txtWithDrawUnit.getText());
					df.setTotalUnit(txtTotalUnit.getText());
					df.setTotalUnitLength(txtTotalInclude.getText());
					df.setSize(txtSizeUnit.getText());
					df.setType("unit");
					CuttingManageFrame.totalUnit = txtTotalUnit.getText();
				}
				else {
					df.setCuttingId(txtCuttingID.getText());
					df.setStockId(txtStockId.getText());
					df.setDraffId(draffId);
					df.setPerUnitLength(txtPerUnitLength.getText());
					df.setRealWithDraw(txtCutLength.getText());
					df.setTotalUnit(txtTotalUnit.getText());
					df.setTotalUnitLength(txtTotalLength.getText());
					df.setSize(txtSize.getText());
					df.setType("inches");
					CuttingManageFrame.totalUnit = txtTotalUnit2.getText();
				}
				CuttingManageFrame.draffCutList.add(df);
				draffEditingFrame.setVisible(false);
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
		panel.setBorder(new TitledBorder(null, "Pate", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 132, 334, 252);
		contentPane.add(panel);
		
		JLabel lblUnitInclude = new JLabel("1 Unit Include");
		lblUnitInclude.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUnitInclude.setBounds(385, 147, 121, 24);
		contentPane.add(lblUnitInclude);
		
		JLabel lblTotalUnit_1 = new JLabel("Total Unit");
		lblTotalUnit_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTotalUnit_1.setBounds(385, 192, 121, 24);
		contentPane.add(lblTotalUnit_1);
		
		JLabel lblTotalInclude = new JLabel(" Total Include");
		lblTotalInclude.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTotalInclude.setBounds(380, 239, 121, 24);
		contentPane.add(lblTotalInclude);
		
		JLabel lblWid = new JLabel(" Withdraw");
		lblWid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblWid.setBounds(380, 289, 121, 24);
		contentPane.add(lblWid);
		
		JLabel label = new JLabel("Size");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(385, 336, 121, 24);
		contentPane.add(label);
		
		txtPerUnitInclude.setBounds(525, 147, 135, 24);
		contentPane.add(txtPerUnitInclude);
		
		txtTotalUnit2.setBounds(525, 192, 135, 24);
		contentPane.add(txtTotalUnit2);
	
		txtTotalInclude.setBounds(525, 239, 135, 24);
		contentPane.add(txtTotalInclude);
		
		txtWithDrawUnit.setBounds(525, 289, 135, 24);
		contentPane.add(txtWithDrawUnit);
		
		txtSizeUnit.setBounds(525, 336, 135, 24);
		contentPane.add(txtSizeUnit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Unit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(354, 132, 334, 252);
		contentPane.add(panel_1);
	}
}
