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
		ModelView = new Mmatrix();
		Mperspective(PI*0.5f, ratio, 1.0f, 100.0f);
		Mupdatetransform();
		/*this.pos = new Mvector3(0,0,-5);
		this.dir = new Mvector3(0,0,1);
		this.up = new Mvector3(1,0,0);*/
	}
	public void Mlookat(Mvector3 pos, Mvector3 dir, Mvector3 up){
		/*this.pos = pos.Mclone(); this.pos.Mnormalize();
		this.dir = dir.Mclone();
		this.dir.Msubtract(pos); this.dir.Mnormalize();
		this.up  = up.Mclone(); this.up.Mnormalize();*/
	}
	public void Mperspective(float fovy, float ratio, float zn, float zf){
		
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
}
