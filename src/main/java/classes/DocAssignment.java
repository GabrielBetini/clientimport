//package classes;
//
//import org.apache.poi.ss.usermodel.*;
//import util.CustomerC;
//
//import java.io.File;
//import java.io.IOException;
//
//public class DocAssignment {
//    File doc = new File("C:\\util\\planilha\\customer.xlsx"); //Alocate .xlsx file
//    Workbook workbook = WorkbookFactory.create(doc); // create a workbook
//    Sheet sheet = workbook.getSheetAt(0); // set wich sheet do you want to read
//    DataFormatter formatter = new DataFormatter(); // data formatter to read cells and set values
//
//    public DocAssignment()
//            throws IOException {
//        for (int i = 1; i < sheet.getLastRowNum(); i++) {
//            if (sheet.getRow(i) == null) {
//                continue;
//            }
//            Row row = sheet.getRow(i);
//            CustomerC customerC = new CustomerC(i);
//
//            customerC.setBirthday(formatter.formatCellValue(row.getCell(0)));
//            //  customerC.tipoCustomer(formatter.formatCellValue(row.getCell(1)));
//        //    customerC.setTipoEndereco(formatter.formatCellValue(row.getCell(2)));
//          //  customerC.setCep(formatter.formatCellValue(row.getCell(3)));
//            //customerC.setTipoLogradouro(formatter.formatCellValue(row.getCell(4)));
//            //  customerC.setEndereco(formatter.formatCellValue(row.getCell(5)));
//            //customerC.setNumero(formatter.formatCellValue(row.getCell(6)));
//            //customerC.setComplemento(formatter.formatCellValue(row.getCell(7)));
//            //customerC.setBairro(formatter.formatCellValue(row.getCell(8)));
//            //customerC.setMunicipio(formatter.formatCellValue(row.getCell(9)));
//            //customerC.setTipoPessoa(formatter.formatCellValue(row.getCell(10)));
//            customerC.setRazaoSocial(formatter.formatCellValue(row.getCell(11)));
//            customerC.setFantasia(formatter.formatCellValue(row.getCell(12)));
//            customerC.setCpfCnpj(formatter.formatCellValue(row.getCell(13)));
//           // customerC.setLimit(formatter.formatCellValue(row.getCell(14)));
//            customerC.setRgIe(formatter.formatCellValue(row.getCell(15)));
//            customerC.setEmail(formatter.formatCellValue(row.getCell(16)));
//            //customerC.setIsentoIcms(formatter.formatCellValue(row.getCell(17)));
//            //customerC.setEhSimples(formatter.formatCellValue(row.getCell(18)));
//            customerC.setCelular(formatter.formatCellValue(row.getCell(19)));
//            customerC.setFone(formatter.formatCellValue(row.getCell(20)));
//            customerC.setObservacao(formatter.formatCellValue(row.getCell(21)));
//           //customerC.setEnderecos(formatter.formatCellValue(row.getCell(22)));
//
//        }
//    }
//}
