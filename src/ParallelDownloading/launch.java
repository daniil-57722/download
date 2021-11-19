package ParallelDownloading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class launch {
    public static void main(String[] args) {

        //как то кривовато (только для 2х файлов) но я не знаю как по-другому ＞﹏＜

        String extension = ".jpg";
        DownloadThread downloadThread = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("files.txt"));
            for (int i = 0; i < 2; i++) {
                String[] mas = bufferedReader.readLine().split(" ");
                downloadThread = new DownloadThread(mas[0], mas[1], extension);
                downloadThread.thread.start();
                extension = ".mp3";
            }
        } catch (IOException e) {
            System.out.println("проблемы со считыванием");
        }
        while (downloadThread.thread.isAlive()){}

        //запуск музыки
        System.out.println("^o^ а теперь музыкааааа ^o^");
    playmusic p = new playmusic();
    p.play();

}

}


