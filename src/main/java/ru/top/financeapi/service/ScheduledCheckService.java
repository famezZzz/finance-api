package ru.top.financeapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Сервис для выполнения задач по расписанию.
 */
@Component // 1. Помечаем класс как Spring-компонент, чтобы он был найден и управлялся Spring
public class ScheduledCheckService {

    // 2. Используем логгер - это лучшая практика, чем System.out.println()
    private static final Logger log = LoggerFactory.getLogger(ScheduledCheckService.class);

    /**
     * Этот метод будет выполняться по расписанию, заданному в аннотации @Scheduled.
     ..cron = "0 * * * * ?" означает "выполнять каждую минуту, в нулевую секунду".
     */
    @Scheduled(cron = "0 * * * * ?")
    public void performScheduledCheck() {
        log.info("Выполняю плановую проверку...");
        // В будущем здесь может быть реальная логика:
        // - Проверка состояния внешних сервисов
        // - Очистка временных файлов
        // - Отправка сводных отчетов по транзакциям
    }
}
