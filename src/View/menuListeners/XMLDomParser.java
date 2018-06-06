package View.menuListeners;

import java.util.List;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

import Model.Teacher;
import Model.DBTeacher;


import View.menuListeners.XMLConst;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Document;

public class XMLDomParser {
    private final String fileName;
    private List<Teacher> db;

    public XMLDomParser(List<Teacher> teachers, String fileName) {
        db = teachers;
        this.fileName = fileName + ".xml";
    }

    public void parseInto() {
        Document document = createDocument();
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource((Node) document);
            File file = new File(fileName);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

        } catch (TransformerException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Ошибка сохранения файла!");
        }
    }

    private Document createDocument() {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element data = document.createElement(View.menuListeners.XMLConst.RECORDS);
            document.appendChild(data);

            for (Teacher teacher : db) {
                Element node = document.createElement(View.menuListeners.XMLConst.TEACHER);
                data.appendChild(node);

                Element secondName = document.createElement(View.menuListeners.XMLConst.SECOND_NAME);
                secondName.setTextContent(teacher.getSecondName());
                node.appendChild(secondName);

                Element firstName = document.createElement(View.menuListeners.XMLConst.FIRST_NAME);
                firstName.setTextContent(teacher.getFirstName());
                node.appendChild(firstName);

                Element thirdName = document.createElement(View.menuListeners.XMLConst.THIRD_NAME);
                thirdName.setTextContent(teacher.getThirdName());
                node.appendChild(thirdName);

                Element faculty = document.createElement(View.menuListeners.XMLConst.FACULTY);
                faculty.setTextContent(teacher.getFaculty());
                node.appendChild(faculty);

                Element chair = document.createElement(View.menuListeners.XMLConst.CHAIR);
                chair.setTextContent(teacher.getChair());
                node.appendChild(chair);

                Element academicTitle = document.createElement(View.menuListeners.XMLConst.ACADEMIC_TITLE);
                academicTitle.setTextContent(teacher.getAcademicTitle());
                node.appendChild(academicTitle);

                Element academicDegree = document.createElement(View.menuListeners.XMLConst.ACADEMIC_DEGREE);
                academicDegree.setTextContent(teacher.getAcademicDegree());
                node.appendChild(academicDegree);

                Element workExperience = document.createElement(View.menuListeners.XMLConst.WORK_EXPERIENCE);
                workExperience.setTextContent(teacher.getWorkExperience().toString());
                node.appendChild(workExperience);

            }
            return document;

        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Ошибка сохранения файла!");
        }
        return null;
    }
}
