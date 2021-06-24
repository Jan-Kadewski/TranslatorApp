import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class View {
    Model model;
    Stage stage;
    Scene scene;
    Group root;
    MenuItem fromLang1;
    MenuItem fromLang2;
    MenuItem fromLang3;
    MenuItem toLang1;
    MenuItem toLang2;
    MenuItem toLang3;
    SplitMenuButton splitMenuButtonFromLang;
    SplitMenuButton splitMenuButtonToLang;
    ImageView arrowImageView;
    TextArea currentTextArea;
    TextArea translatedTextArea;
    Button translateButton;
    List<MenuItem> listOfMenuItem;


    public View() {
        model = new Model();
        initApp();
        createListToChooseLanguageFrom("en", "de", "pl", "en");
        createListToChooseLanguageToTranslate("pl", "pl");
        addArrowsToChangeLanguage();
        createTextAreaForCurrentText();
        createTextAreaForTranslatedText();
        createTranslateButton();
    }

    public void initApp() {
        stage = new Stage();
        stage.setTitle("Translator");
        stage.setResizable(false);
        root = new Group();
        scene = new Scene(root, 700, 800);
        scene.getStylesheets().add("Assets/images/style.css");
        stage.setScene(scene);
        stage.show();
        scene.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.web("#0093E9")), new Stop(1, Color.web("#80D0C7"))));
    }

    public void createListToChooseLanguageFrom(String lang1, String lang2, String lang3, String defaultText) {
        splitMenuButtonFromLang = new SplitMenuButton();
        fromLang1 = new MenuItem(lang1);
        fromLang2 = new MenuItem(lang2);
        fromLang3 = new MenuItem(lang3);
        splitMenuButtonFromLang.getItems().addAll(fromLang1, fromLang2, fromLang3);
        splitMenuButtonFromLang.setText(defaultText);
        root.getChildren().add(splitMenuButtonFromLang);
    }

    public void createListToChooseLanguageToTranslate(String lang1, String defaultText) {
        splitMenuButtonToLang = new SplitMenuButton();
        splitMenuButtonToLang.setId("listToLang");
        toLang1 = new MenuItem(lang1);
        splitMenuButtonToLang.getItems().addAll(toLang1);
        splitMenuButtonToLang.setText(defaultText);
        root.getChildren().add(splitMenuButtonToLang);
    }

    public void addArrowsToChangeLanguage() {
        Image arrowImage = new Image("Assets/images/arrow2.png");
        arrowImageView = new ImageView(arrowImage);
        root.getChildren().add(arrowImageView);
    }

    public void createTextAreaForCurrentText() {
        currentTextArea = new TextArea();
        currentTextArea.setId("currentTextArea");
        root.getChildren().addAll(currentTextArea);
    }

    public void createTextAreaForTranslatedText() {
        translatedTextArea = new TextArea();
        translatedTextArea.setId("translatedTextArea");
        root.getChildren().addAll(translatedTextArea);
    }

    public void createTranslateButton() {
        translateButton = new Button("TRANSLATE");
        root.getChildren().add(translateButton);
    }

}
