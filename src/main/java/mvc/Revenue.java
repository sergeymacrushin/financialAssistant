package mvc;

import java.io.*;
import java.util.Scanner;

public class Revenue implements Serializable {
    private int sumRub;
    private CategoryOfRevenue category;

    public Revenue(int sumRub, CategoryOfRevenue category) {
        this.sumRub = sumRub;
        this.category = category;

    }

    public int getSumRub() {
        return sumRub;
    }
    public CategoryOfRevenue getCategory(){
        return category;
    }
    public static Revenue load(String s, Scanner scan)throws Exception
    {
        FileReader in = new FileReader(s);
        CategoryOfRevenue category = CategoryOfRevenue.load(scan, s);
        int sumRub = scan.nextInt();
        in.close();
        return new Revenue(sumRub, category);
    }
    public static void save(Revenue revenue, String s) throws IOException
    {
        File file = new File(s);
        file.createNewFile();
        FileWriter out = new FileWriter(s);
        out.write(revenue.toString());
        out.flush();
        out.close();

    }

    @Override
    public String toString() {
        return  new StringBuilder().append(category).append(' ').append(sumRub).toString();
    }
}

