package interfaz;

import datos.Socio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InterfazAccionSocio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Socio socio) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazAccionSocio frame = new InterfazAccionSocio(socio);
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
	public InterfazAccionSocio(Socio socio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelTitulo = new JLabel("Socio - " + socio.getNombre() + " " + socio.getApellido() + " - Nivel: " + socio.getNivel());
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTitulo.setBounds(10, 11, 234, 33);
		contentPane.add(labelTitulo);

		JLabel labelDescripcion = new JLabel("Acciones disponibles:");
		labelDescripcion.setBounds(10, 55, 234, 14);
		contentPane.add(labelDescripcion);

		JButton botonCambiarNivel = new JButton("Cambiar nivel");
		botonCambiarNivel.setBounds(10, 80, 200, 23);
		botonCambiarNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nivel = JOptionPane.showInputDialog(null, "Ingresar nuevo nivel (1-5)");
				Interfaz.ventas.cambiarNivel(socio, Integer.parseInt(nivel));
				JOptionPane.showMessageDialog(null, "Se cambió el nivel del socio a " + nivel);
				dispose();
				InterfazEmpleado.main(null);
			}
		});
		contentPane.add(botonCambiarNivel);

		JButton botonAgregarMulta = new JButton("Agregar multa");
		botonAgregarMulta.setBounds(10, 114, 200, 23);
		botonAgregarMulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz.ventas.agregarMulta(socio);
				JOptionPane.showMessageDialog(null, "Se agregó una multa al socio.");
				dispose();
				InterfazEmpleado.main(null);
			}
		});
		contentPane.add(botonAgregarMulta);

		JButton botonBorrar = new JButton("Borrar");
		botonBorrar.setBounds(10, 148, 200, 23);
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz.ventas.borrarSocio(socio);
				JOptionPane.showMessageDialog(null, "Socio borrado.");
				dispose();
				InterfazEmpleado.main(null);
			}
		});
		contentPane.add(botonBorrar);
	}

}
