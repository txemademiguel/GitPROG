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

public class VentanaJListComplejos extends JFrame implements ActionListener,FocusListener {

	private static final long serialVersionUID = 6810668657706728672L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblReal;
	private JTextField txtReal;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JList<Complejo> lstComplejos;
	private DefaultListModel<Complejo> dlm;
	private JLabel lblImaginaria;
	private JTextField txtImaginaria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListComplejos frame = new VentanaJListComplejos();
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
	public VentanaJListComplejos() {
		setTitle("VentanaJListComplejos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblReal = new JLabel("Real");
		panel.add(lblReal);
		
		txtReal = new JTextField();
		txtReal.addFocusListener(this);
		txtReal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtReal.setText("0.0");
		panel.add(txtReal);
		txtReal.setColumns(10);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);
		
		lblImaginaria = new JLabel("Imaginaria");
		panel.add(lblImaginaria);
		
		txtImaginaria = new JTextField();
		txtImaginaria.addFocusListener(this);
		txtImaginaria.setText("0.0");
		txtImaginaria.setHorizontalAlignment(SwingConstants.RIGHT);
		txtImaginaria.setColumns(10);
		panel.add(txtImaginaria);
		panel.add(btnInsertar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);
		
		// Modelo de datos de la lista
		dlm = new DefaultListModel<Complejo>();
		//dlm.addElement(new Complejo(2.0));
		//dlm.addElement(new Complejo(2.0));
		//dlm.addElement(new Complejo(6.0));
		//dlm.addElement(new Complejo(8.0));
		// lista
		lstComplejos = new JList<Complejo>();
		// asocio el DefaultListModel a la lista
		lstComplejos.setModel(dlm);
		contentPane.add(lstComplejos, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// obtengo sobre que componente se ha realizado la accion
		Object o = ae.getSource();
		if (o == btnInsertar){
			// si se ha pulsado btnInsertar
			double real;
			real = Double.parseDouble(txtReal.getText());
			double imaginaria;
			imaginaria = Double.parseDouble(txtImaginaria.getText());
			// creo un nuevo Complejo
			Complejo c;
			c = new Complejo(real,imaginaria);
			
			// compruebo si c esta en la lista
			if(dlm.contains(c)) {
				// si c esta en la lista
				JOptionPane.showMessageDialog(this,(String)"Error al Insertar. El Complejo "+c+" ya está en la lista","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si c NO esta en la lista
				// Inserto el elemento en la lista de forma ordenada
				// busco la posicion a insertar
				int posicion=0;
				int mumeroelementos = dlm.getSize();
				while(posicion < mumeroelementos) {
					if (c.compareTo(dlm.get(posicion)) < 0) {
						// si encuentra la posicion
						// sale del while
						break;
					}
					posicion = posicion + 1;
				}
				// inserto el nuevo elemento en su posicion
				// JOptionPane.showMessageDialog(this,(String)"Posicion "+posicion+" Valor "+n,"Informacion",JOptionPane.INFORMATION_MESSAGE,null);
				dlm.add(posicion, c);
			}
		}
		else if (o == btnBorrar){
			// si se ha pulsado btnBorrar
			// compruebo si hay elementos seleccionados
			int[]indices = this.lstComplejos.getSelectedIndices();
			int numeroOpciones = indices.length;
			if(numeroOpciones == 0) {
				// si NO hay elementos seleccionados
				JOptionPane.showMessageDialog(this,(String)"Error al Borrar. NO hay elementos seleccionados","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si hay elementos seleccionados
				// los borro
				Complejo opcion = new Complejo();
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
