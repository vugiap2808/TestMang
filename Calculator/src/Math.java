/**
 * Created by FckLove on 2/29/2016.
 */
public class Math {
    private String a,b;
    public Math(String a,String b)
    {
        this.a=a;
        this.b=b;
    }
    public String Add()
    {
        String result="0";
        float s=Float.parseFloat(a)+Float.parseFloat(b);
        result=Float.toString(s);
        return result;
    }
    public  String Subt()
    {
        String result="0";
        float s=Float.parseFloat(a)-Float.parseFloat(b);
        result=Float.toString(s);
        return result;
    }
    public String Mul()
    {
        String result="0";
        float s=Float.parseFloat(a)*Float.parseFloat(b);
        result=Float.toString(s);
        return result;
    }
    public String Div()
    {
        String result="0";
        float s=Float.parseFloat(a)/Float.parseFloat(b);
        result=Float.toString(s);
        return result;
    }
}
