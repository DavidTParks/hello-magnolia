package demo.david.models;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import org.json.JSONObject;

import info.magnolia.jcr.util.PropertyUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class QuoteModel<RD extends ConfiguredTemplateDefinition>
        extends RenderingModelImpl<ConfiguredTemplateDefinition> {

    private String category;
    private String quoteText;
    private String author;
    private String tags;
    private String date;
    private String backgroundImage;
    private String title;

    // Fadi supplied self-hosted mocked API data
    private String baseURL = "https://my-json-server.typicode.com/fadiwissa/quotes/quotes/";

    public QuoteModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent)
            throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);

        // set temp category and baseurl for request
        category = PropertyUtil.getString(content, "category");
        baseURL = baseURL + PropertyUtil.getString(content, "category");

        // attempt to request API or print stack trace
        try {
            requestQuote();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Perform GET request to quote API with supplied category and parse
    private void requestQuote() throws Exception {
        // Set up HTTPUrlConnection object with supplied arguments
        URL obj = new URL(baseURL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Parse string into JSON object for easy getting and setting
        JSONObject parsedResponse = new JSONObject(response.toString());
        category = parsedResponse.getString("category");
        quoteText = parsedResponse.getString("quote");
        author = parsedResponse.getString("author");
        tags = parsedResponse.getString("tags");
        date = parsedResponse.getString("date");
        backgroundImage = parsedResponse.getString("background");
        title = parsedResponse.getString("title");
    }

    public String getMyName() {
        return "David Parks";
    }

    // Retrieve quote text
    public String getQuoteText() {
        return quoteText;
    }

    // Get author of quote
    public String getAuthor() {
        return author;
    }

    // Get category of quote
    public String getCategory() {
        return category;
    }

    // Get tags for quote
    public String getTags() {
        return tags;
    }

    // Get date of quote
    public String getDate() {
        return date;
    }

    // Get background image used for quote
    public String getBackgroundImage() {
        return backgroundImage;
    }

    // Get title of quote
    public String getTitle() {
        return title;
    }
}