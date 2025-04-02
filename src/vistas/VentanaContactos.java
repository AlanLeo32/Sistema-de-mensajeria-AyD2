package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

public class VentanaContactos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelBuscar;
	private JTextField textField;
	private JButton btnBuscar;
	private JPanel panelIniciar;
	private JButton btnIniciarConversacion;
	private JScrollPane scrollPane;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaContactos frame = new VentanaContactos();
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
	public VentanaContactos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelBuscar = new JPanel();
		this.contentPane.add(this.panelBuscar, BorderLayout.NORTH);
		this.panelBuscar.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.textField = new JTextField();
		this.panelBuscar.add(this.textField);
		this.textField.setColumns(10);
		
		this.btnBuscar = new JButton("Buscar");
		this.panelBuscar.add(this.btnBuscar);
		
		this.panelIniciar = new JPanel();
		this.contentPane.add(this.panelIniciar, BorderLayout.SOUTH);
		
		this.btnIniciarConversacion = new JButton("Iniciar conversacion");
		this.btnIniciarConversacion.addActionListener(this);
		this.btnIniciarConversacion.setToolTipText("Iniciar conversacion");
		this.panelIniciar.add(this.btnIniciarConversacion);
		
		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane, BorderLayout.CENTER);
		
		this.list = new JList();
		this.scrollPane.setViewportView(this.list);
	}

	public void actionPerformed(ActionEvent e) {
	}
}
