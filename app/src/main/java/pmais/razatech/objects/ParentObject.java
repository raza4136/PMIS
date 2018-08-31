package pmais.razatech.objects;

public class ParentObject {
    private int mId;
    private String mTitle;

    public ParentObject(int Id, String Title) {
        this.mId = Id;
        this.mTitle = Title;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
