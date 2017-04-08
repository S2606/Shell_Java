import java.io.*;
import java.lang.Runtime;
import java.util.*;
import java.net.*;
public class shelljava
{
    public static void main(String args[])throws IOException
    {
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your git remote url");//Accepting URL
            String u=br.readLine();
            URL url=new URL(u);
            //System.out.println("Enter your commit sentence");//Commit line
            String commit="make it better";
            System.out.println("Get ready for your code to be on github in few minutes..");
            String comd[]=new String[6];
            comd[0]="git init";
            comd[1]="git add .";
            comd[2]="git commit -m \""+commit+"\"";
            comd[3]="git remote add origin "+url;
            comd[4]="git push -f origin master";
            for(int i=0;i<5;i++)
            {
                String cmd=comd[i];
                Runtime run = Runtime.getRuntime();
                Process pr = run.exec(cmd);
                pr.waitFor();
                BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                String line = "";
                while ((line=buf.readLine())!=null) {
                    System.out.println(line);
                }
            }
            System.out.println("Uploaded on github..");
        }catch(InterruptedException e){

        }
    }
}
