
import java.io.*;
public class x_and_o
{
    InputStreamReader read=new InputStreamReader(System.in);
    BufferedReader in=new BufferedReader(read);
    char s[]=new char[10];
    String p1;
    String p2;
    //scores
    static int s1;
    static int s2;
    void initiate()
    {
        for(int i=0;i<10;i++)
        {
            s[i]=' ';
        }
    }

    int readint()throws IOException
    {
        boolean flag=false;
        int a=0;
        do
        {
            try
            {
                flag=false;
                a=Integer.parseInt(in.readLine());
            }
            catch(NumberFormatException ex)
            {
                System.out.println("\t\tWrong Input,Enter a number");
                System.out.print("\t\t");
                flag=true;
            }
        }while(flag);
        return a;
    }

    char readxo()throws IOException
    {
        String x="";
        char m=0;
        boolean flag=false;
        do
        {
            flag=false;
            try
            {
                x=in.readLine();
                m=x.charAt(0);
                m=Character.toUpperCase(m);
            }
            catch(Exception e)
            {
                flag=true;
            }
            if(x.length()>1)
            {
                System.out.println("\t\tWrong Input, Enter only 'X' or 'O'");
                System.out.print("\t\t");
                flag=true;
            }
            else if(m!='X' && m!='O')
            {
                System.out.println("\t\tWrong Input, Enter only 'X' or 'O'");
                System.out.print("\t\t");
                flag=true;
            }

        }while(flag);
        return m;
    }

    void display(int cs)throws IOException
    {
        System.out.println("\f");  
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }

        catch (final Exception e)
        {
            //  Handle any exceptions.
        }

