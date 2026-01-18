package ru.top.financeapi.service;

import org.springframework.stereotype.Service;
import ru.top.financeapi.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service // 1. Помечаем класс как Spring-компонент (сервис)
public class TransactionServiceImpl implements TransactionService {

    // 2. Вся логика и "база данных" теперь здесь, а не в контроллере
    private final ConcurrentHashMap<Long, Transaction> transactions = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public TransactionServiceImpl() {
        // Начальные данные для примера
        long id1 = counter.incrementAndGet();
        transactions.put(id1, new Transaction(id1, 100.50, "Покупка продуктов"));
        long id2 = counter.incrementAndGet();
        transactions.put(id2, new Transaction(id2, 75.00, "Оплата интернета"));
    }

    @Override
    public List<Transaction> getAll() {
        return new ArrayList<>(transactions.values());
    }

    @Override
    public Optional<Transaction> getById(Long id) {
        return Optional.ofNullable(transactions.get(id));
    }

    @Override
    public Transaction create(Transaction transaction) {
        long newId = counter.incrementAndGet();
        transaction.setId(newId);
        transactions.put(newId, transaction);
        return transaction;
    }

    @Override
    public Optional<Transaction> update(Long id, Transaction updatedTransaction) {
        if (!transactions.containsKey(id)) {
            return Optional.empty(); // Возвращаем пустой Optional, если транзакции нет
        }
        updatedTransaction.setId(id);
        transactions.put(id, updatedTransaction);
        return Optional.of(updatedTransaction);
    }

    @Override
    public boolean delete(Long id) {
        return transactions.remove(id) != null;
    }
}
