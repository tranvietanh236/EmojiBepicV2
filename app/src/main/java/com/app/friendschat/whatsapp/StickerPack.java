/*
 * Copyright (c) WhatsApp Inc. and its affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.app.friendschat.whatsapp;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StickerPack implements Parcelable {
    Uri trayImageUri;
    String identifier;
    String name;
    String publisher;
    String trayImageFile;
    final String publisherEmail;
    final String publisherWebsite;
    final String privacyPolicyWebsite;
    final String licenseAgreementWebsite;

    String iosAppStoreLink;
    private List<com.app.friendschat.whatsapp.Sticker> stickers;
    private long totalSize;
    String androidPlayStoreLink;
    private boolean isWhitelisted;
    private int stickersAddedIndex = 0;

    /*public StickerPack(String identifier, String name, String publisher, String trayImageFile, String publisherEmail, String publisherWebsite, String privacyPolicyWebsite, String licenseAgreementWebsite) {
        this.identifier = identifier;
        this.name = name;
        this.publisher = publisher;
        this.trayImageFile = trayImageFile;
        this.trayImageUri = Uri.parse("");
        this.publisherEmail = publisherEmail;
        this.publisherWebsite = publisherWebsite;
        this.privacyPolicyWebsite = privacyPolicyWebsite;
        this.licenseAgreementWebsite = licenseAgreementWebsite;
        this.stickers = new ArrayList<>();
    }*/

    public StickerPack(String identifier, String name, List<Uri> stickerUris, Context context) {
        this.identifier = identifier;
        this.name = name;
        this.publisher = "vtd_global";
        this.trayImageFile = "trayimage";
        this.trayImageUri = ImageManipulation.convertIconTrayToWebP(stickerUris.get(0), this.identifier, "trayImage", context);
        this.publisherEmail = "";
        this.publisherWebsite = "";
        this.privacyPolicyWebsite = "";
        this.licenseAgreementWebsite = "";
        this.stickers = new ArrayList<>();

        stickerUris.forEach(uri -> addSticker(uri, context));
    }

    public StickerPack(String identifier, String name, String publisher, Uri trayImageUri, String publisherEmail, String publisherWebsite, String privacyPolicyWebsite, String licenseAgreementWebsite, Context context) {
        this.identifier = identifier;
        this.name = name;
        this.publisher = publisher;
        this.trayImageFile = "trayimage";
        this.trayImageUri = ImageManipulation.convertIconTrayToWebP(trayImageUri, this.identifier, "trayImage", context);
        this.publisherEmail = publisherEmail;
        this.publisherWebsite = publisherWebsite;
        this.privacyPolicyWebsite = privacyPolicyWebsite;
        this.licenseAgreementWebsite = licenseAgreementWebsite;
        this.stickers = new ArrayList<>();
    }

    void setIsWhitelisted(boolean isWhitelisted) {
        this.isWhitelisted = isWhitelisted;
    }

    boolean getIsWhitelisted() {
        return isWhitelisted;
    }

    protected StickerPack(Parcel in) {
        identifier = in.readString();
        name = in.readString();
        publisher = in.readString();
        trayImageFile = in.readString();
        publisherEmail = in.readString();
        publisherWebsite = in.readString();
        privacyPolicyWebsite = in.readString();
        licenseAgreementWebsite = in.readString();
        iosAppStoreLink = in.readString();
        stickers = in.createTypedArrayList(com.app.friendschat.whatsapp.Sticker.CREATOR);
        totalSize = in.readLong();
        androidPlayStoreLink = in.readString();
        isWhitelisted = in.readByte() != 0;
    }

    public static final Creator<StickerPack> CREATOR = new Creator<StickerPack>() {
        @Override
        public StickerPack createFromParcel(Parcel in) {
            return new StickerPack(in);
        }

        @Override
        public StickerPack[] newArray(int size) {
            return new StickerPack[size];
        }
    };

    public void addSticker(Uri uri, Context context){
        String index = String.valueOf(stickersAddedIndex);
        this.stickers.add(new com.app.friendschat.whatsapp.Sticker(
                index,
                ImageManipulation.convertImageToWebP(uri, this.identifier, index, context),
                new ArrayList<String>()));
        stickersAddedIndex++;
    }

    public void addStickers(List<Uri> uris, Context context) {
        for (Uri uri : uris) {
            addSticker(uri, context);
        }
    }

    public void deleteSticker(com.app.friendschat.whatsapp.Sticker sticker){
        new File(sticker.getUri().getPath()).delete();
        this.stickers.remove(sticker);
    }

    public com.app.friendschat.whatsapp.Sticker getSticker(int index){
        return this.stickers.get(index);
    }

    public com.app.friendschat.whatsapp.Sticker getStickerById(int index){
        for(com.app.friendschat.whatsapp.Sticker s : this.stickers){
            if(s.getImageFileName().equals(String.valueOf(index))){
                return s;
            }
        }
        return null;
    }

    public void setAndroidPlayStoreLink(String androidPlayStoreLink) {
        this.androidPlayStoreLink = androidPlayStoreLink;
    }

    public void setIosAppStoreLink(String iosAppStoreLink) {
        this.iosAppStoreLink = iosAppStoreLink;
    }

    public List<Sticker> getStickers() {
        return stickers;
    }

    public long getTotalSize() {
        return totalSize;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(identifier);
        dest.writeString(name);
        dest.writeString(publisher);
        dest.writeString(trayImageFile);
        dest.writeString(publisherEmail);
        dest.writeString(publisherWebsite);
        dest.writeString(privacyPolicyWebsite);
        dest.writeString(licenseAgreementWebsite);
        dest.writeString(iosAppStoreLink);
        dest.writeTypedList(stickers);
        dest.writeLong(totalSize);
        dest.writeString(androidPlayStoreLink);
        dest.writeByte((byte) (isWhitelisted ? 1 : 0));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Uri getTrayImageUri() {
        return trayImageUri;
    }
}
