package clase;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lienzo extends JPanel implements ActionListener
{
	private Bolitas []moneda = new Bolitas[3];
	JButton boton;
	JLabel etiqueta;
	JLabel apuestaUsuario;
	JTextField campo;
	
	int monto = 500 , iniciar = 0 , apuesta = 0;
	int tipo[] = {0,0,0};
	
	float aleatorioX , aleatorioY;
	
	Random random = new Random();
	
	public Lienzo()
	{
		setLayout(null);
		for (int i = 0 ; i<3 ; i++)
		{
			moneda[i] = new Bolitas(700, 700 , random.nextInt(6)); // OUT OF SIGHT, OUT OF MIND
			repaint();
		}
		
		boton = new JButton("Accion");
		boton.setBounds(50, 300 , 100, 30);
		boton.setFont(new Font("Times New Roman" , 1 , 16));
		boton.setForeground(new Color(30,0,255));
		boton.addActionListener(this);
		add(boton);
		
		etiqueta = new JLabel("Monto inicial: 500");
		etiqueta.setBounds(50, 50, 400, 100);
		etiqueta.setFont(new Font("Times New Roman" , 1 , 16));
		add(etiqueta);
		etiqueta.setVisible(true);
		
		apuestaUsuario = new JLabel("Apuesta del usuario:");
		apuestaUsuario.setBounds(50, 130, 200, 100);
		apuestaUsuario.setFont(new Font("Times New Roman" , 1 , 16));
		add(apuestaUsuario);
		apuestaUsuario.setVisible(true);
		
	    campo = new JTextField();
		campo.setBounds(50, 200, 100, 50);
		add (campo);
		
		setBackground(new Color(180,180,250));
}
	
	public void paint (Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i=0 ; i<3 ; i++)
		{
			g2.drawImage(moneda[i].devolverImagen() , moneda[i].devolverX() , moneda[i].devolverY() , null);
		}
		g2.drawRect(280, 190, 240, 100);
	}
	
	public void actionPerformed (ActionEvent eventito)
	{
		if (eventito.getSource() == boton)
		{
			apuesta = Integer.parseInt(campo.getText());
			for (int j=0 ; j<3 ; j++)
			{
				tipo[j] = (random.nextInt(6));
			}
			
			if (apuesta <= monto)
			{
				for (int j=0 ; j<3 ; j++)
				{
					moneda[j].establecerImagenNueva(tipo[j]);
					moneda[j].establecerX(280+80*j);
					moneda[j].establecerY(200);
				}
				repaint();
				
				if (tipo[0] == tipo[1] || tipo[0] == tipo[2] || tipo[1] == tipo[2]) // DOS IGUALES
				{
					if (tipo[0] == tipo[1] && tipo[1] == tipo[2]) // TRES IGUALES
					{
						monto = monto + (apuesta*3);
					}
					monto = monto + (apuesta*2);
				}
				else // TODOS DIFERENTES
				{
					monto = monto-apuesta;
				}
				etiqueta.setText("Monto: " + monto);
			}
			else
			{
				etiqueta.setText("La apuesta supera al monto de " + monto);
			}
		}
	}
}