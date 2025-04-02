package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class VentanaAgregarContacto extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNickname;
	private JPanel panelIP;
	private JLabel ipLabel;
	private JTextField textFieldIP;
	private JPanel panelPuerto;
	private JLabel puertoLabel;
	private JTextField textFieldPuerto;
	private JPanel panel_3;
	private JButton btnAgregarButton;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public VentanaAgregarContacto() {
		setTitle("Agregar contacto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 2, 0, 0));
		
		JPanel panelNickname = new JPanel();
		contentPane.add(panelNickname);
		panelNickname.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel nicknameLabel = new JLabel("Nickname");
		panelNickname.add(nicknameLabel);
		
		this.panel = new JPanel();
		panelNickname.add(this.panel);
		
		textFieldNickname = new JTextField();
		this.textFieldNickname.addKeyListener(this);
		this.panel.add(this.textFieldNickname);
		textFieldNickname.setColumns(10);
		
		panelIP = new JPanel();
		contentPane.add(panelIP);
		this.panelIP.setLayout(new GridLayout(0, 2, 0, 0));
		
		ipLabel = new JLabel("Dirección IP");
		panelIP.add(ipLabel);
		
		this.panel_1 = new JPanel();
		this.panelIP.add(this.panel_1);
		
		textFieldIP = new JTextField();
		this.textFieldIP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == '.')) { // Si no es un número, se ignora el evento
                    e.consume();
                }
            }
			public void keyReleased(KeyEvent e) {
				btnAgregarButton.setEnabled(!(textFieldIP.getText().isEmpty()));
			}
        });
		this.panel_1.add(this.textFieldIP);
		textFieldIP.setColumns(10);
		
		panelPuerto = new JPanel();
		contentPane.add(panelPuerto);
		this.panelPuerto.setLayout(new GridLayout(0, 2, 0, 0));
		
		puertoLabel = new JLabel("Puerto");
		panelPuerto.add(puertoLabel);
		
		this.panel_2 = new JPanel();
		this.panelPuerto.add(this.panel_2);
		
		textFieldPuerto = new JTextField();
		this.textFieldPuerto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) { // Si no es un número, se ignora el evento
                    e.consume();
                }
            }
			public void keyReleased(KeyEvent e) {
				btnAgregarButton.setEnabled(!(textFieldIP.getText().isEmpty()));
			}
        });
		this.panel_2.add(this.textFieldPuerto);
		textFieldPuerto.setColumns(10);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		btnAgregarButton = new JButton("Agregar");
		this.btnAgregarButton.setToolTipText("Agregar");
		this.btnAgregarButton.addActionListener(this);
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
