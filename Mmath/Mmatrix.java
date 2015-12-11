package Mmath;

public class Mmatrix {
	//int columns;//列向量
	//int rows;//行向量
	/**
	 * 该矩阵表示的下标为：
	 *  00 10 20 30
	 *  01 11 21 31
	 *  02 12 22 32
	 *  03 13 23 33
	 */
	int n;
	int size;
	private float[] values;
	public static final int DIMENSION2 = 3;
	public static final int DIMENSION3 = 4;
	public static final int TRANSLATE = 1;
	public static final int SCALE = 2;
	public static final int ROTATE = 3;
	public Mmatrix(float[] values,int dimension){
		this.n = dimension;
		size = n*n;
		this.values = new float[size];
		for(int i=0; i<size; i++)
			this.values[i] = values[i];
	}
	//建议用这个
	public Mmatrix(float[] values){
		this.n = DIMENSION3;
		size = n*n;
		this.values = new float[size];
		for(int i=0; i<size; i++)
			this.values[i] = values[i];
	}
	public Mmatrix(){
		this.n = DIMENSION3;
		size = n*n;
		this.values = new float[size];
		this.Msetidentity();
	}
	/*
	public Mmatrix(float x, float y, float z, int transform){
		this.n = DIMENSION3;
		size = n*n;
		this.values = new float[size];
		this.Msetidentity();
		switch(transform){
		case TRANSLATE:Mtranslate(); break;
		case SCALE: break;
		case ROTATE: break;
		}
	}*/
	/**
	 * 基本运算
	 * @return
	 */
	public Mmatrix Mclone(){
		return new Mmatrix(values, n);
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
		float[] results = new float[size];
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
		float x,y,z,w;
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
	public void Mscale(float f){
		for(int i=0; i<size; i++){
			this.values[i] *= f;
		}
	}
	/**
	 * 辅助类函数
	 */
	public float getValues(int col, int row){
		return values[row*n + col];
	}
	public void setValues(int col, int row, float value){
		values[row*n + col] = value;
	}
	public void Msetidentity(){
		int i = 0;
		for(int x = 0; x<n; x++){
			for(int y = 0; y<n; y++,i++){
				values[i] = (x==y)?1.0f:0.0f;
			}
		}
	}
	public void Msetzero(){
		for(int i = 0; i<size; i++){
			values[i] = 0;
		}
	}
	/**
	 * 基本变换函数
	 */
	public void Mtranslate(float x, float y, float z){
		this.Msetidentity();
		this.setValues(3, 0, x);
		this.setValues(3, 1, y);
		this.setValues(3, 2, z);
	}
	public void Mscale(float x, float y, float z){
		this.Msetidentity();
		this.setValues(0, 0, x);
		this.setValues(1, 1, y);
		this.setValues(2, 2, z);
	}
	/**
	 * Pay more attention to this
	 * @param x
	 * @param y
	 * @param z
	 * @param theta
	 */
	public void Mrotate(float x, float y, float z, float theta){
		float qsin = (float)Math.sin(theta*0.5f);
		float qcos = (float)Math.sin(theta*0.5f);
		Mvector3 v = new Mvector3(x,y,z,1.0f);
		x = v.x * qsin;
		y = v.y * qsin;
		z = v.z * qsin;
		float w = qcos;
		this.setValues(0, 0, 1 - 2*y*y - 2*z*z);
		this.setValues(1, 0, 2*x*y - 2*w*z);
		this.setValues(2, 0, 2*y*z + 2*w*y);
		this.setValues(0, 1, 2*x*y + 2*w*z);
		this.setValues(1, 1, 1 - 2*x*x - 2*z*z);
		this.setValues(2, 1, 2*y*z - 2*w*x);
		this.setValues(0, 2, 2*x*z - 2*w*y);
		this.setValues(1, 2, 2*y*z + 2*w*x);
		this.setValues(2, 2, 1 - 2*x*x - 2*y*y);
		this.setValues(0, 3, 0);
		this.setValues(1, 3, 0);
		this.setValues(2, 3, 0);
		this.setValues(3, 0, 0);
		this.setValues(3, 1, 0);
		this.setValues(3, 2, 0);
		this.setValues(3, 3, 1);
	}
}
