package ru.top.financeapi.repository;

import ru.top.financeapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Здесь можно добавлять кастомные методы для запросов в БД
    // Например, List<Transaction> findByType(Transaction.TransactionType type);
}