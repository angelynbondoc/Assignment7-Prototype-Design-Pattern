package prototypeDesignPattern;

public class ProcessedDocument {
    public static void main(String[] args) {
        DocumentRegistry registry = new DocumentRegistry();

        System.out.println();

        PdfDocument pdf = registry.createPdf();
        pdf.open();

        System.out.println();

        TextDocument text = registry.createTextDocument();
        text.open();

        System.out.println();

        SpreadsheetDocument spreadsheet = registry.createSpreadsheet();
        spreadsheet.open();

        System.out.println();

        PdfDocument summaryPdf = registry.createPdf("summary_report.pdf", "Acme Corp", 30, "Summary Report");
        summaryPdf.open();
    }
}