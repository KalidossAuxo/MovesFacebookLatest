package com.moves.movesCelebrity.social.restFB;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moves.movesCelebrity.configuration.MovesConfiguration;
import com.moves.movesCelebrity.dao.SocialMediaPostDao;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.serdeser.ObjectIDGsonDeserializer;
import com.moves.movesCelebrity.utils.serdeser.ObjectIDGsonSerializer;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.concurrent.CompletableFuture;

public class FBWriteUserDetailsByRestFB implements Command<Void,Document> {

    private ObjectMapper mapper = new ObjectMapper();
    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(ObjectId.class, new ObjectIDGsonDeserializer())
            .registerTypeAdapter(ObjectId.class, new ObjectIDGsonSerializer())
            .setPrettyPrinting().create();

    public FBWriteUserDetailsByRestFB() {
    }

    @Override
    public CompletableFuture<Void> execute(Document document) {
        return CompletableFuture.supplyAsync(() -> {
            //Document trends = null;
            insert(document);
            return null;
        });
    }

    public void insert(Document document) {
        //SocialMediaPostDao.insert(document, MovesConfiguration.COLLECTION_POSTS_TWITTER);
        SocialMediaPostDao.insert(document, MovesConfiguration.COLLECTION_FB_USER_DETAILS);
    }
}
