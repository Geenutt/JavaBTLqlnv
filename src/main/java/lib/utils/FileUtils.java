/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class FileUtils {
    /**
     *
     * @param fileName
     * @param object
     */
    public static void writeXMLtoFile(String fileName, Object object) {
        try {
            // tạo đối tượng JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            // Create đối tượng Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // formating 
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // lưu nội dung XML vào file
            File xmlFile = new File(fileName);
            jaxbMarshaller.marshal(object, xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param fileName
     * @param clazz
     * @return
     */
    public static Object readXMLFile(String fileName, Class<?> clazz) {
        try {
            File xmlFile = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return jaxbUnmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}