        System.out.println("\t\t  ==== Tic Tac Toe ====                 © Makjets Studios");
        System.out.println("\t\t         X and O \n");
        System.out.print("\t   Score- ");
        if(cs==1)
            System.out.print("   "+p1+" : "+s1+" || "+"Comp : "+s2);
        else  if(cs==2)
            System.out.print("   "+p1+" : "+s1+" || "+p2+" : "+s2 );
        System.out.println();
        System.out.println("\t 1           |2           |3");
        System.out.println("\t       "+s[1]+"     |      "+s[2]+"     |      "+s[3]);
        System.out.println("\t_____________|____________|______________                     ");
        System.out.println("\t4            |5           |6");
        System.out.println("\t       "+s[4]+"     |      "+s[5]+"     |      "+s[6]+"       ");
        System.out.println("\t_____________|____________|______________");
        System.out.println("\t7            |8           |9");
        System.out.println("\t       "+s[7]+"     |      "+s[8]+"     |      "+s[9]+"       ");
        System.out.println("\t             |            |");

    }

    void accept(char xo,String sp)throws IOException
    {
        System.out.println("\t"+sp+" Enter the number of square to place "+xo+" ->");
        System.out.print("\t\t");
        int x=readint();

        while(true)
        {
            if(x<1 || x>9)
            {
                System.out.println("\tWrong input, please enter number between 1 & 9");
                System.out.print("\t\t");
                x=readint();
            }
            else if(s[x]=='X' || s[x]=='O')
            {
                System.out.println("\tWrong input, Please enter the space which is not occupied");
                System.out.print("\t\t");
                x=readint();
            }
            else
            {
                s[x]=xo;
                break;
            }
        }
    }

    boolean win(char xo)
    {
        if(s[1]==xo && s[2]==xo && s[3]==xo)
        {
            return true;
        }
        if(s[4]==xo && s[5]==xo && s[6]==xo)
        {
            return true;
        }
        if(s[7]==xo && s[8]==xo && s[9]==xo)
        {
            return true;
        }
        if(s[1]==xo && s[4]==xo && s[7]==xo)
        {
            return true;
        }
        if(s[2]==xo && s[5]==xo && s[8]==xo)
        {
            return true;
        }
        if(s[3]==xo && s[6]==xo && s[9]==xo)
        {
            return true;
        }
        if(s[1]==xo && s[5]==xo && s[9]==xo)
        {
            return true;
        }
        if(s[3]==xo && s[5]==xo && s[7]==xo)
        {
            return true;
        }
        return false;
    }

    void compAI(char x,int d)
    {
        char o=0;
        int p;
        if(x=='X')
        {
            o='O';
        }
        else if(x=='O')
        {
            o='X';
        }
        System.out.print("\t\tComputer is playing "+x+" -");
        do
        {
            p=(int)((Math.random()*9)+1);
            System.out.print("-"); 
        }
        while(s[p]=='X' || s[p]=='O'); 
        if(d==2)
        {
            System.out.print("-"); 
            //first set
            if(s[1]==o && s[2]==o)
            {
                if(s[3]!=x && s[3]!=o)
                    p=3;
            }
            if(s[4]==o && s[5]==o)
            {
                if(s[6]!=x && s[6]!=o)
                    p=6;
            }
            if(s[7]==o && s[8]==o)
            {
                if(s[9]!=x && s[9]!=o)
                    p=9;
            }
            if(s[2]==o && s[3]==o)
            {
                if(s[1]!=x && s[1]!=o)
                    p=1;
            }
            if(s[5]==o && s[6]==o)
            {
                if(s[4]!=x && s[4]!=o)
                    p=4;
            }
            if(s[8]==o && s[9]==o)
            {
                if(s[7]!=x && s[7]!=o)
                    p=7;
            }
            if(s[1]==o && s[3]==o)
            {
                if(s[2]!=x && s[2]!=o)
                    p=2;
            }
            if(s[4]==o && s[6]==o)
            {
                if(s[5]!=x && s[5]!=o)
                    p=5;
            }
            if(s[7]==o && s[9]==o)
            {
                if(s[8]!=x && s[8]!=o)
                    p=8;
            }
            if(s[1]==o && s[4]==o)
            {
                if(s[7]!=x && s[7]!=o)
                    p=7;
            }
            if(s[2]==o && s[5]==o)
            {
                if(s[8]!=x && s[8]!=o)
                    p=8;
            }
            if(s[3]==o && s[6]==o)
            {
                if(s[9]!=x && s[9]!=o)
                    p=9;
            }
            if(s[4]==o && s[7]==o)
            {
                if(s[1]!=x && s[1]!=o)
                    p=1;
            }
            if(s[5]==o && s[8]==o)
            {
                if(s[2]!=x && s[2]!=o)
                    p=2;
            }
            if(s[6]==o && s[9]==o)
            {
                if(s[3]!=x && s[3]!=o)
                    p=3;
            }
            if(s[1]==o && s[7]==o)
            {
                if(s[4]!=x && s[4]!=o)
                    p=4;
            }
            if(s[8]==o && s[2]==o)
            {
                if(s[5]!=x && s[5]!=o)
                    p=5;
            }
            if(s[3]==o && s[9]==o)
            {
                if(s[6]!=x && s[6]!=o)
                    p=6;
            }
            if(s[1]==o && s[5]==o)
            {
                if(s[9]!=x && s[9]!=o)
                    p=9;
            }
            if(s[3]==o && s[5]==o)
            {
                if(s[7]!=x && s[7]!=o)
                    p=7;
            }
            if(s[7]==o && s[5]==o)
            {
                if(s[3]!=x && s[3]!=o)
                    p=3;
            }
            if(s[5]==o && s[9]==o)
            {
                if(s[1]!=x && s[1]!=o)
                    p=1;
            }
            if(s[1]==o && s[9]==o)
            {
                if(s[5]!=x && s[5]!=o)
                    p=5;
            }
            if(s[3]==o && s[7]==o)
            {
                if(s[5]!=x && s[5]!=o)
                    p=5;
            }        
            //next set
            System.out.print("-"); 
            if(s[1]==x && s[2]==x)
            {
                if(s[3]!=x && s[3]!=o)
                    p=3;
            }
            if(s[4]==x && s[5]==x)
            {
                if(s[6]!=x && s[6]!=o)
                    p=6;
            }
            if(s[7]==x && s[8]==x)
            {
                if(s[9]!=x && s[9]!=o)
                    p=9;
            }
            if(s[2]==x && s[3]==x)
            {
                if(s[1]!=x && s[1]!=o)
                    p=1;
            }
            if(s[5]==x && s[6]==x)
            {
                if(s[4]!=x && s[4]!=o)
                    p=4;
            }
            if(s[8]==x && s[9]==x)
            {
                if(s[7]!=x && s[7]!=o)
                    p=7;
            }
            if(s[1]==x && s[3]==x)
            {
                if(s[2]!=x && s[2]!=o)
                    p=2;
            }
            if(s[4]==x && s[6]==x)
            {
                if(s[5]!=x && s[5]!=o)
                    p=5;
            }
            if(s[7]==x && s[9]==x)
            {
                if(s[8]!=x && s[8]!=o)
                    p=8;
            }
            if(s[1]==x && s[4]==x)
            {
                if(s[7]!=x && s[7]!=o)
                    p=7;
            }
            if(s[2]==x && s[5]==x)
            {
                if(s[8]!=x && s[8]!=o)
                    p=8;
            }
            if(s[3]==x && s[6]==x)
            {
                if(s[9]!=x && s[9]!=o)
                    p=9;
            }
            if(s[4]==x && s[7]==x)
            {
                if(s[1]!=x && s[1]!=o)
                    p=1;
            }
            if(s[5]==x && s[8]==x)
            {
                if(s[2]!=x && s[2]!=o)
                    p=2;
            }
            if(s[6]==x && s[9]==x)
            {
                if(s[3]!=x && s[3]!=o)
                    p=3;
            }
            if(s[1]==x && s[7]==x)
            {
                if(s[4]!=x && s[4]!=o)
                    p=4;
            }
            if(s[8]==x && s[2]==x)
            {
                if(s[5]!=x && s[5]!=o)
                    p=5;
            }
            if(s[3]==x && s[9]==x)
            {
                if(s[6]!=x && s[6]!=o)
                    p=6;
            }
            if(s[1]==x && s[5]==x)
            {
                if(s[9]!=x && s[9]!=o)
                    p=9;
            }
            if(s[3]==x && s[5]==x)
            {
                if(s[7]!=x && s[7]!=o)
                    p=7;
            }
            if(s[7]==x && s[5]==x)
            {
                if(s[3]!=x && s[3]!=o)
                    p=3;
            }
            if(s[5]==x && s[9]==x)
            {
                if(s[1]!=x && s[1]!=o)
                    p=1;
            }
            if(s[1]==x && s[9]==x)
            {
                if(s[5]!=x && s[5]!=o)
                    p=5;
            }
            if(s[3]==x && s[7]==x)
            {
                if(s[5]!=x && s[5]!=o)
                    p=5;
            }
        }
        System.out.print("-"); 
        s[p]=x;
    }

    void guide()throws IOException
    {
        System.out.println("\f");
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }

        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
        System.out.println();
        System.out.println("\t\t  ==== Tic Tac Toe ====                 © Makjets Studios");
        System.out.println("\t\t         X and O \n");
        System.out.println("\t\t------------------------ ");
        System.out.println("\t\t       Quick guide ");
        System.out.println("\t\t------------------------  ");
        System.out.println("\t -The game board consists of a 3x3 grid ");
        System.out.println("\t -Players in this game place their character \'X\' or \'O\' ");
        System.out.println("\t      one by one in any of the empty box ");
        System.out.println("\t -\'X\' Starts first ");
        System.out.println("\t -The player who gets any three of his characters in a line wins ");
        System.out.println("\t\t------------------------ ");
        System.out.println("\t\t   Eg.- ");
        System.out.println("     X|   |         O| O |O        X|   |          |   |O  ");
        System.out.println("   ---|---|---    ---|---|---    ---|---|---    ---|---|---       ");
        System.out.println("     X|   |          |   |          | X |          | O |        ");
        System.out.println("   ---|---|---    ---|---|---    ---|---|---    ---|---|---             ");
        System.out.println("     X|   |          |   |          |   |X        O|   |              ");
        System.out.println("\t\t------------------------");
        System.out.println("\t\tPress Enter to return to main menu");
        System.out.print("\t\t");
        String blank=in.readLine();

    }

    public static void main(String[] args)throws IOException 
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        x_and_o ob=new x_and_o();
        char ox=0;
        int b=0;
        int ch;
        do
        {

            ob.initiate();
            System.out.println("\t\t\f");
            try
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }

            catch (final Exception e)
            {
                //  Handle any exceptions.
            }
            System.out.println("\t\t   !!!   WELCOME   !!! ");                        
            System.out.println("\t\t  ==== Tic Tac Toe ====                © Makjets Studios");
            System.out.println("\t\t         X and O \n");
            System.out.println("\t\t------------------------ ");
            System.out.println("\t\t   Main Menu             ");
            System.out.println("\t\t   1.Single Player         ");
            System.out.println("\t\t   2.Double Player       ");
            System.out.println("\t\t   3.Quick guide    ");
            System.out.println("\t\t   4.About the Developer     ");  
            System.out.println("\t\t   5.Exit ");
            System.out.println("\t\t-------------------------\n");
            System.out.println("\t\tEnter the number of your choice->");
            System.out.print("\t\t");
            ch=ob.readint();
            while(!(ch>0 && ch<=5))
            {
                System.out.println("\t\tWrong choice");
                System.out.print("\t\t");
                ch=ob.readint();
            }
            switch(ch)
            {
                case 1:
                System.out.println("\t\t\f");
                try
                {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                }

                catch (final Exception e)
                {
                    //  Handle any exceptions.
                }
                System.out.println("\t\t  ==== Tic Tac Toe ====                 © Makjets Studios");
                System.out.println("\t\t         X and O \n");
                System.out.println();
                System.out.println("\t\t--------------------------- ");
                System.out.println("\t\tEnter Player Name ->");
                System.out.print("\t\t");
                ob.p1=in.readLine();
                System.out.println("\t\t--------------------------- ");
                System.out.println("\t\tEnter difficulty level ->");
                System.out.println("\t\t1. for Sandbox");
                System.out.println("\t\t2. for normal");
                System.out.println("\t\t--------------------------- ");
                System.out.print("\t\t");
                int dif=ob.readint();;
                while(!(dif==1 || dif==2))
                {
                    System.out.println("\t\tWrong Input, enter eiter 1 or 2");
                    System.out.print("\t\t");
                    dif=ob.readint();
                }
                System.out.println("\t\t--------------------------- ");

                do
                {
                    ob.initiate();
                    System.out.println("\t\t"+ob.p1+" Enter X or O to play as X and O respectively ->"); 
                    System.out.print("\t\t");
                    ox=ob.readxo();
                    for(int i=1;i<=5;i++)
                    {

                        if(ox=='X')
                        {
                            ob.display(ch);
                            ob.accept(ox,ob.p1);
                            ob.display(ch);
                            if(ob.win(ox))
                            {
                                s1++;
                                ob.display(ch);
                                System.out.println("\t\t"+ob.p1+" Wins!!");
                                break;
                            }
                        }
                        else
                        {                                              
                            ob.compAI('X',dif);
                            ob.display(ch);
                            if(ob.win('X'))
                            {
                                s2++;
                                ob.display(ch);
                                System.out.println("\t\t"+ob.p1+" Loses!!");

                                break;
                            }

                        }
                        if(i==5)
                        {
                            ob.display(ch);
                            System.out.println("\t\tIts a Draw");
                            break;

                        }
                        if(ox=='O')
                        {
                            ob.display(ch);
                            ob.accept(ox,ob.p1);
                            ob.display(ch);
                            if(ob.win(ox))
                            {
                                s1++;
                                ob.display(ch);
                                System.out.println("\t\t"+ob.p1+" Wins!!");

                                break;
                            }
                        }
                        else
                        {
                            ob.compAI('O',dif);
                            ob.display(ch);
                            if(ob.win('O'))
                            {                       
                                s2++;
                                ob.display(ch);
                                System.out.println("\t\t"+ob.p1+" Loses!!"); 

                                break;
                            }

                        }

                    }
                    System.out.println("\tEnter 1 to play again, any other number to go back to menu");
                    System.out.print("\t\t");
                    b=ob.readint();
                    System.out.println("\t\t\f");
                }while(b==1);
                s1=0;
                s2=0;
                break;
                case 2:
                System.out.println("\t\t\f");
                try
                {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                }

                catch (final Exception e)
                {
                    //  Handle any exceptions.
                }
                System.out.println("\t\t  ==== Tic Tac Toe ====                 © Makjets Studios");
                System.out.println("\t\t         X and O \n");
                System.out.println();
                System.out.println("\t\t--------------------------- ");
                System.out.println("\t\tPlayer 1 enter your name");
                System.out.print("\t\t");
                ob.p1=in.readLine();
                System.out.println("\t\t--------------------------- ");
                System.out.println("\t\tPlayer 2 enter your name");
                System.out.print("\t\t");
                ob.p2=in.readLine();
                System.out.println("\t\t--------------------------- ");
                int chs=1;
                do
                {
                    ob.initiate();
                    if(chs==1)
                    {
                        System.out.println("\t"+ob.p1+" Enter X or O to play as X and O respectively ->");
                        System.out.print("\t\t");
                        ox=ob.readxo();
                        chs=2;
                    }
                    else if(chs==2)
                    {
                        System.out.println("\t"+ob.p2+" Enter X or O to play as X and O respectively ->");
                        System.out.print("\t\t");
                        ox=ob.readxo();
                        ox=(ox=='X')? 'O' : 'X';
                        chs=1;
                    }

                    for(int i=1;i<=5;i++)
                    {

                        if(ox=='X')
                        {
                            ob.display(ch);
                            ob.accept(ox,ob.p1);
                            ob.display(ch);
                            if(ob.win(ox))
                            {
                                s1++;
                                ob.display(ch);
                                System.out.println("\t\t"+ob.p1+" Wins!!");

                                break;
                            }
                        }
                        else
                        {                                              
                            ob.display(ch);
                            ob.accept('X',ob.p2);
                            ob.display(ch);
                            if(ob.win('X'))
                            {
                                s2++;
                                ob.display(ch);
                                System.out.println("\t\t"+ob.p2+" Wins!!");

                                break;
                            }

                        }
                        if(i==5)
                        {
                            ob.display(ch);
                            System.out.println("\t\tIts a Draw");
                            break;

                        }
                        if(ox=='O')
                        {
                            ob.display(ch);
                            ob.accept(ox,ob.p1);
                            ob.display(ch);
                            if(ob.win(ox))
                            {
                                s1++;
                                ob.display(ch);
                                System.out.println("\t\t"+ob.p1+" Wins!!");

                                break;
                            }
                        }
                        else
                        {
                            ob.display(ch);
                            ob.accept('O',ob.p2);
                            ob.display(ch);
                            if(ob.win('O'))
                            {
                                s2++;
                                ob.display(ch);
                                System.out.println("\t\t"+ob.p2+" Wins!!"); 

                                break;
                            }

                        }

                    }
                    System.out.println("\tEnter 1 to play again, any other number to go back to menu");
                    System.out.print("\t\t");
                    b=ob.readint();
                    System.out.println("\f");
                    try
                    {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    }

                    catch (final Exception e)
                    {
                        //  Handle any exceptions.
                    }
                }while(b==1);
                s1=0;
                s2=0;
                break;
                case 3:
                ob.guide();
                break;
                case 4:  
                System.out.println("\f");
                try
                {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                }

                catch (final Exception e)
                {
                    //  Handle any exceptions.
                }
                System.out.println("\t\t  ==== Tic Tac Toe ====                 © Makjets Studios");
                System.out.println("\t\t         X and O \n");
                System.out.println("\t\t--------------------------- ");
                System.out.println("\t\t\tVersion 1.0 \n");
                System.out.println("\t\t    © Makjets studios \n ");
                System.out.println("\t\t--------------------------- ");
                System.out.println("\t\t\tDeveloper: \n");
                System.out.println("\t\t  School   - Smt. Sulochanadevi Singhania School");
                System.out.println("\t\t  Name     - Makarand Madhavi");
                System.out.println("\t\t  Class    - 10-E");
                System.out.println("\t\t  Roll No. - 13\n");
                System.out.println("\t\t--------------------------- ");
                System.out.println();
                System.out.println("\t\tPress Enter to continue");
                System.out.print("\t\t");
                String blank=in.readLine();
                break;
                default:
                System.out.println("\t\twrong choice");
            }
        }while(ch!=5);
        System.out.println("\t\t\f");
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }

        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
        System.out.println("\t\t     Thanks for Playing");
        System.out.println("\t\t  Developer: Makarand Madhavi");
        System.out.println("\t\t       Makjets studios ");
        System.out.println("\t\t\n\n\n\n\n\n");
        System.out.println("\t\t  "+(char)169+" All Copyrights reserved \n\n");
        System.out.println("Press enter to close the terminal window");
        String blank=in.readLine();
        System.exit(0);
    }
}

