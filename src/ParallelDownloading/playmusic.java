package ParallelDownloading;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.IOException;

public class playmusic {
    void play(String path){
    try (FileInputStream inputStream = new FileInputStream(path+"/music.mp3")) {
        try {
            Player player = new Player(inputStream);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    } catch (IOException e) {
        e.printStackTrace();
        }
    }
}
