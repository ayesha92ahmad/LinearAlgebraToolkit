package model;

import viewController.ToolkitView;


//jacobi
//
public class LinearAlgebra {
	
	public static double[][] addMatrix(double mat1[][],double mat2[][], int m, int n){
		int i,j;
		double result[][]=new double[m][n];
		for(i=0;i<m;i++){
			for(j=0;j<n;j++){
				result[i][j]=mat1[i][j]+mat2[i][j];
			}
		}
		return result;
	}
	
	public static double[][] subtractMatrix(double mat1[][],double mat2[][], int m, int n){
		int i,j;
		double result[][]=new double[m][n];
		for(i=0;i<m;i++){
			for(j=0;j<n;j++){
				result[i][j]=mat1[i][j]-mat2[i][j];
			}
		}
		return result;
	}
	
	public static double determinant(double mat[][], int norder){
    	int d;
	   	double result = 0;
	   	if (norder == 1) {
            result = mat[0][0];
            return result;
    	}
    	if (norder == 2) {
            result = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
            return result;
    	}
    	for (int i = 0; i < norder; i++) {
    		double temp[][] = new double[norder - 1][norder - 1];

        for (int j = 1; j < norder; j++) {
                for (int k = 0; k < norder; k++) {

                        if (k < i) {
                                temp[j - 1][k] = mat[j][k];
                        } else if (k > i) {
                                temp[j - 1][k - 1] = mat[j][k];
                        }
                }
        	}
        	result += mat[0][i] * Math.pow(-1, (int) i) * determinant(temp,(norder-1));
    	}

    	return result;
    
    }


    public static int sign(int n){
    	int m=n%2;
    	if(m==0){
    		return 1;
    	}
    	else 
    		return -1;
	}
    
