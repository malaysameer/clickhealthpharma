package com.clickhealth.pharma.controller;

import com.clickhealth.pharma.report.api.ReportsApi;
import com.clickhealth.pharma.report.model.StockReportItem;
import com.clickhealth.pharma.report.model.SalesReportItem;
import com.clickhealth.pharma.report.model.PurchaseReportItem;
import com.clickhealth.pharma.services.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReportController implements ReportsApi {

    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public ResponseEntity<List<StockReportItem>> getStockReport() {
        return ResponseEntity.ok(reportService.getStockReport());
    }

    @Override
    public ResponseEntity<List<SalesReportItem>> getSalesReport(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        return ResponseEntity.ok(reportService.getSalesReport(from, to));
    }

    @Override
    public ResponseEntity<List<PurchaseReportItem>> getPurchaseReport(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        return ResponseEntity.ok(reportService.getPurchaseReport(from, to));
    }
}
