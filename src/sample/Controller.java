package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.objetos.Usuario;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    TextField txt_usuario;
    @FXML
    PasswordField txt_contra;

    conexion conecta= new conexion();
        List<Usuario> usuarios;
    public Object  valores[] = new Object[3];

    public void iniciar(ActionEvent event) {

        System.out.println(txt_usuario.getText()+ "\n"+txt_contra.getText());

      //  escenas es = new escenas(txt_contra.getScene());
       ////   es.addScreen("principal", FXMLLoader.load(getClass().getResource("principal.fxml")));
        //} catch (IOException e) {
         //   e.printStackTrace();
        //}
       // es.activate("principal");

        ResultSet res= conecta.mostrarSql(conecta.consultaLogin(txt_usuario.getText()));
            try {

                while (res.next()) {

                    for (int i = 0; i <= 3; i++) {

                        valores[i] = res.getObject(i).toString();

                    }

                }
            } catch (SQLException e){

            }
            Usuario usuario= new Usuario(Integer.parseInt(valores[0].toString()),
                    valores[1].toString(),
                    valores[2].toString(),
                    valores[3].toString());

        System.out.printf(usuario.getEmail()+ "   "+ usuario.getNombre());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
