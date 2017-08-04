package com.kesteli.filip.sciencebrowser1.bazapodataka;

/**
 * Created by Filip on 9.9.2016..
 */
public class Stranica {

    //private variables
    int _id;
    String _site;
    int _history;
    int _favorite;
    int _eureka;

    public Stranica() {
    }

    public Stranica(int _id, String _site, int _history, int _favorite, int _eureka) {
        this._id = _id;
        this._site = _site;
        this._history = _history;
        this._favorite = _favorite;
        this._eureka = _eureka;
    }

    public Stranica(String _site, int _history, int _favorite, int _eureka) {
        this._site = _site;
        this._history = _history;
        this._favorite = _favorite;
        this._eureka = _eureka;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_site() {
        return _site;
    }

    public void set_site(String _site) {
        this._site = _site;
    }

    public int get_history() {
        return _history;
    }

    public void set_history(int _history) {
        this._history = _history;
    }

    public int get_favorite() {
        return _favorite;
    }

    public void set_favorite(int _favorite) {
        this._favorite = _favorite;
    }

    public int get_eureka() {
        return _eureka;
    }

    public void set_eureka(int _eureka) {
        this._eureka = _eureka;
    }
}
