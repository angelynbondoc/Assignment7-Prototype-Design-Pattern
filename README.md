# Document Management System — Prototype Design Pattern

A Java console application for Assignment 7 that demonstrates the **Prototype design pattern**. A registry stores preconfigured PDF, text, and spreadsheet objects, then creates new documents by cloning those prototypes.

The application models document metadata and prints it to the console. It does not read, write, or open actual document files.

## How it works

1. `DocumentRegistry` initializes one prototype for each document type.
2. The client requests a document through the registry's factory methods.
3. The registry clones the corresponding prototype and returns a separate object.
4. The client can customize the clone without changing the stored prototype.

Each implementation uses `Object.clone()` to make a shallow copy, with a constructor-based fallback. The current fields contain only primitive values and immutable strings, so this is sufficient for independently changing a clone's metadata. Adding mutable fields would require considering deep copying.

## Project structure

```text
src/
├── module-info.java
└── prototypeDesignPattern/
    ├── Document.java
    ├── DocumentRegistry.java
    ├── PdfDocument.java
    ├── ProcessedDocument.java
    ├── SpreadsheetDocument.java
    └── TextDocument.java
```

| Component | Role |
| --- | --- |
| `Document` | Prototype interface; extends `Cloneable` and declares `clone()`, `open()`, and `getType()`. |
| `PdfDocument`, `TextDocument`, `SpreadsheetDocument` | Concrete prototypes that store metadata and implement cloning. |
| `DocumentRegistry` | Stores the prototypes and provides methods to create copies, including a customized PDF. |
| `ProcessedDocument` | Entry point that demonstrates creating and opening each document type. |

## Requirements

- JDK 9 or later, because the project includes `module-info.java`.
- Both `java` and `javac` available on your `PATH`.
- No external dependencies or build tool required.

## Run the demo

From the repository root, compile and run:

```sh
javac -d out src/module-info.java src/prototypeDesignPattern/*.java
java -cp out prototypeDesignPattern.ProcessedDocument
```

Alternatively, import the source into a Java IDE and run `ProcessedDocument.main()`.

The demo creates the three default document types and a customized summary PDF. Expected output:

```text
Creating a PDF Document prototype.
Creating a Text Document prototype.
Creating a Spreadsheet Document prototype.

Opening PDF Document: annual_report_2024.pdf by Acme Corp (150 pages)
Type: PDF, File: annual_report_2024.pdf, Author: Acme Corp, Pages: 150

Opening Text Document: meeting_notes.txt with encoding: UTF-8 (250 words)
Type: Text, Path: meeting_notes.txt, Encoding: UTF-8, Words: 250

Opening Spreadsheet Document: sales_data_q1.xlsx (1000 rows, 20 columns)
Type: Spreadsheet, Name: sales_data_q1.xlsx, Rows: 1000, Columns: 20

Opening PDF Document: summary_report.pdf by Acme Corp (30 pages)
Type: PDF, File: summary_report.pdf, Author: Acme Corp, Pages: 30
```

## Usage example

```java
DocumentRegistry registry = new DocumentRegistry();

// Clone the default PDF prototype.
PdfDocument report = registry.createPdf();
report.setFileName("project_report.pdf");
report.setPageCount(42);
report.open();

// Clone and customize a PDF in one call.
PdfDocument summary = registry.createPdf(
    "summary_report.pdf", "Acme Corp", 30, "Summary Report"
);
summary.open();

// Other document types use the same cloning approach.
TextDocument notes = registry.createTextDocument();
SpreadsheetDocument spreadsheet = registry.createSpreadsheet();
```

## UML diagram

![UML diagram showing the document prototypes and registry](Prototype%20Design%20Pattern_UML%20Diagram.jpg)
