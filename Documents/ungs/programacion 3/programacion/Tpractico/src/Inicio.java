import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Toolkit;

public class Inicio extends JFrame{


	private static final long serialVersionUID = 1L;

	/**
	 * Create the application.
	 */
	//Constructor
	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/Imagen/2048.png")));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Tamaño ventana
		setBackground(Color.ORANGE);
		setTitle("\u00A12048 GAME!");
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblBienvenidosA = new JLabel("   \u00A1Bienvenidos a 2048!");
		lblBienvenidosA.setFont(new Font("Arial", Font.BOLD, 29));
		lblBienvenidosA.setForeground(Color.DARK_GRAY);
		lblBienvenidosA.setBounds(135, 11, 356, 60);
		getContentPane().add(lblBienvenidosA);
		
		
		
		//Boton con la opcion jugar donde se abre la interfaz Opciones
		JButton btnJugar = new JButton("   JUGAR");
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				
				setVisible(true);
				I2048 int2048= new I2048();
				int2048.setVisible(true);
			}
		});
		btnJugar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnJugar.setBackground(Color.LIGHT_GRAY);
		btnJugar.setForeground(Color.DARK_GRAY);
		btnJugar.setBounds(213, 193, 157, 50);
		ImageIcon jugar=new ImageIcon(Inicio.class.getResource("/Imagen/play.png"));
		btnJugar.setIcon(new ImageIcon(jugar.getImage().getScaledInstance(btnJugar.getHeight()-10,btnJugar.getHeight()-10,Image.SCALE_SMOOTH)));
		getContentPane().add(btnJugar);
		
		//Boton con la opcion salir
		JButton btnSalir = new JButton("    SALIR");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnSalir.setForeground(Color.DARK_GRAY);
		btnSalir.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnSalir.setBounds(213, 303, 157, 50);
		ImageIcon salir=new ImageIcon(Inicio.class.getResource("/Imagen/exit.png"));
		btnSalir.setIcon(new ImageIcon(salir.getImage().getScaledInstance(btnSalir.getHeight()-10,btnSalir.getHeight()-10,Image.SCALE_SMOOTH)));
		btnSalir.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btnSalir);
		
		
	}
	
	 	
}
