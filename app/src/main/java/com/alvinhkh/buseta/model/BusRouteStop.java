package com.alvinhkh.buseta.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BusRouteStop implements Parcelable {

    public String code;

    public String companyCode;

    public String destination;

    public String direction;

    public String etaGet;

    public String fare;

    public String fareHoliday;

    public String fareChild;

    public String fareSenior;

    public String imageUrl;

    public String latitude;

    public String location;

    public String longitude;

    public String name;

    public String origin;

    public String sequence;

    public String route;

    public String routeId;

    public BusRouteStop() {
    }

    public boolean equals(BusRouteStop object) {
        return this.toString().equals(object.toString());
    }

    public String toString() {
        return "BusRouteStop{code=" + this.code + ", companyCode=" + this.companyCode
                + ", destination=" + this.destination + ", direction=" + this.direction
                + ", etaGet=" + this.etaGet + ", fare=" + this.fare + ", fareHoliday=" + this.fareHoliday
                + ", fareChild=" + this.fareChild + ", fares=" + this.fareSenior
                + ", imageUrl=" + this.imageUrl + ", latitude=" + this.latitude
                + ", location=" + this.location + ", longitude=" + this.longitude
                + ", name=" + this.name + ", origin=" + this.origin + ", sequence=" + this.sequence
                + ", route=" + this.route + ", routeId=" + this.routeId + "}";
    }

    /**
     * Constructs a BusRouteStop from a Parcel
     * @param p Source Parcel
     */
    public BusRouteStop(Parcel p) {
        this.code = p.readString();
        this.companyCode = p.readString();
        this.destination = p.readString();
        this.direction = p.readString();
        this.etaGet = p.readString();
        this.fare = p.readString();
        this.fareHoliday = p.readString();
        this.fareChild = p.readString();
        this.fareSenior = p.readString();
        this.imageUrl = p.readString();
        this.latitude = p.readString();
        this.location = p.readString();
        this.longitude = p.readString();
        this.name = p.readString();
        this.origin = p.readString();
        this.sequence = p.readString();
        this.route = p.readString();
        this.routeId = p.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //The parcelable object has to be the first one
        dest.writeString(this.code);
        dest.writeString(this.companyCode);
        dest.writeString(this.destination);
        dest.writeString(this.direction);
        dest.writeString(this.etaGet);
        dest.writeString(this.fare);
        dest.writeString(this.fareHoliday);
        dest.writeString(this.fareChild);
        dest.writeString(this.fareSenior);
        dest.writeString(this.imageUrl);
        dest.writeString(this.latitude);
        dest.writeString(this.location);
        dest.writeString(this.longitude);
        dest.writeString(this.name);
        dest.writeString(this.origin);
        dest.writeString(this.sequence);
        dest.writeString(this.route);
        dest.writeString(this.routeId);
    }

    /*
     * Method to recreate class object from a Parcel
     */
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public BusRouteStop createFromParcel(Parcel in) {
            return new BusRouteStop(in);
        }

        public BusRouteStop[] newArray(int size) {
            return new BusRouteStop[size];
        }
    };
}