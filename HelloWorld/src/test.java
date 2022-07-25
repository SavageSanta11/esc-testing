import static com.example.helloworld.HelloWorld.compare_csv;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;
import com.example.helloworld.*;
public class test{
    @Test
    public void test1() throws IOException{
        Scanner csv1 = new Scanner(new File("./src/t1f1.csv"));

        Scanner csv3 = new Scanner(new File("./src/t1f2.csv"));

        compare_csv(csv1, csv3);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/t1r1.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),true);
    }
    @Test
    public void test2() throws IOException{
        Scanner csv1 = new Scanner(new File("./src/t2f1.csv"));

        Scanner csv3 = new Scanner(new File("./src/t2f2.csv"));

        compare_csv(csv1, csv3);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/t2r1.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),true);
    }

    @Test
    public void test3() throws IOException{
        Scanner csv1 = new Scanner(new File("./src/t2f2.csv"));

        Scanner csv3 = new Scanner(new File("./src/t2f1.csv"));

        compare_csv(csv1, csv3);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/t2r1.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),true);
    }

    @Test
    public void test4() throws IOException{
        Scanner csv1 = new Scanner(new File("./src/t3f1.csv"));

        Scanner csv3 = new Scanner(new File("./src/t3f2.csv"));

        compare_csv(csv1, csv3);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/t3r1.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),true);
    }
    @Test
    public void test5() throws IOException{
        Scanner csv1 = new Scanner(new File("./src/sample_file_1.csv"));

        Scanner csv3 = new Scanner(new File("./src/sample_file_3.csv"));

        compare_csv(csv1, csv3);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/t5r1.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),false);
    }
    @Test
    public void test6() throws IOException{
        Scanner csv1 = new Scanner(new File("C:\\Users\\GigaB\\IdeaProjects\\HelloWorld\\src\\sample_file_1.csv"));

        Scanner csv3 = new Scanner(new File("C:\\Users\\GigaB\\IdeaProjects\\HelloWorld\\src\\sample_file_3.csv"));

        compare_csv(csv1, csv3);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/t5r1.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),false);
    }

    @Test
    public void test7() throws IOException{
        try {

        Scanner csv1 = new Scanner(new File("sample_file_1.csv"));
        Scanner csv3 = new Scanner(new File("sample_file_3.csv"));

        compare_csv(csv1, csv3);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/t5r1.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),false);

    }catch(FileNotFoundException e){
            System.out.println("Invalid pathnames");
        }
    }

    @Test
    public void test8() throws IOException{
        try {

            Scanner csv1 = new Scanner(new File("./.idea/sample_file_1.csv"));
            Scanner csv3 = new Scanner(new File("./.idea/sample_file_3.csv"));

            compare_csv(csv1, csv3);

            File file1 = new File("./src/result.csv");
            File file2 = new File("./src/t5r1.csv");
            assertEquals(FileUtils.contentEquals(file1, file2),false);

        }catch(FileNotFoundException e){
            System.out.println("Invalid pathnames");
        }
    }

    @Test
    public void main() throws IOException {

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }
}