package Mmath;

public final class Mbasic {
	public static int Isinclude(int x, int min, int max){
		return  (x < min)? min : ((x > max)? max : x);
	}
	public static double Isinclude(double x, double min, double max){
		return  (x < min)? min : ((x > max)? max : x);
	}
}
