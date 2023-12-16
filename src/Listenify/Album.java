package Listenify;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String albumname;
    private String artistname;
    private List<Song> songList;

    Album(String albumname,String artistname){
        this.albumname=albumname;
        this.artistname=artistname;
        this.songList=new ArrayList<>();
    }

    Album(String albumname,List<Song>songList,String artistname){
        this.albumname=albumname;
        this.artistname=artistname;
        this.songList=songList;
    }

    public boolean findSong(String songname){
        for(Song song : songList){
            if(song.getName().equals(songname)){
                return true;
            }
        }
        return false;
    }

    public String addNewSong(String songname,float duration){
        if(findSong(songname))
            return "Song already present in album";
        songList.add(new Song(songname,duration));
        return "New song added";
    }

    public String addToPlaylist(List <Song> playlist,int songNo){
        if(songNo-1 >= songList.size()){
            return "No such song in this album";
        }
        Song song=songList.get(songNo-1);
        for(Song songs:playlist){
            if(songs.getName().equals(song.getName())){
                return "Song already present in the playlist";
            }
        }
        playlist.add(song);
        return "New song added to playlist";
    }

    public String addToPlaylist(List <Song> playlist,String songName){
        for(Song songs:songList){
            if(songs.getName().equals(songName)){
                playlist.add(songs);
                return "New song added to playlist";
            }
        }
        return "Song not found in album";
    }




}
