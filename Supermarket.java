import java.util.*;
public class Supermarket
{
    static int pid[] = {123, 234, 345, 456, 567, 678, 789, 890, 101, 106};
    static String pname[] = {"Ketchup", "Detergent Powder", "Curd", "Milk", "Water bottle", "Biscuit", "Cola", "Potato Chips", "Coffee powder", "Egg"};
    static int pcost[] = {15, 25, 30, 23, 30, 20, 10, 10, 3, 7};
    static int invoice[] = new int[20];
    public static void main(String[] args)
    {
        String list[] = {"Name", "MRP", "Quanitity", "Cost"};
        Scanner S = new Scanner(System.in);
        int cost, ptr = 0;
        Supermarket smp = new Supermarket();
        String name;
        while(true)
        {
            System.out.println("Enter product id: ");
            int id = S.nextInt();
            invoice[ptr] = id;
            ptr++;
            System.out.println("Enter quantity: ");
            int quantity = S.nextInt();
            invoice[ptr] = quantity;
            ptr++;
            System.out.println("Do you want to continue: (1/0)");
            int res = S.nextInt();
            if(res==0)
                break;
        }
        for(int i=0; i<ptr; i=i+2)
        {
            int index = getindex(invoice[i]);
            invoice[i+1] *= pcost[index];
        }
        int total=0;
        System.out.println("****Invoice****");
        System.out.printf("%-20s %-20s %-20s %-20s%n", list[0], list[1], list[2], list[3]);
        for(int i=0; i<ptr; i=i+2)
        {
            int index = getindex(invoice[i]);
            total += invoice[i+1];
            String name1 = pname[index];
            int mrp = pcost[index];
            int cost1 = invoice[i+1];
            System.out.printf("%-20s %-20d %-20d %-20d%n", name1,mrp,(cost1/mrp),cost1);
        }
        System.out.println("Your total is "+total);
        System.out.println("You have recieved "+(total/100)+" credit points!!!");
    }

	static int getindex (int k)
	{
		for (int i = 0; i < 6; i++)
		{
			if (pid[i] == k)
				return i;
		}
		return -1;
	}
}
