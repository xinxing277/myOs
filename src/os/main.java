package os;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
       // URL loca=getClass().getResource("user.fxml");

        System.out.println(getClass().getResource("user.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("user.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("多道批处理系统两级调度的模拟");
//        primaryStage.setHeight(480);
//        primaryStage.setWidth(640);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
