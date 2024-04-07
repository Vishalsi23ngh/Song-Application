import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private  String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public  boolean findSong(String title){
        for(Song s: songs){
            if(title != null && title.equals(s.getTitle())){
                return true;
            }
        }
        return false;
    }

    public  void addSongtoAlbum(String  title, double duration){
        Song s = new Song(title, duration);
        if(findSong(s.getTitle())){
            System.out.println("Song is already present in album");
        }else{
            songs.add(s);
            System.out.println("New song has been added");
        }
        return;
    }

    public  void addToPlaylistFromAlbum(String title , LinkedList<Song> playList){
        if(findSong(title)){
            for(Song song: songs){
                if(song.getTitle().equals(title)) {
                    playList.add(song);
                    System.out.println(" song has been added to your playlist");
                    break;

                }
            }
        }
        else{
            System.out.println("song is not present in Album");
        }
        return;
    }

    public  void addToPlaylistFromAlbum(int trackNo , LinkedList<Song> playList){
        int index = trackNo -1;
        if(index > 0 && index < songs.size()){
            System.out.println(" song has been added to playlist");
            playList.add(songs.get(index));
        }
        else{
            System.out.println(" Invalid track number");
        }
        return ;
    }
}
