package com.nordbank.ngwebap.web.dao;

@Repository
public class HttpDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getAPResponse(String path, String reqString, UsernamePasswordAuthenticationToken userAuth) {
        String result = "";

        int timeOut = 90000;
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

        connManager.setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(timeOut).build());

        try (CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build()) {

            String url = validatorUrl(path);

            HttpPost post = new HttpPost(url);

            // if(ESAPI.validator().isValidInput(this.getClass().getName(), reqString, "Space", Integer.MAX_VALUE,false)){
            StringEntity entity = new StringEntity(this.handleDataBeforeSend(reqString), "UTF-8");
            post.setEntity(entity);
            post.setHeader("Accept", "application/json");
            post.setHeader("Content-type", "application/json");
            post.setHeader("NORDHEADER", makeNORDHEADER(userAuth)); // Passing web side JWT KEY to ap side

            HttpResponse response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                result = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
                result = this.handleDataAfterSend(result);
            } else if (statusCode == 404) {
                result = "404";
            } else {
                logger.info("Response HTTP Code:" + statusCode);
                result = "";
            }
            // }else{
            // logger.warn("Invalid Input");
            // }
        } catch (Exception ex) {
            logger.warn("getAPResponse", ex);
        }

        return result;
    }

    public String handleDataBeforeSend(String data) {
        return data;
    }

    public String handleDataAfterSend(String data) {
        return data;
    }

    public String getAPResponseNoAuth(String controller, String action, String reqString) {
        String result = "";
        int timeOut = 90000;
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

        connManager.setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(timeOut).build());

        try (CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build()) {

            String url = validatorUrl(path);

            HttpPost post = new HttpPost(url);

            // if(ESAPI.validator().isValidInput(this.getClass().getName(), reqString, "Space", Integer.MAX_VALUE,false)){
            StringEntity entity = new StringEntity(this.handleDataBeforeSend(reqString), "UTF-8");
            post.setEntity(entity);
            post.setHeader("Accept", "application/json");
            post.setHeader("Content-type", "application/json");

            HttpResponse response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                result = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
                result = this.handleDataAfterSend(result);
            } else if (statusCode == 404) {
                result = "404";
            } else {
                logger.info("Response HTTP Code:" + statusCode);
                result = "";
            }
            // }else{
            // logger.warn("Invalid Input");
            // }
        } catch (Exception ex) {
            logger.warn("getAPResponse", ex);
        }

        return result;
    }

    public String getAPResponseNoAuthByGetMethod(String controller, String action) {
        String result = "";
        int timeOut = 90000;
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

        connManager.setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(timeOut).build());

        try (CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build()) {

            String url = validatorUrl(path);
            HttpGet get = new HttpGet(url);

            get.setHeader("Accept", "application/json");
            get.setHeader("Content-type", "application/json");

            HttpResponse response = client.execute(get);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                result = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
                result = this.handleDataAfterSend(result);
            } else if (statusCode == 404) {
                result = "404";
            } else {
                logger.info("Response HTTP Code:" + statusCode);
                result = "";
            }
        } catch (Exception ex) {
            logger.warn("getAPResponse", ex);
            ;
        }

        return result;
    }

    public String getAPResponseByGetMethod(String controller, String action,
            UsernamePasswordAuthenticationToken userAuth) {
        String result = "";
        int timeOut = 90000;
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

        connManager.setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(timeOut).build());
        try (CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build()) {

            String url = validatorUrl(path);
            HttpGet get = new HttpGet(url);

            get.setHeader("Accept", "application/json");
            get.setHeader("Content-type", "application/json");
            get.setHeader("NORDHEADER", makeNORDHEADER(userAuth)); // Passing web side JWT KEY to ap side

            HttpResponse response = client.execute(get);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                result = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
                result = this.handleDataAfterSend(result);
            } else if (statusCode == 404) {
                result = "404";
            } else {
                logger.info("Response HTTP Code:" + statusCode);
                result = "";
            }
        } catch (Exception ex) {
            logger.warn("getAPResponse", ex);
            ;
        }

        return result;
    }

    private String validatorUrl(String path) {
        // String url = "";
        // TODO: if(ESAPI.validator().isValidInput(this.getClass().getName(), controller, "Space", Integer.MAX_VALUE,false))
        return path;
    }

    private String makeNORDHEADER(UsernamePasswordAuthenticationToken userAuth) {
        userAuth = validatorUserAuth(userAuth);
        String header = userAuth.getName();
        logger.info("### From web to ap: post.setHeader = " + header);
        return header;
    }

    private UsernamePasswordAuthenticationToken validatorUserAuth(UsernamePasswordAuthenticationToken userAuth){
        Gson gson = new Gson();        
        // if (ESAPI.validator().isValidInput(this.getClass().getName(), gson.toJson(userAuth), "Space", Integer.MAX_VALUE,false)){
            return userAuth;
        // } else {
        //     return null;
        // }
    }
}
