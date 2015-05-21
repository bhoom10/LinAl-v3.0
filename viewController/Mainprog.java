/*Setting up the toolkit view*/

package viewController;

import java.awt.EventQueue;
import java.awt.Toolkit;

public class Mainprog {
	public static void main(String args[]){
		
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	
	            	ToolkitView m=new ToolkitView();
	               	m.showIt();
	            }
		 });
	}

}
