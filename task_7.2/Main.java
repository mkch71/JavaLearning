import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


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
            String proxy = "";

            try {
                bufferedWriter1.write("1-способ class CheckProxyThread extends Thread\n");
                //bufferedWriter1.flush();
                //System.out.println(result);
            } catch (IOException e) {

                e.printStackTrace();
            }
            try {
                bufferedWriter2.write("2-способ class CheckProxyRunnableThread implements Runnable\n");
                //bufferedWriter2.flush();
                //System.out.println(result);
            } catch (IOException e) {

                e.printStackTrace();
            }
            try {
                bufferedWriter3.write("3-способ\n");
                //bufferedWriter3.flush();
                //System.out.println(result);
            } catch (IOException e) {

                e.printStackTrace();
            }
            //List< CheckProxyThread> thread1 = new ArrayList<CheckProxyThread>();
            //List< Thread> thread2 = new ArrayList<Thread>();
            //List< Thread> thread3 = new ArrayList<Thread>();
            int i;
            while ((i = bufferedReader.read()) != -1) {
                if(i==13) continue;
                else if(i==10){
                    String ip = proxy.split(":")[0];
                    String port = proxy.split(":")[1];


                    //1-способ class CheckProxyThread extends Thread
                    Thread thread1= new CheckProxyThread(ip,Integer.parseInt(port),bufferedWriter1);
                    thread1.start();

                    //2-способ
                    Thread thread2= new Thread(new CheckProxyRunnableThread(ip,Integer.parseInt(port),bufferedWriter2));
                    thread2.start();

                     //3-й способ
                     Thread thread3 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            if( checkProxy(ip, Integer.parseInt(port),"3-й способ")) {

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
                    proxy ="";
                } else if(i!=9) {
                    proxy += (char) i;
                } else
                {
                    proxy +=":";
                }



            }
           /* for (CheckProxyThread t:thread1){
                t.start();
            }
            for (CheckProxyThread t:thread1){
                t.join();
            }
            for (Thread t:thread2){
                t.start();
            }
            for (Thread t:thread2){
                t.join();
            }*/
            /*for (Thread t:thread3){
                t.start();
            }
            for (Thread t:thread3){
                t.join();
            }*/
            /*for (Thread t:thread1){
                System.out.print("Start thread1 ");
                System.out.println(t.getState() + " : " + t.getName()+" : "+ t.getId());
            }
            for (Thread t:thread2){
                System.out.print("Start thread2 ");
                System.out.println(t.getState() + " : " + t.getName()+" : "+ t.getId());
            }
            for (Thread t:thread3){
                System.out.print("Start thread3 ");
                System.out.println(t.getState() + " : " + t.getName()+" : "+ t.getId());
            }*/

            /*for (Thread t:thread1){
                System.out.print("Status thread1 ");
                System.out.println(t.getState() + " : " + t.getName()+" : "+ t.getId());
            }
*/

  /*          for (Thread t:thread2){
                System.out.print("Status thread2 ");
                System.out.println(t.getState() + " : " + t.getName()+" : "+ t.getId());
            }*/



            /*for (Thread t:thread3){
                System.out.print("Status thread3 ");
                System.out.println(t.getState() + " : " + t.getName()+" : "+ t.getId());
            }
            System.out.println(Thread.activeCount());*/
            /*bufferedWriter1.close();
            bufferedWriter2.close();
            bufferedWriter3.close();*/
            bufferedReader.close();

        }catch (Exception e){

            e.printStackTrace();
        }

    }
    public static boolean checkProxy(String ip, int port, String comment) {
        try {
            System.out.println(comment+" Проверяю ip: " + ip + " || port: " + port);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            //URLConnection urlConnection = new URL("http://mkch71.beget.tech/php/ip/").openConnection(proxy);
            URLConnection urlConnection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);
            urlConnection.setConnectTimeout(5000); //5 сек
            urlConnection.setReadTimeout(5000);

            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            //char[] buffer = new char[256];
            int rc;
            StringBuilder sb = new StringBuilder();
            while ((rc = reader.read()) != -1) {
                sb.append((char) rc);
            }
                System.out.println(comment+" IP: " + ip + ":" + port + ANSI_GREEN + " работает" + ANSI_RESET);
                return true;

        } catch ( IOException e) {
            System.out.println(comment+" IP: " + ip + ":" + port + ANSI_RED + " не работает" + ANSI_RESET);
            return false;
        }
            catch (NoSuchElementException e) {
                System.out.println(comment+" Хрень!!! IP: "+ ip+":"+port+ANSI_RED+" не работает"+ANSI_RESET);
                return false;
        }

    }
}

class CheckProxyThread extends Thread{
    private String ip;
    private int port;
    private BufferedWriter bufferedWriter;

    public CheckProxyThread(String ip, int port,BufferedWriter bufferedWriter) {
        this.ip = ip;
        this.port = port;
        this.bufferedWriter = bufferedWriter;
    }


    @Override
    public void run(){
        if (Main.checkProxy(ip,port,"1-й способ")){
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
    private String ip;
    private int port;
    private BufferedWriter bufferedWriter;

    public CheckProxyRunnableThread(String ip, int port, BufferedWriter bufferedWriter) {
        this.ip = ip;
        this.port = port;
        this.bufferedWriter = bufferedWriter;
    }


    @Override
    public void run() {
        if (Main.checkProxy(ip,port,"2-й способ")){
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
