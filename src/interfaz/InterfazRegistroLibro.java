package interfaz;

import datos.Libro;
import datos.Socio;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazRegistroLibro extends JFrame {

	private JPanel contentPane;
	private JTextField fieldStock;
	private JTextField fieldNombre;
	private JTextField fieldPrecioBase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazRegistroLibro frame = new InterfazRegistroLibro();
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
	public InterfazRegistroLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		fieldPrecioBase = new JTextField();
		fieldPrecioBase.setColumns(10);
		fieldPrecioBase.setBounds(10, 167, 100, 20);
		contentPane.add(fieldPrecioBase);

		JLabel labelPrecioBase = new JLabel("Precio Base");
		labelPrecioBase.setBounds(10, 151, 115, 14);
		contentPane.add(labelPrecioBase);
		
		fieldStock = new JTextField();
		fieldStock.setColumns(10);
		fieldStock.setBounds(10, 119, 35, 20);
		contentPane.add(fieldStock);
		
		JLabel labelStock = new JLabel("Stock");
		labelStock.setBounds(10, 102, 115, 14);
		contentPane.add(labelStock);
		
		fieldNombre = new JTextField();
		fieldNombre.setColumns(10);
		fieldNombre.setBounds(10, 71, 190, 20);
		contentPane.add(fieldNombre);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(10, 55, 115, 14);
		contentPane.add(labelNombre);
		
		JLabel labelTitulo = new JLabel("Biblioteca Jenny - Registrar Libro");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTitulo.setBounds(10, 11, 234, 33);
		contentPane.add(labelTitulo);

		JButton botonRegistrar = new JButton("Registrar");
		botonRegistrar.setBounds(10, 210, 115, 23);
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Libro libro = new Libro(fieldNombre.getText(), Integer.parseInt(fieldStock.getText()), Double.parseDouble(fieldPrecioBase.getText()));
				Interfaz.ventas.addLibro(libro);
				if(Interfaz.ventas.guardarLibro(libro)) {
					InterfazEmpleado.main(null);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Error al guardar socio");
				}
			}
		});
		contentPane.add(botonRegistrar);
	}

}
