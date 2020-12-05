package cli;

import java.awt.event.ActionEvent;

public class CLIEvent extends ActionEvent {
    /**
     * Constructs an {@code ActionEvent} object.
     * <p>
     * This method throws an
     * {@code IllegalArgumentException} if {@code source}
     * is {@code null}.
     * A {@code null command} string is legal,
     * but not recommended.
     *
     * @param source  The object that originated the event
     * @param id      An integer that identifies the event.
     *                For information on allowable values, see
     *                the class description for {@link ActionEvent}
     * @param command A string that may specify a command (possibly one
     *                of several) associated with the event
     * @throws IllegalArgumentException if {@code source} is null
     * @see #getSource()
     * @see #getID()
     * @see #getActionCommand()
     */
    public CLIEvent(Object source, int id, String command) {
        super(source, id, command);
    }

    /**
     * Constructs an {@code ActionEvent} object with modifier keys.
     * <p>
     * This method throws an
     * {@code IllegalArgumentException} if {@code source}
     * is {@code null}.
     * A {@code null command} string is legal,
     * but not recommended.
     *
     * @param source    The object that originated the event
     * @param id        An integer that identifies the event.
     *                  For information on allowable values, see
     *                  the class description for {@link ActionEvent}
     * @param command   A string that may specify a command (possibly one
     *                  of several) associated with the event
     * @param modifiers The modifier keys down during event
     *                  (shift, ctrl, alt, meta).
     *                  Passing negative parameter is not recommended.
     *                  Zero value means that no modifiers were passed
     * @throws IllegalArgumentException if {@code source} is null
     * @see #getSource()
     * @see #getID()
     * @see #getActionCommand()
     * @see #getModifiers()
     */
    public CLIEvent(Object source, int id, String command, int modifiers) {
        super(source, id, command, modifiers);
    }

    /**
     * Constructs an {@code ActionEvent} object with the specified
     * modifier keys and timestamp.
     * <p>
     * This method throws an
     * {@code IllegalArgumentException} if {@code source}
     * is {@code null}.
     * A {@code null command} string is legal,
     * but not recommended.
     *
     * @param source    The object that originated the event
     * @param id        An integer that identifies the event.
     *                  For information on allowable values, see
     *                  the class description for {@link ActionEvent}
     * @param command   A string that may specify a command (possibly one
     *                  of several) associated with the event
     * @param when      A long that gives the time the event occurred.
     *                  Passing negative or zero value
     *                  is not recommended
     * @param modifiers The modifier keys down during event
     *                  (shift, ctrl, alt, meta).
     *                  Passing negative parameter is not recommended.
     *                  Zero value means that no modifiers were passed
     * @throws IllegalArgumentException if {@code source} is null
     * @see #getSource()
     * @see #getID()
     * @see #getActionCommand()
     * @see #getModifiers()
     * @see #getWhen()
     * @since 1.4
     */
    public CLIEvent(Object source, int id, String command, long when, int modifiers) {
        super(source, id, command, when, modifiers);
    }
}
