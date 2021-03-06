package org.softserveinc.converters;

import org.softserveinc.service.BookmarkService;
import org.softserveinc.util.ReferenceType;
import org.softserveinc.util.json.AbstractJsonObject;

/**
 * This is Director class for design pattern "Builder".
 * {@link org.softserveinc.util.json.JsonFactory#getJsonBuilderDirector(Integer)} sets builder according to web client that
 * requested Json.
 */
public class JsonBuilderDirector {
    private AbstractJsonBuilder jsonBuilder;

    public AbstractJsonObject buildJson(BookmarkService bookmarkService, ReferenceType owner, String ownerId){
        jsonBuilder.setBookmarkService(bookmarkService);
        jsonBuilder.setBookmarkReferencesByOwnerId(owner, ownerId);
        jsonBuilder.setBookmarkMap();
        return jsonBuilder.buildJsonByOwnerId();
    }

    public void setJsonBuilder(AbstractJsonBuilder jsonBuilder) {
        this.jsonBuilder = jsonBuilder;
    }
}
