import java.io.*;
class calculator{
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string value for number");
		String numbers=br.readLine();
		calculator ob=new calculator();
		System.out.println(ob.Add(numbers));
	}
	int Add(String numbers)
	{
		int sum=0;

		if(numbers.equals(""))
			sum=0;
		else if(numbers.length()==1)
			return Integer.parseInt(numbers);
		else  if(numbers.length()>1)
		{
			String s[]=numbers.split(",");
			for(int x=0;x<s.length;x++){
				sum=sum+Integer.parseInt(s[x]);
			}
		}
		return sum;

	}
}