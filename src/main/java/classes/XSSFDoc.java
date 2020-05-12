package classes;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.CepResponse;
import util.CustomerC;
import util.Endereco;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class XSSFDoc {
    private static final String fileName = "/home/nsd_rgeraldo/Downloads/clientes.xlsx";
    public List<CustomerC> customerList = new ArrayList<>();

    public XSSFDoc() throws IOException {
        try {
            FileInputStream arquivo = new FileInputStream(new File(XSSFDoc.fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetCustomer = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheetCustomer.iterator();
            Gson gson = new Gson();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                CustomerC customerC = new CustomerC();
                Endereco endereco = new Endereco();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    OkHttpClient httpClient = new OkHttpClient();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            customerC.setBirthday((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            String cep;
                            if (cell.getCellType() == CellType.STRING) {
                                cep = cell.getStringCellValue();
                            }
                            else{
                                cep = String.valueOf(cell.getNumericCellValue());
                            }
                            endereco.setCep(cep);
                            // json request body
                            Request request = new Request.Builder()
                                    .url("https://api-dev.smartpos.net.br/api/v1/endereco/cep/" + cep)
                                    .addHeader("Authorization", "NA-AUTH HJwi8Nvh8kaE/4rgvC+z/9t+BF2+XMIV4zue2NgZxA6PiqxqsguoBeeAX4XqWd7vEf4YPYAvo2xkOFE9swMKruvhN5xVTPtE+wqQZueXuy89IHXEhC4DS1nnH3O+fGuV6wAzco7TzBKkgNBlQUCrJL8rax4uqzY83mFNVymxd2Pr4TecVUz7RPsKkGbnl7sv8etzcWCOpyHCONQYo0bWFusAM3KO08wSpIDQZUFAqySpUuERIb4NQbEly3YXWKBS")
                                    .addHeader("Content-Type", "application/json")
                                    .get()
                                    .build();
                            try (Response response = httpClient.newCall(request).execute()) {

                                if (!response.isSuccessful()) {
                                    throw new IOException("Unexpected code " + response + customerC.toString());
                                }
                                String responseBody = Objects.requireNonNull(response.body()).string();
                                CepResponse entity = gson.fromJson(responseBody, CepResponse.class);
                                endereco.setMunicipio(entity.getMunicipio());
                                endereco.setPais(entity.getPais());
                            }

                            break;
                        case 2:
                            endereco.setEndereco(cell.getStringCellValue());
                            break;
                        case 3:
                            if (cell.getCellType() == CellType.STRING){
                                endereco.setNumero(cell.getStringCellValue());
                            }
                            else{
                                endereco.setNumero(String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        case 4:
                            endereco.setComplemento(cell.getStringCellValue());
                            break;
                        case 5:
                            endereco.setBairro(cell.getStringCellValue());
                            break;
                        case 7:
                            if (cell.getStringCellValue().equals("JURIDICA")) {
                                customerC.setTipoPessoa(TipoPessoaEnum.JURIDICA);
                            } else {
                                customerC.setTipoPessoa(TipoPessoaEnum.FISICA);
                            }
                            break;
                        case 8:
                            customerC.setRazaoSocial(cell.getStringCellValue());
                            break;
                        case 9:
                            customerC.setFantasia(cell.getStringCellValue());
                            break;
                        case 10:
                            if (cell.getCellType() == CellType.STRING) {
                                customerC.setCpfCnpj(cell.getStringCellValue());
                            }
                            else{
                                customerC.setCpfCnpj(String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        case 11:
                            customerC.setLimit(cell.getNumericCellValue());
                            break;
                        case 12:
                            if (cell.getCellType() == CellType.STRING) {
                                customerC.setRgIe(cell.getStringCellValue());
                            } else {
                                customerC.setRgIe(String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        case 13:
                            customerC.setEmail(cell.getStringCellValue());
                            break;
                        case 14:
                            customerC.setEhSimples(cell.getStringCellValue().equals("S") || cell.getStringCellValue().equals("s"));
                            break;
                        case 15:
                            if(cell.getCellType() == CellType.STRING) {
                                customerC.setCelular(cell.getStringCellValue());
                            }
                            else{
                                customerC.setCelular(String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        case 16:
                            customerC.setFone(cell.getStringCellValue());
                            break;
                        case 17:
                            customerC.setObservacao(cell.getStringCellValue());
                            break;
                        case 18:
                            if (cell.getCellType() ==  CellType.STRING){
                                customerC.setSuframa(Integer.parseInt(cell.getStringCellValue()));
                            }
                            else {
                                customerC.setSuframa((int) cell.getNumericCellValue());
                            }
                            break;
                        default:
                            System.out.println("Default");
                    }
                }
                customerC.getEnderecos().add(endereco);
                customerList.add(customerC);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
    }
}

