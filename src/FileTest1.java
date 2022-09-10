import java.io.*;

public class FileTest1 {

    public static void main(String[] args) throws IOException {

        String path = "D:\\workspace\\IdeaProjects\\Test\\src\\test";
        File file = new File(path);        //获取其file对象
        //写入中文字符时解决中文乱码问题
        FileOutputStream fos = new FileOutputStream(new File("D:\\workspace\\IdeaProjects\\Test\\src\\test1.text"));
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);

        InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader reader = new BufferedReader(read);
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.matches("第.*章.*")) {
                bw.write("## " + line + "\t\n");
            }else {
                bw.write(line + "\t\n");
            }
        }
        read.close();

        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw.close();
        osw.close();
        fos.close();
    }

    /**
     * 一行一行写入文件，解决写入中文字符时出现乱码
     * <p>
     * 流的关闭顺序：先打开的后关，后打开的先关，
     * 否则有可能出现java.io.IOException: Stream closed异常
     *
     * @throws IOException
     */
    public void writeFile02() throws IOException {
        String[] arrs = {
                "zhangsan,23,福建",
                "lisi,30,上海",
                "wangwu,43,北京",
                "laolin,21,重庆",
                "ximenqing,67,贵州"
        };
        //写入中文字符时解决中文乱码问题
        FileOutputStream fos = new FileOutputStream(new File("E:/phsftp/evdokey/evdokey_201103221556.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        //简写如下：
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
        //        new FileOutputStream(new File("E:/phsftp/evdokey/evdokey_201103221556.txt")), "UTF-8"));

        for (String arr : arrs) {
            bw.write(arr + "\t\n");
        }

        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw.close();
        osw.close();
        fos.close();
    }
}
