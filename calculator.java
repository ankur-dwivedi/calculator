import java.io.*;
class calculator{
	public static void main(String args[])throws IOException,Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string value for number");
		String numbers=br.readLine();
		calculator ob=new calculator();
		
		  // System.out.println(ob.Add("//[;][@][##]\n1;2@10##5")); // for testing uncomment this to write new line in cmd	
		 System.out.println(ob.Add(numbers));

	}
	int Add(String numbers)throws Exception
	{
		int sum=0;

		if(numbers.equals(""))
			sum=0;
		else if(numbers.length()==1)
			return Integer.parseInt(numbers);
		else  if(numbers.length()>1){
			if(numbers.substring(0,2).equals("//")){		

				String newline="\n";
				if(numbers.indexOf(newline)!=-1){
					String regex="";
					if(numbers.charAt(2)!='[')
					regex=numbers.substring(2,numbers.indexOf(newline));
					else
					regex=findRegex(numbers.substring(2,numbers.indexOf(newline)));

					numbers=numbers.substring(numbers.indexOf(newline)+1);
					String s[]=numbers.split(regex);
					for(int x=0;x<s.length;x++){
						if(!s[x].equals("")){
							if(Integer.parseInt(s[x])<0){
						        	negativeNumber(numbers,regex);
							}
							else{
								if(Integer.parseInt(s[x])<=1000)
								sum=sum+Integer.parseInt(s[x]);
							}
						}
			
					}	
				}else{
					System.out.println("Format icorrect new line(\\n) not found");
				}
			}
			else{
				String regex=",|\n|_";
				String s[]=numbers.split(regex);
				for(int x=0;x<s.length;x++){
					if(!s[x].equals("")){
						if(Integer.parseInt(s[x])<0){
						        	negativeNumber(numbers,regex);
								
							}
							else{
								if(Integer.parseInt(s[x])<=1000)
								sum=sum+Integer.parseInt(s[x]);
							}
							
				}
				
				}		
			}
		}
		return sum;

	}
	void negativeNumber(String numbers,String regex)throws Exception{ 
		String s[]=numbers.split(regex),negative="";
		for(int x=0;x<s.length;x++){
			if(!s[x].equals("")){
				if(Integer.parseInt(s[x])<0)
					negative=negative+" "+s[x];
			}
				
		}	
		Exception Negative=new  Exception("negatives not allowed "+negative.trim());
		throw Negative;	
	}
	String findRegex(String numbers){
		numbers=numbers.substring(1,numbers.length()-1);
		for(int x=0;x<numbers.length();x++){
			char c=numbers.charAt(x);
			if(c==']'||c=='[')
				numbers=numbers.substring(0,x)+"123"+numbers.substring(x+1);
		}
		String regex="",reg="123123";
		String s[]=numbers.split(reg);
		for(int x=0;x<s.length;x++){
				regex=regex+"|"+s[x];
		}	
		return regex.substring(1);
	}
}