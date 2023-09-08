package com.proj.IMS.service;

import com.proj.IMS.model.Intern;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class PatchUsingReflection {
    public void internPatcher(Intern existingIntern, Intern updatedIntern) throws IllegalAccessException {
        Class<?> internClass = Intern.class;

        for (Field field : internClass.getDeclaredFields()) {
            field.setAccessible(true);

            Object fieldValue = field.get(updatedIntern);
            System.out.println(field.get(updatedIntern) + " fieldvalue/n/n");

            if (fieldValue != null) {
                field.set(existingIntern, fieldValue);
            }
        }
    }
}
