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

public class VentanaRaiznew2 extends JFrame implements ActionListener{

	private static final long serialVersionUID = -7432671980495821429L;

	// defino los componentes
	private JLabel lblMensaje;
	private JButton btnAceptar;
	
	private JPanel contentPane;
	private JTextField txtDatos;
	private JLabel lblNewLabel;
	private JPanel panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRaiznew2 frame = new VentanaRaiznew2();
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
	public VentanaRaiznew2() {
		setTitle("VentanaRaiznew2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblMensaje = new JLabel("0.0");
		lblMensaje.setForeground(new Color(0, 0, 128));
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMensaje, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("Introduzca un n\u00FAmero real");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		
		txtDatos = new JTextField();
		txtDatos.addActionListener(this);
		txtDatos.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(txtDatos);
		txtDatos.setText("0.0");
		txtDatos.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		panel.add(btnAceptar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// obtengo el valor del texto de la caja de texto
		String valor;
		valor = txtDatos.getText();
		// convierto el valor a double
		double n;
		n = Double.parseDouble(valor);
		// calculo su raiz cuadrada
		double ranterior, ractual, error;
		ractual=0.0;
		ranterior = n/2;
		error = 1;
		while (error > 0.00000001){
			ractual =((n/ranterior)+ranterior)/2;
			error = ranterior - ractual;
			if(error < 0) {
				error = -error;
			}
			ranterior = ractual;
		}

		// muestro el resultado
		lblMensaje.setText("La raiz cuadrada de "+n+" es "+ractual);
	}

}
