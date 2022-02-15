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

public class VentanaActionListenerComunDiferentesComponentes extends JFrame implements ActionListener{

	private static final long serialVersionUID = -7432671980495821429L;

	// defino los componentes
	private JLabel lblTexto;
	private JButton btn1;
	
	private JPanel contentPane;
	private JPanel panel;
	private JButton btn2;
	private JButton btn3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaActionListenerComunDiferentesComponentes frame = new VentanaActionListenerComunDiferentesComponentes();
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
	public VentanaActionListenerComunDiferentesComponentes() {
		setTitle("VentanaActionListenerComunDiferentesComponentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblTexto = new JLabel("Ning\u00FAn bot\u00F3n pulsado");
		lblTexto.setForeground(new Color(0, 0, 128));
		lblTexto.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTexto, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btn1 = new JButton("1");
		btn1.addActionListener(this);
		panel.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(this);
		panel.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(this);
		panel.add(btn3);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// obtengo sobre que componente se ha realizado la accion
		Object o = ae.getSource();
		if (o == btn1){
			// si se ha pulsado btn1
			lblTexto.setText("Has pulsado el botón 1");
		}
		else if (o == btn2){
			// si se ha pulsado btn2
			lblTexto.setText("Has pulsado el botón 2");
		}
		else if (o == btn3){
			// si se ha pulsado btn3
			lblTexto.setText("Has pulsado el botón 3");
		}
	}
}
