import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class I2048 extends JFrame implements  KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Variables de instancia
	ArrayList<JButton> listaBotones;
	private JButton Oyente;
	Boolean ultimaJugada=false;
	
	int tama�o;
	int tama�oVentana;
	Tablero tablero;
	JButton Salir;
	JButton UNDO;
	JButton btnJugadaSugerida;
	JLabel labelContadorPuntaje;
	JLabel labelSalidaPuntaje;
	JLabel labelJugadaSugerida;
	boolean presionoBtnSugerencia=false;
	boolean presionoBtnUNDO=false;
	

	/**
	 * Create the application.
	 */
	//Constructor
	public I2048()
	{
		setBackground(Color.ORANGE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(I2048.class.getResource("/Imagen/2048.png")));
		
		this.tama�oVentana=600;
		this.tablero=new Tablero(4);
		getContentPane().add(getOyente());
		System.out.println("Se inicia el juego");
		initialize();		
		SetListaBotones(tablero.getTama�o());
			IncializarTablero(tablero);
			tablero.iniciarPartida();		
			ActualizarTablero( tablero);
		addKeyListener(this);
		getContentPane().add(labelSalidaPuntaje);
		
		getContentPane().setLayout(null);			
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		getContentPane().setLayout(null);
		//Asigna el titulo del juego
		setTitle("�2048 GAME!");
		setVisible(true);
		//Tama�o de la ventana
		setBounds(100, 100, tama�oVentana, tama�oVentana);	
		//Pone ventana en el centro
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		
	
		//Area donde se imprime el puntaje
		labelSalidaPuntaje = new JLabel();
		labelSalidaPuntaje.setBounds(this.tama�oVentana/2-110/2, this.tama�oVentana-110, 110, 25);
	
		//Boton salir
		Salir= new JButton("Volver");
		Salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Inicio intf=new Inicio();
				intf.setLocationRelativeTo(null);
				intf.setVisible(true);
			}
		});
		Salir.setForeground(Color.DARK_GRAY);
		Salir.setFont(new Font("Arial Black", Font.PLAIN, 14));
		Salir.setBounds(this.tama�oVentana/2-120/2, this.tama�oVentana-80, 120, 30);
		ImageIcon salir=new ImageIcon(Inicio.class.getResource("/Imagen/volver.png"));
		Salir.setIcon(new ImageIcon(salir.getImage().getScaledInstance(Salir.getHeight()-5,Salir.getHeight()-5,Image.SCALE_SMOOTH)));
		getContentPane().add(Salir);
		
		
	}
	
	//Metodo que crea las celdas poniendolas en un arraylist
	public void SetListaBotones(int tama�o){ 
		listaBotones = new ArrayList<>();
		int tama�oLetra= tama�o == 4 ? 24 : tama�o == 6 ? 18 : 11;
		for(int i= 0; i < tama�o; i++) 
		{
			for (int j=0;j<tama�o;j++)
			{
				JButton boton= new JButton("0");
				
				boton.setFont(new Font("Arial",Font.PLAIN,tama�oLetra));
				
				listaBotones.add(boton);
			}
		}
	}
	
	//Metodo que inicializa el tablero dibuajando las celdas
	public void IncializarTablero(Tablero tablero) {
		int tama�oCelda=(tablero.getTama�o()==4 ? 119: tablero.getTama�o()==6 ? 79:59 );
		int espacio = tama�oCelda+1;
		
		for(int i=0 ; i < tablero.getTama�o() ; i++) {
			for(int j=0;j<tablero.getTama�o();j++) {
				listaBotones.get(tablero.getTama�o()*i+j).setBounds(55+espacio*(j), espacio * i+10,tama�oCelda,tama�oCelda);
				getContentPane().add(listaBotones.get(tablero.getTama�o()*i+j));				
			}
		}
		
		setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Metodo que actualiza el tablero cada vez que se realiza un moviento
	public void ActualizarTablero(Tablero tablero)
	{	
		for(int i=0;i<tablero.getTama�o(); i++) {
			for(int j=0;j<tablero.getTama�o();j++) {
				if (tablero.GetCeldas()[i][j].celdaVacia())
				{
					listaBotones.get(tablero.getTama�o()*i+j).setText( "" );
				}
				else
				{
					listaBotones.get(tablero.getTama�o()*i+j).setText( String.valueOf(tablero.GetCeldas()[i][j].ObtenerValor()) );
				}
				if (tablero.GetCeldas()[i][j].ObtenerValor()<8)
				{
					listaBotones.get(tablero.getTama�o()*i+j).setForeground(Color.blue);
				}
				else
				{
					listaBotones.get(tablero.getTama�o()*i+j).setForeground(Color.LIGHT_GRAY);
				}
				AsignarColores(listaBotones.get(tablero.getTama�o()*i+j));
				
				listaBotones.get(tablero.getTama�o()*i+j).setEnabled(false);
			}
		}
		labelSalidaPuntaje.setText("PUNTAJE: "+String.valueOf(tablero.getPuntajes()));
	}
	
	//Metodo para escuchar los teclados
	 private JButton getOyente() {
		  Oyente = new JButton("");
		  Oyente.addKeyListener(this);
		  Oyente.setBounds(10, 10, 100, 0);
		  return Oyente;
	 }
	 
	 //Metodo que asigna los colores a las celdas
	 private void AsignarColores(JButton boton) {
	
		 switch(boton.getText()) {
		 case "":
			 boton.setBackground(Color.black);
			 break;
		 case "2":
			 boton.setBackground(new Color(231, 223, 134));
			 break;
		 case "4":
			 boton.setBackground(new Color(151, 206, 104));
			 break;
		 case "8":
			 boton.setBackground(new Color(240, 79, 3));
			 break;
		 case "16":
			 boton.setBackground(new Color(116, 116, 204));
			 break;
		 case "32":
			 boton.setBackground(new Color(89, 188, 251));
			 break;
		 case "64":
			 boton.setBackground(new Color(245, 213, 69));
			 break;
		 case "128":
			 boton.setBackground(new Color(46, 204, 113));
			 break;
		 case "256":
			 boton.setBackground(new Color(254, 198, 6));
			 break;
		 case "512":
			 boton.setBackground(new Color(151, 206, 104));
			 break;
		 case "1024":
			 boton.setBackground(new Color(136, 112, 255));
			 break;
		 case "2048":
			 boton.setBackground(new Color(255, 215, 0));
			 break;
			 
		 }
		 
		
	 }
	 	@Override
		public void keyPressed(KeyEvent e) 
	 	{
			  if(tablero.puedeMover() )//&& this.ultimaJugada==false) 
			  {
				  if(KeyEvent.VK_DOWN==e.getKeyCode()) 
				  {
						tablero.abajo();						
				  }
				  if(KeyEvent.VK_UP==e.getKeyCode()) 
				  {
						tablero.arriba();
				  }
				  if(KeyEvent.VK_RIGHT==e.getKeyCode()) 
				  {
					  tablero.derecha();
				  }
					
				  if(KeyEvent.VK_LEFT==e.getKeyCode()) 
				  {
						tablero.izquierda();
						
				  }
							
				  this.ActualizarTablero(tablero);
//				  tablero.mostrarPrevio();
//				  tablero.mostrarTablero();
				 
				 
			  }
			  
				  
			 
		}

	 	 
	 	 @Override
	 	 public void keyReleased(KeyEvent e) {
	 		 if(KeyEvent.VK_DOWN==e.getKeyCode()) {
	 		 	  System.out.println("Solt� tecla ABAJO");

				}
				if(KeyEvent.VK_UP==e.getKeyCode()) {
				 	  System.out.println("Solt� tecla ARRIBA");

					
				}
				if(KeyEvent.VK_RIGHT==e.getKeyCode()) {
				 	  System.out.println("Solt� tecla DERECHA");

				}
				if(KeyEvent.VK_LEFT==e.getKeyCode()) {
				 	  System.out.println("Solt� tecla IZQUIERDA");
				}
	 	 }
	 	 
	 	 @Override
	 	 public void keyTyped(KeyEvent e) {
	 	  System.out.println("Escribi� una tecla");
	 	 }
	 	 
	 	
	 	
	 	}


	

