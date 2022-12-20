package treads;

public class User implements Runnable{
    private String page_num;
    public User(String page_url){
        this.page_num = page_url;
    }
    public String Get_num(){
        return this.page_num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " +  Get_num());
    }
}
