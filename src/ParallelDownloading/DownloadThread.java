package ParallelDownloading;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadThread implements Runnable {

    String link, path, extension;
    Thread thread;

    public DownloadThread(String link, String path, String extension) {
        this.link = link;
        this.path = path;
        this.extension = extension;
        thread = new Thread (this);
    }

    @Override
    public void run() {
        System.out.println("процесс скачивания "+extension+" файла начался");
        try {
            URL url = new URL(link);
            ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
            FileOutputStream stream = new FileOutputStream(path+extension);
            stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
            stream.close();
            byteChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("процесс скачивания "+extension+" файла завершился");
    }
}
