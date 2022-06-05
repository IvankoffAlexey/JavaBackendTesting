package com.gb.lesson4.classWork;

import java.io.*;
import java.util.Date;

public class SerializeExampleJava {
    public static void main(String[] args) {

        serializeMessage();
        deserializeMessage();
    }


        private static void serializeMessage() {
            Message message = Message.builder()
                    .createdAt(new Date())
                    .author("Mike")
                    .text("Message text")
                    .build();
            try (ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(
                            new File("data/user.xml")))) {
                os.writeObject(message);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(message);
        }


        private static void deserializeMessage() {
            Message message = null;

                    try (ObjectInputStream is = new ObjectInputStream(
                            new FileInputStream("data/user.xml"))) {
                        message = (Message) is.readObject();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            System.out.println(message);

        }
}
