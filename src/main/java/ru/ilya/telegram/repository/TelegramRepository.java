package ru.ilya.telegram.repository;

import org.springframework.data.repository.Repository;
import ru.ilya.telegram.model.db.TelegramDb;

public interface TelegramRepository extends Repository<TelegramDb, String> {
}
