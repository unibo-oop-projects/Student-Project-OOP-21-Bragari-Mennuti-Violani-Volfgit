package vg.view.utils;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import vg.view.SceneController;


import java.util.Map;
import java.util.Optional;

import static javafx.scene.input.KeyEvent.*;

/**
 * Implementation of {@link EventHandler}.
 * Internally using a {@link KeySettings} which will define
 * the correct action to execute.
 * @see EventHandler
 * @see KeyEvent
 */
public final class KeyEventHandler implements EventHandler<KeyEvent> {

    /**
     * @see KeySettings
     */
    private KeySettings keySettings = KeySettings.defaultKeySettings();

    /**
     * Active view's scene controller to be notified of keyboard events.
     */
    private Optional<SceneController> sceneController;

    /**
     * Updates the key settings.
     * @param newSettings {@link KeySettings#fromSettings(Map)}
     */
    public void updateKeySettings(final Map<KeyCode, KeyAction> newSettings) {
        this.keySettings = KeySettings.fromSettings(newSettings);
    }

    /**
     * {@inheritDoc}
     */
    public KeyAction keyPressed(final KeyCode k) {
        return this.keySettings.getAction(k);
    }

    /**
     * {@inheritDoc}
     */
    public KeyAction keyReleased(final KeyCode k) {
        return null;
    }

    /**
     * Set controller of current scene view.
     * @param sceneController scene controller to be notified about new KeyEvent
     */
    public void setSceneController(final SceneController sceneController) {
        this.sceneController = Optional.of(sceneController);
    }

    @Override
    public void handle(final KeyEvent event) {
       // System.out.println(event);
        if (this.sceneController.isPresent()) {
            if (event.getEventType().equals(KEY_PRESSED)) {
                this.sceneController.get().keyPressed(keyPressed(event.getCode()));
            } else if (event.getEventType().equals(KEY_RELEASED)) {
                this.sceneController.get().keyReleased(keyPressed(event.getCode()));
            } else if (event.getEventType().equals(KEY_TYPED)) {
                this.sceneController.get().keyTapped(keyPressed(event.getCode()));
            }
        }
    }
}
