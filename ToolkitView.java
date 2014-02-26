//MatCommAdv
package viewController;

import viewController.*; 
import java.awt.*; 
import java.io.*;
import java.util.*;
import javax.swing.*;

public class ToolkitView extends JFrame {
	
	private JMenuBar MBar;
	private JMenu filemenu;
	private JMenu toolmenu;
	private JMenu insertmenu;
	private JMenu runmenu;
	private JMenu helpmenu;
	private JScrollPane Scroll;
	private JTextArea text;
	MenuListener menuList;
	
public void showIt(){
	System.out.println("hm");
	this.setTitle("linear algebra toolkit");
	this.setVisible(true);
}
public void hideIt(){
	this.setVisible(false);
}
public ToolkitView(){
	System.out.println("hi");
	//f=new JFrame("menu bar");	
	MBar = new JMenuBar();
	filemenu = new JMenu("File");
	filemenu.add(new JSeparator());
	toolmenu = new JMenu("Tool");
	toolmenu.add(new JSeparator());
	insertmenu = new JMenu("Insert");
	insertmenu.add(new JSeparator());
	helpmenu = new JMenu("Help");
	helpmenu.add(new JSeparator());
	
	text=new JTextArea();
	Scroll=new JScrollPane();
	
	text.setText("Welcome to this gui");
	
	
	
	JMenuItem fileItem1 = new JMenuItem("New");
	JMenuItem fileItem2 = new JMenuItem("Open");
	JMenuItem fileItem3 = new JMenuItem("Close");
	
	JMenu toolItem1= new JMenu("Matrix operations");
	JMenu toolItem2 = new JMenu("Vector operations");
	JMenu toolItem3 = new JMenu("Check for");
	JMenu toolItem4 = new JMenu("Decomposition");
	JMenu toolItem5 = new JMenu("Solve equations ");
	
	
	JMenuItem matAdd = new JMenuItem("Addition");
	JMenuItem matsub = new JMenuItem("Subtraction");
	JMenuItem matmul = new JMenuItem("Multiplication");
	JMenuItem matin = new JMenuItem("Inverse");
	JMenuItem matde = new JMenuItem("Determinant");
	JMenuItem mattr = new JMenuItem("Transpose");
	JMenuItem matrank = new JMenuItem("Rank");
	JMenuItem matnorm = new JMenuItem("Norm");
	JMenuItem matTrace = new JMenuItem("Trace");
	
	JMenuItem mateval = new JMenuItem("Eigen");
	JMenuItem eig = new JMenuItem("Power eigen");
	JMenuItem gso = new JMenuItem("Gram schmdit orthonormalization");
	JMenuItem snf = new JMenuItem("Smith normal form");
	JMenuItem svd = new JMenuItem("Single value decomposition");
	JMenuItem digon = new JMenuItem("Digonalize");
	JMenuItem jaco = new JMenuItem("Jacobi");
		
	JMenuItem mat = new JMenuItem("Matrix");
	
	JMenuItem check1= new JMenuItem("Lower triangular matrix");
	JMenuItem check2= new JMenuItem("Upper triangular matrix");
	JMenuItem check3= new JMenuItem("Hermittian matrix");
	JMenuItem check4= new JMenuItem("Singular matrix");
	JMenuItem check5= new JMenuItem("Diagonalizable matrix");
	JMenuItem check6= new JMenuItem("Invertible matrix");
	JMenuItem check7= new JMenuItem("Symmetric matrix");
	JMenuItem check8= new JMenuItem("Hessenberg matrix");
	

	JMenuItem LuDecomp = new JMenuItem("LU decomposition");
	JMenuItem Gauss = new JMenuItem ("Gaussian Elimination");
	JMenuItem chole = new JMenuItem ("Cholesky Factorization");
	JMenuItem QrDecomp = new JMenuItem("QR decomposition");
		
	
	menuList = new MenuListener(this,Scroll);
	
	filemenu.add(fileItem1);
	filemenu.add(fileItem2);
	filemenu.add(fileItem3);
	toolmenu.add(toolItem1);
	toolmenu.add(toolItem2);
	toolmenu.add(toolItem3);
	toolmenu.add(toolItem4);
	
	insertmenu.add(mat);
		
	toolItem1.add(matAdd);
	toolItem1.add(matsub);
	toolItem1.add(matmul);
	toolItem1.add(matde);
	toolItem1.add(matin);
	toolItem1.add(mattr);
	toolItem1.add(matrank);
	toolItem1.add(matnorm);
	toolItem1.add(matTrace);
	
	fileItem3.addActionListener(menuList);
	matAdd.addActionListener(menuList);
	matsub.addActionListener(menuList);
	matmul.addActionListener(menuList);
	matde.addActionListener(menuList);
	matin.addActionListener(menuList);
	mattr.addActionListener(menuList);
	matrank.addActionListener(menuList);
	matnorm.addActionListener(menuList);
	matTrace.addActionListener(menuList);
	mat.addActionListener(menuList);
	
	toolItem2.add(mateval);
	toolItem2.add(eig);
	toolItem2.add(gso);
	toolItem2.add(snf);
	toolItem2.add(svd);toolItem1.add(matnorm);
	toolItem2.add(digon);
	toolItem2.add(jaco);
	
	mateval.addActionListener(menuList);
	eig.addActionListener(menuList);
	gso.addActionListener(menuList);
	snf.addActionListener(menuList);
	svd.addActionListener(menuList);
	digon.addActionListener(menuList);
	
	toolItem3.add(check1);
	toolItem3.add(check2);
	toolItem3.add(check3);
	toolItem3.add(check4);
	toolItem3.add(check5);
	toolItem3.add(check6);
	toolItem3.add(check7);
	toolItem3.add(check8);
	
	
	check1.addActionListener(menuList);
	check2.addActionListener(menuList);
	check3.addActionListener(menuList);
	check4.addActionListener(menuList);
	check5.addActionListener(menuList);
	check6.addActionListener(menuList);
	check7.addActionListener(menuList);
	check8.addActionListener(menuList);
	
	toolItem4.add(LuDecomp);
	toolItem4.add(Gauss);
	toolItem4.add(chole);
	toolItem4.add(QrDecomp);
		
	LuDecomp.addActionListener(menuList);
	Gauss.addActionListener(menuList);
	chole.addActionListener(menuList);
	QrDecomp.addActionListener(menuList);
	
	System.out.println("yolo");
	MBar.add(filemenu);
	MBar.add(toolmenu);
	MBar.add(insertmenu);
	MBar.add(helpmenu);
	
	
	this.setJMenuBar(MBar);
	this.getContentPane().add(Scroll,BorderLayout.CENTER);
	
	
	System.out.println("hey");
	this.pack();
	this.setSize(700,700);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}

}
 
	
