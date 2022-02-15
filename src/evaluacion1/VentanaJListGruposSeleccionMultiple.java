package evaluacion1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.JButton;

public class VentanaJListGruposSeleccionMultiple extends JFrame implements ActionListener{

	private static final long serialVersionUID = -7432671980495821429L;

	// defino los componentes
	private JLabel lblTexto;
	
	private JPanel contentPane;
	private JList<String> lstGrupos;
	private DefaultListModel<String> dlm;
	private JList<String> lstGruposCopia;
	private DefaultListModel<String> dlmCopia;
	private JPanel panelBotones;
	private JButton btnCopiarIzquierda;
	private JButton btnCopiarDerecha;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListGruposSeleccionMultiple frame = new VentanaJListGruposSeleccionMultiple();
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
	public VentanaJListGruposSeleccionMultiple() {
		setTitle("VentanaJListGruposSeleccionMultiple");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblTexto = new JLabel("Selecciona Elementos de una Lista y los Copia a la otra");
		lblTexto.setForeground(new Color(0, 0, 128));
		lblTexto.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTexto, BorderLayout.NORTH);
		
		// Modelo de datos de la lista de Opciones
		dlm = new DefaultListModel<String>();
		dlm.addElement("1AS3");
		dlm.addElement("2AS3");
		dlm.addElement("1DW3");
		dlm.addElement("2DW3");
		// lista de Opciones
		lstGrupos = new JList<String>();
		// asocio el DefaultListModel a la lista de Opciones
		lstGrupos.setModel(dlm);
		contentPane.add(lstGrupos, BorderLayout.WEST);
		
		// lista Copia
		// Modelo de datos de la lista Copia
		dlmCopia = new DefaultListModel<String>();
		lstGruposCopia = new JList<String>();
		lstGruposCopia.setModel(dlmCopia);
		contentPane.add(lstGruposCopia, BorderLayout.EAST);
		
		panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		btnCopiarIzquierda = new JButton("Copiar A Izquierda");
		btnCopiarIzquierda.addActionListener(this);
		panelBotones.add(btnCopiarIzquierda);
		
		btnCopiarDerecha = new JButton("Copiar A Derecha");
		btnCopiarDerecha.addActionListener(this);
		panelBotones.add(btnCopiarDerecha);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// obtengo sobre que componente se ha realizado la accion
		Object o = ae.getSource();
		if (o == btnCopiarIzquierda){
			// si se ha pulsado btnCopiarIzquierda
			// si quiero copiar de la lista derecha a la izquierda
			int[]indices = this.lstGruposCopia.getSelectedIndices();
			int numeroOpciones = indices.length;
			String opcion = null;
			for(int posicion=0;posicion<numeroOpciones;posicion++){
				opcion = dlmCopia.getElementAt(indices[posicion]);
				this.dlm.addElement(opcion);
			}
		}
		else if(o == btnCopiarDerecha){
			// si se ha pulsado btnCopiarDerecha
			// si quiero copiar de la lista izquierda a la derecha
			int[]indices = this.lstGrupos.getSelectedIndices();
			int numeroOpciones = indices.length;
			String opcion = null;
			for(int posicion=0;posicion<numeroOpciones;posicion++){
				opcion = dlm.getElementAt(indices[posicion]);
				this.dlmCopia.addElement(opcion);
			}
		}
	}

}
