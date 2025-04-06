package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import dto.UsuarioDTO;
import modeloNegocio.Usuario;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame implements IVista, ActionListener, KeyListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMensaje;
	private Controlador controlador;
	private JButton botonAgregarContacto;
	private JButton botonNuevaConversacion;
	private JButton botonEnviar;
	private JList<UsuarioDTO> listaConversacionesActivas;
	private JTextArea textAreaChat;
	private JLabel textFieldNameContacto;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) 
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Controlador controlador) {
		this.controlador=controlador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		this.botonAgregarContacto = new JButton("Agregar contacto");
		this.botonAgregarContacto.setActionCommand("AGREGAR CONTACTO");
		panel_1.add(this.botonAgregarContacto);
		
		this.botonNuevaConversacion = new JButton("Nueva conversacion");
		this.botonNuevaConversacion.setActionCommand("NUEVA CONVERSACIÓN");
		panel_1.add(this.botonNuevaConversacion);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, BorderLayout.CENTER);
		
		listaConversacionesActivas = new JList();
		listaConversacionesActivas.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(listaConversacionesActivas);
		this.listaConversacionesActivas.addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		        UsuarioDTO seleccionado = listaConversacionesActivas.getSelectedValue();
		        if (seleccionado != null) {
		            controlador.contactoSeleccionadoDesdeLista(seleccionado);
		        }
		    }
		});

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		textFieldNameContacto = new JLabel();
		textFieldNameContacto.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(textFieldNameContacto, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(1, 2, 0, 0));
		
		textFieldMensaje = new JTextField();
		this.textFieldMensaje.addKeyListener(this);
		this.textFieldMensaje.setToolTipText("Mensaje");
		panel_3.add(textFieldMensaje);
		textFieldMensaje.setColumns(10);
		
		this.botonEnviar = new JButton("Enviar");
		this.botonEnviar.setEnabled(false);
		this.botonEnviar.setActionCommand("ENVIAR");
		panel_3.add(this.botonEnviar);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		textAreaChat = new JTextArea();
		textAreaChat.setWrapStyleWord(true);
		textAreaChat.setLineWrap(true);
		textAreaChat.setEditable(false);
		textAreaChat.setText("");
		scrollPane.setViewportView(textAreaChat);
	}
	@Override
	public void setActionListener(ActionListener controlador) {
		// TODO Auto-generated method stub
		this.botonAgregarContacto.addActionListener(controlador);
		this.botonNuevaConversacion.addActionListener(controlador);
		this.botonEnviar.addActionListener(controlador);
	}
	//Este metodo actualiza la lista de conversaciones de la izquierda
	//de la ventana principal
	public void actualizarListaChats(List<UsuarioDTO> contactos) {
	    DefaultListModel<UsuarioDTO> modelo = new DefaultListModel<>();
	    for (UsuarioDTO u : contactos) {
	        modelo.addElement(u); 
	    }
	    this.listaConversacionesActivas.setModel(modelo);
	    
	}
	public UsuarioDTO getContactoConversacionActual() {
		return this.listaConversacionesActivas.getSelectedValue();
	}
	public void setTextFieldNameContacto(String name) {
		this.textFieldNameContacto.setText(name);
	}
	public void TitulonameUsuario(String nombre) {
		this.setTitle(nombre);
	}
	public void setDejarSeleccionadoContactoNuevaConversacion(UsuarioDTO contacto) {
		this.listaConversacionesActivas.setSelectedValue(contacto, true);
	}
	public void agregarMensajeAchat(String contenido, LocalDateTime fechayhora, String emisor ) {
		this.textAreaChat.append(String.format("%s (%s): %s\n", emisor, fechayhora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), contenido));	
	}
	public String getTextFieldMensaje() {
		return this.textFieldMensaje.getText();
	}
	public void actionPerformed(ActionEvent e) {
		
	}
	public void limpiarChat() {
	    this.textAreaChat.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		this.botonEnviar.setEnabled(!(textFieldMensaje.getText().isEmpty()));
	}
}
