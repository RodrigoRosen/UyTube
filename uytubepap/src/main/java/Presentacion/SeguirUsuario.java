package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;

import interfaces.IControlador;
import logica.Controlador;
import logica.Handler;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Choice;

public class SeguirUsuario extends JInternalFrame {
	private JLabel lblSeguidor;
	private Choice cmbSeguidor;
	private JLabel lblSeguido;
	private Choice cmbSeguido;
	private Button btnAceptar;
	private Button btnCAncelar;
	private IControlador ctrl;

	public SeguirUsuario(IControlador ctrl) {
		setClosable(true);
		setBounds(100, 100, 530, 430);
		setTitle("Seguir Usuario");
		getContentPane().setLayout(null);
		
		lblSeguidor = new JLabel("Seguidor:");
		lblSeguidor.setBounds(93, 68, 69, 24);
		getContentPane().add(lblSeguidor);
		

		cmbSeguidor = new Choice();
		cmbSeguidor.setBounds(174, 68, 193, 24);
		ArrayList<String> users = Handler.listarUsuarios();
		for(String s: users) {
			cmbSeguidor.add(s);
		}
		getContentPane().add(cmbSeguidor);
		
		lblSeguido = new JLabel("Seguido:");
		lblSeguido.setBounds(93, 121, 69, 24);
		getContentPane().add(lblSeguido);
		
		cmbSeguido = new Choice();
		cmbSeguido.setBounds(174, 121, 193, 24);
		getContentPane().add(cmbSeguido);
		
		btnAceptar = new Button("Aceptar");
		btnAceptar.setBounds(93, 205, 96, 25);
		btnAceptar.setEnabled(false);
		getContentPane().add(btnAceptar);
		
		btnCAncelar = new Button("Cancelar");
		btnCAncelar.setBounds(271, 205, 96, 25);
		btnCAncelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(btnCAncelar);		
		

	}
}