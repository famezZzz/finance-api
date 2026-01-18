package ru.top.financeapi.service;

import ru.top.financeapi.model.Transaction;
import java.util.List;
import java.util.Optional;

public interface TransactionService {

    List<Transaction> getAll();

    Optional<Transaction> getById(Long id);

    Transaction create(Transaction transaction);

    Optional<Transaction> update(Long id, Transaction transaction);

    boolean delete(Long id);
}
