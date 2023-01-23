package com.project.controllers;

import javax.swing.JOptionPane;

import com.project.databases.DBCliente;
import com.project.models.Cliente;
import com.project.models.Gestor;
import com.project.utils.UICliente;

public class ClienteUpdateController {

	public static void switchUpdateCliente(Cliente comprobacionCliente) {
		DBCliente dbCliente = new DBCliente();
		String opcionAct;
		try {
			opcionAct = JOptionPane.showInputDialog(null, "Seleccione dato que quiere actualizar: ", "ACTUALIZACIÓN DEL CLIENTE "+comprobacionCliente.getId_cliente(),
					JOptionPane.PLAIN_MESSAGE, null,
					new Object[] {"ID del gestor", "Nombre", "Apellido(s)", "DNI", "Usuario", "Contraseña", "Correo", "Saldo"}, null).toString();
		} catch (Exception e) {
			opcionAct = "Volver atrás";
		}

		switch (opcionAct) {
		case "ID del gestor":
			boolean existeId_gestor;
			Gestor comprobacionId_gestor;
			do{
				comprobacionId_gestor = UICliente.comprobarId_gestorUpdate(comprobacionCliente);
				existeId_gestor = dbCliente.comprobarId_gestorUpdate(comprobacionId_gestor,comprobacionCliente);
			}while(existeId_gestor == false);
			dbCliente.updateId_gestorCliente(UICliente.updateId_gestorCliente(comprobacionCliente, comprobacionId_gestor));
			JOptionPane.showMessageDialog(null, "ID del gestor actualizado correctamente");
			switchUpdateCliente(comprobacionCliente);
			break;
		case "Nombre":
			dbCliente.updateNombreCliente(UICliente.updateNombreCliente(comprobacionCliente));
			JOptionPane.showMessageDialog(null, "Nombre actualizado correctamente");
			switchUpdateCliente(comprobacionCliente);
			break;
		case "Apellido(s)":
			dbCliente.updateApellidoCliente(UICliente.updateApellidoCliente(comprobacionCliente));
			JOptionPane.showMessageDialog(null, "Apellido(s) actualizado(s) correctamente");
			switchUpdateCliente(comprobacionCliente);
			break;
		case "DNI":
			dbCliente.updateDniCliente(UICliente.updateDniCliente(comprobacionCliente));
			JOptionPane.showMessageDialog(null, "DNI actualizado correctamente");
			switchUpdateCliente(comprobacionCliente);
			break;
		case "Usuario":
			dbCliente.updateUsuarioCliente(UICliente.updateUsuarioCliente(comprobacionCliente));
			JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
			switchUpdateCliente(comprobacionCliente);
			break;
		case "Contraseña":
			dbCliente.updatePasswordCliente(UICliente.updateUsuarioCliente(comprobacionCliente));
			JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente");
			switchUpdateCliente(comprobacionCliente);
			break;
		case "Correo":
			dbCliente.updateCorreoCliente(UICliente.updateCorreoCliente(comprobacionCliente));
			JOptionPane.showMessageDialog(null, "Correo actualizado correctamente");
			switchUpdateCliente(comprobacionCliente);
			break;
		case "Saldo":
			dbCliente.updateSaldoCliente(UICliente.updateSaldoCliente(comprobacionCliente));
			JOptionPane.showMessageDialog(null, "Saldo actualizado correctamente");
			switchUpdateCliente(comprobacionCliente);
			break;
		case "Volver atrás":
			break;
		}
	}
}