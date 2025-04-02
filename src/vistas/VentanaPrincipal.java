package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
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

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMensaje;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
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
		
		JButton botonAgregarContacto = new JButton("Agregar contacto");
		panel_1.add(botonAgregarContacto);
		
		JButton botonNuevaConversacion = new JButton("Nueva conversacion");
		panel_1.add(botonNuevaConversacion);
		
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
		textFieldMensaje.setText("mensaje");
		panel_3.add(textFieldMensaje);
		textFieldMensaje.setColumns(10);
		
		JButton botonEnviar = new JButton("Enviar");
		panel_3.add(botonEnviar);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textAreaChat = new JTextArea();
		textAreaChat.setEditable(false);
		textAreaChat.setText("asfasfafsafasfasf\r\nafafafafafaf\r\nafafafafaf\r\nwwwwffw\r\n");
		scrollPane.setViewportView(textAreaChat);
	}

}
