package org.amaris.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicBeanFactory {
	
	private static HashMap<String, Object> beanContainer = new HashMap<String,Object>();
	private List<String> beanList = new ArrayList<String>();
	
	public static Object getBean(String beanName) {
		 Object object = new Object();
		 object = beanContainer.get(beanName);
		return object;
	}
	
	public void BeanController() {
		beanList.add("InventoryServiceManager");
		beanList.add("BalanceServiceManager");
		beanList.add("CuttingSeriveManager");
		beanList.add("SupplierServiceManager");
		beanList.add("OtherCrudServiceManager");
		beanList.add("LineServiceManager");
//		beanList.add("DividendSupportManager");
//		beanList.add("HeadBranchManager");
//		beanList.add("ExpSeviceDepManager");
//		beanList.add("DividendMstManager");
//		beanList.add("CustomerManager");
//		beanList.add("UnCustomerDividendManager");
		
		Object object = new Object();
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beans.xml");
		BeanFactory beanfactory = (BeanFactory) context;
	    for(String beanName : beanList) {
			 object = beanfactory.getBean(beanName);
			 beanContainer.put(beanName, object);
		}
	}
	
	public BasicBeanFactory( ){
		BeanController();
	}


}
