package evaluacion2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

public class VentanaJListComplejosFicheros extends JFrame implements ActionListener,FocusListener,WindowListener {

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
	
	//controlo si los datos han sido modificados
	private boolean modificado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListComplejosFicheros frame = new VentanaJListComplejosFicheros();
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
	public VentanaJListComplejosFicheros() {
		setTitle("VentanaJListComplejosFicheros");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(this);
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
		
		// cargo los datos desde el fichero en el dlm
		FileInputStream fis;
		ObjectInputStream ois;
		Complejo c = new Complejo();
		try {
			// abro el fichero
			fis = new FileInputStream("complejos.dat");
			ois = new ObjectInputStream(fis);
			
			// leo todo el contenido
			while(fis.available() > 0) {
				c = (Complejo) ois.readObject(); // convierte los bytes leídos en un objeto de la clase Complejo
				// lo inserto en el dlm
				this.dlm.addElement(c);
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(this,(String)"Error. No se ha encontrado el Fichero","Error",JOptionPane.ERROR_MESSAGE,null);
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(this,(String)"Error de Entrada / Salida","Error",JOptionPane.ERROR_MESSAGE,null);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this,(String)"Error. No se ha encontrado la clase Complejo","Error",JOptionPane.ERROR_MESSAGE,null);
		}
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
				// indico que los datos han sido modificados
				modificado = true;
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
				// indico que los datos han sido modificados
				modificado = true;
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
				// indico que los datos han sido modificados
				modificado = true;
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

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// controlo el cierre de la ventana
		// compruebo si los datos han sido modificados
		if (modificado == true) {
			// si los datos han sido modificados
			// pregunto si los quiere guardar
			int opcion = JOptionPane.showConfirmDialog(this,(String)"Los datos han sido modificados. ¿Desea Guardarlos?","Datos Modificados",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null);
			// compruebo la respuesta
			switch(opcion) {
			case JOptionPane.YES_OPTION:
				// si ha pulsado SI
				// guardo los datos del dlm en un fichero
				// guardo el complejo en complejos.dat
				FileOutputStream fos;
				ObjectOutputStream oos;
				try {
					// abro el fichero
					fos = new FileOutputStream("complejos.dat");
					oos = new ObjectOutputStream (fos);
					// guardo todos los datos del dlm
					Complejo c;
					for(int posicion=0;posicion < this.dlm.size();posicion++) {
						// obtengo el objeto de esa posicion
						c = this.dlm.elementAt(posicion);
						// lo escribo en el fichero
						oos.writeObject(c);
					}
					// cierro el fichero
					oos.close();
					fos.close();
				} catch (FileNotFoundException fnfe) {
					JOptionPane.showMessageDialog(this,(String)"Error. No se ha encontrado el Fichero","Error",JOptionPane.ERROR_MESSAGE,null);
				} catch (IOException ioe) {
					JOptionPane.showMessageDialog(this,(String)"Error de Entrada / Salida","Error",JOptionPane.ERROR_MESSAGE,null);
				}
				break;
			/*case JOptionPane.NO_OPTION:
				// si ha pulsado NO
				break;
				*/
			case JOptionPane.CANCEL_OPTION:
			case JOptionPane.CLOSED_OPTION:
				// si ha pulsado Cancelar o
				// si ha cerrado la ventana
				return;
			}
		}
		
		// salgo de la aplicacion
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
