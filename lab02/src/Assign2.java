import java.io.*;
public class Assign2 {
	public static void main(String args[])
	{
		String dict = "D:\\Java Lab\\lab02\\csx-351-hw2-rooiam09-master\\HW2-dictionary.txt";
		String keywds="D:\\Java Lab\\lab02\\csx-351-hw2-rooiam09-master\\HW2-keywords.txt";
		
        int kcount=0;
        try{
               BufferedReader dbr=new BufferedReader(new FileReader(dict));
               BufferedReader kbr=new BufferedReader(new FileReader(keywds));
               FileWriter fileWriter = new FileWriter("D:\\Java Lab\\lab02\\HW2-output-16103067.txt");
               BufferedWriter writer = new BufferedWriter(fileWriter);
               String dic[]=new String [16000];
               String key[]=new String [84];
               
             for(int i=0;i<16000;i++)
             {
            	 dic[i]=dbr.readLine();					//store them in array
             }
             for(int i=0;i<84;i++)
             {
            	 key[i]=kbr.readLine();					//store them in array
             }
             
             String tempStr,temp;
             for (int t = 0; t < 16000 - 1; t++) {
                 for (int i= 0; i < 16000 - t-1; i++) {		//bubble sort
                     if(dic[i+1].compareTo(dic[i])<0) {		//comparing them using compareTo whic returns integer value 
                         tempStr = dic[i];					
                         dic[i] = dic[i + 1];
                         dic[i + 1] = tempStr;
                      }
                 }   
             }
             
             for (int t = 0; t < 84 - 1; t++) {					//bubble sort	
                 for (int i= 0; i < 84 - t-1; i++) {
                     if(key[i+1].compareTo(key[i])<0) {			//sorting the strings in array
                         temp = key[i];
                         key[i] = key[i + 1];
                         key[i + 1] = temp;
                      }
                 }  
             }
             int flag=0;
             try {
            	 for(int t=0;t<84;t++)
            	 {
            		 for(int i=0;i<16000;i++)
            		 {
            			 if(key[t].equals(dic[i])) {			//matching words from keywords file to dictionary file & equals returns boolean 
            			 flag=1;								//if match found flag is set
            			 }
            		 }
            		 if(flag==0) {							
            			 writer.write("Keyword not found: " + key[t] );	 
            			 writer.newLine();						//if match not found flag is reset and count is increased for counting unmatched words
            			 kcount++;
            		 }
            		 flag=0;									//flag is again reset to 0 for first case
            	 }
            	 writer.newLine();
            	 writer.write("No. of keywords not found: "+ kcount);
            	 writer.close();
            	 kbr.close();
            	 dbr.close();
             }
             
             catch (Exception e) {
                 System.out.println("Exception occurred");
              }
        }
             
        catch(FileNotFoundException fne){
        fne.printStackTrace();
        }
        catch(IOException io){
        io.printStackTrace();
        }
	}
}
