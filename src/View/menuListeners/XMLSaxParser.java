package View.menuListeners;


import Model.Teacher;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class XMLSaxParser extends DefaultHandler {
    private final List<Teacher> teacherList;
    private String currentElement;
    private Teacher teacher;
    private StringBuilder content;

    public XMLSaxParser() {
        teacherList = new ArrayList<>();
        currentElement = "";
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {
        currentElement = qName;
        if (currentElement.equals(View.menuListeners.XMLConst.SECOND_NAME)) {
            teacher = new Teacher();
            teacherList.add(teacher);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = new StringBuilder(new String(ch, start, length));
    }

    public void endElement(String uri, String localName, String qName) {
        if (currentElement.equals(View.menuListeners.XMLConst.SECOND_NAME)) {
            teacher.setSecondName(content.toString());
            return;
        }
        if (currentElement.equals(View.menuListeners.XMLConst.FIRST_NAME)) {
            teacher.setFirstName(content.toString());
            return;
        }
        if (currentElement.equals(View.menuListeners.XMLConst.THIRD_NAME)) {
            teacher.setThirdName(content.toString());
            return;
        }

        if (currentElement.equals(View.menuListeners.XMLConst.FACULTY)) {
            teacher.setFaculty(content.toString());
            return;
        }
        if (currentElement.equals(View.menuListeners.XMLConst.CHAIR)) {
            teacher.setChair(content.toString());
            return;
        }
        if (currentElement.equals(View.menuListeners.XMLConst.ACADEMIC_TITLE)) {
            teacher.setAcademicTitle(content.toString());
            return;
        }
        if (currentElement.equals(View.menuListeners.XMLConst.ACADEMIC_DEGREE)) {
            teacher.setAcademicDegree(content.toString());
            return;
        }
        if (currentElement.equals(View.menuListeners.XMLConst.WORK_EXPERIENCE)) {
            if(content.toString().contains("\t") || content.toString().contains("\n"))
                return;
            teacher.setWorkExperience(Integer.parseInt(content.toString()));
            return;
        }
    }
}
