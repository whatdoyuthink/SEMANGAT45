package id.ac.ukdw.fti.rpl.SEMANGAT45.modal;

public class Verse {
    private String Kitab;
    private String Pasal;
    private String Ayat;
    private String Timeline;

    public void setKitab(String Kitab){
        this.Kitab = Kitab;
    }

    public void setPasal(String Pasal){
        this.Pasal = Pasal;
    }

    public void setAyat(String Ayat){
        this.Ayat = Ayat;
    }

    public void setTimeline(String Timeline){
        this.Timeline = Timeline;
    }

    public String getKitab(){
        if(this.Kitab==null){
            return "null";
        }else{
            return this.Kitab;
        }
    }

    public String getPasal(){
        if(this.Pasal==null){
            return "null";
        }else{
            return this.Pasal;
        }  
    }

    public String getAyat(){
        if(this.Ayat==null){
            return "null";
        }else{
            return this.Ayat;
        }   
    }

    public String getTimeline(){
        if(this.Timeline==null){
            return "null";
        }else{
            return this.Timeline;
        }   
    }
  
}