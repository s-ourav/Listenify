package Listenify;

public class Song {
    private String name;
    private float duration;

    Song(String name,float duration){
        this.name=name;
        this.duration=duration;
    }

    public String getName(){
        return name;
    }

    public float getDuration(){
        return duration;
    }

    public String toString(){
        return "Song {Name : "+ name +" Duration "+ duration +" }" ;

    }

}
