import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileTest {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Administrator\\Desktop\\仙宫章节";
        File file = new File(path);        //获取其file对象
        List<File> list = new ArrayList<>();
        list.addAll(Arrays.asList(file.listFiles()));
        //写入中文字符时解决中文乱码问题
        int start = 0;
        int end = 0;

        list.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String tmp1 = o1.getName();
                tmp1 = tmp1.substring(0, tmp1.indexOf("."));
                tmp1 = tmp1.replaceAll("LCP ", "30");
                tmp1 = tmp1.replaceAll("剑指 Offer II ", "50");
                tmp1 = tmp1.replaceAll("剑指 Offer ", "40");

                tmp1 = tmp1.replaceAll("面试题 ", "60");
                tmp1 = tmp1.replaceAll("LCS ", "670");
                String tmp2 = o2.getName();
                tmp2 = tmp2.substring(0, tmp2.indexOf("."));
                tmp2 = tmp2.replaceAll("LCP ", "30");
                tmp2 = tmp2.replaceAll("剑指 Offer II ", "50");
                tmp2 = tmp2.replaceAll("剑指 Offer ", "40");

                tmp2 = tmp2.replaceAll("面试题 ", "60");
                tmp2 = tmp2.replaceAll("LCS ", "70");

                Integer tp1 = 0;
                Integer tp2 = 0;
                if (tmp1.contains("- I")) {

                    tmp1 = tmp1.replaceAll(" - III", "3");
                    tmp1 = tmp1.replaceAll("- III", "3");
                    tmp1 = tmp1.replaceAll(" - II", "2");
                    tmp1 = tmp1.replaceAll("- II", "2");
                    tmp1 = tmp1.replaceAll(" - I", "1");
                    tmp1 = tmp1.replaceAll("- I", "1");
                    tp1 = Integer.parseInt(tmp1.trim());
                } else {
                    tp1 = Integer.parseInt(tmp1.trim()) * 10;
                }
                if (tmp2.contains("- I")) {
                    tmp2 = tmp2.replaceAll(" - III", "3");
                    tmp2 = tmp2.replaceAll("- III", "3");
                    tmp2 = tmp2.replaceAll(" - II", "2");
                    tmp2 = tmp2.replaceAll("- II", "2");
                    tmp2 = tmp2.replaceAll(" - I", "1");
                    tmp2 = tmp2.replaceAll("- I", "1");
                    tp2 = Integer.parseInt(tmp2.trim());
                } else {
                    tp2 = Integer.parseInt(tmp2.trim()) * 10;
                }
                return tp1 > tp2 ? 1 : -1;
            }
        });
        int count = 0;
        int fileCount = 0;
        BufferedWriter bw = null;
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        for (int i = 0; i < list.size(); i++) {  //遍历File[]数组
            File f = list.get(i);
            if (count ++ % 125 == 0) {
                fileCount++;
                 fos = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\leetcode" + count + "-" +  fileCount*125 + ".md"));
                 osw = new OutputStreamWriter(fos, "UTF-8");
                bw = new BufferedWriter(osw);
            }else {
                if (!f.isDirectory()) {
                    //若非目录(即文件)，则判断是不是 html 文件 不是的话就删除
                    if (f.getName().contains(".md")) {
                        try {
                            InputStreamReader read = new InputStreamReader(new FileInputStream(f), "UTF-8");
                            BufferedReader reader = new BufferedReader(read);
                            String line;
                            while ((line = reader.readLine()) != null) {
                                bw.write(line + "\t\n");
                            }
                            read.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

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
