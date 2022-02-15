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

public class VentanaSegundoi extends JFrame {

	private static final long serialVersionUID = -7432671980495821429L;

	// defino los componentes
	private JLabel lblMensaje;
	private JButton btnAceptar;
	
	private JPanel contentPane;
	private JTextField txtHoras;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JTextField txtMinutos;
	private JLabel lblNewLabel_2;
	private JTextField txtSegundos;
	private JLabel lblNewLabel_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSegundoi frame = new VentanaSegundoi();
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
	public VentanaSegundoi() {
		setTitle("VentanaSegundoi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblMensaje = new JLabel("0h 0m 0s");
		lblMensaje.setForeground(new Color(0, 0, 128));
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMensaje, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("Introduzca una hora");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		
		txtHoras = new JTextField();
		txtHoras.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(txtHoras);
		txtHoras.setText("0");
		txtHoras.setColumns(5);
		
		lblNewLabel_1 = new JLabel("horas");
		panel.add(lblNewLabel_1);
		
		txtMinutos = new JTextField();
		txtMinutos.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMinutos.setText("0");
		panel.add(txtMinutos);
		txtMinutos.setColumns(5);
		
		lblNewLabel_2 = new JLabel("minutos");
		panel.add(lblNewLabel_2);
		
		txtSegundos = new JTextField();
		txtSegundos.setText("0");
		txtSegundos.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSegundos.setColumns(5);
		panel.add(txtSegundos);
		
		lblNewLabel_3 = new JLabel("segundos");
		panel.add(lblNewLabel_3);
		
		btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// obtengo el valor del texto de las cajas de texto
				String valor;
				int horas;
				int minutos;
				int segundos;
				
				// convierto el valor de txtHoras a int
				valor = txtHoras.getText();
				horas = Integer.parseInt(valor);
				
				// convierto el valor de txtMinutos a int
				valor = txtMinutos.getText();
				minutos = Integer.parseInt(valor);
				
				// convierto el valor de txtSegundos a int
				valor = txtSegundos.getText();
				segundos = Integer.parseInt(valor);
				
				// incremento 1 el valor de segundos
				segundos = segundos + 1;
				
				if(segundos > 59) {
					minutos = minutos + 1;
					segundos = 0;
					if(minutos > 59) {
						horas = horas + 1;
						minutos = 0;
					}
				}
				
				// actualizo la hora
				lblMensaje.setText(horas+"h "+minutos+"m "+segundos+"s");
			}
		});
	}

}
