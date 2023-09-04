package day02;

import java.util.ArrayList;
import java.util.List;

public class People {
        private String name;

        public People(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof People) {
                People people = (People) obj;
                return name.equalsIgnoreCase(people.getName().trim());
            }
//            if()
            return false;
        }

        public static void main(String[] args) {
            People p1 = new People("张三");
            People p2 = new People("张三    ");
            List<People> list = new ArrayList<People>();
            list.add(p1);
            list.add(p2);
            System.out.println("是否包含张三：" + list.contains(p1));// 此时的p1代表了getName().trim()---Name，而不是引用了
            System.out.println("是否包含张三：" + list.contains(p2));
        }
    }