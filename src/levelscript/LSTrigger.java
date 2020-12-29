package levelscript;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Objects;

public abstract class LSTrigger {
    public static final int VARIABLEVALUE = 1;
    public static final int MAPCHANGE = 2;
    public static final int SCREENRESET = 3;
    public static final int LOADGAME = 4;

    public static final int SMALLEST_TRIGGER_SIZE = 5;

    private int triggerType;
    private int scriptTriggered;

    public LSTrigger(int triggerType, int scriptTriggered) {
        this.triggerType = triggerType;
        this.scriptTriggered = scriptTriggered;
    }

    public static void customAlert(String contentText) {
        Alert a = new Alert(Alert.AlertType.ERROR, contentText, ButtonType.OK);
        a.setHeaderText("Something went wrong");
        a.show();
    }

    public int getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(int triggerType) {
        this.triggerType = triggerType;
    }

    public int getScriptTriggered() {
        return scriptTriggered;
    }

    public void setScriptTriggered(int scriptTriggered) {
        this.scriptTriggered = scriptTriggered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LSTrigger)) return false;
        LSTrigger lst = (LSTrigger) o;
        return this.triggerType == lst.getTriggerType() && this.scriptTriggered == lst.getScriptTriggered();
    }

    @Override
    public int hashCode() {
        return Objects.hash(triggerType, scriptTriggered);
    }

    @Override
    public String toString() {
        return "Starts Script " + getScriptTriggered();
    }
}
