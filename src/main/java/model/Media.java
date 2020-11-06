package model;

public class Media {
    private int mediaId;
    private String link;
    private String mediaName;
    private  int cookStepId;

    public Media() {
    }

    public Media(int mediaId, String link, String mediaName, int cookStepId) {
        this.mediaId = mediaId;
        this.link = link;
        this.mediaName = mediaName;
        this.cookStepId = cookStepId;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public int getCookStepId() {
        return cookStepId;
    }

    public void setCookStepId(int cookStepId) {
        this.cookStepId = cookStepId;
    }
}
