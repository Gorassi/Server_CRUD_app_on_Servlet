package ru.javawebinar.topjava.repository;
import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

// TODO add userId
public interface MealRepository {
    // null if not found, when updated
    // null if updated meal does not belong to userId
    Meal save(Meal meal);

    // false if not found
    // false if meal does not belong to userId
    boolean delete(int id);

    // null if not found
    // null if meal does not belong to userId
    Meal get(int id);

    // ORDERED dateTime desc
    Collection<Meal> getAll();
}
