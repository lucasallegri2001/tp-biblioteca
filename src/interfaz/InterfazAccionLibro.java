package interfaz;

import datos.Libro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InterfazAccionLibro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Libro libro) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazAccionLibro frame = new InterfazAccionLibro(libro);
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
	public InterfazAccionLibro(Libro libro) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelTitulo = new JLabel("Libro - " + libro.getNombre() + " - Stock: " + libro.getStock());
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTitulo.setBounds(10, 11, 234, 33);
		contentPane.add(labelTitulo);

		JLabel labelDescripcion = new JLabel("Acciones disponibles:");
		labelDescripcion.setBounds(10, 55, 234, 14);
		contentPane.add(labelDescripcion);

		JButton botonRenombrarLibro = new JButton("Renombrar libro");
		botonRenombrarLibro.setBounds(10, 80, 200, 23);
		botonRenombrarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nuevoNombre = JOptionPane.showInputDialog(null, "Ingresar el nuevo nombre");
				Interfaz.ventas.renombrarLibro(libro, nuevoNombre);
				JOptionPane.showMessageDialog(null, "Se cambió el nombre del libro a " + nuevoNombre);
				dispose();
				InterfazEmpleado.main(null);
			}
		});
		contentPane.add(botonRenombrarLibro);

		JButton botonReponerStock = new JButton("Reponer stock");
		botonReponerStock.setBounds(10, 114, 200, 23);
		botonReponerStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nuevoStock = JOptionPane.showInputDialog(null, "Ingresar la nueva cant. de stock (numérico, sin puntos ni comas)");
				Interfaz.ventas.reponerStock(libro, Integer.parseInt(nuevoStock));
				JOptionPane.showMessageDialog(null, "Se cambió el stock del libro " + libro.getNombre() + " a " + nuevoStock);
				dispose();
				InterfazEmpleado.main(null);
			}
		});
		contentPane.add(botonReponerStock);

		JButton botonVerVentas = new JButton("Ver unidades vendidas del día");
		botonVerVentas.setBounds(10, 148, 200, 23);
		botonVerVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] resumen = Interfaz.ventas.ventasLibroEspecifico(libro);
				if(resumen[0] != 0) {
					JOptionPane.showMessageDialog(null, "Se vendieron " + resumen[0] + " unidades de este libro. Ganancias totales: $" + resumen[1]);
				}
				dispose();
				InterfazEmpleado.main(null);
			}
		});
		contentPane.add(botonVerVentas);
	}

}
