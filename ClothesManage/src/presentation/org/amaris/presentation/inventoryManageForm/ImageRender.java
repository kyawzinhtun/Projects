package org.amaris.presentation.inventoryManageForm;

import javax.swing.Icon;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageRender extends DefaultTableCellRenderer {
	  
	 public ImageRender() { 
		 super(); 
	 }

	  public void setValue(Object value) {
	    if (value == null) {
	      setText("");
	    }
	    else
	    {
	      setIcon((Icon) value);
	    }
	  }

}
