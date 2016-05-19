package ch.iglwars.Enemy;

import com.badlogic.gdx.Gdx;

import ch.iglwars.Constants;
import ch.iglwars.TexturesMode.PassiveAnimatedTexture;
import ch.iglwars.TexturesMode.TextureMode;

/**
 * Created by Argon on 14.05.16.
 */
public class BigEnemy extends Enemy{

    public static float WIDTH = 94;
    public static float HEIGHT = 94;

    public static String [] TEXTURES_NAME = {
            "enemy_big_0.png",
            "enemy_big_1.png",
            "enemy_big_2.png",
            "enemy_big_3.png",
            "enemy_big_4.png",
            "enemy_big_5.png",
            "enemy_big_6.png"};

    private float direction;

    /**
     * Construction de l'objet de base
     *
     * @param x Position initiale de l'enemi sur l'axe des X
     */
    public BigEnemy(float x, float y) {
        super(x, y);
    }

    /**
     * Définition des propriétés pour l'enemy
     */
    protected void setProperties(){
        direction = 1;
        setHeight(HEIGHT);
    }

    @Override
    protected TextureMode createTextureMode() {
        return new PassiveAnimatedTexture(5,TEXTURES_NAME);
    }

    /**
     * Gestion du déplacement de l'enemy
     */
    protected void setPositionInLoop(){
        this.setY(this.getY() - (200 * Gdx.graphics.getDeltaTime()));


        // Deplacement lateral avec descente à chaque bord
        if(this.getX() > (Constants.GAME_WIDTH - WIDTH)){
            direction = -1;
//            this.setY(this.getY() - HEIGHT * 2);
        } else if (this.getX() < 0) {
            direction = 1;
//            this.setY(this.getY() + HEIGHT * 2);
        }
        this.setX(this.getX() + (direction * 200 * Gdx.graphics.getDeltaTime()));

        //Rotation sur lui-même
        this.incRotation(2);
    }
}
