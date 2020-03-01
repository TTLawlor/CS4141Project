/**
 * Author(s)
 * Tamara Lawlor 19276494
 * Mary Tease 19256434
 * Rachel O'Donoghue 19274505
 */

public class CS4141Project
{
   String[] tabs = new String[256];
   private int nextAvailable = 3;
   private int nextSheetNumber;
   private int indexNumber;
   private int sheetsAvailable;
   int i;
   int index = i + 1;
   
    public void init(){ //initialises first 3 sheets in array
      tabs[0] = "Sheet1";
      tabs[1] = "Sheet2";
      tabs[2] = "Sheet3";
      
   }
   
   //NEEDS TO NOT MAKE DUPLICATES = IF & WHILE STATEMENT?
   public boolean add(){ //adds a sheet to the array
       nextSheetNumber = nextAvailable + 1;
       String x= "Sheet" + Integer.toString(nextSheetNumber);
       if(nextAvailable < tabs.length){ // && tabs[nextSheetNumber] != tabs[i] 
         while(index(x + nextAvailable) == -1){
             tabs[nextAvailable]=x;
             nextAvailable++;
        
             return true;
         }
      }
      return false;
   }

   public void Display(){ //displays the contents of the array
       for(int i=0;i < tabs.length; i++){
          if(tabs[i] != null){
              System.out.print(tabs[i] + " ");
          } 
       }
       System.out.println("");
   }
   
   public int index(String sheetName){ //returns index from sheetname
       for(int i=0;i < nextAvailable - 1; i++){
          if(tabs[i] != null && tabs[i].equalsIgnoreCase(sheetName)){
              System.out.println(i);
              //return i + 1;//if found Sheet2 = 2
              return i; //for Sheet2 = 1
          }
       }
       return -1;//if not found
   }
   
   public int length(){ //returns array length
       sheetsAvailable = tabs.length - nextAvailable;
       System.out.println(tabs.length - sheetsAvailable);
       return tabs.length - sheetsAvailable;
   }
   
   public String sheetName(int index){ //returns sheetname from index
       for(int i=0;i < tabs.length; i++){
           if(i == index){
               return tabs[i - 1]; //if found for 3 = sheet3
               //or return tabs[i]; f or 3 = Sheet4
           }
       }
       return null; //if not found
   }
   //ALLOWS DUPLICATES && index(currentName) != -1 && index(newName) == -1
   public int rename(String currentName, String newName){ //renames a sheet
       for(int i=0;i < tabs.length; i++){
           String temp = "";
           
           if(tabs[i].equalsIgnoreCase(currentName)){
             
               temp = tabs[i].replace(tabs[i], newName);
               tabs[i] = temp;
               return i;// Sheet2 = 1
               //or return i + 1; for Sheets2 = 2
           }
       }
       return -1; 
   }
   
   public int shiftLeft(int index) { //shifts everything ???????
        for(i = index;i < tabs.length - 1; i++) {
            tabs[i] = tabs[i + 1];
        }
        return 0;
   }
   
   public int remove(String sheetName){ //removes a sheet using the sheetname
       for(int i=index;i < tabs.length - 1; i++){
           if(nextAvailable != 1){ 
             if(tabs[i].equalsIgnoreCase(sheetName)){
               shiftLeft(i);
               i = i + 1;
               return i; //if sheet3 returns 3
             }
           }
       }
       return -1; //if not found
   }
   
   public String remove(int index){ //removes a sheet using the index number (user input)
       for(int i=index;i < tabs.length - 1; i++){
           if(tabs.length != 1 && i == index){
               i = i - 1;
               //String temp = tabs[i];
               String x= "Sheet" + Integer.toString(index);
               shiftLeft(i);
               return x; //if 3 returns sheet3
           }
       }
       return null; //if not found
   }
   
   public String moveToEnd(int from){ //moves a sheet to the end of the array using the index number
       for(int i=index;i < tabs.length - 1; i++){
           if(from < tabs.length){
               i = i + 1;
               String temp = "Sheet" + Integer.toString(from);
               remove(from); 
               tabs[nextAvailable - 1] = temp;
               return temp; //if 2 returns sheet 2
           }
       }
       return null; 
   }
    
   public int moveToEnd(String from){ //moves a sheet to the end of the array using the sheetname
       for(int i=index;i < tabs.length - 1; i++){
           if(tabs[i].equalsIgnoreCase(from)){
               i = i + 1;
               String temp = from;
               remove(from);
               tabs[nextAvailable - 1] = temp;
               return i; //if sheet2 returns 2
           }
       }
       return -1;
   }
    
   public int move(String from, String to, boolean before){ //moves a sheet using the sheetnames
         int indexOfFrom = index(from);
         int indexOfTo = index(to);
         String temp = tabs[indexOfFrom];
         if(!from.equalsIgnoreCase(to)){
                if(before == true){
                       if(indexOfFrom < indexOfTo){ 
                       for(int i = indexOfFrom ;i < indexOfTo; i++){
                          tabs[i] = tabs[i + 1];
                       }
                       tabs[indexOfTo - 1] = temp;
                       return indexOfTo - 1;//if true 
                    }else{ 
                        
                       for(int i = indexOfFrom ;i > indexOfTo; i--){
                          tabs[i] = tabs[i - 1];
                       }
                       
                       tabs[indexOfTo] = temp;
                       return indexOfTo;//if true 
                        
                    }
                } else{
                      if(indexOfFrom < indexOfTo){ 
                       for(int i = indexOfFrom ;i < indexOfTo; i++){
                          tabs[i] = tabs[i + 1];
                       }
                       tabs[indexOfTo] = temp;
                       return indexOfTo;//if false
                       
                      } else { 
                         
                       for(int i = indexOfFrom ;i > indexOfTo; i--){
                          tabs[i] = tabs[i - 1];
                       }
                       
                       tabs[indexOfTo + 1] = temp;
                       return indexOfTo + 1;//if false
                    }
                }
         }
         return -1; //if from = to
   }  
   
   public String move(int from, int to, boolean before){ //moves a sheet using the index numbers
          if(from != to && from < nextAvailable){
                if(before == true){
                     if(from < to){
                       String temp = tabs[from - 1];
                       to = to - 1;
                       for(int i = from - 1; i < to; i++){
                          tabs[i] = tabs[i + 1];
                       }
                       tabs[to - 1] = temp;
                       return temp; //if true
                    } else {
                       String temp = tabs[from - 1];
                       to = to - 1;
                       for(int i = from - 1; i > to; i--){
                          tabs[i] = tabs[i - 1];
                       }
                       tabs[to] = temp;
                       return temp; //if true
                    }
                } else{ 
                     if(from < to){
                       String temp = tabs[from - 1];
                       for(int i = from - 1;i < to; i++){
                          tabs[i] = tabs[i + 1];
                       }
                       tabs[to - 1] = temp;
                       return temp; //if false
                    } else { 
                       String temp = tabs[from - 1];
                       for(int i = from - 1;i > to; i--){
                          tabs[i] = tabs[i - 1];
                       }
                       tabs[to] = temp;
                       return temp; //if false
                    }
                }
          }
           return null; //if from = to
   }
}
  
   

 
    
    