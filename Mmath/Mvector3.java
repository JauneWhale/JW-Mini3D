package Mmath;


//一律以列向量来看待
public class Mvector3 {
	float x, y, z;
	float w;
	public Mvector3(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = 1;
	}
	public Mvector3(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = 1;
	}
	public Mvector3(float x, float y, float z, float w){
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	public Mvector3(){
		x = y = z = 0;
		w = 1;
	}
	public Mvector3 Mclone(){
		return new Mvector3(x,y,z,w);
	}
	public float Mlength(){
		return (float) (Math.sqrt(x*x+y*y+z*z)/w);
	}
	public float Msqlength(){
		return (x*x+y*y+z*z)/(w*w);
	}
	public void Mnormalize(){
		x = (int) (x / Mlength());
		y = (int) (x / Mlength());
		z = (int) (x / Mlength());
		w = 1;
	}
	public void Mnegative(){
		x = -x; y = -y; z = -z;
	}
	public void Madd(Mvector3 v){
		x += v.x /v.w*w;
		y += v.y /v.w*w;
		z += v.z /v.w*w;
	}
	public void Msubtract(Mvector3 v){
		x -= v.x /v.w*w;
		y -= v.y /v.w*w;
		z -= v.z /v.w*w;
	}
	public void Mscale(float f){
		x*=f; y*=f; z*=f;
	}
	public void Mscale(int f){
		x*=f; y*=f; z*=f;
	}
	public void Mdivide(float inv){
		float f = 1/inv;
		x*=f; y*=f; z*=f;
	}
	//矢量点乘
	public float Mdot(Mvector3 v){
		return (this.x*v.x+this.y*v.y+this.z*v.z)/(this.w*w);
	}
	//矢量叉乘
	public Mvector3 Mcross(Mvector3 v){
		return new Mvector3(
					-this.z * v.y + this.y * v.z,
					 this.z * v.x - this.x * v.z, 
					-this.y * v.x + this.x * v.y
					);
	}
	public void Mreset(){
		x /= w;
		y /= w;
		z /= w;
		w = 1;
	}
	//双向量版
	public Mvector3 Sadd(Mvector3 v){
		float tx = x + v.x /v.w*w;
		float ty = x + v.y /v.w*w;
		float tz = x + v.z /v.w*w;
		float tw = w;
		return new Mvector3(tx,ty,tz,tw);
	}
	public Mvector3 Ssubtract(Mvector3 v){
		float tx = x - v.x /v.w*w;
		float ty = x - v.y /v.w*w;
		float tz = x - v.z /v.w*w;
		float tw = w;
		return new Mvector3(tx,ty,tz,tw);
	}
}
