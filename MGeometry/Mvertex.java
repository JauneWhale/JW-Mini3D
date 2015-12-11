package MGeometry;

import Mmath.*;

public class Mvertex {
	public float r, g, b;
	public float rhw;
	public Mvector3 vertex;
	public Mvertex(Mvector3 v){
		rhw = 1.0f / v.w;
		r = g = b = rhw;
	}
	public void Madd(Mvertex x){
		float w = vertex.w+x.vertex.w;
		vertex.Madd(x.vertex);//########################
		vertex.w = w;
		rhw += x.rhw;
		r += x.r;
		g += x.g;
		b += x.b;
	}
}

