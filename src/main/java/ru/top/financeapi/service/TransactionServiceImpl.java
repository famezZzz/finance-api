package ru.top.financeapi.service;

import org.springframework.stereotype.Service;
import ru.top.financeapi.model.Transaction;
import ru.top.financeapi.repository.TransactionRepository; // 1. Импортируем наш репозиторий

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    // 2. Внедряем зависимость от репозитория (вместо ConcurrentHashMap)
    private final TransactionRepository transactionRepository;

    // 3. Spring автоматически "подставит" нужную реализацию через конструктор
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAll() {
        // 4. Просто делегируем вызов репозиторию
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> getById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction create(Transaction transaction) {
        // Метод save() создаст новую запись, если id у транзакции null,
        // и вернет сущность с уже присвоенным базой данных ID.
        return transactionRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> update(Long id, Transaction transactionDetails) {
        // Ищем существующую транзакцию по id
        return transactionRepository.findById(id)
                .map(existingTransaction -> { // Если она найдена...
                    // ...обновляем ее поля данными из запроса
                    existingTransaction.setDescription(transactionDetails.getDescription());
                    existingTransaction.setAmount(transactionDetails.getAmount());
                    existingTransaction.setDate(transactionDetails.getDate());
                    // ...и сохраняем изменения в БД
                    return transactionRepository.save(existingTransaction);
                });
    }

    @Override
    public boolean delete(Long id) {
        // Проверяем, существует ли запись, перед удалением
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
