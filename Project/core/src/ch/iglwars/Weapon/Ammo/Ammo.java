package ch.iglwars.Weapon.Ammo;

import com.badlogic.gdx.Gdx;

import ch.iglwars.Utils.Constants;
import ch.iglwars.Utils.GraphicElement;
import ch.iglwars.TexturesMode.PassiveAnimatedTexture;
import ch.iglwars.TexturesMode.ITextureMode;

/**
 * Classe  de base représentant une munition pour une arme
 */
public abstract class Ammo extends GraphicElement {

    //Textures de la munition
    private String[] textures;
    //Direction du tir (Vers le haut ou vers le bas)
    private int direction;
    //Représente le nombre de dégât que va faire l'arme
    private int damage;
    //Vitesse du tir
    private int speed;
    // Destruction du tir
    private boolean isDestroy = false;

    /**
     * Crée l'objet qui permet de gérer le mode de texture
     *
     * @return Objet descendant de TextureMode
     */
    @Override
    protected ITextureMode createTextureMode() {
        if (getTextures() != null) {
            return new PassiveAnimatedTexture(200, getTextures());
        } else {
            return null;
        }
    }

    /**
     * Permet au enfant de définir leur position dans la loop graphique avant de dessiner l'élément.
     * Définit le trajectoire du tir
     */
    @Override
    protected void setPositionInLoop() {
        this.setY(this.getY() + direction * (getSpeed() * Gdx.graphics.getDeltaTime()));
    }

    /**
     * Méthode qui permet de définir les propriétés des enfants
     * A définir dans les classes enfant de Ammo
     */
    @Override
    protected void setProperties() {

    }

    /**
     * Détermine si le tir a été détruit ou non
     *
     * @return Vrai si détruit, sinon faux
     */
    public boolean isDestroyed() {
        if(getY() > (Constants.GAME_HEIGHT - getHeight()) || getY() < 0 - getHeight()) {
            isDestroy = true;
        }
        return isDestroy;
    }

    public void destroy() {
        isDestroy = true;
    }


    public String[] getTextures() {
        return textures;
    }

    public void setTextures(String[] textures) {

        this.textures = textures;
        //A chaque fois qu'on redéfinit la texture, on recrée le mode de texture
        setTextureMode(createTextureMode());
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDamage() {
        return damage;
    }

    protected void setDamage(int damage) {
        this.damage = damage;
    }

    protected int getSpeed() {
        return speed;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
    }
}
