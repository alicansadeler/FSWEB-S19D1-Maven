package com.workintech.s18d2;

import com.workintech.s18d2.exceptions.ApiErrorResponse;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;

public class validations {
    public static void validId(Long id) {
        if (id < 0) {
            throw new PlantException("ID değeri negatif olamaz. ID: " + id, HttpStatus.BAD_REQUEST);
        }
    }
}