	public static double[][] cofactor(double[][] matrix,int norder){
		double mat[][] = new double[norder][norder];
		double temp[][] = new double[norder][norder];
		for (int i=0;i<norder;i++) {
			for (int j=0; j<norder;j++) {
				temp=createSubMatrix(matrix, i, j);
				int n=i+j;
				mat[i][j]= sign(i) *sign(j)* determinant(createSubMatrix(matrix, i, j),temp.length);
			}
		}
		return mat;
	} 
	
	
	public static double[][] createSubMatrix(double[][] matrix, int excluding_row, int excluding_col) {
		double[][] mat = new double[matrix.length-1][matrix[0].length-1];
		int r = -1;
			for (int i=0;i<matrix.length;i++) {
				if (i==excluding_row)
					continue;
				r++;
				int c = -1;
			for (int j=0;j<matrix[0].length;j++) {
				if (j==excluding_col)
					continue;
				mat[r][++c]= matrix[i][j];
			}
			}
		return mat;
	}
	public static double[][] inverse(double[][] matrix, int norder){
		double co[][]=new double[norder][norder];
		double tr[][]=new double[norder][norder];
		double mu[][]=new double[norder][norder];
		double det;
		co=cofactor(matrix,norder);
		det=determinant(matrix,norder);
	   
		for(int i=0;i<norder;i++){
			for(int j=0;j<norder;j++){
				mu[i][j]= co[i][j]/det;
				System.out.println(""+mu[i][j]);
			}
		}
	   
		return (mu);
	   
	} 
	public static double[][] transpose(double[][] matrix,int mrow,int mcol){
		double trans[][]=new double[mrow][mcol];
		for(int i=0;i<mrow;i++){
		   for(int j=0;j<mcol;j++){
			   trans[i][j]=matrix[j][i];
		   }
	   }
	   return trans;
	}
	/*public static double[] eigenval(double a[][],int n){
		Jama.Matrix M=new Jama.Matrix(a);
		int i;
	    EigenvalueDecomposition E = new EigenvalueDecomposition(M);
	    double[] d = new double[n];
	    d=E.getRealEigenvalues();
	    return d;
		}
	public static double[][] eigenvect(double a[][],int n){
		Jama.Matrix M=new Jama.Matrix(a);
		int i;
	    EigenvalueDecomposition E = new EigenvalueDecomposition(M);
	    EigenvalueDecomposition v= M.eig();
	    Matrix v1=E.getV();
	    Matrix v2=E.getD();
	    double[][] evect=v1.getArray();
	    return evect;
		}
	static void vector(int order, double matr[][]){
		double x0[][]= new double[order][1];
		double xi[][]= new double[order][1];
		double x2[][]= new double[order][1];
		int i,flag=1,j;
		
		double min;
		
		for(i=0;i<order;i++){
			xi[i][0]=1;
			x0[i][0]=1;
		}
		for(i=0;i<order;i++){
			System.out.print(xi[i][0]);
		}
		
		for(j=0;;j++){
			flag=0;
			
			xi=multiply(matr,xi,order,order,1);

			min=Math.abs(xi[0][0]);
			for (i=0;i<order;i++){
				System.out.println(" "+xi[i][0]);
				if(Math.abs(min)>Math.abs(xi[i][0])){
					min=xi[i][0];					
				}
			}
			System.out.println("boo1 "+min);
			for(i=0;i<order;i++){
				
				x2[i][0]=xi[i][0]/min;
				System.out.println(" "+x2[i][0]);
			}
			System.out.println("boo");
			for(i=0;i<order;i++){
				if(x2[i][0]-x0[i][0]<=0.02){
					flag++;
				}
			}
			if(flag==order){
				value=min;
				vec=x2;
				break;
			}
			for(i=0;i<order;i++){
				x0[i][0]=x2[i][0];
			}
			
			
		}
		
		System.out.println("eigenvalue:"+value);
		System.out.println("eigenvector:");
		for(i=0;i<order;i++){
			for(j=0;j<1;j++){
				 System.out.print(vec[i][j]+" ");
			}
			System.out.print("\n");
		}
		
	}*/
	public static double[][] multiply (double matrix1[][],double matrix2[][],int row1,int row2,int col2){
		double temp;
		double result[][]=new double[row1][col2];
		
		for ( int c = 0 ; c < row1 ; c++ ){
            for (int  d = 0 ; d < col2 ; d++ ){  
         	   temp= 0;
               for ( int k = 0 ; k < row2 ; k++ ){
                  temp = temp + (matrix1[c][k]* matrix2[k][d]);
               }
               
               result[c][d]=temp;
               
            }
         }
		return result;
	}
	public static int rank(double matrix[][],int n){
		int r=0;
		int i,j;
		int flag=0;
		double a[][]=new double[n][n];
		a=gaussElimin(matrix,n);
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				flag=0;
				if(a[i][j]==0){
					continue;
				}
				flag++;
				
			}
			if(flag!=0) r++;
		}
		return r;
	}
	public static boolean islowerTriangle(double[][] matrix, int norder){
		for(int i=0;i<norder;i++){
			for(int j=0;j<norder;j++){
				if(i<j && matrix[i][j]!=0){
					return false;
				}
			}
		}
		return true;
		
	}
	public static boolean isupperTriangle(double[][] matrix, int norder){
		for(int i=0;i<norder;i++){
			for(int j=0;j<norder;j++){
				if(j<i && matrix[i][j]!=0){
					return false;
				}
			}
		}
		return true;
		
	}
	 public static double[][] gaussElimin(double a[][],int n){
		 int i,j,k;
		 double temp,r;
		 for(i=0;i<n;i++){
			 if(a[i][i]==0){
				 for(j=i+1;j<n;j++){
					 if(a[j][i]!=0){
						 for(k=0;k<n;k++){
							 temp=a[i][k];
							 a[i][k]=a[j][k];
							 a[j][k]=temp;
						 }
						 break;
					 }
				 }
				 if(j==n){
					 System.out.print("singular");
				 }
			 }
			 for(k=i+1;k<n;k++){
				 r=a[k][i]/a[i][i];
				 for(j=0;j<n;j++){
					 a[k][j]-=r*a[i][j];
				 }
			 }
		 }
		 
		 return a;
	 }
	 public static void luDecom(double matrix[][],int n){
    	
    	int i,j,k;
    	double u[][]=new double[n][n];
        double l[][]=new double[n][n];
        double b[][]=new double[n][n];
    	for(i=0;i<n;i++){
    		for(j=0;j<n;j++){
    			u[i][j]=matrix[i][j];
    		}
    	}
    	for(i=0;i<n;i++){
    		for(j=0;j<n;j++){
    			if(i==j) l[i][j]=1;
    			else l[i][j]=0;
    		}
    	}
    	for(k=0;k<n-1;k++){
    		for(j=k+1;j<n;j++){
    			l[j][k]=u[j][k]/u[k][k];
    			for(i=k;i<n;i++){
    				u[j][i]=u[j][i]- l[j][k]*u[k][i];
    			}
    		}
    	}
    	 for(i=0;i<n;i++){
             for(j=0;j<n;j++){
                 System.out.print(l[i][j]+" ");
             }
             System.out.println("");
         }
      for(i=0;i<n;i++){
             for(j=0;j<n;j++){
                 System.out.print(u[i][j]+" ");
             }
             System.out.println("");
         }
      b=multiply(l,u,n,n,n);	
      for(i=0;i<n;i++){
          for(j=0;j<n;j++){
              System.out.print(b[i][j]+" ");
          }
          System.out.println("");
      }
    }
	public static double[] gaussSiedel(double a[][],double b[], double x[],int n,int m){
		double sum = 0;
		int i,j;
        for (int l = 0; l < n; l++)
        x[l] = 0;
        while(m>0)
        {
        	for(i = 0; i <n ; i++)
        	{
        		sum = b[i];
        		for(j = 0; j <n; j++)
        		{
        			if( i != j )
        			{
        				sum = sum - (a[i+1][j+1] * x[j]);
        			}
        		}
        		x[i] = sum/a[i+1][i+1];
        	}
        }
		return x;
		
	}
	public static double norm1(double[][] a,int n){
		int i, j;
		double b[]=new double[n];
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				b[j]+=a[j][i];
			}
		}
		double max=b[0];
		for(i=1;i<n;i++){
			if(b[i]>max){
				max=b[i];
			}
		}
		return max;
		
	}
	public static double[][] gso1(double a[][],int m, int n){
		double u[][]=new double[n][m];
		double v[][]=new double[n][m];
		double w[]=new double[m];
		
		int i,j,k;
		double sum=0;
		v=transpose(a,m,n);
		u[0]=normalise(v[0],m);
					
			for(j=1;j<n;j++){
				//System.out.println("hi2");
				sum=0;
				double x[]=new double[m];
				//System.out.println("hi1");
				for(k=0;k<j;k++){
					sum+=dotProduct(u[k],v[j],m);
					for(i=0;i<m;i++){
						x[k]+=sum*u[k][i];
					}
					
					
				}
				w=subArray(v[j],x,m);
				u[j]=normalise(w,m);
				/*System.out.println("hi");
				for(i=0;i<m;i++){
					System.out.println(u[j][i]+" i="+i+"j="+j);
				}*/
				
			}
		return transpose(u,n,m); 
	}
	public static double[] subArray(double a[],double b[], int m){
		double c[]=new double[m];
		int i;
		for(i=0;i<m;i++){
			c[i]=a[i]-b[i];
		}
		return c;
	}
	public static double dotProduct(double a[],double b[],int m){
		double d=0,sum=0;
		int i=0;
		for(i=0;i<m;i++){
			sum+=a[i]*b[i];
		}
		d=Math.sqrt(sum);
		return d;
		
	}
	
	public static double[] normalise(double a[],int n){
		
		double[] nor= new double[n];
		double sum=0,po;
		int j;
		for(j=0;j<n;j++){
			po=Math.pow(a[j],2);
			sum+=po;
		}
		sum=Math.sqrt(sum);
		for(j=0;j<n;j++){
			nor[j]=a[j]/sum;
		}
		
		return nor;
	}
	
	public static double[][] cholesky(double[][] a){
		int m = a.length;
		double[][] l = new double[m][m]; //automatically initialzed to 0's
		for(int i = 0; i< m;i++){
			for(int k = 0; k < (i+1); k++){
				double sum = 0;
				for(int j = 0; j < k; j++){
					sum += l[i][j] * l[k][j];
				}
				l[i][k] = (i == k) ? Math.sqrt(a[i][i] - sum) :
					(1.0 / l[k][k] * (a[i][k] - sum));
			}
		}
		return l;
	}


}
