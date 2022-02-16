
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author yb
 * @date 2021/10/20
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String keyWord = "信阳市第一人民医院";
        searchEverything(keyWord);
    }

    public static void searchEverything(String keyWord) throws IOException {
        URL url = new URL("http://www.baidu.com/s?wd="+keyWord);//搜索功能在二级域名中
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("GET");
        // httpURLConnection.setRequestProperty();
        /**
         * 接收数据
         */
        InputStream inputStream = httpURLConnection.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while (true) {
            len = inputStream.read(b);
            if (len == -1) {
                break;
            }
            byteArrayOutputStream.write(b, 0, len);
        }
        System.out.println(byteArrayOutputStream.toString());
    }
}
