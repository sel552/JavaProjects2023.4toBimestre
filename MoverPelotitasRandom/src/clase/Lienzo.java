package clase;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Lienzo extends JPanel implements ActionListener
{
	private Bolita []pelotita = new Bolita[3];
	JButton []boton = new JButton[3];
	
	float aleatorioX , aleatorioY;
	
	Random random = new Random();
	
	public Lienzo()
	{
		setLayout(null);
		for (int i = 0 ; i<3 ; i++)
		{
			pelotita[i] = new Bolita((random.nextInt(485)+25) , (random.nextInt(350)+100) , (random.nextInt(10)+1));
			repaint();
			switch(i)
			{
				case 0:
					boton[0] = new JButton("Color Random");
					break;
				case 1:
					boton[1] = new JButton("Mover Random");
					break;
				case 2:
					boton[2] = new JButton("Cambiar Random");
					break;
			}
			boton[i].setBounds((25+(i*180)), 35 , 170, 30);
			boton[i].setFont(new Font("Times New Roman" , 1 , 16));
			boton[i].setForeground(new Color(30,0,255));
			boton[i].addActionListener(this);
			add(boton[i]);
		}
		setBackground(new Color(180,180,250));
	}
	
	public void paint (Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i=0 ; i<3 ; i++)
		{
			g2.drawImage(pelotita[i].devolverImagen() , pelotita[i].devolverX() , pelotita[i].devolverY() , null);
		}
		g2.drawRect(25, 100, 535, 400);
	}
	
	public void actionPerformed (ActionEvent eventito)
	{
		if (eventito.getSource() == boton[0]) // "COLOR RANDOM"
		{
			for (int i=0 ; i<3 ; i++)
			{
				pelotita[i].devolverImagenColor();
				repaint();
			}
		}
		if (eventito.getSource() == boton[1]) // "MOVER RANDOM" LISTO
		{
			for (int i=0 ; i<3 ; i++)
			{
				pelotita[i].establecerX(pelotita[i].devolverX() + (random.nextInt(10)-5));
				pelotita[i].establecerY(pelotita[i].devolverY() + (random.nextInt(10)-5));
				int ubicacionX = pelotita[i].devolverX();
				int ubicacionY = pelotita[i].devolverY();
				if (ubicacionX>510)
				{
					pelotita[i].establecerX(25);
				}
				if (ubicacionX<25)
				{
					pelotita[i].establecerX(510);
				}
				if (ubicacionY>450)
				{
					pelotita[i].establecerY(100);
				}
				if (ubicacionY<100)
				{
					pelotita[i].establecerY(450);
				}
				repaint();
			}
		}
		if (eventito.getSource() == boton[2]) // "CAMBIAR RANDOM"
		{
			for (int i=0 ; i<3 ; i++)
			{
				pelotita[i].devolverImagenColor();
				pelotita[i].establecerX(pelotita[i].random.nextInt(485)+25);
				pelotita[i].establecerY(pelotita[i].random.nextInt(350)+100);
				repaint();
			}
		}
	}
}