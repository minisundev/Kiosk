import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public ArrayList<Product> products;
    private String name;
    private String desc;
    private String id;

    public static void createMenu(String name, String desc){
        ArrayList<Menu> menus = KioskApp.menus;
        SecureRandom random = KioskApp.random;
        boolean newMenus = true;
        for (Menu m : menus){
            if(m.getName().equals(name)){
                newMenus = false;//새 메뉴가 아님
                System.out.println("이미 존재하는 메뉴입니다.");
            }
        }
        //for문을 도는 동안 같은 메뉴이름인게 안 나왔으면 새 메뉴임
        if(newMenus){
            menus.add(new Menu(name,desc,""+random.nextLong()));
        }
    }

    public Menu(String name, String desc, String id) {
        this.name = name;
        this.desc = desc;
        this.products = new ArrayList<Product>();
        this.id = id;
    }
    public static int printIndex(ArrayList<Menu> m) {
        int i=0;
        for (; i < m.size(); i++) {//for문 돌면서 있으면 출력
            System.out.println((i + 1) + ". " +m.get(i).getName() + " | " + m.get(i).getDesc());
        }
        return i+1;
    }
    public static void printId(ArrayList<Menu> menus) {
        for(Menu m:menus){
            System.out.println("\n [ "+m.getName()+" ]");
            for(Product p: m.products){
                System.out.println(p.getName() + "   | id : " +m.getId()+"#"+ p.getId());
            }
        }
    }

    /*getter, setter*/
    public String getName() {
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

}
