package Service;


/**
 * Created by OleksiiF on 15.06.2018.
 */
public interface HtmlCrawlerService {
    String getPathToIdOriginal(String url, String id);
    String getElementByPath(String path);
}
