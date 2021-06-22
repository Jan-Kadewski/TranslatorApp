import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;

public class AppView {
    AppModel appModel;
    public AppView(){
        appModel = new AppModel();
        init();
    }

    public void init(){
        appModel.stage = new Stage();
        appModel.stage.setTitle("Translator");
        appModel.stage.setResizable(false);
        appModel.root = new Group();
        appModel.scene =new Scene(appModel.root,500,800);
        appModel.stage.setScene(appModel.scene);
        appModel.stage.show();
    }
}
