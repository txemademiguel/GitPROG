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

public class JOptionPaneShowConfirmDialog extends JFrame implements ActionListener {

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
					JOptionPaneShowConfirmDialog frame = new JOptionPaneShowConfirmDialog();
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
	public JOptionPaneShowConfirmDialog() {
		setTitle("JOptionPaneShowConfirmDialog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblMensaje = new JLabel("No se ha pulsado un bot\u00F3n");
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
		int opcion = JOptionPane.showConfirmDialog(this,(String)"Prueba de Cuadros de Diálogo","Cuadro de Diálogo de Confirmación",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null);
		switch (opcion) {
		case JOptionPane.YES_OPTION:
			// si ha pulsado Si
			lblMensaje.setText("Ha Pulsado Sí");
			break;
		case JOptionPane.NO_OPTION:
			// si ha pulsado NO
			lblMensaje.setText("Ha Pulsado No");
			break;
		case JOptionPane.CANCEL_OPTION:
			// si ha pulsado Cancelar
			lblMensaje.setText("Ha Pulsado Cancelar");
			break;
		case JOptionPane.CLOSED_OPTION:
			// si ha Cerrado la Ventana
			lblMensaje.setText("Error no se ha introducido una opción válida");
			break;
		}
	}
}
