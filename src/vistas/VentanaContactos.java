package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import dto.UsuarioDTO;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

public class VentanaContactos extends JFrame implements IVista,ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelIniciar;
	private JButton btnIniciarConversacion;
	private JScrollPane scrollPane;
	private JList<UsuarioDTO> list;
	private Controlador controlador;
	/**
	 * Launch the application.
	 */
	/*
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
*/
	/**
	 * Create the frame.
	 */
	public VentanaContactos(Controlador controlador) {
		this.controlador=controlador;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelIniciar = new JPanel();
		this.contentPane.add(this.panelIniciar, BorderLayout.SOUTH);
		
		this.btnIniciarConversacion = new JButton("Iniciar conversacion");
		this.btnIniciarConversacion.setActionCommand("INICIAR CONVERSACIÓN");
		this.btnIniciarConversacion.setToolTipText("Iniciar conversacion");
		this.panelIniciar.add(this.btnIniciarConversacion);
		
		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane, BorderLayout.CENTER);
		
		DefaultListModel<UsuarioDTO> modelo = new DefaultListModel<>();
		modelo.clear();
		
		for (UsuarioDTO c : controlador.getAgenda()) {
		    modelo.addElement(c);
		}

		this.list  = new JList<>(modelo);
		this.scrollPane.setViewportView(this.list);
	}
	public int getPuerto() {
		
		return this.list.getSelectedValue().getPuerto();
	}
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void setActionListener(ActionListener controlador) {
		// TODO Auto-generated method stub
		this.btnIniciarConversacion.addActionListener(controlador);
	}
}
