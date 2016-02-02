package org.amaris.presentation.inventoryManageForm;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import org.amaris.service.balanceManage.IBalanceServiceManager;
import org.amaris.service.inventoryManage.IInventoryServiceManager;
import org.amaris.service.inventoryManage.Style;
import org.amaris.util.BasicBeanFactory;
import org.amaris.util.Conversation;
import org.apache.commons.lang.StringUtils;

import java.awt.Font;
import java.text.ParseException;
import java.util.Date;

public class ImagePreview extends JFrame {

	private JPanel contentPane;
	private IBalanceServiceManager iBalanceServiceManger;
	public static ImagePreview imagePreview;
	public static String image_name;
	public static String image_path;
	public static String image_date;
	private IInventoryServiceManager inventoryServiceManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImagePreview frame = new ImagePreview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static ImagePreview getInstance() {
			imagePreview = new ImagePreview();
			imagePreview.setVisible(true);
			imagePreview.setResizable(false);
			return imagePreview;
	}

	/**
	 * Create the frame.
	 */
	public ImagePreview() {
		setTitle("Preview Image");
		setBounds(100, 100, 445, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		iBalanceServiceManger = (IBalanceServiceManager) BasicBeanFactory.getBean("BalanceServiceManager");
		initializedData();
		JPanel panel = new JPanel();
		panel.setBounds(139, 11, 256, 252);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(image_path));
		lblNewLabel.setBounds(10, 11, 236, 230);
		panel.add(lblNewLabel);
		
		JLabel lblStyleName = new JLabel(image_name);
		lblStyleName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStyleName.setBounds(10, 47, 102, 14);
		contentPane.add(lblStyleName);
		
		JLabel lblDate = new JLabel(image_date);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setBounds(10, 91, 102, 14);
		contentPane.add(lblDate);
		
	}
	
	public void initializedData() {
		String styleCode = (String) Conversation.getConversationValue("Style_Detail");
		inventoryServiceManager = (IInventoryServiceManager) BasicBeanFactory.getBean("InventoryServiceManager");
		Style style = new Style();
		try {
			style = inventoryServiceManager.findStyleDetail(styleCode);
			image_name=style.getStyleName();
			image_path= StringUtils.substringBefore(style.getImagePath(), ".");
			image_path=image_path+"2."+StringUtils.substringAfter(style.getImagePath(), ".");
			System.out.println("path : " + image_path);
			image_date = style.getStyleProduceDate();
			
		}
		catch(Exception ex) {
			
		}
	}
}
