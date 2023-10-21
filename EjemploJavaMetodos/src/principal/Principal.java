package principal;

import clase.Ventana;

public class Principal
{
	public static void main(String[]args)
	{
		Ventana interfaz = new Ventana();
		interfaz.setBounds(100, 100, 700, 600);
		interfaz.setVisible(true);
		interfaz.setLocationRelativeTo(null);
	}
}