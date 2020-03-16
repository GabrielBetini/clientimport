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

public class XSSFDoc  {
    private static final String fileName = "C:\\util\\planilha\\customer.xlsx";
    List<CustomerC> customer = new ArrayList<CustomerC>();



    public XSSFDoc() throws IOException {
        FileInputStream arquivo  = new FileInputStream(new File(XSSFDoc.fileName));
        XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
        XSSFSheet sheetCustomer = workbook.getSheetAt(0);




    }
}
