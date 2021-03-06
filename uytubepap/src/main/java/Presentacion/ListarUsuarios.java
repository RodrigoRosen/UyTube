package Presentacion;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import interfaces.IControlador;

@SuppressWarnings("serial")
public class ListarUsuarios extends JInternalFrame {
	private IControlador controller;
	private JTable table;
	private DefaultTableModel dtm;
	private DefaultTableModel newdt;

	public ListarUsuarios(IControlador ctrl) {
		controller = ctrl;
		setClosable(true);
		setTitle("Listar Usuarios");
		getContentPane().setLayout(null);

		table = new JTable();
		String[] rows = {"User Nickname"};
		String[][] cols = {};
		dtm = new DefaultTableModel(cols, rows);
		table.setModel(dtm);
		JScrollPane sp = new JScrollPane();
		getContentPane().add(sp);
		sp.setViewportView(table);
		setVisible(true);
		setLayout(new FlowLayout());

	}
	
	public void addUsuarios() {
		ArrayList<String> users = controller.listarUsuarios();
		String[] rows = {"User Nickname"};
		String[][] cols = {};
		newdt = new DefaultTableModel(cols, rows);
		for (String s : users) {
			Object[] data = {s};
			newdt.addRow(data);
		}
		table.setModel(newdt);
	}
}
