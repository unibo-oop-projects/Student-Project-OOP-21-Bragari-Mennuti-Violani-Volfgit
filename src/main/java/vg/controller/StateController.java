package vg.controller;

import javafx.scene.input.KeyCode;
import vg.view.utils.KeyAction;
import vg.view.utils.KeyEventHandler;

/**
 * The state controller is the controller of a "state" of the software.
 * The states can be either a game in progress, paused or menu state.
 * @param <V> the type of view
 */
public interface StateController<V> {
    /**
     * Returns the view controlled by the controller.
     * @return the view
     */
    V getView();

    /**
     * Sets the view of the controller.
     * @param view the view that will be bound
     */
    void setView(V view);

}
