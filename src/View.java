import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

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
    Label labelForCurrentText;
    Label labelForTranslatedText;
    Button translateButton;
    Font fontForButtons;


    public View() {
        model = new Model();
        initApp();
        createListToChooseLanguageFrom("de", "en", "pl", "en", 0);
        createListToChooseLanguageToTranslate("de", "en", "pl", "pl", 420);
        addArrowsToChangeLanguage(320, 8, .5);
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
        stage.setScene(scene);
        stage.show();
        scene.setFill(Color.LIGHTGRAY);
        fontForButtons = Font.font("Courier New", FontWeight.BOLD, 20);
    }

    public void createListToChooseLanguageFrom(String lang1, String lang2, String lang3, String defaultText, int translateX) {
        splitMenuButtonFromLang = new SplitMenuButton();
        splitMenuButtonFromLang.setPrefSize(280,40);
        fromLang1 = new MenuItem(lang1);
        fromLang2 = new MenuItem(lang2);
        fromLang3 = new MenuItem(lang3);
        splitMenuButtonFromLang.getItems().addAll(fromLang1, fromLang2, fromLang3);
        splitMenuButtonFromLang.setText(defaultText);
        splitMenuButtonFromLang.setTranslateX(translateX);
        root.getChildren().add(splitMenuButtonFromLang);
        splitMenuButtonFromLang.setFont(fontForButtons);
    }

    public void createListToChooseLanguageToTranslate(String lang1, String lang2, String lang3, String defaultText, int translateX) {
        splitMenuButtonToLang = new SplitMenuButton();
        splitMenuButtonToLang.setPrefSize(280,40);
        toLang1 = new MenuItem(lang1);
        toLang2 = new MenuItem(lang2);
        toLang3 = new MenuItem(lang3);
        splitMenuButtonToLang.getItems().addAll(toLang1, toLang2, toLang3);
        splitMenuButtonToLang.setText(defaultText);
        splitMenuButtonToLang.setTranslateX(translateX);
        root.getChildren().add(splitMenuButtonToLang);
        splitMenuButtonToLang.setFont(fontForButtons);
    }

    public void addArrowsToChangeLanguage(int translateX, int translateY, double opacity) {
        Image arrowImage = new Image("Assets/images/arrow2.png");
        arrowImageView = new ImageView(arrowImage);
        arrowImageView.setX(translateX);
        arrowImageView.setY(translateY);
        arrowImageView.setOpacity(opacity);
        root.getChildren().add(arrowImageView);
    }


    public void createTextAreaForCurrentText(){
        currentTextArea = new TextArea();
        currentTextArea.setTranslateY(200);
        currentTextArea.setTranslateX(65);
        root.getChildren().addAll(currentTextArea);
    }

    public void createTextAreaForTranslatedText(){
        translatedTextArea = new TextArea();
        translatedTextArea.setTranslateY(500);
        translatedTextArea.setTranslateX(65);
        root.getChildren().addAll(translatedTextArea);
    }
    public void createTranslateButton(){
        translateButton = new Button("Translate");
        translateButton.setPrefSize(150,60);
        translateButton.setTextFill(Color.WHITE);
        translateButton.setFont(fontForButtons);
        translateButton.setTranslateX(280);
        translateButton.setTranslateY(410);
        root.getChildren().add(translateButton);
    }

}
