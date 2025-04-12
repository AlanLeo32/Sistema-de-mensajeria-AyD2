package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.*;
import util.Util;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class Ventanalogin extends JFrame implements IVista,ActionListener, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton botonRegistrar;
	private JTextField textFieldPuerto;
	private Controlador controlador;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Ventanalogin(Controlador controlador) {
		this.controlador=controlador;
		setTitle("Sistema de mensajería");
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
		this.txtUsuario.addKeyListener(this);
		
		JLabel lblNewLabel = new JLabel("Puerto(1023<P<65536):");
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setVgap(25);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_3);
		
		this.textFieldPuerto = new JTextField();
		panel_3.add(this.textFieldPuerto);
		this.textFieldPuerto.setColumns(10);
		this.textFieldPuerto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) { // Si no es un número, se ignora el evento
                    e.consume();
                }
            }
			public void keyReleased(KeyEvent e) {
				botonRegistrar.setEnabled(!(getPuerto().isEmpty()));
			}
        });
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.botonRegistrar = new JButton("Registrar");
		this.botonRegistrar.setActionCommand(Util.CTEREGISTRAR);
		this.botonRegistrar.setToolTipText("Registrar");
		this.botonRegistrar.setEnabled(false);
		panel_1.add(this.botonRegistrar);
	}
	
    public void mostrarPuertoEnUso(String error) {
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}
	//Lo de abajo posiblemente se borra
	public String getUsuario() {
		return txtUsuario.getText();
	}

	public String getPuerto() {
		return this.textFieldPuerto.getText();
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
		this.botonRegistrar.setEnabled(!(this.getUsuario().isEmpty() || this.getPuerto().isEmpty()) && (Integer.parseInt(this.getPuerto())>1023) &&(Integer.parseInt(this.getPuerto())<65536));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
 	}

	@Override
	public void setActionListener(ActionListener controlador) {
		// TODO Auto-generated method stub
		this.botonRegistrar.addActionListener(controlador);
	}
	
}
