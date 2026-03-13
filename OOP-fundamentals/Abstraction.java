
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// class PlayerController{
//     private MediaPlayer player;
//     public PlayerController(MediaPlayer player){
//         this.player = player;
//     }
//     void startPlayback(){
//         player.displayStatus();
//         player.play();
//     }
//     void pausePlayback(){
//         player.pause();
//     }
//     void stopPlayback(){
//         player.stop();
//     }
// }

// abstract class MediaPlayer{
//     protected String playerName;
//     public MediaPlayer(String playerName){
//         this.playerName = playerName;
//     }

//     //Abstract methods : each player class implements these in their own way
//     abstract void play();
//     abstract void pause();
//     abstract void stop();

//     //concrete methods : shared behaviour can inherited by all players
//     void displayStatus(){
//         System.out.println("["+playerName+"] Status: Ready");
//     }

//     void logAction(String action){
//         System.out.println("["+playerName+"] Action: "+action);
//     }
// }
// class AudioPlayer extends MediaPlayer{
//     private String audioFile;
//     public AudioPlayer(String audioFile){
//         super("AudioPlayer");
//         this.audioFile = audioFile;
//     }
//     @Override
//     void play(){
//         logAction("Playing audio: "+audioFile);
//     }
//     @Override
//     void pause(){
//         logAction("Paused audio: "+audioFile);
//     }
//     @Override
//     void stop(){
//         logAction("Stopped audio: "+audioFile);
//     }
// }
// class VideoPlayer extends MediaPlayer{
//     private String videoFile;
//     private String resolution;
//     public VideoPlayer(String videoFile, String resolution){
//         super("VideoPlayer");
//         this.videoFile = videoFile;
//         this.resolution = resolution;
//     }
//     @Override
//     void play(){
//         logAction("Playing Video "+videoFile+"at "+resolution);
//     }
//     @Override
//     void pause(){
//         logAction("Paused video "+videoFile);
//     }
//     @Override
//     void stop(){
//         logAction("Stopped video "+videoFile);
//     }
// } 

// class StreamingPlayer extends MediaPlayer{
//     private String streamUrl;
//     private int bufferSize;
//     public StreamingPlayer(String streamUrl, int bufferSize){
//         super("Streaming Player");
//         this.streamUrl = streamUrl;
//         this.bufferSize = bufferSize;
//     }
//     @Override
//     void play(){
//         logAction("Streaming from: "+streamUrl+ " (buffer: )"+bufferSize+"KB");
//     }
//     @Override
//     void pause(){
//         logAction("Paused stream: "+streamUrl);
//     }
//     @Override
//     void stop(){
//         logAction("Stopped stream: "+streamUrl);
//     }
// }

// public class Abstraction{
//     public static void main(String[] args) {
//         PlayerController audioCtrl1 = new PlayerController(new AudioPlayer("HanumanChalisa.mp3"));
//         audioCtrl1.startPlayback();
//         audioCtrl1.pausePlayback();
//         System.out.println("++++++++++++++++++");

//         PlayerController videoCtrl1 = new PlayerController(new VideoPlayer("Saiyaara.mp4", "1080p"));
//         videoCtrl1.startPlayback();
//         videoCtrl1.stopPlayback();
//     }
// }
//-----------------------------------------------------------------------------------------------

abstract class Logger{
    protected String level;
    public Logger(String level){
        this.level = level;
    }
    //Abstract method: every implementing class must provide the HOW
    abstract void log(String message);
    //Concrete method
    String formatMessage(String message){
        String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return "["+timestamp+"] ["+level+"] "+message;
    }
}
class ConsoleLogger extends Logger{
    public ConsoleLogger(String level){
        super(level);
    }
    @Override
    void log(String message){
        System.out.println(formatMessage(message));
    }
}
class FileLogger extends Logger{
    private String filePath;
    public FileLogger(String level, String filePath){
        super(level);
        this.filePath = filePath;
    }
    @Override
    void log(String message){
        System.out.println("Writing to "+filePath+": "+formatMessage(message));
    }
}
public class Abstraction{
    public static void main(String[] args) {
        Logger consoleLogger = new ConsoleLogger("INFO");
        Logger fileLogger = new FileLogger("ERROR", "app.log");
        consoleLogger.log("Application started");
        fileLogger.log("Something went wrong");
    }
}