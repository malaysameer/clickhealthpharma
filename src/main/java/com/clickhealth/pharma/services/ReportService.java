package com.clickhealth.pharma.services;

import com.clickhealth.pharma.report.model.StockReportItem;
import com.clickhealth.pharma.report.model.SalesReportItem;
import com.clickhealth.pharma.report.model.PurchaseReportItem;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    List<StockReportItem> getStockReport();
    List<SalesReportItem> getSalesReport(LocalDate from, LocalDate to);
    List<PurchaseReportItem> getPurchaseReport(LocalDate from, LocalDate to);
}
