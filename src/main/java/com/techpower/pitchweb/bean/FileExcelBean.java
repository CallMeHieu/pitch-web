package com.techpower.pitchweb.bean;

import lombok.Getter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.io.InputStream;

@Getter
@ManagedBean
@ViewScoped
public class FileExcelBean extends BaseBean {
    private final String title = "Load file";

//    public StreamedContent getFile() {
//        return Excel.getFile(sourceFileId, sourceFile);
//    }

    public void handleUploadExcel(FileUploadEvent event) {
        if (!event.getFile().getFileName().endsWith("xlsx")) {
            addWarning("Không phải file excel hoặc sai định dạng mở rộng .xlsx");
            return;
        }
        if (event.getFile() == null) {
            addWarning("Đã xảy ra lỗi khi đọc file!");
            return;
        }
        try {
            InputStream inputStream = event.getFile().getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream);

            //Lấy sheet đầu tiên
            Sheet sheet = workbook.getSheetAt(0);
            addMessage("Oke bạn ê");
            System.out.println("ok");
            //Kiểm tra file có giống file mẫu hay không
        } catch (IOException e) {
            addWarning("Đã xảy ra lỗi khi đọc file!");
        }
    }
}
