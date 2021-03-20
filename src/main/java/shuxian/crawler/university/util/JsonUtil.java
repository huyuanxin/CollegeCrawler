package shuxian.crawler.university.util;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * @author huyuanxin
 */
public class JsonUtil {
    public static boolean createJsonFile(JSONObject json, String fileName) {
        String content = JSONObject.toJSONString(json);
        boolean flag = true;
        try {
            File file = new File("src\\main\\json\\" + fileName + ".json");
            if (!file.getParentFile().exists()) {
                flag = file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                flag = file.delete();
            }
            flag = file.createNewFile();
            // 将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            write.write(content);
            write.flush();
            write.close();
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
    }
}
