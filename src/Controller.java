import javax.naming.ldap.Control;
import java.io.IOException;

public class Controller {
    View view;
    Config cfg;

    public Controller() throws IOException, InterruptedException {
        view = new View();
        initSplitMenuAction();
        cfg = new Config();
        translateAction();
        changeLanguageArrowAction();
    }

    public void initSplitMenuAction() {
        setTextOnButtonLangFrom();
        setTextOnButtonLangTo();
    }

    public void setTextOnButtonLangFrom() {
        view.fromLang1.setOnAction(e -> {
            if (e.getSource() == view.fromLang1) {
                view.splitMenuButtonFromLang.setText(view.fromLang1.getText());
            }
        });

        view.fromLang2.setOnAction(e -> {
            if (e.getSource() == view.fromLang2) {
                view.splitMenuButtonFromLang.setText(view.fromLang2.getText());
            }
        });

        view.fromLang3.setOnAction(e -> {
            if (e.getSource() == view.fromLang3) {
                view.splitMenuButtonFromLang.setText(view.fromLang3.getText());
            }
        });
    }

    public void setTextOnButtonLangTo() {
        view.toLang1.setOnAction(e -> {
            if (e.getSource() == view.toLang1) {
                view.splitMenuButtonToLang.setText(view.toLang1.getText());
            }
        });

        view.toLang2.setOnAction(e -> {
            if (e.getSource() == view.toLang2) {
                view.splitMenuButtonToLang.setText(view.toLang2.getText());
            }
        });

        view.toLang3.setOnAction(e -> {
            if (e.getSource() == view.toLang3) {
                view.splitMenuButtonToLang.setText(view.toLang3.getText());
            }
        });
    }

    public void changeLanguageArrowAction() {
        view.arrowImageView.setOnMouseClicked(e -> {
            String temp = "";
            temp = view.splitMenuButtonFromLang.getText();
            view.splitMenuButtonFromLang.setText(view.splitMenuButtonToLang.getText());
            view.splitMenuButtonToLang.setText(temp);
        });
    }

    public void translateAction() {
        view.translateButton.setOnAction(e -> {
            if (e.getSource() == view.translateButton) {
                cfg.fromLang = view.splitMenuButtonFromLang.getText();
                System.out.println(cfg.fromLang);
                cfg.toLang = view.splitMenuButtonToLang.getText();
                System.out.println(cfg.toLang);
                cfg.textToTranslate = view.currentTextArea.getText();
                try {
                    cfg.test();
                    view.translatedTextArea.setText(cfg.translatedText);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
    }
}
