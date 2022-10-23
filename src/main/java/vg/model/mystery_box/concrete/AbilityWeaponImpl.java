package vg.model.mystery_box.concrete;

import vg.model.Stage;
import vg.model.mystery_box.AbilityInTheBox;
import vg.model.mystery_box.AbstractAbilityDurable;
import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.ability.AbilityWeapon;
import vg.utils.V2D;
import vg.utils.path.PathImageMysteryBox;

public class AbilityWeaponImpl extends AbstractAbilityDurable implements AbilityInTheBox {

    private final boolean canHitBoss;

    public AbilityWeaponImpl(final EAbility idAbility, final double duration, final boolean canHitBoss) {
        super(idAbility, duration);
        this.canHitBoss = canHitBoss;

        if(canHitBoss) {
            this.pathImage = PathImageMysteryBox.MYSTERY_BOSS;
        }
    }


    @Override
    public void activate(Stage<V2D> stage) {

    }
}