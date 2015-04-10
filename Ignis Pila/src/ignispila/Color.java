package ignispila;

public class Color {
	private byte red = (byte)255;
	private byte blue = (byte)255;
	private byte green = (byte)255;
	private byte alpha = (byte)255;
	public Color(byte red, byte green, byte blue, byte alpha){
		this.red = red;
		this.blue = blue;
		this.green = green;
		this.alpha = alpha;
	}
	
	public Color(byte red, byte green, byte blue){
		this.red = red;
		this.blue = blue;
		this.green = green;
	}
	
	public Color(int red, int green, int blue){
		this.red = (byte)red;
		this.blue = (byte)blue;
		this.green = (byte)green;
	}
	
	public Color(int red, int green, int blue, int alpha){
		this.red = (byte)red;
		this.blue = (byte)blue;
		this.green = (byte)green;
		this.alpha = (byte) alpha;
	}
	
	//getters
	public byte getRed(){
		return red;
	}
	public byte getGreen(){
		return green;
	}
	public byte getBlue(){
		return blue;
	}
	public byte getAlpha(){
		return alpha;
	}
	
	//setters
	public void setRed(byte red){
		this.red = red;
	}
	public void setGreen(byte green){
		this.green = green;
	}
	public void setBlue(byte blue){
		this.blue = blue;
	}
	public void setAlpha(byte alpha){
		this.alpha = alpha;
	}
}
