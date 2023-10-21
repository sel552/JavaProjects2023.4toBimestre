package clase;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bolita 
{
	private Image imagen; // CREAMOS UN ATRIBUTO DEL TIPO IMAGE
	private int x, y;
	
	public Bolita(int xe , int ye)
	{
		imagen = new ImageIcon(getClass().getResource("Image/pelotitaBasket.png")).getImage();
		x = xe;
		y = ye;
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
	public void establecerX (int xe)
	{
		x = xe;
	}
	public void establecerY (int ye)
	{
		y = ye;
	}
}
