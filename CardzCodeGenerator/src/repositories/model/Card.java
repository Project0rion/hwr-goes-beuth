package repositories.model;

/**
 * Created by User on 22.01.2017.
 */
public class Card {

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_faction() {
        return _faction;
    }

    public void set_faction(String _faction) {
        this._faction = _faction;
    }

    public int get_cost() {
        return _cost;
    }

    public void set_cost(int _cost) {
        this._cost = _cost;
    }

    public int get_health() {
        return _health;
    }

    public void set_health(int _health) {
        this._health = _health;
    }

    public int get_damage() {
        return _damage;
    }

    public void set_damage(int _damage) {
        this._damage = _damage;
    }

    private String _name;
    private String _faction;
    private int _cost;
    private int _health;
    private int _damage;

    public Card(){

    }
}
