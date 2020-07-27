import java.io.FileInputStream;
import java.io.IOException;

public class File {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=new FileInputStream("D:\\ETC\\ETC文档\\稽核系统测试规划.docx");
        int read = fileInputStream.read();
    }
}
