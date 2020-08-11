package testing;
import java.util.Scanner;
import java.lang.Math;
import java.util.Formatter;
public class testingPrint {

	static Formatter formatter = new Formatter(System.out);
	public static void main(String[] args) {
		double taxrate = 0.00, subtotal=0.0, total=0.0, tax=0.0;
		System.out.print("input:");
		Scanner scanner = new Scanner(System.in);
		String inputdata = scanner.nextLine();
		scanner.close();
		System.out.println("Output:");
		formatter.format("%-15s %5s %14s\n\n", "item", "price", "qty");
		String[] strarray=inputdata.split(", ");//分割出地點[0],商品[1],商品[2],...
		if(strarray[0].equals("Location: CA")) {
			taxrate = 0.0975;
		}else if(strarray[0].equals("Location: NY")) {
			taxrate = 0.08875;
		}else {
			taxrate = 0;
		};
		for (int i = 1; i < strarray.length; i++) {
			String[] strarray2=strarray[i].split(" ",2);//分割出數量[0],商品價格[1]
			String[] strarray3=strarray2[1].split(" at ",2);//分割出商品[0],價格[1]
			if(strarray3[0].equals("pencils")) {strarray3[0]="pencil";}
			
			formatter.format("%-15s %5s %14s\n", strarray3[0], ("$"+strarray3[1]), strarray2[0]);
			for(int j = 0;j < Integer.parseInt(strarray2[0]);j++) {
			if(strarray3[0].equals("shirt")&& taxrate == 0.0975) {
				tax=tax+(Double.parseDouble(strarray3[1])*taxrate);
			}else if(strarray3[0].equals("book")) {
				tax=tax+(Double.parseDouble(strarray3[1])*taxrate);
			}else if(strarray3[0].equals("pencil")) {
				tax=tax+(Double.parseDouble(strarray3[1])*taxrate);
			}
			subtotal = subtotal + Double.parseDouble(strarray3[1]);
			};
		};
		subtotal=(Math.ceil(subtotal * 100.00) / 100.00);
		formatter.format("%-15s %5s %14s\n", "Subtotal:","", ("$"+subtotal));
		tax=Math.round(tax * 20+0.5) / 20.0;
		tax=(Math.round(tax * 100.00) / 100.00);
		formatter.format("%-15s %5s %14s\n", "tax:","", ("$"+String.format("%.2f",tax)));
		total = (tax+subtotal) ;
		total=(Math.round(total * 100.0) / 100.0);
		formatter.format("%-15s %5s %14s\n", "total:","", ("$"+total));
	}

}
