package interfaz;

import datos.Socio;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazRegistroSocio extends JFrame {

	private JPanel contentPane;
	private JTextField fieldApellido;
	private JTextField fieldNombre;
	private JTextField fieldDNI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazRegistroSocio frame = new InterfazRegistroSocio();
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
	public InterfazRegistroSocio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fieldApellido = new JTextField();
		fieldApellido.setColumns(10);
		fieldApellido.setBounds(10, 119, 160, 20);
		contentPane.add(fieldApellido);
		
		JLabel labelApellido = new JLabel("Apellido");
		labelApellido.setBounds(10, 102, 115, 14);
		contentPane.add(labelApellido);
		
		fieldNombre = new JTextField();
		fieldNombre.setColumns(10);
		fieldNombre.setBounds(10, 71, 160, 20);
		contentPane.add(fieldNombre);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(10, 55, 115, 14);
		contentPane.add(labelNombre);
		
		JLabel labelTitulo = new JLabel("Biblioteca Jenny - Registrar Socio");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTitulo.setBounds(10, 11, 234, 33);
		contentPane.add(labelTitulo);
		
		fieldDNI = new JTextField();
		fieldDNI.setColumns(10);
		fieldDNI.setBounds(10, 167, 115, 20);
		contentPane.add(fieldDNI);
		
		JLabel labelDNI = new JLabel("DNI");
		labelDNI.setBounds(10, 150, 115, 14);
		contentPane.add(labelDNI);
		
		JButton botonRegistrar = new JButton("Registrar");
		botonRegistrar.setBounds(10, 215, 115, 23);
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Socio socio = new Socio(fieldNombre.getText(), fieldApellido.getText(), fieldDNI.getText());
				if(Interfaz.ventas.guardarSocio(socio)) {
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
