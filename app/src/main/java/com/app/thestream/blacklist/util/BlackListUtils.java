package com.app.thestream.blacklist.util;

import java.util.ArrayList;
import java.util.List;

public class BlackListUtils {
    private static BlackListUtils appContents;

    public static BlackListUtils getInstance() {
        if (appContents == null)
            appContents = new BlackListUtils();
        return appContents;
    }

    private BlackListUtils() {
    }

    private List<String> blackList = new ArrayList<>();

    public void populateBlackList() {


        //add more here
        this.blackList.add("app.greyshirts.sslcapture");
        this.blackList.add("com.guoshi.httpcanary");
        this.blackList.add("com.minhui.networkcapture");
        this.blackList.add("com.Sniffer.frtparlak");
        this.blackList.add("com.evbadroid.proxymon");
        this.blackList.add("com.minhui.wifianalyzer");
        this.blackList.add("appsniffer.online");
        this.blackList.add("com.aconno.blesniffer");
        this.blackList.add("xyz.easypro.httpcustom");
        this.blackList.add("com.evozi.injector");
        this.blackList.add("com.evozi.injector.lite");
        this.blackList.add("ch.rmy.android.http_shortcuts");
        this.blackList.add("com.guoshi.httpcanary.premium");
        this.blackList.add("com.myprog.netutils");
        this.blackList.add("com.packagesniffer.frtparlak");
        this.blackList.add("jp.co.taosoftware.android.packetcapture");
        this.blackList.add("com.cstanley.urlreader");
        this.blackList.add("com.evbadroid.wicapdemo");
        this.blackList.add("com.dans.apps.webd");
        this.blackList.add("ru.yFarPSsi.ISWLCBgGE");
        this.blackList.add("com.gmail.heagoo.apkeditor.pro");
        this.blackList.add("com.applisto.appcloner");
        this.blackList.add("cc.madkite.freedom");
        this.blackList.add("com.charles.bewlouhaqw");

    }

    public List<String> getBlackList() {
        if (blackList.isEmpty()) {
            populateBlackList();
        }
        return blackList;
    }

    //to add more dynamically
    public void appendMoreIntoBlackListDynamically(List<String> packagesList) {
        blackList.addAll(packagesList);
    }

    public void clearList() {
        blackList.clear();
    }

}
