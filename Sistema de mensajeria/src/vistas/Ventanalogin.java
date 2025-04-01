package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Ventanalogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPuerto;
	private JButton botonRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventanalogin frame = new Ventanalogin();
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
	public Ventanalogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("NickName:");
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(25);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2);
		
		txtUsuario = new JTextField();
		panel_2.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Puerto:");
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setVgap(25);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_3);
		
		txtPuerto = new JPasswordField();
		txtPuerto.setColumns(10);
		panel_3.add(txtPuerto);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton botonRegistrar = new JButton("Registrar");
		panel_1.add(botonRegistrar);
		// Agregar el ActionListener para el botón
        botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = getUsuario();
                String puerto = getPuerto();
                System.out.println("Usuario: " + usuario + ", Contraseña: " + puerto);
            }
        });
	}
	

	//Lo de abajo posiblemente se borra
	public String getUsuario() {
		return txtUsuario.getText();
	}

	public String getPuerto() {
		return new String(txtPuerto.getPassword()); // Convertir password a String
	}
	
}
