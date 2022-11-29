package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazLogin extends JFrame {

	private JPanel contentPane;
	private JTextField fieldUsuario;
	private JTextField fieldContraseña;
	private JLabel labelMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazLogin frame = new InterfazLogin();
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
	public InterfazLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Biblioteca Jenny - Login");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(18, 17, 206, 33);
		contentPane.add(labelTitulo);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(20, 72, 46, 14);
		contentPane.add(labelUsuario);
		
		fieldUsuario = new JTextField();
		fieldUsuario.setBounds(20, 86, 110, 20);
		contentPane.add(fieldUsuario);
		fieldUsuario.setColumns(10);
		
		JLabel labelContraseña = new JLabel("Contraseña");
		labelContraseña.setBounds(20, 117, 86, 14);
		contentPane.add(labelContraseña);
		
		fieldContraseña = new JTextField();
		fieldContraseña.setBounds(20, 132, 110, 20);
		contentPane.add(fieldContraseña);
		
		JButton botonIngresar = new JButton("Ingresar");
		botonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Interfaz.ventas.login(fieldUsuario.getText(), fieldContraseña.getText())) {
				  InterfazEmpleado.main(null);
					dispose();
				} else {
				  labelMensaje.setText("Error: Usuario o contraseña incorrecta");
				}
			}
		});
		botonIngresar.setBounds(20, 195, 89, 23);
		contentPane.add(botonIngresar);
		
		labelMensaje = new JLabel("");
		labelMensaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelMensaje.setBounds(18, 170, 221, 14);
		contentPane.add(labelMensaje);
	}
}
