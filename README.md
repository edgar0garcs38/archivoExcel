# Excel Export Servlet

A minimal Jakarta EE example showing how a Servlet can generate and **download an Excel file** without external libraries, using the SpreadsheetML (XML) format.

## How it works
- `GET /descargarExcel` sets the `application/vnd.ms-excel` content type and a `Content-Disposition: attachment` header
- It writes a SpreadsheetML workbook to the response stream, which Excel opens as a normal spreadsheet

## Tech stack
Java · Jakarta EE Servlets · Maven · Apache Tomcat

## Run it
```bash
./mvnw clean package
```
Deploy to Tomcat, open `index.html` and click the download link.
