package clases;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame
{

	public Ventana()
    {
            setVisible(true);
            setTitle("BolitasAleatorias");
    		getContentPane().setBackground(new Color(191,191,191));
    		setIconImage(new ImageIcon(getClass().getResource("Imags/0.png")).getImage());

            Lamina Tablero=new Lamina();
            add(Tablero);
    }
}
