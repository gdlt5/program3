
/***
* Olympic Igloo Scoring Class
*
* For the Winter Olympics igloo building event there are
* three judges, each of which gives a score from 0 to 50 
* (inclusive), but the lowest score is thrown out and the 
* competitor's overall score is just the sum of the two
* highest scores. This class supports the recording of the
* three judge's scores, and the computing of the competitor's
* overall score.
*
***/

public class IglooScore1
{

   int score1;
   int score2;
   int score3;

public IglooScore1()
{
   score1 = 0;
   score2 = 0;
   score3 = 0;
}

public void recordScores(int s1, int s2, int s3)
{
   score1 = s1;
   score2 = s2;
   score3 = s3;
}

public int overallScore()
{
   int s;
   if (score1 < score2)
      s = score1; //Original Statement: s = score2; Function works by subtracting lowest score from total of all 3 scores. s should not be assigned to highest value. Correction: s = score1
   else
      s = score2; //Original Statement: s = score1; To continue fix of statement at line 40, s should be assigned to lowest value in comparison. Correction: s = score2
   if (s > score3)
      s = score3;
   s = (score1+score2+score3) - s;   
   return s;
}

public static void main(String args[])
{
   int s1, s2, s3;
   if (args.length != 3) {
      System.err.println("Error: must supply three arguments!");
      return;
   }
   try {
      s1 = Integer.parseInt(args[0]);
      s2 = Integer.parseInt(args[1]);
      s3 = Integer.parseInt(args[2]);
   } catch (Exception e) {
      System.err.println("Error: arguments must be integers!");
      return;
   }
   //Determine if input score values are valid
   if (s1<0 || s1>50 || s2<0 || s2>50 || s3<0 || s3>50) {
      System.err.println("Error: scores must be between 0 and 50!");
      return;
   }
   IglooScore1 score = new IglooScore1();
   score.recordScores(s1,s2,s3);
   System.out.println("Overall score: " + score.overallScore());
   return;
}

} // end class

