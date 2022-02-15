package evaluacion1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VentanaJPasswordField extends JFrame implements ActionListener{

	private static final long serialVersionUID = -7432671980495821429L;

	// defino los componentes
	private JLabel lblTexto;
	private JButton btnAceptar;
	
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblContrasea;
	private JPasswordField pwfContrasena;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJPasswordField frame = new VentanaJPasswordField();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaJPasswordField() {
		setTitle("VentanaJPasswordField");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblTexto = new JLabel("An\u00F3nimo.");
		lblTexto.setForeground(new Color(0, 0, 128));
		lblTexto.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTexto, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("Usuario");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		
		txtUsuario = new JTextField();
		txtUsuario.addActionListener(this);
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(txtUsuario);
		txtUsuario.setColumns(20);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(0, 0, 128));
		panel.add(lblContrasea);
		
		pwfContrasena = new JPasswordField();
		pwfContrasena.addActionListener(this);
		pwfContrasena.setColumns(20);
		panel.add(pwfContrasena);
		panel.add(btnAceptar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// compruebo si los datos son correctos
		String usuariocorrecto = "1dw3";
		String contracorrecta = "1dw3";
		
		// obtengo el valor del texto de la caja de texto
		String usuario;
		usuario = txtUsuario.getText();
		// obtengo el valor del texto del JPasswordField
		String contrasena;
		contrasena = new String(pwfContrasena.getPassword());

		// comparo los valores de tipo String
		if(usuario.equals(usuariocorrecto) && contrasena.equals(contracorrecta)) {
			// si son iguales
			lblTexto.setText("Bienvenido "+usuario);
		}
		else {
			// si NO son iguales
			lblTexto.setText("Datos Incorrectos.");
		}
	}
}
