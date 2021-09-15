import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chess
{
    static String[][] boardsGame = new String[8][8];

    public static void main(String args[])
    {
        char c = 'A';
        int counter = 8;
        for(int i=0;i<8;i++,counter--)
        {
            c = 'A';
            for(int j=0;j<8;j++,c++)
            {
                String s = "";
                s = s.concat(String.valueOf(c));
                boardsGame[i][j] = s.concat(String.valueOf(counter));
            }
        }

        String start,end;
        Scanner s = new Scanner(System.in);
        start = s.next();
        end = s.next();

        List<String> result = new ArrayList<>();
        cal(start,end,result);

        for(int i=0;i<result.size();i++)
        {
            System.out.print(result.get(i)+" ");
        }
    }
    static boolean cal(String start, String end, List<String> result)
    {
        boolean found = false;
        if(start.equalsIgnoreCase(end))
        {
            result.add(end);
            return true;
        }
        else
        {
            int x=-1,y=-1;
            for(int i=0;i<8 && x<0 && y<0;i++)
            {
                for(int j=0;j<8;j++)
                {
                    if(boardsGame[i][j].equalsIgnoreCase(start))
                    {
                        x=i;
                        y=j;
                    }
                }
            }
            if(x==-1 && y==-1)
                return false;
            if(x-2>=0 && y+1<8)
            {
                if(cal(boardsGame[x-2][y+1],end,result))
                {
                    result.add(boardsGame[x-2][y+1]);
                    found = true;
                }
            }

            if(x-2>=0 && y-1>=0)
            {
                if(cal(boardsGame[x-2][y-1],end,result))
                {
                    result.add(boardsGame[x-2][y-1]);
                    found = true;
                }
            }

            if(x+2<8 && y-1>=0)
            {
                if(cal(boardsGame[x+2][y-1],end,result))
                {
                    result.add(boardsGame[x+2][y-1]);
                    found = true;
                }
            }

            if(x+2<8 && y+1<8)
            {
                if(cal(boardsGame[x+2][y+1],end,result))
                {
                    result.add(boardsGame[x+2][y+1]);
                    found = true;
                }
            }

            if(x-1>=0 && y+2<8)
            {
                if(cal(boardsGame[x-1][y+2],end,result))
                {
                    result.add(boardsGame[x-1][y+2]);
                    found = true;
                }
            }

            if(x-1>=0 && y-2>=0)
            {
                if(cal(boardsGame[x-1][y-2],end,result))
                {
                    result.add(boardsGame[x-1][y-2]);
                    found = true;
                }
            }

            if(x+1<8 && y+2<8)
            {
                if(cal(boardsGame[x+1][y+2],end,result))
                {
                    result.add(boardsGame[x+1][y+2]);
                    found = true;
                }
            }

            if(x+1<8 && y-2>=0)
            {
                if(cal(boardsGame[x+1][y-2],end,result))
                {
                    result.add(boardsGame[x+1][y-2]);
                    found = true;
                }
            }

            if(found == true)
                return true;
            else
                return false;
        }
    }
}
