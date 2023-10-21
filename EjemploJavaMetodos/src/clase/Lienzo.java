package clase;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Lienzo extends JPanel implements ActionListener
{
	private Bolita pelotita1;
	
	JButton []boton = new JButton[4];
	
	public Lienzo()
	{
		setLayout(null);
		pelotita1 = new Bolita (100,100);
		repaint();
		
		for (int i=0 ; i<4 ; i++)
		{
			switch (i)
			{
			case 0:
				boton[0] = new JButton("→");
				boton[0].setBounds(610, 145, 50, 30);
				break;
			case 1:
				boton[1] = new JButton("←");
				boton[1].setBounds(550, 145, 50, 30);
				break;
			case 2:
				boton[2] = new JButton("↑");
				boton[2].setBounds(580, 110, 50, 30);
				break;
			case 3:
				boton[3] = new JButton("↓");
				boton[3].setBounds(580, 180, 50, 30);
				break;
			}
			boton[i].setFont(new Font("Times New Roman" , 2 , 16));
			boton[i].setForeground(new Color(30,0,255));
			boton[i].addActionListener(this);
			add(boton[i]);
		}
		
		setBackground(new Color(200,200,250));
	}
	
	public void paint (Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(pelotita1.devolverImagen() , pelotita1.devolverX() , pelotita1.devolverY() , null);
	}
	
	public void actionPerformed (ActionEvent eventito)
	{
		if (eventito.getSource() == boton[0]) // "→"
		{
			pelotita1.establecerX(pelotita1.devolverX() + 10);
			repaint();
		}
		
		if (eventito.getSource() == boton[1]) // "←"
		{
			pelotita1.establecerX(pelotita1.devolverX() - 10);
			repaint();
		}
		
		if (eventito.getSource() == boton[2]) // "↑"
		{
			pelotita1.establecerY(pelotita1.devolverY() - 10);
			repaint();
		}
		
		if (eventito.getSource() == boton[3]) // "↓"
		{
			pelotita1.establecerY(pelotita1.devolverY() + 10);
			repaint();
		}
	}
}