package Mmath;

public final class Mbasic {
	public static int Isinclude(int x, int min, int max){
		return  (x < min)? min : ((x > max)? max : x);
	}
	public static float Isinclude(float x, float min, float max){
		return  (x < min)? min : ((x > max)? max : x);
	}
	public static float Interp(float x1, float x2, float t){
		return x1 + (x2 - x1)*t;
	}
	public static Mvector3 Vector_Interp(Mvector3 v1,Mvector3 v2,float t){
		Mvector3 x1 = v1.Mclone();
		Mvector3 x2 = v2.Mclone();
		x1.Mreset(); x2.Mreset();
		Mvector3 res = new Mvector3(
				Interp(x1.x,x2.x,t),
				Interp(x1.y,x2.y,t),
				Interp(x1.z,x2.z,t),
				1.0f);
		return res;
	}
}
