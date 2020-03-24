package mvc;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class CategoryOfCosts implements Serializable {
  private String category;
  public CategoryOfCosts(String category)
  {
      this.category = category;
  }

    public String getCategory(){
        return category;
    }
    public static CategoryOfCosts load(Scanner scan, String s) throws IOException
    {
        FileReader in = new FileReader(s);
        String type = scan.next();
        in.close();
        return new CategoryOfCosts(type);
    }
    @Override
    public String toString(){
        return new StringBuilder().append(category).toString();
    }

}
