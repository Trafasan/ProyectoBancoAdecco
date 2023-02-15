package com.project.controllers;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.project.databases.DBCliente;
import com.project.models.Cliente;
import com.project.utils.UICliente;

public class ClienteUpdateController {

	public static void switchUpdateCliente(Cliente updateCliente) {
		DBCliente dbCliente = new DBCliente();
		int id = updateCliente.getId_cliente();
		String update;
		try {
			update = JOptionPane.showInputDialog(null, "Seleccione el dato que quiere actualizar: ", "ACTUALIZACIÓN DEL CLIENTE "+id,
					JOptionPane.PLAIN_MESSAGE, null,
					new Object[] {"ID del gestor", "Nombre", "Apellido(s)", "DNI", "Usuario", "Contraseña", "Correo", "Saldo"}, null).toString();
		} catch (NullPointerException e) {
			update = "Volver atrás";
		}

		switch (update) {
		case "ID del gestor" -> {
			int id_gestor = UICliente.setId_gestorUpdate(updateCliente);
			if (UICliente.existeIdGestorUpdate(updateCliente, dbCliente.getGestores(), id_gestor)) {
				dbCliente.updateId_gestorCliente(UICliente.updateId_gestorCliente(updateCliente, id_gestor));
				JOptionPane.showMessageDialog(null, "ID del gestor actualizada correctamente");
			}
			else JOptionPane.showMessageDialog(null, "No existe ningún gestor con ese ID\nSe le redigirá al menú Cliente", "ERROR", 0, new ImageIcon("src/images/preocupado.png"));
		} // Me he quedado por aquí en mi revisión
		case "Nombre" -> dbCliente.updateNombreCliente(UICliente.updateNombreCliente(updateCliente));
		case "Apellido(s)" -> dbCliente.updateApellidoCliente(UICliente.updateApellidoCliente(updateCliente));
		case "DNI" -> dbCliente.updateDniCliente(UICliente.updateDniCliente(updateCliente));
		case "Usuario" -> dbCliente.updateUsuarioCliente(UICliente.updateUsuarioCliente(updateCliente));
		case "Contraseña" -> dbCliente.updatePasswordCliente(UICliente.updateUsuarioCliente(updateCliente));
		case "Correo" -> dbCliente.updateCorreoCliente(UICliente.updateCorreoCliente(updateCliente));
		case "Saldo" -> dbCliente.updateSaldoCliente(UICliente.updateSaldoCliente(updateCliente));
		}
		if (!update.equals("ID del gestor") && !update.equals("Contraseña") && !update.equals("Volver atrás")) JOptionPane.showMessageDialog(null, update+" actualizado"+((update.equals("Apellido(s)")) ? "(s)": "")+" correctamente");
		if (!update.equals("Volver atrás")) switchUpdateCliente(updateCliente);
	}
}