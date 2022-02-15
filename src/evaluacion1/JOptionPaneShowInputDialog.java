package evaluacion1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JOptionPaneShowInputDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = -7432671980495821429L;

	// defino los componentes
	private JLabel lblMensaje;
	private JButton btnAceptar;
	
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPaneShowInputDialog frame = new JOptionPaneShowInputDialog();
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
	public JOptionPaneShowInputDialog() {
		setTitle("JOptionPaneShowInputDialog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblMensaje = new JLabel("An\u00F3nimo");
		lblMensaje.setForeground(new Color(0, 0, 128));
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMensaje, BorderLayout.NORTH);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Cuando pulse el boton
		String respuesta = (String)JOptionPane.showInputDialog(this,(String)"Introduzca su Nombre: ","Cuadro de Diálogo de Introducción de Datos",JOptionPane.QUESTION_MESSAGE,null, null, "Sin Nombre");
		if(respuesta != null) {
			// si hay respuesta
			lblMensaje.setText("Hola "+respuesta);
		}
		else {
			// si NO hay respuesta
			lblMensaje.setText("Error no se ha introducido un valor válido");
		}
		
	}

}
