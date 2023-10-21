package clases;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lamina extends JPanel implements ActionListener
{
	JLabel textito1;
	JButton botoncito1;
	Bolita pelotita1,pelotita2,pelotita3; // Esto es mucho mejor reemplazarlo por un vector: sería Bolita[] pelotitas = new Bolita[3]; y luego se detalla cada una en el constructor como siempre
	
	public Lamina()
	{
		setLayout(null);
		
		botoncito1 = new JButton("¡Mover!");
		botoncito1.setBounds(10,70,100,30);
		botoncito1.setFont(new Font("Andale Mono", 1, 14));
		add(botoncito1);
		botoncito1.addActionListener(this);
		
		textito1 = new JLabel("Movimiento y aparición aleatoria de 3 bolitas");
		textito1.setBounds(10,10,600,30);
		textito1.setFont(new Font("Andale Mono", 1, 24));
		add(textito1);
		
		pelotita1 = new Bolita(100+(int)(Math.random()*550),150+(int)(Math.random()*250),(int)(Math.random()*10));
		pelotita2 = new Bolita(100+(int)(Math.random()*550),150+(int)(Math.random()*250),(int)(Math.random()*10));
		pelotita3 = new Bolita(100+(int)(Math.random()*550),150+(int)(Math.random()*250),(int)(Math.random()*10));
	}
	
	public void actionPerformed(ActionEvent eventito)
	{
		pelotita1.establecerX(pelotita1.devolverX() -5 + (int)(Math.random()*10));
		pelotita2.establecerX(pelotita2.devolverX() -5 + (int)(Math.random()*10));
		pelotita3.establecerX(pelotita3.devolverX() -5 + (int)(Math.random()*10));
		pelotita1.establecerY(pelotita1.devolverY() -5 + (int)(Math.random()*10));
		pelotita2.establecerY(pelotita2.devolverY() -5 + (int)(Math.random()*10));
		pelotita3.establecerY(pelotita3.devolverY() -5 + (int)(Math.random()*10));
		repaint();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(pelotita1.devolverImagen(), pelotita1.devolverX(), pelotita1.devolverY(), null);
		g2.drawImage(pelotita2.devolverImagen(), pelotita2.devolverX(), pelotita2.devolverY(), null);
		g2.drawImage(pelotita3.devolverImagen(), pelotita3.devolverX(), pelotita3.devolverY(), null);
		
		g2.drawRect(100, 150, 600, 300); // dibuja un rectángulo de 600x300 en la posición (100,150)
	}
}
