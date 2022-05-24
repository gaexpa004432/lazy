package admin.cms.menu.controller;

import admin.cms.menu.domain.MenuVO;
import admin.cms.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/admin/menu")
    public String menuMain(MenuVO menuVO , Model model){
        System.out.println(menuService.selectTest());
        return "menu/menu";
    }

    @RequestMapping(value = "/test/xmlCreate.do")
    public String xmlCreate(HttpServletRequest req, ModelMap modelMap, HttpServletResponse res) throws Exception {
        MenuVO menuVo = new MenuVO();
        /*menuVo.setLang("ko");*/
        /*List<MenuVO> menuList = commonService.selectTopMenu(menuVo);*/
        List<MenuVO> menuList =new ArrayList<MenuVO>();
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        // book 엘리먼트
        Document doc = docBuilder.newDocument();
        doc.setXmlStandalone(true); //standalone="no" 를 없애준다.

        Element menu = doc.createElement("menu");
        doc.appendChild(menu);
        Element list = doc.createElement("list");

        for(MenuVO vo :menuList){
            // code 엘리먼트
            list = doc.createElement("list");
            menu.appendChild(list);
            Element menuId = doc.createElement("menuId");
            /*menuId.appendChild(doc.createTextNode(vo.getMenuId()));*/
            list.appendChild(menuId);

            Element menuName = doc.createElement("menuName");
            /*menuName.appendChild(doc.createTextNode(vo.getMenuName()));*/
            list.appendChild(menuName);

            Element menuUrl = doc.createElement("menuUrl");
            /*if(vo.getMenuUrl() == null){
                menuUrl.appendChild(doc.createTextNode(""));
            }else{
                menuUrl.appendChild(doc.createTextNode(vo.getMenuUrl()));
            }*/
            list.appendChild(menuUrl);

            Element menuGbn = doc.createElement("menuGbn");

            /*menuGbn.appendChild(doc.createTextNode(vo.getMenuGbn()));*/
            list.appendChild(menuGbn);

            Element contentId = doc.createElement("contentId");
            /*if(vo.getContentId() == null){
                contentId.appendChild(doc.createTextNode(""));
            }else{
                contentId.appendChild(doc.createTextNode(vo.getContentId()));
            }*/
            list.appendChild(contentId);

            Element boardId = doc.createElement("boardId");
            /*if(vo.getBoardId() == null){
                boardId.appendChild(doc.createTextNode(""));
            }else{
                boardId.appendChild(doc.createTextNode(vo.getBoardId()));
            }*/
            list.appendChild(boardId);
        }

        // 속성값 정의 (id:1)
        /*code.setAttribute("id", "1");*/
        //code.setAttribute("type", "novel");


        // XML 파일로 쓰기
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "6"); //정렬 스페이스4칸
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //들여쓰기
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes"); //doc.setXmlStandalone(true); 했을때 붙어서 출력되는부분 개행

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream(new File("D://xml/book.xml")));

        transformer.transform(source, result);

        System.out.println("=========END=========");
        return "/menu/menu";
    }

    @RequestMapping(value = "/test/xmlRead.do")
    public String xmlRead(HttpServletRequest req, ModelMap modelMap,HttpServletResponse res) throws Exception {

        File file = new File("D://xml/book.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(file);
        document.getDocumentElement().normalize();
        System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
        NodeList nList = document.getElementsByTagName("menu");
        System.out.println("nList.getLength() : "+ nList.getLength());
        NodeList nList1 = document.getElementsByTagName("list");
        for (int temp = 0; temp < nList1.getLength(); temp++) {
            System.out.println("----------------------------");
            Node nNode = nList1.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                /*System.out.println("Employee id : " + eElement.getAttribute("id"));*/
                System.out.println("menuId : " + eElement.getElementsByTagName("menuId").item(0).getTextContent());
                System.out.println("menuName : " + eElement.getElementsByTagName("menuName").item(0).getTextContent());
                System.out.println("menuUrl : " + eElement.getElementsByTagName("menuUrl").item(0).getTextContent());
                System.out.println("menuGbn : " + eElement.getElementsByTagName("menuGbn").item(0).getTextContent());
                System.out.println("contentId : " + eElement.getElementsByTagName("contentId").item(0).getTextContent());
                System.out.println("boardId : " + eElement.getElementsByTagName("boardId").item(0).getTextContent());
            }
        }

        return "/menu/menu";
    }
}
