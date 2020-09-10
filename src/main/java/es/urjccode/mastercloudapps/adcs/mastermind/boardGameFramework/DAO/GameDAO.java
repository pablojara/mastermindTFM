package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.DAO;


import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.models.Game;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

import static java.util.Objects.requireNonNull;

 class GameDAO implements DAO {

    private Game game;

    GameDAO(Game game) {
        this.game = game;
    }

    @Override
    public void save() {
        try {
            serialize(this.game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            this.game = (Game)deserialize(this.game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void serialize(Object object) throws Exception {

        Class<?> objectClass = requireNonNull(object).getClass();
        Map<String, Object> serializationElements = new HashMap<>();

        for (Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(DAOField.class)) {
                serializationElements.put(getSerializedKey(field), field.get(object));
            }
        }

        toByteCode(serializationElements);
    }

    private static Object deserialize(Object object) throws Exception {
        Class<?> objectClass = requireNonNull(object).getClass();
        List<String> fileNames = new ArrayList<String>();
        for (Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(DAOField.class)) {
                fileNames.add(getSerializedKey(field));

            }
        }

        HashMap<String, Object> readObjects = toObject(fileNames);

        for (Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(DAOField.class)) {
                field.set(object, readObjects.get(getSerializedKey(field)));
            }
        }

        return object;
    }

    private static void toByteCode(Map<String, Object> serializationElements) throws Exception {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        Iterator it = serializationElements.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            try {
                String fileName = Objects.toString(pair.getKey());
                fileOutputStream = new FileOutputStream(fileName);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(pair.getValue());
                objectOutputStream.close();
                System.out.println("Object serialized in file : " + fileName);
            }
            catch (FileNotFoundException e) {
                throw new Exception(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            it.remove();
        }
    }

    private static HashMap<String, Object> toObject(List<String> fileNames) {
        HashMap<String, Object> readObjects = new HashMap<String, Object>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        for(String fileName: fileNames) {
            try {
                fileInputStream = new FileInputStream(fileName);
                objectInputStream = new ObjectInputStream(fileInputStream);
                readObjects.put(fileName, objectInputStream.readObject());
                objectInputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return readObjects;
    }

    private static String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(DAOField.class).value();

        if (annotationValue.isEmpty()) {
            return field.getName();
        }
        else {
            return annotationValue;
        }
    }

}
