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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaExpendedorCambio extends JFrame {

	private static final long serialVersionUID = -7432671980495821429L;

	// defino los componentes
	private JLabel lblMensaje;
	private JButton btnAceptar;
	
	private JPanel contentPane;
	private JTextField txtOpcion;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblSaldo;
	private JTextField txtSaldo;
	private JPanel panelOpciones;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaExpendedorCambio frame = new VentanaExpendedorCambio();
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
	public VentanaExpendedorCambio() {
		setForeground(new Color(0, 0, 128));
		setTitle("VentanaExpendedorCambio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblMensaje = new JLabel("Seleccione una Opci\u00F3n");
		lblMensaje.setForeground(new Color(0, 0, 128));
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMensaje, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("Opcion");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		
		txtOpcion = new JTextField();
		txtOpcion.setForeground(new Color(0, 0, 128));
		txtOpcion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtOpcion.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(txtOpcion);
		txtOpcion.setText("1");
		txtOpcion.setColumns(5);
		
		lblSaldo = new JLabel("Saldo");
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSaldo.setForeground(new Color(0, 0, 128));
		panel.add(lblSaldo);
		
		txtSaldo = new JTextField();
		txtSaldo.setForeground(new Color(0, 0, 128));
		txtSaldo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSaldo.setText("0.0");
		txtSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSaldo.setColumns(5);
		panel.add(txtSaldo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(0, 0, 128));
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnAceptar);
		
		panelOpciones = new JPanel();
		contentPane.add(panelOpciones, BorderLayout.CENTER);
		GridBagLayout gbl_panelOpciones = new GridBagLayout();
		gbl_panelOpciones.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panelOpciones.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelOpciones.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelOpciones.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelOpciones.setLayout(gbl_panelOpciones);
		
		lblNewLabel_1 = new JLabel("1. Caf\u00E9 (0,43 \u20AC)");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 0;
		panelOpciones.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("2. Refrescos (1,11 \u20AC)");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 1;
		panelOpciones.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("3. Agua (0,36 \u20AC)");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 2;
		panelOpciones.add(lblNewLabel_3, gbc_lblNewLabel_3);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// obtengo el valor del saldo de la caja de texto txtSaldo
				String valor;
				valor = txtSaldo.getText();
				// convierto el valor a double
				double saldo;
				saldo = Double.parseDouble(valor);
				
				// obtengo el valor de la opcion de la caja de texto txtOpcion
				valor = txtOpcion.getText();
				// convierto el valor a int
				int opcion;
				opcion = Integer.parseInt(valor);
				String mensaje ="";
				double cambio;
				
				// compruebo si la opcion es correcta
				if(opcion >= 1 && opcion <= 3) {
					// si es correcta
					double precio=0.0;
					switch (opcion) {
					case 1:
						precio = 0.43;
						break;
					case 2:
						precio = 1.11;
						break;
					case 3:
						precio = 0.36;
						break;
					}
					// compruebo el saldo
					if(saldo >= precio) {
						// si el saldo es mayor o igual
						mensaje = "Su producto. Gracias.";
						cambio = saldo - precio;		
					}
					else {
						// si el saldo NO es mayor o igual
						mensaje = "Saldo insuficiente.";
						cambio = saldo;
					}
				}
				else {
					// si la opcion NO es correcta
					mensaje = "Opción incorrecta.";
					cambio = saldo;
				}
				// pongo el mensaje en lblMensaje
				mensaje = mensaje + " Cambio: "+cambio+" euros";
				lblMensaje.setText(mensaje);
				// calcular las monedas del cambio
				int cambioentero;
				int e2,e1,c50,c20,c10,c5,c2,c1;
				cambioentero = (int) (cambio * 100);
				e2 = cambioentero / 200;
				cambioentero = cambioentero % 200;
				e1 = cambioentero / 100;
				cambioentero = cambioentero % 100;
				c50 = cambioentero / 50;
				cambioentero = cambioentero % 50;
				c20 = cambioentero / 20;
				cambioentero = cambioentero % 20;
				c10 = cambioentero / 10;
				cambioentero = cambioentero % 10;
				c5 = cambioentero / 5;
				cambioentero = cambioentero % 5;
				c2 = cambioentero / 2;
				cambioentero = cambioentero % 2;
				c1 = cambioentero;
				// muestro las monedas del cambio
				mensaje = mensaje + "Monedas cambio: 2e:"+e2+" 1e:"+e1+" 50cts:"+c50+" 20cts:"+c20+" 10cts:"+c10+" 5cts:"+c5+" 2cts:"+c2+" 1cts:"+c1;
				lblMensaje.setText(mensaje);
			}
		});
	}

}
