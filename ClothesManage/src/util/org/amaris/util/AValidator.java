package org.amaris.util;

import java.lang.reflect.Field;

import org.amaris.annotation.Validate;
import org.apache.commons.lang.StringUtils;

public class AValidator {
	
	public static int ID_MAX_LENGTH = 6;
	
	public static Boolean validate(Object validateObj) {
		Field[] fields = validateObj.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			if(field.isAnnotationPresent(Validate.class)) {
				
			}
		}
		
		return false;
	}
	
	public static Boolean requireValidate(String str){
		if(StringUtils.isBlank(str)) {
			return false;
		}
		return true;
	}
	
	

}
