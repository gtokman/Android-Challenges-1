package com.garytokman.tokmangary_assignment2.model;

/**
 * Created by gtokman1 on 8/24/16.
 */
public class Photo {

    // Fields
    private int mLikes;
    private String mName;
    private String mImageUrlSmall;

    public Photo(int title, String name, String imageUrlSmall) {
        mLikes = title;
        mName = name;
        mImageUrlSmall = imageUrlSmall;
    }

    public int getLikes() {
        return mLikes;
    }

    public String getName() {
        return mName;
    }

    public String getImageUrlSmall() {
        return mImageUrlSmall;
    }

    @Override
    public String toString() {
        return "Taken by: " + mName + "\n Number of likes: " + mLikes;
    }
}
