
// import java.util.*;
// class Professor{
//     private String name;
//     public Professor(String name){
//         this.name = name;
//     }
//     public String getName(){
//         return name;
//     }
// }
// class Department{
//     private String name;
//     private List<Professor> professors;
//     public Department(String name, List<Professor> professors){
//         this.name = name;
//         this.professors = professors;
//     }
//     public void printProfessor(){
//         System.out.println("Professors in "+name+"Department");
//         for(Professor p : professors){
//             System.out.println("- "+p.getName());
//         }
//     }
// }
// public class Aggregation {
//     public static void main(String[] args) {
//         Professor p1 = new Professor("Dr. Jones");
//         Professor p2 = new Professor("Dr. Lee");

//         List<Professor> profs = List.of(p1, p2);
//         Department csDept = new Department("CSE", profs);
//         csDept.printProfessor();
//     }
// }
import java.util.*;
class Artist{
    private String name;
    public Artist(String name){
        this.name = name;
    }
    public String getName(){return name;}
}
class Song{
    private String title;
    private Artist artist;
    private int duration;
    public Song(String title, Artist artist, int duration){
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    public String getTitle(){return title;}
    public Artist getArtist(){return artist;}
    public int getDuration(){return duration;}
    @Override
    public String toString(){
        return title+" by "+artist.getName()+" ("+duration+"s)";
    }
}
class Playlist{
    private String name;
    private List<Song> songs = new ArrayList<>();
    public Playlist(String name){
        this.name = name;
    }
    public void addSong(Song song){
        songs.add(song);
    }
    public void removeSong(Song song){
        songs.remove(song);
    }
    public int getSongCount(){
        return songs.size();
    }
    public int getTotalDuration(){
        int total_duration = 0;
        for(Song s: songs){
            total_duration += s.getDuration();
        }
        return total_duration;
    }
    public String getName(){return name;}
    public List<Song> getSongs(){return songs;}
}
class User{
    private String name;
    private List<Playlist> playlists = new ArrayList<>();
    public User(String name){
        this.name = name;
    }
    public Playlist createPlaylist(String playlistName){
        Playlist playlist = new Playlist(playlistName);
        playlists.add(playlist);
        return playlist;
    }
    public void deletePlaylist(Playlist playlist){
        playlists.remove(playlist);
    }
    public String getName(){return name;}
    public List<Playlist> getPlaylists(){return playlists;}
}
class Library{
    private List<Song> songs = new ArrayList<>();
    public void addSong(Song song){
        songs.add(song);
    }
    public int getSongCount(){return songs.size();}
    public List<Song> getSongs(){return songs;}
}

public class Aggregation{
    public static void main(String[] args) {
        Artist coldplay = new Artist("Cold Play");
        Artist adele = new Artist("Adele");
        Song yellow = new Song("Yellow", coldplay, 269);
        Song hello = new Song("Hello", adele, 295);
        Library library = new Library();
        library.addSong(yellow);
        library.addSong(hello);

        User mahesh = new User("mahesh");
        Playlist workout = mahesh.createPlaylist("Workout Mix");
        Playlist chill = mahesh.createPlaylist("Chill");

    }
}