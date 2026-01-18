package ru.top.financeapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * JPA-сущность, представляющая финансовую транзакцию.
 */
@Entity
@Table(name = "transactions") // Явно указываем имя таблицы в базе данных
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    // Использование BigDecimal - лучшая практика для финансовых данных,
    // чтобы избежать ошибок округления, свойственных float/double.
    // precision - общее количество цифр, scale - количество цифр после запятой.
    @Column(name = "amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    // LocalDate - современный и правильный тип для хранения даты без времени.
    @Column(name = "date", nullable = false)
    private LocalDate date;

    /**
     * JPA требует конструктор без аргументов для создания экземпляров.
     */
    public Transaction() {
    }

    /**
     * Удобный конструктор для создания объектов в коде.
     */
    public Transaction(String description, BigDecimal amount, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    // --- Геттеры и Сеттеры ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
