import Service.HtmlCrawlerServiceJsoup;

/**
 * Created by OleksiiF on 15.06.2018.
 */
public class WebCrawler {
    public static void main(String[] args) {
        String inputOriginFilePath = args[0];
        String inputOtherSampleFilePath = args[1];
        HtmlCrawlerServiceJsoup crawler = new HtmlCrawlerServiceJsoup();

        String searchedId = "make-everything-ok-button";
        if(args.length == 2) {
            System.out.println(crawler.getPathToIdOriginal(inputOriginFilePath, searchedId));
            System.out.println(crawler.getElementByPath(inputOtherSampleFilePath));
        } else {
            System.out.println("program expects 2 arguments");
        }

    }
}
