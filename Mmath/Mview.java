package Mmath;

//核心是设置投影矩阵
public final class Mview {
	private final float PI = 3.1415926f;
	//private static Mvector3 pos,dir,up;
	private static float w, h;
	//坐标变换矩阵: 摄像机坐标变换、世界坐标变换、投影变换、最终变换矩阵
	//transform = world * view * projection
	private static Mmatrix ModelView, ModelWorld, ModelProjection,ModelTransform;
	public void Mview_init(int width, int height){
		w = width; h = (height==0)?1:height;
		float ratio = w/h;
		ModelWorld = new Mmatrix();
		ModelWorld.Msetidentity();
		ModelView = new Mmatrix();
		ModelView.Msetidentity();
		Mperspective(PI*0.5f, ratio, 1.0f, 100.0f);
		Mupdatetransform();
	}
	/**
	 * 改变的是视图变换中的view视角矩阵
	 * pay more attention to this function
	 * @param pos
	 * @param dir
	 * @param up
	 */
	public void Mlookat(Mvector3 pos, Mvector3 dir, Mvector3 up){
		Mvector3 xaxis, yaxis, zaxis;
		zaxis = dir.Ssubtract(pos);
		zaxis.Mnormalize();
		xaxis = up.Mcross(zaxis);
		yaxis = zaxis.Mcross(xaxis);
		ModelView.setValues(0, 0, xaxis.x);
		ModelView.setValues(1, 0, xaxis.y);
		ModelView.setValues(2, 0, xaxis.z);
		ModelView.setValues(3, 0, -xaxis.Mdot(pos));

		ModelView.setValues(0, 1, yaxis.x);
		ModelView.setValues(1, 1, yaxis.y);
		ModelView.setValues(2, 1, yaxis.z);
		ModelView.setValues(3, 1, -yaxis.Mdot(pos));

		ModelView.setValues(0, 2, zaxis.x);
		ModelView.setValues(1, 2, zaxis.y);
		ModelView.setValues(2, 2, zaxis.z);
		ModelView.setValues(3, 2, -zaxis.Mdot(pos));
		

		ModelView.setValues(0, 3, 0);
		ModelView.setValues(1, 3, 0);
		ModelView.setValues(2, 3, 0);
		ModelView.setValues(3, 3, 1);
	}
	/**
	 * 改变的是视图变换中的projection投影矩阵
	 * pay more attention to this function
	 * @param fovy
	 * @param ratio
	 * @param zn
	 * @param zf
	 */
	public void Mperspective(float fovy, float ratio, float zn, float zf){
		float fax = 1.0f / (float)Math.tan(fovy*0.5f);
		ModelProjection.Msetzero();
		ModelProjection.setValues(0, 0, fax/ratio);
		ModelProjection.setValues(1, 1, fax);
		ModelProjection.setValues(2, 2, zf / (zf-zn));
		ModelProjection.setValues(3, 2, -zn * zf / (zf-zn));
		ModelProjection.setValues(3, 3, 1);
	}
	public void Mupdatetransform(){
		ModelTransform = ModelWorld.Mclone();
		ModelTransform.Mmutliply(ModelView);
		ModelTransform.Mmutliply(ModelProjection);
	}
	public void Mlookatzero(float x, float y, float z){
		Mvector3 eye = new Mvector3(x, y, z, 1);
		Mvector3 at = new Mvector3(0, 0, 0, 1);
		Mvector3 up = new Mvector3(0, 0, 1, 1);
		Mlookat(eye, at, up);
		Mupdatetransform();
	}
	/**
	 * Pay attention!!!
	 * @param v
	 * @return
	 */
	public int Mtransform_check_cvv(Mvector3 v){
		return 0;
	}
	/**
	 * Pay attention!!
	 * 归一化得到屏幕坐标
	 * @param v
	 */
	public void Mtransform_homogenize(Mvector3 y, Mvector3 x){
		
	}
}
