package Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by OleksiiF on 15.06.2018.
 */
public class HtmlCrawlerServiceJsoup implements HtmlCrawlerService{

    private static StringBuilder path = new StringBuilder();

    public String getPathToIdOriginal(String url, String id){
        return findPathOfAnElement(findElementWithId(url, id));
    }

    private static Element findElementWithId(String url, String id){

        Document targetPage = null;
        try {
            targetPage = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //html[1]>body[2]>div[1]>div[5]>div[9]>div[1]>div[1]>div[5]>a[1]
        //html[1]>body[2]>div[1]>div[5]>div[9]>div[1]>div[1]>div[5]>a[3]
        //html[1]>body[2]>div[1]>div[5]>div[9]>div[1]>div[1]>div[5]>a[3]
        //html[1]>body[2]>div[1]>div[5]>div[9]>div[1]>div[1]>div[9]>a[1]

        return targetPage.getElementById(id);
    }

    private static String findPathOfAnElement (Element element){
        Elements elementParents = element.parents();

        if(!element.ownText().isEmpty()) {
            for (int i = elementParents.size() - 1; i >= 0; i--) {
                Element e = elementParents.get(i);
                path.append(e.nodeName())
                        .append("[")
                        .append(e.siblingIndex())
                        .append("]")
                        .append(">");
            }
            path.append(element.nodeName()).append("[").append(element.siblingIndex()).append("]");
        }

        return path.toString();
    }

    public String getElementByPath(String path){
        String p = "html[1]>body[2]>div[1]>div[5]>div[9]>div[1]>div[1]>div[5]>[1]";

        Document targetPage = null;
        try {
            targetPage = Jsoup.connect(path).get();
        } catch (IOException e) {
            e.printStackTrace();
        }



        targetPage.childNode(1)
                .childNode(2)
                .childNode(1)
                .childNode(5)
                .childNode(9)
                .childNode(1)
                .childNode(1)
                .childNode(5)

                //.childNode(3)
                .toString();



        return "nothing";
    }
}
