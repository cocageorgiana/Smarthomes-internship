package com.example.smarthomes.soapservice.endpoint;

import com.example.smarthomes.soapservice.article.GetArticleRequest;
import com.example.smarthomes.soapservice.article.GetArticleResponse;
import com.example.smarthomes.soapservice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ArticleEndpoint {

    private static final String NAMESPACE_URI  = "http://spring.io/guides/gs-producing-web-service";

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleEndpoint(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     * Configures the behaviour if the request defined in the XML File
     * @param request The request that needs to be made
     * @return The expected response of the request
     */

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getArticleRequest")
    @ResponsePayload
    public GetArticleResponse getArticle(@RequestPayload GetArticleRequest request) {

        GetArticleResponse response = new GetArticleResponse();
        response.setArticle(articleRepository.findArticle(request.getName()));

        return response;
    }
}
