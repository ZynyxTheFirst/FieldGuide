package net.wonky.fieldguide.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.BookViewScreen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.wonky.fieldguide.client.gui.data.*;

import java.util.*;

import static net.wonky.fieldguide.FieldGuide.MODID;

public class FieldGuideScreen extends Screen {
    private static final ResourceLocation BOOK_BASE_TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/gui/guidebook/bookbase.png");
    private static final ResourceLocation BOOK_BUTTONS_TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/gui/guidebook/bookbuttons.png");
    private final List<LineData> lines = new ArrayList<>();
    private final List<CategoryData> categories = new ArrayList<>();
    private final Map<String, ResourceLocation> textureMap = new HashMap<>();

    protected int xSize = 390;
    protected int ySize = 320;
    protected int currentPageCounter = 0;
    protected int maxPagesFromPrinting = 0;
    protected int linesFromJSON = 0;
    protected int linesFromPrinting = 0;
    private ResourceLocation prevPageJSON;
    private ResourceLocation currentPageJSON;
    private ResourceLocation rootPageJSON = ResourceLocation.fromNamespaceAndPath(MODID, "bookcontent/root.json");
    protected ResourceLocation currentPageText = null;
    private PageButton forwardButton;
    private PageButton backButton;
    protected FieldGuidePage internalPage = null;
    protected String writtenTitle = "";
    protected int preservedPageIndex = 0;
    protected String entityTooltip;
    private int mouseX;
    private int mouseY;




    protected FieldGuideScreen(Component title) {
        super(title);
        this.currentPageJSON = this.rootPageJSON;
    }

    protected void init() {
        super.init();
        playOpeningSound();
    }


    protected void playOpeningSound() {
        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.BOOK_PAGE_TURN, 1.0F));
    }

    protected void closeScreen() {
        this.minecraft.setScreen((Screen)null);
    }

}
