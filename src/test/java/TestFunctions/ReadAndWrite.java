package TestFunctions;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadAndWrite {

        public JSONObject readJson() throws IOException, ParseException {
            JSONParser parser = new JSONParser();

                Object obj = parser.parse(new FileReader(System.getProperty("user.dir")+"/config/setting.json"));

                JSONObject jsonObject = (JSONObject) obj;
                return jsonObject;

            }

    public void writeFile(List<String> product) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Products");

        int rowCount = 0;

        for (String aBook : product) {
            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;

                Cell cell = row.createCell(columnCount++);
                cell.setCellValue(aBook);
                }

        try (FileOutputStream outputStream = new FileOutputStream("alikemal.xls")) {
            workbook.write(outputStream);
        }
    }
}
