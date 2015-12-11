package Mmath;

public class Mmatrix {
	//int columns;//������
	//int rows;//������
	int n;
	int size;
	double[] values;
	public static final int DIMENSION2 = 3;
	public static final int DIMENSION3 = 4;
	public Mmatrix(double[] values,int dimension){
		this.n = dimension;
		size = n*n;
		this.values = new double[size];
		for(int i=0; i<size; i++)
			this.values[i] = values[i];
	}
	//���������
	public Mmatrix(double[] values){
		this.n = DIMENSION3;
		size = n*n;
		this.values = new double[size];
		for(int i=0; i<size; i++)
			this.values[i] = values[i];
	}
	public Mmatrix(){
		this.n = DIMENSION3;
		size = n*n;
		this.values = new double[size];
		this.Msetidentity();
	}
	public void Madd(Mmatrix m){
		for(int i=0; i<size; i++){
			this.values[i] += m.values[i];
		}
	}
	public void Msubtract(Mmatrix m){
		for(int i=0; i<size; i++){
			this.values[i] -= m.values[i];
		}
	}
	public Mmatrix Mmutliply(Mmatrix m){
		double[] results = new double[size];
		int i=0;
		for(int x=0; x<n; x++){
			for(int y=0; y<n; y++,i++){
				results[i] = 0;
				for(int k=0; k<n; k++)
					results[i] += getValues(x,k)*m.getValues(k, y);
			}
		}
		return (new Mmatrix(results,n));
	}
	public Mvector3 Mtranform(Mvector3 v){
		double x,y,z,w;
		x = v.x*this.getValues(0, 0) + v.y*this.getValues(1, 0) + v.z*this.getValues(2, 0) + v.w*this.getValues(3, 0);
		y = v.x*this.getValues(0, 1) + v.y*this.getValues(1, 1) + v.z*this.getValues(2, 1) + v.w*this.getValues(3, 1);
		z = v.x*this.getValues(0, 2) + v.y*this.getValues(1, 2) + v.z*this.getValues(2, 2) + v.w*this.getValues(3, 2);
		w = v.x*this.getValues(0, 3) + v.y*this.getValues(1, 3) + v.z*this.getValues(2, 3) + v.w*this.getValues(3, 3);
		Mvector3 res = new Mvector3(x,y,z,w);
		res.Mreset();
		return res;
	}
	public void Mscale(int f){
		for(int i=0; i<size; i++){
			this.values[i] *= f;
		}
	}
	public void Mscale(double f){
		for(int i=0; i<size; i++){
			this.values[i] *= f;
		}
	}
	public double getValues(int col, int row){
		return values[row*n + col];
	}
	public void Msetidentity(){
		int i = 0;
		for(int x = 0; x<n; x++){
			for(int y = 0; y<n; y++,i++){
				values[i] = (x==y)?1.0:0.0;
			}
		}
	}
	public void Msetzero(){
		for(int i = 0; i<size; i++){
			values[i] = 0.0;
		}
	}
}