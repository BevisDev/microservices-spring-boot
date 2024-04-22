package com.rest.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.rest.constant.ApiConst;
import com.rest.dto.response.BaseResponse;
import com.rest.dto.response.HealthCheckDTO;
import com.rest.service.HealthCheckService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@RestController
public class HealCheckController {

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping(value = ApiConst.HEALTH_CHECK_PATH)
    public BaseResponse<HealthCheckDTO> getStatusSystem(@RequestParam(value = "isDetail", required = false) boolean isDetail) throws Exception {
        BaseResponse<HealthCheckDTO> response = healthCheckService.getStatusSystem(isDetail);
        String path = "D:\\Doc\\Quy trình phê duyệt TTr.docx";
        String out = "D:\\Doc\\Quy trình phê duyệt TTr.pdf";
        writeToLastPage(path, "Hello World");
        convert(path, out);
        return response;
    }

    public void writeToLastPage(String docxPath, String textToAdd) {
        try (FileInputStream fis = new FileInputStream(docxPath);
             XWPFDocument document = new XWPFDocument(fis)) {

            // Create a table with 3 rows and 3 columns
            XWPFTable table = document.createTable(3, 3);

            // Fill in each cell with data
            for (int row = 0; row < 3; row++) {
                XWPFTableRow tableRow = table.getRow(row);
                for (int col = 0; col < 3; col++) {
                    tableRow.getCell(col).setText("Row " + row + ", Col " + col);
                }
            }

            // Save the document
            try (OutputStream os = new FileOutputStream(docxPath)) {
                document.write(os);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void convert(String doc, String out) throws Exception {
        InputStream docxInputStream = new FileInputStream(doc);
        try (XWPFDocument document = new XWPFDocument(docxInputStream);
             OutputStream pdfOutputStream = new FileOutputStream(out);) {
            Document pdfDocument = new Document();
            PdfWriter.getInstance(pdfDocument, pdfOutputStream);
            pdfDocument.open();

            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (XWPFParagraph paragraph : paragraphs) {
                pdfDocument.add(new Paragraph(paragraph.getText()));
            }
            pdfDocument.close();
        }
    }

    public void convertDocxToPdf(String docxPath, String pdfPath) throws Exception {
        try (XWPFDocument doc = new XWPFDocument(new FileInputStream(docxPath));
             PDDocument pdfDoc = new PDDocument()) {

            PDPage page = new PDPage(PDRectangle.A4);
            pdfDoc.addPage(page);
//            try (PDPageContentStream contentStream = new PDPageContentStream(pdfDoc, page)) {
//                // Simple text extraction and writing to PDF
//                doc.getParagraphs().forEach(paragraph -> {
//                    try {
//                        contentStream.beginText();
//                        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
//                        contentStream.newLineAtOffset(100, 700);
//                        contentStream.showText(paragraph.getText());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    } finally {
//                        try {
//                            contentStream.endText();
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                });
//            }
//            ;

            pdfDoc.save(pdfPath);
            System.out.println("PDF created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = ApiConst.HEALTH_CHECK_DATABASE_PATH)
    public BaseResponse<?> getStatusDatabase() {
        BaseResponse<HealthCheckDTO> response = healthCheckService.getStatusDatabase();
        return response;
    }

}
