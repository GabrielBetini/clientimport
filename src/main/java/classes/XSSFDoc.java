package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import util.CustomerC;
import util.Endereco;

public class XSSFDoc {
    private static final String fileName = "C:\\util\\planilha\\customer.xlsx";
    private List<CustomerC> customer = new ArrayList<CustomerC>();

    public XSSFDoc() throws IOException {
        try {
            FileInputStream arquivo = new FileInputStream(new File(XSSFDoc.fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetCustomer = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheetCustomer.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                customer.add(new CustomerC());
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:






                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }


    }
}
