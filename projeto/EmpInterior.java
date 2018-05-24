
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EmpInterior extends Empresa implements Serializable
{
    
    private String conselho;
    
    public EmpInterior(){
        super();
        this.conselho="";
    }
    
    public EmpInterior(int nif1,String nemail,String nnome,String nmorada,String npassword,Set<String> setores,double ncoeficiente,Set<Integer> faturas,String conselho){
        super(nif1,nemail,nnome,nmorada,npassword,setores,ncoeficiente,faturas);
        this.conselho = conselho;
    }
    
    public EmpInterior(EmpInterior e){
        super(e);
        this.conselho = e.getConselho();
    }
    
    public String getConselho(){
        return this.conselho;
    }
    
    public void setConselho(String s){
        this.conselho = s;
    }
    
    public EmpInterior clone(){
        return new EmpInterior(this);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(super.toString());
        sb.append(this.conselho + "\n");
        
        return sb.toString();
    }
    
    public boolean equals(Object o){
        if(this == o)
            return true;
        
        if (o == null || (this.getClass() != o.getClass()))
            return false;
        
        EmpInterior aux = (EmpInterior) o;
        
        return this.conselho.equals(aux.getConselho()) && super.equals(aux);
    }
    
    public int hashCode(){
        int hash = 7;
        hash = 31*hash + this.conselho.hashCode();
        hash = 31*hash + super.hashCode();
        
        return hash;
    }
    
    public double reducaoImposto(Map<String,Double> a){
        return a.get(this.conselho);
    }
    
}
