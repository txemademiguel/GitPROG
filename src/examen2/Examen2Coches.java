package examen2;

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
import java.awt.Font;

public class Examen2Coches extends JFrame implements ActionListener,FocusListener,WindowListener {

	private static final long serialVersionUID = 6810668657706728672L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblMarca;
	private JTextField txtMarca;
	private JLabel lblModelo;
	private JTextField txtModelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblStock;
	private JTextField txtStock;
	
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JList<Coche> lstCoches;
	private DefaultListModel<Coche> dlm;
	
	private JButton btnOrdenar;
	private JComboBox<String> cmbOrdenar;
	private DefaultComboBoxModel<String> dcb;
	private ButtonGroup btgOrdenacion;
	private JRadioButton rbtAscendente;
	private JRadioButton rbtDescendente;
	
	private int orden;

	//controlo si los datos han sido modificados
	private boolean modificado = false;
	private JPanel panelTotales;
	private JLabel lblStockTotal;
	private JLabel lblValorStockTotal;
	private JLabel lblTotal;
	private JLabel lblValorTotal;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen2Coches frame = new Examen2Coches();
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
	public Examen2Coches() {
		setTitle("Examen2Coches - Txema De Miguel");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(this);
		setBounds(100, 100, 1461, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblMarca = new JLabel("Marca");
		panel.add(lblMarca);
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.addFocusListener(this);
		txtMarca.setHorizontalAlignment(SwingConstants.LEFT);
		txtMarca.setText("Marca X");
		panel.add(txtMarca);
				
		lblModelo = new JLabel("Modelo");
		panel.add(lblModelo);
		txtModelo = new JTextField();
		txtModelo.addFocusListener(this);
		txtModelo.setText("Modelo X");
		txtModelo.setHorizontalAlignment(SwingConstants.LEFT);
		txtModelo.setColumns(10);
		panel.add(txtModelo);
		
		lblPrecio = new JLabel("Precio");
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.addFocusListener(this);
		txtPrecio.setText("1.0");
		txtPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrecio.setColumns(10);
		panel.add(txtPrecio);
		
		lblStock = new JLabel("Stock");
		panel.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.addFocusListener(this);
		txtStock.setText("1");
		txtStock.setHorizontalAlignment(SwingConstants.RIGHT);
		txtStock.setColumns(4);
		panel.add(txtStock);
		
		
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
		dcb.addElement("Marca");
		dcb.addElement("Modelo");
		dcb.addElement("Precio");
		dcb.addElement("Stock");

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
		dlm = new DefaultListModel<Coche>();
		dlm.addElement(new Coche("Marca 2","Modelo 6",5000.0,4));
		dlm.addElement(new Coche("Marca 2","Modelo 8",3000.0,5));
		dlm.addElement(new Coche("Marca 6","Modelo 4",4000.0,3));
		dlm.addElement(new Coche("Marca 8","Modelo 2",1000.0,2));
	
		// lista
		lstCoches = new JList<Coche>();
		// asocio el DefaultListModel a la lista
		lstCoches.setModel(dlm);
		contentPane.add(lstCoches, BorderLayout.CENTER);
		
		panelTotales = new JPanel();
		contentPane.add(panelTotales, BorderLayout.SOUTH);
		
		lblStockTotal = new JLabel("Stock Total:");
		panelTotales.add(lblStockTotal);
		
		lblValorStockTotal = new JLabel("0");
		lblValorStockTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelTotales.add(lblValorStockTotal);
		
		lblTotal = new JLabel("Total:");
		panelTotales.add(lblTotal);
		
		lblValorTotal = new JLabel("0.0");
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelTotales.add(lblValorTotal);
		
		// cargo los datos desde el fichero en el dlm
		FileInputStream fis;
		ObjectInputStream ois;
		Coche c = new Coche();
		try {
			// abro el fichero
			fis = new FileInputStream("coches.ser");
			ois = new ObjectInputStream(fis);
			
			// leo todo el contenido
			while(fis.available() > 0) {
				c = (Coche) ois.readObject(); // convierte los bytes leídos en un objeto de la clase Coche
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
		// calculo los totales
		calcularTotales();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// obtengo sobre que componente se ha realizado la accion
		Object o = ae.getSource();
		if (o == btnInsertar){
			// si se ha pulsado btnInsertar
			// cojo los valores de los campos de texto
			String marca = this.txtMarca.getText();
			String modelo = this.txtModelo.getText();
			Double precio = Double.parseDouble(this.txtPrecio.getText());
			Integer stock = Integer.parseInt(this.txtStock.getText());
			
			// creo un nuevo elemento
			Coche c;
			c = new Coche(marca,modelo,precio,stock);
			
			// compruebo si el elemento esta en la lista
			if(dlm.contains(c)) {
				// si el elemento esta en la lista
				JOptionPane.showMessageDialog(this,(String)"Error al Insertar. El Coche ya está en la lista","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si el elemento NO esta en la lista
				// Inserto el elemento en la lista 
				dlm.addElement(c);
				// indico que los datos han sido modificados
				modificado = true;
			}
		}
		else if (o == btnBorrar){
			// si se ha pulsado btnBorrar
			// compruebo si hay elementos seleccionados
			int[]indices = this.lstCoches.getSelectedIndices();
			int numeroOpciones = indices.length;
			if(numeroOpciones == 0) {
				// si NO hay elementos seleccionados
				JOptionPane.showMessageDialog(this,(String)"Error al Borrar. NO hay elementos seleccionados","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si hay elementos seleccionados
				// los borro
				Coche opcion = new Coche();
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
		  ArrayList<Coche> arrayList = new ArrayList<Coche>();
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
			case "Marca":
				// ordeno el arrayList por Marca 
				Collections.sort(arrayList, new Comparator<Coche>() {
					@Override
					public int compare(Coche c1, Coche c2) {
					return (orden * c1.getMarca().compareTo(c2.getMarca()));
					}
					});
				break;
			case "Modelo":
				// ordeno el arrayList por Modelo
				Collections.sort(arrayList, new Comparator<Coche>() {
					@Override
					public int compare(Coche c1, Coche c2) {
					return (orden * c1.getModelo().compareTo(c2.getModelo()));
					}
					});
				break;
			case "Precio":
				// ordeno el arrayList por Precio
				Collections.sort(arrayList, new Comparator<Coche>() {
					@Override
					public int compare(Coche c1, Coche c2) {
						Double p1 = c1.getPrecio();
						Double p2 = c2.getPrecio();
					return (orden * p1.compareTo(p2));
					}
					});
				break;
			case "Stock":
				// ordeno el arrayList por Stock
				Collections.sort(arrayList, new Comparator<Coche>() {
					@Override
					public int compare(Coche c1, Coche c2) {
						Integer s1 = c1.getStock();
						Integer s2 = c2.getStock();
					return (orden * s1.compareTo(s2));
					}
					});
				break;
			}
			
			// paso los datos del arrayList ordenado al dlm
		  // borro los elementos antiguos del dlm
		  dlm.clear();
		  // añado al dlm los elementos del arrayList
		  for (Coche c : arrayList) {
		  	dlm.addElement(c);
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
				// guardo los objetos en coches.ser
				FileOutputStream fos;
				ObjectOutputStream oos;
				try {
					// abro el fichero
					fos = new FileOutputStream("coches.ser");
					oos = new ObjectOutputStream (fos);
					// guardo todos los datos del dlm
					Coche c;
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
	// calculo los totales
	private void calcularTotales() {
		int stocktotal = 0;
		double valorstocktotal = 0.0;
		int elementos = dlm.size();
		if (elementos > 0) {
			// si hay elementos en la lista
			Coche c;
			int posicion = 0;
			while (posicion < dlm.size()) {
				c = dlm.getElementAt(posicion);
				stocktotal = stocktotal + c.getStock();
				valorstocktotal = valorstocktotal + (c.getPrecio() * c.getStock());
				posicion++;
			}
		}
		// actualizo las etiquetas
		this.lblValorStockTotal.setText(""+stocktotal);
		this.lblValorTotal.setText(""+valorstocktotal);
	}
}
