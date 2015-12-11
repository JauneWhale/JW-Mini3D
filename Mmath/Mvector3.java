package Mmath;



public class Mvector3 {
	int x, y, z;
	public Mvector3(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Mvector3(){
		x = y = z = 0;
	}
	public Mvector3 Mclone(){
		return new Mvector3(x,y,z);
	}
	public double Mlength(){
		return Math.sqrt(x*x+y*y+z*z);
	}
	public double Msqlength(){
		return (x*x+y*y+z*z);
	}
	public void Mnormalize(){
		x = (int) (x / Mlength());
		y = (int) (x / Mlength());
		z = (int) (x / Mlength());
	}
	public void Mnegative(){
		x = -x; y = -y; z = -z;
	}
	public void Madd(Mvector3 v){
		x += v.x; y += v.y; z += v.z;
	}
	public void Msubtract(Mvector3 v){
		x -= v.x; y -= v.y; z -= v.z;
	}
	public void Mmultiply(double f){
		x*=f; y*=f; z*=f;
	}
	public void Mmultiply(int f){
		x*=f; y*=f; z*=f;
	}
	public void Mdivide(double inv){
		double f = 1/inv;
		x*=f; y*=f; z*=f;
	}
	public double Mdot(Mvector3 v){
		return (this.x*v.x+this.y*v.y+this.z*v.z);
	}
	public Mvector3 Mcross(Mvector3 v){
		return new Mvector3(
					-this.z * v.y + this.y * v.z,
					 this.z * v.x - this.x * v.z, 
					-this.y * v.x + this.x * v.y);
	}
}
