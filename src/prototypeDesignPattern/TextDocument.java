package prototypeDesignPattern;

public class TextDocument implements Document {
    private String filePath;
    private String encoding;
    private int wordCount;

    public TextDocument(String filePath, String encoding, int wordCount) {
        this.filePath = filePath;
        this.encoding = encoding;
        this.wordCount = wordCount;
    }

    @Override
    public TextDocument clone() {
        try {
            return (TextDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            return new TextDocument(filePath, encoding, wordCount);
        }
    }

    @Override
    public void open() {
        System.out.println("Opening Text Document: " + filePath + " with encoding: " + encoding + " (" + wordCount + " words)");
        System.out.println("Type: Text, Path: " + filePath + ", Encoding: " + encoding + ", Words: " + wordCount);
    }

    @Override
    public String getType() { return "Text"; }

    public void setFilePath(String filePath) {
    	this.filePath = filePath; 
    	}
    
    public void setEncoding(String encoding) { 
    	this.encoding = encoding;
    	}
    
    public void setWordCount(int wordCount) { 
    	this.wordCount = wordCount; 
    	}
}
