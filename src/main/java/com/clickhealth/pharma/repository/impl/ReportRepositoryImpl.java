package com.clickhealth.pharma.repository.impl;

import com.clickhealth.pharma.repository.ReportRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> getStockReport() {
        String sql = "SELECT m.id, m.name, m.quantity FROM medicines m";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getSalesReport(LocalDate start, LocalDate end) {
        String sql = """
            SELECT s.sale_date, s.id, c.name, s.total_amount
            FROM sales s
            JOIN customers c ON s.customer_id = c.id
            WHERE s.sale_date BETWEEN :start AND :end
        """;
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("start", start);
        query.setParameter("end", end);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getPurchaseReport(LocalDate start, LocalDate end) {
        String sql = """
            SELECT p.purchase_date, p.id, s.name, p.total_amount
            FROM purchases p
            JOIN suppliers s ON p.supplier_id = s.id
            WHERE p.purchase_date BETWEEN :start AND :end
        """;
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("start", start);
        query.setParameter("end", end);
        return query.getResultList();
    }
}
