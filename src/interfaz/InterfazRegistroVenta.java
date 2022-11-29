package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InterfazRegistroVenta extends JFrame {

	private JPanel contentPane;
	private JTextField fieldID;
	private JTextField fieldCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazRegistroVenta frame = new InterfazRegistroVenta();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent windowEvent) {
							InterfazEmpleado.main(null);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazRegistroVenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Biblioteca Jenny - Registrar Venta");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTitulo.setBounds(10, 11, 234, 33);
		contentPane.add(labelTitulo);
		
		JLabel labelID = new JLabel("ID Libro");
		labelID.setBounds(10, 55, 115, 14);
		contentPane.add(labelID);
		
		fieldID = new JTextField();
		fieldID.setBounds(10, 71, 86, 20);
		contentPane.add(fieldID);
		fieldID.setColumns(10);
		
		JLabel labelCantidad = new JLabel("Cant. vendida");
		labelCantidad.setBounds(10, 102, 115, 14);
		contentPane.add(labelCantidad);
		
		fieldCantidad = new JTextField();
		fieldCantidad.setBounds(10, 119, 86, 20);
		contentPane.add(fieldCantidad);
		fieldCantidad.setColumns(10);
		
		JButton botonRegistrar = new JButton("Registrar");
		botonRegistrar.setBounds(10, 178, 115, 23);
		contentPane.add(botonRegistrar);
	}
}
