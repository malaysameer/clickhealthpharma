package com.clickhealth.pharma.services.impl;

import com.clickhealth.pharma.report.model.PurchaseReportItem;
import com.clickhealth.pharma.report.model.SalesReportItem;
import com.clickhealth.pharma.report.model.StockReportItem;
import com.clickhealth.pharma.repository.ReportRepository;
import com.clickhealth.pharma.services.ReportService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<StockReportItem> getStockReport() {
        return reportRepository.getStockReport().stream()
                .map(r -> new StockReportItem()
                        .medicineId((Integer) r[0])
                        .name((String) r[1])
                        .quantity((Integer) r[2]))
                .collect(Collectors.toList());
    }

    @Override
    public List<SalesReportItem> getSalesReport(LocalDate start, LocalDate end) {
        return reportRepository.getSalesReport(start, end).stream()
                .map(r -> new SalesReportItem()
                        .date(((java.sql.Timestamp) r[0]).toLocalDateTime().toLocalDate())
                        .invoiceId((Integer) r[1])
                        .customerName((String) r[2])
                        .totalAmount((Double) r[3]))
                .collect(Collectors.toList());
    }

    @Override
    public List<PurchaseReportItem> getPurchaseReport(LocalDate start, LocalDate end) {
        return reportRepository.getPurchaseReport(start, end).stream()
                .map(r -> new PurchaseReportItem()
                        .date(((java.sql.Timestamp) r[0]).toLocalDateTime().toLocalDate())
                        .purchaseId((Integer) r[1])
                        .supplierName((String) r[2])
                        .totalAmount((Double) r[3]))
                .collect(Collectors.toList());
    }
}
