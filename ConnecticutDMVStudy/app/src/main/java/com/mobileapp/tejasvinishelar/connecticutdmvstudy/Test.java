package com.mobileapp.tejasvinishelar.connecticutdmvstudy;

import java.util.List;

public class Test
{
    private List<Q> q;

    public List<Q> getQ ()
    {
        return q;
    }

    public void setQ (List<Q> q)
    {
        this.q = q;
    }
}

 class Q{
     private String qid;

     private String answer;

     private String question;

     private List<String> options;

     public String getQid ()
     {
         return qid;
     }

     public void setQid (String qid)
     {
         this.qid = qid;
     }

     public String getAnswer ()
     {
         return answer;
     }

     public void setAnswer (String answer)
     {
         this.answer = answer;
     }

     public String getQuestion ()
     {
         return question;
     }

     public void setQuestion (String question)
     {
         this.question = question;
     }

     public List<String> getOptions ()
     {
         return options;
     }

     public void setOptions (List<String> options)
     {
         this.options = options;
     }

 }
