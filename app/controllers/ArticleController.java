package controllers;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.json.JSONObject;
import play.mvc.Controller;
import play.mvc.Result;


public class ArticleController extends Controller {
    private String url = "http://dpoir.com.ar/articles";

    public Result getAllArticles() {
        Table table = getTable("article");
        PrimaryKey primaryKey = new PrimaryKey("@id", "articles");
        Item item = table.getItem(primaryKey);
        item.removeAttribute("@id");
        JSONObject jsonObject = new JSONObject(item.toJSON());
        jsonObject.put("@id", url);
        return ok(jsonObject.toString());
    }

    public Result getArticle(String id) {
        Table table = getTable("article");
        PrimaryKey primaryKey = new PrimaryKey("@id", id);
        Item item = table.getItem(primaryKey);
        String aux = url + "/" + item.get("@id");
        item.removeAttribute("@id");
        JSONObject jsonObject = new JSONObject(item.toJSON());
        jsonObject.put("@id", aux);
        return ok(jsonObject.toString());
    }

    private Table getTable(String tableName) {
//        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
//                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
//                .build();

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_EAST_2)
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);
        return dynamoDB.getTable(tableName);
    }
}
