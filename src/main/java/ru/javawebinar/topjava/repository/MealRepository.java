package ru.javawebinar.topjava.repository;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface MealRepository {
    // null if not found, when updated
    // null if updated meal does not belong to userId
    Meal save(Meal meal, int userId);

    // false if not found
    // false if meal does not belong to userId
    boolean delete(int id, int userId);

    // null if not found
    // null if meal does not belong to userId
    Meal get(int id, int userId);

    // ORDERED dateTime desc
    List<Meal> getAll(int userId);

    // ORDERED dateTime desc
    List<Meal> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId);
}
