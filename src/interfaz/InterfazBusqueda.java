package interfaz;

import datos.Libro;
import datos.Socio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InterfazBusqueda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazBusqueda frame = new InterfazBusqueda();
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
	public InterfazBusqueda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelTitulo = new JLabel("Biblioteca Jenny - Búsqueda");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTitulo.setBounds(10, 11, 234, 33);
		contentPane.add(labelTitulo);

		JLabel labelDescripcion = new JLabel("Acciones disponibles:");
		labelDescripcion.setBounds(10, 55, 234, 14);
		contentPane.add(labelDescripcion);

		JButton botonBuscarSocio = new JButton("Buscar Socio");
		botonBuscarSocio.setBounds(10, 80, 200, 23);
		botonBuscarSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = JOptionPane.showInputDialog(contentPane, "Ingrese el DNI del socio a buscar");
				Socio socio = Interfaz.ventas.buscarSocio(dni);
				if(socio == null) {
					JOptionPane.showMessageDialog(contentPane, "No se encontró ningún socio con ese DNI");
				} else {
					InterfazAccionSocio.main(null, socio);
				}
				dispose();
			}
		});
		contentPane.add(botonBuscarSocio);

		JButton botonBuscarLibro = new JButton("Buscar Libro");
		botonBuscarLibro.setBounds(10, 114, 200, 23);
		botonBuscarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del libro a buscar");
				Libro libro = Interfaz.ventas.buscarLibro(nombre);
				if(libro == null) {
					JOptionPane.showMessageDialog(null, "No se encontró ningún libro con ese nombre");
				} else {
					InterfazAccionLibro.main(null, libro);
				}
				dispose();
			}
		});
		contentPane.add(botonBuscarLibro);

		JButton botonBuscarMultados = new JButton("Buscar Multados");
		botonBuscarMultados.setBounds(10, 148, 200, 23);
		botonBuscarMultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedList<Socio> multados = Interfaz.ventas.buscarMultados();
				if(multados.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay socios multados");
				} else {
					String[] nombres = new String[multados.size()];
					for(int i = 0; i < multados.size(); i++) {
						Socio multado = multados.get(i);
						nombres[i] = multado.getNombre() + " " + multado.getApellido() + " ( " + multado.getDni() + " )";
					}
					Object index = JOptionPane.showInputDialog(null,"Socios multados","Socios multados",JOptionPane.INFORMATION_MESSAGE,null,nombres,nombres[0]);
					InterfazAccionSocio.main(null, Interfaz.ventas.buscarSocio( ((String)index).split(" ")[3] ));
				}
				dispose();
			}
		});
		contentPane.add(botonBuscarMultados);

		JButton botonBuscarLibrosDisponibles = new JButton("Buscar Libros Disponibles");
		botonBuscarLibrosDisponibles.setBounds(10, 182, 200, 23);
		botonBuscarLibrosDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedList<Libro> disponibles = Interfaz.ventas.librosDisponibles();
				if(disponibles.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay libros disponibles");
				} else {
					String[] nombres = new String[disponibles.size()];
					for(int i = 0; i < disponibles.size(); i++) {
						Libro libro = disponibles.get(i);
						nombres[i] = libro.getNombre();
					}
					Object index = JOptionPane.showInputDialog(null,"Libros disponibles","Libros disponibles",JOptionPane.INFORMATION_MESSAGE,null,nombres,nombres[0]);
					InterfazAccionLibro.main(null, Interfaz.ventas.buscarLibro( (String) index ));
				}
				dispose();
			}
		});
		contentPane.add(botonBuscarLibrosDisponibles);

		JButton botonBuscarSociosRegistrados = new JButton("Buscar Socios Registrados");
		botonBuscarSociosRegistrados.setBounds(10, 216, 200, 23);
		botonBuscarSociosRegistrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedList<Socio> registrados = Interfaz.ventas.sociosRegistrados();
				String dni;
				if(registrados.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay socios registrados");
				} else {
					String[] nombres = new String[registrados.size()];
					for(int i = 0; i < registrados.size(); i++) {
						Socio registrado = registrados.get(i);
						nombres[i] = registrado.getNombre() + " " + registrado.getApellido() + " ( " + registrado.getDni() + " )";
					}
					Object index = JOptionPane.showInputDialog(null,"Socios registrados","Socios registrados",JOptionPane.INFORMATION_MESSAGE,null,nombres,nombres[0]);
					InterfazAccionSocio.main(null, Interfaz.ventas.buscarSocio( ((String)index).split(" ")[3] ));
				}
				dispose();
			}
		});
		contentPane.add(botonBuscarSociosRegistrados);
	}

}
