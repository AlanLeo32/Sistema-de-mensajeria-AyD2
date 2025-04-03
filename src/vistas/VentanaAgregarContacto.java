package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class VentanaAgregarContacto extends JFrame implements IVista,ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelIP;
	private JLabel ipLabel;
	private JPanel panelPuerto;
	private JLabel puertoLabel;
	private JPanel panel_3;
	private JButton btnAgregarButton;
	private JTextField textFieldPuerto;
	private JTextField textFieldIP;
	private JTextField textFieldNickname;
	private Controlador controlador;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarContacto frame = new VentanaAgregarContacto();
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
	public VentanaAgregarContacto(Controlador controlador) {
		this.controlador=controlador;
		setTitle("Agregar contacto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 262, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 2, 0, 0));
		
		JPanel panelNickname = new JPanel();
		contentPane.add(panelNickname);
		panelNickname.setLayout(null);
		
		JLabel nicknameLabel = new JLabel("Nickname");
		nicknameLabel.setBounds(0, 0, 127, 62);
		panelNickname.add(nicknameLabel);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setBounds(100, 21, 86, 20);
		panelNickname.add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		panelIP = new JPanel();
		contentPane.add(panelIP);
		panelIP.setLayout(null);
		
		ipLabel = new JLabel("Dirección IP");
		ipLabel.setBounds(0, 0, 127, 62);
		panelIP.add(ipLabel);
		
		textFieldIP = new JTextField();
		textFieldIP.setBounds(100, 21, 86, 20);
		panelIP.add(textFieldIP);
		textFieldIP.setColumns(10);
		
		panelPuerto = new JPanel();
		contentPane.add(panelPuerto);
		panelPuerto.setLayout(null);
		
		puertoLabel = new JLabel("Puerto");
		puertoLabel.setBounds(0, 0, 254, 62);
		panelPuerto.add(puertoLabel);
		
		textFieldPuerto = new JTextField();
		textFieldPuerto.setBounds(100, 21, 86, 20);
		panelPuerto.add(textFieldPuerto);
		textFieldPuerto.setColumns(10);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		btnAgregarButton = new JButton("Agregar");
		btnAgregarButton.setBounds(75, 24, 80, 23);
		this.btnAgregarButton.setToolTipText("Agregar");
		this.btnAgregarButton.addActionListener(this);
		panel_3.setLayout(null);
		this.btnAgregarButton.setEnabled(false);
		panel_3.add(btnAgregarButton);
	}

	public void actionPerformed(ActionEvent e) {
		//AGREGAR CARTEL O ALGO POR EL ESTILO
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
		this.btnAgregarButton.setEnabled(!(this.textFieldNickname.getText().isEmpty() || this.textFieldIP.getText().isEmpty() || this.textFieldPuerto.getText().isEmpty()));
	}
}
