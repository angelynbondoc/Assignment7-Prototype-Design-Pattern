package prototypeDesignPattern;

public class DocumentRegistry {
    private PdfDocument pdfPrototype;
    private TextDocument textDocumentPrototype;
    private SpreadsheetDocument spreadsheetPrototype;

    public DocumentRegistry() {
        System.out.println("Creating a PDF Document prototype.");
        pdfPrototype = new PdfDocument("annual_report_2024.pdf", "Acme Corp", 150, "PDF Prototype");

        System.out.println("Creating a Text Document prototype.");
        textDocumentPrototype = new TextDocument("meeting_notes.txt", "UTF-8", 250);

        System.out.println("Creating a Spreadsheet Document prototype.");
        spreadsheetPrototype = new SpreadsheetDocument("sales_data_q1.xlsx", 1000, 20);
    }

    public PdfDocument createPdf() {
        return pdfPrototype.clone();
    }

    public PdfDocument createPdf(String fileName, String author, int pageCount, String name) {
        PdfDocument doc = pdfPrototype.clone();
        doc.setFileName(fileName);
        doc.setAuthor(author);
        doc.setPageCount(pageCount);
        doc.setName(name);
        return doc;
    }

    public TextDocument createTextDocument() {
        return textDocumentPrototype.clone();
    }

    public SpreadsheetDocument createSpreadsheet() {
        return spreadsheetPrototype.clone();
    }
}