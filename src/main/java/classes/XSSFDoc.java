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
    private static final String fileName = "C:\\util\\planilha\\clientes.xlsx";
    private List<CustomerC> customer = new ArrayList<CustomerC>();

    public XSSFDoc() throws IOException {
        try {
            FileInputStream arquivo = new FileInputStream(new File(XSSFDoc.fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetCustomer = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheetCustomer.iterator();
            List<CustomerC> customerList = new ArrayList<CustomerC>();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                CustomerC customerC = new CustomerC();
                Endereco endereco = new Endereco();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            customerC.setBirthday(Integer.valueOf((int) cell.getNumericCellValue()));
                            break;
                        case 1:
                            endereco.setCep(cell.getStringCellValue());
                            break;
                        case 2:
                            endereco.setEndereco(cell.getStringCellValue());
                            break;
                        case 3:
                            endereco.setNumero(cell.getStringCellValue());
                            break;
                        case 4:
                            endereco.setComplemento(cell.getStringCellValue());
                            break;
                        case 5:
                            endereco.setBairro(cell.getStringCellValue());
                            break;
                        case 6:
                            endereco.setMunicipio(cell.getStringCellValue());
                            break;
                        case 7:
                            if (cell.getStringCellValue() != "JURIDICA") {
                                customerC.setTipoPessoa(TipoPessoaEnum.FISICA);
                            }
                            else {
                                customerC.setTipoPessoa(TipoPessoaEnum.JURIDICA);
                            }
                            break;
                        case 8:
                            customerC.setRazaoSocial(cell.getStringCellValue());
                            break;
                        case 9:
                            customerC.setFantasia(cell.getStringCellValue());
                            break;
                        case 10:
                            customerC.setCpfCnpj(cell.getStringCellValue());
                            break;
                        case 11:
                            customerC.setLimit(cell.getNumericCellValue());
                            break;
                        case 12:
                            customerC.setRgIe(cell.getStringCellValue());
                            break;
                        case 13:
                            customerC.setEmail(cell.getStringCellValue());
                            break;
                        case 14:
                            if (cell.getStringCellValue() == "S") {
                                customerC.setEhSimples(true);
                            } else {
                                customerC.setEhSimples(false);
                            }
                            break;
                        case 15:
                            customerC.setCelular(cell.getStringCellValue());
                            break;
                        case 16:
                            customerC.setFone(cell.getStringCellValue());
                            break;
                        case 17:
                            customerC.setObservacao(cell.getStringCellValue());
                            break;
                        case 18:
                            customerC.setSuframa((int) cell.getNumericCellValue());

                            customerC.getEnderecos().add(endereco);
                            customerList.add(customerC);
                            break;

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
    }
}
