package model;
import model.LinearAlgebra;

public class Eigen {
	private double Q[][]=new double[10][10];
	private double R[][]=new double[10][10];
	
	
	static void QR(double mat[][], int m,int n){
		double q[][][]=new double [m][m][n];
		double z[][]=new double[m][n];
		double z1[][]=new double[m][n];
		
		double a;
		int i,j;
		z=copy(mat,m,n);
		for(int k=0;k<n && k<m-1;k++){
			double e[]=new double[m];
			double x[]=new double[m];
			z1=minor(z,m,n,k);
			z=copy(z1,m,n);
			x=mcol(z,m,n,k);
			a=vnorm(x,m);
			if(mat[k][k]>0){a=-a;}
			for(i=0;i<m;i++){
				e[i]=(i==k)?1:0;
			}
			e=vmadd(x,e,a,m);
			e=vdiv(e,vnorm(e,m),m);
			q[k]=vmul(e,n);
			z1=multiply(q[k],z,m,m,n);
			z=copy(z1,m,n);
		}
		Q=copy(q[0],m,n);
		R=multiply(q[0],mat,m,m,n);
		for(i=1;i<n && i<m-1;i++){
			z1=multiply(q[1],Q,m,m,n);
			Q=z1;
		}
		z=multiply(Q,mat,m,m,n);
		R=copy(z,m,n);
		Q=transpose(Q,m,n);
		
		System.out.println("Q:");
		for(i=0;i<m;i++){
			for(j=0;j<n;j++){
				System.out.printf("%.4f ",Q[i][j]);
			}
			System.out.println();
		}
		System.out.println("R:");
		for(i=0;i<n;i++){
			for(j=0;j<m;j++){
				System.out.printf("%.2f ",R[i][j]);
			}
			System.out.println();
		}
		
	}
	static void eVect(double mat[][],int m){
		int i,j;
		double x[][]=new double[m][m];
		double pq[][]=new double[m][m];
		
		x=copy(mat,m,m);
		for(i=0;i<m;i++){
			pq[i][i]=1;
		}
		for(i=0;i<20;i++){
			QR(x,m,m);
			pq=multiply(pq,Q,m,m,m);
			x=multiply(R,Q,m,m,m);
		}
		System.out.println("pq");
		for(i=0;i<m;i++){
			for(j=0;j<m;j++){
				System.out.printf("%.4f ",pq[i][j]);
			}
			System.out.println();
		}
		System.out.println("x");
		for(i=0;i<m;i++){
			for(j=0;j<m;j++){
				System.out.printf("%.2f ",x[i][j]);
			}
			System.out.println();
		}
		
	}
	
	static double[] mcol (double a[][],int m, int n,int c){
		double v[]=new double[m];
		int i;
		for(i=0;i<m;i++){
			v[i]=a[i][c];
		}
		return v;
	}
	
	static double vnorm(double x[],int n){
		double sum=0;
		for(int i=0;i<n;i++){
			sum+=x[i]*x[i];
		
		}
		return Math.sqrt(sum);
	}
	
	static double[] vmadd(double a[],double b[],double s,int n){
		double c[]=new double[n];
		for(int i=0;i<n;i++){
			c[i]=a[i]+s*b[i];
		}
		return c;
	
	}
	
	static double[][] minor(double a[][],int m, int n, int d){
		double b[][]=new double[m][n];
		for(int i=0;i<d;i++)
			b[i][i]=1;
		for(int i=d;i<m;i++){
			for(int j=d;j<n;j++){
				b[i][j]=a[i][j];
			}
		}
		return b;
	}
	
	static double[] vdiv(double x[],double d,int n){
		double y[]=new double[n];
		for(int i=0;i<n;i++) y[i]=x[i]/d;
		return y;
		
	}
	static double[][] vmul(double e[], int m){
		double mat[][]=new double[m][m];
		int i,j;
		for( i=0;i<m;i++){
			for(j=0;j<m;j++){
				mat[i][j]=-2* e[i]*e[j];
			}
		}
		for(i=0;i<m;i++){
			mat[i][i]+=1;
		}
		return mat;
    }	
	static double[][] copy(double a[][],int m,int n){
		return a;
	}

}
