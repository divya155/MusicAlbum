package com.app.dsr.simpplrassignment.network.model;

import android.os.Parcel;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#user-object-private">User object (private) model</a>
 */
public class UserPrivate extends UserPublic {

    private String email;
    private String country;
    private String birthdate;
    private String product;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.birthdate);
        dest.writeString(this.country);
        dest.writeString(this.email);
        dest.writeString(this.product);
    }

    public UserPrivate() {
    }

    protected UserPrivate(Parcel in) {
        super(in);
        this.id = in.readString();
        this.display_name = in.readString();
        this.images = in.readParcelable(ClassLoader.getSystemClassLoader());
        this.birthdate = in.readString();
        this.country = in.readString();
        this.email = in.readString();
        this.product = in.readString();
    }

    public static final Creator<UserPrivate> CREATOR = new Creator<UserPrivate>() {
        public UserPrivate createFromParcel(Parcel source) {
            return new UserPrivate(source);
        }

        public UserPrivate[] newArray(int size) {
            return new UserPrivate[size];
        }
    };

    @Override
    public String toString() {
        return "UserPrivate{" +
                "birthdate='" + birthdate + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", product='" + product + '\'' +
                super.toString() + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getProduct() {
        return product;
    }
}
