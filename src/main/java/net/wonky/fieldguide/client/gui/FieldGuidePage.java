package net.wonky.fieldguide.client.gui;

import com.google.gson.*;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.util.GsonHelper;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.wonky.fieldguide.client.gui.data.CategoryData;

import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FieldGuidePage {
    public static final Gson GSON = (new GsonBuilder()).registerTypeAdapter(FieldGuidePage.class, new Deserializer()).create();
    public String translatableTitle = null;
    private String parent = "";
    private String textFileToReadFrom = "";
    private List<CategoryData> categoryButtons = new ArrayList<>();
    private final String title;

    public FieldGuidePage(String parent, String textFileToReadFrom, List<CategoryData> categoryButtons, String title) {
        this.parent = parent;
        this.textFileToReadFrom = textFileToReadFrom;
        this.categoryButtons = categoryButtons;
        this.title = title;
    }

    public static FieldGuidePage deserialize(Reader readerIn) {
        return GsonHelper.fromJson(GSON, readerIn, FieldGuidePage.class);
    }

    public static FieldGuidePage deserialize(String jsonString) {
        return deserialize(new StringReader(jsonString));
    }

    public String generateTitle() {
        if (translatableTitle != null) {
            return I18n.get(translatableTitle);
        }
        return title;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Deserializer implements JsonDeserializer<FieldGuidePage> {

        public FieldGuidePage deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) throws JsonParseException {
            JsonObject jsonobject = GsonHelper.convertToJsonObject(p_deserialize_1_, "book page");
            CategoryData[] categoryPageRead = GsonHelper.getAsObject(jsonobject, "linked_page_buttons", new CategoryData[0], p_deserialize_3_, CategoryData[].class);

            String readParent = "";
            if (jsonobject.has("parent")) {
                readParent = GsonHelper.getAsString(jsonobject, "parent");
            }

            String readTextFile = "";
            if (jsonobject.has("text")) {
                readTextFile = GsonHelper.getAsString(jsonobject, "text");
            }

            String title = "";
            if (jsonobject.has("title")) {
                title = GsonHelper.getAsString(jsonobject, "title");
            }


            FieldGuidePage page = new FieldGuidePage(readParent, readTextFile, Arrays.asList(categoryPageRead), title);
            if (jsonobject.has("title")) {
                page.translatableTitle = GsonHelper.getAsString(jsonobject, "title");
            }
            return page;
        }
    }
}
