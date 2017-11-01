package Pages;

import PageFactory.Browser_SetUp;
import Test.AddRoom_Test;
import Test.Register_Login_Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Hashantha on 6/13/2017.
 */
public class AddRoom extends Browser_SetUp{



    //Register Page Elements
    @FindBy(id = "EmailAddress")
    WebElement RegisterEmail;
    @FindBy(id = "FirstName")
    WebElement RegisterFirstname;
    @FindBy(id = "surname")
    WebElement RegisterSurname;
    @FindBy (id = "show-pwd")
    WebElement ShowPassword;
    @FindBy(id = "Password")
    WebElement RegisterPassword;
    @FindBy(id = "registersubmit")
    WebElement RegisterButton;

    //UserPreference form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/div/section/div/div/div/div[2]/form/div[1]/label[2]")
    WebElement hostTab;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/div/section/div/div/div/div[2]/form/div[2]/button")
    WebElement proceed;

    //RoomName form
    @FindBy(id = "title")
    WebElement roomName;
    @FindBy(id = "edit-field-rental-type-und")
    WebElement propertyType;
    @FindBy(id = "edit-field-rental-category")
    WebElement roomCategory;
    @FindBy(id = "edit-submit")
    WebElement saveRoomName;


    //LocationMap form
    @FindBy(id = "country")
    WebElement country;
    @FindBy(id = "city")
    WebElement townCity;
    @FindBy(id = "county")
    WebElement county;
    @FindBy(id = "pin_code")
    WebElement postAddress;
    @FindBy(id = "home_number")
    WebElement houseNumber;
    @FindBy(id = "neighbourhood")
    WebElement street;
    @FindBy(id = "nearest_airport")
    WebElement nearestAirport;
    @FindBy(id = "distance_to_airport")
    WebElement distanceAirport;
    @FindBy(id = "distance_unit")
    WebElement distanceUnit;
    @FindBy(id = "edit-submit")
    WebElement loactionMapSave;


    //RoomDetails form
    @FindBy(id = "edit-body-und-0-value")
    WebElement roomDescription;
    @FindBy(id = "max_days")
    WebElement maxStay;
    @FindBy(id = "guests")
    WebElement maxGuest;
    @FindBy(id = "bed_type")
    WebElement bedType;
    @FindBy(id = "bathroom_description")
    WebElement bathroomDesc;
    @FindBy(id = "house_rules")
    WebElement houseRule;
    @FindBy(id = "edit-submit")
    WebElement roomDetailsSave;


    //Facility form
    @FindBy(css = "html.js.flexbox.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body.parallax.animated.fadeIn div.container-main div#perspective.perspective.effect-airbnb div.container-main-perspective div.wrapper div.main.clearfix div.off-canvas-wrap div.inner-wrap div.main-container.container.ser-m-bot-30.user-area div.row section.edit-room div.region.region-content section#block-system-main.block.block-system.clearfix form#property-node-form.node-form.node-property-form div div.field-group-tabs-wrapper div.tabbable.tabs-left.vertical-tabs.clearfix.bootstrap-tabs-processed div#tabContent.vertical-tabs-panes.vertical-tabs-processed.tab-content fieldset#edit-group_room_details.required-fields.form-wrapper.tab-pane.vertical-tabs-pane.active.fieldgroup-effects-processed div.form-item.form-item-field-amenities-und.form-type-checkboxes.form-group div#edit-field-amenities-und.form-checkboxes div.form-item.form-item-field-amenities-und-tv.form-type-checkbox.checkbox label.control-label")
    WebElement pond;
    @FindBy(id = "local_amenities")
    WebElement localAmenities;
    @FindBy(id = "edit-submit")
    WebElement facilitySave;

    //Photos form
    @FindBy(linkText = "button version")
    WebElement buttonLink;
    @FindBy(id = "img-browse-btn")
    WebElement chooseFile;
    @FindBy(id = "edit-submit")
    WebElement savePhoto;

    //ContactDetails form
    @FindBy(id = "FirstName")
    WebElement firstName;
    @FindBy(id = "Surname")
    WebElement surname;
    @FindBy(id = "Age")
    WebElement age;
    @FindBy(id = "edit-field-gender-und")
    WebElement gender;
    @FindBy(id = "edit-submit")
    WebElement saveContactDetails;


    //ProfilePictue form
    @FindBy(id = "edit-submit")
    WebElement profileSave;

    //Facebook form
    @FindBy(name = "skip")
    WebElement facebookSkip;

