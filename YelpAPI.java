import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/**
 * Code sample for accessing the Yelp API V2.
 *
 * This program demonstrates the capability of the Yelp API version 2.0 by using the Search API to
 * query for businesses by a search term and location, and the Business API to query additional
 * information about the top result from the search query.
 *
 * <p>
 * See <a href="http://www.yelp.com/developers/documentation">Yelp Documentation</a> for more info.
 */
public class YelpAPI {

  private static final String API_HOST = "api.yelp.com";
  private static final int SEARCH_LIMIT = 1;
  private static final String SEARCH_PATH = "/v2/search/";

  /*
   * Update OAuth credentials below from the Yelp Developers API site:
   * http://www.yelp.com/developers/getting_started/api_access
   */
  private static final String CONSUMER_KEY = "Car7OPWgwgdY43d8l3zH9Q";
  private static final String CONSUMER_SECRET = "YP1hxK0CcE9Xr5y2NrtReR7nJF4";
  private static final String TOKEN = "Y4ymSq_tIsxg7r4I3tSQanPDnNdSCez3";
  private static final String TOKEN_SECRET = "4zkAXT94ulhcMwyQyuvlOl0vda8";

  OAuthService service;
  Token accessToken;

  /**
   * Setup the Yelp API OAuth credentials.
   *
   * @param consumerKey Consumer key
   * @param consumerSecret Consumer secret
   * @param token Token
   * @param tokenSecret Token secret
   */
  public YelpAPI() {
    this.service =
        new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(CONSUMER_KEY)
            .apiSecret(CONSUMER_SECRET).build();
    this.accessToken = new Token(TOKEN, TOKEN_SECRET);
  }

  /**
   * Creates and sends a request to the Search API by term and location.
   * <p>
   * See <a href="http://www.yelp.com/developers/documentation/v2/search_api">Yelp Search API V2</a>
   * for more info.
   *
   * @param term <tt>String</tt> of the search term to be queried
   * @param location <tt>String</tt> of the location
   * @return <tt>String</tt> JSON Response
   */
  public String searchForBusinessesByLocation(String term, String location) {
    OAuthRequest request = createOAuthRequest(SEARCH_PATH);
    request.addQuerystringParameter("term", term);
    request.addQuerystringParameter("location", location);
    request.addQuerystringParameter("limit", String.valueOf(SEARCH_LIMIT));
    return sendRequestAndGetResponse(request);
  }

  /**
   * Creates and returns an {@link OAuthRequest} based on the API endpoint specified.
   *
   * @param path API endpoint to be queried
   * @return <tt>OAuthRequest</tt>
   */
  private OAuthRequest createOAuthRequest(String path) {
    OAuthRequest request = new OAuthRequest(Verb.GET, "https://" + API_HOST + path);
    return request;
  }

  /**
   * Sends an {@link OAuthRequest} and returns the {@link Response} body.
   *
   * @param request {@link OAuthRequest} corresponding to the API request
   * @return <tt>String</tt> body of API response
   */
  private String sendRequestAndGetResponse(OAuthRequest request) {
    System.out.println("Querying " + request.getCompleteUrl() + " ...");
    this.service.signRequest(this.accessToken, request);
    Response response = request.send();
    return response.getBody();
  }

  /**
   * Queries the Search API based on the command line arguments and takes the first result to query
   * the Business API.
   *
   * @param yelpApi <tt>YelpAPI</tt> service instance
   * @param yelpApiCli <tt>YelpAPICLI</tt> command line arguments
   */
  public static String[] queryAPI(YelpAPI yelpApi, YelpAPICLI yelpApiCli) {
    String searchResponseJSON = yelpApi.searchForBusinessesByLocation(yelpApiCli.term, yelpApiCli.location);

    JSONParser parser = new JSONParser();
    JSONObject response = null;
    try {
      response = (JSONObject) parser.parse(searchResponseJSON);
    } catch (ParseException pe) {
      System.out.println("Error: could not parse JSON response:");
      System.out.println(searchResponseJSON);
      System.exit(1);
    }

    JSONArray businesses = (JSONArray) response.get("businesses");
    JSONObject firstBusiness = (JSONObject) businesses.get(0);
    System.out.println(firstBusiness.toString());
    String firstBusinessName = firstBusiness.get("name").toString();
    String firstBusinessPhoneNumber = firstBusiness.get("display_phone").toString();
    System.out.println(String.format(
        "%s businesses found, business info for the top result \"%s\": Phone: %s",
        businesses.size(), firstBusinessName, firstBusinessPhoneNumber));
	return new String[] { firstBusinessName, firstBusinessPhoneNumber };
  }
}
