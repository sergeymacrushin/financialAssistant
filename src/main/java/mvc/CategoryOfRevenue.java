package mvc;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class CategoryOfRevenue implements Serializable {
    private String category;
    public CategoryOfRevenue(String category)
    {
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
    public static CategoryOfRevenue load(Scanner scan, String s) throws IOException
    {
        FileReader in = new FileReader(s);
        String type = scan.next();
        in.close();
        return new CategoryOfRevenue(type);
    }
    @Override
    public String toString(){
        return new StringBuilder().append(category).toString();
    }

}
