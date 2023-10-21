package clases;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bolita
{
	private int x,y;
	private Image imagen;
	
	public Bolita(int xe,int ye,int color)
	{
		x = xe;
		y = ye;
		imagen = new ImageIcon(getClass().getResource("Imags/" + color + ".png")).getImage();
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
	public void establecerX(int xe)
	{
		x = xe;
	}
	public void establecerY(int ye)
	{
		y = ye;
	}
}