    //Aboutyou form
    @FindBy(id = "edit-field-occupation-und-0-value")
    WebElement occupation;
    @FindBy(id = "edit-field-field-countries-i-have-vis-und-0-value")
    WebElement countriesVisit;
    @FindBy(id = "edit-field-field-countries-i-like-vis-und-0-value")
    WebElement countriesLike;
    @FindBy(id = "edit-field-field-spoken-und-0-value")
    WebElement languages;
    @FindBy(id = "edit-field-interests-und-0-value")
    WebElement interest;
    @FindBy(id = "edit-field-hobbies-und-0-value")
    WebElement hobbies;
    @FindBy(id = "edit-submit")
    WebElement aboutSave;


    //Myroom form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/section/div[2]/div/div/div[1]/ul/li[3]/a")
    WebElement publish;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/section/div/div/div/div[1]/ul/li[4]/a")
    WebElement unpublish;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/section/div/div/div/div[1]/ul/li[5]/a")
    WebElement viewLive;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/section/div/div/div/div[1]/ul/li[1]/a")
    WebElement preview;



    public AddRoom(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Register page data passing
    public void setRegisterEmail(String strRemail){
        RegisterEmail.sendKeys(strRemail);

    }
    public void setRegisterFirstname(String strRfname){
        RegisterFirstname.sendKeys(strRfname);
    }
    public void setRegisterSurname(String strRsname){
        RegisterSurname.sendKeys(strRsname);
    }
    public void setRegisterPassword(String strRpassword){
        RegisterPassword.sendKeys(strRpassword);
    }
    public  void clickShowPassword(){
        ShowPassword.click();

    }
    public void clickRegister(){
        RegisterButton.click();
    }


    //User preference data passing
    public  void userPreference(){
        sleep();
        hostTab.click();
        sleep();
        proceed.click();
    }


    //RoomName data passing
    public void setRoomName(String randomName){
        roomName.sendKeys(randomName);
    }
    public void setPropertyType() {
        Select dropdown = new Select(propertyType);
        dropdown.selectByIndex(1);
    }
    public void setRoomCategory() {
        Select dropdown = new Select(roomCategory);
        dropdown.selectByIndex(2);
    }
    public void clickRoomSave(){
        saveRoomName.click();

    }


    //LocationMap data passing
    public void setCountry() {
        Select dropdown = new Select(country);
        dropdown.selectByValue("JM");
    }
    public void setTownCity(){
        sleep();
        townCity.sendKeys("Negril");
        sleep();
    }
    public void setCounty(String randomName){
        county.sendKeys(randomName);
    }
    public void setPostAddress(String location){
        postAddress.sendKeys(location);
        sleep();
    }
    public void streetDetails(String randomName, String randomNumber){
        houseNumber.sendKeys(randomName);
        street.sendKeys(randomNumber);
        nearestAirport.sendKeys(randomName);
        distanceAirport.sendKeys(randomNumber);
        Select dropdown = new Select(distanceUnit);
        dropdown.selectByIndex(1);
        loactionMapSave.click();

    }


    //RoomDetails data passing
    public void roomDetails(String randomName){
        roomDescription.sendKeys(randomName);
        Select maxStaydrop = new Select(maxStay);
        maxStaydrop.selectByIndex(2);
        Select maxGuestdrop = new Select(maxGuest);
        maxGuestdrop.selectByIndex(4);
        Select bedTypeDrop = new Select(bedType);
        bedTypeDrop.selectByIndex(3);
        bathroomDesc.sendKeys(randomName);
        houseRule.sendKeys(randomName);
        roomDetailsSave.click();
    }



    //Facility data passing
    public void facilityDetails(String randomName){

        pond.click();
        localAmenities.sendKeys(randomName);
        facilitySave.click();

    }

    //Photos data passing
    public  void setPhotos() {
        buttonLink.click();
        chooseFile.click();
        sleep();
    }
    public void setSavePhotos(){
        savePhoto.click();
        sleep();

    }

    //ContactDetails data passing
    public  void contactDetails(String randomName){
        firstName.sendKeys(randomName);
        surname.sendKeys(randomName);
        Select ageDrop = new Select(age);
        ageDrop.selectByIndex(3);
        Select genderDrop = new Select(gender);
        genderDrop.selectByIndex(1);
        saveContactDetails.click();

    }


    //ProfilePicture data passing
    public void profilePicDetails(){
        profileSave.click();
    }


    //Facebook data passing
    public void facebookDetails(){
        facebookSkip.click();
    }


    //AboutYou data passing
    public void aboutYouDetails(String randomString){
        occupation.sendKeys(randomString);
        countriesVisit.sendKeys (randomString);
        countriesLike.sendKeys(randomString);
        languages.sendKeys (randomString);
        interest.sendKeys (randomString);
        hobbies.sendKeys (randomString);
        aboutSave.click();
    }

    //Myroom data passing
    public void roomPublish(){
        publish.click();
    }
    public void viewLive(){
        viewLive.click();
        sleep();
    }
    public void roomUnpublish(){
        sleep();
        unpublish.click();
    }
    public void preview(){
        preview.click();
    }

}
