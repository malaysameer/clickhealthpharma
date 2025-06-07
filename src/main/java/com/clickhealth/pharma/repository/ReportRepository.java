package com.clickhealth.pharma.repository;

import java.time.LocalDate;
import java.util.List;

public interface ReportRepository {
    List<Object[]> getStockReport();
    List<Object[]> getSalesReport(LocalDate start, LocalDate end);
    List<Object[]> getPurchaseReport(LocalDate start, LocalDate end);
}
