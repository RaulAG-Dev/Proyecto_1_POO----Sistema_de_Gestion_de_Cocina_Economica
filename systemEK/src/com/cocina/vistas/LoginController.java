// Asegúrate de que el paquete sea el correcto (donde tienes tus archivos)
package com.cocina.vistas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    // 1. Conexiones:
    // La anotación @FXML conecta estas variables con los fx:id del FXML

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    // 2. Manejador de Eventos:
    // Este método se llama cuando presionas el botón (por el onAction="#handleLoginAction")

    @FXML
    private void handleLoginAction(ActionEvent event) {

        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println("Intento de login con:");
        System.out.println("Usuario: " + username);
        System.out.println("Contraseña: " + password); // (Solo para depurar, no hagas esto en producción)

//aqui va la logica de acceso
        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("¡Acceso CONCEDIDO!");
            // (Aquí pondrías el código para abrir la ventana principal)
        } else {
            System.out.println("Acceso DENEGADO.");
            // (Aquí podrías mostrar una alerta de error al usuario)
        }
    }
}