package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
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
				} catch (Exception e) {
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
		setTitle("Messenger");
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
		this.botonAgregarContacto.addActionListener(this);
		panel_1.add(this.botonAgregarContacto);
		
		this.botonNuevaConversacion = new JButton("Nueva conversacion");
		this.botonNuevaConversacion.addActionListener(this);
		this.botonNuevaConversacion.setActionCommand("NUEVA CONVERSACIÓN");
		panel_1.add(this.botonNuevaConversacion);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, BorderLayout.CENTER);
		
		JList listaContactos = new JList();
		listaContactos.setModel(new AbstractListModel() {
			String[] values = new String[] {"dadadda", "adadad", "222", "5353", "1", "423423", "1414", "1414", "222", "555", "11212", "1", "31232132", "11", "42424", "52525", "111", "11", "4", "11"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(listaContactos);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel textFieldNameContacto = new JLabel("NombreContacto");
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
		this.botonEnviar.addActionListener(this);
		this.botonEnviar.setActionCommand("ENVIAR");
		panel_3.add(this.botonEnviar);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textAreaChat = new JTextArea();
		textAreaChat.setWrapStyleWord(true);
		textAreaChat.setLineWrap(true);
		textAreaChat.setEditable(false);
		textAreaChat.setText("asfasfafsafasfasf\r\nafafafafafaf\r\nafafafafaf\r\nwwwwffw\r\n🧊");
		scrollPane.setViewportView(textAreaChat);
	}
	@Override
	public void setActionListener(ActionListener controlador) {
		// TODO Auto-generated method stub
		this.botonAgregarContacto.addActionListener(controlador);
		this.botonNuevaConversacion.addActionListener(controlador);
		this.botonEnviar.addActionListener(controlador);
	}

	public void actionPerformed(ActionEvent e) {
		
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
