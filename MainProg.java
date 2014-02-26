package viewController;

public class Mainprog {
	public static void main(String args[]){
		System.out.println("hm");
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	ToolkitView m=new ToolkitView();
	            	m.showIt();
	            }
		 });
	}

}
