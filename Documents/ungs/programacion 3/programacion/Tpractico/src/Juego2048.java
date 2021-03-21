import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class Juego2048 {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego2048 window = new Juego2048();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Juego2048() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("2048");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(60, 59, 282, 64);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBackground(Color.WHITE);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("GAME 2048");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(129, 0, 144, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.getContentPane().add(lblNewLabel);
		
		JButton buttonUp = new JButton("UP");
		buttonUp.setBounds(158, 159, 89, 23);
		frame.getContentPane().add(buttonUp);
		
		JButton buttonLeft = new JButton("LEFT");
		buttonLeft.setBounds(96, 193, 89, 23);
		frame.getContentPane().add(buttonLeft);
		
		JButton buttonRight = new JButton("RIGHT");
		buttonRight.setBounds(210, 193, 89, 23);
		frame.getContentPane().add(buttonRight);
		
		JButton buttonDown = new JButton("DOWN");
		buttonDown.setBounds(158, 227, 89, 23);
		frame.getContentPane().add(buttonDown);
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\armin\\Documents\\ungs\\programacion 3\\semana2\\space-with-stars-universe-space-infinity-and-starlight-background-starry-night-sky-galaxy-and-planets-in-cosmos-pattern-vector.jpg"));
		lblFondo.setBounds(0, 0, 424, 261);
		frame.getContentPane().add(lblFondo);
	}
}
