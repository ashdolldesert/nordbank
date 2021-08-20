package com.nordbank.ngwebap.web.dao;

import java.nio.charset.Charset;

import com.google.gson.Gson;
import com.nordbank.ngwebap.web.config.GlobalConfig;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Repository;

@Repository
public class HttpDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GlobalConfig globalConfig;

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

    public String getAPResponseNoAuth(String path, String reqString) {
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

    public String getAPResponseNoAuthByGetMethod(String path) {
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

    public String getAPResponseByGetMethod(String path,
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
        String url = globalConfig.APServerHost.concat(path);
        logger.info("ap url=" + url);
        return url;
    }

    private String makeNORDHEADER(UsernamePasswordAuthenticationToken userAuth) {
        userAuth = validatorUserAuth(userAuth);
        // FIXME:
        //String header = userAuth.getName();
        //logger.info("### From web to ap: post.setHeader = " + header);
        //return header;
        return "";
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
