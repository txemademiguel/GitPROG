package evaluacion1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import javax.swing.ListSelectionModel;

public class VentanaJListVariosCamposOrdenado extends JFrame implements ActionListener,ListSelectionListener {

	private static final long serialVersionUID = 6810668657706728672L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblDNI;
	private JTextField txtDNI;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	
	private JPanel panelListas;
	private JList<String> lstDNIs;
	private DefaultListModel<String> dlmDNIs;
	private JList<String> lstNombres;
	private DefaultListModel<String> dlmNombres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListVariosCamposOrdenado frame = new VentanaJListVariosCamposOrdenado();
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
	public VentanaJListVariosCamposOrdenado() {
		setTitle("VentanaJListVariosCampos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblDNI = new JLabel("DNI");
		panel.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setText("00000000X");
		txtDNI.addActionListener(this);
		txtDNI.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);
		
		lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre X");
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setColumns(10);
		panel.add(txtNombre);
		panel.add(btnInsertar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);
		
		panelListas = new JPanel();
		contentPane.add(panelListas, BorderLayout.CENTER);
		panelListas.setLayout(new GridLayout(1, 2, 0, 0));
		
		// Modelo de datos de la lista de DNIs
		dlmDNIs = new DefaultListModel<String>();
		dlmDNIs.addElement("22222222B");
		dlmDNIs.addElement("44444444D");

		// lista de DNIs
		lstDNIs = new JList<String>();
		lstDNIs.addListSelectionListener(this);
		lstDNIs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// asocio el DefaultListModel a la lista de DNIs
		lstDNIs.setModel(dlmDNIs);
		
		// Modelo de datos de la lista de DNIs
		dlmNombres = new DefaultListModel<String>();
		dlmNombres.addElement("Nombre 2");
		dlmNombres.addElement("Nombre 4");

		// lista de Nombres
		lstNombres = new JList<String>();
		lstNombres.addListSelectionListener(this);
		lstNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// asocio el DefaultListModel a la lista de Nombres
		lstNombres.setModel(dlmNombres);
			
		// añado las listas a panelListas
		panelListas.add(lstDNIs);
		panelListas.add(lstNombres);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// obtengo sobre que componente se ha realizado la accion
		Object o = ae.getSource();
		if (o == btnInsertar){
			// si se ha pulsado btnInsertar
			String dni;
			dni = txtDNI.getText();
			if(dni.equals("")) {
				// si el dni esta vacio
				JOptionPane.showMessageDialog(this,(String)"Error al Insertar. El campo DNI debe tener un valor","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si el dni NO esta vacio
				// compruebo si dni esta en la lista
				if(dlmDNIs.contains(dni)) {
					// si dni esta en la lista
					JOptionPane.showMessageDialog(this,(String)"Error al Insertar. El DNI "+dni+" ya está en la lista","Error",JOptionPane.ERROR_MESSAGE,null);
				}
				else {
					// si el dni NO esta en la lista
					// Inserto el elemento en la lista de manera ordenada
					// busco la posicion a insertar
					int posicion=0;
					int mumeroelementos = dlmDNIs.getSize();
					
					while(posicion < mumeroelementos) {
						if (dni.compareTo(dlmDNIs.get(posicion)) < 0) {
							// si encuentra la posicion
							// sale del while
							break;
						}
						posicion = posicion + 1;
					}
					// inserto el nuevo elemento en su posicion
					// JOptionPane.showMessageDialog(this,(String)"Posicion "+posicion+" Valor "+n,"Informacion",JOptionPane.INFORMATION_MESSAGE,null);
					dlmDNIs.add(posicion, dni); 
					String nombre;
					nombre=txtNombre.getText();
					// compruebo si el nombre tiene valor
					if(nombre.equals("")) {
						// si esta en blanco
						// creo un nombre con un espacio en blanco
						nombre = " ";
					}
					// inserto el nombre en su lista
					dlmNombres.add(posicion,nombre);
				}
			}
		}
		else if (o == btnBorrar){
			// si se ha pulsado btnBorrar
			// compruebo si hay elementos seleccionados
			if(lstDNIs.isSelectionEmpty()) {
				// si NO hay elementos seleccionados
				JOptionPane.showMessageDialog(this,(String)"Error al Borrar. NO hay elementos seleccionados","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si hay elementos seleccionados
				// los borro
				int posicion;
				posicion = lstDNIs.getSelectedIndex();
				// borro el elemento de la posicion a borrar
				dlmDNIs.removeElementAt(posicion);
				dlmNombres.removeElementAt(posicion);
			}
		}
		else if (o == btnLimpiar){
			// si se ha pulsado btnLimpiar
			// compruebo si la lista esta vacia
			if(dlmDNIs.isEmpty()) {
				// si la lista esta vacia
				JOptionPane.showMessageDialog(this,(String)"Error al Limpiar. La lista YA está vacía","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si la lista de DNIs NO esta vacia
				// vacio todas las listas
				dlmDNIs.clear();
				dlmNombres.clear();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		// obtengo sobre que componente se ha realizado la accion
		Object o = lse.getSource();
		// obtengo el valor de la posicion seleccionada en ese componente
		int posicion;
		posicion = ((JList<String>)o).getSelectedIndex();
		// selecciono los elementos de esa posicion en todas las listas
		lstDNIs.setSelectedIndex(posicion);
		lstNombres.setSelectedIndex(posicion);
		// actualizo los valores de las cajas de texto
		txtDNI.setText(lstDNIs.getSelectedValue());
		txtNombre.setText(lstNombres.getSelectedValue());
	}
}
