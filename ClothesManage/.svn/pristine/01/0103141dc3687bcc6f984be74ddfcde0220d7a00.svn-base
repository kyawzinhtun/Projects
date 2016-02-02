package org.amaris.presentation.mainForm;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.amaris.presentation.inventoryManageForm.InventoryManageFrame;
import org.amaris.presentation.inventoryManageForm.InventorySearchFrame;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.service.inventoryManage.InventoryItem;
import org.amaris.util.BasicBeanFactory;
import org.apache.commons.lang.StringUtils;
import org.jdesktop.swingx.JXDatePicker;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TemplateFrame extends JFrame {

	public static TemplateFrame testFrame;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemplateFrame frame = new TemplateFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static TemplateFrame getInstance() {
		if (testFrame == null) {
			testFrame = new TemplateFrame();
			testFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			testFrame.setVisible(true);
			testFrame.setResizable(false);
			return testFrame;
		}
		testFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		testFrame.setVisible(true);
		testFrame.setResizable(false);		
		return testFrame;
	}

	/**
	 * Create the frame.
	 */
	public TemplateFrame() {
		
		setTitle("Clothes Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Stock Balance Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 11, 1336, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("Stock Adding");
		lblLogo.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblLogo.setBounds(20, 60, 285, 24);
		panel.add(lblLogo);
		
		List<String> valueFromDB = new ArrayList();
		int aa = valueFromDB.size();
		
		Object [] bb = new Array [aa];
		Object [] cc = new Array [aa];
		

		
		
	

	}
}
