package domain.record;

public class Record {
    private int recordId;
    private String swimName;
    private String swimTime;
    private float swimDist;
    private int isPublic;
    private int userId;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getSwimName() {
        return swimName;
    }

    public void setSwimName(String swimName) {
        this.swimName = swimName;
    }

    public String getSwimTime() {
        return swimTime;
    }

    public void setSwimTime(String swimTime) {
        this.swimTime = swimTime;
    }

    public float getSwimDist() {
        return swimDist;
    }

    public void setSwimDist(float swimDist) {
        this.swimDist = swimDist;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
