import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album1 = new Album("Moosa", "SiddhuMoosewala");
        album1.addSongtoAlbum("295", 4.5);
        album1.addSongtoAlbum("Last ride", 6);
        album1.addSongtoAlbum("So high" , 4.8);

        Album album2 = new Album("Arijit_Songs","Arijit Sing");
        album2.addSongtoAlbum("Gerua" , 5.03);
        album2.addSongtoAlbum("Uska hi bana", 6.5);
        album2.addSongtoAlbum("Nashe si", 4.02);

        albums.add(album1);
        albums.add(album2);

        System.out.println(album2.findSong("Gerua"));

        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.addToPlaylistFromAlbum("295", myPlayList);
        album2.addToPlaylistFromAlbum(2,myPlayList);
        album2.addToPlaylistFromAlbum("Geruagit in",myPlayList);
        album2.addToPlaylistFromAlbum("Nashe si",myPlayList);

        Song sample = new Song("abs",7.00);

        System.out.println(sample);
        play(myPlayList);
    }

    public static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        ListIterator<Song>  itr = playList.listIterator();
        boolean isFarward = true;

        if(playList.size() > 0){
            System.out.println("currently playing : ");
            System.out.println(itr.next());
            isFarward = true;
        }
        else{
            System.out.println("PlayList is Empty");
            return;
        }

        System.out.println("Enter your choice");
        printMenu();

        boolean quit = false;
        while(!quit){
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    if(isFarward == false){
                        itr.next();
                        isFarward = true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }else{
                        System.out.println("No next song");
                        isFarward = false;
                    }
                    break;
                case 2:
                    if(isFarward == true){
                        itr.previous();
                        isFarward = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }else {
                        System.out.println("No previous song, you are at start");
                        isFarward = true;
                    }
                    break;
                case 3:
                    if(isFarward == true){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isFarward = false;
                        }
                        else{
                            System.out.println("Song does not exist");
                        }
                    }else{
                        if(itr.hasNext()) {
                            System.out.println(itr.next());
                            isFarward = true;
                        }else{
                            System.out.println("song is not present");
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    private static void printSongs(LinkedList<Song> playList) {
        for(Song song : playList){
            System.out.println(song);
        }
        return;
    }

    public static void  printMenu(){
        System.out.println("1:Play next song");
        System.out.println("2: Play previous song");
        System.out.println("3: Repeat song");
        System.out.println("4: Show menu again");
        System.out.println("5: Delete the current song");
        System.out.println("6: Show all the song");
        System.out.println("7: Exit");
    }
}