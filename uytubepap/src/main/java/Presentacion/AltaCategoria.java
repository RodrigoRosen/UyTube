package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jboss.jandex.Main;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import interfaces.IControlador;

public class AltaCategoria extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private IControlador ctrl;
	private JLabel lblInfo;
	private JLabel lblNombre;
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Principal window = new Principal();
//					window.AltaCategoria.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


	/**
	 * Create the frame.
	 */
	public AltaCategoria(IControlador cr) {
		ctrl = cr;
		setBounds(100, 100, 362, 190);
		setClosable(true);
		setTitle("Alta Categoria");
		getContentPane().setLayout(null);
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(67, 29, 70, 15);
			getContentPane().add(lblNombre);
		}
		{
			lblInfo = new JLabel();
			lblInfo.setBounds(67, 55, 200, 15);
			getContentPane().add(lblInfo);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(199, 27, 114, 19);
			getContentPane().add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//ctrl.altaCategoria(txtNombre.getText());
					
					if(ctrl.altaCategoria(txtNombre.getText())) {
						lblInfo.setText("Categoria agregada!");
						lblInfo.setVisible(true);
					}
					else {
						lblInfo.setText("Categoria existente!");
						lblInfo.setVisible(true);
					}
				}
			});
			btnAceptar.setBounds(32, 82, 117, 25);
			getContentPane().add(btnAceptar);
		}
		{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					ctrl.finCasoUso();
				}
			});
			btnCancelar.setBounds(199, 82, 117, 25);
			getContentPane().add(btnCancelar);
		}
		

		

	}
}
