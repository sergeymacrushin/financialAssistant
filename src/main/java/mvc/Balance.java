package mvc;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Balance implements Serializable {
    private ArrayList<Cost> costs;
    private ArrayList<Revenue> revenues;

    public Balance(ArrayList<Cost> costs, ArrayList<Revenue> revenues) {
        this.costs = costs;
        this.revenues = revenues;
    }
    public Balance()
    {
        this.costs = new ArrayList<>(0);
        this.revenues = new ArrayList<>(0);
    }

    public int getBalance()
    {
        int temp = 0;
        for (int i=0 ; i < revenues.size(); i++)
        {
            temp += revenues.get(i).getSumRub();
        }
        for (int i=0 ; i < costs.size(); i++)
        {
            temp -= costs.get(i).getSumRub();
        }
        return temp;

    }
    public void addCost(Cost cost)
    {
        this.costs.add(cost);
    }
    public void addRevenue(Revenue revenue)
    {
        this.revenues.add(revenue);
    }

    public ArrayList<Cost> getCosts() {
        return costs;
    }

    public ArrayList<Revenue> getRevenues() {
        return revenues;
    }

    public void setCosts(Cost cost, Cost newCost){
        int index = costs.indexOf(cost);
        costs.set(index, newCost);
    }

    public void setRevenues(Revenue revenue, Revenue newRevenue){
        int index = revenues.indexOf(revenue);
        revenues.set(index, newRevenue);
    }

    public void deleteCost(Cost cost){
        costs.remove(cost);
    }
    public void deleteRevenue(Revenue revenue){
        revenues.remove(revenue);
    }

    public void clearCosts(){
        costs.clear();
    }

    public void clearRevenues(){
        revenues.clear();
    }

    public void clearAll(){
        costs.clear();
        revenues.clear();
    }
    public int sumCostByCategory(String category){
        int sum = 0;
        for(int i = 0; i < costs.size(); i++){
            if(costs.get(i).equals(category)){
                sum += costs.get(i).getSumRub();
            }
        }
        return sum;
    }

    public int sumRevenueByCategory(String category){
        int sum = 0;
        for(int i = 0; i < revenues.size(); i++){
            if(revenues.get(i).equals(category)){
                sum += revenues.get(i).getSumRub();
            }
        }
        return sum;
    }
    public static void save(Balance balance, String s) throws IOException
    {
        File file = new File(s);
        file.createNewFile();
        FileWriter out = new FileWriter(file);
        out.write(new Integer(balance.revenues.size()).toString());
        out.write("\r\n");
        for(int i = 0; i < balance.revenues.size(); i++){
            out.write(balance.revenues.get(i).toString());
            out.write("\r\n");
        }
        out.write(new Integer(balance.costs.size()).toString());
        out.write("\r\n");
        for(int i = 0; i < balance.costs.size(); i++){
            out.write(balance.costs.get(i).toString());
            if(i!= balance.costs.size()-1)
            {
                out.write("\r\n");
            }
        }
        out.flush();
        out.close();
    }
    public static Balance load(String s)throws IOException{
        FileReader in = new FileReader(s);
        Scanner scan = new Scanner(in);
        ArrayList<Revenue> revenues = new ArrayList<>();
        ArrayList<Cost> costs = new ArrayList<>();
        int size = 0;
        try{
            size = scan.nextInt();
            while (size>0) {
                Revenue tmp = Revenue.load(s,scan);
                revenues.add(tmp);
                size--;
            }
            size = scan.nextInt();
            while (size>0) {
                Cost tmp = Cost.load(s,scan);
                costs.add(tmp);
                size--;
            }
        } catch(Exception e) {
            System.out.println("Некорректные данные");
            System.exit(0);
        }
        return new Balance(costs, revenues);
    }
}
