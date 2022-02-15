package evaluacion2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class VentanaJListRacionales extends JFrame implements ActionListener,FocusListener {

	private static final long serialVersionUID = 6810668657706728672L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNumerador;
	private JTextField txtNumerador;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JList<Racional> lstRacionales;
	private DefaultListModel<Racional> dlm;
	private JLabel lblDenominador;
	private JTextField txtDenominador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListRacionales frame = new VentanaJListRacionales();
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
	public VentanaJListRacionales() {
		setTitle("VentanaJListRacionales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblNumerador = new JLabel("Numerador");
		panel.add(lblNumerador);
		
		txtNumerador = new JTextField();
		txtNumerador.addFocusListener(this);
		txtNumerador.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumerador.setText("0");
		panel.add(txtNumerador);
		txtNumerador.setColumns(10);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);
		
		lblDenominador = new JLabel("Denominador");
		panel.add(lblDenominador);
		
		txtDenominador = new JTextField();
		txtDenominador.addFocusListener(this);
		txtDenominador.setText("1");
		txtDenominador.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDenominador.setColumns(10);
		panel.add(txtDenominador);
		panel.add(btnInsertar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);
		
		// Modelo de datos de la lista
		dlm = new DefaultListModel<Racional>();
		dlm.addElement(new Racional(2));
		dlm.addElement(new Racional(4));
		dlm.addElement(new Racional(6));
		dlm.addElement(new Racional(8));
		// lista
		lstRacionales = new JList<Racional>();
		// asocio el DefaultListModel a la lista
		lstRacionales.setModel(dlm);
		contentPane.add(lstRacionales, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// obtengo sobre que componente se ha realizado la accion
		Object o = ae.getSource();
		if (o == btnInsertar){
			// si se ha pulsado btnInsertar
			int numerador;
			numerador = Integer.parseInt(txtNumerador.getText());
			int denominador;
			denominador = Integer.parseInt(txtDenominador.getText());
			// creo un nuevo Racional
			Racional r;
			r = new Racional(numerador,denominador);
			
			// compruebo si r esta en la lista
			if(dlm.contains(r)) {
				// si r esta en la lista
				JOptionPane.showMessageDialog(this,(String)"Error al Insertar. El Racional "+r+" ya está en la lista","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si r NO esta en la lista
				// Inserto el elemento en la lista de forma ordenada
				// busco la posicion a insertar
				int posicion=0;
				int mumeroelementos = dlm.getSize();
				while(posicion < mumeroelementos) {
					if (r.compareTo(dlm.get(posicion)) < 0) {
						// si encuentra la posicion
						// sale del while
						break;
					}
					posicion = posicion + 1;
				}
				// inserto el nuevo elemento en su posicion
				// JOptionPane.showMessageDialog(this,(String)"Posicion "+posicion+" Valor "+n,"Informacion",JOptionPane.INFORMATION_MESSAGE,null);
				dlm.add(posicion, r);
			}
		}
		else if (o == btnBorrar){
			// si se ha pulsado btnBorrar
			// compruebo si hay elementos seleccionados
			int[]indices = this.lstRacionales.getSelectedIndices();
			int numeroOpciones = indices.length;
			if(numeroOpciones == 0) {
				// si NO hay elementos seleccionados
				JOptionPane.showMessageDialog(this,(String)"Error al Borrar. NO hay elementos seleccionados","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si hay elementos seleccionados
				// los borro
				Racional opcion = new Racional();
				for(int posicion=numeroOpciones-1;posicion>=0;posicion--){
					// obtengo el elemento de la posicion a borrar
					opcion = dlm.getElementAt(indices[posicion]);
					// borro el elemento 
					dlm.removeElement(opcion);
				}
			}
		}
		else if (o == btnLimpiar){
			// si se ha pulsado btnLimpiar
			// compruebo si la lista esta vacia
			if(dlm.isEmpty()) {
				// si la lista esta vacia
				JOptionPane.showMessageDialog(this,(String)"Error al Limpiar. La lista YA está vacía","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si la NO lista esta vacia
				// la vacio
				dlm.clear();
			}
		}
	}

	@Override
	public void focusGained(FocusEvent fe) {
		// cuando coja el Foco selecciono todo el texto
		// obtengo sobre que componente se ha realizado la accion
		Object o = fe.getSource();
		JTextField tf = (JTextField) o;
		tf.select(0, tf.getText().length());
	}

	@Override
	public void focusLost(FocusEvent fe) {
		// cuando pierda el foco pierde la seleccion
		// obtengo sobre que componente se ha realizado la accion
		Object o = fe.getSource();
		JTextField tf = (JTextField) o;
		tf.select(0, 0);
	}
}
