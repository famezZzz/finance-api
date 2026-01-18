package ru.top.financeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.top.financeapi.model.Transaction; // Импортируем нашу сущность Transaction

/**
 * Spring Data JPA репозиторий для сущности Transaction.
 * Предоставляет стандартные CRUD-операции без необходимости писать реализацию.
 */
@Repository // Помечаем этот интерфейс как компонент-репозиторий Spring
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Spring Data JPA автоматически предоставит реализации для следующих методов:
    // - save(Transaction entity)
    // - findById(Long id)
    // - findAll()
    // - deleteById(Long id)
    // - existsById(Long id)
    // И многие другие, без единой строчки кода!

    // Здесь вы можете добавить свои кастомные методы, если они потребуются,
    // например: List<Transaction> findByDescriptionContaining(String keyword);
}
