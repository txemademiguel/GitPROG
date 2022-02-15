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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class VentanaJListAlumnosFicheros extends JFrame implements ActionListener,FocusListener,WindowListener {

	private static final long serialVersionUID = 6810668657706728672L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblDNI;
	private JTextField txtDNI;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JList<Alumno> lstAlumnos;
	private DefaultListModel<Alumno> dlm;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblFecha;
	private JTextField txtDia;
	private JLabel lblFecha_1;
	private JTextField txtMes;
	private JLabel lblFecha_2;
	private JTextField txtAño;
	private JButton btnOrdenar;
	private JComboBox<String> cmbOrdenar;
	private DefaultComboBoxModel<String> dcb;
	private ButtonGroup btgOrdenacion;
	private JRadioButton rbtAscendente;
	private JRadioButton rbtDescendente;
	
	private int orden;
	private JLabel lblGrupo;
	private JTextField txtGrupo;

	//controlo si los datos han sido modificados
	private boolean modificado = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListAlumnosFicheros frame = new VentanaJListAlumnosFicheros();
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
	public VentanaJListAlumnosFicheros() {
		setTitle("VentanaJListAlumnosFicheros");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(this);
		setBounds(100, 100, 1461, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblDNI = new JLabel("DNI");
		panel.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.addFocusListener(this);
		txtDNI.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDNI.setText("X");
		panel.add(txtDNI);
				
		lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addFocusListener(this);
		txtNombre.setText("NombreX");
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setColumns(10);
		panel.add(txtNombre);
		
		lblApellidos = new JLabel("Apellidos");
		panel.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.addFocusListener(this);
		txtApellidos.setText("ApellidosX");
		txtApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		txtApellidos.setColumns(10);
		panel.add(txtApellidos);
		
		lblFecha = new JLabel("Fecha nacimiento");
		panel.add(lblFecha);
		
		txtDia = new JTextField();
		txtDia.addFocusListener(this);
		txtDia.setText("1");
		txtDia.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDia.setColumns(2);
		panel.add(txtDia);
		
		lblFecha_1 = new JLabel("/");
		panel.add(lblFecha_1);
		
		txtMes = new JTextField();
		txtMes.addFocusListener(this);
		txtMes.setText("1");
		txtMes.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMes.setColumns(2);
		panel.add(txtMes);
		
		lblFecha_2 = new JLabel("/");
		panel.add(lblFecha_2);
		
		txtAño = new JTextField();
		txtAño.addFocusListener(this);
		txtAño.setText("2021");
		txtAño.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAño.setColumns(4);
		panel.add(txtAño);
		
		lblGrupo = new JLabel("Grupo");
		panel.add(lblGrupo);
		
		txtGrupo = new JTextField();
		txtGrupo.addFocusListener(this);
		txtGrupo.setText("1DW3");
		txtGrupo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGrupo.setColumns(4);
		panel.add(txtGrupo);
		
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);
		panel.add(btnInsertar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);
		
		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(this);
		panel.add(btnOrdenar);
		
		// DefaultComboBoxModel
		dcb = new DefaultComboBoxModel<String>();
		dcb.addElement("DNI");
		dcb.addElement("Nombre");
		dcb.addElement("Apellidos");
		dcb.addElement("Fecha");
		dcb.addElement("Grupo");
		// JComboBox
		cmbOrdenar = new JComboBox<String>();
		cmbOrdenar.setModel(dcb);
		cmbOrdenar.setSelectedIndex(0);
		panel.add(cmbOrdenar);
		
		// JRadioButtons
		rbtAscendente = new JRadioButton("Ascendente");
		rbtAscendente.setSelected(true);
		panel.add(rbtAscendente);
		rbtDescendente = new JRadioButton("Descendente");
		panel.add(rbtDescendente);
		//agrupo los radio buttons.
		btgOrdenacion = new ButtonGroup();
		btgOrdenacion.add(rbtAscendente);
		btgOrdenacion.add(rbtDescendente);
		
		// Modelo de datos de la lista
		dlm = new DefaultListModel<Alumno>();
		/*dlm.addElement(new Alumno(new Persona("2","Nombre 2","Apellidos 2"),"1DW3"));
		dlm.addElement(new Alumno(new Persona("4","Nombre 4","Apellidos 4"),"1AS3"));
		dlm.addElement(new Alumno(new Persona("6","Nombre 6","Apellidos 6"),"2AS3"));
		dlm.addElement(new Alumno(new Persona("8","Nombre 8","Apellidos 8"),"2DW3"));
		*/
		// lista
		lstAlumnos = new JList<Alumno>();
		// asocio el DefaultListModel a la lista
		lstAlumnos.setModel(dlm);
		contentPane.add(lstAlumnos, BorderLayout.CENTER);
		
		// cargo los datos desde el fichero en el dlm
		FileInputStream fis;
		ObjectInputStream ois;
		Alumno a = new Alumno();
		try {
			// abro el fichero
			fis = new FileInputStream("alumnos.ser");
			ois = new ObjectInputStream(fis);
			
			// leo todo el contenido
			while(fis.available() > 0) {
				a = (Alumno) ois.readObject(); // convierte los bytes leídos en un objeto de la clase Alumno
				// lo inserto en el dlm
				this.dlm.addElement(a);
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
			// cojo los valores de los campos de texto
			String dni = this.txtDNI.getText();
			String nombre = this.txtNombre.getText();
			String apellidos = this.txtApellidos.getText();
			int dia = Integer.parseInt(txtDia.getText());
			int mes = Integer.parseInt(txtMes.getText());
			int año = Integer.parseInt(txtAño.getText());
			String grupo = this.txtGrupo.getText();
			
			// creo una nueva Alumno
			Alumno a;
			a = new Alumno(new Persona(dni,nombre,apellidos,new Fecha(dia,mes,año)),grupo);
			
			// compruebo si a esta en la lista
			if(dlm.contains(a)) {
				// si a esta en la lista
				JOptionPane.showMessageDialog(this,(String)"Error al Insertar. El Alumno "+a+" ya está en la lista","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si p NO esta en la lista
				// Inserto el elemento en la lista 
				dlm.addElement(a);
				// indico que los datos han sido modificados
				modificado = true;
			}
		}
		else if (o == btnBorrar){
			// si se ha pulsado btnBorrar
			// compruebo si hay elementos seleccionados
			int[]indices = this.lstAlumnos.getSelectedIndices();
			int numeroOpciones = indices.length;
			if(numeroOpciones == 0) {
				// si NO hay elementos seleccionados
				JOptionPane.showMessageDialog(this,(String)"Error al Borrar. NO hay elementos seleccionados","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si hay elementos seleccionados
				// los borro
				Alumno opcion = new Alumno();
				for(int posicion=numeroOpciones-1;posicion>=0;posicion--){
					// obtengo el elemento de la posicion a borrar
					opcion = dlm.getElementAt(indices[posicion]);
					// borro el elemento 
					dlm.removeElement(opcion);
					// indico que los datos han sido modificados
					modificado = true;
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
				// indico que los datos han sido modificados
				modificado = true;
			}
		}
		else if (o == btnOrdenar){
			// si se ha pulsado btnOrdenar
			// paso los datos del dlm a un arrayList
		  ArrayList<Alumno> arrayList = new ArrayList<Alumno>();
		  for (int posicion=0; posicion < dlm.size(); posicion++) {
		  	arrayList.add(dlm.get(posicion));
		  }
		  
		  // obtengo el orden
		  // por defecto pongo Ascendente
		  orden = 1;
		  // compruebo si esta seleccionado Descendente
		  if(this.rbtDescendente.isSelected()) {
		  	// si esta seleccionado Descendente
		  	orden = -1;
		  }
			// obtengo el criterio de ordenacion
			String opcion = (String) this.cmbOrdenar.getSelectedItem();
			switch (opcion) {
			case "DNI":
				// ordeno el arrayList por dni 
				Collections.sort(arrayList, new Comparator<Alumno>() {
					@Override
					public int compare(Alumno p1, Alumno p2) {
					return (orden * p1.getDni().compareTo(p2.getDni()));
					}
					});
				break;
			case "Nombre":
				// ordeno el arrayList por nombre
				Collections.sort(arrayList, new Comparator<Alumno>() {
					@Override
					public int compare(Alumno p1, Alumno p2) {
					return (orden * p1.getNombre().compareTo(p2.getNombre()));
					}
					});
				break;
			case "Apellidos":
				// ordeno el arrayList por apellidos
				Collections.sort(arrayList, new Comparator<Alumno>() {
					@Override
					public int compare(Alumno p1, Alumno p2) {
					return (orden * p1.getApellidos().compareTo(p2.getApellidos()));
					}
					});
				break;
			case "Fecha":
				// ordeno el arrayList por fecha
				Collections.sort(arrayList, new Comparator<Alumno>() {
					@Override
					public int compare(Alumno p1, Alumno p2) {
					return (orden * p1.getFechanacimiento().compareTo(p2.getFechanacimiento()));
					}
					});
				break;
			case "Grupo":
				// ordeno el arrayList por grupo
				Collections.sort(arrayList, new Comparator<Alumno>() {
					@Override
					public int compare(Alumno p1, Alumno p2) {
					return (orden * p1.getGrupo().compareTo(p2.getGrupo()));
					}
					});
				break;
			}
			
			// paso los datos del arrayList ordenado al dlm
		  // borro los elementos antiguos del dlm
		  dlm.clear();
		  // añado al dlm los elementos del arrayList
		  for (Alumno a : arrayList) {
		  	dlm.addElement(a);
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
				// guardo los objetos en alumnos.ser
				FileOutputStream fos;
				ObjectOutputStream oos;
				try {
					// abro el fichero
					fos = new FileOutputStream("alumnos.ser");
					oos = new ObjectOutputStream (fos);
					// guardo todos los datos del dlm
					Alumno a;
					for(int posicion=0;posicion < this.dlm.size();posicion++) {
						// obtengo el objeto de esa posicion
						a = this.dlm.elementAt(posicion);
						// lo escribo en el fichero
						oos.writeObject(a);
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
		// cierro la aplicacion
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
