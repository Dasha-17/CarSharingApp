package animation;

import com.example.app.DatabaseHandler;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition translateTransition;

    public Shake(Node node){
        translateTransition = new TranslateTransition(Duration.millis(70), node);
        translateTransition.setFromX(0f);
        translateTransition.setByX(10f); //на сколько сдвинется по x
        translateTransition.setCycleCount(3);
        translateTransition.setAutoReverse(true);
    }

    public void playA() {
        translateTransition.playFromStart();
    }
}
