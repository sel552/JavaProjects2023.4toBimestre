package clase;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Bolitas 
{
	private Image imagen;
	private int x, y, fotito;
	Random random = new Random();
	
	public Bolitas(int xe , int ye , int img)
	{
		imagen = new ImageIcon(getClass().getResource("Imags/moneda_"+ img +".png")).getImage();
		x=xe;
		y=ye;
		fotito=img;
	}
	public int devolverX()
	{
		return x;
	}
	public int devolverY()
	{
		return y;
	}
	public Image devolverImagen()
	{
		return imagen;
	}
	public void establecerImagenNueva(int fotito)
	{
		imagen = new ImageIcon(getClass().getResource("Imags/moneda_"+ fotito +".png")).getImage();
	}
	public void establecerX(int xe)
	{
		x=xe;
	}
	public void establecerY(int ye)
	{
		y=ye;
	}
}