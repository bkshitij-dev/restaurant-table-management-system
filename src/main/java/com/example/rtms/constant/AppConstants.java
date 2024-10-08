package com.example.rtms.constant;

import com.example.rtms.exception.AppException;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */
public final class AppConstants {

    private AppConstants() {
        throw new AppException(NOT_INSTANTIABLE);
    }

    public static final String NOT_INSTANTIABLE = "Class is final and not instantiable";

    public static final String SUCCESS_SAVE = "Data saved successfully";
    public static final String SUCCESS_RETRIEVE = "Data retrieved successfully";
    public static final String SUCCESS_UPDATE = "Data updated successfully";
    public static final String SUCCESS_REMOVE = "Data removed successfully";

    public static final int MIN_PASSWORD_LENGTH = 6;

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_STAFF = "STAFF";
    public static final String ROLE_CUSTOMER = "CUSTOMER";
}
