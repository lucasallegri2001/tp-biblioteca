package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazEmpleado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazEmpleado frame = new InterfazEmpleado();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Biblioteca Jenny");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTitulo.setBounds(10, 11, 234, 33);
		contentPane.add(labelTitulo);
		
		JLabel labelDescripcion = new JLabel("Acciones disponibles:");
		labelDescripcion.setBounds(10, 55, 234, 14);
		contentPane.add(labelDescripcion);
		
		JButton botonRegistrarVenta = new JButton("Registrar Venta");
		botonRegistrarVenta.setBounds(10, 80, 123, 23);
		botonRegistrarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazRegistroVenta.main(null);
				dispose();
			}
		});
		contentPane.add(botonRegistrarVenta);
		
		JButton botonRegistrarSocio = new JButton("Registrar Socio");
		botonRegistrarSocio.setBounds(10, 114, 123, 23);
		botonRegistrarSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazRegistroSocio.main(null);
				dispose();
			}
		});
		contentPane.add(botonRegistrarSocio);
		
		JButton botonRegistrarLibro = new JButton("Registrar Libro");
		botonRegistrarLibro.setBounds(10, 148, 123, 23);
		botonRegistrarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazRegistroLibro.main(null);
				dispose();
			}
		});
		contentPane.add(botonRegistrarLibro);
		
		JButton botonBusqueda = new JButton("Búsqueda");
		botonBusqueda.setBounds(10, 182, 123, 23);
		botonBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazBusqueda.main(null);
				dispose();
			}
		});
		contentPane.add(botonBusqueda);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.setBounds(10, 216, 123, 23);
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		contentPane.add(botonSalir);
	}
}
