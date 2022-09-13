package com.project.portal.exceptions;

public class UserAlreadyExistsException extends Exception {

    /**
     * Unique serial ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     *
     * @param s the custom message
     */
    public UserAlreadyExistsException(final String s) {
        super(s);
    }
}
