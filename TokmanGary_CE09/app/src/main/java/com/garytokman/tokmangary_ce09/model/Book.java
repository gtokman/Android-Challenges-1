package com.garytokman.tokmangary_ce09.model;

/**
 * Created by gtokman1 on 8/18/16.
 */
public class Book {

    private String mImage;
    private String mTitle;

    public Book(String image, String title) {
        mImage = image;
        mTitle = title;
    }

    public String getImage() {
        return mImage;
    }

    public String getTitle() {
        return mTitle;
    }

    @Override
    public String toString() {
        return "Book{" +
                "mImage='" + mImage + '\'' +
                ", mTitle='" + mTitle + '\'' +
                '}';
    }
}
