package MGeometry;

import Mmath.Mbasic;
import Mmath.Mvector3;

public class Mvertex_op {
	public static Mvertex Vetex_Interp(Mvertex x1,Mvertex x2,float t){
		Mvector3 v = Mbasic.Vector_Interp(x1.vertex, x2.vertex, t);
		Mvertex res = new Mvertex(v);
		res.r = Mbasic.Interp(x1.r, x2.r, t);
		res.g = Mbasic.Interp(x1.g, x2.g, t);
		res.b = Mbasic.Interp(x1.b, x2.b, t);
		res.rhw = Mbasic.Interp(x1.rhw, x2.rhw, t);
		return res;
	}
	public static Mvertex Vetex_Division(Mvertex x1,Mvertex x2,float w){
		float inv = 1.0f/w;
		Mvector3 v = new Mvector3(
				(x2.vertex.x-x1.vertex.x)*inv,
				(x2.vertex.y-x1.vertex.y)*inv,
				(x2.vertex.z-x1.vertex.z)*inv,
				(x2.vertex.w-x1.vertex.w)*inv
				);
		Mvertex res = new Mvertex(v);
		res.r = (x2.r-x1.r)*inv;
		res.g = (x2.g-x1.g)*inv;
		res.b = (x2.b-x1.b)*inv;
		res.rhw = (x2.rhw-x1.rhw)*inv;
		return res;
	}
}
