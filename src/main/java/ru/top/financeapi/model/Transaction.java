package ru.top.financeapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // 1. Говорит JPA, что это сущность, которую нужно сохранять в БД
@Table(name = "transactions") // 2. (Опционально) Указывает, что таблица в БД будет называться "transactions"
public class Transaction {

    @Id // 3. Помечает это поле как первичный ключ (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Говорит, что БД будет сама генерировать значение этого поля (например, автоинкремент)
    private Long id;

    private double amount;
    private String description;

    // Важно: JPA требует наличие конструктора без аргументов
    public Transaction() {
    }

    // Ваши остальные конструкторы, геттеры и сеттеры...
    public Transaction(Long id, double amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
