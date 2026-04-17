# Assignment7-Prototype-Design-Pattern

This project implements a Document Management System using the **Prototype Design Pattern**. It allows for the creation of new document objects by cloning pre-configured prototypes, reducing the overhead of manual initialization.

## Design Structure


The implementation consists of the following components:
* **Document Interface**: Defines the `clone()`, `open()`, and `getType()` methods[cite: 12, 13, 14, 15].
* **Concrete Prototypes**: `PdfDocument`, `TextDocument`, and `SpreadsheetDocument` which implement the cloning logic[cite: 17, 19, 21].
* **DocumentRegistry**: Maintains a cache of document prototypes and handles the cloning process[cite: 4, 5, 6, 7].

### UML Diagram:
![UML Diagram](https://github.com/angelynbondoc/Assignment7-Prototype-Design-Pattern/blob/main/Prototype%20Design%20Pattern_UML%20Diagram.jpg)
