package org.edgar.archivoExcel;

import java.io.IOException;
import java.io.OutputStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/descargarExcel")
public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"datos.xls\"");

        String excelContent = "<?xml version=\"1.0\"?>\n"
                + "<?mso-application progid=\"Excel.Sheet\"?>\n"
                + "<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\">\n"
                + "   <Worksheet ss:Name=\"Hoja1\">\n"
                + "       <Table>\n"
                + "           <Row>\n"
                + "               <Cell><Data ss:Type=\"String\">ID</Data></Cell>\n"
                + "               <Cell><Data ss:Type=\"String\">Nombre</Data></Cell>\n"
                + "               <Cell><Data ss:Type=\"String\">Edad</Data></Cell>\n"
                + "           </Row>\n"
                + "           <Row>\n"
                + "               <Cell><Data ss:Type=\"Number\">1</Data></Cell>\n"
                + "               <Cell><Data ss:Type=\"String\">Edgar</Data></Cell>\n"
                + "               <Cell><Data ss:Type=\"Number\">30</Data></Cell>\n"
                + "           </Row>\n"
                + "           <Row>\n"
                + "               <Cell><Data ss:Type=\"Number\">2</Data></Cell>\n"
                + "               <Cell><Data ss:Type=\"String\">Maria</Data></Cell>\n"
                + "               <Cell><Data ss:Type=\"Number\">25</Data></Cell>\n"
                + "           </Row>\n"
                + "       </Table>\n"
                + "   </Worksheet>\n"
                + "</Workbook>";

        try (OutputStream out = response.getOutputStream()) {
            out.write(excelContent.getBytes());
        }
    }
}
