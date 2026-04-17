package prototypeDesignPattern;

public class PdfDocument implements Document {
    private String fileName;
    private String author;
    private int pageCount;
    private String name;

    public PdfDocument(String fileName, String author, int pageCount, String name) {
        this.fileName = fileName;
        this.author = author;
        this.pageCount = pageCount;
        this.name = name;
    }

    @Override
    public PdfDocument clone() {
        try {
            return (PdfDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            return new PdfDocument(fileName, author, pageCount, name);
        }
    }

    @Override
    public void open() {
        System.out.println("Opening PDF Document: " + fileName + " by " + author + " (" + pageCount + " pages)");
        System.out.println("Type: PDF, File: " + fileName + ", Author: " + author + ", Pages: " + pageCount);
    }

    @Override
    public String getType() { return "PDF"; }

    public void setFileName(String fileName) {
    	this.fileName = fileName;
    	}
    
    public void setAuthor(String author) { 
    	this.author = author;
    	}
    
    public void setPageCount(int pageCount) { 
    	this.pageCount = pageCount; 
    	}
    
    public void setName(String name) { 
    	this.name = name; 
    	}
}