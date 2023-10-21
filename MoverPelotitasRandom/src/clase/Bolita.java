package clase;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Bolita 
{
	private Image imagen; // CREAMOS UN ATRIBUTO DEL TIPO IMAGE
	private int x, y;
	Random random = new Random();
	
	public Bolita(int xe , int ye , int img)
	{
		imagen = new ImageIcon(getClass().getResource("Image/bolita_" + (random.nextInt(10)+1) + ".png")).getImage();
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
	public Image devolverImagenColor()
	{
		imagen = new ImageIcon(getClass().getResource("Image/bolita_" + (random.nextInt(10)+1) + ".png")).getImage();
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
