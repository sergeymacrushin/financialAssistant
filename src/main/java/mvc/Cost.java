package mvc;


import java.io.*;
import java.util.Scanner;

public class Cost implements Serializable {
    private int sumRub;
    private CategoryOfCosts category;
    public Cost(int sumRub, CategoryOfCosts category) {
        this.sumRub = sumRub;
        this.category = category;
    }
    public int getSumRub() {
        return sumRub;
    }
    public CategoryOfCosts getCategory(){
        return category;
    }
    public static Cost load(String s, Scanner scan)throws Exception
    {
        FileReader in = new FileReader(s);
        CategoryOfCosts category = CategoryOfCosts.load(scan, s);
        int sumRub = scan.nextInt();
        in.close();
        return new Cost(sumRub, category);
    }
    public static void save(Cost cost, String s) throws IOException
    {
        File file = new File(s);
        file.createNewFile();
        FileWriter out = new FileWriter(s);
        out.write(cost.toString());
        out.flush();
        out.close();

    }

    @Override
    public String toString() {
        return  new StringBuilder().append(category).append(' ').append(sumRub).toString();
    }
}
