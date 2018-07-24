package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileName = reader.readLine();

            int maxId = getMaxId(fileName) + 1;

            FileWriter writer = new FileWriter(fileName, true);

            char[] id = new char[8], name = new char[30], price = new char[8], quantity = new char[4];

            for (int i = 0; i < id.length; i++)
                if (!(i >= Integer.toString(maxId).length()))
                    id[i] = Integer.toString(maxId).charAt(i);
                else
                    id[i] = ' ';

            for (int i = 0; i < name.length; i++)
                if (!(i >= args[1].length()))
                    name[i] = args[1].charAt(i);
                else
                    name[i] = ' ';

            for (int i = 0; i < price.length; i++)
                if (!(i >= args[2].length()))
                    price[i] = args[2].charAt(i);
                else
                    price[i] = ' ';

            for (int i = 0; i < quantity.length; i++)
                if (!(i >= args[3].length()))
                    quantity[i] = args[3].charAt(i);
                else
                    quantity[i] = ' ';

            if(new File(fileName).length() != 0)
                writer.write('\n');
            writer.write(id);
            writer.write(name);
            writer.write(price);
            writer.write(quantity);

            writer.close();
            reader.close();
        }

    }

    private static int getMaxId(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        if(!reader.ready())
            return 0;

        int max = Integer.parseInt(reader.readLine().substring(0, 8).trim());

        while(reader.ready()) {
            int id = Integer.parseInt(reader.readLine().substring(0, 8).trim());
            if(max < id) max = id;
        }

        reader.close();

        return max;
    }
    /*public class SpecialFileReader extends java.io.FileReader {
        public SpecialFileReader(String fileName) throws FileNotFoundException {
            super(fileName);
        }

        public String readId() throws IOException {
            StringBuilder id = new StringBuilder();
            for(int i = 0; i < 8; i++) {
                id.append((char) this.read());
            }

            return id.toString();
        }

        public String readProductName() throws IOException {
            StringBuilder productName = new StringBuilder();
            for(int i = 0; i < 30; i++) {
                productName.append((char) this.read());
            }

            return productName.toString();
        }

        public String readPrice() throws IOException {
            StringBuilder price = new StringBuilder();
            for(int i = 0; i < 8; i++) {
                price.append((char) this.read());
            }

            return price.toString();
        }

        public String readQuantity() throws IOException {
            StringBuilder quantity = new StringBuilder();
            for(int i = 0; i < 4; i++) {
                quantity.append((char) this.read());
            }

            return quantity.toString();
        }
    }*/
}
