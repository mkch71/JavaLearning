import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.nio.Buffer;


public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args)  {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\JavaLearning\\proxy.txt"));
            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("D:\\JavaLearning\\good_proxy1.txt"));
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("D:\\JavaLearning\\good_proxy2.txt"));
            BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter("D:\\JavaLearning\\good_proxy3.txt"));
           // FileOutputStream fo
            String readLine = "";

            try {
                bufferedWriter1.write("1-способ class CheckProxyThread extends Thread\n");
                bufferedWriter1.flush();
                //System.out.println(result);
            } catch (IOException e) {

                e.printStackTrace();
            }
            try {
                bufferedWriter2.write("2-способ class CheckProxyRunnableThread implements Runnable\n");
                bufferedWriter2.flush();
                //System.out.println(result);
            } catch (IOException e) {

                e.printStackTrace();
            }
            try {
                bufferedWriter3.write("3-способ\n");
                bufferedWriter3.flush();
                //System.out.println(result);
            } catch (IOException e) {

                e.printStackTrace();
            }

            while ((readLine = bufferedReader.readLine()) != null) {
                String ip = readLine.split("\t")[0].trim();
                int port = Integer.parseInt(readLine.split("\t")[1].trim());

                //1-способ class CheckProxyThread extends Thread
                CheckProxyThread thread1 = new CheckProxyThread(ip,port,bufferedWriter1);
                thread1.start();

                //2-способ
                Thread thread2 = new  Thread(new CheckProxyRunnableThread(ip,port,bufferedWriter2));
                thread2.start();

                 //3-й способ
                Thread thread3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if( checkProxy(ip, port)) {

                            try {
                                bufferedWriter3.write(ip + ":" + port + "\n");
                                bufferedWriter3.flush();
                                //System.out.println(result);
                            } catch (IOException e) {
                                //System.out.println("Тут сломалось?");
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread3.start();


            }


            bufferedReader.close();

        }catch (Exception e){

            e.printStackTrace();
        }

    }
    public static boolean checkProxy(String ip, int port) {
        try {
            System.out.println("Проверяю ip: " + ip + " || port: " + port);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            //URLConnection urlConnection = new URL("http://mkch71.beget.tech/php/ip/").openConnection(proxy);
            URLConnection urlConnection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);
            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            //char[] buffer = new char[256];
            int rc;
            StringBuilder sb = new StringBuilder();
            while ((rc = reader.read()) != -1) {
                sb.append((char) rc);
            }
                System.out.println("IP: " + ip + ":" + port + ANSI_GREEN + " работает" + ANSI_RESET);
                return true;

        } catch ( Exception e) {
            System.out.println("IP: "+ ip+":"+port+ANSI_RED+" не работает"+ANSI_RESET);
            return false;
        }

    }
}

class CheckProxyThread extends Thread{
    String ip;
    int port;
    BufferedWriter bufferedWriter;

    public CheckProxyThread(String ip, int port,BufferedWriter bufferedWriter) {
        this.ip = ip;
        this.port = port;
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void run(){
        if (Main.checkProxy(ip,port)){
            try {
                bufferedWriter.write(ip + ":" + port + "\n");
                bufferedWriter.flush();
                //System.out.println(result);
            } catch (IOException e) {
                //System.out.println("Тут сломалось?");
                e.printStackTrace();
            }
        };
    }

}

class CheckProxyRunnableThread implements Runnable {
    String ip;
    int port;
    BufferedWriter bufferedWriter;

    public CheckProxyRunnableThread(String ip, int port, BufferedWriter bufferedWriter) {
        this.ip = ip;
        this.port = port;
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void run() {
        if (Main.checkProxy(ip,port)){
            try {
                bufferedWriter.write(ip + ":" + port + "\n");
                bufferedWriter.flush();
                //System.out.println(result);
            } catch (IOException e) {
                //System.out.println("Тут сломалось?");
                e.printStackTrace();
            }
        };
    }
}
