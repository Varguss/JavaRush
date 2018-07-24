package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(ivanov.equals(somePerson));
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name; // имя
        public List<Asset> assets = new ArrayList<Asset>(); // активы (дома, животные, т.д.)

        public Human() {
            this.name = "Human_" + this.hashCode();
        } // конструктор, который присваивает уникальное имя каждому объекту в зависимости от его HashCode

        @Override
        public boolean equals(Object o) {
            if (this == o) return true; // если объекты одинаковые (один и тот же объект)
            if (o == null || getClass() != o.getClass()) return false; // если объекта нет (null) или его класс не равняется классу нашего объекта, то false

            Human human = (Human) o; // преобразование до Human

            if (name != null ? !name.equals(human.name) : human.name != null) return false; // если имя нашего объекта не пустое, то в if передается проверка на !name.equals(human.name), если пустое, то проверка, пустое ли имя у другого объекта
            return assets != null ? assets.equals(human.assets) : human.assets == null; // если активы есть, то сравнение активов с другим объектом, или же проверка, нет ли активов у другого объекта

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result; // возвращение хэшкода имени (умноженого на 31) и списка активов
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintStream stream = new PrintStream(outputStream, true);
            stream.println(name);
            for(Asset a : assets) {
                stream.println(a.getName());
                stream.println(a.getPrice());
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            name = reader.readLine();
            for(String s = reader.readLine(); s != null; s = reader.readLine()) {
                Asset a = new Asset(s);
                a.setPrice(Double.parseDouble(reader.readLine()));
                assets.add(a);
            }
        }
    }
}
